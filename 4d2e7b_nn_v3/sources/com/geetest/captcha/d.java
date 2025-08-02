package com.geetest.captcha;

import android.webkit.ValueCallback;

public final class d<T> implements ValueCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5786a = new d();

    public void onReceiveValue(Object obj) {
        h0 h0Var = h0.f5812d;
        h0Var.c("DialogController javascript:jsBridge.callback('showBox') return: " + ((String) obj));
    }
}
