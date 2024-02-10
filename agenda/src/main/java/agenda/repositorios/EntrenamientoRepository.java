package agenda.repositorios;

import agenda.entidades.ArteMarcial;
import agenda.entidades.Entrenamiento;

import java.util.List;

public interface EntrenamientoRepository {
    List<Entrenamiento> obtenerTodos();
    Entrenamiento getId(Long id);
    Entrenamiento save(Entrenamiento entrenamiento);
    void delete(Long id);

    Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento);
}
