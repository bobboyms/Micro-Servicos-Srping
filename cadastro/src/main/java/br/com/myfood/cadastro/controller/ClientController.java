package br.com.myfood.cadastro.controller;

import br.com.myfood.cadastro.dto.ClientDto;
import br.com.myfood.cadastro.entity.Client;
import br.com.myfood.cadastro.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody ClientDto clientDto) {

        try {

            Client client = clientService.saveClient(Client.create(clientDto));
            URI uri = gerUri(client.getId());

            return ResponseEntity.created(uri).body(client.getId());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    private URI gerUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/client/find/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientDto) {

        try {

            Client client = Client.create(clientDto);
            client.setId(id);

            client = clientService.updateClient(client);

            return Objects.nonNull(client) ? ResponseEntity.ok().body(client) :
                    ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }


}
