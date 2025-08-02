package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.e;
import com.facebook.react.devsupport.e0;
import com.facebook.react.s0;
import e6.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k6.c;
import k6.h;
import k6.i;
import p5.a;
import w6.b;

public class j0 {
    private static final String B = "j0";
    private h A = null;

    /* renamed from: a  reason: collision with root package name */
    private final List f20812a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private String f20813b;

    /* renamed from: c  reason: collision with root package name */
    private JSBundleLoader f20814c;

    /* renamed from: d  reason: collision with root package name */
    private String f20815d;

    /* renamed from: e  reason: collision with root package name */
    private NotThreadSafeBridgeIdleDebugListener f20816e;

    /* renamed from: f  reason: collision with root package name */
    private Application f20817f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20818g;

    /* renamed from: h  reason: collision with root package name */
    private e0 f20819h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20820i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20821j;

    /* renamed from: k  reason: collision with root package name */
    private LifecycleState f20822k;

    /* renamed from: l  reason: collision with root package name */
    private JSExceptionHandler f20823l;

    /* renamed from: m  reason: collision with root package name */
    private Activity f20824m;

    /* renamed from: n  reason: collision with root package name */
    private b f20825n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f20826o;

    /* renamed from: p  reason: collision with root package name */
    private k6.b f20827p;

    /* renamed from: q  reason: collision with root package name */
    private JavaScriptExecutorFactory f20828q;

    /* renamed from: r  reason: collision with root package name */
    private int f20829r = 1;

    /* renamed from: s  reason: collision with root package name */
    private int f20830s = -1;

    /* renamed from: t  reason: collision with root package name */
    private UIManagerProvider f20831t;

    /* renamed from: u  reason: collision with root package name */
    private Map f20832u;

    /* renamed from: v  reason: collision with root package name */
    private s0.a f20833v;

    /* renamed from: w  reason: collision with root package name */
    private j f20834w;

    /* renamed from: x  reason: collision with root package name */
    private c f20835x;

    /* renamed from: y  reason: collision with root package name */
    private h f20836y = null;

    /* renamed from: z  reason: collision with root package name */
    private n6.b f20837z = null;

