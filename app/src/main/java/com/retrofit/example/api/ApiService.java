package com.retrofit.example.api;


import com.retrofit.example.filePostApi.FileUploadResponse;
import com.retrofit.example.getApi.GetUserInfoResponse;
import com.retrofit.example.parsing.DataItems;
import com.retrofit.example.postApi.PostApiRequest;
import com.retrofit.example.postApi.PostApiResponse;
import com.retrofit.example.putApi.PutApiRequest;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    @POST("api/v1/users")
    Call<PostApiResponse> callRetrofitPostApi(@Body PostApiRequest postApiRequest, @Header("Authorization") String accessToken);

    @PUT("api/v1/users")
    Call<Object> callRetrofitPutApi(@Body PutApiRequest putApiRequest, @Header("Authorization") String accessToken);

    @GET
    Call<GetUserInfoResponse> getUserInfo(@Url String url, @Header("Authorization") String accessToken);

    @Headers({"Content-Type:application/json;"})
    @DELETE
    Call<Object> callDeleteApi(@Url String url);

    @Multipart
    @POST("api/v1/UploadFile")
    Call<FileUploadResponse> callFileUploadApi(@Part MultipartBody.Part file, @Header("Authorization") String accessToken);

    @Multipart
    @PUT("api/v1/UploadFile")
    Call<FileUploadResponse> callFileUploadApi(@Part MultipartBody.Part file, @Part("request") RequestBody accountSettingPutApiRequest, @Header("Authorization") String accessToken);

    @GET
    Call<List<DataItems>> callLeaderDetailsGetApi(@Url String Url);
}