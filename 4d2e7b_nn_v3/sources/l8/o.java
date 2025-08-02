package l8;

import com.fasterxml.jackson.databind.ser.g;
import com.fasterxml.jackson.databind.ser.r;
import com.fasterxml.jackson.databind.util.c;
import java.io.Serializable;

public final class o implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    protected static final r[] f12734d = new r[0];

    /* renamed from: e  reason: collision with root package name */
    protected static final g[] f12735e = new g[0];

    /* renamed from: a  reason: collision with root package name */
    protected final r[] f12736a;

    /* renamed from: b  reason: collision with root package name */
    protected final r[] f12737b;

    /* renamed from: c  reason: collision with root package name */
    protected final g[] f12738c;

    public o() {
        this((r[]) null, (r[]) null, (g[]) null);
    }

    public boolean a() {
        if (this.f12737b.length > 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f12738c.length > 0) {
            return true;
        }
        return false;
    }

    public Iterable c() {
        return new c(this.f12737b);
    }

    public Iterable d() {
        return new c(this.f12738c);
    }

    public Iterable e() {
        return new c(this.f12736a);
    }

    protected o(r[] rVarArr, r[] rVarArr2, g[] gVarArr) {
        this.f12736a = rVarArr == null ? f12734d : rVarArr;
        this.f12737b = rVarArr2 == null ? f12734d : rVarArr2;
        this.f12738c = gVarArr == null ? f12735e : gVarArr;
    }
}
