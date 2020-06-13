package com.ibm.mdm.api;

import com.ibm.mdm.model.Service;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/**
 * Requires the src/test/docker/docker-compose.testenv.yml to be up:
 *      $ docker-compose -f dam2-listener/src/test/docker/docker-compose.testenv.yml up
 */
@QuarkusTest
public class ServicesResourceTest {

    Jsonb jsonutil = JsonbBuilder.create();

    @Test
    public void testRootApi() {
        given()
                .when().get("/api")
                .then()
                .statusCode(200);
    }

    @Test
    public void testServiceListApi() {
        given()
                .when().get("/api/v1")
                .then()
                .statusCode(200);

    }

    @Test
    public void testDataEntryAndDelete() {
        given().when().post("/api/v1");

//        System.out.println(given().get("/api/v1/", "test-service").getBody().prettyPrint());
    }

}
