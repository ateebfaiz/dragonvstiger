package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.c;
import com.fasterxml.jackson.databind.ser.std.d;
import java.util.Set;
import q8.g;

public class b extends d {
    protected final d X;

    public b(d dVar) {
        super(dVar, (i) null);
        this.X = dVar;
    }

    private boolean K(b0 b0Var) {
        c[] cVarArr;
        if (this.f5539e == null || b0Var.K() == null) {
            cVarArr = this.f5538d;
        } else {
            cVarArr = this.f5539e;
        }
        if (cVarArr.length == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public d B() {
        return this;
    }

    public d H(Object obj) {
        return new b((d) this, this.f5543i, obj);
    }

    public d I(i iVar) {
        return this.X.I(iVar);
    }

    /* access modifiers changed from: protected */
    public d J(c[] cVarArr, c[] cVarArr2) {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void L(Object obj, f fVar, b0 b0Var) {
        c[] cVarArr;
        if (this.f5539e == null || b0Var.K() == null) {
            cVarArr = this.f5538d;
        } else {
            cVarArr = this.f5539e;
        }
        try {
            for (c cVar : cVarArr) {
                if (cVar == null) {
                    fVar.U();
                } else {
                    cVar.u(obj, fVar, b0Var);
                }
            }
        } catch (Exception e10) {
            w(b0Var, e10, obj, cVarArr[0].m());
        } catch (StackOverflowError e11) {
            l j10 = l.j(fVar, "Infinite recursion (StackOverflowError)", e11);
            j10.e(obj, cVarArr[0].m());
            throw j10;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: M */
    public b G(Set set, Set set2) {
        return new b((d) this, set, set2);
    }

    public boolean e() {
        return false;
    }

    public final void f(Object obj, f fVar, b0 b0Var) {
        if (!b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) || !K(b0Var)) {
            fVar.m0(obj);
            L(obj, fVar, b0Var);
            fVar.P();
            return;
        }
        L(obj, fVar, b0Var);
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        if (this.f5543i != null) {
            y(obj, fVar, b0Var, gVar);
            return;
        }
        i8.b A = A(gVar, obj, k.START_ARRAY);
        gVar.g(fVar, A);
        fVar.B(obj);
        L(obj, fVar, b0Var);
        gVar.h(fVar, A);
    }

    public o i(com.fasterxml.jackson.databind.util.l lVar) {
        return this.X.i(lVar);
    }

    public String toString() {
        return "BeanAsArraySerializer for " + c().getName();
    }

    protected b(d dVar, Set set, Set set2) {
        super(dVar, set, set2);
        this.X = dVar;
    }

    protected b(d dVar, i iVar, Object obj) {
        super(dVar, iVar, obj);
        this.X = dVar;
    }
}
