package br.com.myfood.pedido.repository;

import br.com.myfood.pedido.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
