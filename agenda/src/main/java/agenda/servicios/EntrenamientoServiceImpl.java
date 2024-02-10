package agenda.servicios;

import agenda.entidades.Entrenamiento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EntrenamientoServiceImpl implements EntrenamientoService {
    private final EntrenamientoServiceImpl entrenamientoService;

    public EntrenamientoServiceImpl(EntrenamientoServiceImpl entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @Override
    public List<Entrenamiento> obtenerTodos() {
        return entrenamientoService.obtenerTodos();
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        return entrenamientoService.save(entrenamiento);
    }

    @Override
    public void delete(Long id) {
        entrenamientoService.delete(id);
    }

    @Override
    public Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento) {
        return entrenamientoService.modificarEntrenamiento(id,entrenamiento);
    }
}
