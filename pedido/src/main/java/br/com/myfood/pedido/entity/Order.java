package br.com.myfood.pedido.entity;

import br.com.myfood.pedido.dto.OrderDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "menu_id", nullable = false)
    private Long idMenu;

    @Column(name = "restaurant_id", nullable = false)
    private Long idRestaurant;

    @Column(name = "product_id", nullable = false)
    private Long idProduct;

    @Column(nullable = false)
    private Double price;

    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

    public static Order create(OrderDto orderDto) {
        return new ModelMapper().map(orderDto, Order.class);
    }

}
