package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;

/**
 * Created by xuhui on 16/5/25.
 */
public class TabMainActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $.contentView(R.layout.activity_tab_main);
        showNavBar();
        navTitleBar.showNavTitle("Tab Main");
    }
}
