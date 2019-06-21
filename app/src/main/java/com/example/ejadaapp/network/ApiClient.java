package com.example.ejadaapp.network;

import android.app.Application;

import com.example.ejadaapp.application.EjadaApp;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// retrofit client
// singleton
public class ApiClient {

    public static final String BASE_URL = "https://api.github.com/";
    // singleton object
    public static Retrofit retrofit = null;

    // singleton instantiation
    public static Retrofit getApiClient() {
        if (retrofit == null) {
            synchronized (ApiClient.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(getClient())
                            .addConverterFactory(GsonConverterFactory
                                    .create(new GsonBuilder()
                                            .create()))
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }

        return retrofit;
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .cache(new Cache(EjadaApp.getApplication().getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();

                        return chain.proceed(request);
                    }
                })
                .build();
        return client;
    }

}
