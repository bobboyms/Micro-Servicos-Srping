package br.com.myfood.pedido.controller;

import br.com.myfood.pedido.dto.OrderDto;
import br.com.myfood.pedido.entity.Order;
import br.com.myfood.pedido.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public String get() {
        return "Ok";
    }

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity newOrder(OrderDto orderDto) {
        try {

            Order order = orderService.saveOrder(Order.create(orderDto));
            URI uri = gerUri(order.getId());

            return ResponseEntity.created(uri).body(order.getId());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    private URI gerUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/order/find/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
