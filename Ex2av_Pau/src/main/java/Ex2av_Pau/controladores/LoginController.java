package Ex2av_Pau.controladores;

import Ex2av_Pau.entidades.Usuario;
import Ex2av_Pau.repositorios.UsuarioRepository;
import Ex2av_Pau.security.JWTAuthenticationConfig;
import Ex2av_Pau.security.PasswordEncryptor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;


    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping("/login")
    public String login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) throws BadRequestException {


        List<Usuario> usuarios = usuarioRepository.getUsuarios();


        Usuario usuarioEncontrado = null;


        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) &&
                    PasswordEncryptor.decrypt(usuario.getEncryptedPass()).equals(encryptedPass)) {
                usuarioEncontrado = usuario;
                break;
            }
        }


        if (usuarioEncontrado == null) {
            throw new BadRequestException();
        }


        String token = jwtAuthtenticationConfig.getJWTToken(usuarioEncontrado.getUsername(), usuarioEncontrado.getRol());


        return token;


    }
}

