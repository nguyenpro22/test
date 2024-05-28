package dao;

import model.Flight;
import java.util.List;

public interface FlightDAO {
    void addFlight(Flight flight);
    Flight getFlightByNumber(String flightNumber);
    List<Flight> getAllFlights();
    void updateFlight(Flight flight);
    void deleteFlight(String flightNumber);
    List<String> getFlightCodeByLocationAndDate(String loc, String date);
}
