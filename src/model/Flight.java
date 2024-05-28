package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {

    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    private String arrivalTime;
    private int availableSeats;
    private static final String FLIGHT_NUMBER_REGEX = "^F\\d{4}$";

    public Flight(String flightNumber, String departureCity, String destinationCity,
            String departureTime, String arrivalTime, int availableSeats) {
        setFlightNumber(flightNumber);
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        this.availableSeats = availableSeats;
    }

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public static String getFLIGHT_NUMBER_REGEX() {
        return FLIGHT_NUMBER_REGEX;
    }

    private void setFlightNumber(String flightNumber) {
        if (!flightNumber.matches(getFLIGHT_NUMBER_REGEX())) {
            throw new IllegalArgumentException("Invalid flight number format. Should be Fxyzt, where xyzt is a 4-digit number.");
        }
        this.flightNumber = flightNumber;
    }

    private Date parseTime(String time) throws ParseException {
        return new SimpleDateFormat("HH:mm").parse(time);
    }

    private void setDepartureTime(String departureTime) {
        try {
            Date parsedDepartureTime = parseTime(departureTime);
            if (this.arrivalTime != null) {
                Date parsedArrivalTime = parseTime(this.arrivalTime);
                if (parsedDepartureTime.after(parsedArrivalTime)) {
                    throw new IllegalArgumentException("Departure time must be earlier than arrival time.");
                }
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid departure time format. Should be in HH:mm format.");
        }
        this.departureTime = departureTime;
    }

    private void setArrivalTime(String arrivalTime) {
        try {
            Date parsedArrivalTime = parseTime(arrivalTime);
            if (this.departureTime != null) {
                Date parsedDepartureTime = parseTime(this.departureTime);
                if (parsedArrivalTime.before(parsedDepartureTime)) {
                    throw new IllegalArgumentException("Arrival time must be later than departure time.");
                }
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid arrival time format. Should be in HH:mm format.");
        }
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return flightNumber + "|" + departureCity + "|" + destinationCity + "|" + departureTime + "|" + arrivalTime + "|" + availableSeats;
    }

}
