package br.com.myfood.cadastro.dto;

import br.com.myfood.cadastro.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {

    private Long idMenu;
    private String name;
    private Double price;
    private Long idRestaurant;

    public static MenuOrderDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuOrderDto.class);
    }
}
