package br.com.myfood.pedido.message;


import br.com.myfood.pedido.entity.Restaurant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMessage {

    @RabbitListener(queues = {"${cadastro.restaurant.rabbitmq.queue}"})
    public void receive(@Payload Restaurant restaurant) {
        System.out.println(restaurant);
    }

}
