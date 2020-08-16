package br.com.myfood.pedido.message;


import br.com.myfood.pedido.entity.Client;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientMessage {

    @RabbitListener(queues = {"${cadastro.client.rabbitmq.queue}"})
    public void receive(@Payload Client client) {
        System.out.println(client);
    }

}
