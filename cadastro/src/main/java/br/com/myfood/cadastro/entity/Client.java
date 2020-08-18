package br.com.myfood.cadastro.entity;

import br.com.myfood.cadastro.dto.ClientDto;
import br.com.myfood.cadastro.dto.ClientOrderDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String user;
    private String password;

    public static Client create(ClientDto clientDto) {
        return new ModelMapper().map(clientDto, Client.class);
    }

}
