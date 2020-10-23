package com.example.androidretrofitsample.postApi;

import com.google.gson.annotations.SerializedName;

public class PostApiDocumentsItem {

    @SerializedName("notes")
    private String notes;

    @SerializedName("isDeleted")
    private boolean isDeleted;

    @SerializedName("count")
    private int count;

    @SerializedName("id")
    private String id;

    @SerializedName("userId")
    private String userId;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PostApiDocumentsItem() {
    }

    public PostApiDocumentsItem(String notes, boolean isDeleted, int count, String id, String userId) {
        this.notes = notes;
        this.isDeleted = isDeleted;
        this.count = count;
        this.id = id;
        this.userId = userId;
    }
}