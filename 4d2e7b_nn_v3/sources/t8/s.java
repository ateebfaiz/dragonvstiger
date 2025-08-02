package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.c;
import com.fasterxml.jackson.databind.ser.std.d;
import com.fasterxml.jackson.databind.util.l;
import java.io.Serializable;
import java.util.Set;
import q8.g;

public class s extends d implements Serializable {
    protected final l X;

    public s(d dVar, l lVar) {
        super(dVar, lVar);
        this.X = lVar;
    }

    /* access modifiers changed from: protected */
    public d B() {
        return this;
    }

    /* access modifiers changed from: protected */
    public d G(Set set, Set set2) {
        return new s(this, set, set2);
    }

    public d H(Object obj) {
        return new s(this, this.f5543i, obj);
    }

    public d I(i iVar) {
        return new s(this, iVar);
    }

    /* access modifiers changed from: protected */
    public d J(c[] cVarArr, c[] cVarArr2) {
        return new s(this, cVarArr, cVarArr2);
    }

    public boolean e() {
        return true;
    }

    public final void f(Object obj, f fVar, b0 b0Var) {
        fVar.B(obj);
        if (this.f5543i != null) {
            z(obj, fVar, b0Var, false);
        } else if (this.f5541g != null) {
            F(obj, fVar, b0Var);
        } else {
            E(obj, fVar, b0Var);
        }
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        if (b0Var.b0(a0.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            b0Var.k(c(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        fVar.B(obj);
        if (this.f5543i != null) {
            y(obj, fVar, b0Var, gVar);
        } else if (this.f5541g != null) {
            F(obj, fVar, b0Var);
        } else {
            E(obj, fVar, b0Var);
        }
    }

    public o i(l lVar) {
        return new s((d) this, lVar);
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + c().getName();
    }

    public s(s sVar, i iVar) {
        super((d) sVar, iVar);
        this.X = sVar.X;
    }

    public s(s sVar, i iVar, Object obj) {
        super((d) sVar, iVar, obj);
        this.X = sVar.X;
    }

    protected s(s sVar, Set set, Set set2) {
        super((d) sVar, set, set2);
        this.X = sVar.X;
    }

    protected s(s sVar, c[] cVarArr, c[] cVarArr2) {
        super((d) sVar, cVarArr, cVarArr2);
        this.X = sVar.X;
    }
}
