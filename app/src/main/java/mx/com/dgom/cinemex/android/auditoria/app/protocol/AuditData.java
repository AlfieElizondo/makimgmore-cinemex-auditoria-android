package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuditData implements Serializable {

    private Cuestionario auditoria;
    private Question preguntas[];
    private ResponseOption opciones[];

    public Cuestionario getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Cuestionario auditoria) {
        this.auditoria = auditoria;
    }


    public Question[] getPreguntas() {
        return preguntas;
    }


    public List<Question> getPreguntasByArea(AuditArea area) {
        ArrayList<Question> res = new ArrayList<>();
        for (Question item:preguntas) {
            if(item.getId_area_evaluacion().getUuid().equals(area.getUuid())){
                res.add(item);
            }
        }

        return res;
    }

    public void setPreguntas(Question[] preguntas) {
        this.preguntas = preguntas;
    }

    public ResponseOption[] getOpciones() {
        return opciones;
    }

    public void setOpciones(ResponseOption[] opciones) {
        this.opciones = opciones;
    }

}


