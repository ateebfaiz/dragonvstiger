package com.geetest.captcha;

import android.content.Context;
import kotlin.jvm.internal.m;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f5806a = new g0();

    public final int a(Context context, String str) {
        m.f(context, "context");
        m.f(str, "name");
        return a(context, str, "string");
    }

    public final int b(Context context, String str) {
        m.f(context, "context");
        m.f(str, "name");
        return a(context, str, "style");
    }

    public final int a(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        m.e(applicationContext, "context.applicationContext");
        int identifier = applicationContext.getResources().getIdentifier(str, str2, context.getPackageName());
        if (identifier == 0) {
            h0 h0Var = h0.f5812d;
            h0Var.c("ID.getIdentifier resource: " + str + ", type: " + str2 + ", undefined");
        }
        return identifier;
    }
}
