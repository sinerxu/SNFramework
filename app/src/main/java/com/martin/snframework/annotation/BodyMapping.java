package com.martin.snframework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xuhui on 16/1/29.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface BodyMapping {
    String value();
}
