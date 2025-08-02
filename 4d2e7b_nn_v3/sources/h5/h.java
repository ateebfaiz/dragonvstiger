package h5;

import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f21957a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f21958b;

    /* renamed from: c  reason: collision with root package name */
    private static int f21959c = 384;

    /* renamed from: d  reason: collision with root package name */
    private static volatile g f21960d;

    static {
        h hVar = new h();
        f21957a = hVar;
        f21958b = hVar.b();
    }

    private h() {
    }

    public static final g a() {
        if (f21960d == null) {
            synchronized (h.class) {
                try {
                    if (f21960d == null) {
                        f21960d = new g(f21959c, f21958b);
                    }
                    Unit unit = Unit.f12577a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        g gVar = f21960d;
        m.c(gVar);
        return gVar;
    }

    private final int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) min) > 16777216) {
            return (min / 4) * 3;
        }
        return min / 2;
    }
}
