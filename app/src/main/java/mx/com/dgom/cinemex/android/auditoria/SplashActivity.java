package mx.com.dgom.cinemex.android.auditoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orm.SugarContext;

public class SplashActivity extends Activity {

    private final long SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        SugarContext.init(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);


    }
}



