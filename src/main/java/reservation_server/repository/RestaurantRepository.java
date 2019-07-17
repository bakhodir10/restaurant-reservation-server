package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reservation_server.domain.Restaurant;

import java.util.Date;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("from Restaurant as r " +
            " join fetch r.diningTables as tab " +
            " join fetch tab.times as tim " +
            " where r.address.state like %:state% " +
            " and tim.date = :date and tim.endTime <= :startTime")
    Set<Restaurant> findAll(String state, Date date, Date startTime);
}
