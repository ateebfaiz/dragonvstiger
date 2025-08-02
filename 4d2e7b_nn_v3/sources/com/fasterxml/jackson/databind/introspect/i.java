package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public abstract class i extends b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final transient h0 f5357a;

    /* renamed from: b  reason: collision with root package name */
    protected final transient p f5358b;

    protected i(h0 h0Var, p pVar) {
        this.f5357a = h0Var;
        this.f5358b = pVar;
    }

    public final Annotation b(Class cls) {
        p pVar = this.f5358b;
        if (pVar == null) {
            return null;
        }
        return pVar.get(cls);
    }

    public final boolean f(Class cls) {
        p pVar = this.f5358b;
        if (pVar == null) {
            return false;
        }
        return pVar.a(cls);
    }

    public boolean h(Class[] clsArr) {
        p pVar = this.f5358b;
        if (pVar == null) {
            return false;
        }
        return pVar.b(clsArr);
    }

    public final void i(boolean z10) {
        Member m10 = m();
        if (m10 != null) {
            f.g(m10, z10);
        }
    }

    public p j() {
        return this.f5358b;
    }

    public abstract Class k();

    public String l() {
        return k().getName() + "#" + c();
    }

    public abstract Member m();

    public abstract Object n(Object obj);

    public abstract b o(p pVar);
}
