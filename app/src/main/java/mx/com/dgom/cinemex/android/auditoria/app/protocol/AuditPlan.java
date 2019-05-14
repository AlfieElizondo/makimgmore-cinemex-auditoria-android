package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;

public class AuditPlan implements Serializable {
    private int id_plan_auditoria;
    private String uuid;
    private Cuestionario id_cuestionario;
    private int id_auditor;
    private Complejo id_complejo;
    private String id_gerente;
    private String fch_planeacion;

    private String id_estado_auditoria;



    public String getFch_planeacion() {
        return fch_planeacion;
    }

    public void setFch_planeacion(String fch_planeacion) {
        this.fch_planeacion = fch_planeacion;
    }




    public int getId_plan_auditoria() {
        return id_plan_auditoria;
    }

    public void setId_plan_auditoria(int id_plan_auditoria) {
        this.id_plan_auditoria = id_plan_auditoria;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Cuestionario getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(Cuestionario id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public int getId_auditor() {
        return id_auditor;
    }

    public void setId_auditor(int id_auditor) {
        this.id_auditor = id_auditor;
    }

    public Complejo getId_complejo() {
        return id_complejo;
    }

    public void setId_complejo(Complejo id_complejo) {
        this.id_complejo = id_complejo;
    }

    public String getId_gerente() {
        return id_gerente;
    }

    public void setId_gerente(String id_gerente) {
        this.id_gerente = id_gerente;
    }

    public String getId_estado_auditoria() {
        return id_estado_auditoria;
    }

    public void setId_estado_auditoria(String id_estado_auditoria) {
        this.id_estado_auditoria = id_estado_auditoria;
    }
}


