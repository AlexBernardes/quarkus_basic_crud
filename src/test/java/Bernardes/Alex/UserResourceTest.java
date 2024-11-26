package Bernardes.Alex;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserResourceTest {

    @Test
    @Order(1)
    void create() {
        JsonObject jsonItem = Json
                .createObjectBuilder()
                .add("firstName", "firstName")
                .add("lastName", "lastName")
                .build();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonItem.toString())
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @Order(2)
    void getAll() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].id", is(1))
                .body("[0].firstName", is("firstName"))
                .body("[0].lastName", is("lastName"));


    }

}