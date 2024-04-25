package udem.edu.co.heroes.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udem.edu.co.heroes.entities.Heroe;
import udem.edu.co.heroes.repository.HeroeRepository;
import udem.edu.co.heroes.service.HeroeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HeroeServiceImplTest {

    @InjectMocks
    private HeroeService heroeService;

    @Mock
    private HeroeRepository heroeRepository;

    private AutoCloseable openMocks;

    private Heroe heroe;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        heroe = new Heroe("Spider Man", "Misiles");
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void findAllHeroesNull() throws IOException, SQLException {
        List<Heroe> heroes = new ArrayList<>();
        heroes.add(heroe);
        when(heroeRepository.findAll()).thenReturn(heroes);
        assertNull(heroeService.findAllHeroes());
    }

    @Test
    void findAllHeroesNotNull() throws IOException, SQLException {
        List<Heroe> heroes = new ArrayList<>();
        heroes.add(heroe);
        when(heroeRepository.findAll()).thenReturn(heroes);
        assertNotNull(heroeService.findAllHeroes());
    }

    @Test
    void findByIdHeroeNotNull() throws IOException, SQLException {
        when(heroeRepository.findById(heroe.getName())).thenReturn(Optional.of(heroe));
        assertNotNull(heroeService.findByIdHeroe(heroe.getName()));
    }

    @Test
    void findByIdHeroeNull() throws IOException, SQLException {
        when(heroeRepository.findById(heroe.getName())).thenReturn(Optional.of(heroe));
        assertNull(heroeService.findByIdHeroe(heroe.getName()));
    }


    @Test
    void createHeroeNotNull() throws IOException {
        when(heroeRepository.save(heroe)).thenReturn(heroe);
        assertNotNull(heroeService.createHeroe(heroe));
    }

    @Test
    void createHeroeNull() throws IOException {
        when(heroeRepository.save(heroe)).thenReturn(heroe);
        assertNull(heroeService.createHeroe(heroe));
    }

    @Test
    void updateHeroeNotNull() throws IOException {
        when(heroeRepository.save(heroe)).thenReturn(heroe);
        assertNotNull(heroeService.updateHeroe(heroe));
    }

    @Test
    void updateHeroeNull() throws IOException {
        when(heroeRepository.save(heroe)).thenReturn(heroe);
        assertNull(heroeService.updateHeroe(heroe));
    }


    @Test
    void deleteHeroe() {
    }
}