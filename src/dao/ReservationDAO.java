package dao;

import model.Reservation;
import java.util.List;

public interface ReservationDAO {
    void addReservation(Reservation reservation);
    Reservation getReservationById(String reservationId);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservation(String reservationId);
    //dung da o day
}
