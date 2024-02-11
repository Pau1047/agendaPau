package Ex2av_Pau.entidades;
public class Usuario {
    String username;
    String encryptedPass;
    String rol;


    public Usuario(String username, String encryptedPass, String rol) {
        this.username = username;
        this.encryptedPass = encryptedPass;
        this.rol = rol;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEncryptedPass() {
        return encryptedPass;
    }


    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", encryptedPass='" + encryptedPass + '\'' +
                ", rol=" + rol +
                '}';
    }
}
