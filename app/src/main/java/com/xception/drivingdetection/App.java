package com.xception.drivingdetection;

import android.app.Application;

import com.xception.drivingdetection.helper.ApplicationHelper;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // To have an access of the application context in every class
        ApplicationHelper.initInstance(this);
    }
}
