package r;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.mah.sdk.OooO00o;
import d.g;
import g.l;
import i.v;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import r.d;
import s.e;
import w.d;

public class f {

    /* renamed from: h  reason: collision with root package name */
    public static final String f23569h = d.f("");

    /* renamed from: i  reason: collision with root package name */
    public static int f23570i = 1000;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f23571a = new l("MahLogReport-Dispatcher", new c((a) null)).f21566b;

    /* renamed from: b  reason: collision with root package name */
    public b f23572b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23573c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public i f23574d;

    /* renamed from: e  reason: collision with root package name */
    public d.c f23575e;

    /* renamed from: f  reason: collision with root package name */
    public Context f23576f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f23577g = new AtomicBoolean(false);

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f23578a = new f();
    }

    public class c implements Handler.Callback {
        public c(a aVar) {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                String str = f.f23569h;
                f.this.p();
            } else if (i10 == 1) {
                f.this.g((d) message.obj);
            }
            return true;
        }
    }

    public static int a(boolean z10, int i10) {
        if (z10) {
            return 1000;
        }
        if (i10 == 1000) {
            i10 = 0;
        }
        int i11 = i10 + 10000;
        if (i11 <= 60000) {
            return i11;
        }
        return i10;
    }

    public static File b(g gVar, String str) {
        return new d.d(gVar, "report" + File.separator + str).a();
    }

    public static f c() {
        return b.f23578a;
    }

    public final void d(int i10, File file) {
        if (i10 == -1) {
            f23570i = a(false, f23570i);
        } else if (i10 != 200) {
            i.c.o(file);
        } else {
            file.getAbsolutePath();
            f23570i = a(true, f23570i);
            i.c.o(file);
        }
    }

    public void e(Context context, d.c cVar) {
        if (this.f23573c.compareAndSet(false, true)) {
            this.f23576f = v.b(context);
            this.f23575e = cVar;
            this.f23574d = new i(cVar, context);
            l();
        }
    }

    public final void f(File file) {
        file.getAbsolutePath();
        Object a10 = i.c.a(i.c.q(file));
        if (a10 == null) {
            i.c.o(file);
            q();
            return;
        }
        d(this.f23574d.a((h) a10), file);
        q();
    }

    public final void g(d dVar) {
        boolean z10;
        h b10 = dVar.b();
        if (b10 != null) {
            z10 = this.f23572b.c(b10);
        } else {
            z10 = false;
        }
        h(dVar, z10);
        j(z10);
    }

    public final void h(d dVar, boolean z10) {
        d.a a10 = dVar.a();
        if (a10 != null) {
            if (z10) {
                a10.OooO00o();
            } else {
                a10.e();
            }
        }
    }

    public final void j(boolean z10) {
        if (z10 && !this.f23571a.hasMessages(0)) {
            q();
        }
    }

    public final boolean k(g gVar) {
        File b10 = b(gVar, "log_cache_low");
        File b11 = b(gVar, "log_cache_normal");
        File b12 = b(gVar, "log_cache_high");
        if (b10 == null || b11 == null || b12 == null) {
            return false;
        }
        this.f23572b = new b(b10, b11, b12);
        return true;
    }

    public final void l() {
        this.f23571a.postAtFrontOfQueue(new e(this));
    }

    public void m(d dVar) {
        if (n() && dVar != null) {
            Message obtainMessage = this.f23571a.obtainMessage(1);
            obtainMessage.obj = dVar;
            this.f23571a.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    public final boolean n() {
        if (!this.f23573c.get() || !this.f23577g.get()) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void o() {
        if (k(this.f23575e.j())) {
            this.f23577g.set(true);
            q();
        }
    }

    public final void p() {
        if (!OooO00o.OooO0O0(this.f23575e.k().h(d.b.ADDRESS_TYPE_PROXY_HANDSHAKE))) {
            f23570i = a(false, f23570i);
            q();
        } else if (!e.c(this.f23576f).h()) {
            f23570i = a(false, f23570i);
            q();
        } else {
            File a10 = this.f23572b.a();
            if (a10 != null) {
                f(a10);
            }
        }
    }

    public final void q() {
        this.f23571a.sendEmptyMessageDelayed(0, (long) f23570i);
    }
}
