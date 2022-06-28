package com.hts.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ServiceDataLog {
    public static final int NONE = 0;

    public static final int IN = 1;

    public static final int OUT = 2;

    public static final int BOTH = 3;

    int value();
}
