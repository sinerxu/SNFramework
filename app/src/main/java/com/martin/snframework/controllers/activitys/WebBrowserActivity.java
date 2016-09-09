package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.controlers.SNWebView;
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
        final SNWebView outView = wvMain.toView(SNWebView.class);
        outView.setRefreshEnable(true);
        outView.setOnPullRefreshListener(new SNWebView.SNOnPullRefreshListener() {
            @Override
            public void onRefresh() {
                wvMain.loadUrl("http://beile.jiamingbaobao.com/");
            }
        });
        outView.setAutoRefresh(true);
       // wvMain.loadUrl("http://weixin003.jiamingbaobao.com/app/index.php?i=2&c=entry&do=shop&m=ewei_shop&uid=3");
    }
}
