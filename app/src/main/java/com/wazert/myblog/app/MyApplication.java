package com.wazert.myblog.app;

import android.app.Application;
import android.util.Log;

/**
 * @author zhaozhuo
 * @date 2018/4/23 15:06
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
