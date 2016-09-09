package com.pyn.rtexchagerate.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.orhanobut.logger.Logger;

/**
 * RTCRApplication
 * @author pengyn
 * created at 2016/9/9 18:09
 */
public class RTCRApplication extends Application {

    private static final String TAG = "RTCRApplication";

    private static Context mContext;
    private static Handler mHandler;
    private static int mainThreadId;

    private static RTCRApplication instance;
    // 当前屏幕的宽度
    public int screenW = 0;
    public int screenH = 0;

    // 单例模式获取唯一MyApplication实例
    public static RTCRApplication getInstance(){

        if(instance == null){
            instance = new RTCRApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        mContext = getApplicationContext();
        mHandler = new Handler();
        mainThreadId = android.os.Process.myTid();

        // 得到屏幕宽度和高度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenW = dm.widthPixels;
        screenH = dm.heightPixels;

        // Bugly初始化
//        CrashReport.initCrashReport(getApplicationContext(), "900033774", false);
        Logger.init(TAG);

        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Logger.v("onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Logger.v("onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Logger.v("onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Logger.v("onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Logger.v("onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Logger.v("onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Logger.v("onActivityDestroyed");
            }
        });
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }
}
