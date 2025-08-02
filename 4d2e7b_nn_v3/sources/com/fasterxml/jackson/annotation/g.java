package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface g {

    public enum a {
        DEFAULT,
        DELEGATING,
        PROPERTIES,
        DISABLED
    }

    a mode() default a.DEFAULT;
}
