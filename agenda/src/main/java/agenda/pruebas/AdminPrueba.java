package agenda.pruebas;


import agenda.entidades.ArteMarcial;
import agenda.security.Constans;
import org.springframework.http.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

class AdminPrueba {

    private final RestTemplate restTemplate = new RestTemplate();

    private String token;

    public AdminPrueba(String username, String password) {
        this.token = autentificarse(username, password);
    }



    private String autentificarse(String username, String password) {
        return restTemplate.postForObject(Constans.LOGIN_URL + "?user={username}&encryptedPass={encryptedPass}", null, String.class, username, password);
    }


    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.ADMIN_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Todos las artes");
        System.out.println(responseAll.getBody());
    }

    public void getAllbyID(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        ResponseEntity<String> responseAll = restTemplate.exchange(Constans.ADMIN_URL + "/" + id, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("artes con id: " + id);
        System.out.println(responseAll.getBody());

    }

    public void getById(Long id) {
        getAllbyID(id);
    }
    public void createNew(ArteMarcial arteMarcial) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<ArteMarcial> requestEntity = new HttpEntity<>(arteMarcial, headers);
        try {
            restTemplate.postForEntity(Constans.ADMIN_URL, requestEntity, Void.class);
            System.out.println("Nuevo arte marcial creada");
        } catch (HttpServerErrorException e) {
            System.out.println("Fallo al crear el nuevo arte ");
        }
    }
    public void actualiazarPorId(ArteMarcial newarte, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<ArteMarcial> requestEntity = new HttpEntity<>(newarte, headers);

        restTemplate.put(Constans.ADMIN_URL + "/" + id, requestEntity);
        System.out.println("ArteMarcial actualizada");
    }
    public void borrar(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constans.HEADER_AUTHORIZACION_KEY, token);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        restTemplate.exchange(Constans.ADMIN_URL + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        System.out.println("Arte borrado");
        System.out.println();
    }

    public static void main(String[] args) {
        AdminPrueba a = new AdminPrueba("Pau", "prueba");
        a.getAll();

    }
}