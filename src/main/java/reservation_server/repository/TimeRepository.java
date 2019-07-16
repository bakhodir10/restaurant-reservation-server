package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation_server.domain.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
