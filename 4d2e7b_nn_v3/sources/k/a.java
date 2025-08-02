package k;

import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import d.k;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import l.a;
import l.e;
import m.b;
import o.g;
import w.d;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f22225g = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f22226a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f22227b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public k f22228c;

    /* renamed from: d  reason: collision with root package name */
    public c f22229d;

    /* renamed from: e  reason: collision with root package name */
    public b f22230e;

    /* renamed from: f  reason: collision with root package name */
    public e f22231f;

    /* renamed from: k.a$a  reason: collision with other inner class name */
    public static class C0295a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22232a = new a();
    }

    public static a f() {
        return C0295a.f22232a;
    }

    public void a() {
        if (this.f22227b.get()) {
            String d10 = d();
            l.a a10 = l.a.a();
            if (a10.f(d10)) {
                a10.g();
                a10.b(d10);
                a10.d();
            }
        }
    }

    public void b(k kVar, c cVar) {
        if (this.f22227b.compareAndSet(false, true)) {
            this.f22228c = kVar;
            this.f22229d = cVar;
            c(kVar.o().c());
            i();
            g();
            g.a().e();
            h();
        }
    }

    public final boolean c(boolean z10) {
        String OooO00o = OooO00o.OooO00o(this.f22228c.OooO00o(), z10);
        if (TextUtils.isEmpty(OooO00o)) {
            return false;
        }
        this.f22226a.set(OooO00o);
        this.f22226a.get();
        return true;
    }

    public String d() {
        if (!this.f22227b.get()) {
            return "";
        }
        return String.format(Locale.US, "%s/access.log", new Object[]{this.f22226a.get()});
    }

    public String e() {
        if (!this.f22227b.get()) {
            return "";
        }
        return String.format(Locale.US, "%s/debug.log", new Object[]{this.f22226a.get()});
    }

    public final void g() {
        this.f22230e = new b(this.f22228c, this.f22229d);
    }

    public final void h() {
        n.b.k().d(this.f22228c.o().P, this.f22228c.OooO00o(), this.f22229d);
    }

    public final void i() {
        if (!TextUtils.isEmpty((CharSequence) this.f22226a.get())) {
            p.b bVar = new p.b(this.f22228c, this.f22229d, (String) this.f22226a.get());
            bVar.e();
            bVar.b();
        }
    }

    public void j() {
        if (this.f22227b.get()) {
            l.a.a().b(d());
            a.b.f22342a.d();
        }
    }

    public void k() {
        if (this.f22227b.get()) {
            n.b.k().o();
        }
    }

    public void l() {
        if (this.f22227b.get()) {
            this.f22230e.c();
        }
    }

    public final void m() {
        n.b.k().r(this.f22228c.o().P);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050 A[Catch:{ all -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f22227b
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            l.a r0 = l.a.a()     // Catch:{ all -> 0x0020 }
            d.k r1 = r6.f22228c     // Catch:{ all -> 0x0020 }
            h.g r1 = r1.o()     // Catch:{ all -> 0x0020 }
            h.e r1 = r1.E     // Catch:{ all -> 0x0020 }
            boolean r2 = h.c.g(r1)     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x0022
            l.e r1 = r6.f22231f     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x004d
            goto L_0x004e
        L_0x0020:
            r0 = move-exception
            goto L_0x0054
        L_0x0022:
            l.e r2 = r6.f22231f     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x0035
            l.e r2 = new l.e     // Catch:{ all -> 0x0020 }
            d.k r3 = r6.f22228c     // Catch:{ all -> 0x0020 }
            d.c r4 = r6.f22229d     // Catch:{ all -> 0x0020 }
            r2.<init>(r1, r3, r4)     // Catch:{ all -> 0x0020 }
            r6.f22231f = r2     // Catch:{ all -> 0x0020 }
            r0.c(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x004d
        L_0x0035:
            boolean r2 = r2.e(r1)     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x004d
            l.e r2 = r6.f22231f     // Catch:{ all -> 0x0020 }
            l.e r3 = new l.e     // Catch:{ all -> 0x0020 }
            d.k r4 = r6.f22228c     // Catch:{ all -> 0x0020 }
            d.c r5 = r6.f22229d     // Catch:{ all -> 0x0020 }
            r3.<init>(r1, r4, r5)     // Catch:{ all -> 0x0020 }
            r6.f22231f = r3     // Catch:{ all -> 0x0020 }
            r0.c(r3)     // Catch:{ all -> 0x0020 }
            r1 = r2
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            if (r1 == 0) goto L_0x005b
            r0.e(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x005b
        L_0x0054:
            o.g r1 = o.g.a()
            r1.b(r0)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.n():void");
    }

    public final void o() {
        if (this.f22228c.o().c()) {
            this.f22230e.f();
        }
    }

    public final void p() {
        String str = (String) this.f22226a.get();
        if (c(this.f22228c.o().c()) && !((String) this.f22226a.get()).equals(str)) {
            OooO00o.OooO00o((String) this.f22226a.get());
        }
    }

    public void q() {
        if (this.f22227b.get()) {
            p();
            o();
            m();
        }
    }
}
