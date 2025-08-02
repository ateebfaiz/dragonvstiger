package com.bugsnag.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.p;

public final class i0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectivityManager f18758a;

    /* renamed from: b  reason: collision with root package name */
    private final g0 f18759b;

    public i0(Context context, Function2 function2) {
        g0 g0Var;
        ConnectivityManager b10 = l0.b(context);
        this.f18758a = b10;
        if (b10 == null) {
            g0Var = j4.f18812a;
        } else if (Build.VERSION.SDK_INT >= 24) {
            g0Var = new h0(b10, function2);
        } else {
            g0Var = new j0(context, b10, function2);
        }
        this.f18759b = g0Var;
    }

    public void a() {
        try {
            o.a aVar = o.f12592b;
            this.f18759b.a();
            o.b(Unit.f12577a);
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            o.b(p.a(th));
        }
    }

    public boolean b() {
        Object obj;
        try {
            o.a aVar = o.f12592b;
            obj = o.b(Boolean.valueOf(this.f18759b.b()));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (o.d(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public String c() {
        Object obj;
        try {
            o.a aVar = o.f12592b;
            obj = o.b(this.f18759b.c());
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (o.d(obj) != null) {
            obj = "unknown";
        }
        return (String) obj;
    }
}
