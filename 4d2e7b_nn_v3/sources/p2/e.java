package p2;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import h2.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p2.f;

public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d  reason: collision with root package name */
    private static final Map f23092d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final a f23093e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f23094a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f23095b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f23096c;

    public static final class a {
        private a() {
        }

        public final void a(Activity activity) {
            m.f(activity, "activity");
            int hashCode = activity.hashCode();
            Map b10 = e.b();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = b10.get(valueOf);
            if (obj == null) {
                obj = new e(activity, (DefaultConstructorMarker) null);
                b10.put(valueOf, obj);
            }
            e.c((e) obj);
        }

        public final void b(Activity activity) {
            m.f(activity, "activity");
            int hashCode = activity.hashCode();
            e eVar = (e) e.b().get(Integer.valueOf(hashCode));
            if (eVar != null) {
                e.b().remove(Integer.valueOf(hashCode));
                e.d(eVar);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f23097a;

        b(e eVar) {
            this.f23097a = eVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    View e10 = l2.b.e((Activity) e.a(this.f23097a).get());
                    Activity activity = (Activity) e.a(this.f23097a).get();
                    if (e10 == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View view : c.a(e10)) {
                            if (!d.g(view)) {
                                String d10 = c.d(view);
                                if (d10.length() > 0 && d10.length() <= 300) {
                                    f.a aVar = f.f23099f;
                                    String localClassName = activity.getLocalClassName();
                                    m.e(localClassName, "activity.localClassName");
                                    aVar.c(view, e10, localClassName);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private e(Activity activity) {
        this.f23094a = new WeakReference(activity);
        this.f23095b = new Handler(Looper.getMainLooper());
        this.f23096c = new AtomicBoolean(false);
    }

    public static final /* synthetic */ WeakReference a(e eVar) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return eVar.f23094a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map b() {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23092d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void c(e eVar) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                eVar.f();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void d(e eVar) {
        Class<e> cls = e.class;
        if (!v5.a.d(cls)) {
            try {
                eVar.g();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void e() {
        if (!v5.a.d(this)) {
            try {
                b bVar = new b(this);
                Thread currentThread = Thread.currentThread();
                Looper mainLooper = Looper.getMainLooper();
                m.e(mainLooper, "Looper.getMainLooper()");
                if (currentThread == mainLooper.getThread()) {
                    bVar.run();
                } else {
                    this.f23095b.post(bVar);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void f() {
        View e10;
        if (!v5.a.d(this)) {
            try {
                if (!this.f23096c.getAndSet(true) && (e10 = l2.b.e((Activity) this.f23094a.get())) != null) {
                    ViewTreeObserver viewTreeObserver = e10.getViewTreeObserver();
                    m.e(viewTreeObserver, "observer");
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        e();
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void g() {
        View e10;
        if (!v5.a.d(this)) {
            try {
                if (this.f23096c.getAndSet(false) && (e10 = l2.b.e((Activity) this.f23094a.get())) != null) {
                    ViewTreeObserver viewTreeObserver = e10.getViewTreeObserver();
                    m.e(viewTreeObserver, "observer");
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onGlobalLayout() {
        if (!v5.a.d(this)) {
            try {
                e();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public /* synthetic */ e(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }
}
