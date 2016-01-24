package com.martin.snframework;

import com.martin.snframework.cores.configs.AppConfig;
import com.sn.application.SNApplication;

/**
 * Created by xuhui on 15/10/31.
 */
public class MainApplication extends SNApplication implements
        Thread.UncaughtExceptionHandler {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化app配置
        AppConfig.initAppConfig();

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        $.util.logInfo(MainApplication.class, "uncaughtException");
        System.exit(0);
    }

}
