package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class DiningTable {
    @Id
    @GeneratedValue
    private Long id;
    private int capacity;
    @OneToOne
    private Time time;
    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;
}
