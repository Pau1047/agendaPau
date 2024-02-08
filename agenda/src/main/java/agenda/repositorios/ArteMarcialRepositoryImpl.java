package agenda.repositorios;

import agenda.entidades.ArteMarcial;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ArteMarcialRepositoryImpl implements ArteMarcialRepository{
    private  final Map<Long,ArteMarcial> artesMarciales = new HashMap<>();
    private Long idSecuencia = 1L;


    public ArteMarcialRepositoryImpl(){
        ArteMarcial arteInicial = new ArteMarcial("Kickboxing", "kicklight");
        arteInicial.setId(idSecuencia++);
        artesMarciales.put(arteInicial.getId(), arteInicial);
        System.out.println(artesMarciales.get(1L));
    }

    @Override
    public List<ArteMarcial> obtenerTodos() {
        return new ArrayList<>(artesMarciales.values());
    }

    @Override
    public ArteMarcial getId(Long id) {
        return artesMarciales.get(id);
    }

    @Override
    public ArteMarcial save(ArteMarcial arteMarcial) {
        if (arteMarcial.getId() == null){
            arteMarcial.setId(idSecuencia++);
        }
        artesMarciales.put(arteMarcial.getId(),arteMarcial);
        return arteMarcial;
    }

    @Override
    public void delete(Long id) {
        artesMarciales.remove(id);
    }

    @Override
    public ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial) {
        artesMarciales.put(id,arteMarcial);
        return arteMarcial;
    }
}
