package reservation_server.criteria;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@ToString
public class RestaurantCriteria {
    private String state;
    private LocalDate date;
    private LocalTime time;
    private int countOfPeople;
}
