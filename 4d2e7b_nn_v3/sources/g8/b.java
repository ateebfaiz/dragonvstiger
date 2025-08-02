package g8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.io.c;
import com.fasterxml.jackson.core.l;
import com.fasterxml.jackson.core.n;
import e8.a;
import j8.d;
import j8.h;

public abstract class b extends a {
    protected static final int[] N0 = com.fasterxml.jackson.core.io.a.d();
    protected static final h O0 = f.f5092c;
    protected int[] C = N0;
    protected int X;
    protected n Y = d.f12406h;
    protected boolean Z;

    /* renamed from: w  reason: collision with root package name */
    protected final c f12221w;

    public b(c cVar, int i10, l lVar) {
        super(i10, lVar);
        this.f12221w = cVar;
        if (f.b.ESCAPE_NON_ASCII.c(i10)) {
            this.X = 127;
        }
        this.Z = !f.b.QUOTE_FIELD_NAMES.c(i10);
    }

    /* access modifiers changed from: protected */
    public void B0(String str) {
        a(String.format("Can not %s, expecting field name (context: %s)", new Object[]{str, this.f11964h.f()}));
    }

    public f C(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.X = i10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void C0(String str, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.f5094a.c(this);
            } else if (i10 == 2) {
                this.f5094a.l(this);
            } else if (i10 == 3) {
                this.f5094a.b(this);
            } else if (i10 != 5) {
                b();
            } else {
                B0(str);
            }
        } else if (this.f11964h.d()) {
            this.f5094a.i(this);
        } else if (this.f11964h.e()) {
            this.f5094a.d(this);
        }
    }

    public f D0(n nVar) {
        this.Y = nVar;
        return this;
    }

    public f p(f.b bVar) {
        super.p(bVar);
        if (bVar == f.b.QUOTE_FIELD_NAMES) {
            this.Z = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void z0(int i10, int i11) {
        super.z0(i10, i11);
        this.Z = !f.b.QUOTE_FIELD_NAMES.c(i10);
    }
}
