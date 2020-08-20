package br.com.myfood.pedido.dto;

import br.com.myfood.pedido.entity.Order;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long idMenu;
    private Long idClient;
    private Long idRestaurant;
    private Double price;

}


