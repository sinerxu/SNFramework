package com.martin.snframework.managers.app.interfaces;

import com.martin.snframework.models.UserModel;

/**
 * 核心Manager 本地数据存储管理类
 */
public interface IAppPropManager {


    //region manager current user
    void removeCurrentUser();

    void setCurrentUser(UserModel user);

    UserModel getCurrentUser();
    //endregion


    //region manager already open app
    void removeAlreadyOpenApp();

    void setAlreadyOpenApp(boolean val);

    boolean getAlreadyOpenApp();
    //endregion


}
