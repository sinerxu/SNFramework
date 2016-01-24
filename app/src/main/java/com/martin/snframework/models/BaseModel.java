package com.martin.snframework.models;

import com.sn.annotation.SNMapping;
import com.sn.main.SNManager;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Created by xuhui on 16/1/20.
 */
public class BaseModel implements Serializable, Cloneable {
    
    SNManager $;

    public BaseModel(SNManager _$) {
        this.$ = _$;
    }




    public HashMap<String, String> toBody() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Class c = getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String mod = Modifier.toString(field.getModifiers());
            if (mod.indexOf("static") != -1)
                continue;
            try {
                hashMap.put(field.getName(), field.get(this).toString());
            } catch (Exception ex) {
            }
        }
        return hashMap;
    }

    @Override
    public BaseModel clone() {
        try {
            return (BaseModel) super.clone();
        } catch (Exception e) {
            return null;
        }

    }
}
