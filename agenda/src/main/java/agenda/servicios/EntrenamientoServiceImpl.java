package agenda.servicios;

import agenda.entidades.Entrenamiento;
import agenda.repositorios.EntrenamientoRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EntrenamientoServiceImpl implements EntrenamientoService {
    private final EntrenamientoRepositoryImpl entrenamientoRepository;

    public EntrenamientoServiceImpl(EntrenamientoRepositoryImpl entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }

    @Override
    public List<Entrenamiento> obtenerTodos() {
        return entrenamientoRepository.obtenerTodos();
    }

    @Override
    public Entrenamiento getId(Long id) {
        return entrenamientoRepository.getId(id);
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        return entrenamientoRepository.save(entrenamiento);
    }

    @Override
    public void delete(Long id) {
        entrenamientoRepository.delete(id);
    }

    @Override
    public Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento) {
        return entrenamientoRepository.modificarEntrenamiento(id,entrenamiento);
    }
}
