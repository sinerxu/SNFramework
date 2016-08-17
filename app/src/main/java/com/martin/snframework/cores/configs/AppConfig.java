package com.martin.snframework.cores.configs;

import com.martin.snframework.BuildConfig;
import com.sn.core.SNUtility;

/**
 * Created by xuhui on 16/1/24.
 */
public class AppConfig {
    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static final String APP_SHARE_ICON_FILE = "shareicon.jpg";
    public static final String APP_DOWNLOAD_URL = "http://www.91qiming.net/m/";
    public static final String APP_SHARE_URL = APP_DOWNLOAD_URL;





    public static void initAppConfig() {
        //日志开关
        SNUtility.instance().logSwitch(DEBUG);
    }
}
