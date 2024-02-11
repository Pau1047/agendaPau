package Ex2av_Pau.entidades;

public class Entrenamiento {
    private Long id;
    private String duracion;
    private String tipoArte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipoArte() {
        return tipoArte;
    }

    public void setTipoArte(String tipoArte) {
        this.tipoArte = tipoArte;
    }

    public Entrenamiento(String duracion, String tipoArte) {
        this.duracion = duracion;
        this.tipoArte = tipoArte;
    }

    @Override
    public String toString() {
        return "Entrene : duración = " + duracion  + ", tipo de arte = " + tipoArte;
    }
}
