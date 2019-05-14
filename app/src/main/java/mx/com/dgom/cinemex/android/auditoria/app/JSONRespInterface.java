package mx.com.dgom.cinemex.android.auditoria.app;



public interface JSONRespInterface {

    void stringErrorResp(String json);
    void stringResp(String json);
    void noInternetError(String msg);
    void newSessionRequired();
}