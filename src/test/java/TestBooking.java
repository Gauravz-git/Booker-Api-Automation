
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Booking;
import org.example.BookingDates;
import org.example.BookingResponse;

public class TestBooking {
    public static void main(String[] args) throws Exception {

        //objects
        BookingDates bookingDates = new BookingDates("2026-10-01","2026-10-05");
        Booking booking = new Booking("Gaurav","Chaudhari", 2000, true, bookingDates);
        BookingResponse bookingResponse = new BookingResponse(123, booking);


        // Object Mapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(booking);
        Booking booking2 = objectMapper.readValue(json,Booking.class);
        System.out.println(booking2);

        System.out.println("bookingId: " + bookingResponse.getBookingId());
        System.out.println("firstName: " + bookingResponse.getBooking().getFirstName());
        System.out.println("lastName: " + bookingResponse.getBooking().getLastName());
        System.out.println("totalPrice: " + bookingResponse.getBooking().getTotalPrice());
        System.out.println("depositPaid: " + bookingResponse.getBooking().isDepositPaid());
        System.out.println("checkIn: " + bookingResponse.getBooking().getBookingDates().getCheckIn());
        System.out.println("checkOut: " + bookingResponse.getBooking().getBookingDates().getCheckOut());


    }
}
