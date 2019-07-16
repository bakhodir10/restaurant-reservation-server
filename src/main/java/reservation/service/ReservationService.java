package reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.domain.Customer;
import reservation.domain.Reservation;
import reservation.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Transactional
    public Reservation save(Reservation reservation) {
        int numberOfPeople = reservation.getNumberOfPeople();
        return repository.save(reservation);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public List<Reservation> findReservationByOwner(Customer owner) {
        return repository.findReservationByOwner(owner);
    }
}
