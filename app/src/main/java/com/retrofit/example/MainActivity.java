package com.retrofit.example;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.retrofit.example.api.APIUrlBase;
import com.retrofit.example.api.ApiBase;
import com.retrofit.example.filePostApi.FileUploadResponse;
import com.retrofit.example.filePostApi.UserInfoPutDataItems;
import com.retrofit.example.getApi.GetUserInfoResponse;
import com.retrofit.example.parsing.JsonParserActivity;
import com.retrofit.example.postApi.PostApiDocumentsItem;
import com.retrofit.example.postApi.PostApiRequest;
import com.retrofit.example.postApi.PostApiResponse;
import com.retrofit.example.putApi.PutApiRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String accessToken = "<ACCESS_TOKEN>";
    private static final String user_ID = "<USER_ID>";
    private String RandomUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.postApiButton).setOnClickListener(v -> callRetrofitPostApi());
        findViewById(R.id.putApiButton).setOnClickListener(v -> callRetrofitPutApi());
        findViewById(R.id.getApiButton).setOnClickListener(v -> callRetrofitGetApi());
        findViewById(R.id.deleteApiButton).setOnClickListener(v -> callRetrofitDeleteApi());
        findViewById(R.id.multiPartApiType1Button).setOnClickListener(v -> callRetrofitMultiPartApi());
        findViewById(R.id.multiPartApiType2Button).setOnClickListener(v -> callRetrofitMultiPartApiType2());
        findViewById(R.id.jsonParsingButton).setOnClickListener(v -> navigateToJsonParserScreen());
        UUID uuid = UUID.randomUUID();
        RandomUUID = uuid.toString();
    }

    /**
     * Method handle to Retrofit POST API
     */
    private void callRetrofitPostApi() {
        try {
            PostApiDocumentsItem postApiDocumentsItem = new PostApiDocumentsItem("Notes", true, 12, RandomUUID, user_ID);
            List<PostApiDocumentsItem> postApiDocumentsItemList = new ArrayList<>();
            postApiDocumentsItemList.add(postApiDocumentsItem);
            PostApiRequest postApiRequest = new PostApiRequest(postApiDocumentsItemList);
            if (isNetworkAvailable()) {
                Call<PostApiResponse> call = ApiBase.apiService().callRetrofitPostApi(postApiRequest, accessToken);
                call.enqueue(new Callback<PostApiResponse>() {
                    @Override
                    public void onResponse(Call<PostApiResponse> call, Response<PostApiResponse> response) {
                        if (response.code() == 200 && response.body() != null) {
                            Log.d("##callRetrofitPostApi", "Post Api Success");
                        } else {
                            Log.d("##callRetrofitPostApi", "Post Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostApiResponse> call, Throwable t) {
                        Log.d("##callRetrofitPostApi", "------->Error--->" + t.getMessage());
                    }
                });
            } else {
                Log.d("##callRetrofitPostApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callRetrofitPostApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * Method handle to Retrofit GET API
     */
    private void callRetrofitGetApi() {
        try {
            if (isNetworkAvailable()) {
                String userInfoUrl = APIUrlBase.BASE_URL_API + "api/v1/userInfo";
                Call<GetUserInfoResponse> call = ApiBase.apiService().getUserInfo(userInfoUrl, accessToken);
                call.enqueue(new Callback<GetUserInfoResponse>() {
                    @Override
                    public void onResponse(Call<GetUserInfoResponse> call, Response<GetUserInfoResponse> response) {
                        if (response.code() == 200 && response.body() != null) {
                            //GetUserInfoResponse getUserInfoResponse = response.body();
                            Log.d("##callRetrofitGetApi", "Get Api Success");
                        } else {
                            Log.d("##callRetrofitGetApi", "Get Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUserInfoResponse> call, Throwable t) {
                        Log.d("##callRetrofitGetApi", "------->Error--->" + t.getMessage());
                    }
                });
            } else {
                Log.d("##callRetrofitGetApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callRetrofitGetApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method handle to Retrofit PUT API
     */
    private void callRetrofitPutApi() {
        try {
            PutApiRequest putApiRequest = new PutApiRequest(true, user_ID);
            if (isNetworkAvailable()) {
                Call<Object> call = ApiBase.apiService().callRetrofitPutApi(putApiRequest, accessToken);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if (response.code() == 200 && response.body() != null) {
                            Log.d("##callRetrofitPutApi", "Put Api Success");
                        } else {
                            Log.d("##callRetrofitPutApi", "Put Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Log.d("##callRetrofitPutApi", "------->Error--->" + t.getMessage());
                    }
                });
            } else {
                Log.d("##callRetrofitPutApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callRetrofitPutApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method handle to Retrofit DELETE API
     */
    private void callRetrofitDeleteApi() {
        try {
            if (isNetworkAvailable()) {
                String url = APIUrlBase.BASE_URL_API + "api/v1/unregister?UserId=" + user_ID;
                Call<Object> call = ApiBase.apiService().callDeleteApi(url);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if (response.code() == 200 && response.body() != null) {
                            Log.d("##callRetrofitDeleteApi", "Delete Api Success");
                        } else {
                            Log.d("##callRetrofitDeleteApi", "Delete Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Log.d("##callRetrofitDeleteApi", "------->Error--->" + t.getMessage());
                    }
                });
            } else {
                Log.d("##callRetrofitDeleteApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callRetrofitDeleteApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method handle to Retrofit FILE UPLOAD API
     */
    private void callRetrofitMultiPartApi() {
        try {
            if (isNetworkAvailable()) {
                String imageUri = "<IMAGE_PATH>";
                File cameraFile = new File(imageUri);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), cameraFile);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", "image.jpg", requestFile);
                Call<FileUploadResponse> call = ApiBase.apiService().callFileUploadApi(body, accessToken);
                call.enqueue(new Callback<FileUploadResponse>() {
                    @Override
                    public void onResponse(Call<FileUploadResponse> call, Response<FileUploadResponse> response) {
                        if (response.code() == 200 && response.body() != null) {
                            Log.d("##callMultiPartApi", "File Post Api Success");
                        } else {
                            Log.d("##callMultiPartApi", "File Post Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<FileUploadResponse> call, Throwable t) {
                        Log.d("##callMultiPartApi", "------->Error--->" + t.getMessage());
                    }
                });

            } else {
                Log.d("##callMultiPartApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callMultiPartApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method handle to Retrofit FILE UPLOAD API with json request
     */
    private void callRetrofitMultiPartApiType2() {
        try {
            UserInfoPutDataItems userInfoPutDataItems = new UserInfoPutDataItems("ProfileUrl", "Male", "alex@mailinator.com", "", "Hales", "01-05-1989", "32651611618", "Alex");
            if (isNetworkAvailable()) {
                String imageUri = "<IMAGE_PATH>";
                File cameraFile = new File(imageUri);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), cameraFile);
                MultipartBody.Part body = MultipartBody.Part.createFormData("image", "image.jpg", requestFile);
                String json = new Gson().toJson(userInfoPutDataItems);
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
                Call<FileUploadResponse> call = ApiBase.apiService().callFileUploadApi(body, requestBody, accessToken);
                call.enqueue(new Callback<FileUploadResponse>() {
                    @Override
                    public void onResponse(Call<FileUploadResponse> call, Response<FileUploadResponse> response) {
                        if (response.code() == 200 && response.body() != null) {
                            Log.d("##callMultiPartApi", "File Post Api Success");
                        } else {
                            Log.d("##callMultiPartApi", "File Post Api Failed--->" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<FileUploadResponse> call, Throwable t) {
                        Log.d("##callMultiPartApi", "------->Error--->" + t.getMessage());
                    }
                });

            } else {
                Log.d("##callMultiPartApi", "------->No Network");
            }
        } catch (Exception e) {
            Log.d("##callMultiPartApi", "------->" + e.getMessage());
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Method used to navigate {@Link JsonParserActivity.java}
     */
    private void navigateToJsonParserScreen() {
        startActivity(new Intent(MainActivity.this, JsonParserActivity.class));
    }

    /**
     * Method handle to return ----> is network available???
     */
    private boolean isNetworkAvailable() {
        boolean status = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo;
            if (connectivityManager != null) {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                status = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return status;
    }
}