package com.airbnb.lottie;

import android.content.Context;
import java.io.File;
import p0.b;
import p0.c;
import v0.f;
import v0.g;
import v0.h;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f17634a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f17635b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f17636c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f17637d = true;

    /* renamed from: e  reason: collision with root package name */
    private static a f17638e = a.AUTOMATIC;

    /* renamed from: f  reason: collision with root package name */
    private static f f17639f;

    /* renamed from: g  reason: collision with root package name */
    private static v0.e f17640g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile h f17641h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile g f17642i;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal f17643j;

    /* renamed from: k  reason: collision with root package name */
    private static b f17644k = new c();

    public static void b(String str) {
        if (f17635b) {
            g().a(str);
        }
    }

    public static float c(String str) {
        if (!f17635b) {
            return 0.0f;
        }
        return g().b(str);
    }

    public static a d() {
        return f17638e;
    }

    public static boolean e() {
        return f17637d;
    }

    public static b f() {
        return f17644k;
    }

    private static y0.h g() {
        y0.h hVar = (y0.h) f17643j.get();
        if (hVar != null) {
            return hVar;
        }
        y0.h hVar2 = new y0.h();
        f17643j.set(hVar2);
        return hVar2;
    }

    public static boolean h() {
        return f17635b;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ File i(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static g j(Context context) {
        if (!f17636c) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        g gVar = f17642i;
        if (gVar == null) {
            synchronized (g.class) {
                try {
                    gVar = f17642i;
                    if (gVar == null) {
                        v0.e eVar = f17640g;
                        if (eVar == null) {
                            eVar = new d(applicationContext);
                        }
                        gVar = new g(eVar);
                        f17642i = gVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return gVar;
    }

    public static h k(Context context) {
        h hVar = f17641h;
        if (hVar == null) {
            synchronized (h.class) {
                try {
                    hVar = f17641h;
                    if (hVar == null) {
                        g j10 = j(context);
                        f fVar = f17639f;
                        if (fVar == null) {
                            fVar = new v0.b();
                        }
                        hVar = new h(j10, fVar);
                        f17641h = hVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return hVar;
    }
}
