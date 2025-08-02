package f2;

import android.app.Activity;
import com.facebook.o;
import kotlin.jvm.internal.m;
import q5.b;
import q5.p0;
import q5.r;
import q5.s;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21498a = a.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f21499b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f21500c = new a();

    /* renamed from: f2.a$a  reason: collision with other inner class name */
    static final class C0277a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C0277a f21501a = new C0277a();

        C0277a() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    if (!b.f23250h.h(o.f())) {
                        a aVar = a.f21500c;
                        a.b(aVar);
                        a.a(aVar, true);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private a() {
    }

    public static final /* synthetic */ void a(a aVar, boolean z10) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f21499b = z10;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void b(a aVar) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                aVar.e();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void c() {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                o.p().execute(C0277a.f21501a);
            } catch (Exception e10) {
                p0.e0(f21498a, e10);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void d(Activity activity) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(activity, "activity");
                try {
                    if (!f21499b) {
                        return;
                    }
                    if (!c.f21504e.c().isEmpty()) {
                        d.f21509f.e(activity);
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void e() {
        String i10;
        if (!v5.a.d(this)) {
            try {
                r o10 = s.o(o.g(), false);
                if (o10 != null && (i10 = o10.i()) != null) {
                    c.f21504e.d(i10);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
