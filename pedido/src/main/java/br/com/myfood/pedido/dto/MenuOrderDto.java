package br.com.myfood.pedido.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {

    private Long id;
    private String name;
    private Double price;
    private Long idRestaurant;

}
