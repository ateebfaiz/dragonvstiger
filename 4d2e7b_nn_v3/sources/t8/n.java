package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.std.b0;
import i8.b;
import java.util.Collection;
import java.util.Iterator;
import q8.g;

public class n extends b0 {

    /* renamed from: d  reason: collision with root package name */
    public static final n f13115d = new n();

    protected n() {
        super(Collection.class);
    }

    private final void A(Collection collection, f fVar, com.fasterxml.jackson.databind.b0 b0Var) {
        int i10 = 0;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    b0Var.x(fVar);
                } else {
                    fVar.s0(str);
                }
                i10++;
            }
        } catch (Exception e10) {
            v(b0Var, e10, collection, 0);
        }
    }

    /* renamed from: B */
    public void h(Collection collection, f fVar, com.fasterxml.jackson.databind.b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(collection, k.START_ARRAY));
        fVar.B(collection);
        A(collection, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    public o x(d dVar, Boolean bool) {
        return new n(this, bool);
    }

    /* renamed from: z */
    public void f(Collection collection, f fVar, com.fasterxml.jackson.databind.b0 b0Var) {
        int size = collection.size();
        if (size != 1 || ((this.f5528c != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5528c != Boolean.TRUE)) {
            fVar.n0(collection, size);
            A(collection, fVar, b0Var);
            fVar.P();
            return;
        }
        A(collection, fVar, b0Var);
    }

    protected n(n nVar, Boolean bool) {
        super(nVar, bool);
    }
}
