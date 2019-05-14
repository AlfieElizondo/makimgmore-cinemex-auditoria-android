package mx.com.dgom.cinemex.android.auditoria.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mx.com.dgom.cinemex.android.auditoria.R;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.AuditPlan;

public class CalendarAdapter extends ArrayAdapter {

    private Context context;

    private ArrayList<AuditPlan> datos;



    public CalendarAdapter(Context context, ArrayList<AuditPlan> arrayList) {
        super(context, R.layout.row_audit_plan, arrayList);
        this.context = context;
        this.datos = arrayList;
    }


    public int getCount() {
        return this.datos.size();
    }

    public Object getItem(int index) {
        return this.datos.get(index);
    }

    public void setDatos(ArrayList<AuditPlan> arrayList) {
        this.datos = arrayList;
        notifyDataSetChanged();
    }


    public View getView(int index, View view, ViewGroup viewGroup) {
        AuditPlan to = this.datos.get(index);

        view = View.inflate(this.context, R.layout.row_audit_plan, null);

        TextView txtComplejo = view.findViewById(R.id.txt_complejo_auditoria);
        TextView txtFecha = view.findViewById(R.id.txt_fecha_auditoria);
        TextView txtEstatus = view.findViewById(R.id.txt_status_auditoria);

        txtComplejo.setText(to.getId_complejo().getTxt_nombre());
        txtFecha.setText(to.getFch_planeacion());
        txtEstatus.setText(to.getId_estado_auditoria());

        return view;



    }
}
