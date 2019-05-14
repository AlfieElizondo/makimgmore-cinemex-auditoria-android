package mx.com.dgom.cinemex.android.auditoria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.dgom.cinemex.android.auditoria.adapters.AreasAdapter;
import mx.com.dgom.cinemex.android.auditoria.app.AppActivityExtension;
import mx.com.dgom.cinemex.android.auditoria.app.AppController;
import mx.com.dgom.cinemex.android.auditoria.app.AppControllerNetwork;
import mx.com.dgom.cinemex.android.auditoria.app.AppData;
import mx.com.dgom.cinemex.android.auditoria.app.JSONRespInterface;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.Audit;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditArea;
import mx.com.dgom.cinemex.android.auditoria.app.to.AuditAreaStatus;

public class AuditCheckListActivity extends AppActivityExtension {

    private static final String TAG = "AuditCheckListActivity";


    private ArrayList<AuditAreaStatus> areasStatus = new ArrayList<AuditAreaStatus>();
    private AreasAdapter adapter;


    private ListView listAreasAuditorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audit_check_list);

        listAreasAuditorias = findViewById(R.id.list_areas_auditoria);
        listAreasAuditorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AuditCheckListActivity.this, AuditQuestionActivity.class);
                AppController.setAreaCuestionario(areasStatus.get(i));
                startActivity(intent);
            }
        });



        adapter = new AreasAdapter(this,areasStatus);
        listAreasAuditorias.setAdapter(adapter);

        loadCuestionario();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setupTable(){
        ArrayList<AuditArea> areasStr = AppController.getAudit().getAreas();
        for (AuditArea item:areasStr) {
            areasStatus.add(new AuditAreaStatus(item, false));
        }
        adapter.setDatos(areasStatus);
    }


    private void loadCuestionario(){
        AppControllerNetwork controller = new AppControllerNetwork();
        addCover();
        controller.getCuestionario(AppController.getAuditPlan().getId_cuestionario().getUuid(), this, new JSONRespInterface() {
            @Override
            public void stringErrorResp(String json) {
                Log.d(TAG, "json");
                removeCover();
            }

            @Override
            public void stringResp(String json) {
                Log.d(TAG, "json");
                AppController.setAudit( Audit.parse(json) );
                setupTable();
                removeCover();
            }

            @Override
            public void noInternetError(String msg) {
                Log.d(TAG, "json");
                removeCover();
                Toast.makeText(AuditCheckListActivity.this,msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void newSessionRequired() {
                AppData.logout();
                Intent intent = new Intent(AuditCheckListActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
                removeCover();

            }
        });
    }
}
