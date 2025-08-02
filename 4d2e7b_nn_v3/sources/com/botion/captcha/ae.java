package com.botion.captcha;

import android.content.Context;
import kotlin.jvm.internal.m;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final ae f18474a = new ae();

    private ae() {
    }

    public static int a(Context context, String str) {
        m.f(context, "context");
        m.f(str, "name");
        return a(context, str, "string");
    }

    public static int b(Context context, String str) {
        m.f(context, "context");
        m.f(str, "name");
        return a(context, str, "style");
    }

    private static int a(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        m.e(applicationContext, "context.applicationContext");
        return a(str, str2, applicationContext.getResources().getIdentifier(str, str2, context.getPackageName()));
    }

    private static int a(String str, String str2, int i10) {
        if (i10 == 0) {
            af afVar = af.f18475a;
            af.b("ID.getIdentifier resource: " + str + ", type: " + str2 + ", undefined");
        }
        return i10;
    }
}
