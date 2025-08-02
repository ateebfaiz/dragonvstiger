package g4;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.work.WorkRequest;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.l;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f21695a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicInteger f21696b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f21697c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f21698d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f21699e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final Lazy f21700f = i.b(b.f21704a);

    /* renamed from: g  reason: collision with root package name */
    private static final Runnable f21701g;

    /* renamed from: h  reason: collision with root package name */
    private static final Runnable f21702h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21703a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                g4.k$a[] r0 = g4.k.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                g4.k$a r1 = g4.k.a.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                g4.k$a r1 = g4.k.a.NEAREST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                g4.k$a r1 = g4.k.a.MISSING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f21703a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g4.d.a.<clinit>():void");
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21704a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("FrescoAnimationWorker");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    }

    static {
        d dVar = new d();
        f21695a = dVar;
        b bVar = new b();
        f21701g = bVar;
        c cVar = new c();
        f21702h = cVar;
        dVar.e().post(bVar);
        dVar.e().post(cVar);
    }

    private d() {
    }

    /* access modifiers changed from: private */
    public static final void c() {
        float andSet = (float) f21696b.getAndSet(0);
        float andSet2 = (float) f21697c.getAndSet(0);
        float andSet3 = (float) f21698d.getAndSet(0);
        float f10 = andSet + andSet2 + andSet3;
        if (f10 > 0.0f) {
            float f11 = andSet / f10;
            float f12 = andSet3 / f10;
            if (andSet2 / f10 > 0.25f || f12 > 0.1f) {
                for (Map.Entry entry : f21699e.entrySet()) {
                    int intValue = ((Number) entry.getValue()).intValue();
                    f21695a.i((h) entry.getKey(), -intValue);
                }
            } else if (f11 > 0.98f) {
                for (Map.Entry entry2 : f21699e.entrySet()) {
                    int intValue2 = ((Number) entry2.getValue()).intValue();
                    f21695a.i((h) entry2.getKey(), intValue2);
                }
            }
            f21699e.clear();
        }
        f21695a.h();
    }

    /* access modifiers changed from: private */
    public static final void d() {
        j.f21724c.a(new Date(System.currentTimeMillis() - WorkRequest.MIN_BACKOFF_MILLIS));
        f21695a.g();
    }

    private final Handler e() {
        return (Handler) f21700f.getValue();
    }

    private final boolean g() {
        return e().postDelayed(f21702h, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private final boolean h() {
        return e().postDelayed(f21701g, 2000);
    }

    private final void i(h hVar, int i10) {
        int h10 = l.h(hVar.b() + i10, (int) l.b(((float) hVar.a()) * 0.5f, 1.0f), hVar.a());
        if (h10 != hVar.b()) {
            hVar.c(h10);
        }
    }

    public final void f(h hVar, k kVar) {
        m.f(hVar, "animation");
        m.f(kVar, "frameResult");
        ConcurrentHashMap concurrentHashMap = f21699e;
        if (!concurrentHashMap.contains(hVar)) {
            concurrentHashMap.put(hVar, Integer.valueOf((int) (((float) hVar.a()) * 0.2f)));
        }
        int i10 = a.f21703a[kVar.b().ordinal()];
        if (i10 == 1) {
            f21696b.incrementAndGet();
        } else if (i10 == 2) {
            f21697c.incrementAndGet();
        } else if (i10 == 3) {
            f21698d.incrementAndGet();
        }
    }
}
