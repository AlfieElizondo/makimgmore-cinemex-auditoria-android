package mx.com.dgom.cinemex.android.auditoria.app;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import mx.com.dgom.cinemex.android.auditoria.R;

public class AppActivityExtension extends Activity {

    protected AppControllerNetwork appController = new AppControllerNetwork();
    private int coversCount = 0;
    protected Gson gson = new Gson();
    private ProgressDialog pd;

    protected void addCover() {
        this.coversCount++;
        if (this.pd == null) {
            this.pd = new ProgressDialog(this);
            this.pd.setMessage(getString(R.string.espere_un_momento));
            this.pd.setCancelable(false);
        }
        if (!this.pd.isShowing()) {
            this.pd.show();
        }
    }

    protected void removeCover() {
        this.coversCount--;
        if (this.coversCount < 0) {
            this.coversCount = 0;
        }
        if (this.pd != null && this.coversCount == 0) {
            this.pd.dismiss();
        }
    }

    protected boolean isWorking() {
        return this.coversCount > 0;
    }

    public void notInternetErrorManager(String str) {
        removeCover();
        Toast.makeText(this, R.string.no_internet_error, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
