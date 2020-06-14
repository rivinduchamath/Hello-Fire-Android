package com.example.mobileapp;

import android.app.Application;

import com.firebase.client.Firebase;

public class MobileApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
