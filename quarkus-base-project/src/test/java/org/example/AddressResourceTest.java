package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AddressResourceTest {

    @Test
    public void testListAddressesEndpoint() {
        RestAssured.get("/addresses").then()
                .statusCode(200)
                .body(CoreMatchers.is("[]"));
    }
}
