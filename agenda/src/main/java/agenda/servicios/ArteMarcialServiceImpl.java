package agenda.servicios;

import agenda.entidades.ArteMarcial;
import agenda.repositorios.ArteMarcialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArteMarcialServiceImpl implements ArteMarcialService {
    @Autowired
    private final ArteMarcialRepository arteMarcialRepository;

    public ArteMarcialServiceImpl(ArteMarcialRepository arteMarcialRepository) {
        this.arteMarcialRepository = arteMarcialRepository;
    }


    @Override
    public List<ArteMarcial> obtenerTodos() {
        return arteMarcialRepository.obtenerTodos();
    }

    @Override
    public ArteMarcial save(ArteMarcial arteMarcial) {
        return arteMarcialRepository.save(arteMarcial);
    }

    @Override
    public void delete(Long id) {
        arteMarcialRepository.delete(id);
    }

    @Override
    public ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial) {
        return arteMarcialRepository.modificarArteMarcial(id,arteMarcial);
    }
}
