package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reservation_server.domain.Restaurant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("from Restaurant r " +
            " join fetch r.diningTables tab " +
            " left outer join tab.times tim " +
            " where r.address.state like %:state% " +
            " and tim.date = :date and(:startTime not between tim.startTime and tim.endTime) or tim.date is null order by r.name desc")
    Set<Restaurant> findAll(String state, LocalDate date, LocalTime startTime);
}
