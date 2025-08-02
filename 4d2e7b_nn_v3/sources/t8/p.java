package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.ser.std.k0;
import q8.g;

public class p extends k0 {
    public p() {
        super(Object.class);
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        if (b0Var.b0(a0.FAIL_ON_EMPTY_BEANS)) {
            x(b0Var, obj);
        }
        super.f(obj, fVar, b0Var);
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        if (b0Var.b0(a0.FAIL_ON_EMPTY_BEANS)) {
            x(b0Var, obj);
        }
        super.h(obj, fVar, b0Var, gVar);
    }

    /* access modifiers changed from: protected */
    public void x(b0 b0Var, Object obj) {
        b0Var.k(c(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", new Object[]{obj.getClass().getName()}));
    }

    public p(Class cls) {
        super(cls);
    }
}
