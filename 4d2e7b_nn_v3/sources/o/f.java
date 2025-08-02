package o;

import a.b;
import android.content.Context;
import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import i.p;
import i.u;
import java.util.ArrayList;
import java.util.List;
import k.a;
import w.d;

public class f extends g {

    /* renamed from: h  reason: collision with root package name */
    public static final String f22866h = d.f("");

    /* renamed from: c  reason: collision with root package name */
    public final c f22867c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f22868d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final b f22869e;

    /* renamed from: f  reason: collision with root package name */
    public final String f22870f;

    /* renamed from: g  reason: collision with root package name */
    public final d.f f22871g;

    public f(Context context, boolean z10, d.f fVar, boolean z11, c cVar) {
        this.f22867c = new c(context);
        this.f22869e = new b(cVar);
        this.f22871g = fVar;
        if (z10) {
            u.b(new d(this, context, z11));
        }
        this.f22870f = OooO00o.OooO00o(context);
    }

    public void b(Throwable th) {
        c(th, (String) null);
    }

    public void c(Throwable th, String str) {
        if (th != null) {
            try {
                a d10 = a.d(th, true, str, this.f22870f);
                String str2 = d10.f22838d.f22876b;
                if (!TextUtils.isEmpty(str2)) {
                    String b10 = p.b(str2);
                    if (!this.f22868d.contains(b10)) {
                        this.f22868d.add(b10);
                        g(d10, false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void e() {
        List<a> c10 = this.f22867c.c();
        c10.size();
        int i10 = 0;
        for (a aVar : c10) {
            int i11 = i10 + 1;
            if (i10 < 5) {
                String str = aVar.f22835a;
                g(aVar, true);
            } else {
                String str2 = aVar.f22835a;
                this.f22867c.a(aVar);
            }
            i10 = i11;
        }
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f22871g.t();
            a.f().k();
        } else if (a.h(str)) {
            this.f22871g.t();
            a.f().k();
            try {
                this.f22867c.b(a.c(str, this.f22870f));
            } catch (Throwable unused) {
            }
        }
    }

    public final void g(a aVar, boolean z10) {
        if (!aVar.e()) {
            this.f22867c.a(aVar);
        } else {
            this.f22869e.d(aVar, this.f22867c, z10);
        }
    }

    public final void h(Context context, boolean z10) {
        b.a(context, new e(this), z10);
    }

    public final void i(Throwable th) {
        if (th != null) {
            try {
                this.f22867c.b(a.d(th, false, "", this.f22870f));
            } catch (Throwable unused) {
            }
        }
    }
}
