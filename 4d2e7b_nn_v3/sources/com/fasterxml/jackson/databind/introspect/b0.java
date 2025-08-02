package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.o0;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.w;

public class b0 {

    /* renamed from: f  reason: collision with root package name */
    private static final b0 f5260f = new b0(w.f5733e, Object.class, (Class) null, false, (Class) null);

    /* renamed from: a  reason: collision with root package name */
    protected final w f5261a;

    /* renamed from: b  reason: collision with root package name */
    protected final Class f5262b;

    /* renamed from: c  reason: collision with root package name */
    protected final Class f5263c;

    /* renamed from: d  reason: collision with root package name */
    protected final Class f5264d;

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f5265e;

    public b0(w wVar, Class cls, Class cls2, Class cls3) {
        this(wVar, cls, cls2, false, cls3);
    }

    public static b0 a() {
        return f5260f;
    }

    public boolean b() {
        return this.f5265e;
    }

    public Class c() {
        return this.f5262b;
    }

    public w d() {
        return this.f5261a;
    }

    public Class e() {
        return this.f5264d;
    }

    public b0 f(boolean z10) {
        if (this.f5265e == z10) {
            return this;
        }
        return new b0(this.f5261a, this.f5264d, this.f5262b, z10, this.f5263c);
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.f5261a + ", scope=" + f.Q(this.f5264d) + ", generatorType=" + f.Q(this.f5262b) + ", alwaysAsId=" + this.f5265e;
    }

    protected b0(w wVar, Class cls, Class cls2, boolean z10, Class cls3) {
        this.f5261a = wVar;
        this.f5264d = cls;
        this.f5262b = cls2;
        this.f5265e = z10;
        this.f5263c = cls3 == null ? o0.class : cls3;
    }
}
