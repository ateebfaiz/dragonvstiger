package l5;

import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22458a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a f22459b = new C0303b();

    /* renamed from: c  reason: collision with root package name */
    private static c f22460c;

    public interface a {
    }

    /* renamed from: l5.b$b  reason: collision with other inner class name */
    private static final class C0303b implements a {
    }

    public interface c {
        void a(String str);

        void b();

        boolean isTracing();
    }

    private b() {
    }

    public static final void a(String str) {
        m.f(str, "name");
        f22458a.c().a(str);
    }

    public static final void b() {
        f22458a.c().b();
    }

    private final c c() {
        a aVar;
        c cVar = f22460c;
        if (cVar != null) {
            return cVar;
        }
        synchronized (b.class) {
            aVar = new a();
            f22460c = aVar;
        }
        return aVar;
    }

    public static final boolean d() {
        return f22458a.c().isTracing();
    }
}
