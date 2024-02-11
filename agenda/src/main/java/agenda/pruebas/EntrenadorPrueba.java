package agenda.pruebas;

import agenda.entidades.ArteMarcial;
import agenda.entidades.Entrenamiento;
import agenda.security.Constans;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class EntrenadorPrueba {
    private final RestTemplate restTemplate = new RestTemplate();

    private String token;

    public EntrenadorPrueba(String username, String password) {
        this.token = autentificarse(username, password);
    }



    public static void main(String[] args) {
        EntrenadorPrueba coach = new EntrenadorPrueba("Andrei", "1234");
        coach.create(new Entrenamiento("2h","boxeo"));
        coach.getAll();

    }

    private String autentificarse(String username, String password) {
        return restTemplate.postForObject(Constans.LOGIN_URL + "?user={username}&encryptedPass={encryptedPass}", null, String.class, username, password);
    }


    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.ENTRENADOR_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos los entrenes");
        System.out.println(responseAll.getBody());
    }

    public void getAllbyID(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.ENTRENADOR_URL + "/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Entrenes con id: " + id);
        System.out.println(responseAll.getBody());

    }

    public void getById(Long id) {
        getAllbyID(id);
    }
    public void create(Entrenamiento entrenamiento) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Entrenamiento> requestEntity = new HttpEntity<>(entrenamiento, headers);
        try {
            restTemplate.postForEntity(Constans.ENTRENADOR_URL, requestEntity, Void.class);
            System.out.println("Nuevo entrenamiento creado");
        } catch (HttpServerErrorException e) {
            System.out.println("Fallo al crear el nuevo entrenamiento ");
        }
    }
    public void update(Entrenamiento newentrene, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Entrenamiento> requestEntity = new HttpEntity<>(newentrene, headers);

        restTemplate.put(Constans.ENTRENADOR_URL + "/" + id, requestEntity);
        System.out.println("Entrenamiento actualizada");
    }
    public void delete(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(Constans.ENTRENADOR_URL + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println("Entrenamiento borrado");
        System.out.println();
    }

}
