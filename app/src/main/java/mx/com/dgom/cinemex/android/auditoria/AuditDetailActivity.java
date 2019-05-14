package mx.com.dgom.cinemex.android.auditoria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mx.com.dgom.cinemex.android.auditoria.app.AppActivityExtension;
import mx.com.dgom.cinemex.android.auditoria.app.AppController;
import mx.com.dgom.cinemex.android.auditoria.app.AppData;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Audit;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditPlan;

public class AuditDetailActivity extends AppActivityExtension {

    private static final String TAG = "AuditDetailActivity";

    private AuditPlan auditPlan;
    private Audit audit;

    private TextView txtComplejo;
    private TextView txtFecha;
    private TextView txtDireccion;
    private TextView txtCuestionario;
    private TextView txtEstatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_detail);

        Intent intent = getIntent();
        if(intent.getSerializableExtra("AUDIT_PLAN") != null) {
            auditPlan = (AuditPlan) intent.getSerializableExtra("AUDIT_PLAN");
        }


        txtComplejo = findViewById(R.id.txt_complejo_auditoria);
        txtFecha  = findViewById(R.id.txt_fecha_auditoria);
        txtDireccion = findViewById(R.id.txt_direccion_complejo);
        txtCuestionario  = findViewById(R.id.txt_nombre_cuestionario);
        txtEstatus = findViewById(R.id.txt_estatus_auditoria);

        txtCuestionario.setText(auditPlan.getId_cuestionario().getTxt_nombre());
        txtComplejo.setText(auditPlan.getId_complejo().getTxt_nombre());
        txtFecha.setText(auditPlan.getFch_planeacion());
        txtEstatus.setText(auditPlan.getId_estado_auditoria());
        txtDireccion.setText(auditPlan.getId_complejo().getTxt_direccion());



    }


    public void initCuestionarioAction(View v){
        //Carga el cuestionario
        Intent intent = new Intent(AuditDetailActivity.this, AuditCheckListActivity.class);
        AppController.setAuditPlan(auditPlan,this);
        startActivity(intent);
    }




}
