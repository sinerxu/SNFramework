package com.martin.snframework.managers.app.interfaces;

import com.martin.snframework.models.DataVersionModel;

/**
 * Created by xuhui on 16/1/18.
 */
public interface IAppVersionManager {
    /**
     * 检测版本（返回版本状态）
     * 正常
     * VERSION_STATUS_NORMAL
     * 需要更新
     * VERSION_STATUS_UPDATE
     * 强制更新
     * VERSION_STATUS_MUST_UPDATE
     *
     * @param version
     * @return
     */
    int isAppNewVersion(DataVersionModel version);
}
