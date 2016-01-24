package com.martin.snframework.managers.model.interfaces;

import com.martin.snframework.models.UserModel;

/**
 * Created by xuhui on 15/11/10.
 */
public interface IUserModelManager {

    void setCurrentUser(UserModel user);

    UserModel getCurrentUser();

    boolean isLogin();

    void logoff();

}
