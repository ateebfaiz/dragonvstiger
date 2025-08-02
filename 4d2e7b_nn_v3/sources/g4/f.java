package g4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import c4.c;
import g4.i;
import g4.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.collections.g0;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import w4.d;

public final class f implements i {

    /* renamed from: m  reason: collision with root package name */
    public static final b f21708m = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f21709a;

    /* renamed from: b  reason: collision with root package name */
    private final c f21710b;

    /* renamed from: c  reason: collision with root package name */
    private final f4.c f21711c;

    /* renamed from: d  reason: collision with root package name */
    private final b4.d f21712d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21713e;

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentHashMap f21714f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private volatile int f21715g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f21716h;

    /* renamed from: i  reason: collision with root package name */
    private final g f21717i = new g(k().getFrameCount());

    /* renamed from: j  reason: collision with root package name */
    private int f21718j = -1;

    /* renamed from: k  reason: collision with root package name */
    private Map f21719k = i0.f();

    /* renamed from: l  reason: collision with root package name */
    private Set f21720l = r0.d();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c3.a f21721a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f21722b;

        public a(c3.a aVar) {
            m.f(aVar, "bitmapRef");
            this.f21721a = aVar;
        }

        public final c3.a a() {
            return this.f21721a;
        }

        public final boolean b() {
            if (this.f21722b || !this.f21721a.w()) {
                return false;
            }
            return true;
        }

        public final void c() {
            c3.a.m(this.f21721a);
        }

