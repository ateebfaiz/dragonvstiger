package j2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.j;
import q5.n;
import v5.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f22193a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static final f f22194b = new f();

    private f() {
    }

    public static final void a() {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                f22193a.set(true);
                b();
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    public static final void b() {
        Class<f> cls = f.class;
        if (!a.d(cls)) {
            try {
                if (!f22193a.get()) {
                    return;
                }
                if (!f22194b.c() || !n.g(n.b.IapLoggingLib2)) {
                    a.g();
                } else {
                    b.c(o.f());
                }
            } catch (Throwable th) {
                a.b(th, cls);
            }
        }
    }

    private final boolean c() {
        String string;
        if (a.d(this)) {
            return false;
        }
        try {
            Context f10 = o.f();
            ApplicationInfo applicationInfo = f10.getPackageManager().getApplicationInfo(f10.getPackageName(), 128);
            if (applicationInfo == null || (string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version")) == null || Integer.parseInt((String) j.v0(string, new String[]{com.alibaba.pdns.f.G}, false, 3, 2, (Object) null).get(0)) < 2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        } catch (Throwable th) {
            a.b(th, this);
        }
        return false;
    }
}
