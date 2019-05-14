package mx.com.dgom.cinemex.android.auditoria.app.protocol;

public class User {
    private int id_auditor;
    private String uuid;
    private String txt_nombre;
    private String txt_correo;
    private int b_habilitado;

    public int getId_auditor() {
        return id_auditor;
    }

    public void setId_auditor(int id_auditor) {
        this.id_auditor = id_auditor;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(String txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public String getTxt_correo() {
        return txt_correo;
    }

    public void setTxt_correo(String txt_correo) {
        this.txt_correo = txt_correo;
    }

    public int getB_habilitado() {
        return b_habilitado;
    }

    public void setB_habilitado(int b_habilitado) {
        this.b_habilitado = b_habilitado;
    }
}
