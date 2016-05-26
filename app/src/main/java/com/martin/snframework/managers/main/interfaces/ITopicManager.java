package com.martin.snframework.managers.main.interfaces;

import com.martin.snframework.managers.async.listeners.AsyncManagerListener;

/**
 * Created by xuhui on 16/5/18.
 */
public interface ITopicManager {
    void getTopics(int page, int pageSize, AsyncManagerListener asyncManagerListener);
}
