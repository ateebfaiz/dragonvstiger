package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.q;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import t8.l;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f5516a = new HashMap(64);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f5517b = new AtomicReference();

    private final synchronized l a() {
        l lVar;
        lVar = (l) this.f5517b.get();
        if (lVar == null) {
            lVar = l.b(this.f5516a);
            this.f5517b.set(lVar);
        }
        return lVar;
    }

    public void b(j jVar, o oVar, b0 b0Var) {
        synchronized (this) {
            try {
                if (this.f5516a.put(new q(jVar, false), oVar) == null) {
                    this.f5517b.set((Object) null);
                }
                if (oVar instanceof o) {
                    ((o) oVar).b(b0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Class cls, j jVar, o oVar, b0 b0Var) {
        synchronized (this) {
            try {
                Object put = this.f5516a.put(new q(cls, false), oVar);
                Object put2 = this.f5516a.put(new q(jVar, false), oVar);
                if (put == null || put2 == null) {
                    this.f5517b.set((Object) null);
                }
                if (oVar instanceof o) {
                    ((o) oVar).b(b0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Class cls, o oVar) {
        synchronized (this) {
            try {
                if (this.f5516a.put(new q(cls, true), oVar) == null) {
                    this.f5517b.set((Object) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public l e() {
        l lVar = (l) this.f5517b.get();
        if (lVar != null) {
            return lVar;
        }
        return a();
    }

    public o f(Class cls) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f5516a.get(new q(cls, true));
        }
        return oVar;
    }

    public o g(j jVar) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f5516a.get(new q(jVar, false));
        }
        return oVar;
    }

    public o h(Class cls) {
        o oVar;
        synchronized (this) {
            oVar = (o) this.f5516a.get(new q(cls, false));
        }
        return oVar;
    }
}
