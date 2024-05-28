package model;

public class Reservation {

    private String reservationId;
    private String passengerName;
    private String contactDetails;
    private String flightNumber;

    public Reservation(String reservationId, String passengerName, String contactDetails, String flightNumber) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.contactDetails = contactDetails;
        this.flightNumber = flightNumber;
    }

    public Reservation() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return reservationId + "|" + passengerName + "|" + contactDetails + "|" + flightNumber;
    }

}
