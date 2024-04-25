package udem.edu.co.heroes.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udem.edu.co.heroes.entities.Heroe;
import udem.edu.co.heroes.entities.Poder;
import udem.edu.co.heroes.repository.PoderRepository;
import udem.edu.co.heroes.service.PoderService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class PoderServiceImplTest {

    @InjectMocks
    private PoderService poderService;

    @Mock
    private PoderRepository poderRepository;

    private AutoCloseable openMocks;

    private Poder poder;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        poder = new Poder("Correr", "Flash");
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void findAllPoderesNull() throws IOException, SQLException {
        List<Poder> poderes = new ArrayList<>();
        poderes.add(poder);
        when(poderRepository.findAll()).thenReturn(poderes);
        assertNull(poderService.findAllPoderes());
    }

    @Test
    void findAllPoderesNotNull() throws IOException, SQLException {
        List<Poder> poderes = new ArrayList<>();
        poderes.add(poder);
        when(poderRepository.findAll()).thenReturn(poderes);
        assertNotNull(poderService.findAllPoderes());
    }


    @Test
    void findByIdPoderNotNull() throws IOException, SQLException {
        when(poderRepository.findById(poder.getName())).thenReturn(Optional.of(poder));
        assertNotNull(poderService.findByIdPoder(poder.getName()));
    }

    @Test
    void findByIdPoderNull() throws IOException, SQLException {
        when(poderRepository.findById(poder.getName())).thenReturn(Optional.of(poder));
        assertNull(poderService.findByIdPoder(poder.getName()));
    }

    @Test
    void createPoderNotNull() throws IOException {
        when(poderRepository.save(poder)).thenReturn(poder);
        assertNotNull(poderService.createPoder(poder));
    }

    @Test
    void createPoderNull() throws IOException {
        when(poderRepository.save(poder)).thenReturn(poder);
        assertNull(poderService.createPoder(poder));
    }

    @Test
    void updatePoderNotNull() throws IOException {
        when(poderRepository.save(poder)).thenReturn(poder);
        assertNotNull(poderService.updatePoder(poder));
    }

    @Test
    void updatePoderNull() throws IOException {
        when(poderRepository.save(poder)).thenReturn(poder);
        assertNull(poderService.updatePoder(poder));
    }

}