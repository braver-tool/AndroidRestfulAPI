package com.example.androidretrofitsample.api;

import android.annotation.SuppressLint;
import android.os.Build;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;

public class APIUrlBase {
    public static final String BASE_URL_API = "<BASE_URL>";

    @SuppressLint("TrustAllX509TrustManager")
    public static OkHttpClient getSafeOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            try {
                // Create a trust manager that does not validate certificate chains
                final TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        }
                };

                // Install the all-trusting trust manager
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                // Create an ssl socket factory with our all-trusting manager
                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
                builder.connectTimeout(2, TimeUnit.MINUTES);
                builder.readTimeout(2, TimeUnit.MINUTES);
                builder.writeTimeout(2, TimeUnit.MINUTES);
                builder.addInterceptor(logging);
                builder.protocols(Util.immutableList(Protocol.HTTP_1_1));
                builder.hostnameVerifier((hostname, session) -> true);
                return builder.build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).addInterceptor(logging).protocols(Util.immutableList(Protocol.HTTP_1_1)).build();
        }
    }
}
