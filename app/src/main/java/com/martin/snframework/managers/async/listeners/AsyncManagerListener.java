package com.martin.snframework.managers.async.listeners;

import com.martin.snframework.managers.async.AsyncManagerResult;

/**
 * Created by xuhui on 16/1/24.
 */
public interface AsyncManagerListener {
    void onResult(AsyncManagerResult result);
}
