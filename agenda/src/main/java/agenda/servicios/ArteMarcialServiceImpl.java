package agenda.servicios;

import agenda.entidades.ArteMarcial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArteMarcialServiceImpl implements ArteMarcialService {
    private final ArteMarcialServiceImpl arteMarcialService;

    public ArteMarcialServiceImpl(ArteMarcialServiceImpl arteMarcialService) {
        this.arteMarcialService = arteMarcialService;
    }

    @Override
    public List<ArteMarcial> obtenerTodos() {
        return arteMarcialService.obtenerTodos();
    }

    @Override
    public ArteMarcial save(ArteMarcial arteMarcial) {
        return arteMarcialService.save(arteMarcial);
    }

    @Override
    public void delete(Long id) {
        arteMarcialService.delete(id);
    }

    @Override
    public ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial) {
        return arteMarcialService.modificarArteMarcial(id,arteMarcial);
    }
}
