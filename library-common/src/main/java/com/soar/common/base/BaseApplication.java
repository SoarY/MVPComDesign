package com.soar.common.base;

import android.app.Application;
import android.content.Context;

/**
 * NAME：YONG_
 * Created at: 2019/8/30 14
 * Describe:
 */
public class BaseApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
