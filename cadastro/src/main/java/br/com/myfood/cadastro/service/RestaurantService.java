package br.com.myfood.cadastro.service;

import br.com.myfood.cadastro.entity.Restaurant;
import br.com.myfood.cadastro.message.RestaurantMessage;
import br.com.myfood.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMessage restaurantMessage;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMessage restaurantMessage) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMessage = restaurantMessage;
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {

        Restaurant restaurant1 = restaurantRepository.save(restaurant);
        restaurantMessage.sendMessage(restaurant);
        return restaurant1;
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
