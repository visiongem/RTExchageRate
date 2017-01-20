package com.pyn.rtexchagerate.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.pyn.rtexchagerate.R;
import com.pyn.rtexchagerate.utils.ToastMaker;

import butterknife.BindView;
import butterknife.OnClick;

public class RTExchangeRateFragment extends BaseFragment {

    @BindView(R.id.tv_one_name)
    TextView oneNameTv;
    @BindView(R.id.tv_two_name)
    TextView twoNameTV;
    @BindView(R.id.edt_one_num)
    EditText oneNumEdt;
    @BindView(R.id.edt_two_num)
    EditText twoNumEdt;
    @BindView(R.id.refresh_rate)
    SwipeRefreshLayout swipeRefresh;

    public static RTExchangeRateFragment newInstance() {
        RTExchangeRateFragment fragment = new RTExchangeRateFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_rtexchange_rate;
    }

    @Override
    protected void initData() {

        hideSoftInputMethod(oneNumEdt);
        hideSoftInputMethod(twoNumEdt);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDatas();
            }
        });
    }

    @OnClick({R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_ac, R.id.btn_point, R.id.ibtn_delete})
    public void numsOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                ToastMaker.showShortToast("0");
                break;
            case R.id.btn_1:
                ToastMaker.showShortToast("1");
                break;
            case R.id.btn_2:
                ToastMaker.showShortToast("2");
                break;
            case R.id.btn_3:
                ToastMaker.showShortToast("3");
                break;
            case R.id.btn_4:
                ToastMaker.showShortToast("4");
                break;
            case R.id.btn_5:
                ToastMaker.showShortToast("5");
                break;
            case R.id.btn_6:
                ToastMaker.showShortToast("6");
                break;
            case R.id.btn_7:
                ToastMaker.showShortToast("7");
                break;
            case R.id.btn_8:
                ToastMaker.showShortToast("8");
                break;
            case R.id.btn_9:
                ToastMaker.showShortToast("9");
                break;
            case R.id.btn_ac:
                ToastMaker.showShortToast("ac");
                break;
            case R.id.btn_point:
                ToastMaker.showShortToast("point");
                break;
            case R.id.ibtn_delete:
                ToastMaker.showShortToast("delete");
                break;
        }
    }

    /**
     * 刷新当前汇率换算
     */
    private void refreshDatas() {
        ToastMaker.showShortToast("刷新喽");
        swipeRefresh.setRefreshing(false);
    }

    /**
     * Edittext 隐藏系统弹出的键盘,显示出光标
     *
     * @param editText
     */
    public void hideSoftInputMethod(EditText editText) {

        mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if (currentVersion >= 16) {
            // 4.2
            methodName = "setShowSoftInputOnFocus";
            // 19 setShowSoftInputOnFocus
        } else if (currentVersion >= 14) {
            // 4.0
            methodName = "setSoftInputShownOnFocus";
        }

        if (methodName == null) {
            editText.setInputType(InputType.TYPE_NULL);
        } else {
            Class<TextView> cls = TextView.class;
            java.lang.reflect.Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);
            } catch (Exception e) {
                editText.setInputType(InputType.TYPE_NULL);
                e.printStackTrace();
            }
        }
    }
}
