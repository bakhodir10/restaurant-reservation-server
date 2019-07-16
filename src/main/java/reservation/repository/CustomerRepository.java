package reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
