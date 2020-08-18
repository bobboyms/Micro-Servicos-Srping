package br.com.myfood.cadastro.message;

import br.com.myfood.cadastro.dto.MenuOrderDto;
import br.com.myfood.cadastro.entity.Client;
import br.com.myfood.cadastro.entity.Restaurant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MenuSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.menu.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MenuSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MenuOrderDto menuOrderDto) {
        System.out.println(menuOrderDto);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, menuOrderDto);
    }

}
