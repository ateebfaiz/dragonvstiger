package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface e0 {
    boolean enabled() default true;

    String prefix() default "";

    String suffix() default "";
}
