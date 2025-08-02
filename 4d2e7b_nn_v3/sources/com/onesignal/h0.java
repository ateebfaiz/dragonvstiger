package com.onesignal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.o3;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

abstract class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List f10648a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap f10649b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10650c;

    /* renamed from: d  reason: collision with root package name */
    static final Object f10651d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static c f10652e;

    /* renamed from: f  reason: collision with root package name */
    static Thread f10653f;

    /* renamed from: g  reason: collision with root package name */
    static Context f10654g;

    /* renamed from: h  reason: collision with root package name */
    static Location f10655h;

    /* renamed from: i  reason: collision with root package name */
    static String f10656i;

    class a {
        a() {
        }
    }

    interface b {
        void a(d dVar);

        f getType();
    }

    protected static class c extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        Handler f10657a = new Handler(getLooper());

        c() {
            super("OSH_LocationHandlerThread");
            start();
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        Double f10658a;

        /* renamed from: b  reason: collision with root package name */
        Double f10659b;

        /* renamed from: c  reason: collision with root package name */
        Float f10660c;

        /* renamed from: d  reason: collision with root package name */
        Integer f10661d;

        /* renamed from: e  reason: collision with root package name */
        Boolean f10662e;

        /* renamed from: f  reason: collision with root package name */
        Long f10663f;

        d() {
        }

        public String toString() {
            return "LocationPoint{lat=" + this.f10658a + ", log=" + this.f10659b + ", accuracy=" + this.f10660c + ", type=" + this.f10661d + ", bg=" + this.f10662e + ", timeStamp=" + this.f10663f + '}';
        }
    }

    static abstract class e implements b {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void b(o3.z zVar) {
        }
    }

    enum f {
        STARTUP,
        PROMPT_LOCATION,
        SYNC_SERVICE
    }

    private static void a(b bVar) {
        if (bVar instanceof e) {
            List list = f10648a;
            synchronized (list) {
                list.add((e) bVar);
            }
        }
    }

    private static void b(Context context, boolean z10, boolean z11) {
        y a10 = f4.f10638a.a(context, context.getPackageName(), 4096);
        if (!a10.b() || a10.a() == null) {
            n(z10, o3.z.ERROR);
            return;
        }
        if (Arrays.asList(a10.a().requestedPermissions).contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            f10656i = "android.permission.ACCESS_BACKGROUND_LOCATION";
        }
        if (f10656i == null || !z10) {
            n(z10, o3.z.PERMISSION_GRANTED);
            p();
            return;
        }
        i0.f10676a.d(z11, f10656i);
    }

    private static void c(d dVar) {
        Thread thread;
        HashMap hashMap = new HashMap();
        synchronized (h0.class) {
            hashMap.putAll(f10649b);
            f10649b.clear();
            thread = f10653f;
        }
        for (f fVar : hashMap.keySet()) {
            ((b) hashMap.get(fVar)).a(dVar);
        }
        if (thread != null && !Thread.currentThread().equals(thread)) {
            thread.interrupt();
        }
        if (thread == f10653f) {
            synchronized (h0.class) {
                try {
                    if (thread == f10653f) {
                        f10653f = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        o(o3.w0().b());
    }

    protected static void d(Location location) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "LocationController fireCompleteForLocation with location: " + location);
        d dVar = new d();
        dVar.f10660c = Float.valueOf(location.getAccuracy());
        dVar.f10662e = Boolean.valueOf(o3.O0() ^ true);
        dVar.f10661d = Integer.valueOf(f10650c ^ true ? 1 : 0);
        dVar.f10663f = Long.valueOf(location.getTime());
        if (f10650c) {
            BigDecimal bigDecimal = new BigDecimal(location.getLatitude());
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            dVar.f10658a = Double.valueOf(bigDecimal.setScale(7, roundingMode).doubleValue());
            dVar.f10659b = Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, roundingMode).doubleValue());
        } else {
            dVar.f10658a = Double.valueOf(location.getLatitude());
            dVar.f10659b = Double.valueOf(location.getLongitude());
        }
        c(dVar);
        m(f10654g);
    }

    static void e() {
        synchronized (f10651d) {
            try {
                if (j()) {
                    t.e();
                } else if (k()) {
                    b0.e();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        c((d) null);
    }

    private static long f() {
        return z3.d(z3.f11153a, "OS_LAST_LOCATION_TIME", -600000);
    }

    static void g(Context context, boolean z10, boolean z11, b bVar) {
        int i10;
        a(bVar);
        f10654g = context;
        f10649b.put(bVar.getType(), bVar);
        if (!o3.Q0()) {
            n(z10, o3.z.ERROR);
            e();
            return;
        }
        int a10 = h.a(context, "android.permission.ACCESS_FINE_LOCATION");
        int i11 = -1;
        if (a10 == -1) {
            i10 = h.a(context, "android.permission.ACCESS_COARSE_LOCATION");
            f10650c = true;
        } else {
            i10 = -1;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            i11 = h.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (a10 != 0) {
            y a11 = f4.f10638a.a(context, context.getPackageName(), 4096);
            if (!a11.b() || a11.a() == null) {
                n(z10, o3.z.ERROR);
                return;
            }
            List asList = Arrays.asList(a11.a().requestedPermissions);
            o3.z zVar = o3.z.PERMISSION_DENIED;
            if (asList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                f10656i = "android.permission.ACCESS_FINE_LOCATION";
            } else if (!asList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                o3.d1(o3.v.INFO, "Location permissions not added on AndroidManifest file");
                zVar = o3.z.LOCATION_PERMISSIONS_MISSING_MANIFEST;
            } else if (i10 != 0) {
                f10656i = "android.permission.ACCESS_COARSE_LOCATION";
            } else if (i12 >= 29 && asList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                f10656i = "android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            if (f10656i != null && z10) {
                i0.f10676a.d(z11, f10656i);
            } else if (i10 == 0) {
                n(z10, o3.z.PERMISSION_GRANTED);
                p();
            } else {
                n(z10, zVar);
                e();
            }
        } else if (i12 < 29 || i11 == 0) {
            n(z10, o3.z.PERMISSION_GRANTED);
            p();
        } else {
            b(context, z10, z11);
        }
    }

    static c h() {
        if (f10652e == null) {
            synchronized (f10651d) {
                try {
                    if (f10652e == null) {
                        f10652e = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10652e;
    }

    private static boolean i(Context context) {
        if (h.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || h.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    static boolean j() {
        if (!OSUtils.B() || !OSUtils.s()) {
            return false;
        }
        return true;
    }

    static boolean k() {
        if (!OSUtils.G() || !OSUtils.v()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void l() {
        /*
            java.lang.Object r0 = f10651d
            monitor-enter(r0)
            boolean r1 = j()     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x0010
            com.onesignal.t.l()     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x001b
        L_0x0010:
            boolean r1 = k()     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x0019
            com.onesignal.b0.l()     // Catch:{ all -> 0x000e }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.h0.l():void");
    }

    static boolean m(Context context) {
        long j10;
        if (!i(context)) {
            o3.d1(o3.v.DEBUG, "LocationController scheduleUpdate not possible, location permission not enabled");
            return false;
        } else if (!o3.Q0()) {
            o3.d1(o3.v.DEBUG, "LocationController scheduleUpdate not possible, location shared not enabled");
            return false;
        } else {
            long b10 = o3.w0().b() - f();
            if (o3.O0()) {
                j10 = 300;
            } else {
                j10 = 600;
            }
            long j11 = j10 * 1000;
            o3.v vVar = o3.v.DEBUG;
            o3.d1(vVar, "LocationController scheduleUpdate lastTime: " + b10 + " minTime: " + j11);
            b3.q().r(context, j11 - b10);
            return true;
        }
    }

    static void n(boolean z10, o3.z zVar) {
        if (!z10) {
            o3.d1(o3.v.DEBUG, "LocationController sendAndClearPromptHandlers from non prompt flow");
            return;
        }
        List<e> list = f10648a;
        synchronized (list) {
            try {
                o3.d1(o3.v.DEBUG, "LocationController calling prompt handlers");
                for (e b10 : list) {
                    b10.b(zVar);
                }
                f10648a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void o(long j10) {
        z3.l(z3.f11153a, "OS_LAST_LOCATION_TIME", j10);
    }

    static void p() {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "LocationController startGetLocation with lastLocation: " + f10655h);
        try {
            if (j()) {
                t.p();
            } else if (k()) {
                b0.p();
            } else {
                o3.a(o3.v.WARN, "LocationController startGetLocation not possible, no location dependency found");
                e();
            }
        } catch (Throwable th) {
            o3.b(o3.v.WARN, "Location permission exists but there was an error initializing: ", th);
            e();
        }
    }
}
