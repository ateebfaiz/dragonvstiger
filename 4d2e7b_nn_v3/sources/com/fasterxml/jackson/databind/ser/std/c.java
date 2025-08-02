package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.type.j;
import com.fasterxml.jackson.databind.util.l;
import java.util.concurrent.atomic.AtomicReference;
import q8.g;

public class c extends z {
    public c(j jVar, boolean z10, g gVar, o oVar) {
        super(jVar, z10, gVar, oVar);
    }

    public z D(Object obj, boolean z10) {
        return new c(this, this.f5604d, this.f5605e, this.f5606f, this.f5607g, obj, z10);
    }

    /* access modifiers changed from: protected */
    public z E(d dVar, g gVar, o oVar, l lVar) {
        return new c(this, dVar, gVar, oVar, lVar, this.f5609i, this.f5610j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: F */
    public Object z(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public Object A(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public boolean B(AtomicReference atomicReference) {
        if (atomicReference.get() != null) {
            return true;
        }
        return false;
    }

    protected c(c cVar, d dVar, g gVar, o oVar, l lVar, Object obj, boolean z10) {
        super(cVar, dVar, gVar, oVar, lVar, obj, z10);
    }
}
