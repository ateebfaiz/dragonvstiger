package l2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.o;
import com.facebook.w;
import e2.g;
import j2.f;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.d0;
import q5.n;
import q5.p0;
import q5.r;
import q5.s;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f22392a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ScheduledExecutorService f22393b = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile ScheduledFuture f22394c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Object f22395d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f22396e = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static volatile h f22397f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicBoolean f22398g = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static String f22399h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static long f22400i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static int f22401j;

    /* renamed from: k  reason: collision with root package name */
    private static WeakReference f22402k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f22403l = new a();

    /* renamed from: l2.a$a  reason: collision with other inner class name */
    static final class C0301a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C0301a f22404a = new C0301a();

        C0301a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    a aVar = a.f22403l;
                    if (a.f22397f == null) {
                        a.f22397f = h.f22435g.b();
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22405a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22406b;

        /* renamed from: l2.a$b$a  reason: collision with other inner class name */
        static final class C0302a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f22407a;

            C0302a(b bVar) {
                this.f22407a = bVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
                v5.a.b(r0, r8);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r8 = this;
                    boolean r0 = v5.a.d(r8)
                    if (r0 == 0) goto L_0x0007
                    return
                L_0x0007:
                    l2.a r0 = l2.a.f22403l     // Catch:{ all -> 0x0025 }
                    l2.h r1 = l2.a.f22397f     // Catch:{ all -> 0x0025 }
                    if (r1 != 0) goto L_0x0027
                    l2.h r1 = new l2.h     // Catch:{ all -> 0x0025 }
                    l2.a$b r2 = r8.f22407a     // Catch:{ all -> 0x0025 }
                    long r2 = r2.f22405a     // Catch:{ all -> 0x0025 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0025 }
                    r6 = 4
                    r7 = 0
                    r4 = 0
                    r5 = 0
                    r2 = r1
                    r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0025 }
                    l2.a.f22397f = r1     // Catch:{ all -> 0x0025 }
                    goto L_0x0027
                L_0x0025:
                    r0 = move-exception
                    goto L_0x0058
                L_0x0027:
                    java.util.concurrent.atomic.AtomicInteger r1 = l2.a.f22396e     // Catch:{ all -> 0x0025 }
                    int r1 = r1.get()     // Catch:{ all -> 0x0025 }
                    r2 = 0
                    if (r1 > 0) goto L_0x0049
                    l2.a$b r1 = r8.f22407a     // Catch:{ all -> 0x0025 }
                    java.lang.String r1 = r1.f22406b     // Catch:{ all -> 0x0025 }
                    l2.h r3 = l2.a.f22397f     // Catch:{ all -> 0x0025 }
                    java.lang.String r4 = l2.a.f22399h     // Catch:{ all -> 0x0025 }
                    l2.i.e(r1, r3, r4)     // Catch:{ all -> 0x0025 }
                    l2.h$a r1 = l2.h.f22435g     // Catch:{ all -> 0x0025 }
                    r1.a()     // Catch:{ all -> 0x0025 }
                    l2.a.f22397f = r2     // Catch:{ all -> 0x0025 }
                L_0x0049:
                    java.lang.Object r1 = l2.a.f22395d     // Catch:{ all -> 0x0025 }
                    monitor-enter(r1)     // Catch:{ all -> 0x0025 }
                    l2.a.f22394c = r2     // Catch:{ all -> 0x0055 }
                    kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0025 }
                    return
                L_0x0055:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0025 }
                    throw r0     // Catch:{ all -> 0x0025 }
                L_0x0058:
                    v5.a.b(r0, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: l2.a.b.C0302a.run():void");
            }
        }

        b(long j10, String str) {
            this.f22405a = j10;
            this.f22406b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
            v5.a.b(r0, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r8 = this;
                boolean r0 = v5.a.d(r8)
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                l2.a r0 = l2.a.f22403l     // Catch:{ all -> 0x0023 }
                l2.h r1 = l2.a.f22397f     // Catch:{ all -> 0x0023 }
                if (r1 != 0) goto L_0x0025
                l2.h r1 = new l2.h     // Catch:{ all -> 0x0023 }
                long r2 = r8.f22405a     // Catch:{ all -> 0x0023 }
                java.lang.Long r3 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0023 }
                r6 = 4
                r7 = 0
                r4 = 0
                r5 = 0
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0023 }
                l2.a.f22397f = r1     // Catch:{ all -> 0x0023 }
                goto L_0x0025
            L_0x0023:
                r0 = move-exception
                goto L_0x0081
            L_0x0025:
                l2.h r1 = l2.a.f22397f     // Catch:{ all -> 0x0023 }
                if (r1 == 0) goto L_0x0034
                long r2 = r8.f22405a     // Catch:{ all -> 0x0023 }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0023 }
                r1.k(r2)     // Catch:{ all -> 0x0023 }
            L_0x0034:
                java.util.concurrent.atomic.AtomicInteger r1 = l2.a.f22396e     // Catch:{ all -> 0x0023 }
                int r1 = r1.get()     // Catch:{ all -> 0x0023 }
                if (r1 > 0) goto L_0x0061
                l2.a$b$a r1 = new l2.a$b$a     // Catch:{ all -> 0x0023 }
                r1.<init>(r8)     // Catch:{ all -> 0x0023 }
                java.lang.Object r2 = l2.a.f22395d     // Catch:{ all -> 0x0023 }
                monitor-enter(r2)     // Catch:{ all -> 0x0023 }
                java.util.concurrent.ScheduledExecutorService r3 = l2.a.f22393b     // Catch:{ all -> 0x005e }
                int r4 = r0.r()     // Catch:{ all -> 0x005e }
                long r4 = (long) r4     // Catch:{ all -> 0x005e }
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x005e }
                java.util.concurrent.ScheduledFuture r1 = r3.schedule(r1, r4, r6)     // Catch:{ all -> 0x005e }
                l2.a.f22394c = r1     // Catch:{ all -> 0x005e }
                kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x005e }
                monitor-exit(r2)     // Catch:{ all -> 0x0023 }
                goto L_0x0061
            L_0x005e:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0023 }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x0061:
                long r1 = l2.a.f22400i     // Catch:{ all -> 0x0023 }
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 <= 0) goto L_0x0072
                long r3 = r8.f22405a     // Catch:{ all -> 0x0023 }
                long r3 = r3 - r1
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1     // Catch:{ all -> 0x0023 }
                long r3 = r3 / r1
            L_0x0072:
                java.lang.String r1 = r8.f22406b     // Catch:{ all -> 0x0023 }
                l2.d.e(r1, r3)     // Catch:{ all -> 0x0023 }
                l2.h r0 = l2.a.f22397f     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x0080
                r0.m()     // Catch:{ all -> 0x0023 }
            L_0x0080:
                return
            L_0x0081:
                v5.a.b(r0, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.a.b.run():void");
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22408a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22409b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f22410c;

        c(long j10, String str, Context context) {
            this.f22408a = j10;
            this.f22409b = str;
            this.f22410c = context;
        }

        public final void run() {
            Long l10;
            h e10;
            if (!v5.a.d(this)) {
                try {
                    a aVar = a.f22403l;
                    h e11 = a.f22397f;
                    if (e11 != null) {
                        l10 = e11.e();
                    } else {
                        l10 = null;
                    }
                    if (a.f22397f == null) {
                        a.f22397f = new h(Long.valueOf(this.f22408a), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
                        String str = this.f22409b;
                        String b10 = a.f22399h;
                        Context context = this.f22410c;
                        m.e(context, "appContext");
                        i.c(str, (j) null, b10, context);
                    } else if (l10 != null) {
                        long longValue = this.f22408a - l10.longValue();
                        if (longValue > ((long) (aVar.r() * 1000))) {
                            i.e(this.f22409b, a.f22397f, a.f22399h);
                            String str2 = this.f22409b;
                            String b11 = a.f22399h;
                            Context context2 = this.f22410c;
                            m.e(context2, "appContext");
                            i.c(str2, (j) null, b11, context2);
                            a.f22397f = new h(Long.valueOf(this.f22408a), (Long) null, (UUID) null, 4, (DefaultConstructorMarker) null);
                        } else if (longValue > 1000 && (e10 = a.f22397f) != null) {
                            e10.h();
                        }
                    }
                    h e12 = a.f22397f;
                    if (e12 != null) {
                        e12.k(Long.valueOf(this.f22408a));
                    }
                    h e13 = a.f22397f;
                    if (e13 != null) {
                        e13.m();
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class d implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f22411a = new d();

        d() {
        }

        public final void a(boolean z10) {
            if (z10) {
                g2.b.g();
            } else {
                g2.b.f();
            }
        }
    }

    public static final class e implements Application.ActivityLifecycleCallbacks {
        e() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
            d0.f23283f.b(w.APP_EVENTS, a.f22392a, "onActivityCreated");
            b.a();
            a.t(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            m.f(activity, "activity");
            d0.a aVar = d0.f23283f;
            w wVar = w.APP_EVENTS;
            a aVar2 = a.f22403l;
            aVar.b(wVar, a.f22392a, "onActivityDestroyed");
            aVar2.u(activity);
        }

        public void onActivityPaused(Activity activity) {
            m.f(activity, "activity");
            d0.a aVar = d0.f23283f;
            w wVar = w.APP_EVENTS;
            a aVar2 = a.f22403l;
            aVar.b(wVar, a.f22392a, "onActivityPaused");
            b.a();
            aVar2.v(activity);
        }

        public void onActivityResumed(Activity activity) {
            m.f(activity, "activity");
            d0.f23283f.b(w.APP_EVENTS, a.f22392a, "onActivityResumed");
            b.a();
            a.w(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
            m.f(bundle, "outState");
            d0.f23283f.b(w.APP_EVENTS, a.f22392a, "onActivitySaveInstanceState");
        }

        public void onActivityStarted(Activity activity) {
            m.f(activity, "activity");
            a aVar = a.f22403l;
            a.f22401j = a.f22401j + 1;
            d0.f23283f.b(w.APP_EVENTS, a.f22392a, "onActivityStarted");
        }

        public void onActivityStopped(Activity activity) {
            m.f(activity, "activity");
            d0.a aVar = d0.f23283f;
            w wVar = w.APP_EVENTS;
            a aVar2 = a.f22403l;
            aVar.b(wVar, a.f22392a, "onActivityStopped");
            g.f21166c.g();
            a.f22401j = a.f22401j - 1;
        }
    }

    static {
        String canonicalName = a.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        f22392a = canonicalName;
    }

    private a() {
    }

    private final void o() {
        ScheduledFuture scheduledFuture;
        synchronized (f22395d) {
            try {
                if (!(f22394c == null || (scheduledFuture = f22394c) == null)) {
                    scheduledFuture.cancel(false);
                }
                f22394c = null;
                Unit unit = Unit.f12577a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final Activity p() {
        WeakReference weakReference = f22402k;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public static final UUID q() {
        h hVar;
        if (f22397f == null || (hVar = f22397f) == null) {
            return null;
        }
        return hVar.d();
    }

    /* access modifiers changed from: private */
    public final int r() {
        r j10 = s.j(o.g());
        if (j10 != null) {
            return j10.l();
        }
        return e.a();
    }

    public static final boolean s() {
        if (f22401j == 0) {
            return true;
        }
        return false;
    }

    public static final void t(Activity activity) {
        f22393b.execute(C0301a.f22404a);
    }

    /* access modifiers changed from: private */
    public final void u(Activity activity) {
        g2.b.k(activity);
    }

    /* access modifiers changed from: private */
    public final void v(Activity activity) {
        AtomicInteger atomicInteger = f22396e;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(f22392a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        o();
        long currentTimeMillis = System.currentTimeMillis();
        String t10 = p0.t(activity);
        g2.b.l(activity);
        f22393b.execute(new b(currentTimeMillis, t10));
    }

    public static final void w(Activity activity) {
        m.f(activity, "activity");
        f22402k = new WeakReference(activity);
        f22396e.incrementAndGet();
        f22403l.o();
        long currentTimeMillis = System.currentTimeMillis();
        f22400i = currentTimeMillis;
        String t10 = p0.t(activity);
        g2.b.m(activity);
        f2.a.d(activity);
        p2.d.h(activity);
        f.b();
        f22393b.execute(new c(currentTimeMillis, t10, activity.getApplicationContext()));
    }

    public static final void x(Application application, String str) {
        m.f(application, "application");
        if (f22398g.compareAndSet(false, true)) {
            n.a(n.b.CodelessEvents, d.f22411a);
            f22399h = str;
            application.registerActivityLifecycleCallbacks(new e());
        }
    }
}
