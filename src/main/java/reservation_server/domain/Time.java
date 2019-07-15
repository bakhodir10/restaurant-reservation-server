package reservation_server.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Time {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
}
