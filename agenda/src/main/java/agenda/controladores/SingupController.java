package agenda.controladores;


import agenda.entidades.Usuario;
import agenda.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SingupController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("signup")
    public void signup(
            @RequestBody Usuario usuario) {
                usuarioService.save(usuario);
    }

    @GetMapping("signup")
    public List<Usuario> obtenerTodos() {
        return usuarioService.getUsuarios();
    }

}
