package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testListBooksEndpoint() {
        RestAssured.get("/books").then()
                .statusCode(200)
                .body(CoreMatchers.is("[]"));
    }
}
