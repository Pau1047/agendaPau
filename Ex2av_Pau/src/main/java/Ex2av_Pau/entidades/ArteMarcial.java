package Ex2av_Pau.entidades;

public class ArteMarcial {
    private Long id;
    private String nombre;
    private String paisOriginario;
    private String dificultad;

    public ArteMarcial(String nombre,String paisOriginario,String dificultad){
        this.nombre=nombre;
        this.paisOriginario=paisOriginario;
        this.dificultad=dificultad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOriginario() {
        return paisOriginario;
    }

    public void setPaisOriginario(String paisOriginario) {
        this.paisOriginario = paisOriginario;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Arte marcial:" + ", nombre = " + nombre  + ", pais originario = " + paisOriginario + ", dificultad = " + dificultad;
    }
}
