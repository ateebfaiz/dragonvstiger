package com.fasterxml.jackson.databind.type;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.m;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.util.k;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class o implements Serializable {
    private static final Class C;
    private static final Class N0;
    protected static final l O0;
    protected static final l P0;
    protected static final l Q0;
    protected static final l R0;
    protected static final l S0;
    protected static final l T0;
    protected static final l U0;
    protected static final l V0;
    protected static final l W0;
    private static final Class X;
    private static final Class Y;
    private static final Class Z;

    /* renamed from: e  reason: collision with root package name */
    private static final j[] f5653e = new j[0];

    /* renamed from: f  reason: collision with root package name */
    protected static final o f5654f = new o();

    /* renamed from: g  reason: collision with root package name */
    protected static final n f5655g = n.i();

    /* renamed from: h  reason: collision with root package name */
    private static final Class f5656h;

    /* renamed from: i  reason: collision with root package name */
    private static final Class f5657i;

    /* renamed from: j  reason: collision with root package name */
    private static final Class f5658j;

    /* renamed from: w  reason: collision with root package name */
    private static final Class f5659w;

    /* renamed from: a  reason: collision with root package name */
    protected final k f5660a;

    /* renamed from: b  reason: collision with root package name */
    protected final p[] f5661b;

    /* renamed from: c  reason: collision with root package name */
    protected final q f5662c;

    /* renamed from: d  reason: collision with root package name */
    protected final ClassLoader f5663d;

    static {
        Class<String> cls = String.class;
        f5656h = cls;
        Class<Object> cls2 = Object.class;
        f5657i = cls2;
        Class<Comparable> cls3 = Comparable.class;
        f5658j = cls3;
        Class<Class> cls4 = Class.class;
        f5659w = cls4;
        Class<Enum> cls5 = Enum.class;
        C = cls5;
        Class<m> cls6 = m.class;
        X = cls6;
        Class cls7 = Boolean.TYPE;
        Y = cls7;
        Class cls8 = Integer.TYPE;
        Z = cls8;
        Class cls9 = Long.TYPE;
        N0 = cls9;
        O0 = new l(cls7);
        P0 = new l(cls8);
        Q0 = new l(cls9);
        R0 = new l(cls);
        S0 = new l(cls2);
        T0 = new l(cls3);
        U0 = new l(cls5);
        V0 = new l(cls4);
        W0 = new l(cls6);
    }

    private o() {
        this((k) null);
    }

    public static o F() {
        return f5654f;
    }

    public static j J() {
        return F().v();
    }

    private n b(j jVar, int i10, Class cls, boolean z10) {
        i[] iVarArr = new i[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iVarArr[i11] = new i(i11);
        }
        j j10 = i((c) null, cls, n.d(cls, iVarArr)).j(jVar.s());
        if (j10 != null) {
            String u10 = u(jVar, j10);
            if (u10 == null || z10) {
                j[] jVarArr = new j[i10];
                for (int i12 = 0; i12 < i10; i12++) {
                    j Z2 = iVarArr[i12].Z();
                    if (Z2 == null) {
                        Z2 = J();
                    }
                    jVarArr[i12] = Z2;
                }
                return n.d(cls, jVarArr);
            }
            throw new IllegalArgumentException("Failed to specialize base type " + jVar.e() + " as " + cls.getName() + ", problem: " + u10);
        }
        throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", new Object[]{jVar.s().getName(), cls.getName()}));
    }

    private j c(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = v();
        } else if (l10.size() == 1) {
            jVar2 = (j) l10.get(0);
        } else {
            throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": cannot determine type parameters");
        }
        return e.Y(cls, nVar, jVar, jVarArr, jVar2);
    }

    private j o(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        j jVar3;
        j v10;
        String str;
        if (cls == Properties.class) {
            v10 = R0;
        } else {
            List l10 = nVar.l();
            int size = l10.size();
            if (size == 0) {
                v10 = v();
            } else if (size != 2) {
                String Q = f.Q(cls);
                Integer valueOf = Integer.valueOf(size);
                if (size == 1) {
                    str = "";
                } else {
                    str = DomainUhfReportModel.SCENE;
                }
                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", new Object[]{Q, valueOf, str, nVar}));
            } else {
                jVar3 = (j) l10.get(0);
                jVar2 = (j) l10.get(1);
                return h.Z(cls, nVar, jVar, jVarArr, jVar3, jVar2);
            }
        }
        jVar3 = v10;
        jVar2 = jVar3;
        return h.Z(cls, nVar, jVar, jVarArr, jVar3, jVar2);
    }

    private j q(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = v();
        } else if (l10.size() == 1) {
            jVar2 = (j) l10.get(0);
        } else {
            throw new IllegalArgumentException("Strange Reference type " + cls.getName() + ": cannot determine type parameters");
        }
        return j.c0(cls, nVar, jVar, jVarArr, jVar2);
    }

    private String u(j jVar, j jVar2) {
        j jVar3;
        List l10 = jVar.k().l();
        List l11 = jVar2.k().l();
        int size = l11.size();
        int size2 = l10.size();
        for (int i10 = 0; i10 < size2; i10++) {
            j jVar4 = (j) l10.get(i10);
            if (i10 < size) {
                jVar3 = (j) l11.get(i10);
            } else {
                jVar3 = J();
            }
            if (!w(jVar4, jVar3)) {
                Class<Object> cls = Object.class;
                if (!jVar4.z(cls) && ((i10 != 0 || !jVar.I() || !jVar3.z(cls)) && (!jVar4.G() || !jVar4.M(jVar3.s())))) {
                    return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", new Object[]{Integer.valueOf(i10 + 1), Integer.valueOf(size2), jVar4.e(), jVar3.e()});
                }
            }
        }
        return null;
    }

    private boolean w(j jVar, j jVar2) {
        if (jVar2 instanceof i) {
            ((i) jVar2).a0(jVar);
            return true;
        } else if (jVar.s() != jVar2.s()) {
            return false;
        } else {
            List l10 = jVar.k().l();
            List l11 = jVar2.k().l();
            int size = l10.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!w((j) l10.get(i10), (j) l11.get(i10))) {
                    return false;
                }
            }
            return true;
        }
    }

    public h A(Class cls, j jVar, j jVar2) {
        n h10 = n.h(cls, new j[]{jVar, jVar2});
        h hVar = (h) i((c) null, cls, h10);
        if (h10.n()) {
            j j10 = hVar.j(Map.class);
            j q10 = j10.q();
            if (q10.equals(jVar)) {
                j l10 = j10.l();
                if (!l10.equals(jVar2)) {
                    throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", new Object[]{f.Q(cls), jVar2, l10}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", new Object[]{f.Q(cls), jVar, q10}));
            }
        }
        return hVar;
    }

    public h B(Class cls, Class cls2, Class cls3) {
        j jVar;
        j jVar2;
        if (cls == Properties.class) {
            jVar2 = R0;
            jVar = jVar2;
        } else {
            n nVar = f5655g;
            jVar2 = i((c) null, cls2, nVar);
            jVar = i((c) null, cls3, nVar);
        }
        return A(cls, jVar2, jVar);
    }

    public j C(j jVar, Class cls) {
        return D(jVar, cls, false);
    }

    public j D(j jVar, Class cls, boolean z10) {
        j jVar2;
        Class<EnumSet> s10 = jVar.s();
        if (s10 == cls) {
            return jVar;
        }
        if (s10 == Object.class) {
            jVar2 = i((c) null, cls, f5655g);
        } else if (s10.isAssignableFrom(cls)) {
            if (jVar.C()) {
                if (jVar.I()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        jVar2 = i((c) null, cls, n.c(cls, jVar.q(), jVar.l()));
                    }
                } else if (jVar.B()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        jVar2 = i((c) null, cls, n.b(cls, jVar.l()));
                    } else if (s10 == EnumSet.class) {
                        return jVar;
                    }
                }
            }
            if (jVar.k().n()) {
                jVar2 = i((c) null, cls, f5655g);
            } else {
                int length = cls.getTypeParameters().length;
                if (length == 0) {
                    jVar2 = i((c) null, cls, f5655g);
                } else {
                    jVar2 = i((c) null, cls, b(jVar, length, cls, z10));
                }
            }
        } else {
            throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{f.Q(cls), f.C(jVar)}));
        }
        return jVar2.R(jVar);
    }

    public j E(Type type) {
        return f((c) null, type, f5655g);
    }

    public j[] G(j jVar, Class cls) {
        j j10 = jVar.j(cls);
        if (j10 == null) {
            return f5653e;
        }
        return j10.k().p();
    }

    public j H(Type type, n nVar) {
        return f((c) null, type, nVar);
    }

    public j I(Class cls) {
        return d(cls, f5655g, (j) null, (j[]) null);
    }

    /* access modifiers changed from: protected */
    public j a(Type type, j jVar) {
        if (this.f5661b == null) {
            return jVar;
        }
        jVar.k();
        p[] pVarArr = this.f5661b;
        if (pVarArr.length <= 0) {
            return jVar;
        }
        p pVar = pVarArr[0];
        throw null;
    }

    /* access modifiers changed from: protected */
    public j d(Class cls, n nVar, j jVar, j[] jVarArr) {
        j e10;
        if (!nVar.n() || (e10 = e(cls)) == null) {
            return p(cls, nVar, jVar, jVarArr);
        }
        return e10;
    }

    /* access modifiers changed from: protected */
    public j e(Class cls) {
        if (cls.isPrimitive()) {
            if (cls == Y) {
                return O0;
            }
            if (cls == Z) {
                return P0;
            }
            if (cls == N0) {
                return Q0;
            }
            return null;
        } else if (cls == f5656h) {
            return R0;
        } else {
            if (cls == f5657i) {
                return S0;
            }
            if (cls == X) {
                return W0;
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public j f(c cVar, Type type, n nVar) {
        j jVar;
        String str;
        if (type instanceof Class) {
            jVar = i(cVar, (Class) type, f5655g);
        } else if (type instanceof ParameterizedType) {
            jVar = j(cVar, (ParameterizedType) type, nVar);
        } else if (type instanceof j) {
            return (j) type;
        } else {
            if (type instanceof GenericArrayType) {
                jVar = h(cVar, (GenericArrayType) type, nVar);
            } else if (type instanceof TypeVariable) {
                jVar = k(cVar, (TypeVariable) type, nVar);
            } else if (type instanceof WildcardType) {
                jVar = n(cVar, (WildcardType) type, nVar);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unrecognized Type: ");
                if (type == null) {
                    str = "[null]";
                } else {
                    str = type.toString();
                }
                sb2.append(str);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return a(type, jVar);
    }

    /* access modifiers changed from: protected */
    public j h(c cVar, GenericArrayType genericArrayType, n nVar) {
        return a.Y(f(cVar, genericArrayType.getGenericComponentType(), nVar), nVar);
    }

    /* access modifiers changed from: protected */
    public j i(c cVar, Class cls, n nVar) {
        Object obj;
        c cVar2;
        j jVar;
        j s10;
        j[] t10;
        j e10 = e(cls);
        if (e10 != null) {
            return e10;
        }
        if (nVar == null || nVar.n()) {
            obj = cls;
        } else {
            obj = nVar.a(cls);
        }
        j jVar2 = (j) this.f5660a.get(obj);
        if (jVar2 != null) {
            return jVar2;
        }
        if (cVar == null) {
            cVar2 = new c(cls);
        } else {
            c c10 = cVar.c(cls);
            if (c10 != null) {
                k kVar = new k(cls, f5655g);
                c10.a(kVar);
                return kVar;
            }
            cVar2 = cVar.b(cls);
        }
        if (cls.isArray()) {
            jVar = a.Y(f(cVar2, cls.getComponentType(), nVar), nVar);
        } else {
            if (cls.isInterface()) {
                t10 = t(cVar2, cls, nVar);
                s10 = null;
            } else {
                s10 = s(cVar2, cls, nVar);
                t10 = t(cVar2, cls, nVar);
            }
            j[] jVarArr = t10;
            j jVar3 = s10;
            if (cls == Properties.class) {
                l lVar = R0;
                jVar2 = h.Z(cls, nVar, jVar3, jVarArr, lVar, lVar);
            } else if (jVar3 != null) {
                jVar2 = jVar3.N(cls, nVar, jVar3, jVarArr);
            }
            if (jVar2 == null && (jVar2 = l(cVar2, cls, nVar, jVar3, jVarArr)) == null && (jVar2 = m(cVar2, cls, nVar, jVar3, jVarArr)) == null) {
                jVar = p(cls, nVar, jVar3, jVarArr);
            } else {
                jVar = jVar2;
            }
        }
        cVar2.d(jVar);
        if (!jVar.y()) {
            this.f5660a.putIfAbsent(obj, jVar);
        }
        return jVar;
    }

    /* access modifiers changed from: protected */
    public j j(c cVar, ParameterizedType parameterizedType, n nVar) {
        int i10;
        n nVar2;
        Class cls = (Class) parameterizedType.getRawType();
        if (cls == C) {
            return U0;
        }
        if (cls == f5658j) {
            return T0;
        }
        if (cls == f5659w) {
            return V0;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments == null) {
            i10 = 0;
        } else {
            i10 = actualTypeArguments.length;
        }
        if (i10 == 0) {
            nVar2 = f5655g;
        } else {
            j[] jVarArr = new j[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                jVarArr[i11] = f(cVar, actualTypeArguments[i11], nVar);
            }
            nVar2 = n.d(cls, jVarArr);
        }
        return i(cVar, cls, nVar2);
    }

    /* access modifiers changed from: protected */
    public j k(c cVar, TypeVariable typeVariable, n nVar) {
        Type[] bounds;
        String name = typeVariable.getName();
        if (nVar != null) {
            j j10 = nVar.j(name);
            if (j10 != null) {
                return j10;
            }
            if (nVar.m(name)) {
                return S0;
            }
            n q10 = nVar.q(name);
            synchronized (typeVariable) {
                bounds = typeVariable.getBounds();
            }
            return f(cVar, bounds[0], q10);
        }
        throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + name + "\")");
    }

    /* access modifiers changed from: protected */
    public j l(c cVar, Class cls, n nVar, j jVar, j[] jVarArr) {
        if (nVar == null) {
            nVar = f5655g;
        }
        if (cls == Map.class) {
            return o(cls, nVar, jVar, jVarArr);
        }
        if (cls == Collection.class) {
            return c(cls, nVar, jVar, jVarArr);
        }
        if (cls == AtomicReference.class) {
            return q(cls, nVar, jVar, jVarArr);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public j m(c cVar, Class cls, n nVar, j jVar, j[] jVarArr) {
        for (j N : jVarArr) {
            j N2 = N.N(cls, nVar, jVar, jVarArr);
            if (N2 != null) {
                return N2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public j n(c cVar, WildcardType wildcardType, n nVar) {
        return f(cVar, wildcardType.getUpperBounds()[0], nVar);
    }

    /* access modifiers changed from: protected */
    public j p(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new l(cls, nVar, jVar, jVarArr);
    }

    /* access modifiers changed from: protected */
    public j s(c cVar, Class cls, n nVar) {
        Type z10 = f.z(cls);
        if (z10 == null) {
            return null;
        }
        return f(cVar, z10, nVar);
    }

    /* access modifiers changed from: protected */
    public j[] t(c cVar, Class cls, n nVar) {
        Type[] y10 = f.y(cls);
        if (y10 == null || y10.length == 0) {
            return f5653e;
        }
        int length = y10.length;
        j[] jVarArr = new j[length];
        for (int i10 = 0; i10 < length; i10++) {
            jVarArr[i10] = f(cVar, y10[i10], nVar);
        }
        return jVarArr;
    }

    /* access modifiers changed from: protected */
    public j v() {
        return S0;
    }

    public e x(Class cls, j jVar) {
        n f10 = n.f(cls, jVar);
        e eVar = (e) i((c) null, cls, f10);
        if (f10.n() && jVar != null) {
            j l10 = eVar.j(Collection.class).l();
            if (!l10.equals(jVar)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", new Object[]{f.Q(cls), jVar, l10}));
            }
        }
        return eVar;
    }

    public e y(Class cls, Class cls2) {
        return x(cls, i((c) null, cls2, f5655g));
    }

    public j z(j jVar, Class cls) {
        Class s10 = jVar.s();
        if (s10 == cls) {
            return jVar;
        }
        j j10 = jVar.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (!cls.isAssignableFrom(s10)) {
            throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", new Object[]{cls.getName(), jVar}));
        }
        throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", new Object[]{cls.getName(), jVar}));
    }

    protected o(k kVar) {
        this.f5660a = kVar == null ? new com.fasterxml.jackson.databind.util.j(16, 200) : kVar;
        this.f5662c = new q(this);
        this.f5661b = null;
        this.f5663d = null;
    }
}
