package com.facebook.react;

import android.app.Application;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.e0;
import com.facebook.react.s0;
import e6.i;
import e6.j;
import java.util.List;
import k6.c;
import k6.h;
import n6.b;

public abstract class k0 {

    /* renamed from: a  reason: collision with root package name */
    private final Application f20840a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f20841b;

    class a implements j {
        a() {
        }

        public i c(String str) {
            return null;
        }
    }

    protected k0(Application application) {
        this.f20840a = application;
    }

    /* access modifiers changed from: protected */
    public g0 a() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        j0 c10 = c();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return c10.b();
    }

    /* access modifiers changed from: protected */
    public final Application b() {
        return this.f20840a;
    }

    /* access modifiers changed from: protected */
    public j0 c() {
        j0 p10 = g0.t().d(this.f20840a).n(k()).w(v()).h(g()).g(f()).t(s()).u(t()).m(j()).p(m());
        r();
        j0 q10 = p10.s((k6.i) null).o(l()).v(u()).i(LifecycleState.BEFORE_CREATE).r(q()).l(i()).f(e()).q(o());
        for (m0 a10 : n()) {
            q10.a(a10);
        }
        String h10 = h();
        if (h10 != null) {
            q10.j(h10);
        } else {
            q10.e((String) p5.a.c(d()));
        }
        return q10;
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "index.android.bundle";
    }

    /* access modifiers changed from: protected */
    public b e() {
        return null;
    }

    /* access modifiers changed from: protected */
    public c f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public e0 g() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String h();

    /* access modifiers changed from: protected */
    public abstract h i();

    /* access modifiers changed from: protected */
    public JSExceptionHandler j() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract String k();

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory l() {
        return null;
    }

    public boolean m() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract List n();

    /* access modifiers changed from: protected */
    public h o() {
        return null;
    }

    public g0 p() {
        if (this.f20841b == null) {
            ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.f20841b = a();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.f20841b;
    }

    /* access modifiers changed from: protected */
    public abstract s0.a q();

    /* access modifiers changed from: protected */
    public k6.i r() {
        return null;
    }

    public boolean s() {
        return true;
    }

    public j t() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public abstract UIManagerProvider u();

    public abstract boolean v();

    public boolean w() {
        if (this.f20841b != null) {
            return true;
        }
        return false;
    }
}
