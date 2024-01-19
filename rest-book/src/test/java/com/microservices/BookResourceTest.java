package com.microservices;

import com.microservices.book.Book;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldCreateABook() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"lalalal\", \"author\": \"lalalal\", \"year_of_publication\": \"2001\", \"genre\": \"lalalal\", \"creation_date\": \"2024-01-11\"}")
                .when()
                .post("/api/books")
                .then()
                .statusCode(201);
    }

}