package br.com.myfood.pedido.message;


import br.com.myfood.pedido.dto.MenuOrderDto;
import br.com.myfood.pedido.entity.Menu;
import br.com.myfood.pedido.repository.MenuRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuReceiveMessage(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @RabbitListener(queues = {"${cadastro.menu.rabbitmq.queue}"})
    public void receive(@Payload MenuOrderDto menuOrderDto) {
        System.out.println(menuOrderDto);

        final Menu menu = new Menu();
        menu.setIdMenu(menuOrderDto.getIdMenu());
        menu.setIdRestaurant(menuOrderDto.getIdRestaurant());
        menu.setName(menuOrderDto.getName());
        menu.setPrice(menuOrderDto.getPrice());

        System.out.println(menu);

        menuRepository.save(menu);

        System.out.println(menu);
    }

}
