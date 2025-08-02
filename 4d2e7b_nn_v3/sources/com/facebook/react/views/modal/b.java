package com.facebook.react.views.modal;

import android.graphics.Point;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.u0;
import com.facebook.react.uimanager.v;
import kotlin.jvm.internal.m;

public final class b extends v {
    /* renamed from: d0 */
    public void I(u0 u0Var, int i10) {
        m.f(u0Var, "child");
        super.I(u0Var, i10);
        e1 F = F();
        m.e(F, "getThemedContext(...)");
        Point a10 = a.a(F);
        u0Var.A((float) a10.x);
        u0Var.f((float) a10.y);
    }
}
