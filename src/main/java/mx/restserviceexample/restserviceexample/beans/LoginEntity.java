package mx.restserviceexample.restserviceexample.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginEntity {
    //region Varibles
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastname")
    private String lastname;
    //endregion

    //region Constructor
    public LoginEntity(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    //endregion

    //region Setter's & Getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //endregion

}
