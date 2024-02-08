package agenda;

import agenda.entidades.ArteMarcial;
import agenda.entidades.Contacto;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GinmasioPrueba {
    private static final String BASE_URL = "http://localhost:8080/artesmarciales";

    public static void main(String[] args) {
        // Crea un nuevo contacto para agregar
        ArteMarcial nuevaArte = new ArteMarcial("Muay Thai", "LightContact");

        // Ejecuta el cliente de prueba
        GinmasioPrueba cliente = new GinmasioPrueba();
        cliente.realizarPruebas(nuevaArte);
    }

    public void realizarPruebas(ArteMarcial nuevaArte) {
        listarArteMarcial();

        // Agrega un nuevo contacto
        nuevaArte = agregarArte(nuevaArte);
        System.out.println("Arte agregado: " + nuevaArte);

        // Obtiene todos los contactos
        listarArteMarcial();

        // Obtiene un contacto por ID
        obtenerArteMarcialPorId(nuevaArte.getId());

        // Obtiene todos los contactos después de la actualización
        listarArteMarcial();

        // Obtiene un contacto por ID
        ArteMarcial a = new ArteMarcial("Muay Thai", "LightContact");
        modificarArteMarcial(1L,a);

        // Obtiene todos los contactos después de la actualización
        listarArteMarcial();

        // Elimina un contacto por ID
        eliminarArteMarcial(a.getId());

        // Obtiene todos los contactos después de la eliminación
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