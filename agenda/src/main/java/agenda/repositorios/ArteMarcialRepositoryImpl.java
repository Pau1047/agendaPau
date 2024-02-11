package agenda.repositorios;

import agenda.entidades.ArteMarcial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ArteMarcialRepositoryImpl implements ArteMarcialRepository{
        private final JdbcTemplate jdbcTemplate;

        public ArteMarcialRepositoryImpl(JdbcTemplate jdbcTemplate){
            this.jdbcTemplate=jdbcTemplate;
        }

    @Override
    public List<ArteMarcial> obtenerTodos() {
        String sql = "SELECT nombre, pais_originario, dificultad FROM arte_marcial";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                new ArteMarcial(
                        rs.getString("nombre"),
                        rs.getString("pais_originario"),
                        rs.getString("dificultad")
                )
        );
    }

    @Override
    public ArteMarcial save(ArteMarcial arteMarcial) {
            String sql = "INSERT INTO arte_marcial (nombre, pais_originario, dificultad) VALUES (?,?,?)";
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
            String sql = "UPDATE arte_marcial SET nombre = ?, pais_originario = ?, dificultad = ? WHERE id = ?";
            jdbcTemplate.update(sql, arteMarcial.getNombre(), arteMarcial.getPaisOriginario(), arteMarcial.getDificultad(), id);
            System.out.println("Cambiando el arte marcial con el id = " + id);
            return arteMarcial;
    }
}
