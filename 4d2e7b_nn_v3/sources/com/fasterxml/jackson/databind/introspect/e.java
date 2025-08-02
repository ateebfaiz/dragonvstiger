package com.fasterxml.jackson.databind.introspect;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class e extends n {

    /* renamed from: d  reason: collision with root package name */
    protected final Constructor f5315d;

    /* renamed from: e  reason: collision with root package name */
    protected a f5316e;

    private static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected Class f5317a;

        /* renamed from: b  reason: collision with root package name */
        protected Class[] f5318b;

        public a(Constructor constructor) {
            this.f5317a = constructor.getDeclaringClass();
            this.f5318b = constructor.getParameterTypes();
        }
    }

    public e(h0 h0Var, Constructor constructor, p pVar, p[] pVarArr) {
        super(h0Var, pVar, pVarArr);
        if (constructor != null) {
            this.f5315d = constructor;
            return;
        }
        throw new IllegalArgumentException("Null constructor not allowed");
    }

    public String c() {
        return this.f5315d.getName();
    }

    public Class d() {
        return this.f5315d.getDeclaringClass();
    }

    public j e() {
        return this.f5357a.a(d());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, e.class)) {
            return false;
        }
        Constructor constructor = ((e) obj).f5315d;
        if (constructor != null) {
            return constructor.equals(this.f5315d);
        }
        if (this.f5315d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f5315d.getName().hashCode();
    }

    public Class k() {
        return this.f5315d.getDeclaringClass();
    }

    public Member m() {
        return this.f5315d;
    }

    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + k().getName());
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        a aVar = this.f5316e;
        Class cls = aVar.f5317a;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(aVar.f5318b);
            if (!declaredConstructor.isAccessible()) {
                f.g(declaredConstructor, false);
            }
            return new e((h0) null, declaredConstructor, (p) null, (p[]) null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find constructor with " + this.f5316e.f5318b.length + " args from Class '" + cls.getName());
        }
    }

    public j s(int i10) {
        Type[] genericParameterTypes = this.f5315d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f5357a.a(genericParameterTypes[i10]);
    }

    public String toString() {
        String str;
        int length = this.f5315d.getParameterTypes().length;
        String Q = f.Q(this.f5315d.getDeclaringClass());
        Integer valueOf = Integer.valueOf(length);
        if (length == 1) {
            str = "";
        } else {
            str = DomainUhfReportModel.SCENE;
        }
        return String.format("[constructor for %s (%d arg%s), annotations: %s", new Object[]{Q, valueOf, str, this.f5358b});
    }

    public final Object u() {
        return this.f5315d.newInstance((Object[]) null);
    }

    public int v() {
        return this.f5315d.getParameterTypes().length;
    }

    /* renamed from: w */
    public e o(p pVar) {
        return new e(this.f5357a, this.f5315d, pVar, this.f5384c);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new e(new a(this.f5315d));
    }

    protected e(a aVar) {
        super((h0) null, (p) null, (p[]) null);
        this.f5315d = null;
        this.f5316e = aVar;
    }
}
