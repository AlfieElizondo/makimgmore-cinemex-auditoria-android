package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;

public class MessageResponse implements Serializable {

    private static final String TAG = "MessageResponse";

    private int responseCode;
    private String message;




    public static MessageResponse parse(String json){
        Log.d(TAG, json);
        Gson gson = new Gson();
        return gson.fromJson(json, MessageResponse.class);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
