package Ex2av_Pau.pruebas;

import Ex2av_Pau.entidades.ArteMarcial;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GinmasioPrueba {
    private static final String BASE_URL = "http://localhost:8080/arte_marcial";

    public static void main(String[] args) {

        ArteMarcial nuevaArte = new ArteMarcial("rubwen", "casaruben","easy");
        GinmasioPrueba cliente = new GinmasioPrueba();
        cliente.realizarPruebas(nuevaArte);
    }

    public void realizarPruebas(ArteMarcial nuevaArte) {
        listarArteMarcial();

        nuevaArte = agregarArte(nuevaArte);
        System.out.println("Arte agregado: " + nuevaArte);



        ArteMarcial a = new ArteMarcial("Muay Thai", "LightContact","sergwer");
        modificarArteMarcial(2L,a);

        listarArteMarcial();
    }

    private ArteMarcial agregarArte(ArteMarcial arteMarcial) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArteMarcial> response = restTemplate.postForEntity(BASE_URL, arteMarcial, ArteMarcial.class);
        return response.getBody();
    }

    private ArteMarcial modificarArteMarcial(Long id, ArteMarcial arteMarcial) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ArteMarcial> requestEntity = new HttpEntity<>(arteMarcial, headers);

        ResponseEntity<ArteMarcial> response = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, requestEntity, ArteMarcial.class);

        return response.getBody();
    }


    private void listarArteMarcial() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArteMarcial[]> response = restTemplate.getForEntity(BASE_URL, ArteMarcial[].class);
        ArteMarcial[] artes = response.getBody();
        System.out.println("Lista de artes marciales:");
        for (ArteMarcial arteMarcial : artes) {
            System.out.println(arteMarcial.toString());
        }
    }

    private void obtenerArteMarcialPorId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ArteMarcial arteMarcial = restTemplate.getForObject(BASE_URL + "/" + id, ArteMarcial.class);
        System.out.println("Arte obtenido por ID: " + arteMarcial);
    }


    private void eliminarArteMarcial(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL + "/" + id);
        System.out.println("Arte eliminado con ID: " + id);
    }
}
