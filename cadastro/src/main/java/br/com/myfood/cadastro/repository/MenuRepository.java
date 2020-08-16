package br.com.myfood.cadastro.repository;

import br.com.myfood.cadastro.entity.Menu;
import br.com.myfood.cadastro.entity.Restaurant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Override
//    @Cacheable("menu")
    Optional<Menu> findById(Long aLong);
}
