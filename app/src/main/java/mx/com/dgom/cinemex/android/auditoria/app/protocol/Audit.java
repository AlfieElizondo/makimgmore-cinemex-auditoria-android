package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class Audit extends MessageResponse implements Serializable {

    private AuditData data;



    public static Audit parse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Audit.class);
    }

    public AuditData getData() {
        return data;
    }

    public void setData(AuditData data) {
        this.data = data;
    }


    public ArrayList<AuditArea> getAreas(){
        ArrayList<AuditArea> res = new ArrayList<>();
        Question[] lista = data.getPreguntas();
        AuditArea name;
        for (Question item:lista) {
            name = item.getId_area_evaluacion();
            if(!res.contains(name)){
                res.add(name);
            }
        }

        return res;
    }
}


