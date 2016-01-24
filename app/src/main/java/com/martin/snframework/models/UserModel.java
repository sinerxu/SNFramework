package com.martin.snframework.models;

import com.sn.main.SNManager;

/**
 * Created by xuhui on 16/1/24.
 */
public class UserModel extends BaseModel {


    public UserModel(SNManager _$, String _name, int _age) {
        super(_$);
        setName(_name);
        setAge(_age);
    }

    String name;
    int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return $.util.strFormat("大家好，我是{0}, 今年{1}岁", getName(), getAge());
    }

    public String getShowAge() {
        return String.valueOf(getAge());
    }
}
