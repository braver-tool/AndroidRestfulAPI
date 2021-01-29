package com.retrofit.example.filePostApi;

import com.google.gson.annotations.SerializedName;

public class UserInfoPutDataItems {

    @SerializedName("profileUrl")
    private String profileUrl;

    @SerializedName("gender")
    private String gender;

    @SerializedName("emailId")
    private String emailId;

    @SerializedName("middle")
    private String middleName;

    @SerializedName("last")
    private String lastName;

    @SerializedName("dateOfBirth")
    private String dateOfBirth;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("first")
    private String firstName;

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserInfoPutDataItems() {
    }

    public UserInfoPutDataItems(String profileUrl, String gender, String emailId, String middleName, String lastName, String dateOfBirth, String phoneNumber, String firstName) {
        this.profileUrl = profileUrl;
        this.gender = gender;
        this.emailId = emailId;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
    }
}