package v5;

import android.os.Handler;
import android.os.Looper;
import com.facebook.o;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.m;
import s5.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f24408a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private static boolean f24409b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f24410c = new a();

    /* renamed from: v5.a$a  reason: collision with other inner class name */
    public static final class C0348a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f24411a;

        C0348a(Throwable th) {
            this.f24411a = th;
        }

        public void run() {
            throw new RuntimeException(this.f24411a);
        }
    }

    private a() {
    }

    public static final void a() {
        f24409b = true;
    }

    public static final void b(Throwable th, Object obj) {
        m.f(obj, "o");
        if (f24409b) {
            f24408a.add(obj);
            if (o.k()) {
                s5.a.b(th);
                b.a.b(th, b.c.CrashShield).g();
            }
            e(th);
        }
    }

    public static final boolean c() {
        return false;
    }

    public static final boolean d(Object obj) {
        m.f(obj, "o");
        return f24408a.contains(obj);
    }

    public static final void e(Throwable th) {
        if (c()) {
            new Handler(Looper.getMainLooper()).post(new C0348a(th));
        }
    }
}
