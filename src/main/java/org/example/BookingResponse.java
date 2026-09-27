package org.example;

public class BookingResponse {
    private int bookingId;
    private Booking booking;

    //constructor
    public BookingResponse(int bookingId, Booking booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    //getter & setter
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
