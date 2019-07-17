package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.Restaurant;
import reservation_server.exception.NotFoundException;
import reservation_server.service.RestaurantService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants/list")
    public List<Restaurant> all() {
        return restaurantService.findAll();
    }

    @GetMapping(value = "/restaurants")
    public Set<Restaurant> all(@RequestParam String state,
                               @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                               @RequestParam("time") @DateTimeFormat(pattern = "hh:mm:ss") Date time,
                               Integer countOfPeople) {
        System.out.println("countOfPeople = " + countOfPeople);
        return restaurantService.findAll(state, date, time, countOfPeople);
    }

    @GetMapping(value = "/restaurants/{id}")
    public Restaurant one(@PathVariable Long id) {
        return this.restaurantService.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PostMapping(value = "/restaurants")
    public Restaurant newRestaurant(@RequestBody Restaurant newRestaurant) {
        return restaurantService.save(newRestaurant);
    }

    @PutMapping(value = "/restaurants/{id}")
    public Restaurant replaceRestaurant(@PathVariable Long id, @RequestBody Restaurant newRestaurant) {
        return this.restaurantService.save(newRestaurant);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public void delete(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }
}