    j0() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r2.getMessage().contains("__cxa_bad_typeid") == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        com.facebook.react.jscexecutor.JSCExecutor.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        return new q6.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        z2.a.j(B, "Unable to load neither the Hermes nor the JSC native library. Your application is not built correctly and will fail to execute");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.bridge.JavaScriptExecutorFactory c(java.lang.String r2, java.lang.String r3, android.content.Context r4) {
        /*
            r1 = this;
            com.facebook.react.g0.J(r4)
            com.facebook.react.h r4 = r1.f20836y
            if (r4 != 0) goto L_0x0030
            com.facebook.hermes.reactexecutor.HermesExecutor.a()     // Catch:{ UnsatisfiedLinkError -> 0x0010 }
            com.facebook.hermes.reactexecutor.a r4 = new com.facebook.hermes.reactexecutor.a     // Catch:{ UnsatisfiedLinkError -> 0x0010 }
            r4.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0010 }
            return r4
        L_0x0010:
            com.facebook.react.jscexecutor.JSCExecutor.b()     // Catch:{ UnsatisfiedLinkError -> 0x0019 }
            q6.a r4 = new q6.a     // Catch:{ UnsatisfiedLinkError -> 0x0019 }
            r4.<init>(r2, r3)     // Catch:{ UnsatisfiedLinkError -> 0x0019 }
            return r4
        L_0x0019:
            r2 = move-exception
            java.lang.String r3 = B
            java.lang.String r4 = "Unable to load neither the Hermes nor the JSC native library. Your application is not built correctly and will fail to execute"
            z2.a.j(r3, r4)
            java.lang.String r3 = r2.getMessage()
            java.lang.String r4 = "__cxa_bad_typeid"
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x002f
            r2 = 0
            return r2
        L_0x002f:
            throw r2
        L_0x0030:
            com.facebook.react.h r0 = com.facebook.react.h.HERMES
            if (r4 != r0) goto L_0x003d
            com.facebook.hermes.reactexecutor.HermesExecutor.a()
            com.facebook.hermes.reactexecutor.a r2 = new com.facebook.hermes.reactexecutor.a
            r2.<init>()
            return r2
        L_0x003d:
            com.facebook.react.jscexecutor.JSCExecutor.b()
            q6.a r4 = new q6.a
            r4.<init>(r2, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.j0.c(java.lang.String, java.lang.String, android.content.Context):com.facebook.react.bridge.JavaScriptExecutorFactory");
    }

    public j0 a(m0 m0Var) {
        this.f20812a.add(m0Var);
        return this;
    }

    public g0 b() {
        boolean z10;
        JavaScriptExecutorFactory javaScriptExecutorFactory;
        String str;
        a.d(this.f20817f, "Application property has not been set with this builder");
        if (this.f20822k == LifecycleState.RESUMED) {
            a.d(this.f20824m, "Activity needs to be set if initial lifecycle state is resumed");
        }
        boolean z11 = true;
        if (!this.f20818g && this.f20813b == null && this.f20814c == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        a.b(z10, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
        if (this.f20815d == null && this.f20813b == null && this.f20814c == null) {
            z11 = false;
        }
        a.b(z11, "Either MainModulePath or JS Bundle File needs to be provided");
        String packageName = this.f20817f.getPackageName();
        String d10 = a7.a.d();
        Application application = this.f20817f;
        Activity activity = this.f20824m;
        b bVar = this.f20825n;
        JavaScriptExecutorFactory javaScriptExecutorFactory2 = this.f20828q;
        if (javaScriptExecutorFactory2 == null) {
            javaScriptExecutorFactory = c(packageName, d10, application.getApplicationContext());
        } else {
            javaScriptExecutorFactory = javaScriptExecutorFactory2;
        }
        JSBundleLoader jSBundleLoader = this.f20814c;
        if (jSBundleLoader == null && (str = this.f20813b) != null) {
            jSBundleLoader = JSBundleLoader.createAssetLoader(this.f20817f, str, false);
        }
        JSBundleLoader jSBundleLoader2 = jSBundleLoader;
        String str2 = this.f20815d;
        List list = this.f20812a;
        boolean z12 = this.f20818g;
        e0 e0Var = this.f20819h;
        if (e0Var == null) {
            e0Var = new e();
        }
        return new g0(application, activity, bVar, javaScriptExecutorFactory, jSBundleLoader2, str2, list, z12, e0Var, this.f20820i, this.f20821j, this.f20816e, (LifecycleState) a.d(this.f20822k, "Initial lifecycle state was not set"), this.f20823l, (i) null, this.f20826o, this.f20827p, this.f20829r, this.f20830s, this.f20831t, this.f20832u, this.f20833v, this.f20834w, this.f20835x, this.f20837z, this.A);
    }

    public j0 d(Application application) {
        this.f20817f = application;
        return this;
    }

    public j0 e(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            str2 = "assets://" + str;
        }
        this.f20813b = str2;
        this.f20814c = null;
        return this;
    }

    public j0 f(n6.b bVar) {
        this.f20837z = bVar;
        return this;
    }

    public j0 g(c cVar) {
        this.f20835x = cVar;
        return this;
    }

    public j0 h(e0 e0Var) {
        this.f20819h = e0Var;
        return this;
    }

    public j0 i(LifecycleState lifecycleState) {
        this.f20822k = lifecycleState;
        return this;
    }

    public j0 j(String str) {
        if (!str.startsWith("assets://")) {
            return k(JSBundleLoader.createFileLoader(str));
        }
        this.f20813b = str;
        this.f20814c = null;
        return this;
    }

    public j0 k(JSBundleLoader jSBundleLoader) {
        this.f20814c = jSBundleLoader;
        this.f20813b = null;
        return this;
    }

    public j0 l(h hVar) {
        this.f20836y = hVar;
        return this;
    }

    public j0 m(JSExceptionHandler jSExceptionHandler) {
        this.f20823l = jSExceptionHandler;
        return this;
    }

    public j0 n(String str) {
        this.f20815d = str;
        return this;
    }

    public j0 o(JavaScriptExecutorFactory javaScriptExecutorFactory) {
        this.f20828q = javaScriptExecutorFactory;
        return this;
    }

    public j0 p(boolean z10) {
        this.f20826o = z10;
        return this;
    }

    public j0 q(h hVar) {
        this.A = hVar;
        return this;
    }

    public j0 r(s0.a aVar) {
        this.f20833v = aVar;
        return this;
    }

    public j0 s(i iVar) {
        return this;
    }

    public j0 t(boolean z10) {
        this.f20820i = z10;
        return this;
    }

    public j0 u(j jVar) {
        this.f20834w = jVar;
        return this;
    }

    public j0 v(UIManagerProvider uIManagerProvider) {
        this.f20831t = uIManagerProvider;
        return this;
    }

    public j0 w(boolean z10) {
        this.f20818g = z10;
        return this;
    }
}
