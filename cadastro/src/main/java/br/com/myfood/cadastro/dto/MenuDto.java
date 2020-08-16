package br.com.myfood.cadastro.dto;

import br.com.myfood.cadastro.entity.Menu;
import br.com.myfood.cadastro.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String name;
    private Double price;
    @JsonProperty("restaurant_id")
    private Long idRestaurant;

    public static MenuDto create(Menu menu) {
        return new ModelMapper().map(menu, MenuDto.class);
    }
}
