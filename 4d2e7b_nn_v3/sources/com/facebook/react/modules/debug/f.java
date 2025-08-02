package com.facebook.react.modules.debug;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.TreeMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f implements Choreographer.FrameCallback {
    private static final a Y = new a((DefaultConstructorMarker) null);
    private double C = 60.0d;
    private TreeMap X;

    /* renamed from: a  reason: collision with root package name */
    private final ReactContext f3259a;

    /* renamed from: b  reason: collision with root package name */
    private Choreographer f3260b;

    /* renamed from: c  reason: collision with root package name */
    private final UIManagerModule f3261c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3262d = new c();

    /* renamed from: e  reason: collision with root package name */
    private long f3263e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f3264f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f3265g;

    /* renamed from: h  reason: collision with root package name */
    private int f3266h;

    /* renamed from: i  reason: collision with root package name */
    private int f3267i;

    /* renamed from: j  reason: collision with root package name */
    private int f3268j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3269w;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f3270a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3271b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3272c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3273d;

        /* renamed from: e  reason: collision with root package name */
        private final double f3274e;

        /* renamed from: f  reason: collision with root package name */
        private final double f3275f;

        /* renamed from: g  reason: collision with root package name */
        private final int f3276g;

        public b(int i10, int i11, int i12, int i13, double d10, double d11, int i14) {
            this.f3270a = i10;
            this.f3271b = i11;
            this.f3272c = i12;
            this.f3273d = i13;
            this.f3274e = d10;
            this.f3275f = d11;
            this.f3276g = i14;
        }
    }

    public f(ReactContext reactContext) {
        m.f(reactContext, "reactContext");
        this.f3259a = reactContext;
        this.f3261c = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
    }

    public static /* synthetic */ void l(f fVar, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = fVar.C;
        }
        fVar.k(d10);
    }

    /* access modifiers changed from: private */
    public static final void m(f fVar) {
        m.f(fVar, "this$0");
        Choreographer instance = Choreographer.getInstance();
        fVar.f3260b = instance;
        if (instance != null) {
            instance.postFrameCallback(fVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void o(f fVar) {
        m.f(fVar, "this$0");
        Choreographer instance = Choreographer.getInstance();
        fVar.f3260b = instance;
        if (instance != null) {
            instance.removeFrameCallback(fVar);
        }
    }

    public final int c() {
        return this.f3267i;
    }

    public final int d() {
        return (int) (((this.C * ((double) i())) / ((double) 1000)) + ((double) 1));
    }

    public void doFrame(long j10) {
        if (this.f3263e == -1) {
            this.f3263e = j10;
        }
        long j11 = this.f3264f;
        this.f3264f = j10;
        if (this.f3262d.d(j11, j10)) {
            this.f3268j++;
        }
        this.f3265g++;
        int d10 = d();
        if ((d10 - this.f3266h) - 1 >= 4) {
            this.f3267i++;
        }
        if (this.f3269w) {
            p5.a.c(this.X);
            b bVar = new b(g(), h(), d10, this.f3267i, e(), f(), i());
            TreeMap treeMap = this.X;
            if (treeMap != null) {
                b bVar2 = (b) treeMap.put(Long.valueOf(System.currentTimeMillis()), bVar);
            }
        }
        this.f3266h = d10;
        Choreographer choreographer = this.f3260b;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public final double e() {
        if (this.f3264f == this.f3263e) {
            return 0.0d;
        }
        return (((double) g()) * 1.0E9d) / ((double) (this.f3264f - this.f3263e));
    }

    public final double f() {
        if (this.f3264f == this.f3263e) {
            return 0.0d;
        }
        return (((double) h()) * 1.0E9d) / ((double) (this.f3264f - this.f3263e));
    }

    public final int g() {
        return this.f3265g - 1;
    }

    public final int h() {
        return this.f3268j - 1;
    }

    public final int i() {
        return ((int) (((double) this.f3264f) - ((double) this.f3263e))) / 1000000;
    }

    public final void j() {
        this.f3263e = -1;
        this.f3264f = -1;
        this.f3265g = 0;
        this.f3267i = 0;
        this.f3268j = 0;
        this.f3269w = false;
        this.X = null;
    }

    public final void k(double d10) {
        if (!this.f3259a.isBridgeless()) {
            this.f3259a.getCatalystInstance().addBridgeIdleDebugListener(this.f3262d);
        }
        UIManagerModule uIManagerModule = this.f3261c;
        if (uIManagerModule != null) {
            uIManagerModule.setViewHierarchyUpdateDebugListener(this.f3262d);
        }
        this.C = d10;
        UiThreadUtil.runOnUiThread(new d(this));
    }

    public final void n() {
        if (!this.f3259a.isBridgeless()) {
            this.f3259a.getCatalystInstance().removeBridgeIdleDebugListener(this.f3262d);
        }
        UIManagerModule uIManagerModule = this.f3261c;
        if (uIManagerModule != null) {
            uIManagerModule.setViewHierarchyUpdateDebugListener((j7.a) null);
        }
        UiThreadUtil.runOnUiThread(new e(this));
    }
}
