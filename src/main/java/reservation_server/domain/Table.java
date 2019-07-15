package reservation_server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private int capacity;
    @ManyToOne
    private Restaurant restaurant;
}
