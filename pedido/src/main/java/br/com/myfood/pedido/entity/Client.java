package br.com.myfood.pedido.entity;

import br.com.myfood.pedido.dto.ClientOrderDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long idClient;

    private String name;

    public static Client create(ClientOrderDto clientOrderDto) {
        return new ModelMapper().map(clientOrderDto, Client.class);
    }

}
