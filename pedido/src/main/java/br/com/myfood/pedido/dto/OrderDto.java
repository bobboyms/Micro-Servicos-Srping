package br.com.myfood.pedido.dto;

import br.com.myfood.pedido.entity.Order;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long idMenu;
    private Long idRestaurant;
    private Long idProduct;
    private Double price;

    public static OrderDto create(Order order) {
        return new ModelMapper().map(order, OrderDto.class);
    }

}


