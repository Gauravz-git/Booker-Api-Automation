import io.restassured.RestAssured;
import org.example.Booking;
import org.example.BookingDates;

import static io.restassured.RestAssured.given;

public class BookingTest {
    public static void main(String[] args) {

        //Objects
        BookingDates bookingDates = new BookingDates("2026-10-01","2026-10-05");
        Booking booking = new Booking("Gaurav","Chaudhari", 2000, true, bookingDates);

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        given()
                .log().all()
                .contentType("application/json")
                .body(booking)
        .when()
                .post("/booking")
        .then()
                .log().all()
                .statusCode(200);
    }
}
