package mx.com.dgom.cinemex.android.auditoria.app.protocol;

import com.google.gson.Gson;

public class LoginResponse extends MessageResponse {

    private UserData data;


    public static LoginResponse parse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, LoginResponse.class);
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}

