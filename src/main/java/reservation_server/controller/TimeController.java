package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.Time;
import reservation_server.service.TimeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping(value = "/times")
    public Time newTime(@RequestBody Time time) {
        return timeService.save(time);
    }

    @PutMapping(value = "/times/{id}")
    public Time replaceRestaurant(@PathVariable Long id, @RequestBody Time newTime) {
        return this.timeService.save(newTime);
    }

    @DeleteMapping(value = "/times/{id}")
    public void delete(@PathVariable Long id) {
        timeService.deleteById(id);
    }
}
