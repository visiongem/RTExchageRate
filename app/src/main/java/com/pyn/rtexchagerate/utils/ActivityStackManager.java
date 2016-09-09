package com.pyn.rtexchagerate.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * activity堆栈管理
 * @author pengyn
 * created at 2016/9/9 18:18
 */
public class ActivityStackManager {

    private static ActivityStackManager mInstance;
    private static Stack<Activity> mActivityStack;

    public static ActivityStackManager getInstance() {

        if (null == mInstance) {
            mInstance = new ActivityStackManager();
        }
        return mInstance;
    }

    private ActivityStackManager() {
        mActivityStack = new Stack<Activity>();
    }

    /**
     * 入栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mActivityStack.push(activity);
    }

    /**
     * 出栈
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        mActivityStack.remove(activity);
    }

    /**
     * 彻底退出
     */
    public void finishAllActivity() {
        Activity activity;
        while (!mActivityStack.empty()) {
            activity = mActivityStack.pop();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
}
