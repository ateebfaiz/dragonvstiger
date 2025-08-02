package com.fasterxml.jackson.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    Class generator();

    String property() default "@id";

    Class resolver() default o0.class;

    Class scope() default Object.class;
}
