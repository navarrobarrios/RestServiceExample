package mx.restserviceexample.restserviceexample.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import mx.restserviceexample.restserviceexample.ErrorUtils;

public enum ErrorCodesAplication {
    ERROR_001(1,"E001 username not found"),
    ERROR_002(2,"E002 Incorrect password"),
    ERROR_003(3,"E003 Invalid parameters"),
    ERROR_004(4,"E004 Internal error"),
    ERROR_005(5,"E005 Bad url request"),
    ERROR_000(0,"E000 Unknowed error");

    //region Variables
    private int errorCode;
    private String message;
    //endregion

    //region Constructor's

    ErrorCodesAplication(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.message = errorMessage;
    }
    //endregion

    //region Setters && Getters

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        this.setMessage(ErrorUtils.getErrorMessage(errorCode));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //endregion

}
