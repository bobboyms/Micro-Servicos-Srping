package br.com.myfood.pedido.repository;

import br.com.myfood.pedido.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
