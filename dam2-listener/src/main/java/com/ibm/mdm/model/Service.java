package com.ibm.mdm.model;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.transform.Source;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Resource model
 */
public class Service extends PanacheMongoEntityBase implements Serializable, Source {

    private String systemId;

    private LocalDateTime postDate;

    @NotNull(message = "Service status must be set")
    private ServiceStatus status = ServiceStatus.DOWN;

    @BsonId
    @NotBlank(message = "name may not be blank")
    private String name;

    @NotBlank(message = "deploymentHost may not be blank")
    private String deploymentHost;

    @NotBlank(message = "Version may not be blank")
    private String version;

    @NotBlank(message = "Must specify execution port")
    private String executionPostPort;

    public static Service findByName(String name) {
        return find("_id", name).firstResult();
    }

    public String getDeploymentHost() {
        return deploymentHost;
    }

    public void setDeploymentHost(String deploymentHost) {
        this.deploymentHost = deploymentHost;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getExecutionPostPort() {
        return executionPostPort;
    }

    public void setExecutionPostPort(String executionPostPort) {
        this.executionPostPort = executionPostPort;
    }

    @Override
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @Override
    public String getSystemId() {
        return systemId;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
