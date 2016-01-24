package com.martin.snframework.managers.app.interfaces;

import com.sn.interfaces.SNAppEventListener;

import java.util.HashMap;

/**
 * Created by xuhui on 16/1/24.
 */
public interface IAppEventListenerManager {
    /**
     * 移除
     *
     * @param key
     */
    void remove(String key);

    /**
     * 设置
     *
     * @param key
     */
    void set(String key, SNAppEventListener appEventListener);

    /**
     * 执行
     *
     * @param key
     * @return
     */
    void fire(String key, HashMap<String, Object> args, boolean isRemove);

    /**
     * 执行
     *
     * @param key
     * @return
     */
    void fire(String key, HashMap<String, Object> args);

    /**
     * 执行
     *
     * @param key
     * @return
     */
    void fire(String key);
}
