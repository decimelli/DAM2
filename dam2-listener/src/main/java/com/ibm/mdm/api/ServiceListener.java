package com.ibm.mdm.api;

import com.ibm.mdm.model.Service;
import com.ibm.mdm.model.ServiceConstraintViolation;
import com.ibm.mdm.model.ServiceStatus;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Listens for new services and updates mongodb. Also deletes services. API calls to this class should come from
 * other services, rather than user input.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceListener {

    @Inject
    public Validator validator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postNewService(Service newService) {
        // Try to add this service to the database then validate service inputs
        Set<ServiceConstraintViolation> validations = validator.validate(newService)
                .stream()
                .map(ServiceConstraintViolation::new)
                .collect(Collectors.toSet());

        // If there are no validation errors, add the service to the database
        if (validations.isEmpty()) {
            newService.setPostDate(LocalDateTime.now());
            newService.setStatus(ServiceStatus.UP);
            newService.persistOrUpdate();
            return Response.ok(newService).build();
        } else {
            return Response.ok(validations).build();
        }
    }

    @DELETE
    @Path("/{name}")
    public Response deleteService(@PathParam("name") String name) {
        Service toDelete = Service.findByName(name);
        if (toDelete == null) {
            return Response.ok("No service by the name of " + name).build();
        } else {
            toDelete.delete();
            toDelete.setStatus(ServiceStatus.DOWN);
            return Response.ok(toDelete).build();
        }
    }

    @GET
    public Response getServices() {
        return Response.ok(Service.findAll().list()).build();
    }

    @GET
    @Path("/{name}")
    public Response getServices(@PathParam("name") String name) {
        return Response.ok(Objects.requireNonNullElseGet(Service.findByName(name), () -> "No service by the name of " + name)).build();
    }

}
