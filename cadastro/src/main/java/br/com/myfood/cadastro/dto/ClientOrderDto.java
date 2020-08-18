package br.com.myfood.cadastro.dto;

import br.com.myfood.cadastro.entity.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class ClientOrderDto {

    private Long id;
    private String name;

    public static ClientOrderDto create(Client client) {
        return new ModelMapper().map(client, ClientOrderDto.class);
    }

}
