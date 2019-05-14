package mx.com.dgom.cinemex.android.auditoria;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.dgom.cinemex.android.auditoria.app.AppActivityExtension;
import mx.com.dgom.cinemex.android.auditoria.app.AppControllerNetwork;
import mx.com.dgom.cinemex.android.auditoria.app.AppData;
import mx.com.dgom.cinemex.android.auditoria.app.JSONRespInterface;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.LoginResponse;
import mx.com.dgom.cinemex.android.auditoria.app.protocol.MessageResponse;

public class LoginActivity extends AppActivityExtension {

    private static final String TAG = "LoginActivity";

    private EditText txtMail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Rem ove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);




        txtMail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
    }


    public void loginAction(View v){
        String userName = txtMail.getText().toString();
        String pass = txtPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            this.txtMail.setError("Indica tu correo");
            return;
        } else if (TextUtils.isEmpty(pass)) {
            this.txtPassword.setError("Indica tu contraseña");
            return;
        }


        AppControllerNetwork controller = new AppControllerNetwork();
        addCover();
        controller.login(userName, pass, this, new JSONRespInterface() {
            @Override
            public void stringErrorResp(String json) {
                Log.d(TAG, "json");
                MessageResponse mr = MessageResponse.parse(json);
                removeCover();
                Toast.makeText(LoginActivity.this, mr.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void stringResp(String json) {
                Log.d(TAG, "json");
                LoginResponse res = LoginResponse.parse(json);
                if(res.getData().getUsuario().getB_habilitado() == 0){
                    Toast.makeText(LoginActivity.this, "El usuario no se encuentra habilitado", Toast.LENGTH_SHORT).show();
                    return;
                }

                AppData.usuarioLogueado = res.getData().getUsuario();
                AppData.token = res.getData().getToken();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
                removeCover();
            }

            @Override
            public void noInternetError(String msg) {
                Log.d(TAG, "json");
                removeCover();
                Toast.makeText(LoginActivity.this,msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void newSessionRequired() {
                /*
                AppData.logout();
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
                */
                removeCover();
            }
        });
    }
}
