package br.com.myfood.cadastro.controller;

import br.com.myfood.cadastro.dto.MenuDto;
import br.com.myfood.cadastro.entity.Menu;
import br.com.myfood.cadastro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/save")
    public ResponseEntity saveMenu(@RequestBody MenuDto menuDto) {

        try {

            Menu menu = menuService.saveMenu(menuDto);

            URI uri = gerUri(menu.getId());
            return ResponseEntity.created(uri).body(menu.getId());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    private URI gerUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/menu/find/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurant(@PathVariable("id") Long id, @RequestBody MenuDto menuDto) {

        try {

            Menu menu = Menu.create(menuDto);
            menu.setId(id);

            menu = menuService.updateMenu(menu);

            return Objects.nonNull(menu) ? ResponseEntity.ok().body(menu) :
                    ResponseEntity.notFound().build();


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        final Optional<Menu> menu = menuService.findById(id);

        if (menu.isPresent()) {
            MenuDto menuDto = MenuDto.create(menu.get());
            menuDto.setIdRestaurant(menu.get().getRestaurant().getId());
            return ResponseEntity.ok(menuDto);
        }

        return ResponseEntity.notFound().build();

    }


}
