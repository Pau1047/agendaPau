package Ex2av_Pau.repositorios;

import Ex2av_Pau.entidades.ArteMarcial;

import java.util.List;

public interface ArteMarcialRepository {
    List<ArteMarcial> obtenerTodos();

    ArteMarcial save(ArteMarcial arteMarcial);
    void delete(Long id);


    ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial);
}
