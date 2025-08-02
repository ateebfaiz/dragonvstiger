package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.a0;
import com.fasterxml.jackson.annotation.b;
import com.fasterxml.jackson.annotation.b0;
import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.annotation.d;
import com.fasterxml.jackson.annotation.d0;
import com.fasterxml.jackson.annotation.e0;
import com.fasterxml.jackson.annotation.f;
import com.fasterxml.jackson.annotation.f0;
import com.fasterxml.jackson.annotation.g;
import com.fasterxml.jackson.annotation.g0;
import com.fasterxml.jackson.annotation.h;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.k;
import com.fasterxml.jackson.annotation.k0;
import com.fasterxml.jackson.annotation.m;
import com.fasterxml.jackson.annotation.n;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.q;
import com.fasterxml.jackson.annotation.r;
import com.fasterxml.jackson.annotation.s;
import com.fasterxml.jackson.annotation.t;
import com.fasterxml.jackson.annotation.u;
import com.fasterxml.jackson.annotation.v;
import com.fasterxml.jackson.annotation.w;
import com.fasterxml.jackson.annotation.y;
import com.fasterxml.jackson.annotation.z;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.g;
import com.fasterxml.jackson.databind.util.j;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k8.b;
import k8.c;
import k8.e;

public class x extends b implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private static final Class[] f5431c;

    /* renamed from: d  reason: collision with root package name */
    private static final Class[] f5432d;

    /* renamed from: a  reason: collision with root package name */
    protected transient j f5433a = new j(48, 48);

    /* renamed from: b  reason: collision with root package name */
    protected boolean f5434b = true;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5435a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                k8.e$a[] r0 = k8.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5435a = r0
                k8.e$a r1 = k8.e.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5435a     // Catch:{ NoSuchFieldError -> 0x001d }
                k8.e$a r1 = k8.e.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5435a     // Catch:{ NoSuchFieldError -> 0x0028 }
                k8.e$a r1 = k8.e.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5435a     // Catch:{ NoSuchFieldError -> 0x0033 }
                k8.e$a r1 = k8.e.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5435a     // Catch:{ NoSuchFieldError -> 0x003e }
                k8.e$a r1 = k8.e.a.DEFAULT_INCLUSION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.x.a.<clinit>():void");
        }
    }

    static {
        Class<g0> cls = g0.class;
        Class<i> cls2 = i.class;
        Class<c0> cls3 = c0.class;
        Class<e0> cls4 = e0.class;
        Class<f> cls5 = f.class;
        Class<s> cls6 = s.class;
        f5431c = new Class[]{e.class, cls, cls2, cls3, com.fasterxml.jackson.annotation.x.class, cls4, cls5, cls6};
        f5432d = new Class[]{c.class, cls, cls2, cls3, cls4, cls5, cls6, t.class};
        try {
            o8.c.a();
        } catch (Throwable unused) {
        }
    }

    private p.b B0(b bVar, p.b bVar2) {
        e eVar = (e) a(bVar, e.class);
        if (eVar != null) {
            int i10 = a.f5435a[eVar.include().ordinal()];
            if (i10 == 1) {
                return bVar2.o(p.a.ALWAYS);
            }
            if (i10 == 2) {
                return bVar2.o(p.a.NON_NULL);
            }
            if (i10 == 3) {
                return bVar2.o(p.a.NON_DEFAULT);
            }
            if (i10 == 4) {
                return bVar2.o(p.a.NON_EMPTY);
            }
        }
        return bVar2;
    }

    private l t0(String str) {
        return new l((Closeable) null, str);
    }

    private l u0(Throwable th, String str) {
        return new l((Closeable) null, str, th);
    }

    private final Boolean w0(b bVar) {
        w wVar = (w) a(bVar, w.class);
        if (wVar == null || !wVar.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    private boolean z0(Class cls, Class cls2) {
        if (cls.isPrimitive()) {
            if (cls == com.fasterxml.jackson.databind.util.f.S(cls2)) {
                return true;
            }
            return false;
        } else if (!cls2.isPrimitive()) {
            return false;
        } else {
            if (cls2 == com.fasterxml.jackson.databind.util.f.S(cls)) {
                return true;
            }
            return false;
        }
    }

    public String A(b bVar) {
        u uVar = (u) a(bVar, u.class);
        if (uVar == null) {
            return null;
        }
        String defaultValue = uVar.defaultValue();
        if (defaultValue.isEmpty()) {
            return null;
        }
        return defaultValue;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.w A0(String str, String str2) {
        if (str.isEmpty()) {
            return com.fasterxml.jackson.databind.w.f5732d;
        }
        if (str2 == null || str2.isEmpty()) {
            return com.fasterxml.jackson.databind.w.a(str);
        }
        return com.fasterxml.jackson.databind.w.b(str, str2);
    }

    public String B(b bVar) {
        v vVar = (v) a(bVar, v.class);
        if (vVar == null) {
            return null;
        }
        return vVar.value();
    }

    public n.a C(l8.l lVar, b bVar) {
        n nVar = (n) a(bVar, n.class);
        if (nVar == null) {
            return n.a.f();
        }
        return n.a.i(nVar);
    }

    public n.a D(b bVar) {
        return C((l8.l) null, bVar);
    }

    public p.b E(b bVar) {
        p.b bVar2;
        p pVar = (p) a(bVar, p.class);
        if (pVar == null) {
            bVar2 = p.b.c();
        } else {
            bVar2 = p.b.d(pVar);
        }
        if (bVar2.i() == p.a.USE_DEFAULTS) {
            return B0(bVar, bVar2);
        }
        return bVar2;
    }

    public q.a F(l8.l lVar, b bVar) {
        q qVar = (q) a(bVar, q.class);
        if (qVar == null) {
            return q.a.c();
        }
        return q.a.d(qVar);
    }

    public Integer G(b bVar) {
        int index;
        u uVar = (u) a(bVar, u.class);
        if (uVar == null || (index = uVar.index()) == -1) {
            return null;
        }
        return Integer.valueOf(index);
    }

    public q8.f H(l8.l lVar, i iVar, com.fasterxml.jackson.databind.j jVar) {
        if (jVar.C() || jVar.d()) {
            return null;
        }
        return x0(lVar, iVar, jVar);
    }

    public b.a I(i iVar) {
        s sVar = (s) a(iVar, s.class);
        if (sVar != null) {
            return b.a.c(sVar.value());
        }
        f fVar = (f) a(iVar, f.class);
        if (fVar != null) {
            return b.a.a(fVar.value());
        }
        return null;
    }

    public com.fasterxml.jackson.databind.w J(l8.l lVar, g gVar, com.fasterxml.jackson.databind.w wVar) {
        return null;
    }

    public com.fasterxml.jackson.databind.w K(c cVar) {
        y yVar = (y) a(cVar, y.class);
        String str = null;
        if (yVar == null) {
            return null;
        }
        String namespace = yVar.namespace();
        if (namespace == null || !namespace.isEmpty()) {
            str = namespace;
        }
        return com.fasterxml.jackson.databind.w.b(yVar.value(), str);
    }

    public Object L(i iVar) {
        e eVar = (e) a(iVar, e.class);
        if (eVar == null) {
            return null;
        }
        return o0(eVar.contentConverter(), g.a.class);
    }

    public Object M(b bVar) {
        e eVar = (e) a(bVar, e.class);
        if (eVar == null) {
            return null;
        }
        return o0(eVar.converter(), g.a.class);
    }

    public String[] N(c cVar) {
        w wVar = (w) a(cVar, w.class);
        if (wVar == null) {
            return null;
        }
        return wVar.value();
    }

    public Boolean O(b bVar) {
        return w0(bVar);
    }

    public e.b P(b bVar) {
        e eVar = (e) a(bVar, e.class);
        if (eVar == null) {
            return null;
        }
        return eVar.typing();
    }

    public Object Q(b bVar) {
        Class<o.a> using;
        e eVar = (e) a(bVar, e.class);
        if (eVar != null && (using = eVar.using()) != o.a.class) {
            return using;
        }
        com.fasterxml.jackson.annotation.x xVar = (com.fasterxml.jackson.annotation.x) a(bVar, com.fasterxml.jackson.annotation.x.class);
        if (xVar == null || !xVar.value()) {
            return null;
        }
        return new com.fasterxml.jackson.databind.ser.std.y(bVar.d());
    }

    public z.a R(b bVar) {
        return z.a.d((z) a(bVar, z.class));
    }

    public List S(b bVar) {
        a0 a0Var = (a0) a(bVar, a0.class);
        if (a0Var == null) {
            return null;
        }
        a0.a[] value = a0Var.value();
        ArrayList arrayList = new ArrayList(value.length);
        for (a0.a aVar : value) {
            arrayList.add(new q8.b(aVar.value(), aVar.name()));
            for (String bVar2 : aVar.names()) {
                arrayList.add(new q8.b(aVar.value(), bVar2));
            }
        }
        return arrayList;
    }

    public String T(c cVar) {
        d0 d0Var = (d0) a(cVar, d0.class);
        if (d0Var == null) {
            return null;
        }
        return d0Var.value();
    }

    public q8.f U(l8.l lVar, c cVar, com.fasterxml.jackson.databind.j jVar) {
        return x0(lVar, cVar, jVar);
    }

    public com.fasterxml.jackson.databind.util.l V(i iVar) {
        e0 e0Var = (e0) a(iVar, e0.class);
        if (e0Var == null || !e0Var.enabled()) {
            return null;
        }
        return com.fasterxml.jackson.databind.util.l.b(e0Var.prefix(), e0Var.suffix());
    }

    public Class[] W(b bVar) {
        g0 g0Var = (g0) a(bVar, g0.class);
        if (g0Var == null) {
            return null;
        }
        return g0Var.value();
    }

    public Boolean Y(b bVar) {
        com.fasterxml.jackson.annotation.c cVar = (com.fasterxml.jackson.annotation.c) a(bVar, com.fasterxml.jackson.annotation.c.class);
        if (cVar == null) {
            return null;
        }
        return Boolean.valueOf(cVar.enabled());
    }

    public boolean Z(j jVar) {
        return b(jVar, com.fasterxml.jackson.annotation.c.class);
    }

    public Boolean a0(b bVar) {
        d dVar = (d) a(bVar, d.class);
        if (dVar == null) {
            return null;
        }
        return Boolean.valueOf(dVar.enabled());
    }

    public Boolean b0(l8.l lVar, b bVar) {
        r rVar = (r) a(bVar, r.class);
        if (rVar == null) {
            return null;
        }
        return Boolean.valueOf(rVar.value());
    }

    public Boolean c0(b bVar) {
        f0 f0Var = (f0) a(bVar, f0.class);
        if (f0Var == null) {
            return null;
        }
        return Boolean.valueOf(f0Var.value());
    }

    public void d(l8.l lVar, c cVar, List list) {
        k8.b bVar = (k8.b) a(cVar, k8.b.class);
        if (bVar != null) {
            boolean prepend = bVar.prepend();
            b.a[] attrs = bVar.attrs();
            int length = attrs.length;
            com.fasterxml.jackson.databind.j jVar = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (jVar == null) {
                    jVar = lVar.e(Object.class);
                }
                com.fasterxml.jackson.databind.ser.c r02 = r0(attrs[i10], lVar, cVar, jVar);
                if (prepend) {
                    list.add(i10, r02);
                } else {
                    list.add(r02);
                }
            }
            b.C0148b[] props = bVar.props();
            int length2 = props.length;
            for (int i11 = 0; i11 < length2; i11++) {
                com.fasterxml.jackson.databind.ser.c s02 = s0(props[i11], lVar, cVar);
                if (prepend) {
                    list.add(i11, s02);
                } else {
                    list.add(s02);
                }
            }
        }
    }

    public boolean d0(j jVar) {
        f0 f0Var = (f0) a(jVar, f0.class);
        if (f0Var == null || !f0Var.value()) {
            return false;
        }
        return true;
    }

    public j0 e(c cVar, j0 j0Var) {
        com.fasterxml.jackson.annotation.e eVar = (com.fasterxml.jackson.annotation.e) a(cVar, com.fasterxml.jackson.annotation.e.class);
        if (eVar == null) {
            return j0Var;
        }
        return j0Var.f(eVar);
    }

    public boolean e0(b bVar) {
        com.fasterxml.jackson.annotation.g gVar = (com.fasterxml.jackson.annotation.g) a(bVar, com.fasterxml.jackson.annotation.g.class);
        if (gVar == null) {
            if (this.f5434b) {
                boolean z10 = bVar instanceof e;
            }
            return false;
        } else if (gVar.mode() != g.a.DISABLED) {
            return true;
        } else {
            return false;
        }
    }

    public Object f(b bVar) {
        Class<o.a> contentUsing;
        e eVar = (e) a(bVar, e.class);
        if (eVar == null || (contentUsing = eVar.contentUsing()) == o.a.class) {
            return null;
        }
        return contentUsing;
    }

    public boolean f0(i iVar) {
        return y0(iVar);
    }

    public Boolean g0(i iVar) {
        u uVar = (u) a(iVar, u.class);
        if (uVar != null) {
            return Boolean.valueOf(uVar.required());
        }
        return null;
    }

    public g.a h(l8.l lVar, b bVar) {
        com.fasterxml.jackson.annotation.g gVar = (com.fasterxml.jackson.annotation.g) a(bVar, com.fasterxml.jackson.annotation.g.class);
        if (gVar != null) {
            return gVar.mode();
        }
        if (!this.f5434b || !lVar.F(com.fasterxml.jackson.databind.q.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)) {
            return null;
        }
        boolean z10 = bVar instanceof e;
        return null;
    }

    public boolean h0(Annotation annotation) {
        boolean z10;
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Boolean bool = (Boolean) this.f5433a.get(annotationType);
        if (bool == null) {
            if (annotationType.getAnnotation(com.fasterxml.jackson.annotation.a.class) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            bool = Boolean.valueOf(z10);
            this.f5433a.putIfAbsent(annotationType, bool);
        }
        return bool.booleanValue();
    }

    public g.a i(b bVar) {
        com.fasterxml.jackson.annotation.g gVar = (com.fasterxml.jackson.annotation.g) a(bVar, com.fasterxml.jackson.annotation.g.class);
        if (gVar == null) {
            return null;
        }
        return gVar.mode();
    }

    public Boolean i0(c cVar) {
        com.fasterxml.jackson.annotation.o oVar = (com.fasterxml.jackson.annotation.o) a(cVar, com.fasterxml.jackson.annotation.o.class);
        if (oVar == null) {
            return null;
        }
        return Boolean.valueOf(oVar.value());
    }

    public String[] j(Class cls, Enum[] enumArr, String[] strArr) {
        u uVar;
        HashMap hashMap = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (uVar = (u) field.getAnnotation(u.class)) != null) {
                String value = uVar.value();
                if (!value.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(field.getName(), value);
                }
            }
        }
        if (hashMap != null) {
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str = (String) hashMap.get(enumArr[i10].name());
                if (str != null) {
                    strArr[i10] = str;
                }
            }
        }
        return strArr;
    }

    public Boolean j0(i iVar) {
        return Boolean.valueOf(b(iVar, b0.class));
    }

    public Object k(b bVar) {
        h hVar = (h) a(bVar, h.class);
        if (hVar == null) {
            return null;
        }
        String value = hVar.value();
        if (!value.isEmpty()) {
            return value;
        }
        return null;
    }

    public i.d l(b bVar) {
        i iVar = (i) a(bVar, i.class);
        if (iVar == null) {
            return null;
        }
        return i.d.d(iVar);
    }

    public com.fasterxml.jackson.databind.j l0(l8.l lVar, b bVar, com.fasterxml.jackson.databind.j jVar) {
        Class cls;
        com.fasterxml.jackson.databind.j jVar2;
        Class cls2;
        com.fasterxml.jackson.databind.j jVar3;
        com.fasterxml.jackson.databind.type.o B = lVar.B();
        e eVar = (e) a(bVar, e.class);
        Class cls3 = null;
        if (eVar == null) {
            cls = null;
        } else {
            cls = n0(eVar.as());
        }
        if (cls != null) {
            if (jVar.z(cls)) {
                jVar = jVar.S();
            } else {
                Class s10 = jVar.s();
                try {
                    if (cls.isAssignableFrom(s10)) {
                        jVar = B.z(jVar, cls);
                    } else if (s10.isAssignableFrom(cls)) {
                        jVar = B.C(jVar, cls);
                    } else if (z0(s10, cls)) {
                        jVar = jVar.S();
                    } else {
                        throw t0(String.format("Cannot refine serialization type %s into %s; types not related", new Object[]{jVar, cls.getName()}));
                    }
                } catch (IllegalArgumentException e10) {
                    throw u0(e10, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{jVar, cls.getName(), bVar.c(), e10.getMessage()}));
                }
            }
        }
        if (jVar.I()) {
            com.fasterxml.jackson.databind.j q10 = jVar.q();
            if (eVar == null) {
                cls2 = null;
            } else {
                cls2 = n0(eVar.keyAs());
            }
            if (cls2 != null) {
                if (q10.z(cls2)) {
                    jVar3 = q10.S();
                } else {
                    Class s11 = q10.s();
                    try {
                        if (cls2.isAssignableFrom(s11)) {
                            jVar3 = B.z(q10, cls2);
                        } else if (s11.isAssignableFrom(cls2)) {
                            jVar3 = B.C(q10, cls2);
                        } else if (z0(s11, cls2)) {
                            jVar3 = q10.S();
                        } else {
                            throw t0(String.format("Cannot refine serialization key type %s into %s; types not related", new Object[]{q10, cls2.getName()}));
                        }
                    } catch (IllegalArgumentException e11) {
                        throw u0(e11, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls2.getName(), bVar.c(), e11.getMessage()}));
                    }
                }
                jVar = ((com.fasterxml.jackson.databind.type.g) jVar).Y(jVar3);
            }
        }
        com.fasterxml.jackson.databind.j l10 = jVar.l();
        if (l10 == null) {
            return jVar;
        }
        if (eVar != null) {
            cls3 = n0(eVar.contentAs());
        }
        if (cls3 == null) {
            return jVar;
        }
        if (l10.z(cls3)) {
            jVar2 = l10.S();
        } else {
            Class s12 = l10.s();
            try {
                if (cls3.isAssignableFrom(s12)) {
                    jVar2 = B.z(l10, cls3);
                } else if (s12.isAssignableFrom(cls3)) {
                    jVar2 = B.C(l10, cls3);
                } else if (z0(s12, cls3)) {
                    jVar2 = l10.S();
                } else {
                    throw t0(String.format("Cannot refine serialization content type %s into %s; types not related", new Object[]{l10, cls3.getName()}));
                }
            } catch (IllegalArgumentException e12) {
                throw u0(e12, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{jVar, cls3.getName(), bVar.c(), e12.getMessage()}));
            }
        }
        return jVar.P(jVar2);
    }

    public String m(i iVar) {
        com.fasterxml.jackson.databind.w v02 = v0(iVar);
        if (v02 == null) {
            return null;
        }
        return v02.c();
    }

    public j m0(l8.l lVar, j jVar, j jVar2) {
        Class<String> x10 = jVar.x(0);
        Class<String> x11 = jVar2.x(0);
        if (x10.isPrimitive()) {
            if (!x11.isPrimitive()) {
                return jVar;
            }
            return null;
        } else if (x11.isPrimitive()) {
            return jVar2;
        } else {
            Class<String> cls = String.class;
            if (x10 == cls) {
                if (x11 != cls) {
                    return jVar;
                }
            } else if (x11 == cls) {
                return jVar2;
            }
            return null;
        }
    }

    public b.a n(i iVar) {
        String str;
        com.fasterxml.jackson.annotation.b bVar = (com.fasterxml.jackson.annotation.b) a(iVar, com.fasterxml.jackson.annotation.b.class);
        if (bVar == null) {
            return null;
        }
        b.a d10 = b.a.d(bVar);
        if (d10.f()) {
            return d10;
        }
        if (!(iVar instanceof j)) {
            str = iVar.d().getName();
        } else {
            j jVar = (j) iVar;
            if (jVar.w() == 0) {
                str = iVar.d().getName();
            } else {
                str = jVar.x(0).getName();
            }
        }
        return d10.h(str);
    }

    /* access modifiers changed from: protected */
    public Class n0(Class cls) {
        if (cls == null || com.fasterxml.jackson.databind.util.f.F(cls)) {
            return null;
        }
        return cls;
    }

    public Object o(i iVar) {
        b.a n10 = n(iVar);
        if (n10 == null) {
            return null;
        }
        return n10.e();
    }

    /* access modifiers changed from: protected */
    public Class o0(Class cls, Class cls2) {
        Class n02 = n0(cls);
        if (n02 == null || n02 == cls2) {
            return null;
        }
        return n02;
    }

    public Object p(b bVar) {
        Class<o.a> keyUsing;
        e eVar = (e) a(bVar, e.class);
        if (eVar == null || (keyUsing = eVar.keyUsing()) == o.a.class) {
            return null;
        }
        return keyUsing;
    }

    /* access modifiers changed from: protected */
    public r8.j p0() {
        return r8.j.l();
    }

    public Boolean q(b bVar) {
        t tVar = (t) a(bVar, t.class);
        if (tVar == null) {
            return null;
        }
        return tVar.value().a();
    }

    /* access modifiers changed from: protected */
    public r8.j q0() {
        return new r8.j();
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.ser.c r0(b.a aVar, l8.l lVar, c cVar, com.fasterxml.jackson.databind.j jVar) {
        com.fasterxml.jackson.databind.v vVar;
        if (aVar.required()) {
            vVar = com.fasterxml.jackson.databind.v.f5720h;
        } else {
            vVar = com.fasterxml.jackson.databind.v.f5721i;
        }
        String value = aVar.value();
        com.fasterxml.jackson.databind.w A0 = A0(aVar.propName(), aVar.propNamespace());
        if (!A0.e()) {
            A0 = com.fasterxml.jackson.databind.w.a(value);
        }
        return t8.a.G(value, com.fasterxml.jackson.databind.util.n.s(lVar, new i0(cVar, cVar.d(), value, jVar), A0, vVar, aVar.include()), cVar.n(), jVar);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this.f5433a == null) {
            this.f5433a = new j(48, 48);
        }
        return this;
    }

    public com.fasterxml.jackson.databind.w s(b bVar) {
        boolean z10;
        z zVar = (z) a(bVar, z.class);
        if (zVar != null) {
            String value = zVar.value();
            if (!value.isEmpty()) {
                return com.fasterxml.jackson.databind.w.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        u uVar = (u) a(bVar, u.class);
        String str = null;
        if (uVar != null) {
            String namespace = uVar.namespace();
            if (namespace == null || !namespace.isEmpty()) {
                str = namespace;
            }
            return com.fasterxml.jackson.databind.w.b(uVar.value(), str);
        } else if (z10 || c(bVar, f5432d)) {
            return com.fasterxml.jackson.databind.w.f5732d;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.ser.c s0(b.C0148b bVar, l8.l lVar, c cVar) {
        com.fasterxml.jackson.databind.v vVar;
        if (bVar.required()) {
            vVar = com.fasterxml.jackson.databind.v.f5720h;
        } else {
            vVar = com.fasterxml.jackson.databind.v.f5721i;
        }
        com.fasterxml.jackson.databind.w A0 = A0(bVar.name(), bVar.namespace());
        com.fasterxml.jackson.databind.j e10 = lVar.e(bVar.type());
        com.fasterxml.jackson.databind.util.n s10 = com.fasterxml.jackson.databind.util.n.s(lVar, new i0(cVar, cVar.d(), A0.c(), e10), A0, vVar, bVar.include());
        Class value = bVar.value();
        lVar.w();
        return ((com.fasterxml.jackson.databind.ser.s) com.fasterxml.jackson.databind.util.f.k(value, lVar.b())).F(lVar, cVar, s10, e10);
    }

    public com.fasterxml.jackson.databind.w t(b bVar) {
        boolean z10;
        com.fasterxml.jackson.annotation.j jVar = (com.fasterxml.jackson.annotation.j) a(bVar, com.fasterxml.jackson.annotation.j.class);
        if (jVar != null) {
            String value = jVar.value();
            if (!value.isEmpty()) {
                return com.fasterxml.jackson.databind.w.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        u uVar = (u) a(bVar, u.class);
        String str = null;
        if (uVar != null) {
            String namespace = uVar.namespace();
            if (namespace == null || !namespace.isEmpty()) {
                str = namespace;
            }
            return com.fasterxml.jackson.databind.w.b(uVar.value(), str);
        } else if (z10 || c(bVar, f5431c)) {
            return com.fasterxml.jackson.databind.w.f5732d;
        } else {
            return null;
        }
    }

    public Object u(c cVar) {
        k8.d dVar = (k8.d) a(cVar, k8.d.class);
        if (dVar == null) {
            return null;
        }
        return dVar.value();
    }

    public Object v(b bVar) {
        Class<o.a> nullsUsing;
        e eVar = (e) a(bVar, e.class);
        if (eVar == null || (nullsUsing = eVar.nullsUsing()) == o.a.class) {
            return null;
        }
        return nullsUsing;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.w v0(b bVar) {
        if (!(bVar instanceof m)) {
            return null;
        }
        ((m) bVar).q();
        return null;
    }

    public b0 w(b bVar) {
        k kVar = (k) a(bVar, k.class);
        if (kVar == null || kVar.generator() == k0.class) {
            return null;
        }
        return new b0(com.fasterxml.jackson.databind.w.a(kVar.property()), kVar.scope(), kVar.generator(), kVar.resolver());
    }

    public b0 x(b bVar, b0 b0Var) {
        com.fasterxml.jackson.annotation.l lVar = (com.fasterxml.jackson.annotation.l) a(bVar, com.fasterxml.jackson.annotation.l.class);
        if (lVar == null) {
            return b0Var;
        }
        if (b0Var == null) {
            b0Var = b0.a();
        }
        return b0Var.f(lVar.alwaysAsId());
    }

    /* access modifiers changed from: protected */
    public q8.f x0(l8.l lVar, b bVar, com.fasterxml.jackson.databind.j jVar) {
        q8.f fVar;
        c0 c0Var = (c0) a(bVar, c0.class);
        k8.g gVar = (k8.g) a(bVar, k8.g.class);
        q8.e eVar = null;
        if (gVar != null) {
            if (c0Var == null) {
                return null;
            }
            fVar = lVar.I(bVar, gVar.value());
        } else if (c0Var == null) {
            return null;
        } else {
            if (c0Var.use() == c0.b.NONE) {
                return p0();
            }
            fVar = q0();
        }
        k8.f fVar2 = (k8.f) a(bVar, k8.f.class);
        if (fVar2 != null) {
            eVar = lVar.H(bVar, fVar2.value());
        }
        if (eVar != null) {
            eVar.b(jVar);
        }
        q8.f f10 = fVar.f(c0Var.use(), eVar);
        c0.a include = c0Var.include();
        if (include == c0.a.EXTERNAL_PROPERTY && (bVar instanceof c)) {
            include = c0.a.PROPERTY;
        }
        q8.f b10 = f10.e(include).b(c0Var.property());
        Class<c0.c> defaultImpl = c0Var.defaultImpl();
        if (defaultImpl != c0.c.class && !defaultImpl.isAnnotation()) {
            b10 = b10.c(defaultImpl);
        }
        return b10.a(c0Var.visible());
    }

    public u.a y(b bVar) {
        u uVar = (u) a(bVar, u.class);
        if (uVar != null) {
            return uVar.access();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean y0(b bVar) {
        m mVar = (m) a(bVar, m.class);
        if (mVar != null) {
            return mVar.value();
        }
        return false;
    }

    public q8.f z(l8.l lVar, i iVar, com.fasterxml.jackson.databind.j jVar) {
        if (jVar.l() != null) {
            return x0(lVar, iVar, jVar);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + jVar + ")");
    }
}
