package br.com.myfood.pedido.message;


import br.com.myfood.pedido.dto.ClientOrderDto;
import br.com.myfood.pedido.entity.Client;
import br.com.myfood.pedido.repository.ClientRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientReceiveMessage(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RabbitListener(queues = {"${cadastro.client.rabbitmq.queue}"})
    public void receive(@Payload ClientOrderDto clientOrderDto) {
        System.out.println(clientOrderDto);
        clientRepository.save(Client.create(clientOrderDto));
    }

}
