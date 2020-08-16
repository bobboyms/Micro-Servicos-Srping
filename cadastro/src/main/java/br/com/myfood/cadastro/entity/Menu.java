package br.com.myfood.cadastro.entity;

import br.com.myfood.cadastro.dto.MenuDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data
@Entity(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public static Menu create(MenuDto menuDto) {
        return new ModelMapper().map(menuDto, Menu.class);
    }

}
