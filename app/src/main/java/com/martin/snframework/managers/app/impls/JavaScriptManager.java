package com.martin.snframework.managers.app.impls;

import android.webkit.JavascriptInterface;

import com.martin.snframework.managers.BaseManager;
import com.martin.snframework.managers.ManagerFactory;
import com.martin.snframework.managers.app.interfaces.IAppManager;
import com.martin.snframework.managers.app.interfaces.IJavaScriptManager;
import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/1/7.
 */


public class JavaScriptManager extends BaseManager implements IJavaScriptManager {


    IAppManager appManager;

    public JavaScriptManager(SNManager _$) {
        super(_$);
        appManager = ManagerFactory.instance($).createAppManager();
    }


    @JavascriptInterface
    @Override
    public void openUrlInApp(String url) {
        appManager.openUrlInApp(url);
    }
}
