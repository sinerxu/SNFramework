package com.martin.snframework.models;

import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/1/18.
 */
public class DataVersionModel extends BaseModel {

    public DataVersionModel(SNManager _$) {
        super(_$);
    }

    String current;
    String min;
    String download;

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }
}
