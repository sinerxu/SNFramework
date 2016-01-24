package com.martin.snframework.managers.app.interfaces;

import com.martin.snframework.models.ShareOptionModel;

/**
 * 核心Manager，管理app的各种操作
 */
public interface IAppManager {


    boolean appRunningForeground();


    boolean appRunning();

    void setAppRunning(boolean isRun);


    String readSource();

    String getMachineCode();

    String getVersionName();

    String getTemplatesPath();

    String getTemplatesStaticPath();


    /**
     * 从手机系统浏览器打开网页
     *
     * @param url
     */
    void openUrl(String url);


    /**
     * 调用app内的浏览器内打开网页
     *
     * @param url
     */
    void openUrlInApp(String url, ShareOptionModel option);

    /**
     * 调用app内的浏览器内打开网页
     *
     * @param url
     */
    void openUrlInApp(String url);

    /**
     * 加载html
     *
     * @param html
     */
    void openHtml(String html, ShareOptionModel option);

    /**
     * 加载html
     *
     * @param html
     */
    void openHtml(String html);

}
