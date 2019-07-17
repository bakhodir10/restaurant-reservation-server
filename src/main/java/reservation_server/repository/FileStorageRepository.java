package reservation_server.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation_server.domain.FileStorage;
import reservation_server.domain.Time;

import javax.persistence.*;
import java.util.Set;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
    FileStorage save(FileStorage fileStorage);
}
