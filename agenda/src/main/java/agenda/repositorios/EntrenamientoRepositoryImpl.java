package agenda.repositorios;


import agenda.entidades.Entrenamiento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EntrenamientoRepositoryImpl implements EntrenamientoRepository {

    private final JdbcTemplate jdbcTemplate;

    public EntrenamientoRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Entrenamiento> obtenerTodos() {
        String sql ="SELECT duracion, tipo_arte FROM entrenamiento";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                new Entrenamiento(
                    rs.getString("duracion"),
                    rs.getString("tipo_arte")
                )
        );
    }

    @Override
    public Entrenamiento save(Entrenamiento entrenamiento) {
        String sql = "INSERT INTO entrenamiento (duracion, tipo_arte) VALUES (?,?)";
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
        String sql = "UPDATE entrenamiento SET duracion = ?, tipo_arte = ? WHERE id = ?";
        jdbcTemplate.update(sql, entrenamiento.getDuracion(), entrenamiento.getTipoArte(), id);
        return entrenamiento;
    }
}
