package com.pyn.rtexchagerate.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.pyn.rtexchagerate.R;
import com.pyn.rtexchagerate.utils.ActivityStackManager;

import butterknife.ButterKnife;

/**
 * @author pengyn
 * created at 2016/9/12 15:21
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutRedId(){
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRedId());

        ButterKnife.bind(this);
        initDatas();
        ActivityStackManager.getInstance().addActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    @Override
    protected synchronized void onDestroy() {
        ActivityStackManager.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
