package com.pyn.rtexchagerate.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.pyn.rtexchagerate.application.RTCRApplication;

/**
 * ui的工具类
 *
 * @author pengyn
 *         created at 2016/9/9 18:18
 */
public class UIUtils {

    public static Context getContext() {
        return RTCRApplication.getContext();
    }

    public static Handler getHandler() {
        return RTCRApplication.getHandler();
    }

    public static int getMainThreadId() {
        return RTCRApplication.getMainThreadId();
    }

    /**
     * 获取资源文件字符串
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    /**
     * 获取资源文件字符串数组
     *
     * @param id
     * @return
     */
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    /**
     * 获取资源文件图片
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

    /**
     * 获取资源文件颜色
     *
     * @param id
     * @return
     */
    public static int getColor(int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    /**
     * 根据id获取颜色的状态选择器
     *
     * @param id
     * @return
     */
    public static ColorStateList getColorStateList(int id) {
        return ContextCompat.getColorStateList(getContext(), id);
    }

    /**
     * 获取尺寸
     *
     * @param id
     * @return
     */
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id); // 返回具体像素值
    }

    /**
     * dp -> px
     *
     * @param dp
     * @return
     */
    public static int dp2px(float dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    /**
     * px -> dp
     *
     * @param px
     * @return
     */
    public static float px2dp(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    /**
     * 加载布局文件
     *
     * @param id
     * @return
     */
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    /**
     * 判断是否运行在主线程
     *
     * @return
     */
    public static boolean isRunOnUIThread() {
        // 获取当前线程id, 如果当前线程id和主线程id相同, 那么当前就是主线程
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 运行在主线程
     *
     * @param r
     */
    public static void runOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            // 已经是主线程, 直接运行
            r.run();
        } else {
            // 如果是子线程, 借助handler让其运行在主线程
            getHandler().post(r);
        }
    }
}
