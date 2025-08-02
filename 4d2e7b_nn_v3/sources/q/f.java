package q;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import d.c;
import java.io.File;
import java.util.List;
import java.util.Locale;
import q.c;
import w.d;

public class f {

    /* renamed from: g  reason: collision with root package name */
    public static final String f23148g = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public h f23149a;

    /* renamed from: b  reason: collision with root package name */
    public g f23150b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23151c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f23152d;

    /* renamed from: e  reason: collision with root package name */
    public String f23153e;

    /* renamed from: f  reason: collision with root package name */
    public String f23154f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f23155a = new f();
    }

    public static f f() {
        return a.f23155a;
    }

    public d a(int i10, String str) {
        return new b(b.b(i10), this.f23152d, MahProxy.getVersion(), str);
    }

    public d b(Throwable th) {
        return j.c(th, this.f23152d);
    }

    public void c(Context context, c cVar) {
        File c10;
        if (!this.f23151c && (c10 = new d.d(cVar.j(), NotificationCompat.CATEGORY_EVENT).c()) != null) {
            this.f23153e = c10.getAbsolutePath();
            this.f23154f = String.format(Locale.US, "event_%d.log", new Object[]{Long.valueOf(System.currentTimeMillis())});
            File file = new File(c10, this.f23154f);
            file.getAbsolutePath();
            this.f23149a = new h(file);
            this.f23150b = new g(cVar);
            this.f23152d = OooO00o.OooO00o(context);
            this.f23151c = true;
        }
    }

    public final void d(File[] fileArr) {
        int length = fileArr.length;
        int i10 = 0;
        for (File file : fileArr) {
            if (i10 < 5) {
                file.getName();
                this.f23150b.b(file);
                i10++;
            } else {
                file.delete();
                file.getName();
            }
        }
    }

    public final /* synthetic */ boolean e(File file) {
        return !file.getName().equals(this.f23154f);
    }

    public void g(int i10, String str) {
        if (l()) {
            this.f23149a.b(a(i10, str));
        }
    }

    public void h(Throwable th) {
        if (l()) {
            th.getMessage();
            this.f23149a.b(b(th));
        }
    }

    public void i(c.a aVar) {
        if (l() && aVar != null) {
            aVar.a();
            this.f23149a.b(c.c(this.f23152d, aVar));
        }
    }

    public void j(boolean z10, int i10, List list) {
        if (l()) {
            this.f23149a.b(i.c(this.f23152d, z10, i10, list));
        }
    }

    public final File[] k() {
        return new File(this.f23153e).listFiles(new e(this));
    }

    public boolean l() {
        if (!this.f23151c) {
            return false;
        }
        return true;
    }

    public void m() {
        File[] k10;
        if (l() && (k10 = k()) != null && k10.length != 0) {
            i.c.e(k10);
            d(k10);
        }
    }
}
