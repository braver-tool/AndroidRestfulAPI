package com.example.androidretrofitsample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.androidretrofitsample.api.APIUrlBase.getSafeOkHttpClient;

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


}