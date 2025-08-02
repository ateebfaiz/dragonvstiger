package t8;

import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.annotation.l0;
import com.fasterxml.jackson.databind.introspect.b0;
import com.fasterxml.jackson.databind.ser.c;

public class j extends l0 {

    /* renamed from: b  reason: collision with root package name */
    protected final c f13089b;

    public j(b0 b0Var, c cVar) {
        this(b0Var.e(), cVar);
    }

    public boolean a(i0 i0Var) {
        if (i0Var.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) i0Var;
        if (jVar.e() == this.f5016a && jVar.f13089b == this.f13089b) {
            return true;
        }
        return false;
    }

    public i0 b(Class cls) {
        if (cls == this.f5016a) {
            return this;
        }
        return new j(cls, this.f13089b);
    }

    public Object c(Object obj) {
        try {
            return this.f13089b.l(obj);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IllegalStateException("Problem accessing property '" + this.f13089b.m() + "': " + e11.getMessage(), e11);
        }
    }

    public i0 d(Object obj) {
        return this;
    }

    protected j(Class cls, c cVar) {
        super(cls);
        this.f13089b = cVar;
    }
}
