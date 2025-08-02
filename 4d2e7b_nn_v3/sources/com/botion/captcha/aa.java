package com.botion.captcha;

import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.m;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final aa f18457a = new aa();

    private aa() {
    }

    public static int a(Context context) {
        m.f(context, "context");
        Resources resources = context.getResources();
        m.e(resources, "context.resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        m.f(context, "context");
        Resources resources = context.getResources();
        m.e(resources, "context.resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public static boolean c(Context context) {
        m.f(context, "context");
        Resources resources = context.getResources();
        m.e(resources, "context.resources");
        if ((resources.getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }
}
