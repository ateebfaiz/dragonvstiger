package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.h;
import com.fasterxml.jackson.databind.z;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import t8.k;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    protected static final o f5548a = new e0();

    /* renamed from: b  reason: collision with root package name */
    protected static final o f5549b = new d();

    public static class a extends h0 {

        /* renamed from: c  reason: collision with root package name */
        protected final int f5550c;

        public a(int i10, Class cls) {
            super(cls, false);
            this.f5550c = i10;
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            String str;
            switch (this.f5550c) {
                case 1:
                    b0Var.v((Date) obj, fVar);
                    return;
                case 2:
                    b0Var.u(((Calendar) obj).getTimeInMillis(), fVar);
                    return;
                case 3:
                    fVar.T(((Class) obj).getName());
                    return;
                case 4:
                    if (b0Var.b0(a0.WRITE_ENUMS_USING_TO_STRING)) {
                        str = obj.toString();
                    } else {
                        Enum enumR = (Enum) obj;
                        if (b0Var.b0(a0.WRITE_ENUM_KEYS_USING_INDEX)) {
                            str = String.valueOf(enumR.ordinal());
                        } else {
                            str = enumR.name();
                        }
                    }
                    fVar.T(str);
                    return;
                case 5:
                case 6:
                    fVar.R(((Number) obj).longValue());
                    return;
                case 7:
                    fVar.T(b0Var.f().i().a((byte[]) obj));
                    return;
                default:
                    fVar.T(obj.toString());
                    return;
            }
        }
    }

    public static class b extends h0 {

        /* renamed from: c  reason: collision with root package name */
        protected transient k f5551c = k.c();

        public b() {
            super(String.class, false);
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            Class<?> cls = obj.getClass();
            k kVar = this.f5551c;
            o j10 = kVar.j(cls);
            if (j10 == null) {
                j10 = x(kVar, cls, b0Var);
            }
            j10.f(obj, fVar, b0Var);
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            this.f5551c = k.c();
            return this;
        }

        /* access modifiers changed from: protected */
        public o x(k kVar, Class cls, b0 b0Var) {
            if (cls == Object.class) {
                a aVar = new a(8, cls);
                this.f5551c = kVar.i(cls, aVar);
                return aVar;
            }
            k.d d10 = kVar.d(cls, b0Var, (com.fasterxml.jackson.databind.d) null);
            k kVar2 = d10.f13099b;
            if (kVar != kVar2) {
                this.f5551c = kVar2;
            }
            return d10.f13098a;
        }
    }

    public static class c extends h0 {

        /* renamed from: c  reason: collision with root package name */
        protected final h f5552c;

        protected c(Class cls, h hVar) {
            super(cls, false);
            this.f5552c = hVar;
        }

        public static c x(Class cls, h hVar) {
            return new c(cls, hVar);
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            if (b0Var.b0(a0.WRITE_ENUMS_USING_TO_STRING)) {
                fVar.T(obj.toString());
                return;
            }
            Enum enumR = (Enum) obj;
            if (b0Var.b0(a0.WRITE_ENUM_KEYS_USING_INDEX)) {
                fVar.T(String.valueOf(enumR.ordinal()));
            } else {
                fVar.S(this.f5552c.d(enumR));
            }
        }
    }

    public static class d extends h0 {
        public d() {
            super(String.class, false);
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            fVar.T((String) obj);
        }
    }

    public static o a(z zVar, Class cls) {
        if (cls != null) {
            if (cls == Enum.class) {
                return new b();
            }
            if (com.fasterxml.jackson.databind.util.f.G(cls)) {
                return c.x(cls, h.b(zVar, cls));
            }
        }
        return new a(8, cls);
    }

    public static o b(z zVar, Class<byte[]> cls, boolean z10) {
        if (cls == null || cls == Object.class) {
            return new b();
        }
        if (cls == String.class) {
            return f5549b;
        }
        if (cls.isPrimitive()) {
            cls = com.fasterxml.jackson.databind.util.f.Z(cls);
        }
        if (cls == Integer.class) {
            return new a(5, cls);
        }
        if (cls == Long.class) {
            return new a(6, cls);
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
            return new a(8, cls);
        }
        if (cls == Class.class) {
            return new a(3, cls);
        }
        if (Date.class.isAssignableFrom(cls)) {
            return new a(1, cls);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return new a(2, cls);
        }
        if (cls == UUID.class) {
            return new a(8, cls);
        }
        if (cls == byte[].class) {
            return new a(7, cls);
        }
        if (z10) {
            return new a(8, cls);
        }
        return null;
    }
}
