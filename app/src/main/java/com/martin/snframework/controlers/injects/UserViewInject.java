package com.martin.snframework.controlers.injects;

import com.martin.snframework.R;
import com.martin.snframework.models.UserModel;
import com.sn.annotation.SNInjectElement;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 16/1/30.
 */
public class UserViewInject extends BaseInject {

    @SNInjectElement(id = R.id.tvName)
    SNElement tvName;
    @SNInjectElement(id = R.id.tvDesp)
    SNElement tvDesp;

    public UserViewInject(SNElement _v) {
        super(_v);
    }

    @Override
    public void onInjectUI() {
        super.onInjectUI();
        UserModel userModel = getData(UserModel.class);
        tvName.text(userModel.getName());
        tvDesp.text(userModel.getInfo());
    }
}
