package com.example.androidretrofitsample.postApi;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PostApiRequest {

    @SerializedName("documents")
    private List<PostApiDocumentsItem> smokePostdocuments;

    public PostApiRequest(List<PostApiDocumentsItem> smokePostdocuments) {
        this.smokePostdocuments = smokePostdocuments;
    }

    public void setSmokePostdocuments(List<PostApiDocumentsItem> smokePostdocuments) {
        this.smokePostdocuments = smokePostdocuments;
    }

    public List<PostApiDocumentsItem> getSmokePostdocuments() {
        return smokePostdocuments;
    }
}