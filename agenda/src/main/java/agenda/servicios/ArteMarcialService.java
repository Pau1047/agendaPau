package agenda.servicios;

import agenda.entidades.ArteMarcial;

import java.util.List;

public interface ArteMarcialService {
    List<ArteMarcial> obtenerTodos();
    ArteMarcial getId(Long id);
    ArteMarcial save(ArteMarcial arteMarcial);
    void delete(Long id);

    ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial);
}
