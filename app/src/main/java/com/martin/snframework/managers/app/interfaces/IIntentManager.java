package com.martin.snframework.managers.app.interfaces;

import android.content.Intent;

import com.martin.snframework.models.ShareOptionModel;

/**
 * 核心Manager，获取Intent，方便activity跳转
 */
public interface IIntentManager {


    /**
     * 打开系统浏览器
     *
     * @param url
     * @return
     */
    Intent instanceSystemBrowserIntent(String url);


    /**
     * APP内打开浏览器加载url
     *
     * @param url
     * @param option
     * @return
     */
    Intent instanceInAppBrowserUrlIntent(String url, ShareOptionModel option);

    /**
     * APP内打开浏览器加载url
     *
     * @param url
     * @return
     */
    Intent instanceInAppBrowserUrlIntent(String url);


    /**
     * APP内打开浏览器加载html
     *
     * @param html
     * @param option
     * @return
     */
    Intent instanceInAppBrowserHtmlIntent(String html, ShareOptionModel option);

    /**
     * APP内打开浏览器加载html
     *
     * @param html
     * @return
     */
    Intent instanceInAppBrowserHtmlIntent(String html);

}
