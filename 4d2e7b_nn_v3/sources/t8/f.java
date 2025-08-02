package t8;

import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.std.b0;
import i8.b;
import java.util.List;
import q8.g;

public final class f extends b0 {

    /* renamed from: d  reason: collision with root package name */
    public static final f f13073d = new f();

    protected f() {
        super(List.class);
    }

    private final void A(List list, com.fasterxml.jackson.core.f fVar, com.fasterxml.jackson.databind.b0 b0Var, int i10) {
        int i11 = 0;
        while (i11 < i10) {
            try {
                String str = (String) list.get(i11);
                if (str == null) {
                    b0Var.x(fVar);
                } else {
                    fVar.s0(str);
                }
                i11++;
            } catch (Exception e10) {
                v(b0Var, e10, list, i11);
                return;
            }
        }
    }

    /* renamed from: B */
    public void h(List list, com.fasterxml.jackson.core.f fVar, com.fasterxml.jackson.databind.b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(list, k.START_ARRAY));
        fVar.B(list);
        A(list, fVar, b0Var, list.size());
        gVar.h(fVar, g10);
    }

    public o x(d dVar, Boolean bool) {
        return new f(this, bool);
    }

    /* renamed from: z */
    public void f(List list, com.fasterxml.jackson.core.f fVar, com.fasterxml.jackson.databind.b0 b0Var) {
        int size = list.size();
        if (size != 1 || ((this.f5528c != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5528c != Boolean.TRUE)) {
            fVar.n0(list, size);
            A(list, fVar, b0Var, size);
            fVar.P();
            return;
        }
        A(list, fVar, b0Var, 1);
    }

    public f(f fVar, Boolean bool) {
        super(fVar, bool);
    }
}
