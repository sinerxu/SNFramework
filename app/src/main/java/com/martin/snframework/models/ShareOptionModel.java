package com.martin.snframework.models;

import com.martin.snframework.cores.configs.AppConfig;
import com.sn.core.SNUtility;
import com.sn.main.SNManager;
import com.sn.sdk.interfaces.SNShareListener;

/**
 * Created by xuhui on 16/1/19.
 */
public class ShareOptionModel extends BaseModel {

    public ShareOptionModel(SNManager _$) {
        super(_$);
    }

    String title;
    String content;
    String url;
    String imageUrl;
    SNShareListener snShareListener;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        if (SNUtility.instance().strIsNotNullOrEmpty(url))
            return url;
        else return AppConfig.APP_SHARE_URL;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        if (SNUtility.instance().strIsNotNullOrEmpty(imageUrl))
            return imageUrl;
        else return AppConfig.APP_SHARE_ICON_FILE;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public SNShareListener getSnShareListener() {
        return snShareListener;
    }

    public void setSnShareListener(SNShareListener snShareListener) {
        this.snShareListener = snShareListener;
    }
}
