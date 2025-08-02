package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class j extends n implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    protected final transient Method f5362d;

    /* renamed from: e  reason: collision with root package name */
    protected Class[] f5363e;

    /* renamed from: f  reason: collision with root package name */
    protected a f5364f;

    private static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected Class f5365a;

        /* renamed from: b  reason: collision with root package name */
        protected String f5366b;

        /* renamed from: c  reason: collision with root package name */
        protected Class[] f5367c;

        public a(Method method) {
            this.f5365a = method.getDeclaringClass();
            this.f5366b = method.getName();
            this.f5367c = method.getParameterTypes();
        }
    }

    public j(h0 h0Var, Method method, p pVar, p[] pVarArr) {
        super(h0Var, pVar, pVarArr);
        if (method != null) {
            this.f5362d = method;
            return;
        }
        throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
    }

    /* renamed from: A */
    public j o(p pVar) {
        return new j(this.f5357a, this.f5362d, pVar, this.f5384c);
    }

    public String c() {
        return this.f5362d.getName();
    }

    public Class d() {
        return this.f5362d.getReturnType();
    }

    public com.fasterxml.jackson.databind.j e() {
        return this.f5357a.a(this.f5362d.getGenericReturnType());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, j.class)) {
            return false;
        }
        Method method = ((j) obj).f5362d;
        if (method != null) {
            return method.equals(this.f5362d);
        }
        if (this.f5362d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f5362d.getName().hashCode();
    }

    public Class k() {
        return this.f5362d.getDeclaringClass();
    }

    public String l() {
        String l10 = super.l();
        int w10 = w();
        if (w10 == 0) {
            return l10 + "()";
        } else if (w10 != 1) {
            return String.format("%s(%d params)", new Object[]{super.l(), Integer.valueOf(w())});
        } else {
            return l10 + "(" + x(0).getName() + ")";
        }
    }

    public Object n(Object obj) {
        try {
            return this.f5362d.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to getValue() with method " + l() + ": " + f.m(e10), e10);
        }
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        a aVar = this.f5364f;
        Class cls = aVar.f5365a;
        try {
            Method declaredMethod = cls.getDeclaredMethod(aVar.f5366b, aVar.f5367c);
            if (!declaredMethod.isAccessible()) {
                f.g(declaredMethod, false);
            }
            return new j((h0) null, declaredMethod, (p) null, (p[]) null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + this.f5364f.f5366b + "' from Class '" + cls.getName());
        }
    }

    public com.fasterxml.jackson.databind.j s(int i10) {
        Type[] genericParameterTypes = this.f5362d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f5357a.a(genericParameterTypes[i10]);
    }

    public String toString() {
        return "[method " + l() + "]";
    }

    public Method u() {
        return this.f5362d;
    }

    /* renamed from: v */
    public Method m() {
        return this.f5362d;
    }

    public int w() {
        return y().length;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new j(new a(this.f5362d));
    }

    public Class x(int i10) {
        Class[] y10 = y();
        if (i10 >= y10.length) {
            return null;
        }
        return y10[i10];
    }

    public Class[] y() {
        if (this.f5363e == null) {
            this.f5363e = this.f5362d.getParameterTypes();
        }
        return this.f5363e;
    }

    public Class z() {
        return this.f5362d.getReturnType();
    }

    protected j(a aVar) {
        super((h0) null, (p) null, (p[]) null);
        this.f5362d = null;
        this.f5364f = aVar;
    }
}
