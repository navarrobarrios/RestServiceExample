package mx.restserviceexample.restserviceexample.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralResponse<T> {
    //region Variables
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("response")
    private T result;
    //endregion

    //region Constructor

    public GeneralResponse() {
    }

    public GeneralResponse(boolean success) {
        this.success = success;
    }

    //endregion

    //region Setters && Getters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    //endregion

}
