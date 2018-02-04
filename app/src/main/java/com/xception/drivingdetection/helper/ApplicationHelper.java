package com.xception.drivingdetection.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.xception.drivingdetection.App;

public class ApplicationHelper {

    private static ApplicationHelper mApplicationHelper = null;
    private Context mContext;

    private ApplicationHelper(Context context) {
        mContext = context;
    }

    public static void initInstance(App app) {
        if (mApplicationHelper == null) {
            mApplicationHelper = new ApplicationHelper(app);
        }
    }

    public static ApplicationHelper getInstance() {
        if (mApplicationHelper == null) {
            throw new RuntimeException("Shared application context must be initialized " +
                    "with method 'initInstance' before being used");
        }
        return mApplicationHelper;
    }

    public Context getContext() {
        return mContext;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
