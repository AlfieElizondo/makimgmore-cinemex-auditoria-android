package mx.com.dgom.cinemex.android.auditoria.app;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import mx.com.dgom.cinemex.android.auditoria.app.protocol.LoginResponse;

public class AppControllerNetwork {

    private Gson gson = new Gson();
    private AppNetwork net = new AppNetwork();


    /**
     * Login del usuario en la plataforma
     * @param user
     * @param pass
     * @param ctx
     * @param respInterface
     */
    public void login(String user, String pass, Context ctx ,JSONRespInterface respInterface){
        try{
            JSONObject data = new JSONObject();
            data.put("user_name", user);
            data.put("password", pass);

            net.jsonObjectRequest(AppConstantes.getAPIURL() + AppConstantes.API_REST_LOGIN, data ,ctx , respInterface);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }



    public void getCalendario( Context ctx ,JSONRespInterface respInterface){
        try{
            JSONObject data = new JSONObject();
            data.put("user_name", AppData.usuarioLogueado.getTxt_correo());
            data.put("uuid", AppData.usuarioLogueado.getUuid());

            net.jsonObjectRequest(AppConstantes.getAPIURL() + AppConstantes.API_REST_CALENDARIO, data ,ctx , respInterface);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }


    public void getCuestionario(String uuidCuestionario,Context ctx ,JSONRespInterface respInterface){
        try{
            JSONObject data = new JSONObject();
            data.put("user_name", AppData.usuarioLogueado.getTxt_correo());
            data.put("uuid", AppData.usuarioLogueado.getUuid());
            data.put("uuid_cuestionario", uuidCuestionario);

            net.jsonObjectRequest(AppConstantes.getAPIURL() + AppConstantes.API_REST_CUESTIONARIO, data ,ctx , respInterface);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
