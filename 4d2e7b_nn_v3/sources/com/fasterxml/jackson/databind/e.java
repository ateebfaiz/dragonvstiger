package com.fasterxml.jackson.databind;

import c.d;
import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.databind.introspect.b;
import com.fasterxml.jackson.databind.introspect.b0;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.util.g;
import java.lang.reflect.Type;
import l8.l;

public abstract class e {
    /* access modifiers changed from: protected */
    public final String a(String str, Object... objArr) {
        if (objArr.length > 0) {
            return String.format(str, objArr);
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public String b(String str) {
        if (str == null) {
            return "[N/A]";
        }
        return String.format("\"%s\"", new Object[]{c(str)});
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }

    public j d(Type type) {
        if (type == null) {
            return null;
        }
        return h().E(type);
    }

    public g e(b bVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<g.a> cls = (Class) obj;
            if (cls == g.a.class || f.F(cls)) {
                return null;
            }
            if (g.class.isAssignableFrom(cls)) {
                l f10 = f();
                f10.w();
                d.a(f.k(cls, f10.b()));
                return null;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    public abstract l f();

    public abstract o h();

    public i0 i(b bVar, b0 b0Var) {
        Class c10 = b0Var.c();
        l f10 = f();
        f10.w();
        return ((i0) f.k(c10, f10.b())).b(b0Var.e());
    }

    public abstract Object j(j jVar, String str);

    public Object k(Class cls, String str) {
        return j(d(cls), str);
    }
}
