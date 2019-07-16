package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.criteria.RestaurantCriteria;
import reservation_server.domain.Restaurant;
import reservation_server.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> findAll(RestaurantCriteria criteria) {
        return restaurantRepository.findAll(criteria.getState());
    }

    public Restaurant getOne(Long id) {
        return this.restaurantRepository.getOne(id);
    }

    public Restaurant save(Restaurant newRestaurant) {
        return this.restaurantRepository.save(newRestaurant);
    }

    public void deleteById(Long id) {
        this.restaurantRepository.deleteById(id);
    }

    public Optional<Restaurant> findById(Long id) {
        return this.restaurantRepository.findById(id);
    }
}
