package br.com.myfood.pedido.entity;

import br.com.myfood.pedido.dto.ClientOrderDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    public static Client create(ClientOrderDto clientOrderDto) {
        return new ModelMapper().map(clientOrderDto, Client.class);
    }

}
