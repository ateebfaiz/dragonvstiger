package com.facebook.react.common;

import d6.a;
import kotlin.jvm.internal.m;

@a
public class JavascriptException extends RuntimeException {
    private String extraDataAsJson;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JavascriptException(String str) {
        super(str);
        m.f(str, "jsStackTrace");
    }

    public final JavascriptException setExtraDataAsJson(String str) {
        this.extraDataAsJson = str;
        return this;
    }
}
