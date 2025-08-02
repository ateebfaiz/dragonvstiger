package q3;

import android.graphics.Rect;
import f3.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import m4.l;
import p3.d;
import r3.b;
import y2.o;

public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final d f23189a;

    /* renamed from: b  reason: collision with root package name */
    private final c f23190b;

    /* renamed from: c  reason: collision with root package name */
    private final i f23191c = new i();

    /* renamed from: d  reason: collision with root package name */
    private final o f23192d;

    /* renamed from: e  reason: collision with root package name */
    private b f23193e;

    /* renamed from: f  reason: collision with root package name */
    private r3.a f23194f;

    /* renamed from: g  reason: collision with root package name */
    private g5.c f23195g;

    /* renamed from: h  reason: collision with root package name */
    private List f23196h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23197i;

    public a(c cVar, d dVar, o oVar) {
        this.f23190b = cVar;
        this.f23189a = dVar;
        this.f23192d = oVar;
    }

    private void h() {
        if (this.f23194f == null) {
            this.f23194f = new r3.a(this.f23190b, this.f23191c, this, this.f23192d);
        }
        if (this.f23193e == null) {
            this.f23193e = new b(this.f23190b, this.f23191c);
        }
        if (this.f23195g == null) {
            this.f23195g = new g5.c(this.f23193e);
        }
    }

    public void a(i iVar, l lVar) {
        List list;
        if (this.f23197i && (list = this.f23196h) != null && !list.isEmpty()) {
            iVar.y();
            Iterator it = this.f23196h.iterator();
            if (it.hasNext()) {
                c.d.a(it.next());
                throw null;
            }
        }
    }

    public void b(i iVar, e eVar) {
        List list;
        iVar.n(eVar);
        if (this.f23197i && (list = this.f23196h) != null && !list.isEmpty()) {
            if (eVar == e.SUCCESS) {
                d();
            }
            iVar.y();
            Iterator it = this.f23196h.iterator();
            if (it.hasNext()) {
                c.d.a(it.next());
                throw null;
            }
        }
    }

    public void c(g gVar) {
        if (gVar != null) {
            if (this.f23196h == null) {
                this.f23196h = new CopyOnWriteArrayList();
            }
            this.f23196h.add(gVar);
        }
    }

    public void d() {
        z3.b b10 = this.f23189a.b();
        if (b10 != null && b10.f() != null) {
            Rect bounds = b10.f().getBounds();
            this.f23191c.t(bounds.width());
            this.f23191c.s(bounds.height());
        }
    }

    public void e() {
        List list = this.f23196h;
        if (list != null) {
            list.clear();
        }
    }

    public void f() {
        e();
        g(false);
        this.f23191c.b();
    }

    public void g(boolean z10) {
        this.f23197i = z10;
        if (z10) {
            h();
            r3.a aVar = this.f23194f;
            if (aVar != null) {
                this.f23189a.j(aVar);
            }
            g5.c cVar = this.f23195g;
            if (cVar != null) {
                this.f23189a.h0(cVar);
                return;
            }
            return;
        }
        r3.a aVar2 = this.f23194f;
        if (aVar2 != null) {
            this.f23189a.R(aVar2);
        }
        g5.c cVar2 = this.f23195g;
        if (cVar2 != null) {
            this.f23189a.w0(cVar2);
        }
    }
}
