package com.martin.snframework.managers.app.impls;

import com.martin.snframework.managers.BaseManager;
import com.martin.snframework.managers.app.interfaces.IAppManager;
import com.martin.snframework.models.ShareOptionModel;
import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/1/24.
 */
public class AppManager extends BaseManager implements IAppManager {
    public AppManager(SNManager _$) {
        super(_$);
    }

    @Override
    public boolean appRunningForeground() {
        return false;
    }

    @Override
    public boolean appRunning() {
        return false;
    }

    @Override
    public void setAppRunning(boolean isRun) {

    }

    @Override
    public String readSource() {
        return null;
    }

    @Override
    public String getMachineCode() {
        return null;
    }

    @Override
    public String getVersionName() {
        return null;
    }

    @Override
    public String getTemplatesPath() {
        return null;
    }

    @Override
    public String getTemplatesStaticPath() {
        return null;
    }

    /**
     * 从手机系统浏览器打开网页
     *
     * @param url
     */
    @Override
    public void openUrl(String url) {

    }

    /**
     * 调用app内的浏览器内打开网页
     *
     * @param url
     * @param option
     */
    @Override
    public void openUrlInApp(String url, ShareOptionModel option) {

    }

    /**
     * 调用app内的浏览器内打开网页
     *
     * @param url
     */
    @Override
    public void openUrlInApp(String url) {

    }

    /**
     * 加载html
     *
     * @param html
     * @param option
     */
    @Override
    public void openHtml(String html, ShareOptionModel option) {

    }

    /**
     * 加载html
     *
     * @param html
     */
    @Override
    public void openHtml(String html) {

    }
}
