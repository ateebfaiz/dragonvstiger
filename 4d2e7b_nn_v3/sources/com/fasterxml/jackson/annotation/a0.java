package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface a0 {

    public @interface a {
        String name() default "";

        String[] names() default {};

        Class value();
    }

    a[] value();
}
