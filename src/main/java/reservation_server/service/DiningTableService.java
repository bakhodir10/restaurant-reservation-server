package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.criteria.RestaurantCriteria;
import reservation_server.domain.DiningTable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiningTableService {

    @Autowired
    private DiningTableService diningTableService;

    public List<DiningTable> findAll() {
        return diningTableService.findAll();
    }

    public List<DiningTable> findAll(RestaurantCriteria criteria) {
        return diningTableService.findAll(criteria);
    }

    public DiningTable getOne(Long id) {
        return this.diningTableService.getOne(id);
    }

    public DiningTable save(DiningTable newDiningTable) {
        return this.diningTableService.save(newDiningTable);
    }

    public void deleteById(Long id) {
        this.diningTableService.deleteById(id);
    }

    public Optional<DiningTable> findById(Long id) {
        return this.diningTableService.findById(id);
    }
}
