package agenda.pruebas;


import agenda.entidades.Rol;
import agenda.entidades.Usuario;
import agenda.security.Constans;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class CrearUsers {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        CrearUsers.crearUser(new Usuario("Pau", "prueba", Rol.ADMIN.getRol()));
        CrearUsers.crearUser(new Usuario("Andrei", "1234", Rol.ENTRENADOR.getRol()));
        CrearUsers.crearUser(new Usuario("Hector", "hector", Rol.USER.getRol()));
        CrearUsers.mirarTodosLosUsers();
    }
    private static void crearUser(Usuario newUser) {
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
