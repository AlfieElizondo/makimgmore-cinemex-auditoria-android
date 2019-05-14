package mx.com.dgom.cinemex.android.auditoria.app;

import java.util.List;

import mx.com.dgom.cinemex.android.auditoria.app.protocol.Audit;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditPlan;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Question;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.User;
import mx.com.dgom.cinemex.android.auditoria.app.to.AuditAreaStatus;

public class AppData {

    public static User usuarioLogueado = null;
    public static String token = null;



    public static void logout(){
        AppData.usuarioLogueado = null;
        AppData.token = null;
    }


}
