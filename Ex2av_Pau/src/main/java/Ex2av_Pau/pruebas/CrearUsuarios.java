package Ex2av_Pau.pruebas;


import Ex2av_Pau.entidades.Rol;
import Ex2av_Pau.entidades.Usuario;
import Ex2av_Pau.security.Constans;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class CrearUsuarios {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        CrearUsuarios.crearUsuario(new Usuario("Pau", "prueba", Rol.ADMIN.getRol()));
        CrearUsuarios.crearUsuario(new Usuario("Andrei", "1234", Rol.ENTRENADOR.getRol()));
        CrearUsuarios.crearUsuario(new Usuario("Hector", "hector", Rol.USER.getRol()));
        CrearUsuarios.mirarTodosLosUsers();
    }
    private static void crearUsuario(Usuario newUser) {
        try {
            restTemplate.postForObject(Constans.SIGNUP_URL, newUser, Usuario.class);
            System.out.println("Nuevo user creada");
        } catch (HttpServerErrorException errorException$InternalServerError) {
            System.out.println("Ya hay un usuario con ese username");
        }

    }

    private static void mirarTodosLosUsers() {
        ResponseEntity<String> responseAll = restTemplate.getForEntity(Constans.SIGNUP_URL, String.class);
        System.out.println(responseAll.getBody());
    }


}
