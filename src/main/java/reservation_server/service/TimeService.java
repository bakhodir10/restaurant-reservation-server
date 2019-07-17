package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.domain.Time;
import reservation_server.repository.TimeRepository;

import java.util.Optional;

@Service
@Transactional
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time getOne(Long id) {
        return this.timeRepository.getOne(id);
    }

    public Time save(Time newTime) {
        return this.timeRepository.save(newTime);
    }

    public void deleteById(Long id) {
        this.timeRepository.deleteById(id);
    }

    public Optional<Time> findById(Long id) {
        return this.timeRepository.findById(id);
    }
}
