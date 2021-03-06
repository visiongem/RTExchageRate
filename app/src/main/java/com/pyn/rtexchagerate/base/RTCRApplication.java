package com.pyn.rtexchagerate.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.antfortune.freeline.FreelineCore;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.Logger;

/**
 * RTCRApplication
 * @author pengyn
 * created at 2016/9/9 18:09
 */
public class RTCRApplication extends Application {

    private static final String TAG = "RTCRApplication";

    private static Context mContext;
    // 当前屏幕的宽度
    public static int screenW = 0;
    public static int screenH = 0;

    // 获取全局的Context
    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        FreelineCore.init(this);
        super.onCreate();
        // 初始化hawk数据存储
        Hawk.init(this).build();
//
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

        mContext = getApplicationContext();
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
}
