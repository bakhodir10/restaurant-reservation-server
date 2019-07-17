package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class FileStorage {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long size;
    @Lob
    @Column(name = "DATA", columnDefinition = "BLOB", nullable = false)
    private byte[] data;
}