package agenda.repositorios;

import agenda.entidades.ArteMarcial;
import agenda.entidades.Entrenamiento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntrenamientoRepositoryImpl implements EntrenamientoRepository {
    private  final Map<Long, Entrenamiento> entrenamientos = new HashMap<>();
    private Long idSecuencia = 1L;


    public EntrenamientoRepositoryImpl(){
        Entrenamiento entreneInicial = new Entrenamiento("1h", "mma");
        entreneInicial.setId(idSecuencia++);
        entrenamientos.put(entreneInicial.getId(), entreneInicial);
        System.out.println(entrenamientos.get(1L));
    }
    @Override
    public List<Entrenamiento> obtenerTodos() {
        return new ArrayList<>(entrenamientos.values());
    }

    @Override
    public Entrenamiento getId(Long id) {
        return entrenamientos.get(id);
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        if(entrenamiento.getId() == null){
            entrenamiento.setId(idSecuencia++);
        }
        return entrenamiento;
    }

    @Override
    public void delete(Long id) {
        entrenamientos.remove(id);
    }

    @Override
    public Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento) {
        entrenamientos.put(id,entrenamiento);
        return entrenamiento;
    }
}
