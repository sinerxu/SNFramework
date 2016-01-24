package com.martin.snframework.controlers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.martin.snframework.models.UserModel;
import com.sn.annotation.SNInjectElement;
import com.sn.main.SNElement;

public class MainActivity extends BaseActivity {

    @SNInjectElement(id = R.id.tvUserName)
    SNElement tvUserName;
    @SNInjectElement(id = R.id.tvAge)
    SNElement tvAge;
    @SNInjectElement(id = R.id.tvIntroduce)
    SNElement tvIntroduce;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $.contentView(R.layout.activity_main, this);


        UserModel userModel = new UserModel($, "徐辉", 24);
        tvUserName.text(userModel.getName());
        tvAge.text(userModel.getShowAge());
        tvIntroduce.text(userModel.getInfo());
    }
}
