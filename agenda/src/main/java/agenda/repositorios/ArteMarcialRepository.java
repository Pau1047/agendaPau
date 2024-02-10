package agenda.repositorios;

import agenda.entidades.ArteMarcial;

import java.util.List;

public interface ArteMarcialRepository {
    List<ArteMarcial> obtenerTodos();

    ArteMarcial save(ArteMarcial arteMarcial);
    void delete(Long id);

    ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial);
}
