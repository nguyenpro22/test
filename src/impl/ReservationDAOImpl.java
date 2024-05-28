// dao/impl/ReservationDAOImpl.java
package impl;

import dao.ReservationDAO;
import model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        return null; // Not found
    }

    @Override
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations); // Return a copy to prevent external modification
    }

    @Override
    public void updateReservation(Reservation reservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationId().equals(reservation.getReservationId())) {
                reservations.set(i, reservation);
                break;
            }
        }
    }

    @Override
    public void deleteReservation(String reservationId) {
        reservations.removeIf(reservation -> reservation.getReservationId().equals(reservationId));
    }
    // Other reservation-related methods can be added
}
