package j8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.io.h;
import com.fasterxml.jackson.core.m;
import com.fasterxml.jackson.core.n;
import java.io.Serializable;

public class d implements m, e, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final h f12406h = new h(" ");

    /* renamed from: a  reason: collision with root package name */
    protected b f12407a;

    /* renamed from: b  reason: collision with root package name */
    protected b f12408b;

    /* renamed from: c  reason: collision with root package name */
    protected final n f12409c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f12410d;

    /* renamed from: e  reason: collision with root package name */
    protected transient int f12411e;

    /* renamed from: f  reason: collision with root package name */
    protected i f12412f;

    /* renamed from: g  reason: collision with root package name */
    protected String f12413g;

    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f12414b = new a();

        public void a(f fVar, int i10) {
            fVar.g0(' ');
        }

        public boolean isInline() {
            return true;
        }
    }

    public interface b {
        void a(f fVar, int i10);

        boolean isInline();
    }

    public static class c implements b, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12415a = new c();

        public void a(f fVar, int i10) {
        }

        public boolean isInline() {
            return true;
        }
    }

    public d() {
        this((n) f12406h);
    }

    public void a(f fVar) {
        fVar.g0('{');
        if (!this.f12408b.isInline()) {
            this.f12411e++;
        }
    }

    public void b(f fVar) {
        n nVar = this.f12409c;
        if (nVar != null) {
            fVar.h0(nVar);
        }
    }

    public void c(f fVar) {
        fVar.g0(this.f12412f.b());
        this.f12407a.a(fVar, this.f12411e);
    }

    public void d(f fVar) {
        this.f12408b.a(fVar, this.f12411e);
    }

    public void f(f fVar, int i10) {
        if (!this.f12408b.isInline()) {
            this.f12411e--;
        }
        if (i10 > 0) {
            this.f12408b.a(fVar, this.f12411e);
        } else {
            fVar.g0(' ');
        }
        fVar.g0('}');
    }

    public void h(f fVar) {
        if (!this.f12407a.isInline()) {
            this.f12411e++;
        }
        fVar.g0('[');
    }

    public void i(f fVar) {
        this.f12407a.a(fVar, this.f12411e);
    }

    public void j(f fVar) {
        fVar.g0(this.f12412f.c());
        this.f12408b.a(fVar, this.f12411e);
    }

    public void k(f fVar, int i10) {
        if (!this.f12407a.isInline()) {
            this.f12411e--;
        }
        if (i10 > 0) {
            this.f12407a.a(fVar, this.f12411e);
        } else {
            fVar.g0(' ');
        }
        fVar.g0(']');
    }

    public void l(f fVar) {
        if (this.f12410d) {
            fVar.i0(this.f12413g);
        } else {
            fVar.g0(this.f12412f.d());
        }
    }

    /* renamed from: m */
    public d e() {
        if (getClass() == d.class) {
            return new d(this);
        }
        throw new IllegalStateException("Failed `createInstance()`: " + getClass().getName() + " does not override method; it has to");
    }

    public d n(i iVar) {
        this.f12412f = iVar;
        this.f12413g = " " + iVar.d() + " ";
        return this;
    }

    public d(n nVar) {
        this.f12407a = a.f12414b;
        this.f12408b = c.f12402f;
        this.f12410d = true;
        this.f12409c = nVar;
        n(m.f5182l);
    }

    public d(d dVar) {
        this(dVar, dVar.f12409c);
    }

    public d(d dVar, n nVar) {
        this.f12407a = a.f12414b;
        this.f12408b = c.f12402f;
        this.f12410d = true;
        this.f12407a = dVar.f12407a;
        this.f12408b = dVar.f12408b;
        this.f12410d = dVar.f12410d;
        this.f12411e = dVar.f12411e;
        this.f12412f = dVar.f12412f;
        this.f12413g = dVar.f12413g;
        this.f12409c = nVar;
    }
}
