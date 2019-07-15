package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.domain.Restaurant;
import reservation_server.repository.RestaurantRepository;

import java.util.List;

@Service
@Transactional
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
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
}
