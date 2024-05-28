// dao/impl/FlightDAOImpl.java
package impl;

import dao.FlightDAO;
import model.Flight;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    private List<Flight> flights = new ArrayList<>();

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null; // Not found
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights); // Return a copy to prevent external modification
    }

    @Override
    public void updateFlight(Flight flight) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equals(flight.getFlightNumber())) {
                flights.set(i, flight);
                break;
            }
        }
    }

    @Override
    public void deleteFlight(String flightNumber) {
        flights.removeIf(flight -> flight.getFlightNumber().equals(flightNumber));
    }
    // Other flight-related methods can be added
}
