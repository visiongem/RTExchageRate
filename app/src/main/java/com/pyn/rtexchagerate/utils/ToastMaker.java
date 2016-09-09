package com.pyn.rtexchagerate.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pyn.rtexchagerate.R;
import com.pyn.rtexchagerate.application.RTCRApplication;

/**
 * 对app中所有的toast进行管理
 * @author pengyn
 * created at 2016/9/9 18:18
 */
public class ToastMaker {

    public static void showShortToast(String msg) {
        showCustomTranslucentToast(RTCRApplication.getInstance(), msg, Toast.LENGTH_SHORT);
    }

    public static void showShortToast(int msgId) {
        showCustomTranslucentToast(RTCRApplication.getInstance(), msgId, Toast.LENGTH_SHORT);
    }

    public static void showLongToast(String msg){
        showCustomTranslucentToast(RTCRApplication.getInstance(), msg, Toast.LENGTH_LONG);
    }

    public static void showLongToast(int msgId){
        showCustomTranslucentToast(RTCRApplication.getInstance(), msgId, Toast.LENGTH_LONG);
    }

    /**
     * 创建运行在UI线程中的Toast
     * @param activity
     * @param stringId
     */
    public static void showToastInUiThread(final Activity activity, final int stringId){
        if(activity != null){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showCustomTranslucentToast(activity, stringId);
                }
            });
        }
    }

    private static void showCustomTranslucentToast(Context context, int msgId){
        final String msg = context.getResources().getString(msgId);
        showCustomTranslucentToast(context, msg);
    }

    private static void showCustomTranslucentToast(Context context, String msg){
        showCustomTranslucentToast(context, msg, Toast.LENGTH_SHORT);
    }

    private static void showCustomTranslucentToast(Context context, int msgId, int duration){
        final String msg = context.getResources().getString(msgId);
        showCustomTranslucentToast(context, msg, duration);
    }

    private static void showCustomTranslucentToast(final Context context, final String msg, final int duration) {

        if (context == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            showToast(context, msg, duration);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    showToast(context, msg, duration);
                }
            });
        }
    }

    private static void showToast(Context context, String msg, int duration) {

        if (null != context) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View layout = inflater.inflate(R.layout.toast_layout, null);
            TextView content = (TextView) layout.findViewById(R.id.toast_content);
            content.setText(msg);

            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER, 0, RTCRApplication.getInstance().screenH / 4);
            toast.setDuration(duration);
            toast.setView(layout);
            toast.show();
        }
    }
}
