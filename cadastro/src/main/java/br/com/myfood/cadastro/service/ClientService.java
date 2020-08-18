package br.com.myfood.cadastro.service;

import br.com.myfood.cadastro.dto.ClientOrderDto;
import br.com.myfood.cadastro.entity.Client;
import br.com.myfood.cadastro.message.ClientSendMessage;
import br.com.myfood.cadastro.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientSendMessage clientMessage;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientSendMessage clientMessage) {
        this.clientRepository = clientRepository;
        this.clientMessage = clientMessage;
    }

    public Client saveClient(Client client) throws JsonProcessingException {
        final Client newClient = clientRepository.save(client);
        clientMessage.sendMessage(ClientOrderDto.create(newClient));
        return newClient;
    }

    public Client updateClient(Client client) throws JsonProcessingException {

        final Optional<Client> optional = clientRepository.findById(client.getId());

        if (optional.isPresent()) {
            return clientRepository.save(client);
        } else {
            return null;
        }

    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

}
