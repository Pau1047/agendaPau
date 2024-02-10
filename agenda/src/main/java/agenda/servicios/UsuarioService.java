package agenda.servicios;

import agenda.entidades.Usuario;

import java.util.List;

public interface UsuarioService {
    void save(Usuario usuario);
    List<Usuario> getUsuarios();
}
