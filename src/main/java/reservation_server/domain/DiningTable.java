package reservation_server.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class DiningTable {
    @Id
    @GeneratedValue
    private Long id;
    private int capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diningTable")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Time> times;
}