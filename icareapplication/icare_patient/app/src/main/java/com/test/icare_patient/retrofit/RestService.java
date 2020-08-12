package com.test.icare_patient.retrofit;

import com.google.gson.JsonObject;
import com.test.icare_patient.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestService {

    @POST("doctor_registration")
   Call<JsonObject> doctor_reg(@Body UserInfo jsonObject);

    @POST("Patientlogin")
    Call<JsonObject> patient_login(@Body UserInfo jsonObject);

  /*  @GET("get_department")
    Call<Sector_Pojo> getSectorDetail();*/


}
