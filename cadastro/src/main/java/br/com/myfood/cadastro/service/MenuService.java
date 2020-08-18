package br.com.myfood.cadastro.service;

import br.com.myfood.cadastro.dto.MenuDto;
import br.com.myfood.cadastro.dto.MenuOrderDto;
import br.com.myfood.cadastro.entity.Menu;
import br.com.myfood.cadastro.entity.Restaurant;
import br.com.myfood.cadastro.exception.NotFoundException;
import br.com.myfood.cadastro.message.MenuSendMessage;
import br.com.myfood.cadastro.repository.MenuRepository;
import br.com.myfood.cadastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuSendMessage menuSendMessage;

    @Autowired
    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository, MenuSendMessage menuSendMessage) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuSendMessage = menuSendMessage;
    }

    public Menu saveMenu(MenuDto menuDto) throws NotFoundException {

        System.out.println(menuDto);

        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDto.getIdRestaurant());

        if (restaurant.isPresent()) {
            Menu menu = Menu.create(menuDto);
            menu.setRestaurant(restaurant.get());
            Menu newMenu = menuRepository.save(menu);
            menuSendMessage.sendMessage(MenuOrderDto.create(newMenu));
            return newMenu;
        }

        throw new NotFoundException("Restaurante não encontrado");

    }

    public Menu updateMenu(Menu menu) {

        final Optional<Menu> optional = menuRepository.findById(menu.getId());

        if (optional.isPresent()) {
            return menuRepository.save(menu);
        } else {
            return null;
        }
    }

    @Cacheable("teste")
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

}
