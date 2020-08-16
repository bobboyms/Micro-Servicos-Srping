package br.com.myfood.cadastro.service;

import br.com.myfood.cadastro.entity.Restaurant;
import br.com.myfood.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {

        final Optional<Restaurant> optional = restaurantRepository.findById(restaurant.getId());

        if (optional.isPresent()) {
            return restaurantRepository.save(restaurant);
        } else {
            return null;
        }

    }

    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

}
