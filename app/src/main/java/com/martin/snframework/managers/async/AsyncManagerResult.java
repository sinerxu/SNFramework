package com.martin.snframework.managers.async;

/**
 * Created by xuhui on 16/1/24.
 */
public class AsyncManagerResult {
    public static final int SERVICE_RESULT_WARNING = -1;
    public static final int SERVICE_RESULT_ERROR = 0;
    public static final int SERVICE_RESULT_SUCCESS = 1;

    static final String WARNING_MESSAGE = "出现警告";
    static final String ERROR_MESSAGE = "网络错误，请稍后再试";
    static final String SUCCESS_MESSAGE = "请求成功";

    Object result;
    String message;
    int code;

    public <T> T getResult(Class<T> _class) {
        return (T) result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return code == SERVICE_RESULT_SUCCESS;
    }

    public boolean isError() {
        return code == SERVICE_RESULT_ERROR;
    }

    public boolean isWarning() {
        return code == SERVICE_RESULT_WARNING;
    }

    public static AsyncManagerResult create(Object _result, String _message, int _code) {
        AsyncManagerResult r = new AsyncManagerResult();
        r.setResult(_result);
        r.setMessage(_message);
        r.setCode(_code);
        return r;
    }

    public static AsyncManagerResult createErrorResult(Object _result) {
        return AsyncManagerResult.create(_result, ERROR_MESSAGE, SERVICE_RESULT_ERROR);
    }

    public static AsyncManagerResult createError(Object _result, String _message) {
        return AsyncManagerResult.create(_result, _message, SERVICE_RESULT_ERROR);
    }

    public static AsyncManagerResult createError(String _message) {
        return AsyncManagerResult.create(ERROR_MESSAGE, _message, SERVICE_RESULT_ERROR);
    }

    public static AsyncManagerResult createError() {
        return AsyncManagerResult.create(ERROR_MESSAGE, ERROR_MESSAGE, SERVICE_RESULT_ERROR);
    }

    public static AsyncManagerResult createSuccessResult(Object _result) {
        return AsyncManagerResult.create(_result, SUCCESS_MESSAGE, SERVICE_RESULT_SUCCESS);
    }

    public static AsyncManagerResult createSuccess(Object _result, String _message) {
        return AsyncManagerResult.create(_result, _message, SERVICE_RESULT_SUCCESS);
    }

    public static AsyncManagerResult createSuccess(String _message) {
        return AsyncManagerResult.create(SUCCESS_MESSAGE, _message, SERVICE_RESULT_SUCCESS);
    }

    public static AsyncManagerResult createSuccess() {
        return AsyncManagerResult.create(SUCCESS_MESSAGE, SUCCESS_MESSAGE, SERVICE_RESULT_SUCCESS);
    }

    public static AsyncManagerResult createWarningResult(Object _result) {
        return AsyncManagerResult.create(_result, WARNING_MESSAGE, SERVICE_RESULT_WARNING);
    }

    public static AsyncManagerResult createWarning(Object _result, String _message) {
        return AsyncManagerResult.create(_result, _message, SERVICE_RESULT_WARNING);
    }

    public static AsyncManagerResult createWarning(String _message) {
        return AsyncManagerResult.create(WARNING_MESSAGE, _message, SERVICE_RESULT_WARNING);
    }

    public static AsyncManagerResult createWarning() {
        return AsyncManagerResult.create(WARNING_MESSAGE, ERROR_MESSAGE, SERVICE_RESULT_WARNING);
    }
}
