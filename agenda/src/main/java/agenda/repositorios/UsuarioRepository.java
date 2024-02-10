package agenda.repositorios;

import agenda.entidades.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void save(Usuario usuario);
    List<Usuario> getUsuarios();
}
