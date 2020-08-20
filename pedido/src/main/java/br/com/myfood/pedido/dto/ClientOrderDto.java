package br.com.myfood.pedido.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrderDto {

    private String name;
    private Long idClient;

}
