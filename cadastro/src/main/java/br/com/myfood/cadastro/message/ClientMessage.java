package br.com.myfood.cadastro.message;

import br.com.myfood.cadastro.configuration.RabbitmqConfiguration;
import br.com.myfood.cadastro.entity.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientMessage {

    @Value("${cadastro.rabbitmq.exchange}")
    String exchange;

    @Value("${cadastro.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public ClientMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Client client) {
        rabbitTemplate.convertAndSend(exchange, routingkey, client);
    }

}
