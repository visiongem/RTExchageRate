package com.pyn.rtexchagerate.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.pyn.rtexchagerate.R;
import com.pyn.rtexchagerate.utils.ToastMaker;
import com.pyn.rtexchagerate.view.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class RTExchangeRateFragment extends BaseFragment {

    @BindView(R.id.tv_one_name)
    TextView tvOneName;
    @BindView(R.id.tv_two_name)
    TextView tvTwoName;
    @BindView(R.id.cedt_one_num)
    ClearEditText cedtOneNum;
    @BindView(R.id.tv_two_num)
    TextView tvTwoNum;
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

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDatas();
            }
        });
    }

    /**
     * 刷新当前汇率换算
     */
    private void refreshDatas() {
        ToastMaker.showShortToast("刷新喽");
        swipeRefresh.setRefreshing(false);
    }

    @OnClick({R.id.tv_one_name, R.id.tv_two_name})
    public void viewsOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_one_name:
                break;

            case R.id.tv_two_name:
                break;

        }
    }
}
