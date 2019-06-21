package com.example.ejadaapp.application;

import android.app.Application;

public class EjadaApp extends Application {

    private static Application appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Application getApplication(){
        return appContext;
    }
}
