package mx.com.dgom.cinemex.android.auditoria.app.database;

import com.orm.SugarRecord;

public class AuditDb extends SugarRecord {


    private String auditPlanUuid;
    private String cuestionarioUuid;
    private boolean completed;
    private Long timeStamp;
    private Long endTime;



    public AuditDb(String auditPlanUuid, String cuestionarioUuid){
        this.auditPlanUuid = auditPlanUuid;
        this.cuestionarioUuid = cuestionarioUuid;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getAuditPlanUuid() {
        return auditPlanUuid;
    }

    public void setAuditPlanUuid(String auditPlanUuid) {
        this.auditPlanUuid = auditPlanUuid;
    }

    public String getCuestionarioUuid() {
        return cuestionarioUuid;
    }

    public void setCuestionarioUuid(String cuestionarioUuid) {
        this.cuestionarioUuid = cuestionarioUuid;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
