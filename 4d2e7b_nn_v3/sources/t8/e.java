package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.std.b;
import java.util.List;
import q8.g;

public final class e extends b {
    public e(j jVar, boolean z10, g gVar, o oVar) {
        super(List.class, jVar, z10, gVar, oVar);
    }

    /* renamed from: D */
    public boolean d(b0 b0Var, List list) {
        return list.isEmpty();
    }

    /* renamed from: E */
    public final void f(List list, f fVar, b0 b0Var) {
        int size = list.size();
        if (size != 1 || ((this.f5524f != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5524f != Boolean.TRUE)) {
            fVar.n0(list, size);
            B(list, fVar, b0Var);
            fVar.P();
            return;
        }
        B(list, fVar, b0Var);
    }

    /* renamed from: F */
    public void B(List list, f fVar, b0 b0Var) {
        o A;
        o oVar = this.f5526h;
        if (oVar != null) {
            G(list, fVar, b0Var, oVar);
        } else if (this.f5525g != null) {
            H(list, fVar, b0Var);
        } else {
            int size = list.size();
            if (size != 0) {
                try {
                    k kVar = this.f5527i;
                    for (int i10 = 0; i10 < size; i10++) {
                        Object obj = list.get(i10);
                        if (obj == null) {
                            b0Var.x(fVar);
                        } else {
                            Class<?> cls = obj.getClass();
                            o j10 = kVar.j(cls);
                            if (j10 == null) {
                                if (this.f5521c.x()) {
                                    A = z(kVar, b0Var.t(this.f5521c, cls), b0Var);
                                } else {
                                    A = A(kVar, cls, b0Var);
                                }
                                j10 = A;
                                kVar = this.f5527i;
                            }
                            j10.f(obj, fVar, b0Var);
                        }
                    }
                } catch (Exception e10) {
                    v(b0Var, e10, list, 0);
                }
            }
        }
    }

    public void G(List list, f fVar, b0 b0Var, o oVar) {
        int size = list.size();
        if (size != 0) {
            g gVar = this.f5525g;
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = list.get(i10);
                if (obj == null) {
                    try {
                        b0Var.x(fVar);
                    } catch (Exception e10) {
                        v(b0Var, e10, list, i10);
                    }
                } else if (gVar == null) {
                    oVar.f(obj, fVar, b0Var);
                } else {
                    oVar.h(obj, fVar, b0Var, gVar);
                }
            }
        }
    }

    public void H(List list, f fVar, b0 b0Var) {
        o A;
        int size = list.size();
        if (size != 0) {
            try {
                g gVar = this.f5525g;
                k kVar = this.f5527i;
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = list.get(i10);
                    if (obj == null) {
                        b0Var.x(fVar);
                    } else {
                        Class<?> cls = obj.getClass();
                        o j10 = kVar.j(cls);
                        if (j10 == null) {
                            if (this.f5521c.x()) {
                                A = z(kVar, b0Var.t(this.f5521c, cls), b0Var);
                            } else {
                                A = A(kVar, cls, b0Var);
                            }
                            j10 = A;
                            kVar = this.f5527i;
                        }
                        j10.h(obj, fVar, b0Var, gVar);
                    }
                }
            } catch (Exception e10) {
                v(b0Var, e10, list, 0);
            }
        }
    }

    /* renamed from: I */
    public e C(d dVar, g gVar, o oVar, Boolean bool) {
        return new e(this, dVar, gVar, oVar, bool);
    }

    public h x(g gVar) {
        return new e(this, this.f5522d, gVar, this.f5526h, this.f5524f);
    }

    public e(e eVar, d dVar, g gVar, o oVar, Boolean bool) {
        super((b) eVar, dVar, gVar, oVar, bool);
    }
}
