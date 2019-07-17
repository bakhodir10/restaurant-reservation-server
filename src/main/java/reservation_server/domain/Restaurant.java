package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import reservation_server.repository.FileStorageRepository;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<DiningTable> diningTables;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Time> availableHours;
}
