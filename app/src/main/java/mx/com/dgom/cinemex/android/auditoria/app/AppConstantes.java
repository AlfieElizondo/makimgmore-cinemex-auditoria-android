package mx.com.dgom.cinemex.android.auditoria.app;

public class AppConstantes
{

    public static final String INTENT_AUDIT_PLAN = "INTENT:AUDIT_PLAN";
    public static final String INTENT_QUESTION =  "INTENT_QUESTION";
    public static final String SHARED_PREFS = "CINEMEX_SHARED_PREFS";
    public static final String SHARED_PREFS_AUDIT = "SHARED_PREFS_AUDIT";


    private static final String API_KEY_LOCAL = "key";
    private static final String API_SECRET_LOCAL = "secret";

    private static final String API_REST_URL_LOCAL          = "http://192.168.1.122/2019/cinemex/auditoria/web";

    private static final String API_REST_URL_DEV            = "https://dev.2geeksonemonkey.com/vinevera/sale-force/web/services/";
    private static final String API_REST_URL_QA             = "https://qa.2geeksonemonkey.com/vinevera/vinevera-sale-force/web/services/";

    private static final String API_REST_URL_PROD           = "https://milibreta.app/services/";


    // -------------------------- SERVICE ENDPOINTS ------------------------------------
    public static final String API_REST_LOGIN = "/service/login";
    public static final String API_REST_CALENDARIO = "/service/calendario";
    public static final String API_REST_CUESTIONARIO = "/service/cuestionario";


    public enum api {
        QA,
        DEV,
        LOCAL,
        PROD
    }

    //Version que utiliza QA o DEV
    public static final api ambiente = api.LOCAL;


    public static String getApiKey(){
        switch (ambiente) {
            case LOCAL:
            default:
                return API_KEY_LOCAL;
        }
    }

    public static String getApiSecret(){
        switch (ambiente) {
            case LOCAL:
            default:
                return API_SECRET_LOCAL;
        }
    }


    public static String getAPIURL() {
        switch (ambiente) {
            case QA:
                return API_REST_URL_QA;
            case DEV:
                return API_REST_URL_DEV;
            case LOCAL:
                return API_REST_URL_LOCAL;
            case PROD:
                return API_REST_URL_PROD;
            default:
                return API_REST_URL_DEV;
        }
    }

    public static String getAPIURLName() {
        switch (ambiente) {
            case QA:
                return "qa";
            case DEV:
                return "dev";
            case LOCAL:
                return "local";
            case PROD:
                return "Prod";
            default:
                return "dev";
        }
    }
}
