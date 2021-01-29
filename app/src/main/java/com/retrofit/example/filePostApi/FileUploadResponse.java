package com.retrofit.example.filePostApi;

import com.google.gson.annotations.SerializedName;


public class FileUploadResponse {

    @SerializedName("filePath")
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}