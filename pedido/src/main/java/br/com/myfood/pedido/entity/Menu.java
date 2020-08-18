package br.com.myfood.pedido.entity;

import br.com.myfood.pedido.dto.ClientOrderDto;
import br.com.myfood.pedido.dto.MenuOrderDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static Menu create(MenuOrderDto menuOrderDto) {
        return new ModelMapper().map(menuOrderDto, Menu.class);
    }

}
