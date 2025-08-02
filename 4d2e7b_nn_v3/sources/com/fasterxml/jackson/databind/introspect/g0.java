package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.type.b;
import java.io.Serializable;
import java.util.Map;

public class g0 implements t.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final t.a f5347a;

    /* renamed from: b  reason: collision with root package name */
    protected Map f5348b;

    public g0(t.a aVar) {
        this.f5347a = aVar;
    }

    public Class a(Class cls) {
        Class cls2;
        Map map;
        t.a aVar = this.f5347a;
        if (aVar == null) {
            cls2 = null;
        } else {
            cls2 = aVar.a(cls);
        }
        if (cls2 != null || (map = this.f5348b) == null) {
            return cls2;
        }
        return (Class) map.get(new b(cls));
    }

    public boolean b() {
        if (this.f5348b != null) {
            return true;
        }
        t.a aVar = this.f5347a;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof g0) {
            return ((g0) aVar).b();
        }
        return true;
    }
}
