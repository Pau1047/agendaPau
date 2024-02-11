package Ex2av_Pau.servicios;

import Ex2av_Pau.entidades.ArteMarcial;

import java.util.List;

public interface ArteMarcialService {
    List<ArteMarcial> obtenerTodos();

    ArteMarcial save(ArteMarcial arteMarcial);
    void delete(Long id);

    ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial);
}
