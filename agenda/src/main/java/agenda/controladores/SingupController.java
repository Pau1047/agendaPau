package agenda.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SingupController {
    @Autowired
    UserService userService;

    @PostMapping("signup")
    public void signup(
            @RequestBody Usuario user) {
        userService.saveUser(user);
    }

    @GetMapping("signup")
    public List<Usuario> obtenerTodos() {
        return userService.getUsuarios();
    }

}
