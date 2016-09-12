package com.pyn.rtexchagerate.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pyn.rtexchagerate.R;
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
    @BindView(R.id.img_exchage)
    ImageView imgExchange;

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

    }

    @OnClick({R.id.tv_one_name, R.id.tv_two_name, R.id.img_exchage})
    public void viewsOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_one_name:
                break;

            case R.id.tv_two_name:
                break;

            case R.id.img_exchage:

                String temp = tvOneName.getText().toString();
                tvOneName.setText(tvTwoName.getText().toString());
                tvTwoName.setText(temp);

                break;
        }
    }
}
