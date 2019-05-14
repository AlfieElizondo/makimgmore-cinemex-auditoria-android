package mx.com.dgom.cinemex.android.auditoria.app.database;


import com.orm.SugarRecord;

public class AuditEvaluationDb extends SugarRecord {



    private AuditDb audit;
    private String preguntaUuid;
    private String respuestaUuid;
    private String notas;
    private long timeStamp;


    public AuditEvaluationDb(AuditDb audit, String preguntaUuid, String respuestaUuid, String notas){
        this.audit = audit;
        this.preguntaUuid = preguntaUuid;
        this.respuestaUuid = respuestaUuid;
        this.notas = notas;
        this.timeStamp = System.currentTimeMillis();
    }



    public AuditDb getAudit() {
        return audit;
    }

    public void setAudit(AuditDb audit) {
        this.audit = audit;
    }

    public String getPreguntaUuid() {
        return preguntaUuid;
    }

    public void setPreguntaUuid(String preguntaUuid) {
        this.preguntaUuid = preguntaUuid;
    }

    public String getRespuestaUuid() {
        return respuestaUuid;
    }

    public void setRespuestaUuid(String respuestaUuid) {
        this.respuestaUuid = respuestaUuid;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
