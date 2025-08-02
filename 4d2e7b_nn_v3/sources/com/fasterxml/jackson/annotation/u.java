package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface u {

    public enum a {
        AUTO,
        READ_ONLY,
        WRITE_ONLY,
        READ_WRITE
    }

    a access() default a.AUTO;

    String defaultValue() default "";

    int index() default -1;

    String namespace() default "";

    boolean required() default false;

    String value() default "";
}
