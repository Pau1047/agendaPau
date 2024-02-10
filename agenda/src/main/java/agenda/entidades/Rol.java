package agenda.entidades;
public enum Rol {
    ADMIN("ADMIN"),
    USER("USER"),
    ENTRENADOR("COACH");


    private final String rol;


    Rol(String rol) {
        this.rol = rol;
    }


    public String getRol() {
        return rol;
    }
}
