package com.retrofit.example.parsing;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.retrofit.example.R;
import com.retrofit.example.api.ApiBase;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonParserActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parser);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        if (isNetworkAvailable()) {
            leaderDetailsGetAPI();
        } else {
            //Creating dialog box
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please check your internet connection!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", (dialog, id) -> onBackPressed());
            AlertDialog alert = builder.create();
            alert.setTitle("Connection Failed");
            alert.show();
        }
    }

    /**
     * Call sample API
     */
    private void leaderDetailsGetAPI() {
        progressBar.setVisibility(View.VISIBLE);
        String leaderDetailsGetUrl = "https://braver-tool.000webhostapp.com/leaders.json";
        Call<List<DataItems>> call = ApiBase.apiService1().callLeaderDetailsGetApi(leaderDetailsGetUrl);
        call.enqueue(new Callback<List<DataItems>>() {
            @Override
            public void onResponse(Call<List<DataItems>> call, Response<List<DataItems>> response) {
                Log.d("##leaderDetailsGetAPI", "----------->" + response.code());
                if (response.code() == 200 && response.body() != null && response.body().size() > 0) {
                    List<DataItems> dataItemsList = response.body();
                    loadRecyclerView(dataItemsList);
                } else {
                    loadRecyclerView(getJsonList());
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<DataItems>> call, Throwable t) {
                Log.d("##leaderDetailsGetAPI", t.getMessage() != null ? t.getMessage() : "");
                loadRecyclerView(getJsonList());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    /**
     * @param dataItemsList - data
     */
    private void loadRecyclerView(List<DataItems> dataItemsList) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataItemsList, JsonParserActivity.this);
        recyclerView.setAdapter(recyclerAdapter);
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
            Log.d("Error", e.getMessage());
        }
        return status;
    }

    /**
     * @returnm - String data that contains json data
     */
    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = JsonParserActivity.this.getAssets().open("leaders.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * @return - List ----> conversion
     */
    private List<DataItems> getJsonList() {
        List<DataItems> dataItemsList;
        String jsonData = loadJSONFromAsset();
        Type listType = new TypeToken<List<DataItems>>() {
        }.getType();
        dataItemsList = new Gson().fromJson(jsonData, listType);
        return dataItemsList;
    }

}