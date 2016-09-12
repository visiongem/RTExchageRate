package com.pyn.rtexchagerate.activity;

import android.support.v4.app.Fragment;

import com.pyn.rtexchagerate.fragment.RTExchangeRateFragment;

public class RTExchangeRateActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return RTExchangeRateFragment.newInstance();
    }

    @Override
    protected void initDatas() {

    }
}
