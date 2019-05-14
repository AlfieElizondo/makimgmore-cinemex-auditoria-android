package mx.com.dgom.cinemex.android.auditoria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Arrays;

import mx.com.dgom.cinemex.android.auditoria.adapters.CalendarAdapter;
import mx.com.dgom.cinemex.android.auditoria.app.AppActivityExtension;
import mx.com.dgom.cinemex.android.auditoria.app.AppController;
import mx.com.dgom.cinemex.android.auditoria.app.AppControllerNetwork;
import mx.com.dgom.cinemex.android.auditoria.app.AppData;
import mx.com.dgom.cinemex.android.auditoria.app.JSONRespInterface;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditPlan;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.CalendarResponse;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.MessageResponse;

public class MainActivity extends AppActivityExtension {

    private static final String TAG = "MainActivity";
    private AppControllerNetwork controller = new AppControllerNetwork();

    private CalendarResponse list;
    private CalendarAdapter adapter;
    private ListView listCalendario;
    private ArrayList<AuditPlan> auditPlanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCalendario = findViewById(R.id.tbl_calendario);
        adapter = new CalendarAdapter(this, new ArrayList<AuditPlan>());
        listCalendario.setAdapter(adapter);



        listCalendario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                AuditPlan ap = auditPlanList.get(index);
                Intent intent = new Intent(MainActivity.this, AuditDetailActivity.class);
                intent.putExtra("AUDIT_PLAN", ap);
                startActivity(intent);
            }
        });


        getCalendario();

        //Verifica si hay alguna auditoria en proceso
        Long idAuditoria = AppController.getActualAudit(this);
        if(idAuditoria > 0){
            Toast.makeText(this,R.string.there_is_an_audit_in_progress, Toast.LENGTH_LONG).show();
        }
    }

    public void iniciarAuditoriaAction(View v){
        Intent intent = new Intent(MainActivity.this, AuditCheckListActivity.class);
        startActivity(intent);
    }


    private void getCalendario(){
        addCover();
        controller.getCalendario(this, new JSONRespInterface() {
            public void stringErrorResp(String json) {
                Log.d(TAG, "json");
                MessageResponse mr = MessageResponse.parse(json);
                removeCover();
                Toast.makeText(MainActivity.this, mr.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void stringResp(String json) {
                Log.d(TAG, "json");
                CalendarResponse list = CalendarResponse.parse(json);

                auditPlanList = new ArrayList<AuditPlan>( Arrays.asList(list.getResults()));
                adapter.setDatos(auditPlanList);
                removeCover();
            }

            @Override
            public void noInternetError(String msg) {
                Log.d(TAG, "json");
                removeCover();
                Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void newSessionRequired() {
                AppData.logout();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
                removeCover();

            }
        });
    }
}
