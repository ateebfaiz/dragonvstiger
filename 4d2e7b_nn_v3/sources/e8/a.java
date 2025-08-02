package e8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.j;
import com.fasterxml.jackson.core.l;
import g8.c;
import java.math.BigDecimal;

public abstract class a extends f {

    /* renamed from: j  reason: collision with root package name */
    protected static final int f11960j = ((f.b.WRITE_NUMBERS_AS_STRINGS.d() | f.b.ESCAPE_NON_ASCII.d()) | f.b.STRICT_DUPLICATE_DETECTION.d());

    /* renamed from: e  reason: collision with root package name */
    protected l f11961e;

    /* renamed from: f  reason: collision with root package name */
    protected int f11962f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f11963g;

    /* renamed from: h  reason: collision with root package name */
    protected c f11964h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f11965i;

    protected a(int i10, l lVar) {
        g8.a aVar;
        this.f11962f = i10;
        this.f11961e = lVar;
        if (f.b.STRICT_DUPLICATE_DETECTION.c(i10)) {
            aVar = g8.a.e(this);
        } else {
            aVar = null;
        }
        this.f11964h = c.m(aVar);
        this.f11963g = f.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
    }

    public f A(int i10, int i11) {
        int i12 = this.f11962f;
        int i13 = (i10 & i11) | ((~i11) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this.f11962f = i13;
            z0(i13, i14);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void A0(String str);

    public void B(Object obj) {
        c cVar = this.f11964h;
        if (cVar != null) {
            cVar.q(obj);
        }
    }

    public void close() {
        this.f11965i = true;
    }

    public void k0(String str) {
        A0("write raw value");
        i0(str);
    }

    public f p(f.b bVar) {
        int d10 = bVar.d();
        this.f11962f &= ~d10;
        if ((d10 & f11960j) != 0) {
            if (bVar == f.b.WRITE_NUMBERS_AS_STRINGS) {
                this.f11963g = false;
            } else if (bVar == f.b.ESCAPE_NON_ASCII) {
                C(0);
            } else if (bVar == f.b.STRICT_DUPLICATE_DETECTION) {
                this.f11964h = this.f11964h.r((g8.a) null);
            }
        }
        return this;
    }

    public j v() {
        return this.f11964h;
    }

    public final boolean y(f.b bVar) {
        if ((bVar.d() & this.f11962f) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String y0(BigDecimal bigDecimal) {
        if (!f.b.WRITE_BIGDECIMAL_AS_PLAIN.c(this.f11962f)) {
            return bigDecimal.toString();
        }
        int scale = bigDecimal.scale();
        if (scale < -9999 || scale > 9999) {
            a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(scale), Integer.valueOf(com.alibaba.pdns.x.c.f18290d), Integer.valueOf(com.alibaba.pdns.x.c.f18290d)}));
        }
        return bigDecimal.toPlainString();
    }

    /* access modifiers changed from: protected */
    public void z0(int i10, int i11) {
        if ((f11960j & i11) != 0) {
            this.f11963g = f.b.WRITE_NUMBERS_AS_STRINGS.c(i10);
            f.b bVar = f.b.ESCAPE_NON_ASCII;
            if (bVar.c(i11)) {
                if (bVar.c(i10)) {
                    C(127);
                } else {
                    C(0);
                }
            }
            f.b bVar2 = f.b.STRICT_DUPLICATE_DETECTION;
            if (!bVar2.c(i11)) {
                return;
            }
            if (!bVar2.c(i10)) {
                this.f11964h = this.f11964h.r((g8.a) null);
            } else if (this.f11964h.n() == null) {
                this.f11964h = this.f11964h.r(g8.a.e(this));
            }
        }
    }
}
