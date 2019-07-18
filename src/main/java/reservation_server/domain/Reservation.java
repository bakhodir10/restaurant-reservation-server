package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import reservation_server.repository.FileStorageRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private LocalDateTime reservationDate;
    private LocalDateTime reservationCancelDate;
    @Column(nullable = false)
    private int numberOfPeople;
    @OneToMany
    private List<DiningTable> tables;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Customer owner;
}
