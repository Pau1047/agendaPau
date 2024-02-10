package agenda.repositorios;

import agenda.entidades.Usuario;
import agenda.security.PasswordEncryptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements  UsuarioRepository{
    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, rol) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getUsername(), PasswordEncryptor.encrypt(usuario.getEncryptedPass()), usuario.getRol());
    }

    @Override
    public List<Usuario> getUsuarios() {
        String sql = "SELECT username, password, rol FROM Usuario";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Usuario(
                        rs.getString("username"),
                        PasswordEncryptor.decrypt(rs.getString("password")),
                        rs.getString("rol")
                )
        );
    }
}
