package com.retrofit.example.putApi;

import com.google.gson.annotations.SerializedName;

public class PutApiRequest {
    @SerializedName("isDeleted")
    private boolean isDeleted;

    @SerializedName("userId")
    private String userId;

    public PutApiRequest() {
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PutApiRequest(boolean isDeleted, String userId) {
        this.isDeleted = isDeleted;
        this.userId = userId;
    }
}