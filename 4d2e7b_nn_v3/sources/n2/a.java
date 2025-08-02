package n2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.facebook.o;
import e2.c;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.m;
import q5.p0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f22811a = r0.h("fb_mobile_purchase", "StartTrial", "Subscribe");

    /* renamed from: b  reason: collision with root package name */
    public static final a f22812b = new a();

    /* renamed from: n2.a$a  reason: collision with other inner class name */
    static final class C0312a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f22814b;

        C0312a(String str, c cVar) {
            this.f22813a = str;
            this.f22814b = cVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    c.c(this.f22813a, r.e(this.f22814b));
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f22815a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22816b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22817c;

        b(Context context, String str, String str2) {
            this.f22815a = context;
            this.f22816b = str;
            this.f22817c = str2;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    SharedPreferences sharedPreferences = this.f22815a.getSharedPreferences(this.f22816b, 0);
                    String str = this.f22817c + "pingForOnDevice";
                    if (sharedPreferences.getLong(str, 0) == 0) {
                        c.e(this.f22817c);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(str, System.currentTimeMillis());
                        edit.apply();
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private a() {
    }

    private final boolean a(c cVar) {
        boolean z10;
        if (v5.a.d(this)) {
            return false;
        }
        try {
            if (!cVar.i() || !f22811a.contains(cVar.f())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if ((!cVar.i()) || z10) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    public static final boolean b() {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            if (o.u(o.f()) || p0.V() || !c.b()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final void c(String str, c cVar) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(str, "applicationId");
                m.f(cVar, NotificationCompat.CATEGORY_EVENT);
                if (f22812b.a(cVar)) {
                    o.p().execute(new C0312a(str, cVar));
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void d(String str, String str2) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                Context f10 = o.f();
                if (f10 != null && str != null && str2 != null) {
                    o.p().execute(new b(f10, str2, str));
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }
}
