package reservation.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany
    private List<Table> tables;
}
