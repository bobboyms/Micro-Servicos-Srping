package br.com.myfood.pedido.service;

import br.com.myfood.pedido.entity.Client;
import br.com.myfood.pedido.entity.Menu;
import br.com.myfood.pedido.entity.Order;
import br.com.myfood.pedido.exception.NotFoundException;
import br.com.myfood.pedido.repository.ClientRepository;
import br.com.myfood.pedido.repository.MenuRepository;
import br.com.myfood.pedido.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ClientRepository clientRepository;

    private final MenuRepository menuRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.menuRepository = menuRepository;
    }

    public Order saveOrder(Order order) throws NotFoundException {

        System.out.println(order);

        final Optional<Client> client = clientRepository.findByIdClient(order.getIdClient());

        if (client.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        System.out.println(order.getIdMenu());
        System.out.println(order.getIdRestaurant());
        final Optional<Menu> menu = menuRepository.findByIdMenuAndIdRestaurant(order.getIdMenu(), order.getIdRestaurant());

        if (menu.isEmpty()) {
            throw new NotFoundException("Menu ou restaurantes não encontrados");
        }

        return orderRepository.save(order);
    }
}
