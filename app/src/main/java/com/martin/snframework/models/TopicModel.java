package com.martin.snframework.models;

import com.martin.snframework.annotation.ApiMapping;
import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/5/18.
 */
public class TopicModel extends BaseModel {
    public TopicModel(SNManager _$) {
        super(_$);
    }

    @ApiMapping("UserName")
    String username;

    @ApiMapping("Avatar")
    String avatar;

    @ApiMapping("Subject")
    String title;

    @ApiMapping("TopicText")
    String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


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
}
