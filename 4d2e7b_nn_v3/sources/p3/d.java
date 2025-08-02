package p3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import e5.e;
import g5.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import k5.b;
import m4.g;
import t3.a;
import w3.p;
import x4.x;
import y2.f;
import y2.j;
import y2.l;
import y2.o;

public class d extends a {
    private static final Class M = d.class;
    private final d5.a A;
    private final f B;
    private final x C;
    private r2.d D;
    private o E;
    private boolean F;
    private f G;
    private q3.a H;
    private Set I;
    private b J;
    private b[] K;
    private b L;

    /* renamed from: z  reason: collision with root package name */
    private final Resources f23115z;

    public d(Resources resources, s3.a aVar, d5.a aVar2, Executor executor, x xVar, f fVar) {
        super(aVar, executor, (String) null, (Object) null);
        this.f23115z = resources;
        this.A = new a(resources, aVar2);
        this.B = fVar;
        this.C = xVar;
    }

    private void o0(o oVar) {
        this.E = oVar;
        s0((e) null);
    }

    private Drawable r0(f fVar, e eVar) {
        Drawable b10;
        if (fVar == null) {
            return null;
        }
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            d5.a aVar = (d5.a) it.next();
            if (aVar.a(eVar) && (b10 = aVar.b(eVar)) != null) {
                return b10;
            }
        }
        return null;
    }

    private void s0(e eVar) {
        if (this.F) {
            if (q() == null) {
                u3.a aVar = new u3.a();
                i(new v3.a(aVar));
                Z(aVar);
            }
            if (q() instanceof u3.a) {
                z0(eVar, (u3.a) q());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void O(Drawable drawable) {
        if (drawable instanceof n3.a) {
            ((n3.a) drawable).a();
        }
    }

    public void e(z3.b bVar) {
        super.e(bVar);
        s0((e) null);
    }

    public synchronized void h0(g5.e eVar) {
        try {
            if (this.I == null) {
                this.I = new HashSet();
            }
            this.I.add(eVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i0 */
    public Drawable k(c3.a aVar) {
        try {
            if (l5.b.d()) {
                l5.b.a("PipelineDraweeController#createDrawable");
            }
            l.i(c3.a.y(aVar));
            e eVar = (e) aVar.p();
            s0(eVar);
            Drawable r02 = r0(this.G, eVar);
            if (r02 != null) {
                if (l5.b.d()) {
                    l5.b.b();
                }
                return r02;
            }
            Drawable r03 = r0(this.B, eVar);
            if (r03 != null) {
                if (l5.b.d()) {
                    l5.b.b();
                }
                return r03;
            }
            Drawable b10 = this.A.b(eVar);
            if (b10 != null) {
                if (l5.b.d()) {
                    l5.b.b();
                }
                return b10;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + eVar);
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j0 */
    public c3.a m() {
        if (l5.b.d()) {
            l5.b.a("PipelineDraweeController#getCachedImage");
        }
        try {
            x xVar = this.C;
            if (xVar != null) {
                r2.d dVar = this.D;
                if (dVar != null) {
                    c3.a aVar = xVar.get(dVar);
                    if (aVar == null || ((e) aVar.p()).s().a()) {
                        if (l5.b.d()) {
                            l5.b.b();
                        }
                        return aVar;
                    }
                    aVar.close();
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                    return null;
                }
            }
            return null;
        } finally {
            if (l5.b.d()) {
                l5.b.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String k0() {
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        return n10.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l0 */
    public int w(c3.a aVar) {
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m0 */
    public e5.l x(c3.a aVar) {
        l.i(c3.a.y(aVar));
        return ((e) aVar.p()).u();
    }

    public synchronized g5.e n0() {
        Set set = this.I;
        if (set == null) {
            return null;
        }
        return new c(set);
    }

    public void p0(o oVar, String str, r2.d dVar, Object obj, f fVar) {
        if (l5.b.d()) {
            l5.b.a("PipelineDraweeController#initialize");
        }
        super.C(str, obj);
        o0(oVar);
        this.D = dVar;
        x0(fVar);
        s0((e) null);
        if (l5.b.d()) {
            l5.b.b();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void q0(g gVar, t3.b bVar, o oVar) {
        try {
            q3.a aVar = this.H;
            if (aVar != null) {
                aVar.f();
            }
            if (gVar != null) {
                if (this.H == null) {
                    this.H = new q3.a(AwakeTimeSinceBootClock.get(), this, oVar);
                }
                this.H.c(gVar);
                this.H.g(true);
            }
            this.J = (b) bVar.n();
            this.K = (b[]) bVar.m();
            this.L = (b) bVar.o();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public i3.c r() {
        if (l5.b.d()) {
            l5.b.a("PipelineDraweeController#getDataSource");
        }
        if (z2.a.u(2)) {
            z2.a.w(M, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        i3.c cVar = (i3.c) this.E.get();
        if (l5.b.d()) {
            l5.b.b();
        }
        return cVar;
    }

    /* renamed from: t0 */
    public Map J(e5.l lVar) {
        if (lVar == null) {
            return null;
        }
        return lVar.getExtras();
    }

    public String toString() {
        return j.c(this).b("super", super.toString()).b("dataSourceSupplier", this.E).toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u0 */
    public void L(String str, c3.a aVar) {
        super.L(str, aVar);
        synchronized (this) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v0 */
    public void Q(c3.a aVar) {
        c3.a.m(aVar);
    }

    public synchronized void w0(g5.e eVar) {
        Set set = this.I;
        if (set != null) {
            set.remove(eVar);
        }
    }

    public void x0(f fVar) {
        this.G = fVar;
    }

    /* access modifiers changed from: protected */
    public Uri y() {
        return m4.j.a(this.J, this.L, this.K, b.f22286z);
    }

    public void y0(boolean z10) {
        this.F = z10;
    }

    /* access modifiers changed from: protected */
    public void z0(e eVar, u3.a aVar) {
        w3.o a10;
        aVar.j(u());
        z3.b b10 = b();
        p.b bVar = null;
        if (!(b10 == null || (a10 = p.a(b10.f())) == null)) {
            bVar = a10.z();
        }
        aVar.m(bVar);
        String k02 = k0();
        if (k02 != null) {
            aVar.b("cc", k02);
        }
        if (eVar != null) {
            aVar.k(eVar.getWidth(), eVar.getHeight());
            aVar.l(eVar.g());
            return;
        }
        aVar.i();
    }
}
