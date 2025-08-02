package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4203a = new a();

    private a() {
    }

    private final ColorStateList a(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        m.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
        return obtainStyledAttributes.getColorStateList(0);
    }

    public static final ColorStateList b(Context context) {
        m.f(context, "context");
        return f4203a.a(context, 16842904);
    }

    public static final int c(Context context) {
        m.f(context, "context");
        ColorStateList a10 = f4203a.a(context, 16842905);
        if (a10 != null) {
            return a10.getDefaultColor();
        }
        return 0;
    }

    public static final ColorStateList d(Context context) {
        m.f(context, "context");
        return f4203a.a(context, 16842906);
    }
}
