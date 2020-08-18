package br.com.myfood.cadastro.message;

import br.com.myfood.cadastro.dto.ClientOrderDto;
import br.com.myfood.cadastro.entity.Client;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientSendMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.client.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ClientOrderDto client) {
        System.out.println(client);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, client);
    }

}
