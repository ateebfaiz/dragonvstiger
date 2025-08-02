package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import c8.b;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.events.e;
import com.facebook.yoga.f;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class j1 {

    /* renamed from: a  reason: collision with root package name */
    protected Object f3781a;

    /* renamed from: b  reason: collision with root package name */
    protected final e f3782b;

    /* renamed from: c  reason: collision with root package name */
    protected final ReactApplicationContext f3783c;

    /* renamed from: d  reason: collision with root package name */
    protected final b1 f3784d;

    /* renamed from: e  reason: collision with root package name */
    private final i2 f3785e;

    /* renamed from: f  reason: collision with root package name */
    private final r1 f3786f;

    /* renamed from: g  reason: collision with root package name */
    private final d0 f3787g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f3788h;

    /* renamed from: i  reason: collision with root package name */
    private long f3789i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f3790j;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t0 f3791a;

        a(t0 t0Var) {
            this.f3791a = t0Var;
        }

        public void run() {
            j1.this.f3784d.b(this.f3791a);
        }
    }

    j1(ReactApplicationContext reactApplicationContext, i2 i2Var, e eVar, int i10) {
        this(reactApplicationContext, i2Var, new r1(reactApplicationContext, new c0(i2Var), i10), eVar);
    }

    private void A(t0 t0Var) {
        if (t0Var.l()) {
            for (int i10 = 0; i10 < t0Var.b(); i10++) {
                A(t0Var.a(i10));
            }
            t0Var.V(this.f3787g);
        }
    }

    private void L(t0 t0Var) {
        d0.j(t0Var);
        this.f3784d.g(t0Var.q());
        for (int b10 = t0Var.b() - 1; b10 >= 0; b10--) {
            L(t0Var.a(b10));
        }
        t0Var.p();
    }

    private void c(t0 t0Var) {
        ViewManager viewManager = (ViewManager) p5.a.c(this.f3785e.c(t0Var.M()));
        if (viewManager instanceof r) {
            r rVar = (r) viewManager;
            if (rVar != null && rVar.needsCustomLayoutForChildren()) {
                throw new s("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + t0Var.M() + "). Use measure instead.");
            }
            return;
        }
        throw new s("Trying to use view " + t0Var.M() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }

    private boolean e(int i10, String str) {
        if (this.f3784d.c(i10) != null) {
            return true;
        }
        z2.a.G("ReactNative", "Unable to execute operation " + str + " on view with tag: " + i10 + ", since the view does not exist");
        return false;
    }

    private void n() {
        if (this.f3786f.U()) {
            m(-1);
        }
    }

    private void y(int i10, int i11, int[] iArr) {
        t0 c10 = this.f3784d.c(i10);
        t0 c11 = this.f3784d.c(i11);
        if (c10 == null || c11 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Tag ");
            if (c10 != null) {
                i10 = i11;
            }
            sb2.append(i10);
            sb2.append(" does not exist");
            throw new s(sb2.toString());
        }
        if (c10 != c11) {
            t0 parent = c10.getParent();
            while (parent != c11) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    throw new s("Tag " + i11 + " is not an ancestor of tag " + i10);
                }
            }
        }
        z(c10, c11, iArr);
    }

    private void z(t0 t0Var, t0 t0Var2, int[] iArr) {
        int i10;
        int i11;
        if (t0Var == t0Var2 || t0Var.t()) {
            i11 = 0;
            i10 = 0;
        } else {
            i11 = Math.round(t0Var.T());
            i10 = Math.round(t0Var.P());
            for (t0 parent = t0Var.getParent(); parent != t0Var2; parent = parent.getParent()) {
                p5.a.c(parent);
                c(parent);
                i11 += Math.round(parent.T());
                i10 += Math.round(parent.P());
            }
            c(t0Var2);
        }
        iArr[0] = i11;
        iArr[1] = i10;
        iArr[2] = t0Var.B();
        iArr[3] = t0Var.c();
    }

    public void B() {
        this.f3790j = false;
        this.f3785e.f();
    }

    public void C() {
    }

    public void D() {
        this.f3786f.V();
    }

    public void E() {
        this.f3786f.Y();
    }

    public void F(i1 i1Var) {
        this.f3786f.W(i1Var);
    }

    public void G() {
        this.f3786f.X();
    }

    public void H(View view, int i10, e1 e1Var) {
        synchronized (this.f3781a) {
            t0 h10 = h();
            h10.O(i10);
            h10.z(e1Var);
            e1Var.runOnNativeModulesQueueThread(new a(h10));
            this.f3786f.y(i10, view);
        }
    }

    public void I(int i10) {
        synchronized (this.f3781a) {
            this.f3784d.h(i10);
        }
    }

    public void J(int i10) {
        I(i10);
        this.f3786f.J(i10);
    }

    /* access modifiers changed from: protected */
    public final void K(t0 t0Var) {
        L(t0Var);
        t0Var.dispose();
    }

    public int M(int i10) {
        if (this.f3784d.f(i10)) {
            return i10;
        }
        t0 N = N(i10);
        if (N != null) {
            return N.H();
        }
        z2.a.G("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i10);
        return 0;
    }

    public final t0 N(int i10) {
        return this.f3784d.c(i10);
    }

    /* access modifiers changed from: protected */
    public final ViewManager O(String str) {
        return this.f3785e.e(str);
    }

    public void P(int i10, int i11) {
        this.f3786f.K(i10, i11);
    }

    public void Q(int i10, ReadableArray readableArray) {
        if (this.f3790j) {
            synchronized (this.f3781a) {
                try {
                    t0 c10 = this.f3784d.c(i10);
                    int i11 = 0;
                    while (i11 < readableArray.size()) {
                        t0 c11 = this.f3784d.c(readableArray.getInt(i11));
                        if (c11 != null) {
                            c10.I(c11, i11);
                            i11++;
                        } else {
                            throw new s("Trying to add unknown view tag: " + readableArray.getInt(i11));
                        }
                    }
                    this.f3787g.k(c10, readableArray);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void R(int i10, boolean z10) {
        t0 c10 = this.f3784d.c(i10);
        if (c10 != null) {
            while (c10.G() == b0.NONE) {
                c10 = c10.getParent();
            }
            this.f3786f.L(c10.q(), i10, z10);
        }
    }

    public void S(boolean z10) {
        this.f3786f.M(z10);
    }

    public void T(j7.a aVar) {
        this.f3786f.Z(aVar);
    }

    public void U(int i10, Object obj) {
        t0 c10 = this.f3784d.c(i10);
        if (c10 == null) {
            z2.a.G("ReactNative", "Attempt to set local data for view with unknown tag: " + i10);
            return;
        }
        c10.E(obj);
        n();
    }

    public void V(int i10, v0 v0Var) {
        UiThreadUtil.assertOnUiThread();
        this.f3786f.S().updateProperties(i10, v0Var);
    }

    public void W(int i10, int i11, int i12) {
        t0 c10 = this.f3784d.c(i10);
        if (c10 == null) {
            z2.a.G("ReactNative", "Tried to update size of non-existent tag: " + i10);
            return;
        }
        c10.A((float) i11);
        c10.f((float) i12);
        n();
    }

    public void X(int i10, int i11, int i12) {
        t0 c10 = this.f3784d.c(i10);
        if (c10 == null) {
            z2.a.G("ReactNative", "Tried to update non-existent root tag: " + i10);
            return;
        }
        Y(c10, i11, i12);
    }

    public void Y(t0 t0Var, int i10, int i11) {
        t0Var.g(i10, i11);
    }

    public void Z(int i10, String str, ReadableMap readableMap) {
        if (this.f3790j) {
            if (this.f3785e.c(str) != null) {
                t0 c10 = this.f3784d.c(i10);
                if (c10 == null) {
                    throw new s("Trying to update non-existent view with tag " + i10);
                } else if (readableMap != null) {
                    v0 v0Var = new v0(readableMap);
                    c10.a0(v0Var);
                    t(c10, str, v0Var);
                }
            } else {
                throw new s("Got unknown view type: " + str);
            }
        }
    }

    public void a(i1 i1Var) {
        this.f3786f.N(i1Var);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a0() {
        /*
            r13 = this;
            java.lang.String r0 = "rootTag"
            java.lang.String r1 = "UIImplementation.updateViewHierarchy"
            r2 = 0
            c8.a.c(r2, r1)
            r1 = 0
        L_0x000a:
            com.facebook.react.uimanager.b1 r4 = r13.f3784d     // Catch:{ all -> 0x0093 }
            int r4 = r4.d()     // Catch:{ all -> 0x0093 }
            if (r1 >= r4) goto L_0x00a2
            com.facebook.react.uimanager.b1 r4 = r13.f3784d     // Catch:{ all -> 0x0093 }
            int r4 = r4.e(r1)     // Catch:{ all -> 0x0093 }
            com.facebook.react.uimanager.b1 r5 = r13.f3784d     // Catch:{ all -> 0x0093 }
            com.facebook.react.uimanager.t0 r4 = r5.c(r4)     // Catch:{ all -> 0x0093 }
            java.lang.Integer r5 = r4.getWidthMeasureSpec()     // Catch:{ all -> 0x0093 }
            if (r5 == 0) goto L_0x009e
            java.lang.Integer r5 = r4.getHeightMeasureSpec()     // Catch:{ all -> 0x0093 }
            if (r5 == 0) goto L_0x009e
            java.lang.String r5 = "UIImplementation.notifyOnBeforeLayoutRecursive"
            c8.b$a r5 = c8.b.a(r2, r5)     // Catch:{ all -> 0x0093 }
            int r6 = r4.q()     // Catch:{ all -> 0x0093 }
            c8.b$a r5 = r5.a(r0, r6)     // Catch:{ all -> 0x0093 }
            r5.c()     // Catch:{ all -> 0x0093 }
            r13.A(r4)     // Catch:{ all -> 0x0099 }
            c8.a.g(r2)     // Catch:{ all -> 0x0093 }
            r13.d(r4)     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = "UIImplementation.applyUpdatesRecursive"
            c8.b$a r5 = c8.b.a(r2, r5)     // Catch:{ all -> 0x0093 }
            int r6 = r4.q()     // Catch:{ all -> 0x0093 }
            c8.b$a r5 = r5.a(r0, r6)     // Catch:{ all -> 0x0093 }
            r5.c()     // Catch:{ all -> 0x0093 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x008d }
            r5.<init>()     // Catch:{ all -> 0x008d }
            r6 = 0
            r13.b(r4, r6, r6, r5)     // Catch:{ all -> 0x008d }
            java.util.Iterator r4 = r5.iterator()     // Catch:{ all -> 0x008d }
        L_0x0062:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x008d }
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x008d }
            com.facebook.react.uimanager.t0 r5 = (com.facebook.react.uimanager.t0) r5     // Catch:{ all -> 0x008d }
            com.facebook.react.uimanager.events.e r6 = r13.f3782b     // Catch:{ all -> 0x008d }
            int r8 = r5.q()     // Catch:{ all -> 0x008d }
            int r9 = r5.R()     // Catch:{ all -> 0x008d }
            int r10 = r5.D()     // Catch:{ all -> 0x008d }
            int r11 = r5.B()     // Catch:{ all -> 0x008d }
            int r12 = r5.c()     // Catch:{ all -> 0x008d }
            r7 = -1
            com.facebook.react.uimanager.f0 r5 = com.facebook.react.uimanager.f0.c(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x008d }
            r6.c(r5)     // Catch:{ all -> 0x008d }
            goto L_0x0062
        L_0x008d:
            r0 = move-exception
            goto L_0x0095
        L_0x008f:
            c8.a.g(r2)     // Catch:{ all -> 0x0093 }
            goto L_0x009e
        L_0x0093:
            r0 = move-exception
            goto L_0x00a6
        L_0x0095:
            c8.a.g(r2)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x0099:
            r0 = move-exception
            c8.a.g(r2)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x00a2:
            c8.a.g(r2)
            return
        L_0x00a6:
            c8.a.g(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.j1.a0():void");
    }

    /* access modifiers changed from: protected */
    public void b(t0 t0Var, float f10, float f11, List list) {
        if (t0Var.l()) {
            if (t0Var.J(f10, f11) && t0Var.K() && !this.f3784d.f(t0Var.q())) {
                list.add(t0Var);
            }
            Iterable<t0> n10 = t0Var.n();
            if (n10 != null) {
                for (t0 b10 : n10) {
                    b(b10, t0Var.T() + f10, t0Var.P() + f11, list);
                }
            }
            t0Var.o(f10, f11, this.f3786f, this.f3787g);
            t0Var.d();
            this.f3787g.p(t0Var);
        }
    }

    public void b0(int i10, int i11, Callback callback) {
        t0 c10 = this.f3784d.c(i10);
        t0 c11 = this.f3784d.c(i11);
        if (c10 == null || c11 == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        callback.invoke(Boolean.valueOf(c10.X(c11)));
    }

    /* access modifiers changed from: protected */
    public void d(t0 t0Var) {
        float f10;
        b.a(0, "cssRoot.calculateLayout").a("rootTag", t0Var.q()).c();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            int intValue = t0Var.getWidthMeasureSpec().intValue();
            int intValue2 = t0Var.getHeightMeasureSpec().intValue();
            float f11 = Float.NaN;
            if (View.MeasureSpec.getMode(intValue) == 0) {
                f10 = Float.NaN;
            } else {
                f10 = (float) View.MeasureSpec.getSize(intValue);
            }
            if (View.MeasureSpec.getMode(intValue2) != 0) {
                f11 = (float) View.MeasureSpec.getSize(intValue2);
            }
            t0Var.Q(f10, f11);
        } finally {
            c8.a.g(0);
            this.f3789i = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    public void f() {
        this.f3786f.A();
    }

    public void g(ReadableMap readableMap, Callback callback) {
        this.f3786f.B(readableMap, callback);
    }

    /* access modifiers changed from: protected */
    public t0 h() {
        u0 u0Var = new u0();
        if (com.facebook.react.modules.i18nmanager.a.f().i(this.f3783c)) {
            u0Var.j(f.RTL);
        }
        u0Var.i("Root");
        return u0Var;
    }

    /* access modifiers changed from: protected */
    public t0 i(String str) {
        return this.f3785e.c(str).createShadowNodeInstance(this.f3783c);
    }

    public void j(int i10, String str, int i11, ReadableMap readableMap) {
        v0 v0Var;
        if (this.f3790j) {
            synchronized (this.f3781a) {
                try {
                    t0 i12 = i(str);
                    t0 c10 = this.f3784d.c(i11);
                    p5.a.d(c10, "Root node with tag " + i11 + " doesn't exist");
                    i12.O(i10);
                    i12.i(str);
                    i12.y(c10.q());
                    i12.z(c10.F());
                    this.f3784d.a(i12);
                    if (readableMap != null) {
                        v0Var = new v0(readableMap);
                        i12.a0(v0Var);
                    } else {
                        v0Var = null;
                    }
                    s(i12, i11, v0Var);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void k(int i10, int i11, ReadableArray readableArray) {
        if (e(i10, "dispatchViewManagerCommand: " + i11)) {
            this.f3786f.D(i10, i11, readableArray);
        }
    }

    public void l(int i10, String str, ReadableArray readableArray) {
        if (e(i10, "dispatchViewManagerCommand: " + str)) {
            this.f3786f.E(i10, str, readableArray);
        }
    }

    public void m(int i10) {
        b.a(0, "UIImplementation.dispatchViewUpdates").a("batchId", i10).c();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            a0();
            this.f3787g.o();
            this.f3786f.z(i10, uptimeMillis, this.f3789i);
        } finally {
            c8.a.g(0);
        }
    }

    public void o(int i10, float f10, float f11, Callback callback) {
        this.f3786f.F(i10, f10, f11, callback);
    }

    public Map p() {
        return this.f3786f.T();
    }

    public int q() {
        return this.f3786f.S().getRootViewNum();
    }

    /* access modifiers changed from: package-private */
    public r1 r() {
        return this.f3786f;
    }

    /* access modifiers changed from: protected */
    public void s(t0 t0Var, int i10, v0 v0Var) {
        if (!t0Var.t()) {
            this.f3787g.g(t0Var, t0Var.F(), v0Var);
        }
    }

    /* access modifiers changed from: protected */
    public void t(t0 t0Var, String str, v0 v0Var) {
        if (!t0Var.t()) {
            this.f3787g.m(t0Var, str, v0Var);
        }
    }

    public void u(int i10, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        int i11;
        int i12;
        int i13;
        int i14 = i10;
        ReadableArray readableArray6 = readableArray;
        ReadableArray readableArray7 = readableArray2;
        ReadableArray readableArray8 = readableArray3;
        ReadableArray readableArray9 = readableArray4;
        ReadableArray readableArray10 = readableArray5;
        if (this.f3790j) {
            synchronized (this.f3781a) {
                try {
                    t0 c10 = this.f3784d.c(i14);
                    if (readableArray6 == null) {
                        i11 = 0;
                    } else {
                        i11 = readableArray.size();
                    }
                    if (readableArray8 == null) {
                        i12 = 0;
                    } else {
                        i12 = readableArray3.size();
                    }
                    if (readableArray10 == null) {
                        i13 = 0;
                    } else {
                        i13 = readableArray5.size();
                    }
                    if (i11 != 0) {
                        if (readableArray7 == null || i11 != readableArray2.size()) {
                            throw new s("Size of moveFrom != size of moveTo!");
                        }
                    }
                    if (i12 != 0) {
                        if (readableArray9 == null || i12 != readableArray4.size()) {
                            throw new s("Size of addChildTags != size of addAtIndices!");
                        }
                    }
                    int i15 = i11 + i12;
                    a2[] a2VarArr = new a2[i15];
                    int i16 = i11 + i13;
                    int[] iArr = new int[i16];
                    try {
                        int[] iArr2 = new int[i16];
                        int i17 = i15;
                        int[] iArr3 = new int[i13];
                        if (i11 > 0) {
                            p5.a.c(readableArray);
                            p5.a.c(readableArray2);
                            int i18 = 0;
                            while (i18 < i11) {
                                int i19 = i16;
                                int i20 = readableArray6.getInt(i18);
                                int q10 = c10.a(i20).q();
                                a2VarArr[i18] = new a2(q10, readableArray7.getInt(i18));
                                iArr[i18] = i20;
                                iArr2[i18] = q10;
                                i18++;
                                readableArray6 = readableArray;
                                i16 = i19;
                                iArr3 = iArr3;
                                c10 = c10;
                            }
                        }
                        t0 t0Var = c10;
                        int[] iArr4 = iArr3;
                        int i21 = i16;
                        if (i12 > 0) {
                            p5.a.c(readableArray3);
                            p5.a.c(readableArray4);
                            for (int i22 = 0; i22 < i12; i22++) {
                                a2VarArr[i11 + i22] = new a2(readableArray8.getInt(i22), readableArray9.getInt(i22));
                            }
                        }
                        if (i13 > 0) {
                            p5.a.c(readableArray5);
                            int i23 = 0;
                            while (i23 < i13) {
                                int i24 = readableArray10.getInt(i23);
                                t0 t0Var2 = t0Var;
                                int q11 = t0Var2.a(i24).q();
                                int i25 = i11 + i23;
                                iArr[i25] = i24;
                                iArr2[i25] = q11;
                                iArr4[i23] = q11;
                                i23++;
                                t0Var = t0Var2;
                            }
                        }
                        t0 t0Var3 = t0Var;
                        Arrays.sort(a2VarArr, a2.f3547c);
                        Arrays.sort(iArr);
                        int i26 = i21 - 1;
                        int i27 = -1;
                        while (i26 >= 0) {
                            int i28 = iArr[i26];
                            if (i28 != i27) {
                                t0Var3.e(i28);
                                i27 = iArr[i26];
                                i26--;
                            } else {
                                throw new s("Repeated indices in Removal list for view tag: " + i10);
                            }
                        }
                        int i29 = i17;
                        int i30 = 0;
                        while (i30 < i29) {
                            a2 a2Var = a2VarArr[i30];
                            int[] iArr5 = iArr2;
                            t0 c11 = this.f3784d.c(a2Var.f3548a);
                            if (c11 != null) {
                                t0Var3.I(c11, a2Var.f3549b);
                                i30++;
                                iArr2 = iArr5;
                            } else {
                                throw new s("Trying to add unknown view tag: " + a2Var.f3548a);
                            }
                        }
                        int[] iArr6 = iArr2;
                        this.f3787g.i(t0Var3, iArr, iArr6, a2VarArr, iArr4);
                        for (int i31 = 0; i31 < i13; i31++) {
                            K(this.f3784d.c(iArr4[i31]));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    public void v(int i10, Callback callback) {
        if (this.f3790j) {
            this.f3786f.H(i10, callback);
        }
    }

    public void w(int i10, Callback callback) {
        if (this.f3790j) {
            this.f3786f.I(i10, callback);
        }
    }

    public void x(int i10, int i11, Callback callback, Callback callback2) {
        if (this.f3790j) {
            try {
                y(i10, i11, this.f3788h);
                float b10 = g0.b((float) this.f3788h[0]);
                float b11 = g0.b((float) this.f3788h[1]);
                float b12 = g0.b((float) this.f3788h[2]);
                float b13 = g0.b((float) this.f3788h[3]);
                callback2.invoke(Float.valueOf(b10), Float.valueOf(b11), Float.valueOf(b12), Float.valueOf(b13));
            } catch (s e10) {
                callback.invoke(e10.getMessage());
            }
        }
    }

    protected j1(ReactApplicationContext reactApplicationContext, i2 i2Var, r1 r1Var, e eVar) {
        this.f3781a = new Object();
        b1 b1Var = new b1();
        this.f3784d = b1Var;
        this.f3788h = new int[4];
        this.f3789i = 0;
        this.f3790j = true;
        this.f3783c = reactApplicationContext;
        this.f3785e = i2Var;
        this.f3786f = r1Var;
        this.f3787g = new d0(r1Var, b1Var);
        this.f3782b = eVar;
    }
}
