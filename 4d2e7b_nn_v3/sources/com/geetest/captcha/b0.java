package com.geetest.captcha;

import kotlin.jvm.internal.m;

public enum b0 {
    CENTER("center"),
    BOTTOM("bottom");
    
    public String value;

    /* access modifiers changed from: public */
    b0(String str) {
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
