package com.example.androidretrofitsample.postApi;

import com.google.gson.annotations.SerializedName;


public class PostApiResponse {

    @SerializedName("data")
    private String data;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("reasonCode")
    private int reasonCode;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public int getReasonCode() {
        return reasonCode;
    }
}