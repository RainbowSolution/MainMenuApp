package com.test.icare_patient.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL = "http://15.206.103.57/Icare/Api/Authentication/";




    private static Retrofit retrofit = null;
    public static RestService getClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(5, TimeUnit.MINUTES);

        // change your base URL
       if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(clientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        RestService api = retrofit.create(RestService.class);
        return api; // return the APIInterface object

    }

}