package agenda.entidades;

public class ArteMarcial {
    private Long id;
    private String nombre;
    private String modalidad;

    public ArteMarcial(String nombre,String modalidad){
        this.nombre=nombre;
        this.modalidad=modalidad;
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public String toString() {
        return "Arte marcial:" + " id = " + id + ", nombre = " + nombre  + ", modalidad = " + modalidad;
    }
}
