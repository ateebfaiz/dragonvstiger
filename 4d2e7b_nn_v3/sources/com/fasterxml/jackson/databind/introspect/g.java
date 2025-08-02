package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.util.f;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class g extends i implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    protected final transient Field f5343c;

    /* renamed from: d  reason: collision with root package name */
    protected a f5344d;

    private static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected Class f5345a;

        /* renamed from: b  reason: collision with root package name */
        protected String f5346b;

        public a(Field field) {
            this.f5345a = field.getDeclaringClass();
            this.f5346b = field.getName();
        }
    }

    public g(h0 h0Var, Field field, p pVar) {
        super(h0Var, pVar);
        this.f5343c = field;
    }

    public String c() {
        return this.f5343c.getName();
    }

    public Class d() {
        return this.f5343c.getType();
    }

    public j e() {
        return this.f5357a.a(this.f5343c.getGenericType());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!f.D(obj, g.class)) {
            return false;
        }
        Field field = ((g) obj).f5343c;
        if (field != null) {
            return field.equals(this.f5343c);
        }
        if (this.f5343c == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f5343c.getName().hashCode();
    }

    public Class k() {
        return this.f5343c.getDeclaringClass();
    }

    public Member m() {
        return this.f5343c;
    }

    public Object n(Object obj) {
        try {
            return this.f5343c.get(obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to getValue() for field " + l() + ": " + e10.getMessage(), e10);
        }
    }

    public Field p() {
        return this.f5343c;
    }

    public int q() {
        return this.f5343c.getModifiers();
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        a aVar = this.f5344d;
        Class cls = aVar.f5345a;
        try {
            Field declaredField = cls.getDeclaredField(aVar.f5346b);
            if (!declaredField.isAccessible()) {
                f.g(declaredField, false);
            }
            return new g((h0) null, declaredField, (p) null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + this.f5344d.f5346b + "' from Class '" + cls.getName());
        }
    }

    public boolean s() {
        return Modifier.isTransient(q());
    }

    /* renamed from: t */
    public g o(p pVar) {
        return new g(this.f5357a, this.f5343c, pVar);
    }

    public String toString() {
        return "[field " + l() + "]";
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new g(new a(this.f5343c));
    }

    protected g(a aVar) {
        super((h0) null, (p) null);
        this.f5343c = null;
        this.f5344d = aVar;
    }
}
