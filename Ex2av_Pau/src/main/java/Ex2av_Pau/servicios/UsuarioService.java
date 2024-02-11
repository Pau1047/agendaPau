package Ex2av_Pau.servicios;

import Ex2av_Pau.entidades.Usuario;

import java.util.List;

public interface UsuarioService {
    void save(Usuario usuario);
    List<Usuario> getUsuarios();
}
