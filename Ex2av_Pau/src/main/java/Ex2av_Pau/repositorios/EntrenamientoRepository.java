package Ex2av_Pau.repositorios;

import Ex2av_Pau.entidades.Entrenamiento;

import java.util.List;

public interface EntrenamientoRepository {
    List<Entrenamiento> obtenerTodos();

    Entrenamiento save(Entrenamiento entrenamiento);
    void delete(Long id);

    Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento);
}
