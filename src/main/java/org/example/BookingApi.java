package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {

    public BookingApi() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    public Response createBooking(Booking booking) {

        return given()
                .contentType("application/json")
                .body(booking)
                .when()
                .post("/booking");
    }

    public Response getBooking(int bookingId) {

        return given()
                .contentType("application/json")
                .when()
                .get("/booking/" + bookingId);
    }
}