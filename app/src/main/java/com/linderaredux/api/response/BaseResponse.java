package com.linderaredux.api.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("confirmation")
    private String confirmation;

    @SerializedName(value = "message", alternate = {"errors"})
    private T data;

    @SerializedName("token")
    private String token;

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}