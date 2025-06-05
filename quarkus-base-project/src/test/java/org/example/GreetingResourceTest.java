package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        RestAssured.get("/hello").then()
                .statusCode(200)
                .body(CoreMatchers.is("Hello from Quarkus"));
    }
}
