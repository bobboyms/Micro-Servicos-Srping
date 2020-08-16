package br.com.myfood.cadastro.dto;

import br.com.myfood.cadastro.entity.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private String name;
    private String email;
    private String user;
    private String password;

    public static ClientDto create(Client client) {
        return new ModelMapper().map(client, ClientDto.class);
    }

}
