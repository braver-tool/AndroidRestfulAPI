package com.retrofit.example.getApi;

import com.google.gson.annotations.SerializedName;

public class GetUserInfoResponse {

    @SerializedName("BloodGroup")
    private String bloodGroup;

    @SerializedName("Email")
    private String email;

    @SerializedName("UserDOB")
    private String UserDOB;

    @SerializedName("UserName")
    private String UserName;

    @SerializedName("Gender")
    private String gender;

    @SerializedName("Mobile")
    private Object mobile;

    @SerializedName("Weight")
    private String weight;

    @SerializedName("Contact")
    private String contact;

    @SerializedName("AddressLine2")
    private String addressLine2;

    @SerializedName("Profession")
    private String profession;

    @SerializedName("AddressLine1")
    private String addressLine1;

    @SerializedName("Height")
    private Object height;

    @SerializedName("Age")
    private String age;

    @SerializedName("ProfileUrl")
    private String profileUrl;

    @SerializedName("Title")
    private String title;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserDOB() {
        return UserDOB;
    }

    public void setUserDOB(String userDOB) {
        UserDOB = userDOB;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getMobile() {
        return mobile;
    }

    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}