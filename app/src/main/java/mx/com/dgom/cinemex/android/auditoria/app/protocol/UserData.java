package mx.com.dgom.cinemex.android.auditoria.app.protocol;

public class UserData {
    private String token;
    private User usuario;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
