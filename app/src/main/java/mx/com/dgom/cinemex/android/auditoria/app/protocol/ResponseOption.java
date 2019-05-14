package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;

public class ResponseOption implements Serializable {
    private int id_opcion_respuesta;
    private String uuid;
    private String token;
    private String txt_nombre;
    private String txt_descripcion;
    private int b_critico;
    private int b_habilitado;

    public int getId_opcion_respuesta() {
        return id_opcion_respuesta;
    }

    public void setId_opcion_respuesta(int id_opcion_respuesta) {
        this.id_opcion_respuesta = id_opcion_respuesta;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(String txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public String getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(String txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    public int getB_critico() {
        return b_critico;
    }

    public void setB_critico(int b_critico) {
        this.b_critico = b_critico;
    }

    public int getB_habilitado() {
        return b_habilitado;
    }

    public void setB_habilitado(int b_habilitado) {
        this.b_habilitado = b_habilitado;
    }
}
