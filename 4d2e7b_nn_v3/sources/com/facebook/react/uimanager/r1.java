package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.core.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class r1 {
    /* access modifiers changed from: private */
    public static final String A = "r1";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3821a = new int[4];
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c0 f3822b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f3823c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Object f3824d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final i f3825e;

    /* renamed from: f  reason: collision with root package name */
    private final ReactApplicationContext f3826f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f3827g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f3828h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f3829i = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ArrayDeque f3830j = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public j7.a f3831k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3832l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f3833m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f3834n = false;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f3835o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public long f3836p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public long f3837q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public long f3838r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public long f3839s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public long f3840t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f3841u;

    /* renamed from: v  reason: collision with root package name */
    private long f3842v;

    /* renamed from: w  reason: collision with root package name */
    private long f3843w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public long f3844x;

    /* renamed from: y  reason: collision with root package name */
    private long f3845y;

    /* renamed from: z  reason: collision with root package name */
    private long f3846z;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f3848b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayDeque f3849c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f3850d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f3851e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f3852f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f3853g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ long f3854h;

        a(int i10, ArrayList arrayList, ArrayDeque arrayDeque, ArrayList arrayList2, long j10, long j11, long j12, long j13) {
            this.f3847a = i10;
            this.f3848b = arrayList;
            this.f3849c = arrayDeque;
            this.f3850d = arrayList2;
            this.f3851e = j10;
            this.f3852f = j11;
            this.f3853g = j12;
            this.f3854h = j13;
        }

        public void run() {
            c8.b.a(0, "DispatchUI").a("BatchId", this.f3847a).c();
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList = this.f3848b;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g gVar = (g) it.next();
                        try {
                            gVar.c();
                        } catch (RetryableMountingLayerException e10) {
                            RetryableMountingLayerException retryableMountingLayerException = e10;
                            if (gVar.a() == 0) {
                                gVar.b();
                                r1.this.f3827g.add(gVar);
                            } else {
                                ReactSoftExceptionLogger.logSoftException(r1.A, new ReactNoCrashSoftException((Throwable) retryableMountingLayerException));
                            }
                        } catch (Throwable th) {
                            ReactSoftExceptionLogger.logSoftException(r1.A, th);
                        }
                    }
                }
                ArrayDeque arrayDeque = this.f3849c;
                if (arrayDeque != null) {
                    Iterator it2 = arrayDeque.iterator();
                    while (it2.hasNext()) {
                        ((r) it2.next()).execute();
                    }
                }
                ArrayList arrayList2 = this.f3850d;
                if (arrayList2 != null) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        ((r) it3.next()).execute();
                    }
                }
                if (r1.this.f3834n && r1.this.f3836p == 0) {
                    r1.this.f3836p = this.f3851e;
                    r1.this.f3837q = SystemClock.uptimeMillis();
                    r1.this.f3838r = this.f3852f;
                    r1.this.f3839s = this.f3853g;
                    r1.this.f3840t = uptimeMillis;
                    r1 r1Var = r1.this;
                    r1Var.f3841u = r1Var.f3837q;
                    r1.this.f3844x = this.f3854h;
                    c8.a.b(0, "delayBeforeDispatchViewUpdates", 0, r1.this.f3836p * 1000000);
                    c8.a.f(0, "delayBeforeDispatchViewUpdates", 0, r1.this.f3839s * 1000000);
                    c8.a.b(0, "delayBeforeBatchRunStart", 0, r1.this.f3839s * 1000000);
                    c8.a.f(0, "delayBeforeBatchRunStart", 0, r1.this.f3840t * 1000000);
                }
                r1.this.f3822b.clearLayoutAnimation();
                if (r1.this.f3831k != null) {
                    r1.this.f3831k.b();
                }
                c8.a.g(0);
            } catch (Exception e11) {
                r1.this.f3833m = true;
                throw e11;
            } catch (Throwable th2) {
                c8.a.g(0);
                throw th2;
            }
        }
    }

    class b extends GuardedRunnable {
        b(ReactContext reactContext) {
            super(reactContext);
        }

        public void runGuarded() {
            r1.this.R();
        }
    }

    private final class c extends v {

        /* renamed from: c  reason: collision with root package name */
        private final int f3857c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3858d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f3859e;

        public c(int i10, int i11, boolean z10, boolean z11) {
            super(i10);
            this.f3857c = i11;
            this.f3859e = z10;
            this.f3858d = z11;
        }

        public void execute() {
            if (!this.f3859e) {
                r1.this.f3822b.setJSResponder(this.f3910a, this.f3857c, this.f3858d);
            } else {
                r1.this.f3822b.clearJSResponder();
            }
        }
    }

    private class d implements r {

        /* renamed from: a  reason: collision with root package name */
        private final ReadableMap f3861a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f3862b;

        public void execute() {
            r1.this.f3822b.configureLayoutAnimation(this.f3861a, this.f3862b);
        }

        private d(ReadableMap readableMap, Callback callback) {
            this.f3861a = readableMap;
            this.f3862b = callback;
        }
    }

    private final class e extends v {

        /* renamed from: c  reason: collision with root package name */
        private final e1 f3864c;

        /* renamed from: d  reason: collision with root package name */
        private final String f3865d;

        /* renamed from: e  reason: collision with root package name */
        private final v0 f3866e;

        public e(e1 e1Var, int i10, String str, v0 v0Var) {
            super(i10);
            this.f3864c = e1Var;
            this.f3865d = str;
            this.f3866e = v0Var;
            c8.a.j(0, "createView", this.f3910a);
        }

        public void execute() {
            c8.a.d(0, "createView", this.f3910a);
            r1.this.f3822b.createView(this.f3864c, this.f3910a, this.f3865d, this.f3866e);
        }
    }

    private final class f extends v implements g {

        /* renamed from: c  reason: collision with root package name */
        private final int f3868c;

        /* renamed from: d  reason: collision with root package name */
        private final ReadableArray f3869d;

        /* renamed from: e  reason: collision with root package name */
        private int f3870e = 0;

        public f(int i10, int i11, ReadableArray readableArray) {
            super(i10);
            this.f3868c = i11;
            this.f3869d = readableArray;
        }

        public int a() {
            return this.f3870e;
        }

        public void b() {
            this.f3870e++;
        }

        public void c() {
            r1.this.f3822b.dispatchCommand(this.f3910a, this.f3868c, this.f3869d);
        }

        public void execute() {
            try {
                r1.this.f3822b.dispatchCommand(this.f3910a, this.f3868c, this.f3869d);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException(r1.A, new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    private interface g {
        int a();

        void b();

        void c();
    }

    private final class h extends v implements g {

        /* renamed from: c  reason: collision with root package name */
        private final String f3872c;

        /* renamed from: d  reason: collision with root package name */
        private final ReadableArray f3873d;

        /* renamed from: e  reason: collision with root package name */
        private int f3874e = 0;

        public h(int i10, String str, ReadableArray readableArray) {
            super(i10);
            this.f3872c = str;
            this.f3873d = readableArray;
        }

        public int a() {
            return this.f3874e;
        }

        public void b() {
            this.f3874e++;
        }

        public void c() {
            r1.this.f3822b.dispatchCommand(this.f3910a, this.f3872c, this.f3873d);
        }

        public void execute() {
            try {
                r1.this.f3822b.dispatchCommand(this.f3910a, this.f3872c, this.f3873d);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException(r1.A, new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    private class i extends o {

        /* renamed from: a  reason: collision with root package name */
        private final int f3876a;

        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = android.os.SystemClock.uptimeMillis();
            r1.execute();
            r0 = r8.f3877b;
            com.facebook.react.uimanager.r1.o(r0, com.facebook.react.uimanager.r1.e(r0) + (android.os.SystemClock.uptimeMillis() - r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
            com.facebook.react.uimanager.r1.n(r8.f3877b, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
            throw r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(long r9) {
            /*
                r8 = this;
            L_0x0000:
                long r0 = java.lang.System.nanoTime()
                long r0 = r0 - r9
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r0 = r0 / r2
                r2 = 16
                long r2 = r2 - r0
                int r0 = r8.f3876a
                long r0 = (long) r0
                int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x0014
                goto L_0x0028
            L_0x0014:
                com.facebook.react.uimanager.r1 r0 = com.facebook.react.uimanager.r1.this
                java.lang.Object r0 = r0.f3824d
                monitor-enter(r0)
                com.facebook.react.uimanager.r1 r1 = com.facebook.react.uimanager.r1.this     // Catch:{ all -> 0x0029 }
                java.util.ArrayDeque r1 = r1.f3830j     // Catch:{ all -> 0x0029 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x002b
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            L_0x0028:
                return
            L_0x0029:
                r9 = move-exception
                goto L_0x0057
            L_0x002b:
                com.facebook.react.uimanager.r1 r1 = com.facebook.react.uimanager.r1.this     // Catch:{ all -> 0x0029 }
                java.util.ArrayDeque r1 = r1.f3830j     // Catch:{ all -> 0x0029 }
                java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x0029 }
                com.facebook.react.uimanager.r1$r r1 = (com.facebook.react.uimanager.r1.r) r1     // Catch:{ all -> 0x0029 }
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x004f }
                r1.execute()     // Catch:{ Exception -> 0x004f }
                com.facebook.react.uimanager.r1 r0 = com.facebook.react.uimanager.r1.this     // Catch:{ Exception -> 0x004f }
                long r4 = r0.f3835o     // Catch:{ Exception -> 0x004f }
                long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x004f }
                long r6 = r6 - r2
                long r4 = r4 + r6
                r0.f3835o = r4     // Catch:{ Exception -> 0x004f }
                goto L_0x0000
            L_0x004f:
                r9 = move-exception
                com.facebook.react.uimanager.r1 r10 = com.facebook.react.uimanager.r1.this
                r0 = 1
                r10.f3833m = r0
                throw r9
            L_0x0057:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.r1.i.a(long):void");
        }

        /* JADX INFO: finally extract failed */
        public void doFrameGuarded(long j10) {
            if (r1.this.f3833m) {
                z2.a.G("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            c8.a.c(0, "dispatchNonBatchedUIOperations");
            try {
                a(j10);
                c8.a.g(0);
                r1.this.R();
                com.facebook.react.modules.core.a.h().m(a.b.DISPATCH_UI, this);
            } catch (Throwable th) {
                c8.a.g(0);
                throw th;
            }
        }

        private i(ReactContext reactContext, int i10) {
            super(reactContext);
            this.f3876a = i10;
        }
    }

    private final class j implements r {

        /* renamed from: a  reason: collision with root package name */
        private final int f3878a;

        /* renamed from: b  reason: collision with root package name */
        private final float f3879b;

        /* renamed from: c  reason: collision with root package name */
        private final float f3880c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f3881d;

        public void execute() {
            try {
                r1.this.f3822b.measure(this.f3878a, r1.this.f3821a);
                float f10 = (float) r1.this.f3821a[0];
                float f11 = (float) r1.this.f3821a[1];
                int findTargetTagForTouch = r1.this.f3822b.findTargetTagForTouch(this.f3878a, this.f3879b, this.f3880c);
                try {
                    r1.this.f3822b.measure(findTargetTagForTouch, r1.this.f3821a);
                    float b10 = g0.b(((float) r1.this.f3821a[0]) - f10);
                    float b11 = g0.b(((float) r1.this.f3821a[1]) - f11);
                    float b12 = g0.b((float) r1.this.f3821a[2]);
                    float b13 = g0.b((float) r1.this.f3821a[3]);
                    this.f3881d.invoke(Integer.valueOf(findTargetTagForTouch), Float.valueOf(b10), Float.valueOf(b11), Float.valueOf(b12), Float.valueOf(b13));
                } catch (s unused) {
                    this.f3881d.invoke(new Object[0]);
                }
            } catch (s unused2) {
                this.f3881d.invoke(new Object[0]);
            }
        }

        private j(int i10, float f10, float f11, Callback callback) {
            this.f3878a = i10;
            this.f3879b = f10;
            this.f3880c = f11;
            this.f3881d = callback;
        }
    }

    private final class k extends v {

        /* renamed from: c  reason: collision with root package name */
        private final int[] f3883c;

        /* renamed from: d  reason: collision with root package name */
        private final a2[] f3884d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f3885e;

        public k(int i10, int[] iArr, a2[] a2VarArr, int[] iArr2) {
            super(i10);
            this.f3883c = iArr;
            this.f3884d = a2VarArr;
            this.f3885e = iArr2;
        }

        public void execute() {
            r1.this.f3822b.manageChildren(this.f3910a, this.f3883c, this.f3884d, this.f3885e);
        }
    }

    private final class l implements r {

        /* renamed from: a  reason: collision with root package name */
        private final int f3887a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f3888b;

        public void execute() {
            try {
                r1.this.f3822b.measureInWindow(this.f3887a, r1.this.f3821a);
                float b10 = g0.b((float) r1.this.f3821a[0]);
                float b11 = g0.b((float) r1.this.f3821a[1]);
                float b12 = g0.b((float) r1.this.f3821a[2]);
                float b13 = g0.b((float) r1.this.f3821a[3]);
                this.f3888b.invoke(Float.valueOf(b10), Float.valueOf(b11), Float.valueOf(b12), Float.valueOf(b13));
            } catch (e0 unused) {
                this.f3888b.invoke(new Object[0]);
            }
        }

        private l(int i10, Callback callback) {
            this.f3887a = i10;
            this.f3888b = callback;
        }
    }

    private final class m implements r {

        /* renamed from: a  reason: collision with root package name */
        private final int f3890a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f3891b;

        public void execute() {
            try {
                r1.this.f3822b.measure(this.f3890a, r1.this.f3821a);
                float b10 = g0.b((float) r1.this.f3821a[0]);
                float b11 = g0.b((float) r1.this.f3821a[1]);
                float b12 = g0.b((float) r1.this.f3821a[2]);
                float b13 = g0.b((float) r1.this.f3821a[3]);
                this.f3891b.invoke(0, 0, Float.valueOf(b12), Float.valueOf(b13), Float.valueOf(b10), Float.valueOf(b11));
            } catch (e0 unused) {
                this.f3891b.invoke(new Object[0]);
            }
        }

        private m(int i10, Callback callback) {
            this.f3890a = i10;
            this.f3891b = callback;
        }
    }

    private final class n extends v {
        public n(int i10) {
            super(i10);
        }

        public void execute() {
            r1.this.f3822b.removeRootView(this.f3910a);
        }
    }

    private final class o extends v {

        /* renamed from: c  reason: collision with root package name */
        private final int f3894c;

        public void execute() {
            try {
                r1.this.f3822b.sendAccessibilityEvent(this.f3910a, this.f3894c);
            } catch (RetryableMountingLayerException e10) {
                ReactSoftExceptionLogger.logSoftException(r1.A, e10);
            }
        }

        private o(int i10, int i11) {
            super(i10);
            this.f3894c = i11;
        }
    }

    private class p implements r {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f3896a;

        public void execute() {
            r1.this.f3822b.setLayoutAnimationEnabled(this.f3896a);
        }

        private p(boolean z10) {
            this.f3896a = z10;
        }
    }

    private class q implements r {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f3898a;

        public q(i1 i1Var) {
            this.f3898a = i1Var;
        }

        public void execute() {
            this.f3898a.a(r1.this.f3822b);
        }
    }

    public interface r {
        void execute();
    }

    private final class s extends v {

        /* renamed from: c  reason: collision with root package name */
        private final int f3900c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3901d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3902e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3903f;

        /* renamed from: g  reason: collision with root package name */
        private final int f3904g;

        public s(int i10, int i11, int i12, int i13, int i14, int i15) {
            super(i11);
            this.f3900c = i10;
            this.f3901d = i12;
            this.f3902e = i13;
            this.f3903f = i14;
            this.f3904g = i15;
            c8.a.j(0, "updateLayout", this.f3910a);
        }

        public void execute() {
            c8.a.d(0, "updateLayout", this.f3910a);
            r1.this.f3822b.updateLayout(this.f3900c, this.f3910a, this.f3901d, this.f3902e, this.f3903f, this.f3904g);
        }
    }

    private final class t extends v {

        /* renamed from: c  reason: collision with root package name */
        private final v0 f3906c;

        public void execute() {
            r1.this.f3822b.updateProperties(this.f3910a, this.f3906c);
        }

        private t(int i10, v0 v0Var) {
            super(i10);
            this.f3906c = v0Var;
        }
    }

    private final class u extends v {

        /* renamed from: c  reason: collision with root package name */
        private final Object f3908c;

        public u(int i10, Object obj) {
            super(i10);
            this.f3908c = obj;
        }

        public void execute() {
            r1.this.f3822b.updateViewExtraData(this.f3910a, this.f3908c);
        }
    }

    private abstract class v implements r {

        /* renamed from: a  reason: collision with root package name */
        public int f3910a;

        public v(int i10) {
            this.f3910a = i10;
        }
    }

    public r1(ReactApplicationContext reactApplicationContext, c0 c0Var, int i10) {
        this.f3822b = c0Var;
        this.f3825e = new i(reactApplicationContext, i10 == -1 ? 8 : i10);
        this.f3826f = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r12.f3834n == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r12.f3842v = android.os.SystemClock.uptimeMillis() - r2;
        r12.f3843w = r12.f3835o;
        r12.f3834n = false;
        c8.a.b(0, "batchedExecutionTime", 0, r2 * 1000000);
        c8.a.e(0, "batchedExecutionTime", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r12.f3835o = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R() {
        /*
            r12 = this;
            boolean r0 = r12.f3833m
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Not flushing pending UI operations because of previously thrown Exception"
            z2.a.G(r0, r1)
            return
        L_0x000c:
            java.lang.Object r0 = r12.f3823c
            monitor-enter(r0)
            java.util.ArrayList r1 = r12.f3829i     // Catch:{ all -> 0x0062 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0064
            java.util.ArrayList r1 = r12.f3829i     // Catch:{ all -> 0x0062 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0062 }
            r2.<init>()     // Catch:{ all -> 0x0062 }
            r12.f3829i = r2     // Catch:{ all -> 0x0062 }
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            long r2 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0029
        L_0x0039:
            boolean r0 = r12.f3834n
            r4 = 0
            if (r0 == 0) goto L_0x005f
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r2
            r12.f3842v = r0
            long r0 = r12.f3835o
            r12.f3843w = r0
            r0 = 0
            r12.f3834n = r0
            java.lang.String r8 = "batchedExecutionTime"
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r2 * r6
            r6 = 0
            r9 = 0
            c8.a.b(r6, r8, r9, r10)
            java.lang.String r1 = "batchedExecutionTime"
            c8.a.e(r4, r1, r0)
        L_0x005f:
            r12.f3835o = r4
            return
        L_0x0062:
            r1 = move-exception
            goto L_0x0066
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            return
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.r1.R():void");
    }

    public void A() {
        this.f3828h.add(new c(0, 0, true, false));
    }

    public void B(ReadableMap readableMap, Callback callback) {
        this.f3828h.add(new d(readableMap, callback));
    }

    public void C(e1 e1Var, int i10, String str, v0 v0Var) {
        synchronized (this.f3824d) {
            this.f3845y++;
            this.f3830j.addLast(new e(e1Var, i10, str, v0Var));
        }
    }

    public void D(int i10, int i11, ReadableArray readableArray) {
        this.f3827g.add(new f(i10, i11, readableArray));
    }

    public void E(int i10, String str, ReadableArray readableArray) {
        this.f3827g.add(new h(i10, str, readableArray));
    }

    public void F(int i10, float f10, float f11, Callback callback) {
        this.f3828h.add(new j(i10, f10, f11, callback));
    }

    public void G(int i10, int[] iArr, a2[] a2VarArr, int[] iArr2) {
        this.f3828h.add(new k(i10, iArr, a2VarArr, iArr2));
    }

    public void H(int i10, Callback callback) {
        this.f3828h.add(new m(i10, callback));
    }

    public void I(int i10, Callback callback) {
        this.f3828h.add(new l(i10, callback));
    }

    public void J(int i10) {
        this.f3828h.add(new n(i10));
    }

    public void K(int i10, int i11) {
        this.f3828h.add(new o(i10, i11));
    }

    public void L(int i10, int i11, boolean z10) {
        this.f3828h.add(new c(i10, i11, false, z10));
    }

    public void M(boolean z10) {
        this.f3828h.add(new p(z10));
    }

    public void N(i1 i1Var) {
        this.f3828h.add(new q(i1Var));
    }

    public void O(int i10, Object obj) {
        this.f3828h.add(new u(i10, obj));
    }

    public void P(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f3828h.add(new s(i10, i11, i12, i13, i14, i15));
    }

    public void Q(int i10, String str, v0 v0Var) {
        this.f3846z++;
        this.f3828h.add(new t(i10, v0Var));
    }

    /* access modifiers changed from: package-private */
    public c0 S() {
        return this.f3822b;
    }

    public Map T() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.f3836p));
        hashMap.put("CommitEndTime", Long.valueOf(this.f3837q));
        hashMap.put("LayoutTime", Long.valueOf(this.f3838r));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.f3839s));
        hashMap.put("RunStartTime", Long.valueOf(this.f3840t));
        hashMap.put("RunEndTime", Long.valueOf(this.f3841u));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.f3842v));
        hashMap.put("NonBatchedExecutionTime", Long.valueOf(this.f3843w));
        hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(this.f3844x));
        hashMap.put("CreateViewCount", Long.valueOf(this.f3845y));
        hashMap.put("UpdatePropsCount", Long.valueOf(this.f3846z));
        return hashMap;
    }

    public boolean U() {
        if (!this.f3828h.isEmpty() || !this.f3827g.isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void V() {
        this.f3832l = false;
        com.facebook.react.modules.core.a.h().o(a.b.DISPATCH_UI, this.f3825e);
        R();
    }

    public void W(i1 i1Var) {
        this.f3828h.add(0, new q(i1Var));
    }

    public void X() {
        this.f3834n = true;
        this.f3836p = 0;
        this.f3845y = 0;
        this.f3846z = 0;
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        this.f3832l = true;
        if (!ReactFeatureFlags.enableFabricRendererExclusively) {
            com.facebook.react.modules.core.a.h().m(a.b.DISPATCH_UI, this.f3825e);
        }
    }

    public void Z(j7.a aVar) {
        this.f3831k = aVar;
    }

    public void y(int i10, View view) {
        this.f3822b.addRootView(i10, view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ba, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z(int r20, long r21, long r23) {
        /*
            r19 = this;
            r15 = r19
            r0 = r20
            java.lang.String r1 = "UIViewOperationQueue.dispatchViewUpdates"
            r13 = 0
            c8.b$a r1 = c8.b.a(r13, r1)
            java.lang.String r2 = "batchId"
            c8.b$a r1 = r1.a(r2, r0)
            r1.c()
            long r11 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0031 }
            long r16 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ all -> 0x0031 }
            java.util.ArrayList r1 = r15.f3827g     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0031 }
            r2 = 0
            if (r1 != 0) goto L_0x0035
            java.util.ArrayList r1 = r15.f3827g     // Catch:{ all -> 0x0031 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0031 }
            r3.<init>()     // Catch:{ all -> 0x0031 }
            r15.f3827g = r3     // Catch:{ all -> 0x0031 }
            r4 = r1
            goto L_0x0036
        L_0x0031:
            r0 = move-exception
            r2 = r13
            goto L_0x00bc
        L_0x0035:
            r4 = r2
        L_0x0036:
            java.util.ArrayList r1 = r15.f3828h     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x0049
            java.util.ArrayList r1 = r15.f3828h     // Catch:{ all -> 0x0031 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0031 }
            r3.<init>()     // Catch:{ all -> 0x0031 }
            r15.f3828h = r3     // Catch:{ all -> 0x0031 }
            r6 = r1
            goto L_0x004a
        L_0x0049:
            r6 = r2
        L_0x004a:
            java.lang.Object r1 = r15.f3824d     // Catch:{ all -> 0x0031 }
            monitor-enter(r1)     // Catch:{ all -> 0x0031 }
            java.util.ArrayDeque r3 = r15.f3830j     // Catch:{ all -> 0x0060 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0060 }
            if (r3 != 0) goto L_0x005e
            java.util.ArrayDeque r2 = r15.f3830j     // Catch:{ all -> 0x0060 }
            java.util.ArrayDeque r3 = new java.util.ArrayDeque     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            r15.f3830j = r3     // Catch:{ all -> 0x0060 }
        L_0x005e:
            r5 = r2
            goto L_0x0063
        L_0x0060:
            r0 = move-exception
            r2 = r13
            goto L_0x00b8
        L_0x0063:
            monitor-exit(r1)     // Catch:{ all -> 0x0060 }
            j7.a r1 = r15.f3831k     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x006b
            r1.a()     // Catch:{ all -> 0x0031 }
        L_0x006b:
            com.facebook.react.uimanager.r1$a r9 = new com.facebook.react.uimanager.r1$a     // Catch:{ all -> 0x0031 }
            r1 = r9
            r2 = r19
            r3 = r20
            r7 = r21
            r18 = r9
            r9 = r23
            r13 = r16
            r1.<init>(r3, r4, r5, r6, r7, r9, r11, r13)     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "acquiring mDispatchRunnablesLock"
            r2 = 0
            c8.b$a r1 = c8.b.a(r2, r1)     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = "batchId"
            c8.b$a r0 = r1.a(r4, r0)     // Catch:{ all -> 0x00ab }
            r0.c()     // Catch:{ all -> 0x00ab }
            java.lang.Object r1 = r15.f3823c     // Catch:{ all -> 0x00ab }
            monitor-enter(r1)     // Catch:{ all -> 0x00ab }
            c8.a.g(r2)     // Catch:{ all -> 0x00b1 }
            java.util.ArrayList r0 = r15.f3829i     // Catch:{ all -> 0x00b1 }
            r4 = r18
            r0.add(r4)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b1 }
            boolean r0 = r15.f3832l     // Catch:{ all -> 0x00ab }
            if (r0 != 0) goto L_0x00ad
            com.facebook.react.uimanager.r1$b r0 = new com.facebook.react.uimanager.r1$b     // Catch:{ all -> 0x00ab }
            com.facebook.react.bridge.ReactApplicationContext r1 = r15.f3826f     // Catch:{ all -> 0x00ab }
            r0.<init>(r1)     // Catch:{ all -> 0x00ab }
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)     // Catch:{ all -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r0 = move-exception
            goto L_0x00bc
        L_0x00ad:
            c8.a.g(r2)
            return
        L_0x00b1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00b4:
            r0 = move-exception
            r2 = 0
            goto L_0x00bc
        L_0x00b8:
            monitor-exit(r1)     // Catch:{ all -> 0x00ba }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ba:
            r0 = move-exception
            goto L_0x00b8
        L_0x00bc:
            c8.a.g(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.r1.z(int, long, long):void");
    }
}
