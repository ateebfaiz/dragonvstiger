package p;

import android.content.Context;
import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import d.k;
import java.io.File;
import java.util.Locale;
import w.d;

public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f23043f = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final k f23044a;

    /* renamed from: b  reason: collision with root package name */
    public final c f23045b;

    /* renamed from: c  reason: collision with root package name */
    public int f23046c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final String f23047d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23048e;

    public b(k kVar, c cVar, String str) {
        this.f23044a = kVar;
        this.f23045b = cVar;
        this.f23047d = str;
        this.f23048e = String.format(Locale.US, "%s/debug.log", new Object[]{str});
    }

    public static void c(Context context) {
        String OooO00o = OooO00o.OooO00o(context, true);
        if (!TextUtils.isEmpty(OooO00o)) {
            OooO00o.OooO00o(OooO00o, "debug.log_");
        }
    }

    public final String a(int i10) {
        if (i10 == 0) {
            return this.f23044a.r().o();
        }
        return String.valueOf(System.currentTimeMillis());
    }

    public final void b() {
        OooO00o.OooO00o(this.f23047d, "access.log");
        i.c.f(new File(this.f23048e));
        c(this.f23044a.OooO00o());
    }

    public final boolean d() {
        if (this.f23044a.o().c()) {
            this.f23046c = 2;
            return true;
        } else if (this.f23044a.q()) {
            this.f23046c = 3;
            return true;
        } else if (this.f23044a.o().N) {
            this.f23046c = 1;
            return true;
        } else if (!this.f23044a.r().m()) {
            return false;
        } else {
            this.f23046c = 0;
            return true;
        }
    }

    public final void e() {
        if (d()) {
            new a(this.f23044a, this.f23045b, a(this.f23046c), this.f23046c).b();
        }
    }
}
