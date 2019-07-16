package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reservation_server.domain.Restaurant;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("from Restaurant r join fetch r.diningTables")
    List<Restaurant> findAll();

    @Query("from Restaurant as r where r.address.state like %:state%")
    List<Restaurant> findAll(String state);
}
