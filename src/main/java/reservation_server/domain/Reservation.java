package reservation_server.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime reservationCancelDate;
    private Integer numberOfPeople;
    @ManyToOne
    private Time time;
    @OneToMany
    private List<DiningTable> diningTables;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Customer owner;

}
