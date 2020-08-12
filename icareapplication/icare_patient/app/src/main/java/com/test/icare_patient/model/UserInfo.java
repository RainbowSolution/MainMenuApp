package com.test.icare_patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    public String getLogin_type() {
        return login_type;
    }

   public void setLogin_type(String login_type) {
       this.login_type = login_type;
    }

    @SerializedName("login_type")
    @Expose
    private String login_type;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    public String getFirebase_token() {
        return Firebase_token;
    }

   public void setFirebase_token(String firebase_token) {
        Firebase_token = firebase_token;
    }

    @SerializedName("Firebase_token")
    @Expose
    private String Firebase_token;

    @SerializedName("phone_number")
    @Expose
    private String phone_number;

    @SerializedName("hospital_name")
    @Expose
    private String hospital_name;

    @SerializedName("sector")
    @Expose
    private Integer sector;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
   }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

   public Integer getSector() {
       return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }
}
