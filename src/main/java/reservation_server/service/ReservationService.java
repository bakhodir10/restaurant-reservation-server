package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.domain.Customer;
import reservation_server.domain.Reservation;
import reservation_server.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Transactional
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public List<Reservation> findReservationByOwner(Customer owner) {
        return repository.findReservationByOwner(owner);
    }
}
