package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.z;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import t8.t;

public abstract class j extends b0 implements Serializable {
    protected transient ArrayList N0;
    protected transient f O0;
    protected transient Map Z;

    public static final class a extends j {
        public a() {
        }

        /* renamed from: r0 */
        public a p0(z zVar, q qVar) {
            return new a(this, zVar, qVar);
        }

        protected a(b0 b0Var, z zVar, q qVar) {
            super(b0Var, zVar, qVar);
        }
    }

    protected j() {
    }

    private final void l0(f fVar, Object obj, o oVar) {
        try {
            oVar.f(obj, fVar, this);
        } catch (Exception e10) {
            throw o0(fVar, e10);
        }
    }

    private final void m0(f fVar, Object obj, o oVar, w wVar) {
        try {
            fVar.o0();
            fVar.S(wVar.i(this.f5206a));
            oVar.f(obj, fVar, this);
            fVar.Q();
        } catch (Exception e10) {
            throw o0(fVar, e10);
        }
    }

    private IOException o0(f fVar, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String m10 = com.fasterxml.jackson.databind.util.f.m(exc);
        if (m10 == null) {
            m10 = "[no message for " + exc.getClass().getName() + "]";
        }
        return new l(fVar, m10, exc);
    }

    public t E(Object obj, i0 i0Var) {
        i0 i0Var2;
        Map map = this.Z;
        if (map == null) {
            this.Z = k0();
        } else {
            t tVar = (t) map.get(obj);
            if (tVar != null) {
                return tVar;
            }
        }
        ArrayList arrayList = this.N0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                i0Var2 = (i0) this.N0.get(i10);
                if (i0Var2.a(i0Var)) {
                    break;
                }
                i10++;
            }
        } else {
            this.N0 = new ArrayList(8);
        }
        i0Var2 = null;
        if (i0Var2 == null) {
            i0Var2 = i0Var.d(this);
            this.N0.add(i0Var2);
        }
        t tVar2 = new t(i0Var2);
        this.Z.put(obj, tVar2);
        return tVar2;
    }

    public f S() {
        return this.O0;
    }

    public Object Y(s sVar, Class cls) {
        if (cls == null) {
            return null;
        }
        this.f5206a.w();
        return com.fasterxml.jackson.databind.util.f.k(cls, this.f5206a.b());
    }

    public boolean Z(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals((Object) null);
        } catch (Throwable th) {
            d0(obj.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", new Object[]{obj.getClass().getName(), th.getClass().getName(), com.fasterxml.jackson.databind.util.f.m(th)}), th);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.fasterxml.jackson.databind.o} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o i0(com.fasterxml.jackson.databind.introspect.b r5, java.lang.Object r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof com.fasterxml.jackson.databind.o
            if (r1 == 0) goto L_0x000b
            com.fasterxml.jackson.databind.o r6 = (com.fasterxml.jackson.databind.o) r6
            goto L_0x007c
        L_0x000b:
            boolean r1 = r6 instanceof java.lang.Class
            if (r1 != 0) goto L_0x0034
            com.fasterxml.jackson.databind.j r1 = r5.e()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AnnotationIntrospector returned serializer definition of type "
            r2.append(r3)
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = "; expected type JsonSerializer or Class<JsonSerializer> instead"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r4.j(r1, r2)
        L_0x0034:
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.Class<com.fasterxml.jackson.databind.o$a> r1 = com.fasterxml.jackson.databind.o.a.class
            if (r6 == r1) goto L_0x0081
            boolean r1 = com.fasterxml.jackson.databind.util.f.F(r6)
            if (r1 == 0) goto L_0x0041
            goto L_0x0081
        L_0x0041:
            java.lang.Class<com.fasterxml.jackson.databind.o> r0 = com.fasterxml.jackson.databind.o.class
            boolean r0 = r0.isAssignableFrom(r6)
            if (r0 != 0) goto L_0x006a
            com.fasterxml.jackson.databind.j r5 = r5.e()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r1 = r6.getName()
            r0.append(r1)
            java.lang.String r1 = "; expected Class<JsonSerializer>"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.j(r5, r0)
        L_0x006a:
            com.fasterxml.jackson.databind.z r5 = r4.f5206a
            r5.w()
            com.fasterxml.jackson.databind.z r5 = r4.f5206a
            boolean r5 = r5.b()
            java.lang.Object r5 = com.fasterxml.jackson.databind.util.f.k(r6, r5)
            r6 = r5
            com.fasterxml.jackson.databind.o r6 = (com.fasterxml.jackson.databind.o) r6
        L_0x007c:
            com.fasterxml.jackson.databind.o r5 = r4.q(r6)
            return r5
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.j.i0(com.fasterxml.jackson.databind.introspect.b, java.lang.Object):com.fasterxml.jackson.databind.o");
    }

    /* access modifiers changed from: protected */
    public Map k0() {
        if (b0(a0.USE_EQUALITY_FOR_OBJECT_ID)) {
            return new HashMap();
        }
        return new IdentityHashMap();
    }

    /* access modifiers changed from: protected */
    public void n0(f fVar) {
        try {
            O().f((Object) null, fVar, this);
        } catch (Exception e10) {
            throw o0(fVar, e10);
        }
    }

    public abstract j p0(z zVar, q qVar);

    public void q0(f fVar, Object obj) {
        this.O0 = fVar;
        if (obj == null) {
            n0(fVar);
            return;
        }
        Class<?> cls = obj.getClass();
        o H = H(cls, true, (d) null);
        w S = this.f5206a.S();
        if (S == null) {
            if (this.f5206a.b0(a0.WRAP_ROOT_VALUE)) {
                m0(fVar, obj, H, this.f5206a.K(cls));
                return;
            }
        } else if (!S.h()) {
            m0(fVar, obj, H, S);
            return;
        }
        l0(fVar, obj, H);
    }

    protected j(b0 b0Var, z zVar, q qVar) {
        super(b0Var, zVar, qVar);
    }
}
