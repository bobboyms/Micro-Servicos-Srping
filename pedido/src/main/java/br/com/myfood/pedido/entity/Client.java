package br.com.myfood.pedido.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Client {
    private Long id;
    private String name;
    private String email;
    private String user;
    private String password;
}
