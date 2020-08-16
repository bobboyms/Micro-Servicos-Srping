package br.com.myfood.cadastro.service;

import br.com.myfood.cadastro.entity.Client;
import br.com.myfood.cadastro.message.ClientMessage;
import br.com.myfood.cadastro.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientMessage clientMessage;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMessage clientMessage) {
        this.clientRepository = clientRepository;
        this.clientMessage = clientMessage;
    }

    public Client saveClient(Client client) throws JsonProcessingException {
        Client client1 = clientRepository.save(client);
        clientMessage.sendMessage(client1);
        return client1;
    }

    public Client updateClient(Client client) throws JsonProcessingException {

        final Optional<Client> optional = clientRepository.findById(client.getId());

        if (optional.isPresent()) {
            Client client1 = clientRepository.save(client);
            clientMessage.sendMessage(client1);
            return client1;
        } else {
            return null;
        }

    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

}
