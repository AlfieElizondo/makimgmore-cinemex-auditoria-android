package mx.com.dgom.cinemex.android.auditoria.app.to;

import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditArea;

public class AuditAreaStatus {

    private AuditArea area;
    private boolean status;

    public AuditAreaStatus(AuditArea area, boolean status){
        this.area = area;
        this.status = status;
    }

    public AuditArea getArea() {
        return area;
    }

    public void setArea(AuditArea area) {
        this.area = area;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
