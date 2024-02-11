package Ex2av_Pau.servicios;

import Ex2av_Pau.entidades.Usuario;
import Ex2av_Pau.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private final UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.getUsuarios();
    }
}
