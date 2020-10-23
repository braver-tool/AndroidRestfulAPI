package com.example.androidretrofitsample.api;


import com.example.androidretrofitsample.filePostApi.FileUploadResponse;
import com.example.androidretrofitsample.getApi.GetUserInfoResponse;
import com.example.androidretrofitsample.postApi.PostApiRequest;
import com.example.androidretrofitsample.postApi.PostApiResponse;
import com.example.androidretrofitsample.putApi.PutApiRequest;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface ApiService {

    @POST("api/v1/vitals")
    Call<PostApiResponse> callRetrofitPostApi(@Body PostApiRequest postApiRequest, @Header("Authorization") String accessToken);

    @PUT("api/v1/vitals")
    Call<Object> callRetrofitPutApi(@Body PutApiRequest putApiRequest, @Header("Authorization") String accessToken);

    @GET
    Call<GetUserInfoResponse> getUserInfo(@Url String url, @Header("Authorization") String accessToken);

    @Headers({"Content-Type:application/json;"})
    @DELETE
    Call<Object> callDeleteApi(@Url String url);

    @Multipart
    @POST("api/v1/UploadFile")
    Call<FileUploadResponse> callFileUploadApi(@Part MultipartBody.Part file, @Header("Authorization") String accessToken);
}