package mx.com.dgom.cinemex.android.auditoria.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mx.com.dgom.cinemex.android.auditoria.R;
import mx.com.dgom.cinemex.android.auditoria.app.to.AuditAreaStatus;

public class AreasAdapter extends ArrayAdapter {

    private Context context;

    private ArrayList<AuditAreaStatus> datos;



    public AreasAdapter(Context context, ArrayList<AuditAreaStatus> arrayList) {
        super(context, R.layout.row_audit_area_status, arrayList);
        this.context = context;
        this.datos = arrayList;
    }


    public int getCount() {
        return this.datos.size();
    }

    public Object getItem(int index) {
        return this.datos.get(index);
    }

    public void setDatos(ArrayList<AuditAreaStatus> arrayList) {
        this.datos = arrayList;
        notifyDataSetChanged();
    }


    public View getView(int index, View view, ViewGroup viewGroup) {
        AuditAreaStatus to = this.datos.get(index);

        view = View.inflate(this.context, R.layout.row_audit_area_status, null);

        TextView txtArea = view.findViewById(R.id.txt_area_auditoria);
        ImageView imgEstatus = view.findViewById(R.id.img_estatus_auditoria);

        txtArea.setText(to.getArea().getTxt_nombre());
        if(to.isStatus()){
            imgEstatus.setImageDrawable(context.getDrawable(R.drawable.done));
        }else{
            imgEstatus.setImageDrawable(context.getDrawable(R.drawable.pendiente));
        }

        return view;



    }
}