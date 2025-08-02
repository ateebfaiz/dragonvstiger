package com.bugsnag.android;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import kotlin.jvm.functions.Function2;

public final class a0 implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private final b1 f18604a;

    /* renamed from: b  reason: collision with root package name */
    private final Function2 f18605b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2 f18606c;

    public a0(b1 b1Var, Function2 function2, Function2 function22) {
        this.f18604a = b1Var;
        this.f18605b = function2;
        this.f18606c = function22;
    }

    public void onConfigurationChanged(Configuration configuration) {
        String o10 = this.f18604a.o();
        if (this.f18604a.x(configuration.orientation)) {
            this.f18605b.invoke(o10, this.f18604a.o());
        }
    }

    public void onLowMemory() {
        this.f18606c.invoke(Boolean.TRUE, (Object) null);
    }

    public void onTrimMemory(int i10) {
        boolean z10;
        Function2 function2 = this.f18606c;
        if (i10 >= 80) {
            z10 = true;
        } else {
            z10 = false;
        }
        function2.invoke(Boolean.valueOf(z10), Integer.valueOf(i10));
    }
}
