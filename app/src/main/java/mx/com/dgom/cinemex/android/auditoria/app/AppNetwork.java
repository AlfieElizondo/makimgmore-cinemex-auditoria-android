package mx.com.dgom.cinemex.android.auditoria.app;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import mx.com.dgom.cinemex.android.auditoria.app.protocol.MessageResponse;


/**
 * Created by Jessica on 03/04/2018.
 */

public class AppNetwork {
    private static final String TAG = "Network";
    private static final String NETWORK="NETWORK";
    private String response;

    private static Gson gson = new Gson();

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void jsonObjectRequest(String url, JSONObject data, Context context , final JSONRespInterface jreqinterface) {

        Log.d(TAG, url);

        final JsonObjectRequest jsonObjectReq = new JsonObjectRequest(Request.Method.POST,  url, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String res = response.toString();
                    MessageResponse mr = gson.fromJson(res, MessageResponse.class);

                    if(mr.getResponseCode() < 0){
                        jreqinterface.stringErrorResp(res);
                    }else{
                        jreqinterface.stringResp(res);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    jreqinterface.stringErrorResp("{\"responseCode\":-1,\"message\":" + e.getLocalizedMessage() + "}");
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG, error.toString());
                if( error instanceof NoConnectionError){
                    jreqinterface.noInternetError(error.getMessage());
                }else{
                    Log.d(NETWORK, "Error: " + error.getMessage());
                    jreqinterface.stringErrorResp("Error: " + error.getMessage());
                }
            }
        })

        {
            /** Passing some request headers* */
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("api-key", AppConstantes.getApiKey());
                headers.put("api-secret", AppConstantes.getApiSecret());
                if(AppData.token != null){
                    headers.put("Authentication-Token", AppData.token);
                }
                return headers;
            }
        };

        jsonObjectReq.setRetryPolicy(new DefaultRetryPolicy(0, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context).addToRequestQueue(jsonObjectReq);
    }
}
