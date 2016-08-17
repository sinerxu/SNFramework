package com.martin.snframework.dialogs;

import android.content.Context;
import android.os.Bundle;

import com.martin.snframework.R;
import com.sn.dialog.SNDialog;
import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/7/13.
 */
public class BaseDialog extends SNDialog {

    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
    }

    public BaseDialog(SNManager $, int theme) {
        super($, theme);
    }


    public BaseDialog(SNManager $) {
        super($);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout_resid = onLayout();
        if (layout_resid != 0) $.contentView(layout_resid);
    }

    protected int onLayout() {
        return 0;
    }

}
