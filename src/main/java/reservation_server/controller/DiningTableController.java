package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.DiningTable;
import reservation_server.exception.NotFoundException;
import reservation_server.service.DiningTableService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController("/dining-tables")
public class DiningTableController {

    @Autowired
    private DiningTableService diningTableService;

    @GetMapping
    public List<DiningTable> all() {
        return diningTableService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DiningTable one(@PathVariable Long id) {
        return this.diningTableService.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PostMapping
    public DiningTable newRestaurant(@RequestBody DiningTable newDiningTable) {
        return diningTableService.save(newDiningTable);
    }

    @PutMapping(value = "/{id}")
    public DiningTable replaceRestaurant(@PathVariable Long id, @RequestBody DiningTable newDiningTable) {
        return this.diningTableService.save(newDiningTable);
    }

    @PutMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        diningTableService.deleteById(id);
    }
}
