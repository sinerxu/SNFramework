package com.martin.snframework.managers;

import com.martin.snframework.managers.app.impls.AppEventListenerManager;
import com.martin.snframework.managers.app.impls.AppManager;
import com.martin.snframework.managers.app.impls.JavaScriptManager;
import com.martin.snframework.managers.app.interfaces.IAppEventListenerManager;
import com.martin.snframework.managers.app.interfaces.IAppManager;
import com.martin.snframework.managers.app.interfaces.IJavaScriptManager;
import com.martin.snframework.managers.main.impls.TopicManager;
import com.martin.snframework.managers.main.interfaces.ITopicManager;
import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/1/24.
 */
public class ManagerFactory {

    SNManager $;

    public static ManagerFactory instance(SNManager _$) {
        ManagerFactory factory = new ManagerFactory();
        factory.$ = _$;
        return factory;
    }

    public IAppManager createAppManager() {
        return new AppManager($);
    }

    public IAppEventListenerManager createAppEventListenerManager() {
        return new AppEventListenerManager($);
    }

    public ITopicManager createTopicManager() {
        return new TopicManager($);
    }

    public IJavaScriptManager createJavaScriptManager() {
        return new JavaScriptManager($);
    }
}
