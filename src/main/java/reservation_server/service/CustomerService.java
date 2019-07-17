package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation_server.domain.Customer;
import reservation_server.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    public Customer findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Customer save(Customer customer) {
        return this.repository.save(customer);
    }
}
