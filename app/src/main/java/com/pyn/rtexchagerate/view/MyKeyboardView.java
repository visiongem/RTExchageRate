package com.pyn.rtexchagerate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;
import com.pyn.rtexchagerate.R;
import com.pyn.rtexchagerate.utils.ToastMaker;

/**
 * describtion: 自定义键盘
 * Created by pengyn on 2016/12/30.
 */
public class MyKeyboardView extends LinearLayout implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, pointBtn, acBtn;
    private ImageButton deleteIBtn;
    private Button[] numBtns;
    private OnNumberClickListener onNumberClickListener;
    private Context mContext;

    // 子控件是否可以接受点击事件
    private boolean childClickable = true;

    public MyKeyboardView(Context context) {
        this(context, null);
    }

    public MyKeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(context);
    }

    private void initView(Context context) {

        View view = View.inflate(context, R.layout.layout_key, this);
        btn0 = (Button) view.findViewById(R.id.btn_0);
        btn1 = (Button) view.findViewById(R.id.btn_1);
        btn2 = (Button) view.findViewById(R.id.btn_2);
        btn3 = (Button) view.findViewById(R.id.btn_3);
        btn4 = (Button) view.findViewById(R.id.btn_4);
        btn5 = (Button) view.findViewById(R.id.btn_5);
        btn6 = (Button) view.findViewById(R.id.btn_6);
        btn7 = (Button) view.findViewById(R.id.btn_7);
        btn8 = (Button) view.findViewById(R.id.btn_8);
        btn9 = (Button) view.findViewById(R.id.btn_9);
        pointBtn = (Button) view.findViewById(R.id.btn_point);
        acBtn = (Button) view.findViewById(R.id.btn_ac);
        deleteIBtn = (ImageButton) view.findViewById(R.id.ibtn_delete);

        numBtns = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, pointBtn, acBtn};

        for (Button numBtn : numBtns) {
            numBtn.setOnClickListener(MyKeyboardView.this);
        }

        deleteIBtn.setOnClickListener(MyKeyboardView.this);
    }

    @Override
    public void onClick(View view) {

        if (onNumberClickListener != null) {

            switch (view.getId()) {

                case R.id.btn_0:
                    Logger.d("dianjile btn0");
                    onNumberClickListener.onNumberReturn("0");
                    break;

                case R.id.btn_1:
                    ToastMaker.showShortToast("1");
                    onNumberClickListener.onNumberReturn("1");
                    break;

                case R.id.btn_2:
                    onNumberClickListener.onNumberReturn("2");
                    break;

                case R.id.btn_3:
                    onNumberClickListener.onNumberReturn("3");
                    break;

                case R.id.btn_4:
                    onNumberClickListener.onNumberReturn("4");
                    break;

                case R.id.btn_5:
                    onNumberClickListener.onNumberReturn("5");
                    break;

                case R.id.btn_6:
                    onNumberClickListener.onNumberReturn("6");
                    break;

                case R.id.btn_7:
                    onNumberClickListener.onNumberReturn("7");
                    break;

                case R.id.btn_8:
                    onNumberClickListener.onNumberReturn("8");
                    break;

                case R.id.btn_9:
                    onNumberClickListener.onNumberReturn("9");
                    break;

                case R.id.btn_point:
                    onNumberClickListener.onNumberReturn(".");
                    break;

                case R.id.btn_ac:
                    onNumberClickListener.onNumberAC();
                    break;

                case R.id.ibtn_delete:
                    onNumberClickListener.onNumberDelete();
                    break;

            }
        }
    }

    public OnNumberClickListener getOnNumberClickListener() {
        return onNumberClickListener;
    }

    public void setOnNumberClickListener(OnNumberClickListener onNumberClickListener) {
        this.onNumberClickListener = onNumberClickListener;
    }

    public interface OnNumberClickListener {

        // 回调点击的数字
        public void onNumberReturn(String number);

        // 删除键的回调
        public void onNumberDelete();

        // AC键的回调
        public void onNumberAC();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 返回true则拦截子控件所有点击事件，如果childclickable为true，则需返回false
        return !childClickable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setChildClickable(boolean clickable) {
        childClickable = clickable;
    }

}
