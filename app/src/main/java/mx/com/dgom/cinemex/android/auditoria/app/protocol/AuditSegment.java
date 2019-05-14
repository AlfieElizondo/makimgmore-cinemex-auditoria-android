package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;

public class AuditSegment  implements Serializable {
    private int id_segmento;
    private String uuid;
    private String txt_nombre;
    private String txt_descripcion;
    private int b_habilitado;

    public int getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(int id_segmento) {
        this.id_segmento = id_segmento;
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
