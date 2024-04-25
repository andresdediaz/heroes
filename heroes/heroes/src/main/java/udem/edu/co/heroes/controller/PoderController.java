package udem.edu.co.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udem.edu.co.heroes.entities.Poder;
import udem.edu.co.heroes.service.PoderService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "poder")
public class PoderController {

    @Autowired
    PoderService poderService;

    @GetMapping("/poder")
    public List<Poder> findAllPoderes() throws SQLException, IOException {
        try {
            return this.poderService.findAllPoderes();
        } catch (IOException e) {
            System.err.println("Uh, uh: información no valida\n");
            return null;
        } catch (SQLException e) {
            System.err.println("No hay nada en la lista");
            return null;
        }
    }

    @GetMapping("/poder/{name}")
    public Optional<Poder> findByIdPoder(String name) throws SQLException, IOException {
        try {
            return this.poderService.findByIdPoder(name);
        } catch (IOException e) {
            System.err.println("Uh, uh: Información no valida");
            return Optional.empty();
        }

    }

    @PostMapping("/poder")
    public Poder createPoder(@RequestBody()Poder poder) throws IOException {
        try {
            return this.poderService.createPoder(poder);
        } catch (IOException e) {
            System.err.println("Uh, uh: Información no valida");
            return null;
        }
    }

    @PutMapping("/poder")
    public Poder updatePoder(@RequestBody() Poder poder) throws IOException {
        try {
            return this.poderService.updatePoder(poder);
        }catch (IOException e) {
            System.err.println("Uh, uh: Información no valida");
            return null;
        }
    }

    @DeleteMapping("/poder")
    public void deletePoder(@PathVariable("name") String name) throws IOException {
        try {
            this.poderService.deletePoder(name);
        }  catch (IOException e) {
            System.err.println("Uh, uh: información no valida:\n");
        }
    }
}
