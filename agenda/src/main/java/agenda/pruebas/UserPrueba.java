package agenda.pruebas;

import agenda.entidades.Entrenamiento;
import agenda.security.Constans;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class UserPrueba {
    private final RestTemplate restTemplate = new RestTemplate();

    private String token;

    public UserPrueba(String username, String password) {
        this.token = autentificarse(username, password);
    }



    public static void main(String[] args) {
        UserPrueba userPrueba = new UserPrueba("Hector", "hector");
        userPrueba.delete(2L);
        userPrueba.getAll();

    }

    private String autentificarse(String username, String password) {
        return restTemplate.postForObject(Constans.LOGIN_URL + "?user={username}&encryptedPass={encryptedPass}", null, String.class, username, password);
    }


    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.USER_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos los entrenes");
        System.out.println(responseAll.getBody());
    }

    public void getAllbyID(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.USER_URL + "/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Entrenes con id: " + id);
        System.out.println(responseAll.getBody());

    }

    public void getById(Long id) {
        getAllbyID(id);
    }

    public void update(Entrenamiento newentrene, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<Entrenamiento> requestEntity = new HttpEntity<>(newentrene, headers);

        restTemplate.put(Constans.USER_URL + "/" + id, requestEntity);
        System.out.println("Entrenamiento actualizada");
    }
    public void delete(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(Constans.USER_URL + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println("Entrenamiento borrado");
        System.out.println();
    }

}
