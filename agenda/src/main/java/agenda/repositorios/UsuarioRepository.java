package agenda.repositorios;

import agenda.entidades.Rol;
import agenda.entidades.Usuario;
import agenda.security.PasswordEncryptor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    public List<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
        usuarios.add(new Usuario("pau", PasswordEncryptor.encrypt("1234"), Rol.ENTRENADOR));
        usuarios.add(new Usuario("hector", PasswordEncryptor.encrypt("1111"), Rol.USER));
        usuarios.add(new Usuario("admin", PasswordEncryptor.encrypt("1111"), Rol.ADMIN));
        return usuarios;
    }
}
