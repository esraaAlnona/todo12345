package com.example.myapp;

import android.app.Application;

//import com.marcinorlowski.fonty.Fonty;

public class TagPortalApp extends Application {

    protected static TagPortalApp tagPortalApp;


    @Override
    public void onCreate() {
        super.onCreate();

        tagPortalApp = this;

    }


    public static TagPortalApp getInstance() {
        return tagPortalApp;
    }


}