package agenda.pruebas;

import agenda.entidades.Entrenamiento;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class EntrenePrueba {
    private static final String BASE_URL = "http://localhost:8080/entrenamiento";

    public static void main(String[] args) {

        Entrenamiento nuevoentrene = new Entrenamiento("1h", "MMA");
        EntrenePrueba cliente = new EntrenePrueba();
        cliente.realizarPruebas(nuevoentrene);
    }

    public void realizarPruebas(Entrenamiento entrene) {
        listarEntrenes();

        entrene = agregarEntrene(entrene);
        System.out.println("Entrenamiento agregado: " + entrene);



        Entrenamiento entrenamiento = new Entrenamiento("1h", "kickboxing");
        modificarEntrene(2L,entrenamiento);

        listarEntrenes();
    }

    private Entrenamiento agregarEntrene(Entrenamiento entrenamiento) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Entrenamiento> response = restTemplate.postForEntity(BASE_URL, entrenamiento, Entrenamiento.class);
        return response.getBody();
    }

    private Entrenamiento modificarEntrene(Long id, Entrenamiento entrenamiento) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Entrenamiento> requestEntity = new HttpEntity<>(entrenamiento, headers);

        ResponseEntity<Entrenamiento> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, requestEntity, Entrenamiento.class);

        return response.getBody();
    }


    private void listarEntrenes() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Entrenamiento[]> response = restTemplate.getForEntity(BASE_URL, Entrenamiento[].class);
        Entrenamiento[] entrenes = response.getBody();
        System.out.println("Lista de entrenamientos:");
        for (Entrenamiento entrenamiento : entrenes) {
            System.out.println(entrenamiento.toString());
        }
    }


    private void eliminarEntreneamiento(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL + "/" + id);
        System.out.println("Entrene eliminado con ID: " + id);
    }
}
