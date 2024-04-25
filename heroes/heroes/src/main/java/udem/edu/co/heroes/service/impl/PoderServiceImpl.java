package udem.edu.co.heroes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udem.edu.co.heroes.entities.Poder;
import udem.edu.co.heroes.repository.PoderRepository;
import udem.edu.co.heroes.service.PoderService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PoderServiceImpl implements PoderService {

    @Autowired
    PoderRepository poderRepository;

    @Override
    public List<Poder> findAllPoderes() throws IOException, SQLException {
        return poderRepository.findAll();

    }

    @Override
    public Optional<Poder> findByIdPoder(String name) {
        return poderRepository.findById(name);

    }

    @Override
    public Poder createPoder(Poder poder) {
        return poderRepository.save(poder);

    }

    @Override
    public Poder updatePoder(Poder poder) {
        return poderRepository.save(poder);

    }

    @Override
    public void deletePoder(String name){
        Poder poderEliminado = new Poder();
        poderEliminado.setName(name);
        poderRepository.delete(poderEliminado);

    }
}
