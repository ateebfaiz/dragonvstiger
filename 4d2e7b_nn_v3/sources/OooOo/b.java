package OooOo;

import OooOo.a;
import android.content.Context;
import com.mah.sdk.OooO00o;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import s.e;
import s.h;
import s.i;
import s.j;
import w.d;

public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f13537f = d.f("");

    /* renamed from: g  reason: collision with root package name */
    public static final c f13538g = new c((a) null);

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f13539a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f13540b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f13541c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public a.b f13542d;

    /* renamed from: e  reason: collision with root package name */
    public C0166b f13543e;

    /* renamed from: OooOo.b$b  reason: collision with other inner class name */
    public interface C0166b {
        void a(e eVar, boolean z10);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public j.b f13544a;

        public interface a {
            void a(boolean z10);
        }

        public c(a aVar) {
        }

        public void a() {
            j.b bVar = this.f13544a;
            if (bVar != null) {
                bVar.a();
                this.f13544a = null;
            }
        }

        public void b(a aVar) {
            String unused = b.f13537f;
            j.b c10 = j.a.a().c(new j(this, aVar), 1);
            this.f13544a = c10;
            if (c10 == null && aVar != null) {
                aVar.a(true);
            }
        }

        public final boolean c(String str) {
            try {
                InetAddress.getByName(str);
                return false;
            } catch (UnknownHostException unused) {
                return true;
            } catch (Throwable unused2) {
                String unused3 = b.f13537f;
                return false;
            }
        }

        public final /* synthetic */ void d(a aVar) {
            if (c("www.baidu.com") && c("www.qq.com") && c("www.163.com") && aVar != null) {
                aVar.a(true);
            }
        }
    }

    public b(Context context) {
        this.f13540b = context;
        this.f13543e = null;
        this.f13539a = new AtomicReference(new e(0));
        a.a(context);
    }

    public final /* synthetic */ void b(int i10) {
        e b10 = e.b(i10);
        b10.f();
        b10.a();
        d(b10);
    }

    public void c(C0166b bVar) {
        h hVar = new h(this);
        this.f13542d = hVar;
        a.g(hVar);
        a.p();
        this.f13541c.set(OooO00o.OooO0O0(this.f13540b, f().j()));
        ((e) this.f13539a.get()).a();
        this.f13541c.get();
        this.f13543e = bVar;
    }

    public final void d(e eVar) {
        if (eVar.f() == 1) {
            c cVar = f13538g;
            cVar.a();
            cVar.b(new i(this, eVar));
            return;
        }
        f13538g.a();
        g(eVar);
    }

    public final /* synthetic */ void e(e eVar, boolean z10) {
        if (z10) {
            g(eVar);
        }
    }

    public e f() {
        return (e) this.f13539a.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void g(s.e r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference r0 = r4.f13539a     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0023 }
            s.e r0 = (s.e) r0     // Catch:{ all -> 0x0023 }
            boolean r1 = r5.e(r0)     // Catch:{ all -> 0x0023 }
            r2 = 1
            if (r1 != 0) goto L_0x0025
            r0.a()     // Catch:{ all -> 0x0023 }
            r5.a()     // Catch:{ all -> 0x0023 }
            java.util.concurrent.atomic.AtomicReference r0 = r4.f13539a     // Catch:{ all -> 0x0023 }
            r0.set(r5)     // Catch:{ all -> 0x0023 }
            OooOo.b$b r0 = r4.f13543e     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x004b
            r0.a(r5, r2)     // Catch:{ all -> 0x0023 }
            goto L_0x004b
        L_0x0023:
            r5 = move-exception
            goto L_0x004d
        L_0x0025:
            java.util.concurrent.atomic.AtomicInteger r0 = r4.f13541c     // Catch:{ all -> 0x0023 }
            int r0 = r0.get()     // Catch:{ all -> 0x0023 }
            android.content.Context r1 = r4.f13540b     // Catch:{ all -> 0x0023 }
            boolean r3 = r5.j()     // Catch:{ all -> 0x0023 }
            int r1 = com.mah.sdk.OooO00o.OooO0O0((android.content.Context) r1, (boolean) r3)     // Catch:{ all -> 0x0023 }
            if (r0 != r1) goto L_0x003e
            if (r0 == r2) goto L_0x003c
            r2 = 2
            if (r0 != r2) goto L_0x003e
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            java.util.concurrent.atomic.AtomicInteger r0 = r4.f13541c     // Catch:{ all -> 0x0023 }
            r0.set(r1)     // Catch:{ all -> 0x0023 }
            OooOo.b$b r0 = r4.f13543e     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x004b
            r1 = 0
            r0.a(r5, r1)     // Catch:{ all -> 0x0023 }
        L_0x004b:
            monitor-exit(r4)
            return
        L_0x004d:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: OooOo.b.g(s.e):void");
    }

    public void h() {
        a.n(this.f13542d);
    }
}
