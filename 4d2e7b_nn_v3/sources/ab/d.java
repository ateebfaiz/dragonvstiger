package ab;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import java.util.Arrays;
import kotlin.collections.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class d {
    public static final b J = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static MotionEvent.PointerProperties[] K;
    /* access modifiers changed from: private */
    public static MotionEvent.PointerCoords[] L;
    private static short M;
    private g A;
    private p B;
    private e C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2357a = new int[12];
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2358b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f2359c;

    /* renamed from: d  reason: collision with root package name */
    private int f2360d;

    /* renamed from: e  reason: collision with root package name */
    private View f2361e;

    /* renamed from: f  reason: collision with root package name */
    private int f2362f;

    /* renamed from: g  reason: collision with root package name */
    private float f2363g;

    /* renamed from: h  reason: collision with root package name */
    private float f2364h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2365i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2366j;

    /* renamed from: k  reason: collision with root package name */
    private int f2367k;

    /* renamed from: l  reason: collision with root package name */
    private WritableArray f2368l;

    /* renamed from: m  reason: collision with root package name */
    private WritableArray f2369m;

    /* renamed from: n  reason: collision with root package name */
    private int f2370n;

    /* renamed from: o  reason: collision with root package name */
    private int f2371o;

    /* renamed from: p  reason: collision with root package name */
    private final c[] f2372p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2373q;

    /* renamed from: r  reason: collision with root package name */
    private float[] f2374r;

    /* renamed from: s  reason: collision with root package name */
    private short f2375s;

    /* renamed from: t  reason: collision with root package name */
    private float f2376t;

    /* renamed from: u  reason: collision with root package name */
    private float f2377u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2378v;

    /* renamed from: w  reason: collision with root package name */
    private float f2379w;

    /* renamed from: x  reason: collision with root package name */
    private float f2380x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f2381y;

    /* renamed from: z  reason: collision with root package name */
    private int f2382z;

    public static final class a extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(ab.d r21, android.view.MotionEvent r22, java.lang.IllegalArgumentException r23) {
            /*
                r20 = this;
                r0 = r22
                r1 = r23
                java.lang.String r2 = "handler"
                r3 = r21
                kotlin.jvm.internal.m.f(r3, r2)
                java.lang.String r2 = "event"
                kotlin.jvm.internal.m.f(r0, r2)
                java.lang.String r2 = "e"
                kotlin.jvm.internal.m.f(r1, r2)
                java.lang.Class r2 = r21.getClass()
                zb.c r2 = kotlin.jvm.internal.z.b(r2)
                java.lang.String r2 = r2.b()
                int r4 = r21.Q()
                android.view.View r5 = r21.U()
                ab.g r6 = r21.N()
                boolean r7 = r21.b0()
                boolean r8 = r21.X()
                boolean r9 = r21.Y()
                int r10 = r21.f2358b
                int[] r11 = r21.f2357a
                r18 = 62
                r19 = 0
                java.lang.String r12 = ", "
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                java.lang.String r3 = kotlin.collections.j.M(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "\n    handler: "
                r11.append(r12)
                r11.append(r2)
                java.lang.String r2 = "\n    state: "
                r11.append(r2)
                r11.append(r4)
                java.lang.String r2 = "\n    view: "
                r11.append(r2)
                r11.append(r5)
                java.lang.String r2 = "\n    orchestrator: "
                r11.append(r2)
                r11.append(r6)
                java.lang.String r2 = "\n    isEnabled: "
                r11.append(r2)
                r11.append(r7)
                java.lang.String r2 = "\n    isActive: "
                r11.append(r2)
                r11.append(r8)
                java.lang.String r2 = "\n    isAwaiting: "
                r11.append(r2)
                r11.append(r9)
                java.lang.String r2 = "\n    trackedPointersCount: "
                r11.append(r2)
                r11.append(r10)
                java.lang.String r2 = "\n    trackedPointers: "
                r11.append(r2)
                r11.append(r3)
                java.lang.String r2 = "\n    while handling event: "
                r11.append(r2)
                r11.append(r0)
                java.lang.String r0 = "\n    "
                r11.append(r0)
                java.lang.String r0 = r11.toString()
                java.lang.String r0 = kotlin.text.j.f(r0)
                r2 = r20
                r2.<init>(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ab.d.a.<init>(ab.d, android.view.MotionEvent, java.lang.IllegalArgumentException):void");
        }
    }

    public static final class b {
        private b() {
        }

        /* access modifiers changed from: private */
        public final boolean c(float f10) {
            return !Float.isNaN(f10);
        }

        /* access modifiers changed from: private */
        public final void d(int i10) {
            if (d.K == null) {
                d.K = new MotionEvent.PointerProperties[12];
                d.L = new MotionEvent.PointerCoords[12];
            }
            while (i10 > 0) {
                MotionEvent.PointerProperties[] c10 = d.K;
                MotionEvent.PointerCoords[] pointerCoordsArr = null;
                if (c10 == null) {
                    m.u("pointerProps");
                    c10 = null;
                }
                int i11 = i10 - 1;
                if (c10[i11] == null) {
                    MotionEvent.PointerProperties[] c11 = d.K;
                    if (c11 == null) {
                        m.u("pointerProps");
                        c11 = null;
                    }
                    c11[i11] = new MotionEvent.PointerProperties();
                    MotionEvent.PointerCoords[] b10 = d.L;
                    if (b10 == null) {
                        m.u("pointerCoords");
                    } else {
                        pointerCoordsArr = b10;
                    }
                    pointerCoordsArr[i11] = new MotionEvent.PointerCoords();
                    i10--;
                } else {
                    return;
                }
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2383a;

        /* renamed from: b  reason: collision with root package name */
        private float f2384b;

        /* renamed from: c  reason: collision with root package name */
        private float f2385c;

        /* renamed from: d  reason: collision with root package name */
        private float f2386d;

        /* renamed from: e  reason: collision with root package name */
        private float f2387e;

        public c(int i10, float f10, float f11, float f12, float f13) {
            this.f2383a = i10;
            this.f2384b = f10;
            this.f2385c = f11;
            this.f2386d = f12;
            this.f2387e = f13;
        }

        public final float a() {
            return this.f2386d;
        }

        public final float b() {
            return this.f2387e;
        }

        public final int c() {
            return this.f2383a;
        }

        public final float d() {
            return this.f2384b;
        }

        public final float e() {
            return this.f2385c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f2383a == cVar.f2383a && Float.compare(this.f2384b, cVar.f2384b) == 0 && Float.compare(this.f2385c, cVar.f2385c) == 0 && Float.compare(this.f2386d, cVar.f2386d) == 0 && Float.compare(this.f2387e, cVar.f2387e) == 0) {
                return true;
            }
            return false;
        }

        public final void f(float f10) {
            this.f2386d = f10;
        }

        public final void g(float f10) {
            this.f2387e = f10;
        }

        public final void h(float f10) {
            this.f2384b = f10;
        }

        public int hashCode() {
            return (((((((this.f2383a * 31) + Float.floatToIntBits(this.f2384b)) * 31) + Float.floatToIntBits(this.f2385c)) * 31) + Float.floatToIntBits(this.f2386d)) * 31) + Float.floatToIntBits(this.f2387e);
        }

        public final void i(float f10) {
            this.f2385c = f10;
        }

        public String toString() {
            int i10 = this.f2383a;
            float f10 = this.f2384b;
            float f11 = this.f2385c;
            float f12 = this.f2386d;
            float f13 = this.f2387e;
            return "PointerData(pointerId=" + i10 + ", x=" + f10 + ", y=" + f11 + ", absoluteX=" + f12 + ", absoluteY=" + f13 + ")";
        }
    }

    public d() {
        int[] iArr = new int[2];
        for (int i10 = 0; i10 < 2; i10++) {
            iArr[i10] = 0;
        }
        this.f2359c = iArr;
        this.f2366j = true;
        c[] cVarArr = new c[12];
        for (int i11 = 0; i11 < 12; i11++) {
            cVarArr[i11] = null;
        }
        this.f2372p = cVarArr;
        this.D = 3;
    }

    private final void A() {
        this.f2369m = null;
        for (c cVar : this.f2372p) {
            if (cVar != null) {
                m(cVar);
            }
        }
    }

    private final int C() {
        int[] iArr;
        int i10 = 0;
        while (i10 < this.f2358b) {
            int i11 = 0;
            while (true) {
                iArr = this.f2357a;
                if (i11 < iArr.length && iArr[i11] != i10) {
                    i11++;
                }
            }
            if (i11 == iArr.length) {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    private final void D0(MotionEvent motionEvent) {
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        int i10 = 1;
        if (toolType == 1) {
            i10 = 0;
        } else if (toolType != 2) {
            i10 = 3;
            if (toolType == 3) {
                i10 = 2;
            }
        }
        this.D = i10;
    }

    private final Activity F(Context context) {
        if (context instanceof ReactContext) {
            return ((ReactContext) context).getCurrentActivity();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return F(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private final boolean Z(int i10) {
        int i11 = this.E;
        if (i11 == 0) {
            if (i10 == 1) {
                return true;
            }
            return false;
        } else if ((i10 & i11) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final void e0(int i10) {
        UiThreadUtil.assertOnUiThread();
        if (this.f2362f != i10) {
            if (this.f2371o > 0 && (i10 == 5 || i10 == 3 || i10 == 1)) {
                p();
            }
            int i11 = this.f2362f;
            this.f2362f = i10;
            if (i10 == 4) {
                short s10 = M;
                M = (short) (s10 + 1);
                this.f2375s = s10;
            }
            g gVar = this.A;
            m.c(gVar);
            gVar.w(this, i10, i11);
            l0(i10, i11);
        }
    }

    private final boolean f0(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.f2358b) {
            return true;
        }
        int length = this.f2357a.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = this.f2357a[i10];
            if (i11 != -1 && i11 != i10) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.view.MotionEvent$PointerCoords} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX WARNING: type inference failed for: r9v3, types: [android.view.MotionEvent$PointerCoords[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00b6 A[EDGE_INSN: B:77:0x00b6->B:42:0x00b6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.MotionEvent k(android.view.MotionEvent r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            boolean r0 = r25.f0(r26)
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            int r0 = r26.getActionMasked()
            r3 = 2
            r4 = 5
            r5 = 0
            r6 = -1
            r7 = 1
            if (r0 == 0) goto L_0x0036
            r8 = 6
            if (r0 == r7) goto L_0x0020
            if (r0 == r4) goto L_0x0036
            if (r0 == r8) goto L_0x0020
            r3 = r0
            r0 = r6
            goto L_0x004b
        L_0x0020:
            int r0 = r26.getActionIndex()
            int r4 = r2.getPointerId(r0)
            int[] r9 = r1.f2357a
            r4 = r9[r4]
            if (r4 == r6) goto L_0x004b
            int r3 = r1.f2358b
            if (r3 != r7) goto L_0x0034
            r3 = r7
            goto L_0x004b
        L_0x0034:
            r3 = r8
            goto L_0x004b
        L_0x0036:
            int r0 = r26.getActionIndex()
            int r8 = r2.getPointerId(r0)
            int[] r9 = r1.f2357a
            r8 = r9[r8]
            if (r8 == r6) goto L_0x004b
            int r3 = r1.f2358b
            if (r3 != r7) goto L_0x004a
            r3 = r5
            goto L_0x004b
        L_0x004a:
            r3 = r4
        L_0x004b:
            ab.d$b r4 = J
            int r7 = r1.f2358b
            r4.d(r7)
            float r4 = r26.getRawX()
            float r7 = r26.getX()
            float r4 = r4 - r7
            float r7 = r26.getRawY()
            float r8 = r26.getY()
            float r7 = r7 - r8
            r2.offsetLocation(r4, r7)
            int r8 = r26.getPointerCount()
            r13 = r3
            r14 = r5
        L_0x006d:
            java.lang.String r3 = "pointerCoords"
            java.lang.String r9 = "pointerProps"
            r10 = 0
            if (r5 >= r8) goto L_0x00b6
            int r11 = r2.getPointerId(r5)
            int[] r12 = r1.f2357a
            r12 = r12[r11]
            if (r12 == r6) goto L_0x00b3
            android.view.MotionEvent$PointerProperties[] r12 = K
            if (r12 != 0) goto L_0x0086
            kotlin.jvm.internal.m.u(r9)
            r12 = r10
        L_0x0086:
            r12 = r12[r14]
            r2.getPointerProperties(r5, r12)
            android.view.MotionEvent$PointerProperties[] r12 = K
            if (r12 != 0) goto L_0x0093
            kotlin.jvm.internal.m.u(r9)
            r12 = r10
        L_0x0093:
            r9 = r12[r14]
            kotlin.jvm.internal.m.c(r9)
            int[] r12 = r1.f2357a
            r11 = r12[r11]
            r9.id = r11
            android.view.MotionEvent$PointerCoords[] r9 = L
            if (r9 != 0) goto L_0x00a6
            kotlin.jvm.internal.m.u(r3)
            goto L_0x00a7
        L_0x00a6:
            r10 = r9
        L_0x00a7:
            r3 = r10[r14]
            r2.getPointerCoords(r5, r3)
            if (r5 != r0) goto L_0x00b1
            int r3 = r14 << 8
            r13 = r13 | r3
        L_0x00b1:
            int r14 = r14 + 1
        L_0x00b3:
            int r5 = r5 + 1
            goto L_0x006d
        L_0x00b6:
            android.view.MotionEvent$PointerProperties[] r0 = K
            if (r0 != 0) goto L_0x00be
            kotlin.jvm.internal.m.u(r9)
            r0 = r10
        L_0x00be:
            int r0 = r0.length
            if (r0 != 0) goto L_0x00c2
            goto L_0x00cd
        L_0x00c2:
            android.view.MotionEvent$PointerCoords[] r0 = L
            if (r0 != 0) goto L_0x00ca
            kotlin.jvm.internal.m.u(r3)
            r0 = r10
        L_0x00ca:
            int r0 = r0.length
            if (r0 != 0) goto L_0x00ff
        L_0x00cd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            android.view.MotionEvent$PointerCoords[] r2 = L
            if (r2 != 0) goto L_0x00d7
            kotlin.jvm.internal.m.u(r3)
            r2 = r10
        L_0x00d7:
            int r2 = r2.length
            android.view.MotionEvent$PointerProperties[] r3 = K
            if (r3 != 0) goto L_0x00e0
            kotlin.jvm.internal.m.u(r9)
            goto L_0x00e1
        L_0x00e0:
            r10 = r3
        L_0x00e1:
            int r3 = r10.length
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "pointerCoords.size="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", pointerProps.size="
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r0.<init>(r2)
            throw r0
        L_0x00ff:
            long r5 = r26.getDownTime()     // Catch:{ IllegalArgumentException -> 0x0110 }
            long r11 = r26.getEventTime()     // Catch:{ IllegalArgumentException -> 0x0110 }
            android.view.MotionEvent$PointerProperties[] r0 = K     // Catch:{ IllegalArgumentException -> 0x0110 }
            if (r0 != 0) goto L_0x0112
            kotlin.jvm.internal.m.u(r9)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r15 = r10
            goto L_0x0113
        L_0x0110:
            r0 = move-exception
            goto L_0x0152
        L_0x0112:
            r15 = r0
        L_0x0113:
            android.view.MotionEvent$PointerCoords[] r0 = L     // Catch:{ IllegalArgumentException -> 0x0110 }
            if (r0 != 0) goto L_0x011d
            kotlin.jvm.internal.m.u(r3)     // Catch:{ IllegalArgumentException -> 0x0110 }
            r16 = r10
            goto L_0x011f
        L_0x011d:
            r16 = r0
        L_0x011f:
            int r17 = r26.getMetaState()     // Catch:{ IllegalArgumentException -> 0x0110 }
            int r18 = r26.getButtonState()     // Catch:{ IllegalArgumentException -> 0x0110 }
            float r19 = r26.getXPrecision()     // Catch:{ IllegalArgumentException -> 0x0110 }
            float r20 = r26.getYPrecision()     // Catch:{ IllegalArgumentException -> 0x0110 }
            int r21 = r26.getDeviceId()     // Catch:{ IllegalArgumentException -> 0x0110 }
            int r22 = r26.getEdgeFlags()     // Catch:{ IllegalArgumentException -> 0x0110 }
            int r23 = r26.getSource()     // Catch:{ IllegalArgumentException -> 0x0110 }
            int r24 = r26.getFlags()     // Catch:{ IllegalArgumentException -> 0x0110 }
            r9 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ IllegalArgumentException -> 0x0110 }
            java.lang.String r3 = "obtain(...)"
            kotlin.jvm.internal.m.e(r0, r3)     // Catch:{ IllegalArgumentException -> 0x0110 }
            float r3 = -r4
            float r4 = -r7
            r2.offsetLocation(r3, r4)
            r0.offsetLocation(r3, r4)
            return r0
        L_0x0152:
            ab.d$a r3 = new ab.d$a
            r3.<init>(r1, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.d.k(android.view.MotionEvent):android.view.MotionEvent");
    }

    private final void l(c cVar) {
        if (this.f2368l == null) {
            this.f2368l = Arguments.createArray();
        }
        WritableArray writableArray = this.f2368l;
        m.c(writableArray);
        writableArray.pushMap(s(cVar));
    }

    private final void m(c cVar) {
        if (this.f2369m == null) {
            this.f2369m = Arguments.createArray();
        }
        WritableArray writableArray = this.f2369m;
        m.c(writableArray);
        writableArray.pushMap(s(cVar));
    }

    private final void p() {
        this.f2370n = 4;
        this.f2368l = null;
        A();
        for (c cVar : this.f2372p) {
            if (cVar != null) {
                l(cVar);
            }
        }
        this.f2371o = 0;
        j.m(this.f2372p, (Object) null, 0, 0, 6, (Object) null);
        w();
    }

    private final WritableMap s(c cVar) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", cVar.c());
        createMap.putDouble("x", (double) g0.b(cVar.d()));
        createMap.putDouble("y", (double) g0.b(cVar.e()));
        createMap.putDouble("absoluteX", (double) g0.b(cVar.a()));
        createMap.putDouble("absoluteY", (double) g0.b(cVar.b()));
        return createMap;
    }

    private final void v(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.f2368l = null;
        this.f2370n = 1;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        this.f2372p[pointerId] = new c(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent2.getX(motionEvent.getActionIndex()) + (motionEvent2.getRawX() - motionEvent2.getX())) - ((float) this.f2359c[0]), (motionEvent2.getY(motionEvent.getActionIndex()) + (motionEvent2.getRawY() - motionEvent2.getY())) - ((float) this.f2359c[1]));
        this.f2371o++;
        c cVar = this.f2372p[pointerId];
        m.c(cVar);
        l(cVar);
        A();
        w();
    }

    /* access modifiers changed from: private */
    public static final void w0(d dVar) {
        m.f(dVar, "$this_applySelf");
        dVar.o();
    }

    private final void x(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.f2368l = null;
        this.f2370n = 2;
        float rawX = motionEvent2.getRawX() - motionEvent2.getX();
        float rawY = motionEvent2.getRawY() - motionEvent2.getY();
        int pointerCount = motionEvent.getPointerCount();
        int i10 = 0;
        for (int i11 = 0; i11 < pointerCount; i11++) {
            c cVar = this.f2372p[motionEvent.getPointerId(i11)];
            if (!(cVar == null || (cVar.d() == motionEvent.getX(i11) && cVar.e() == motionEvent.getY(i11)))) {
                cVar.h(motionEvent.getX(i11));
                cVar.i(motionEvent.getY(i11));
                cVar.f((motionEvent2.getX(i11) + rawX) - ((float) this.f2359c[0]));
                cVar.g((motionEvent2.getY(i11) + rawY) - ((float) this.f2359c[1]));
                l(cVar);
                i10++;
            }
        }
        if (i10 > 0) {
            A();
            w();
        }
    }

    private final void y(MotionEvent motionEvent, MotionEvent motionEvent2) {
        A();
        this.f2368l = null;
        this.f2370n = 3;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        this.f2372p[pointerId] = new c(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent2.getX(motionEvent.getActionIndex()) + (motionEvent2.getRawX() - motionEvent2.getX())) - ((float) this.f2359c[0]), (motionEvent2.getY(motionEvent.getActionIndex()) + (motionEvent2.getRawY() - motionEvent2.getY())) - ((float) this.f2359c[1]));
        c cVar = this.f2372p[pointerId];
        m.c(cVar);
        l(cVar);
        this.f2372p[pointerId] = null;
        this.f2371o--;
        w();
    }

    public final d A0(int i10) {
        this.E = i10;
        return this;
    }

    public final void B() {
        int i10 = this.f2362f;
        if (i10 == 4 || i10 == 0 || i10 == 2) {
            e0(1);
        }
    }

    public final void B0(boolean z10) {
        this.f2373q = z10;
    }

    public final d C0(p pVar) {
        this.B = pVar;
        return this;
    }

    public final int D() {
        return this.f2367k;
    }

    public final int E() {
        return this.F;
    }

    public final d E0(boolean z10) {
        d f10 = q0();
        f10.f2381y = z10;
        return f10;
    }

    public final void F0(boolean z10) {
        this.I = z10;
    }

    public final short G() {
        return this.f2375s;
    }

    public final void G0(int i10) {
        this.f2360d = i10;
    }

    public final float H() {
        return (this.f2376t + this.f2379w) - ((float) this.f2359c[0]);
    }

    /* access modifiers changed from: protected */
    public final boolean H0(MotionEvent motionEvent) {
        m.f(motionEvent, "sourceEvent");
        if (motionEvent.getToolType(0) == 3) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6 || motionEvent.getAction() == 5 || (motionEvent.getAction() != 2 && !Z(motionEvent.getActionButton()))) {
                return false;
            }
            if (motionEvent.getAction() != 2 || Z(motionEvent.getButtonState())) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final float I() {
        return (this.f2377u + this.f2380x) - ((float) this.f2359c[1]);
    }

    public boolean I0(d dVar) {
        e eVar;
        m.f(dVar, "handler");
        if (dVar == this || (eVar = this.C) == null) {
            return false;
        }
        return eVar.d(this, dVar);
    }

    public final float J() {
        return this.f2376t;
    }

    public boolean J0(d dVar) {
        m.f(dVar, "handler");
        if (dVar == this) {
            return true;
        }
        e eVar = this.C;
        if (eVar != null) {
            return eVar.b(this, dVar);
        }
        return false;
    }

    public final float K() {
        return this.f2377u;
    }

    public boolean K0(d dVar) {
        e eVar;
        m.f(dVar, "handler");
        if (dVar == this || (eVar = this.C) == null) {
            return false;
        }
        return eVar.a(this, dVar);
    }

    public final boolean L() {
        return this.f2373q;
    }

    public final boolean L0(d dVar) {
        e eVar;
        m.f(dVar, "handler");
        if (dVar == this || (eVar = this.C) == null) {
            return false;
        }
        return eVar.c(this, dVar);
    }

    public final int M() {
        return this.f2382z;
    }

    public final void M0(int i10) {
        int[] iArr = this.f2357a;
        if (iArr[i10] == -1) {
            iArr[i10] = C();
            this.f2358b++;
        }
    }

    /* access modifiers changed from: protected */
    public final g N() {
        return this.A;
    }

    public final void N0(int i10) {
        int[] iArr = this.f2357a;
        if (iArr[i10] != -1) {
            iArr[i10] = -1;
            this.f2358b--;
        }
    }

    public final int O() {
        return this.D;
    }

    /* access modifiers changed from: protected */
    public final PointF O0(PointF pointF) {
        PointF F2;
        m.f(pointF, "point");
        g gVar = this.A;
        if (gVar != null && (F2 = gVar.F(this.f2361e, pointF)) != null) {
            return F2;
        }
        pointF.x = Float.NaN;
        pointF.y = Float.NaN;
        return pointF;
    }

    public final boolean P() {
        return this.I;
    }

    public final void P0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            v(motionEvent, motionEvent2);
            x(motionEvent, motionEvent2);
        } else if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
            x(motionEvent, motionEvent2);
            y(motionEvent, motionEvent2);
        } else if (motionEvent.getActionMasked() == 2) {
            x(motionEvent, motionEvent2);
        }
    }

    public final int Q() {
        return this.f2362f;
    }

    public final boolean Q0() {
        int i10;
        if (!this.f2366j || (i10 = this.f2362f) == 1 || i10 == 3 || i10 == 5 || this.f2358b <= 0) {
            return false;
        }
        return true;
    }

    public final int R() {
        return this.f2360d;
    }

    public final void R0(Function0 function0) {
        m.f(function0, "closure");
        this.f2365i = true;
        function0.invoke();
        this.f2365i = false;
    }

    public final int S() {
        return this.f2370n;
    }

    public final int T() {
        return this.f2371o;
    }

    public final View U() {
        return this.f2361e;
    }

    public final void V(MotionEvent motionEvent, MotionEvent motionEvent2) {
        int i10;
        m.f(motionEvent, "transformedEvent");
        m.f(motionEvent2, "sourceEvent");
        if (this.f2366j && (i10 = this.f2362f) != 3 && i10 != 1 && i10 != 5 && this.f2358b >= 1) {
            try {
                MotionEvent[] motionEventArr = {k(motionEvent), k(motionEvent2)};
                MotionEvent motionEvent3 = motionEventArr[0];
                MotionEvent motionEvent4 = motionEventArr[1];
                this.f2363g = motionEvent3.getX();
                this.f2364h = motionEvent3.getY();
                this.f2382z = motionEvent3.getPointerCount();
                boolean d02 = d0(this.f2361e, this.f2363g, this.f2364h);
                this.f2365i = d02;
                if (!this.f2381y || d02) {
                    i iVar = i.f2409a;
                    this.f2376t = iVar.b(motionEvent3, true);
                    this.f2377u = iVar.c(motionEvent3, true);
                    this.f2379w = motionEvent3.getRawX() - motionEvent3.getX();
                    this.f2380x = motionEvent3.getRawY() - motionEvent3.getY();
                    if (motionEvent2.getAction() == 0 || motionEvent2.getAction() == 9 || motionEvent2.getAction() == 7) {
                        D0(motionEvent2);
                    }
                    if (motionEvent2.getAction() == 9 || motionEvent2.getAction() == 7 || motionEvent2.getAction() == 10) {
                        i0(motionEvent3, motionEvent4);
                    } else {
                        h0(motionEvent3, motionEvent4);
                    }
                    if (!m.b(motionEvent3, motionEvent)) {
                        motionEvent3.recycle();
                    }
                    if (!m.b(motionEvent4, motionEvent2)) {
                        motionEvent4.recycle();
                        return;
                    }
                    return;
                }
                int i11 = this.f2362f;
                if (i11 == 4) {
                    o();
                } else if (i11 == 2) {
                    B();
                }
            } catch (a unused) {
                B();
            }
        }
    }

    public final boolean W(d dVar) {
        m.f(dVar, "other");
        int length = this.f2357a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.f2357a[i10] != -1 && dVar.f2357a[i10] != -1) {
                return true;
            }
        }
        return false;
    }

    public final boolean X() {
        return this.G;
    }

    public final boolean Y() {
        return this.H;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    public final boolean a0(ab.d r4) {
        /*
            r3 = this;
            java.lang.String r0 = "of"
            kotlin.jvm.internal.m.f(r4, r0)
            android.view.View r0 = r3.f2361e
            r1 = 0
            if (r0 == 0) goto L_0x000f
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L_0x0017
            android.view.View r0 = (android.view.View) r0
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x002f
            android.view.View r2 = r4.f2361e
            boolean r2 = kotlin.jvm.internal.m.b(r0, r2)
            if (r2 == 0) goto L_0x0024
            r4 = 1
            return r4
        L_0x0024:
            android.view.ViewParent r0 = r0.getParent()
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L_0x0017
            android.view.View r0 = (android.view.View) r0
            goto L_0x0018
        L_0x002f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.d.a0(ab.d):boolean");
    }

    public final boolean b0() {
        return this.f2366j;
    }

    public final boolean c0() {
        return this.f2365i;
    }

    public final boolean d0(View view, float f10, float f11) {
        float f12;
        float f13;
        m.c(view);
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        float[] fArr = this.f2374r;
        float f14 = 0.0f;
        if (fArr != null) {
            float f15 = fArr[0];
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            b bVar = J;
            if (bVar.c(f15)) {
                f13 = 0.0f - f15;
            } else {
                f13 = 0.0f;
            }
            if (bVar.c(f16)) {
                f14 = 0.0f - f16;
            }
            if (bVar.c(f17)) {
                width += f17;
            }
            if (bVar.c(f18)) {
                height += f18;
            }
            float f19 = fArr[4];
            float f20 = fArr[5];
            if (bVar.c(f19)) {
                if (!bVar.c(f15)) {
                    f13 = width - f19;
                } else if (!bVar.c(f17)) {
                    width = f19 + f13;
                }
            }
            if (bVar.c(f20)) {
                if (!bVar.c(f16)) {
                    f14 = height - f20;
                } else if (!bVar.c(f18)) {
                    height = f20 + f14;
                }
            }
            f12 = f14;
            f14 = f13;
        } else {
            f12 = 0.0f;
        }
        if (f14 > f10 || f10 > width || f12 > f11 || f11 > height) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void g0() {
    }

    /* access modifiers changed from: protected */
    public abstract void h0(MotionEvent motionEvent, MotionEvent motionEvent2);

    public final void i() {
        j(false);
    }

    /* access modifiers changed from: protected */
    public void i0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        m.f(motionEvent2, "sourceEvent");
    }

    public void j(boolean z10) {
        if (!this.f2378v || z10) {
            int i10 = this.f2362f;
            if (i10 == 0 || i10 == 2) {
                e0(4);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    /* access modifiers changed from: protected */
    public void k0() {
    }

    /* access modifiers changed from: protected */
    public void l0(int i10, int i11) {
    }

    public final void m0(View view, g gVar) {
        Context context;
        if (this.f2361e == null && this.A == null) {
            Arrays.fill(this.f2357a, -1);
            this.f2358b = 0;
            this.f2362f = 0;
            this.f2361e = view;
            this.A = gVar;
            View view2 = null;
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            Activity F2 = F(context);
            if (F2 != null) {
                view2 = F2.findViewById(16908290);
            }
            if (view2 != null) {
                view2.getLocationOnScreen(this.f2359c);
            } else {
                int[] iArr = this.f2359c;
                iArr[0] = 0;
                iArr[1] = 0;
            }
            j0();
            return;
        }
        throw new IllegalStateException("Already prepared or hasn't been reset".toString());
    }

    public final void n() {
        if (this.f2362f == 0) {
            e0(2);
        }
    }

    public final void n0() {
        this.f2361e = null;
        this.A = null;
        Arrays.fill(this.f2357a, -1);
        this.f2358b = 0;
        this.f2371o = 0;
        j.m(this.f2372p, (Object) null, 0, 0, 6, (Object) null);
        this.f2370n = 0;
        k0();
    }

    public final void o() {
        int i10 = this.f2362f;
        if (i10 == 4 || i10 == 0 || i10 == 2 || this.H) {
            g0();
            e0(3);
        }
    }

    public void o0() {
        this.f2373q = false;
        this.f2378v = false;
        this.f2381y = false;
        this.f2366j = true;
        this.f2374r = null;
    }

    public void p0() {
    }

    public final WritableArray q() {
        WritableArray writableArray = this.f2369m;
        this.f2369m = null;
        return writableArray;
    }

    /* access modifiers changed from: protected */
    public final d q0() {
        m.d(this, "null cannot be cast to non-null type ConcreteGestureHandlerT of com.swmansion.gesturehandler.core.GestureHandler");
        return this;
    }

    public final WritableArray r() {
        WritableArray writableArray = this.f2368l;
        this.f2368l = null;
        return writableArray;
    }

    public final void r0(int i10) {
        this.f2367k = i10;
    }

    public final void s0(int i10) {
        this.F = i10;
    }

    public void t(MotionEvent motionEvent) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        p pVar = this.B;
        if (pVar != null) {
            pVar.b(q0(), motionEvent);
        }
    }

    public final void t0(boolean z10) {
        this.G = z10;
    }

    public String toString() {
        String str;
        View view = this.f2361e;
        if (view == null) {
            str = null;
        } else {
            m.c(view);
            str = view.getClass().getSimpleName();
        }
        String simpleName = getClass().getSimpleName();
        int i10 = this.f2360d;
        return simpleName + "@[" + i10 + "]:" + str;
    }

    public void u(int i10, int i11) {
        p pVar = this.B;
        if (pVar != null) {
            pVar.c(q0(), i10, i11);
        }
    }

    public final void u0(boolean z10) {
        this.H = z10;
    }

    public final d v0(boolean z10) {
        d f10 = q0();
        if (!(f10.f2361e == null || f10.f2366j == z10)) {
            UiThreadUtil.runOnUiThread(new c(f10));
        }
        f10.f2366j = z10;
        return f10;
    }

    public void w() {
        p pVar;
        if (this.f2368l != null && (pVar = this.B) != null) {
            pVar.a(q0());
        }
    }

    public final d x0(float f10, float f11, float f12, float f13, float f14, float f15) {
        d f16 = q0();
        if (f16.f2374r == null) {
            f16.f2374r = new float[6];
        }
        float[] fArr = f16.f2374r;
        m.c(fArr);
        fArr[0] = f10;
        float[] fArr2 = f16.f2374r;
        m.c(fArr2);
        fArr2[1] = f11;
        float[] fArr3 = f16.f2374r;
        m.c(fArr3);
        fArr3[2] = f12;
        float[] fArr4 = f16.f2374r;
        m.c(fArr4);
        fArr4[3] = f13;
        float[] fArr5 = f16.f2374r;
        m.c(fArr5);
        fArr5[4] = f14;
        float[] fArr6 = f16.f2374r;
        m.c(fArr6);
        fArr6[5] = f15;
        b bVar = J;
        if (bVar.c(f14) && bVar.c(f10) && bVar.c(f12)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined".toString());
        } else if (bVar.c(f14) && !bVar.c(f10) && !bVar.c(f12)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined".toString());
        } else if (bVar.c(f15) && bVar.c(f13) && bVar.c(f11)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined".toString());
        } else if (!bVar.c(f15) || bVar.c(f13) || bVar.c(f11)) {
            return f16;
        } else {
            throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined".toString());
        }
    }

    public final d y0(e eVar) {
        d f10 = q0();
        f10.C = eVar;
        return f10;
    }

    public final void z() {
        int i10 = this.f2362f;
        if (i10 == 2 || i10 == 4) {
            e0(5);
        }
    }

    public final d z0(boolean z10) {
        d f10 = q0();
        f10.f2378v = z10;
        return f10;
    }
}
