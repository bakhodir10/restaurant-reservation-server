package reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.domain.Customer;
import reservation.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }
}
