package com.fasterxml.jackson.annotation;

import com.alibaba.fastjson.JSON;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface c0 {

    public enum a {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    public enum b {
        NONE((String) null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME(JSON.DEFAULT_TYPE_KEY),
        DEDUCTION((String) null),
        CUSTOM((String) null);
        

        /* renamed from: a  reason: collision with root package name */
        private final String f4964a;

        private b(String str) {
            this.f4964a = str;
        }

        public String a() {
            return this.f4964a;
        }
    }

    public static abstract class c {
    }

    Class defaultImpl() default c0.class;

    a include() default a.PROPERTY;

    String property() default "";

    b use();

    boolean visible() default false;
}
