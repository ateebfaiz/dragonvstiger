package OooOo;

import OooOo.OooO0oO;
import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import w.d;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final String f13529e = d.f("");

    /* renamed from: f  reason: collision with root package name */
    public static a f13530f = null;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ boolean f13531g = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13532a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f13533b;

    /* renamed from: c  reason: collision with root package name */
    public OooO0oO f13534c;

    /* renamed from: d  reason: collision with root package name */
    public int f13535d = 0;

    /* renamed from: OooOo.a$a  reason: collision with other inner class name */
    public class C0165a implements OooO0oO.h {
        public C0165a() {
        }

        public void a(int i10) {
            a.h(a.this, i10);
        }

        public void c(int i10) {
            a.this.c(i10);
        }

        public void d(long j10) {
            a.this.l(j10);
        }

        public void e(long j10) {
            a.this.e(j10);
        }

        public void f(long j10, int i10) {
            a.this.f(j10, i10);
        }

        public void g(long[] jArr) {
            a.this.j(jArr);
        }
    }

    public interface b {
        void a(int i10);
    }

    public a(Context context) {
        this.f13532a = context.getApplicationContext();
        this.f13533b = new CopyOnWriteArrayList();
    }

    public static a a(Context context) {
        if (f13530f == null) {
            f13530f = new a(context);
        }
        return f13530f;
    }

    public static void g(b bVar) {
        o().f13533b.add(bVar);
    }

    public static void h(a aVar, int i10) {
        aVar.f13535d = i10;
        aVar.k(i10);
    }

    public static void n(b bVar) {
        o().f13533b.remove(bVar);
    }

    public static a o() {
        if (f13531g || f13530f != null) {
            return f13530f;
        }
        throw new AssertionError();
    }

    public static void p() {
        o().i(true, new c());
    }

    public final void b() {
        OooO0oO oooO0oO = this.f13534c;
        if (oooO0oO != null) {
            oooO0oO.l();
            this.f13534c = null;
        }
    }

    public void c(int i10) {
    }

    public final void d(int i10, long j10) {
        Iterator it = this.f13533b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(i10);
        }
    }

    public void e(long j10) {
    }

    public void f(long j10, int i10) {
    }

    public final void i(boolean z10, OooO0oO.i iVar) {
        if (!z10) {
            b();
        } else if (this.f13534c == null) {
            OooO0oO oooO0oO = new OooO0oO(this.f13532a, new C0165a(), iVar);
            this.f13534c = oooO0oO;
            OooO0oO.g n10 = oooO0oO.n();
            int b10 = n10.b();
            this.f13535d = b10;
            k(b10);
            c(n10.a());
        }
    }

    public void j(long[] jArr) {
    }

    public void k(int i10) {
        d(i10, m());
    }

    public void l(long j10) {
    }

    public long m() {
        OooO0oO oooO0oO = this.f13534c;
        if (oooO0oO == null) {
            return -1;
        }
        return oooO0oO.o();
    }
}
