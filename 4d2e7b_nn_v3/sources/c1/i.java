package c1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class i implements Application.ActivityLifecycleCallbacks, Handler.Callback {
    private static volatile long C;

    /* renamed from: a  reason: collision with root package name */
    public static final i f17220a;

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList f17221b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f17222c;

    /* renamed from: d  reason: collision with root package name */
    private static Application f17223d;

    /* renamed from: e  reason: collision with root package name */
    private static int f17224e;

    /* renamed from: f  reason: collision with root package name */
    private static int f17225f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f17226g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f17227h = SystemClock.elapsedRealtime();

    /* renamed from: i  reason: collision with root package name */
    private static boolean f17228i = true;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f17229j;

    /* renamed from: w  reason: collision with root package name */
    private static volatile long f17230w;

    public interface a {
        void a(boolean z10, long j10);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    static {
        i iVar = new i();
        f17220a = iVar;
        f17222c = new Handler(Looper.getMainLooper(), iVar);
    }

    private i() {
    }

    public static final long a() {
        return C;
    }

    public static final long b() {
        return f17230w;
    }

    private final long d(Message message) {
        return (((long) message.arg1) << 32) | ((long) message.arg2);
    }

    public static final boolean e() {
        return f17229j;
    }

    public static final void f(a aVar) {
        h(aVar, false, 2, (Object) null);
    }

    public static final void g(a aVar, boolean z10) {
        long j10;
        ArrayList arrayList = f17221b;
        synchronized (arrayList) {
            arrayList.add(new WeakReference(aVar));
        }
        if (z10) {
            boolean z11 = f17229j;
            if (z11) {
                j10 = C;
            } else {
                j10 = f17230w;
            }
            aVar.a(z11, j10);
        }
    }

    public static /* synthetic */ void h(a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        g(aVar, z10);
    }

    public static final void i(Application application) {
        Application application2 = f17223d;
        if (application != application2) {
            if (application2 != null) {
                application2.unregisterActivityLifecycleCallbacks(f17220a);
            }
            f17223d = application;
            application.registerActivityLifecycleCallbacks(f17220a);
        }
    }

    private final void j(Message message, long j10) {
        message.arg1 = (int) ((j10 >>> 32) & 4294967295L);
        message.arg2 = (int) (j10 & 4294967295L);
    }

    public final long c() {
        return f17227h;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|(4:15|(2:17|29)(2:20|30)|28|13)|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r7) {
        /*
            r6 = this;
            int r0 = r7.what
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0007
            return r1
        L_0x0007:
            f17226g = r1
            boolean r0 = f17228i
            if (r0 != 0) goto L_0x004a
            f17229j = r1
            f17228i = r2
            long r3 = r6.d(r7)
            java.util.ArrayList r7 = f17221b
            monitor-enter(r7)
            boolean r0 = r7.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0020
            monitor-exit(r7)
            goto L_0x0045
        L_0x0020:
            java.util.Iterator r0 = r7.iterator()     // Catch:{ Exception -> 0x0042 }
        L_0x0024:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x0042 }
            if (r5 == 0) goto L_0x0042
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x0042 }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0042 }
            c1.i$a r5 = (c1.i.a) r5     // Catch:{ Exception -> 0x0042 }
            if (r5 != 0) goto L_0x003e
            r0.remove()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0024
        L_0x003c:
            r0 = move-exception
            goto L_0x0048
        L_0x003e:
            r5.a(r1, r3)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0024
        L_0x0042:
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003c }
            monitor-exit(r7)
        L_0x0045:
            f17230w = r3
            goto L_0x004a
        L_0x0048:
            monitor-exit(r7)
            throw r0
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.i.handleMessage(android.os.Message):boolean");
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        f17224e++;
    }

    public void onActivityDestroyed(Activity activity) {
        f17224e = Math.max(0, f17224e - 1);
    }

    public void onActivityPaused(Activity activity) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(4:10|(2:12|22)(2:15|23)|21|8)|16|17|18|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityPostStarted(android.app.Activity r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)
            goto L_0x0030
        L_0x000b:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x002d }
        L_0x000f:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ Exception -> 0x002d }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x002d }
            c1.i$a r2 = (c1.i.a) r2     // Catch:{ Exception -> 0x002d }
            if (r2 != 0) goto L_0x0029
            r1.remove()     // Catch:{ Exception -> 0x002d }
            goto L_0x000f
        L_0x0027:
            r4 = move-exception
            goto L_0x0031
        L_0x0029:
            r2.onActivityStarted(r4)     // Catch:{ Exception -> 0x002d }
            goto L_0x000f
        L_0x002d:
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
        L_0x0030:
            return
        L_0x0031:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.i.onActivityPostStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(4:10|(2:12|22)(2:15|23)|21|8)|16|17|18|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityPostStopped(android.app.Activity r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)
            goto L_0x0030
        L_0x000b:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x002d }
        L_0x000f:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x002d }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ Exception -> 0x002d }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x002d }
            c1.i$a r2 = (c1.i.a) r2     // Catch:{ Exception -> 0x002d }
            if (r2 != 0) goto L_0x0029
            r1.remove()     // Catch:{ Exception -> 0x002d }
            goto L_0x000f
        L_0x0027:
            r4 = move-exception
            goto L_0x0031
        L_0x0029:
            r2.onActivityStopped(r4)     // Catch:{ Exception -> 0x002d }
            goto L_0x000f
        L_0x002d:
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
        L_0x0030:
            return
        L_0x0031:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.i.onActivityPostStopped(android.app.Activity):void");
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|(4:14|(2:16|50)(2:19|51)|49|12)|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:34|35|(4:38|(2:40|53)(2:43|54)|52|36)|44|45|46|57) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0084 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityStarted(android.app.Activity r7) {
        /*
            r6 = this;
            int r0 = f17225f
            r1 = 1
            if (r0 != 0) goto L_0x0042
            boolean r0 = f17226g
            if (r0 != 0) goto L_0x0042
            long r2 = android.os.SystemClock.elapsedRealtime()
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r4 = r0.isEmpty()     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x0018
            monitor-exit(r0)
            goto L_0x003d
        L_0x0018:
            java.util.Iterator r4 = r0.iterator()     // Catch:{ Exception -> 0x003a }
        L_0x001c:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r5 == 0) goto L_0x003a
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x003a }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ Exception -> 0x003a }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x003a }
            c1.i$a r5 = (c1.i.a) r5     // Catch:{ Exception -> 0x003a }
            if (r5 != 0) goto L_0x0036
            r4.remove()     // Catch:{ Exception -> 0x003a }
            goto L_0x001c
        L_0x0034:
            r7 = move-exception
            goto L_0x0040
        L_0x0036:
            r5.a(r1, r2)     // Catch:{ Exception -> 0x003a }
            goto L_0x001c
        L_0x003a:
            kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)
        L_0x003d:
            C = r2
            goto L_0x0042
        L_0x0040:
            monitor-exit(r0)
            throw r7
        L_0x0042:
            int r0 = f17225f
            int r0 = r0 + r1
            f17225f = r0
            android.os.Handler r0 = f17222c
            r0.removeMessages(r1)
            f17229j = r1
            r0 = 0
            f17226g = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x008a
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0062
            monitor-exit(r0)
            goto L_0x008a
        L_0x0062:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x0084 }
        L_0x0066:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0084 }
            if (r2 == 0) goto L_0x0084
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0084 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ Exception -> 0x0084 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x0084 }
            c1.i$a r2 = (c1.i.a) r2     // Catch:{ Exception -> 0x0084 }
            if (r2 != 0) goto L_0x0080
            r1.remove()     // Catch:{ Exception -> 0x0084 }
            goto L_0x0066
        L_0x007e:
            r7 = move-exception
            goto L_0x0088
        L_0x0080:
            r2.onActivityStarted(r7)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0066
        L_0x0084:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x007e }
            monitor-exit(r0)
            goto L_0x008a
        L_0x0088:
            monitor-exit(r0)
            throw r7
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.i.onActivityStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|(4:15|(2:17|51)(2:20|52)|50|13)|21|22|23) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:35|36|(4:39|(2:41|54)(2:44|55)|53|37)|45|46|47|58) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0092 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityStopped(android.app.Activity r7) {
        /*
            r6 = this;
            int r0 = f17225f
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            int r0 = java.lang.Math.max(r2, r0)
            f17225f = r0
            if (r0 != 0) goto L_0x005f
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r0 = r7.isChangingConfigurations()
            if (r0 == 0) goto L_0x0028
            f17226g = r1
            android.os.Handler r0 = f17222c
            android.os.Message r1 = r0.obtainMessage(r1)
            r6.j(r1, r3)
            r2 = 700(0x2bc, double:3.46E-321)
            r0.sendMessageDelayed(r1, r2)
            goto L_0x005f
        L_0x0028:
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x0033
            monitor-exit(r0)
            goto L_0x0058
        L_0x0033:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x0055 }
        L_0x0037:
            boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0055 }
            if (r5 == 0) goto L_0x0055
            java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0055 }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0055 }
            c1.i$a r5 = (c1.i.a) r5     // Catch:{ Exception -> 0x0055 }
            if (r5 != 0) goto L_0x0051
            r1.remove()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0037
        L_0x004f:
            r7 = move-exception
            goto L_0x005d
        L_0x0051:
            r5.a(r2, r3)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0037
        L_0x0055:
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x004f }
            monitor-exit(r0)
        L_0x0058:
            f17229j = r2
            f17230w = r3
            goto L_0x005f
        L_0x005d:
            monitor-exit(r0)
            throw r7
        L_0x005f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x0098
            java.util.ArrayList r0 = f17221b
            monitor-enter(r0)
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0070
            monitor-exit(r0)
            goto L_0x0098
        L_0x0070:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ Exception -> 0x0092 }
        L_0x0074:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0092 }
            if (r2 == 0) goto L_0x0092
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0092 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ Exception -> 0x0092 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x0092 }
            c1.i$a r2 = (c1.i.a) r2     // Catch:{ Exception -> 0x0092 }
            if (r2 != 0) goto L_0x008e
            r1.remove()     // Catch:{ Exception -> 0x0092 }
            goto L_0x0074
        L_0x008c:
            r7 = move-exception
            goto L_0x0096
        L_0x008e:
            r2.onActivityStopped(r7)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0074
        L_0x0092:
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x008c }
            monitor-exit(r0)
            goto L_0x0098
        L_0x0096:
            monitor-exit(r0)
            throw r7
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.i.onActivityStopped(android.app.Activity):void");
    }
}
