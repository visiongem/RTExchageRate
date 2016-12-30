package com.pyn.rtexchagerate.view;

import android.content.Context;
import android.graphics.Canvas;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import com.pyn.rtexchagerate.R;

/**
 * describtion: 自定义键盘
 * Created by pengyn on 2016/12/30.
 */
public class MyKeyboardView extends KeyboardView {

    public MyKeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // 设置软键盘按键的布局
        Keyboard keyboard = new Keyboard(context,
                R.xml.num_keyboard);
        setKeyboard(keyboard);
        setEnabled(true);
        setPreviewEnabled(false);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
