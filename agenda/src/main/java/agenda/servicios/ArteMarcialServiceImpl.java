package agenda.servicios;

import agenda.entidades.ArteMarcial;
import agenda.repositorios.ArteMarcialRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArteMarcialServiceImpl implements ArteMarcialService {
    private final JdbcTemplate jdbcTemplate;

    public ArteMarcialServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<ArteMarcial> obtenerTodos() {
        String sql = "SELECT nombre, paisOriginario, dificultad FROM arte_marcial";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                new ArteMarcial(
                        rs.getString("nombre"),
                        rs.getString("paisOriginario"),
                        rs.getString("dificultad")
                )
        );
    }

    @Override
    public ArteMarcial save(ArteMarcial arteMarcial) {
        String sql = "INSERT INTO arte_marcial (nombre, paisOriginario, dificultad) VALUES (?,?,?)";
        jdbcTemplate.update(sql, arteMarcial.getNombre(), arteMarcial.getPaisOriginario(), arteMarcial.getDificultad());
        System.out.println("Arte Marcial creada");
        return arteMarcial;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM arte_marcial WHERE id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Arte marcial eliminada");
    }

    @Override
    public ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial) {
        String sql = "UPDATE arte_marcial SET nombre = ?, paisOriginario = ?, dificultad = ? WHERE id = ?";
        jdbcTemplate.update(sql, arteMarcial.getNombre(), arteMarcial.getPaisOriginario(), arteMarcial.getDificultad());
        System.out.println("Cambiando el arte marcial con el id = " + id);
        return arteMarcial;
    }
}
