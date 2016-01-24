package com.martin.snframework.managers;


import com.martin.snframework.managers.async.AsyncManagerResult;
import com.martin.snframework.managers.async.listeners.AsyncManagerListener;
import com.sn.main.SNManager;


public class BaseManager {
    public SNManager $;

    public BaseManager(SNManager _$) {
        this.$ = _$;
    }


    public void callBackSuccessResult(AsyncManagerListener _onResult, Object result) {
        callBack(_onResult, AsyncManagerResult.createSuccessResult(result));
    }

    public void callBackErrorResult(AsyncManagerListener _onResult, Object result) {
        callBack(_onResult, AsyncManagerResult.createErrorResult(result));
    }

    public void callBackSuccess(AsyncManagerListener _onResult) {
        callBack(_onResult, AsyncManagerResult.createSuccess());
    }

    public void callBackSuccess(AsyncManagerListener _onResult, String msg) {
        callBack(_onResult, AsyncManagerResult.createSuccess(msg));
    }

    public void callBackError(AsyncManagerListener _onResult, String msg) {
        callBack(_onResult, AsyncManagerResult.createError(msg));
    }

    public void callBackError(AsyncManagerListener _onResult) {
        callBack(_onResult, AsyncManagerResult.createError());
    }

    public void callBackWarning(AsyncManagerListener _onResult, String msg) {
        callBack(_onResult, AsyncManagerResult.createWarning(msg));
    }

    public void callBackWarningResult(AsyncManagerListener _onResult, Object result) {
        callBack(_onResult, AsyncManagerResult.createWarningResult(result));
    }

    public void callBackWarning(AsyncManagerListener _onResult) {
        callBack(_onResult, AsyncManagerResult.createWarning());
    }

    @Deprecated
    public void callBack(AsyncManagerListener _onResult, AsyncManagerResult _result) {
        if (_onResult != null)
            _onResult.onResult(_result);
    }

}
