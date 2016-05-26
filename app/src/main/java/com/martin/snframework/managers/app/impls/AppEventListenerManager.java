package com.martin.snframework.managers.app.impls;

import android.content.Intent;

import com.martin.snframework.managers.BaseManager;
import com.martin.snframework.managers.app.interfaces.IAppEventListenerManager;
import com.sn.interfaces.SNAppEventListener;
import com.sn.main.SNManager;

import java.util.HashMap;

/**
 * Created by xuhui on 16/1/13.
 */
public class AppEventListenerManager extends BaseManager implements IAppEventListenerManager {
    public AppEventListenerManager(SNManager _$) {
        super(_$);
    }


    /**
     * 移除
     *
     * @param key
     */
    @Override
    public void remove(String key) {
        $.removeAppEventListener(key);
    }

    /**
     * 设置
     *
     * @param key
     */
    @Override
    public void set(String key, SNAppEventListener appEventListener) {
        $.setAppEventListener(key, appEventListener);
    }

    /**
     * 执行
     *
     * @param key
     * @return
     */
    @Override
    public void fire(String key, Intent intent) {
        fire(key, intent, false);
    }

    /**
     * 执行
     *
     * @param key
     * @return
     */
    @Override
    public void fire(String key) {
        fire(key, null);
    }

    /**
     * 执行
     *
     * @param key
     * @param intent
     * @param isRemove @return
     */
    @Override
    public void fire(String key, Intent intent, boolean isRemove) {
        $.fireAppEventListener(key, intent, isRemove);
    }

}
