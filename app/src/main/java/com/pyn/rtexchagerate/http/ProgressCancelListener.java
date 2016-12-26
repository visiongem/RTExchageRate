package com.pyn.rtexchagerate.http;

/**
 * 接口是在Dialog消失onCancel的时候回调的，用于终止网络请求
 * created at 2016/12/26 18:54
 */
public interface ProgressCancelListener {

    void onCancelProgress();

}
