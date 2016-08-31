package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 16/8/17.
 */

public class WebBrowserActivity extends BaseActivity {


    @SNInjectElement(id = R.id.wvMain)
    SNElement wvMain;

    @Override
    public int onLayout() {
        return R.layout.activity_web_browser;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wvMain.loadUrl("http://weixin003.jiamingbaobao.com/app/index.php?i=2&c=entry&do=shop&m=ewei_shop&uid=3");
    }
}
