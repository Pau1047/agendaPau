package agenda.servicios;

import agenda.entidades.Entrenamiento;

import java.util.List;

public interface EntrenamientoService {
    List<Entrenamiento> obtenerTodos();

    Entrenamiento save(Entrenamiento entrenamiento);
    void delete(Long id);

    Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento);
}
