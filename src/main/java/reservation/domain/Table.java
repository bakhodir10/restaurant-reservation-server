package reservation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name = "dining_table")
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private int capacity;
    @ManyToOne
    private Restaurant restaurant;
}
