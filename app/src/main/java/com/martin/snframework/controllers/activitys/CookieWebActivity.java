package com.martin.snframework.controllers.activitys;

import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.martin.snframework.R;
import com.martin.snframework.controllers.injects.UserViewInject;
import com.sn.annotation.SNInjectElement;
import com.sn.interfaces.SNAdapterOnItemClickListener;
import com.sn.main.SNElement;
import com.sn.models.SNAdapterViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhui on 16/7/7.
 */
public class CookieWebActivity extends BaseActivity {


    @SNInjectElement(id = R.id.gvTest)
    SNElement gvTest;


    @SNInjectElement(id = R.id.wvMain)
    SNElement wvMain;

    @Override
    public void onInitNavBar() {
        super.onInitNavBar();
        showNavBar();
        navTitleBar.showNavTitle("Cookie访问web");
        navTitleBar.showNavBack();
    }

    @Override
    public int onLayout() {
        return R.layout.activity_cookie_web;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
        initEvent();
    }

    void initList() {
        List<String> actions = new ArrayList<String>();
        actions.add("微商人人店");
        gvTest.bindListAdapter(actions, R.layout.adapter_user, UserViewInject.class);
    }


    void initEvent() {
        gvTest.itemClick(new SNAdapterOnItemClickListener() {
            @Override
            public void onItemClick(SNAdapterViewInject holder) {
                if (holder.getPos() == 0) {
                    wvMain.webResponsive();
                    String url = "http://weixin003.jiamingbaobao.com/app/index.php?i=2&c=entry&do=shop&m=ewei_shop&p=list&pcate=1&ccate=2";
                    wvMain.webCookie(url, "76ba___multiid=2; PHPSESSID=4dc72365135b777269a181677fa6bc46");
                    wvMain.loadUrl(url);
                }
            }
        });
    }
}
