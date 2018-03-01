package mx.restserviceexample.restserviceexample;

public class ErrorUtils {
    //region Error's Declaration
    public static String ERROR_000 = "E000 Unknowed error";
    public static String ERROR_001 = "E001 username not found";
    public static String ERROR_002 = "E002 Incorrect password";
    //endregion

    //region Local Methods
    public static String getErrorMessage(int errorCode){
        switch (errorCode){
            case 1:
                return ERROR_001;
            case 2:
                return ERROR_002;
            default:
                return ERROR_000;

        }
    }
    //endregion
}
