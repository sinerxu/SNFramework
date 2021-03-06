package com.martin.snframework.widgets.alert;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.martin.snframework.dialogs.CustomerAlertDialog;
import com.sn.dialog.SNUIAlertDialog;
import com.sn.interfaces.SNOnClickListener;
import com.sn.postting.alert.SNAlert;

/**
 * Created by xuhui on 16/6/8.
 */
public class CustomerAlert extends SNAlert {


    public CustomerAlert() {
    }

    public CustomerAlert(Context _context) {
        super(_context);
    }

    @Override
    public void alert(String title, String msg, String buttonTitle, final SNOnClickListener onClickListener) {
        super.alert(title, msg, buttonTitle, onClickListener);
        DialogInterface.OnClickListener _onClick = null;
        if (onClickListener != null) {
            _onClick = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (onClickListener != null)
                        onClickListener.onClick(null);
                    dialogInterface.cancel();
                }
            };
        }
//        Dialog alertDialog = new SNUIAlertDialog.Builder(context).setTitle(title).setMessage(msg)
//                .setPositiveButton(buttonTitle, _onClick).create();
//        alertDialog.show();

        Dialog alertDialog = new CustomerAlertDialog(context);
        alertDialog.show();
    }

    @Override
    public void confirm(String title, String msg, String btnOkTitle, String btnCancelTitle, final SNOnClickListener okClick, final SNOnClickListener cancelClick) {
        super.confirm(title, msg, btnOkTitle, btnCancelTitle, okClick, cancelClick);


        DialogInterface.OnClickListener _onClick = null;
        DialogInterface.OnClickListener _cancelClick = null;

        if (okClick != null) {
            _onClick = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if (okClick != null)
                        okClick.onClick(null);

                    dialogInterface.cancel();
                }
            };
        }
        if (cancelClick != null) {
            _cancelClick = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (cancelClick != null)
                        cancelClick.onClick(null);
                    dialogInterface.cancel();
                }
            };
        }
//        Dialog alertDialog = new SNUIAlertDialog.Builder(context).setTitle(title).setMessage(msg)
//                .setPositiveButton(btnOkTitle, _onClick).setNegativeButton(btnCancelTitle, _cancelClick).create();
//        alertDialog.show();

        Dialog alertDialog = new CustomerAlertDialog(context);
        alertDialog.show();
    }
}
