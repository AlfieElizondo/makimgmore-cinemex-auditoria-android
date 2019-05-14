package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import com.google.gson.Gson;

public class CalendarResponse extends ListResponse{

    public static CalendarResponse parse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, CalendarResponse.class);
    }

    public AuditPlan[] getResults() {
        return results;
    }

    public void setResults(AuditPlan[] results) {
        this.results = results;
    }

    private AuditPlan[] results;
}


