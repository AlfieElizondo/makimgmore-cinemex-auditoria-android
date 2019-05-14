package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;

public class Question implements Serializable {
    private int id_pregunta;
    private String uuid;
    private int id_cuestionario;
    private AuditSegment id_segmento;
    private AuditArea id_area_evaluacion;
    private String txt_pregunta;
    private String txt_descripcion;
    private int b_requerida;


    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public AuditSegment getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(AuditSegment id_segmento) {
        this.id_segmento = id_segmento;
    }

    public AuditArea getId_area_evaluacion() {
        return id_area_evaluacion;
    }

    public void setId_area_evaluacion(AuditArea id_area_evaluacion) {
        this.id_area_evaluacion = id_area_evaluacion;
    }

    public String getTxt_pregunta() {
        return txt_pregunta;
    }

    public void setTxt_pregunta(String txt_pregunta) {
        this.txt_pregunta = txt_pregunta;
    }

    public String getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(String txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    public int getB_requerida() {
        return b_requerida;
    }

    public void setB_requerida(int b_requerida) {
        this.b_requerida = b_requerida;
    }
}
