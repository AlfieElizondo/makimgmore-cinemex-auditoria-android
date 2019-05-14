package mx.com.dgom.cinemex.android.auditoria;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import mx.com.dgom.cinemex.android.auditoria.app.AppActivityExtension;
import mx.com.dgom.cinemex.android.auditoria.app.AppConstantes;
import mx.com.dgom.cinemex.android.auditoria.app.AppController;
import mx.com.dgom.cinemex.android.auditoria.app.AppData;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Question;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.ResponseOption;

public class AuditQuestionActivity extends AppActivityExtension {


    private Question question;

    HashMap<Integer,ResponseOption> spinnerMap;

    TextView txtArea;
    TextView txtSegmento;
    TextView txtPregunta;
    TextView txtDescripcion;
    TextView txtNumber;
    Spinner spinResponse;
    EditText txtNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_question);


        txtArea = findViewById(R.id.txt_area);
        txtSegmento = findViewById(R.id.txt_segmento);
        txtPregunta = findViewById(R.id.txt_question);
        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtNumber = findViewById(R.id.txt_number);
        spinResponse = findViewById(R.id.spin_respuesta);
        txtNotas = findViewById(R.id.txt_notas);

        setupSpinner();
        setupNetQuestion();

    }

    private void setupSpinner() {
        //Obtiene las opciones de respuesta
        ResponseOption[] opciones = AppController.getAudit().getData().getOpciones();


        String[] spinnerArray = new String[opciones.length + 1];
        spinnerMap = new HashMap<Integer, ResponseOption>();
        spinnerMap.put(0,null);
        spinnerArray[0] = "Seleccione una opción";

        for (int i = 0; i < opciones.length; i++)
        {
            spinnerMap.put(i + 1,opciones[i]);
            spinnerArray[i + 1] = opciones[i].getTxt_nombre();
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinResponse.setAdapter(adapter);
    }

    private ResponseOption getSelectedValue(){
        String name = spinResponse.getSelectedItem().toString();
        ResponseOption element = spinnerMap.get(spinResponse.getSelectedItemPosition());
        return element;
    }

    private void setupNetQuestion(){
        this.question = AppController.getNextQuestion();

        if(this.question == null){
            //TODO termina el proceso actual
            AppController.setAreaCuestionarioCompleta();
            finish();
            return;
        }

        setupUI();
    }




    private void setupUI(){
        txtArea.setText(question.getId_area_evaluacion().getTxt_nombre());
        txtSegmento.setText(question.getId_segmento().getTxt_nombre());
        txtPregunta.setText(question.getTxt_pregunta());
        txtDescripcion.setText(question.getTxt_descripcion());

        txtNumber.setText(AppController.getQuestionNumber() + "/" + AppController.getQuestionsCount());
    }



    public void nextQuestion(View v){

        if(txtNotas.getText().toString().trim().length() == 0){
            Toast.makeText(this,R.string.notes_required, Toast.LENGTH_SHORT).show();
            spinResponse.requestFocus();
            return;
        }

        if(getSelectedValue() == null){
            Toast.makeText(this,R.string.option_required, Toast.LENGTH_SHORT).show();
            spinResponse.requestFocus();
            return;
        }



        txtNotas.setText("");
        spinResponse.setSelection(0);

        txtNotas.setText("OK");
        spinResponse.setSelection(1);

        setupNetQuestion();
    }


}
