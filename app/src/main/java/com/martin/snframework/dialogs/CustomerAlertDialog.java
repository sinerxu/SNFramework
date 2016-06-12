package com.martin.snframework.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.martin.snframework.R;

/**
 * Created by xuhui on 16/6/8.
 */
public class CustomerAlertDialog extends Dialog {

    public CustomerAlertDialog(Context context) {
        super(context, R.style.ShareDialog);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_customer_alert);
    }
}
