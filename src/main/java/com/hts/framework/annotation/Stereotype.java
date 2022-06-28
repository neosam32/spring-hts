package com.hts.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Stereotype {
    public static final String Service = "Service";

    public static final String Business = "Business";

    public static final String Dao = "DAO";

    public static final String Undefined = "Undefined";

    String value();
}
