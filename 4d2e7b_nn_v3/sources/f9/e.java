package f9;

import android.os.Handler;
import android.os.Looper;
import com.hcaptcha.sdk.h;
import com.hcaptcha.sdk.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12070a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12071b;

    /* renamed from: c  reason: collision with root package name */
    private Object f12072c;

    /* renamed from: d  reason: collision with root package name */
    private i f12073d;

    /* renamed from: e  reason: collision with root package name */
    private final List f12074e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List f12075f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final List f12076g = new ArrayList();
    /* access modifiers changed from: protected */

    /* renamed from: h  reason: collision with root package name */
    public final Handler f12077h = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            for (a f10 : e.this.f12075f) {
                f10.f(new i(h.TOKEN_TIMEOUT));
            }
        }
    }

    public e() {
        i();
    }

    private void i() {
        this.f12070a = false;
        this.f12071b = false;
        this.f12072c = null;
        this.f12073d = null;
    }

    private void m() {
        boolean z10 = false;
        if (g() != null) {
            for (d onSuccess : this.f12074e) {
                onSuccess.onSuccess(g());
                z10 = true;
            }
        }
        if (f() != null) {
            for (a f10 : this.f12075f) {
                f10.f(f());
                z10 = true;
            }
        }
        if (z10) {
            i();
        }
    }

    public e b(a aVar) {
        this.f12075f.add(aVar);
        m();
        return this;
    }

    public e c(c cVar) {
        this.f12076g.add(cVar);
        m();
        return this;
    }

    public e d(d dVar) {
        this.f12074e.add(dVar);
        m();
        return this;
    }

    public void e() {
        for (c a10 : this.f12076g) {
            a10.a();
        }
    }

    public i f() {
        return this.f12073d;
    }

    public Object g() {
        return this.f12072c;
    }

    public e h() {
        this.f12074e.clear();
        this.f12075f.clear();
        this.f12076g.clear();
        return this;
    }

    public void j(long j10) {
        this.f12077h.postDelayed(new a(), TimeUnit.SECONDS.toMillis(j10));
    }

    public void k(i iVar) {
        this.f12073d = iVar;
        this.f12071b = false;
        this.f12070a = true;
        m();
    }

    public void l(Object obj) {
        this.f12072c = obj;
        this.f12071b = true;
        this.f12070a = true;
        m();
    }
}
