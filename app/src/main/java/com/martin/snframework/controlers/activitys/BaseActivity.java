package com.martin.snframework.controlers.activitys;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.martin.snframework.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.sn.activity.SNNavigationSlidingActivity;
import com.sn.interfaces.SNOnClickListener;
import com.sn.main.SNConfig;

/**
 * Created by xuhui on 16/1/20.
 */
public class BaseActivity extends SNNavigationSlidingActivity {

    final static int ANIMATE_TYPE = SNConfig.SN_ANIMATE_ACTIVITY_PUSH_POP_HORIZONTAL;
    static int animateType = ANIMATE_TYPE;
    boolean isLoadNavBar = false;
    int currentAnimateType = -1;
    final static int TOAST_DURATION = 3000;
    SystemBarTintManager tintManager;
    boolean isInject = false;

    public static void restoreAnimateType() {
        animateType = ANIMATE_TYPE;
    }

    public static void setAnimateType(int _animateType) {
        animateType = _animateType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setCurrentAnimateType();
    }

    @Override
    public void finish() {
        super.finish();
        $.activityAnimateType(getCurrentAnimateType(), true);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);


    }

    private int getCurrentAnimateType() {
        if (this.currentAnimateType == -1) {
            return animateType;
        } else {
            return this.currentAnimateType;
        }
    }

    private void setCurrentAnimateType() {
        this.currentAnimateType = animateType;
        restoreAnimateType();
    }


    /**
     * 加载导航条
     */
    public void showNavBar() {
        tintManager.setTintResource(R.color.nav_bg_color);
        if (!isLoadNavBar) {
            loadNavBar($.px(38), R.color.nav_bg_color);
            isLoadNavBar = true;
        }
        navTitleBar.visible($.SN_UI_VISIBLE);
    }

    public void hideNavBar() {
        navTitleBar.visible($.SN_UI_NONE);
    }

    public SystemBarTintManager getTintManager() {
        return tintManager;
    }

    public void startActivityAnimate(Class<?> c) {
        $.startActivity(c, animateType);
    }

    public void startActivityAnimate(Intent intent) {
        $.startActivity(intent, animateType);
    }

    public void startActivityResultAnimate(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
        $.activityAnimateType(animateType);
    }

    public void startActivityResultAnimate(Class<?> c, int requestCode) {
        startActivityForResult(new Intent(this, c), requestCode);
        $.activityAnimateType(animateType);
    }

    public void toast(String msg) {
        $.toast(msg, TOAST_DURATION);
    }

    public void alert(String msg) {
        alert(msg, null);
    }

    public void alert(String msg, SNOnClickListener onClickListener) {
        alert($.stringResId(R.string.alert_title), msg, $.stringResId(R.string.alert_ok), onClickListener);
    }

    public void alert(String title, String msg, String btnTitle, SNOnClickListener onClickListener) {
        $.alert(title, msg, btnTitle, onClickListener);
    }

    public void confirm(String msg, SNOnClickListener okClickListener) {
        $.confirm($.stringResId(R.string.confirm_title), msg, $.stringResId(R.string.confirm_ok), $.stringResId(R.string.confirm_cancel), okClickListener, null);
    }

    public void confirm(String msg, SNOnClickListener okClickListener, SNOnClickListener cancelClickListener) {
        $.confirm($.stringResId(R.string.confirm_title), msg, $.stringResId(R.string.confirm_ok), $.stringResId(R.string.confirm_cancel), okClickListener, cancelClickListener);
    }

    public void confirm(String title, String msg, String ok, String cancel, SNOnClickListener okClickListener, SNOnClickListener cancelClickListener) {
        $.confirm(title, msg, ok, cancel, okClickListener, cancelClickListener);
    }
}
