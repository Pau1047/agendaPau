package agenda.servicios;

import agenda.entidades.Entrenamiento;
import agenda.repositorios.EntrenamientoRepositoryImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EntrenamientoServiceImpl implements EntrenamientoService {
    private final JdbcTemplate jdbcTemplate;

    public EntrenamientoServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Entrenamiento> obtenerTodos() {
        String sql ="SELECT duracion, tipoArte FROM entrenamiento";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                new Entrenamiento(
                        rs.getString("duracion"),
                        rs.getString("tipoArte")
                )
        );
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        String sql = "INSERT INTO entrenamiento (duracion, tipoArte) VALUES (?,?,?)";
        jdbcTemplate.update(sql, entrenamiento.getDuracion(),entrenamiento.getTipoArte());
        System.out.println("Entrenamiento creado");
        return entrenamiento;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM entrenamiento WHERE id = ?";
        jdbcTemplate.update(sql,id);
        System.out.println("Entrenamiento borrado");
    }

    @Override
    public Entrenamiento modificarEntrenamiento(Long id, Entrenamiento entrenamiento) {
        String sql = "UPDATE entrenamiento SET duracion = ?, tipoArte = ? WHERE id = ?";
        jdbcTemplate.update(sql, entrenamiento.getDuracion(), entrenamiento.getTipoArte());
        return entrenamiento;
    }
}
