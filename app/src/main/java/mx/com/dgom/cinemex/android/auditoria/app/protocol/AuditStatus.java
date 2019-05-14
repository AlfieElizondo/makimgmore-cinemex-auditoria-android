package mx.com.dgom.cinemex.android.auditoria.app.protocol;

public class AuditStatus{
        private int id_estado_auditoria;
        private String uuid;
        private String token;
        private String txt_nombre;
        private String txt_descripcion;
        private int b_habilitado;

    public int getId_estado_auditoria() {
        return id_estado_auditoria;
    }

    public void setId_estado_auditoria(int id_estado_auditoria) {
        this.id_estado_auditoria = id_estado_auditoria;
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

    public int getB_habilitado() {
        return b_habilitado;
    }

    public void setB_habilitado(int b_habilitado) {
        this.b_habilitado = b_habilitado;
    }
}
