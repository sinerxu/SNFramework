package com.martin.snframework.managers.app.impls;

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
    public void fire(String key, HashMap<String, Object> args) {
        fire(key, args, false);
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
     * @param args
     * @param isRemove @return
     */
    @Override
    public void fire(String key, HashMap<String, Object> args, boolean isRemove) {
        $.fireAppEventListener(key, args, isRemove);
    }

}