        public final void d(boolean z10) {
            this.f21722b = z10;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(d dVar, c cVar, f4.c cVar2, b4.d dVar2) {
        m.f(dVar, "platformBitmapFactory");
        m.f(cVar, "bitmapFrameRenderer");
        m.f(cVar2, "fpsCompressor");
        m.f(dVar2, "animationInformation");
        this.f21709a = dVar;
        this.f21710b = cVar;
        this.f21711c = cVar2;
        this.f21712d = dVar2;
        int j10 = j(k());
        this.f21713e = j10;
        c(j(k()));
        this.f21715g = (int) (((float) j10) * 0.5f);
    }

    private final void e(c3.a aVar) {
        if (aVar.w()) {
            new Canvas((Bitmap) aVar.p()).drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
        tb.c.a(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fc, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean f(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            g4.g r14 = r10.f21717i
            int r0 = r10.f21713e
            java.util.List r11 = r14.d(r11, r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0013:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0034
            java.lang.Object r0 = r11.next()
            r1 = r0
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.util.Set r2 = r10.f21720l
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r2.contains(r1)
            if (r1 == 0) goto L_0x0013
            r14.add(r0)
            goto L_0x0013
        L_0x0034:
            java.util.Set r11 = kotlin.collections.r.A0(r14)
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            java.util.concurrent.ConcurrentHashMap r1 = r10.f21714f
            java.util.Set r1 = r1.keySet()
            java.lang.String r2 = "bufferFramesHash.keys"
            kotlin.jvm.internal.m.e(r1, r2)
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r1 = kotlin.collections.r0.i(r1, r2)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            java.util.Iterator r1 = r14.iterator()
        L_0x0055:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x00fd
            java.lang.Object r2 = r1.next()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.util.concurrent.ConcurrentHashMap r5 = r10.f21714f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Object r5 = r5.get(r6)
            if (r5 == 0) goto L_0x0074
            goto L_0x0055
        L_0x0074:
            int r5 = r10.f21718j
            r6 = -1
            if (r5 == r6) goto L_0x0084
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r5 = r11.contains(r5)
            if (r5 != 0) goto L_0x0084
            return r4
        L_0x0084:
            java.lang.Object r5 = r0.pollFirst()
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x0090
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
        L_0x0090:
            java.lang.String r6 = "oldFramesNumbers.pollFirst() ?: -1"
            kotlin.jvm.internal.m.e(r5, r6)
            int r5 = r5.intValue()
            java.util.concurrent.ConcurrentHashMap r6 = r10.f21714f
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r6.get(r7)
            g4.f$a r6 = (g4.f.a) r6
            r7 = 0
            if (r6 == 0) goto L_0x00b3
            c3.a r8 = r6.a()
            if (r8 == 0) goto L_0x00b3
            c3.a r8 = r8.h()
            goto L_0x00b4
        L_0x00b3:
            r8 = r7
        L_0x00b4:
            if (r8 == 0) goto L_0x00b7
            goto L_0x00d4
        L_0x00b7:
            g4.f$a r6 = new g4.f$a
            w4.d r8 = r10.f21709a
            c3.a r8 = r8.a(r12, r13)
            java.lang.String r9 = "platformBitmapFactory.createBitmap(width, height)"
            kotlin.jvm.internal.m.e(r8, r9)
            r6.<init>(r8)
            c3.a r8 = r6.a()
            c3.a r8 = r8.b()
            java.lang.String r9 = "bufferFrame.bitmapRef.clone()"
            kotlin.jvm.internal.m.e(r8, r9)
        L_0x00d4:
            r6.d(r3)
            r10.n(r8, r2, r12, r13)     // Catch:{ all -> 0x00f6 }
            kotlin.Unit r3 = kotlin.Unit.f12577a     // Catch:{ all -> 0x00f6 }
            tb.c.a(r8, r7)
            java.util.concurrent.ConcurrentHashMap r3 = r10.f21714f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.remove(r5)
            r6.d(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.concurrent.ConcurrentHashMap r3 = r10.f21714f
            r3.put(r2, r6)
            goto L_0x0055
        L_0x00f6:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r12 = move-exception
            tb.c.a(r8, r11)
            throw r12
        L_0x00fd:
            boolean r11 = r14.isEmpty()
            r12 = 1056964608(0x3f000000, float:0.5)
            if (r11 == 0) goto L_0x010b
            int r11 = r10.f21713e
            float r11 = (float) r11
            float r11 = r11 * r12
            int r11 = (int) r11
            goto L_0x0121
        L_0x010b:
            int r11 = r14.size()
            float r13 = (float) r11
            float r13 = r13 * r12
            int r12 = (int) r13
            int r11 = r11 - r3
            int r11 = kotlin.ranges.l.h(r12, r4, r11)
            java.lang.Object r11 = r14.get(r11)
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
        L_0x0121:
            r10.f21715g = r11
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.f.f(int, int, int, int):boolean");
    }

    static /* synthetic */ boolean g(f fVar, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        return fVar.f(i10, i11, i12, i13);
    }

    private final a h(int i10) {
        a aVar;
        Iterator it = new IntRange(0, this.f21717i.b()).iterator();
        do {
            aVar = null;
            if (!it.hasNext()) {
                break;
            }
            int a10 = this.f21717i.a(i10 - ((g0) it).nextInt());
            a aVar2 = (a) this.f21714f.get(Integer.valueOf(a10));
            if (aVar2 != null) {
                if (!aVar2.b()) {
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    aVar = new a(a10, aVar2.a());
                    continue;
                } else {
                    continue;
                }
            }
        } while (aVar == null);
        return aVar;
    }

    private final k i(int i10) {
        a h10 = h(i10);
        if (h10 == null) {
            return new k((c3.a) null, k.a.MISSING);
        }
        c3.a b10 = h10.a().b();
        m.e(b10, "nearestFrame.bitmap.clone()");
        this.f21718j = h10.b();
        return new k(b10, k.a.NEAREST);
    }

    private final int j(b4.d dVar) {
        return (int) l.d(TimeUnit.SECONDS.toMillis(1) / ((long) (dVar.g() / dVar.getFrameCount())), 1);
    }

    private final void l(int i10, int i11) {
        if (!this.f21716h) {
            this.f21716h = true;
            f4.b.f21517a.b(new e(this, i10, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final void m(f fVar, int i10, int i11) {
        m.f(fVar, "this$0");
        do {
        } while (!g(fVar, l.c(fVar.f21718j, 0), i10, i11, 0, 8, (Object) null));
        fVar.f21716h = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        tb.c.a(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void n(c3.a r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            g4.a r7 = r4.h(r6)
            java.lang.String r8 = "targetBitmap.get()"
            if (r7 == 0) goto L_0x0062
            c3.a r0 = r7.a()
            if (r0 == 0) goto L_0x0062
            c3.a r0 = r0.h()
            if (r0 == 0) goto L_0x0062
            int r7 = r7.b()     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r7 >= r6) goto L_0x0056
            java.lang.Object r2 = r0.p()     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "nearestBitmap.get()"
            kotlin.jvm.internal.m.e(r2, r3)     // Catch:{ all -> 0x0050 }
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ all -> 0x0050 }
            r4.o(r5, r2)     // Catch:{ all -> 0x0050 }
            kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange     // Catch:{ all -> 0x0050 }
            int r7 = r7 + 1
            r2.<init>(r7, r6)     // Catch:{ all -> 0x0050 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0050 }
        L_0x0034:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x0052
            r7 = r6
            kotlin.collections.g0 r7 = (kotlin.collections.g0) r7     // Catch:{ all -> 0x0050 }
            int r7 = r7.nextInt()     // Catch:{ all -> 0x0050 }
            c4.c r2 = r4.f21710b     // Catch:{ all -> 0x0050 }
            java.lang.Object r3 = r5.p()     // Catch:{ all -> 0x0050 }
            kotlin.jvm.internal.m.e(r3, r8)     // Catch:{ all -> 0x0050 }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ all -> 0x0050 }
            r2.d(r7, r3)     // Catch:{ all -> 0x0050 }
            goto L_0x0034
        L_0x0050:
            r5 = move-exception
            goto L_0x005c
        L_0x0052:
            tb.c.a(r0, r1)
            return
        L_0x0056:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0050 }
            tb.c.a(r0, r1)
            goto L_0x0062
        L_0x005c:
            throw r5     // Catch:{ all -> 0x005d }
        L_0x005d:
            r6 = move-exception
            tb.c.a(r0, r5)
            throw r6
        L_0x0062:
            r4.e(r5)
            kotlin.ranges.IntRange r7 = new kotlin.ranges.IntRange
            r0 = 0
            r7.<init>(r0, r6)
            java.util.Iterator r6 = r7.iterator()
        L_0x006f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x008b
            r7 = r6
            kotlin.collections.g0 r7 = (kotlin.collections.g0) r7
            int r7 = r7.nextInt()
            c4.c r0 = r4.f21710b
            java.lang.Object r1 = r5.p()
            kotlin.jvm.internal.m.e(r1, r8)
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0.d(r7, r1)
            goto L_0x006f
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.f.n(c3.a, int, int, int):void");
    }

    private final c3.a o(c3.a aVar, Bitmap bitmap) {
        if (aVar.w() && !m.b(aVar.p(), bitmap)) {
            Canvas canvas = new Canvas((Bitmap) aVar.p());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        return aVar;
    }

    public void a(int i10, int i11, Function0 function0) {
        m.f(function0, "onAnimationLoaded");
        l(i10, i11);
        function0.invoke();
    }

    public k b(int i10, int i11, int i12) {
        Integer num = (Integer) this.f21719k.get(Integer.valueOf(i10));
        if (num == null) {
            return i(i10);
        }
        int intValue = num.intValue();
        this.f21718j = intValue;
        a aVar = (a) this.f21714f.get(num);
        if (aVar == null || !aVar.b()) {
            aVar = null;
        }
        if (aVar != null) {
            if (this.f21717i.c(this.f21715g, intValue, this.f21713e)) {
                l(i11, i12);
            }
            return new k(aVar.a().b(), k.a.SUCCESS);
        }
        l(i11, i12);
        return i(intValue);
    }

    public void c(int i10) {
        Map a10 = this.f21711c.a(k().g() * l.c(k().getLoopCount(), 1), k().getFrameCount(), l.f(i10, j(k())));
        this.f21719k = a10;
        this.f21720l = r.A0(a10.values());
    }

    public void clear() {
        Collection<a> values = this.f21714f.values();
        m.e(values, "bufferFramesHash.values");
        for (a c10 : values) {
            c10.c();
        }
        this.f21714f.clear();
        this.f21718j = -1;
    }

    public b4.d k() {
        return this.f21712d;
    }

    public void onStop() {
        i.a.a(this);
    }
}
