package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.criteria.RestaurantCriteria;
import reservation_server.domain.Restaurant;
import reservation_server.exception.NotFoundException;
import reservation_server.service.RestaurantService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> all(RestaurantCriteria criteria) {
        return restaurantService.findAll(criteria);
    }

    @GetMapping("/{id}")
    public Restaurant one(@PathVariable Long id) {
        return this.restaurantService.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PostMapping
    public Restaurant newRestaurant(@RequestBody Restaurant newRestaurant) {
        return restaurantService.save(newRestaurant);
    }

    @PutMapping("/{id}")
    public Restaurant replaceRestaurant(@PathVariable Long id, @RequestBody Restaurant newRestaurant) {
        return this.restaurantService.save(newRestaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }
}
