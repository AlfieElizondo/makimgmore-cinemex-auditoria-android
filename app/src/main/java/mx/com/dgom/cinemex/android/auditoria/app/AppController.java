package mx.com.dgom.cinemex.android.auditoria.app;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import mx.com.dgom.cinemex.android.auditoria.app.database.AuditDb;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Audit;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditPlan;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Question;
import mx.com.dgom.cinemex.android.auditoria.app.to.AuditAreaStatus;

import static android.content.Context.MODE_PRIVATE;

public class AppController {

    private static AuditPlan auditPlan;
    private static Audit audit;
    private static int questionIndex;
    private static AuditAreaStatus areaStatus;
    private static List<Question> questions;




    /**
     * Asinga el plan de auditoria
     * Inicializa la auditoria
     * @param ap
     */
    public static void setAuditPlan(AuditPlan ap, Context ctx){
        auditPlan = ap;

        //Crea la auditoria en la base de datos
        AuditDb audit = new AuditDb(ap.getUuid(),ap.getId_cuestionario().getUuid());
        audit.save();
        Long id = audit.getId();
        saveLongPreference(AppConstantes.SHARED_PREFS_AUDIT, id, ctx);
    }




    /**
     * Obtiene la Auditoria que se está trabajando
     * @param ctx
     * @return
     */
    public static long getActualAudit(Context ctx){
        return getLongPreference(AppConstantes.SHARED_PREFS_AUDIT, ctx);
    }


    public static AuditPlan getAuditPlan(){
        return auditPlan;
    }


    public static void setAudit(Audit audit){
        AppController.audit = audit;
    }
    public static Audit getAudit(){
        return audit;
    }

    /**
     * Recupera la siguiente pregunta
     * @return
     */
    public static Question getNextQuestion(){
        if(questionIndex < questions.size()) {
            return questions.get(questionIndex++);
        }

        return null;
    }

    /**
     * Recupera la siguiente pregunta
     * @return
     */
    public static Question getPrevQuestion(){
        return questions.get(--questionIndex);
    }

    public static int getQuestionsCount() {
        return questions.size();
    }

    public static int getQuestionNumber() {
        return questionIndex;
    }

    /**
     * Asigna el área con la que va a trabajar
     * @param auditAreaStatus
     */
    public static void setAreaCuestionario(AuditAreaStatus auditAreaStatus) {
        AppController.areaStatus = auditAreaStatus;
        AppController.questions = audit.getData().getPreguntasByArea(auditAreaStatus.getArea());
        questionIndex = 0;
    }

    public static void setAreaCuestionarioCompleta() {
        AppController.areaStatus.setStatus(true);
    }




    //------------ UTILS --------------------

    private static void saveLongPreference(String name, long value,Context ctx){
        SharedPreferences.Editor editor = ctx.getSharedPreferences(AppConstantes.SHARED_PREFS, MODE_PRIVATE).edit();
        editor.putLong(name, value);
        editor.apply();
    }


    private static long getLongPreference(String name,Context ctx){
        SharedPreferences prefs = ctx.getSharedPreferences(AppConstantes.SHARED_PREFS, MODE_PRIVATE);
        Long idAuditoria = prefs.getLong(name, -1);
        return idAuditoria;
    }
}
