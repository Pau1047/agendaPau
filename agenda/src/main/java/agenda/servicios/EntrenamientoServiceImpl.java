package agenda.servicios;

import agenda.entidades.Entrenamiento;
import agenda.repositorios.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EntrenamientoServiceImpl implements EntrenamientoService {
    @Autowired
    private final EntrenamientoRepository entrenamientoRepository;

    public EntrenamientoServiceImpl(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }


    @Override
    public List<Entrenamiento> obtenerTodos() {
        return entrenamientoRepository.obtenerTodos();
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
