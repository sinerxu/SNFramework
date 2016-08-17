package com.martin.snframework.dialogs;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 16/6/8.
 */
public class CustomerLoadingDialog extends BaseDialog {
    @SNInjectElement(id = R.id.ivLoading)
    SNElement ivLoading;

    public CustomerLoadingDialog(Context context) {
        super(context, R.style.LoadingDialog);
    }

    @Override
    protected int onLayout() {
        return R.layout.dialog_customer_loading;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ivLoading.toView(ImageView.class).setBackgroundResource(R.drawable.frame_loadding);
        AnimationDrawable anim = (AnimationDrawable) ivLoading.toView(ImageView.class).getBackground();
        anim.start();
    }
}
