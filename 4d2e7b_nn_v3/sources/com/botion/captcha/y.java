package com.botion.captcha;

import kotlin.jvm.internal.m;

public enum y {
    CENTER("center"),
    BOTTOM("bottom");
    
    private String value;

    private y(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        m.f(str, "<set-?>");
        this.value = str;
    }
}
