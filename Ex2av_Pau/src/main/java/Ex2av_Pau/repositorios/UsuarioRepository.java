package Ex2av_Pau.repositorios;

import Ex2av_Pau.entidades.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void save(Usuario usuario);
    List<Usuario> getUsuarios();
}
