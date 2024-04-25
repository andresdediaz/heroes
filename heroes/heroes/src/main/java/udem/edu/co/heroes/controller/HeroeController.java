package udem.edu.co.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.heroes.entities.Heroe;
import udem.edu.co.heroes.service.HeroeService;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/heroe")
public class HeroeController {

    @Autowired
    HeroeService heroeService;

    @GetMapping("/heroe")
    public List<Heroe> findAllHeroes() throws SQLException, IOException {
        try {
            return this.heroeService.findAllHeroes();
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida\n");
            return null;
        } catch (SQLException e) {
            System.err.println("No hay nada en la lista");
            return null;
        }
    }


    @GetMapping("/heroe/{name}")
    public Optional<Heroe> findHeroeById(@PathVariable("name") String name) {
        try {
            return this.heroeService.findByIdHeroe(name);
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida:\n");
            return null;
        } catch (SQLException e) {
            System.err.println("El nombre no existe");
            return null;
        }
    }



    @PostMapping("/heroe")
    public Heroe createHeroe(@RequestBody() Heroe heroe) throws IOException {
        try {
            return this.heroeService.createHeroe(heroe);
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida:\n");
            return heroe;
        }
    }


    @PutMapping("/heroe/{name}")
    public Heroe updateHeroe(@RequestBody() Heroe heroe) throws IOException {
        try {
            return this.heroeService.updateHeroe(heroe);
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida:\n");
            return heroe;
        }
    }


    @DeleteMapping("/heroe/{name}")
    public void deleteHeroe(@PathVariable("name") String name) throws IOException {
        try {
            this.heroeService.deleteHeroe(name);
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida:\n");
        }
    }
}
