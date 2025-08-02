package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.type.b;
import com.fasterxml.jackson.databind.w;
import java.io.Serializable;
import l8.l;

public class m implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected transient j f5699a = new j(20, 200);

    public w a(Class cls, l lVar) {
        b bVar = new b(cls);
        w wVar = (w) this.f5699a.get(bVar);
        if (wVar != null) {
            return wVar;
        }
        w K = lVar.h().K(lVar.D(cls).k());
        if (K == null || !K.e()) {
            K = w.a(cls.getSimpleName());
        }
        this.f5699a.b(bVar, K);
        return K;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new m();
    }
}
