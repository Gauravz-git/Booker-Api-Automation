import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.Booking;
import org.example.BookingApi;
import org.example.BookingDates;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest {

    @Test
    public void createAndGetBooking() {

        // Objects
        BookingDates bookingDates =
                new BookingDates("2026-10-01", "2026-10-05");

        Booking booking =
                new Booking("Gaurav", "Chaudhari", 2000, true, bookingDates);

        //BookingApi Object
        BookingApi bookingApi = new BookingApi();

        //post booking
        Response response = bookingApi.createBooking(booking);

        // Print complete response
        System.out.println(response.asString());

        JsonPath jsonPath1 = response.jsonPath();

        int bookingId = jsonPath1.getInt("bookingid");
        System.out.println("Booking ID: " + bookingId);

        //get booking
        Response getResponse =bookingApi.getBooking(bookingId);

        // Print complete get response
        System.out.println("GET Response: " + getResponse.asString());

        JsonPath jsonPath2 = getResponse.jsonPath();

        String firstName = jsonPath2.getString("firstname");
        String lastName = jsonPath2.getString("lastname");
        double totalPrice = jsonPath2.getDouble("totalprice");
        boolean depositPaid = jsonPath2.getBoolean("depositpaid");

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Deposit Paid: " + depositPaid);

        // Actual vs Expected validation
        Assert.assertEquals(firstName, booking.getFirstName());
        Assert.assertEquals(lastName, booking.getLastName());
        Assert.assertEquals(totalPrice, booking.getTotalPrice());
        Assert.assertEquals(depositPaid, booking.isDepositPaid());

        System.out.println("All booking details validated successfully!");

    }
}