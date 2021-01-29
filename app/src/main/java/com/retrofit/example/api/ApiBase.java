package com.retrofit.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.retrofit.example.api.APIUrlBase.getSafeOkHttpClient;

public class ApiBase {
    private static String TAG = ApiBase.class.getSimpleName();

    /**
     * @return - api-auth url --> retrofit service
     */
    public static ApiService apiService() {
        ApiService MDAuthApiService;
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrlBase.BASE_URL_API).addConverterFactory(GsonConverterFactory.create()).client(getSafeOkHttpClient()).build();
        MDAuthApiService = retrofit.create(ApiService.class);
        return MDAuthApiService;
    }

    /**
     * @return - api-auth url --> retrofit service
     */
    public static ApiService apiService1() {
        ApiService MDAuthApiService;
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://braver-tool.000webhostapp.com/").addConverterFactory(GsonConverterFactory.create()).client(getSafeOkHttpClient()).build();
        MDAuthApiService = retrofit.create(ApiService.class);
        return MDAuthApiService;
    }


}