package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class DiningTable {
    @Id
    @GeneratedValue
    private Long id;
    private Integer capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diningTable")
    private Set<Time> times;
}
