package br.com.myfood.pedido.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Restaurant {

    private Long id;
    private String name;
    private String email;
    private String user;
    private String password;

}
