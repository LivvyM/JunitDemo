package com.livvy.junitdemo;

import android.content.Context;

/**
 * Created by livvy on 3/5/16.
 */
public class AppClient extends android.app.Application{

    private static AppClient instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext() {
        return instance;
    }

}
