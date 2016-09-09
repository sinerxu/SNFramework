package com.martin.snframework.models;

import com.martin.snframework.annotation.ApiMapping;
import com.martin.snframework.annotation.BodyMapping;
import com.sn.main.SNManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xuhui on 16/1/20.
 */
public class BaseModel implements Serializable, Cloneable {

    transient SNManager $;

    public void set$(SNManager _$) {
        this.$ = _$;
    }

    public BaseModel(SNManager _$) {
        this.$ = _$;
    }


    public HashMap<String, String> toBody() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Class c = getClass();
        $.util.logInfo(BaseModel.class, "class name=" + c.getName());
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String mod = Modifier.toString(field.getModifiers());
            if (mod.indexOf("static") != -1)
                continue;
            try {
                String fieldNames = field.getName();
                if (field.isAnnotationPresent(BodyMapping.class)) {
                    try {
                        BodyMapping mapping = (BodyMapping) field.getAnnotation(BodyMapping.class);
                        fieldNames = mapping.value();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                hashMap.put(fieldNames, field.get(this).toString());
            } catch (Exception ex) {
                ex.printStackTrace();
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

    public void fromJson(String json) {
        fromJson($.util.jsonParse(json));
    }

    public void fromJson(JSONObject jsonObject) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldNames = field.getName();
                if (field.isAnnotationPresent(ApiMapping.class)) {
                    try {
                        ApiMapping mapping = (ApiMapping) field.getAnnotation(ApiMapping.class);
                        fieldNames = mapping.value();
                    } catch (Exception ex) {
                        fieldNames = field.getName();
                    }
                }
                String[] fns = fieldNames.split(",");
                for (String fieldName : fns) {
                    if ($.util.jsonNotIsNullOrNoHas(jsonObject, fieldName)) {
                        try {
                            if ($.util.refClassIsEqual(field.getType(), String.class)) {
                                field.set(this, jsonObject.get(fieldName).toString());
                            } else if ($.util.refClassIsEqual(field.getType(), int.class)) {
                                field.set(this, Integer.parseInt(jsonObject.get(fieldName).toString()));
                            } else if ($.util.refClassIsEqual(field.getType(), boolean.class)) {
                                String r = jsonObject.get(fieldName).toString();
                                if (r.equals("0")) {
                                    field.set(this, false);
                                } else if (r.equals("1")) {
                                    field.set(this, true);
                                } else {
                                    field.set(this, Boolean.parseBoolean(r));
                                }
                            } else if ($.util.refClassIsEqual(field.getType(), float.class)) {
                                field.set(this, Float.parseFloat(jsonObject.get(fieldName).toString()));
                            } else if ($.util.refClassIsEqual(field.getType(), double.class)) {
                                field.set(this, Double.parseDouble(jsonObject.get(fieldName).toString()));
                            } else if ($.util.refClassIsEqual(field.getType(), List.class)) {
                                JSONArray arrays = jsonObject.getJSONArray(fieldName);
                                List<BaseModel> list = (List) field.get(this);
                                Type fc = field.getGenericType();
                                if (fc == null) continue;
                                Class baseModelClass = null;
                                if (fc instanceof ParameterizedType) {
                                    ParameterizedType pt = (ParameterizedType) fc;
                                    baseModelClass = (Class) pt.getActualTypeArguments()[0];
                                }
                                if (baseModelClass == null) continue;
                                for (int i = 0; i < arrays.length(); i++) {
                                    BaseModel baseModel = (BaseModel) baseModelClass.getConstructor(SNManager.class).newInstance($);
                                    baseModel.set$($);
                                    baseModel.fromJson(arrays.getJSONObject(i));
                                    list.add(baseModel);
                                }


                            }
                        } catch (Exception ex) {

                        }
                        break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
