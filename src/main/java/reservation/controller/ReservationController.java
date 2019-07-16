package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation.domain.Customer;
import reservation.domain.Reservation;
import reservation.service.CustomerService;
import reservation.service.ReservationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/api")
@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 6000)
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/reservations")
    private Reservation add(@Valid Reservation reservation) {
        return reservationService.save(reservation);
    }

    @GetMapping("/reservations")
    private List<Reservation> getAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{ownerId}")
    private List<Reservation> getAllByCustomer(@PathVariable long ownerId) {
        Optional<Customer> customer = customerService.findById(ownerId);
        if (customer.isPresent())
            return reservationService.findReservationByOwner(customer.get());
        else return new ArrayList<>();
    }
}