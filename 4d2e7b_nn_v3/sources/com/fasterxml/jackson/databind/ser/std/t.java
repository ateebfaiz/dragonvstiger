package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.i;
import i8.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import q8.g;
import t8.k;

public class t extends h implements i {
    protected static final j P0 = o.J();
    public static final Object Q0 = p.a.NON_EMPTY;
    protected final Set C;
    protected final i.a N0;
    protected final boolean O0;
    protected final Object X;
    protected final Object Y;
    protected final boolean Z;

    /* renamed from: c  reason: collision with root package name */
    protected final d f5575c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f5576d;

    /* renamed from: e  reason: collision with root package name */
    protected final j f5577e;

    /* renamed from: f  reason: collision with root package name */
    protected final j f5578f;

    /* renamed from: g  reason: collision with root package name */
    protected com.fasterxml.jackson.databind.o f5579g;

    /* renamed from: h  reason: collision with root package name */
    protected com.fasterxml.jackson.databind.o f5580h;

    /* renamed from: i  reason: collision with root package name */
    protected final g f5581i;

    /* renamed from: j  reason: collision with root package name */
    protected k f5582j;

    /* renamed from: w  reason: collision with root package name */
    protected final Set f5583w;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5584a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.p$a[] r0 = com.fasterxml.jackson.annotation.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5584a = r0
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5584a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5584a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5584a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5584a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5584a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.a.<clinit>():void");
        }
    }

    protected t(Set set, Set set2, j jVar, j jVar2, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar, com.fasterxml.jackson.databind.o oVar2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f5583w = set;
        this.C = set2;
        this.f5577e = jVar;
        this.f5578f = jVar2;
        this.f5576d = z10;
        this.f5581i = gVar;
        this.f5579g = oVar;
        this.f5580h = oVar2;
        this.f5582j = k.c();
        this.f5575c = null;
        this.X = null;
        this.O0 = false;
        this.Y = null;
        this.Z = false;
        this.N0 = com.fasterxml.jackson.databind.util.i.a(set, set2);
    }

    private final com.fasterxml.jackson.databind.o C(b0 b0Var, Object obj) {
        Class<?> cls = obj.getClass();
        com.fasterxml.jackson.databind.o j10 = this.f5582j.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5578f.x()) {
            return A(this.f5582j, b0Var.t(this.f5578f, cls), b0Var);
        }
        return B(this.f5582j, cls, b0Var);
    }

    public static t H(Set set, j jVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar, com.fasterxml.jackson.databind.o oVar2, Object obj) {
        return I(set, (Set) null, jVar, z10, gVar, oVar, oVar2, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.ser.std.t I(java.util.Set r12, java.util.Set r13, com.fasterxml.jackson.databind.j r14, boolean r15, q8.g r16, com.fasterxml.jackson.databind.o r17, com.fasterxml.jackson.databind.o r18, java.lang.Object r19) {
        /*
            r0 = r14
            r1 = r19
            if (r0 != 0) goto L_0x000a
            com.fasterxml.jackson.databind.j r0 = P0
            r6 = r0
            r7 = r6
            goto L_0x0022
        L_0x000a:
            com.fasterxml.jackson.databind.j r2 = r14.q()
            java.lang.Class<java.util.Properties> r3 = java.util.Properties.class
            boolean r3 = r14.z(r3)
            if (r3 == 0) goto L_0x001d
            com.fasterxml.jackson.databind.j r0 = com.fasterxml.jackson.databind.type.o.J()
        L_0x001a:
            r7 = r0
            r6 = r2
            goto L_0x0022
        L_0x001d:
            com.fasterxml.jackson.databind.j r0 = r14.l()
            goto L_0x001a
        L_0x0022:
            r0 = 0
            if (r15 != 0) goto L_0x0030
            if (r7 == 0) goto L_0x002e
            boolean r2 = r7.F()
            if (r2 == 0) goto L_0x002e
            r0 = 1
        L_0x002e:
            r8 = r0
            goto L_0x003a
        L_0x0030:
            java.lang.Class r2 = r7.s()
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r2 != r3) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r8 = r15
        L_0x003a:
            com.fasterxml.jackson.databind.ser.std.t r0 = new com.fasterxml.jackson.databind.ser.std.t
            r3 = r0
            r4 = r12
            r5 = r13
            r9 = r16
            r10 = r17
            r11 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r1 == 0) goto L_0x004e
            com.fasterxml.jackson.databind.ser.std.t r0 = r0.T(r1)
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.I(java.util.Set, java.util.Set, com.fasterxml.jackson.databind.j, boolean, q8.g, com.fasterxml.jackson.databind.o, com.fasterxml.jackson.databind.o, java.lang.Object):com.fasterxml.jackson.databind.ser.std.t");
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o A(k kVar, j jVar, b0 b0Var) {
        k.d g10 = kVar.g(jVar, b0Var, this.f5575c);
        k kVar2 = g10.f13099b;
        if (kVar != kVar2) {
            this.f5582j = kVar2;
        }
        return g10.f13098a;
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o B(k kVar, Class cls, b0 b0Var) {
        k.d h10 = kVar.h(cls, b0Var, this.f5575c);
        k kVar2 = h10.f13099b;
        if (kVar != kVar2) {
            this.f5582j = kVar2;
        }
        return h10.f13098a;
    }

    /* access modifiers changed from: protected */
    public boolean D(Map map) {
        if (!(map instanceof HashMap) || !map.containsKey((Object) null)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Map E(Map map, f fVar, b0 b0Var) {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!D(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                G(fVar, b0Var, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    /* renamed from: F */
    public t x(g gVar) {
        if (this.f5581i == gVar) {
            return this;
        }
        z("_withValueTypeSerializer");
        return new t(this, gVar, this.Y, this.Z);
    }

    /* access modifiers changed from: protected */
    public void G(f fVar, b0 b0Var, Object obj) {
        com.fasterxml.jackson.databind.o oVar;
        com.fasterxml.jackson.databind.o C2 = b0Var.C(this.f5577e, this.f5575c);
        if (obj != null) {
            oVar = this.f5580h;
            if (oVar == null) {
                oVar = C(b0Var, obj);
            }
            Object obj2 = this.Y;
            if (obj2 == Q0) {
                if (oVar.d(b0Var, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (!this.Z) {
            oVar = b0Var.O();
        } else {
            return;
        }
        try {
            C2.f((Object) null, fVar, b0Var);
            oVar.f(obj, fVar, b0Var);
        } catch (Exception e10) {
            w(b0Var, e10, obj, "");
        }
    }

    public j J() {
        return this.f5578f;
    }

    /* renamed from: K */
    public boolean d(b0 b0Var, Map map) {
        boolean z10;
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this.Y;
        if (obj == null && !this.Z) {
            return false;
        }
        com.fasterxml.jackson.databind.o oVar = this.f5580h;
        if (Q0 == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (oVar != null) {
            for (Object next : map.values()) {
                if (next == null) {
                    if (!this.Z) {
                        return false;
                    }
                } else if (z10) {
                    if (!oVar.d(b0Var, next)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object next2 : map.values()) {
            if (next2 != null) {
                try {
                    com.fasterxml.jackson.databind.o C2 = C(b0Var, next2);
                    if (!z10) {
                        if (obj != null && obj.equals(map)) {
                        }
                        return false;
                    } else if (!C2.d(b0Var, next2)) {
                        return false;
                    }
                } catch (com.fasterxml.jackson.databind.f unused) {
                }
            } else if (!this.Z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: L */
    public void f(Map map, f fVar, b0 b0Var) {
        fVar.p0(map);
        R(map, fVar, b0Var);
        fVar.Q();
    }

    public void M(Map map, f fVar, b0 b0Var) {
        Object obj = null;
        if (this.f5581i != null) {
            P(map, fVar, b0Var, (Object) null);
            return;
        }
        com.fasterxml.jackson.databind.o oVar = this.f5579g;
        try {
            Object obj2 = null;
            for (Map.Entry entry : map.entrySet()) {
                try {
                    Object value = entry.getValue();
                    obj2 = entry.getKey();
                    if (obj2 == null) {
                        b0Var.C(this.f5577e, this.f5575c).f((Object) null, fVar, b0Var);
                    } else {
                        i.a aVar = this.N0;
                        if (aVar == null || !aVar.b(obj2)) {
                            oVar.f(obj2, fVar, b0Var);
                        }
                    }
                    if (value == null) {
                        b0Var.x(fVar);
                    } else {
                        com.fasterxml.jackson.databind.o oVar2 = this.f5580h;
                        if (oVar2 == null) {
                            oVar2 = C(b0Var, value);
                        }
                        oVar2.f(value, fVar, b0Var);
                    }
                } catch (Exception e10) {
                    e = e10;
                    obj = obj2;
                    w(b0Var, e, map, String.valueOf(obj));
                }
            }
        } catch (Exception e11) {
            e = e11;
            w(b0Var, e, map, String.valueOf(obj));
        }
    }

    public void N(Map map, f fVar, b0 b0Var, com.fasterxml.jackson.databind.o oVar) {
        com.fasterxml.jackson.databind.o oVar2 = this.f5579g;
        g gVar = this.f5581i;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            i.a aVar = this.N0;
            if (aVar == null || !aVar.b(key)) {
                if (key == null) {
                    b0Var.C(this.f5577e, this.f5575c).f((Object) null, fVar, b0Var);
                } else {
                    oVar2.f(key, fVar, b0Var);
                }
                Object value = entry.getValue();
                if (value == null) {
                    b0Var.x(fVar);
                } else if (gVar == null) {
                    try {
                        oVar.f(value, fVar, b0Var);
                    } catch (Exception e10) {
                        w(b0Var, e10, map, String.valueOf(key));
                    }
                } else {
                    oVar.h(value, fVar, b0Var, gVar);
                }
            }
        }
    }

    public void O(Map map, f fVar, b0 b0Var, Object obj) {
        boolean z10;
        com.fasterxml.jackson.databind.o oVar;
        com.fasterxml.jackson.databind.o oVar2;
        if (this.f5581i != null) {
            P(map, fVar, b0Var, obj);
            return;
        }
        if (Q0 == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                oVar = b0Var.C(this.f5577e, this.f5575c);
            } else {
                i.a aVar = this.N0;
                if (aVar == null || !aVar.b(key)) {
                    oVar = this.f5579g;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                oVar2 = this.f5580h;
                if (oVar2 == null) {
                    oVar2 = C(b0Var, value);
                }
                if (z10) {
                    if (oVar2.d(b0Var, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this.Z) {
                oVar2 = b0Var.O();
            }
            try {
                oVar.f(key, fVar, b0Var);
                oVar2.f(value, fVar, b0Var);
            } catch (Exception e10) {
                w(b0Var, e10, map, String.valueOf(key));
            }
        }
    }

    public void P(Map map, f fVar, b0 b0Var, Object obj) {
        boolean z10;
        com.fasterxml.jackson.databind.o oVar;
        com.fasterxml.jackson.databind.o oVar2;
        if (Q0 == obj) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                oVar = b0Var.C(this.f5577e, this.f5575c);
            } else {
                i.a aVar = this.N0;
                if (aVar == null || !aVar.b(key)) {
                    oVar = this.f5579g;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                oVar2 = this.f5580h;
                if (oVar2 == null) {
                    oVar2 = C(b0Var, value);
                }
                if (z10) {
                    if (oVar2.d(b0Var, value)) {
                    }
                } else if (obj != null && obj.equals(value)) {
                }
            } else if (!this.Z) {
                oVar2 = b0Var.O();
            }
            oVar.f(key, fVar, b0Var);
            try {
                oVar2.h(value, fVar, b0Var, this.f5581i);
            } catch (Exception e10) {
                w(b0Var, e10, map, String.valueOf(key));
            }
        }
    }

    /* renamed from: Q */
    public void h(Map map, f fVar, b0 b0Var, g gVar) {
        fVar.B(map);
        b g10 = gVar.g(fVar, gVar.d(map, com.fasterxml.jackson.core.k.START_OBJECT));
        R(map, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    public void R(Map map, f fVar, b0 b0Var) {
        if (!map.isEmpty()) {
            if (this.O0 || b0Var.b0(a0.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = E(map, fVar, b0Var);
            }
            Object obj = this.X;
            if (obj != null) {
                t(b0Var, obj, map);
            }
            Object obj2 = this.Y;
            if (obj2 != null || this.Z) {
                O(map, fVar, b0Var, obj2);
                return;
            }
            com.fasterxml.jackson.databind.o oVar = this.f5580h;
            if (oVar != null) {
                N(map, fVar, b0Var, oVar);
            } else {
                M(map, fVar, b0Var);
            }
        }
    }

    public t S(Object obj, boolean z10) {
        if (obj == this.Y && z10 == this.Z) {
            return this;
        }
        z("withContentInclusion");
        return new t(this, this.f5581i, obj, z10);
    }

    public t T(Object obj) {
        if (this.X == obj) {
            return this;
        }
        z("withFilterId");
        return new t(this, obj, this.O0);
    }

    public t U(d dVar, com.fasterxml.jackson.databind.o oVar, com.fasterxml.jackson.databind.o oVar2, Set set, Set set2, boolean z10) {
        z("withResolved");
        t tVar = new t(this, dVar, oVar, oVar2, set, set2);
        if (z10 != tVar.O0) {
            return new t(tVar, this.X, z10);
        }
        return tVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0125, code lost:
        if (r0 != 5) goto L_0x015f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r14, com.fasterxml.jackson.databind.d r15) {
        /*
            r13 = this;
            com.fasterxml.jackson.databind.b r0 = r14.L()
            r1 = 0
            if (r15 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000d
        L_0x0009:
            com.fasterxml.jackson.databind.introspect.i r2 = r15.b()
        L_0x000d:
            boolean r3 = com.fasterxml.jackson.databind.ser.std.h0.k(r2, r0)
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r0.p(r2)
            if (r3 == 0) goto L_0x001e
            com.fasterxml.jackson.databind.o r3 = r14.i0(r2, r3)
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            java.lang.Object r4 = r0.f(r2)
            if (r4 == 0) goto L_0x002a
            com.fasterxml.jackson.databind.o r4 = r14.i0(r2, r4)
            goto L_0x002e
        L_0x002a:
            r4 = r1
            goto L_0x002e
        L_0x002c:
            r3 = r1
            r4 = r3
        L_0x002e:
            if (r4 != 0) goto L_0x0032
            com.fasterxml.jackson.databind.o r4 = r13.f5580h
        L_0x0032:
            com.fasterxml.jackson.databind.o r4 = r13.n(r14, r15, r4)
            if (r4 != 0) goto L_0x004a
            boolean r5 = r13.f5576d
            if (r5 == 0) goto L_0x004a
            com.fasterxml.jackson.databind.j r5 = r13.f5578f
            boolean r5 = r5.H()
            if (r5 != 0) goto L_0x004a
            com.fasterxml.jackson.databind.j r4 = r13.f5578f
            com.fasterxml.jackson.databind.o r4 = r14.y(r4, r15)
        L_0x004a:
            r8 = r4
            if (r3 != 0) goto L_0x004f
            com.fasterxml.jackson.databind.o r3 = r13.f5579g
        L_0x004f:
            if (r3 != 0) goto L_0x0059
            com.fasterxml.jackson.databind.j r3 = r13.f5577e
            com.fasterxml.jackson.databind.o r3 = r14.A(r3, r15)
        L_0x0057:
            r7 = r3
            goto L_0x005e
        L_0x0059:
            com.fasterxml.jackson.databind.o r3 = r14.X(r3, r15)
            goto L_0x0057
        L_0x005e:
            java.util.Set r3 = r13.f5583w
            java.util.Set r4 = r13.C
            boolean r5 = com.fasterxml.jackson.databind.ser.std.h0.k(r2, r0)
            r12 = 0
            if (r5 == 0) goto L_0x00d6
            com.fasterxml.jackson.databind.z r5 = r14.f()
            com.fasterxml.jackson.annotation.n$a r6 = r0.C(r5, r2)
            java.util.Set r6 = r6.h()
            boolean r9 = com.fasterxml.jackson.databind.ser.std.h0.l(r6)
            if (r9 == 0) goto L_0x009d
            if (r3 != 0) goto L_0x0083
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            goto L_0x0089
        L_0x0083:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>(r3)
            r3 = r9
        L_0x0089:
            java.util.Iterator r6 = r6.iterator()
        L_0x008d:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x009d
            java.lang.Object r9 = r6.next()
            java.lang.String r9 = (java.lang.String) r9
            r3.add(r9)
            goto L_0x008d
        L_0x009d:
            com.fasterxml.jackson.annotation.q$a r5 = r0.F(r5, r2)
            java.util.Set r5 = r5.e()
            if (r5 == 0) goto L_0x00c9
            if (r4 != 0) goto L_0x00af
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            goto L_0x00b5
        L_0x00af:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r4)
            r4 = r6
        L_0x00b5:
            java.util.Iterator r5 = r5.iterator()
        L_0x00b9:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00c9
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r4.add(r6)
            goto L_0x00b9
        L_0x00c9:
            java.lang.Boolean r5 = r0.O(r2)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = r6.equals(r5)
            r9 = r3
            r10 = r4
            goto L_0x00d9
        L_0x00d6:
            r9 = r3
            r10 = r4
            r5 = r12
        L_0x00d9:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            com.fasterxml.jackson.annotation.i$d r4 = r13.q(r14, r15, r3)
            if (r4 == 0) goto L_0x00ef
            com.fasterxml.jackson.annotation.i$a r6 = com.fasterxml.jackson.annotation.i.a.WRITE_SORTED_MAP_ENTRIES
            java.lang.Boolean r4 = r4.e(r6)
            if (r4 == 0) goto L_0x00ef
            boolean r4 = r4.booleanValue()
            r11 = r4
            goto L_0x00f0
        L_0x00ef:
            r11 = r5
        L_0x00f0:
            r5 = r13
            r6 = r15
            com.fasterxml.jackson.databind.ser.std.t r4 = r5.U(r6, r7, r8, r9, r10, r11)
            if (r2 == 0) goto L_0x0102
            java.lang.Object r0 = r0.k(r2)
            if (r0 == 0) goto L_0x0102
            com.fasterxml.jackson.databind.ser.std.t r4 = r4.T(r0)
        L_0x0102:
            com.fasterxml.jackson.annotation.p$b r15 = r13.s(r14, r15, r3)
            if (r15 == 0) goto L_0x0163
            com.fasterxml.jackson.annotation.p$a r0 = r15.f()
            com.fasterxml.jackson.annotation.p$a r2 = com.fasterxml.jackson.annotation.p.a.USE_DEFAULTS
            if (r0 == r2) goto L_0x0163
            int[] r2 = com.fasterxml.jackson.databind.ser.std.t.a.f5584a
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 1
            if (r0 == r2) goto L_0x0148
            r3 = 2
            if (r0 == r3) goto L_0x013d
            r3 = 3
            if (r0 == r3) goto L_0x013a
            r3 = 4
            if (r0 == r3) goto L_0x012a
            r14 = 5
            if (r0 == r14) goto L_0x0128
            goto L_0x015f
        L_0x0128:
            r12 = r2
            goto L_0x015f
        L_0x012a:
            java.lang.Class r15 = r15.e()
            java.lang.Object r1 = r14.Y(r1, r15)
            if (r1 != 0) goto L_0x0135
            goto L_0x0128
        L_0x0135:
            boolean r12 = r14.Z(r1)
            goto L_0x015f
        L_0x013a:
            java.lang.Object r1 = Q0
            goto L_0x0128
        L_0x013d:
            com.fasterxml.jackson.databind.j r14 = r13.f5578f
            boolean r14 = r14.d()
            if (r14 == 0) goto L_0x0128
            java.lang.Object r1 = Q0
            goto L_0x0128
        L_0x0148:
            com.fasterxml.jackson.databind.j r14 = r13.f5578f
            java.lang.Object r1 = com.fasterxml.jackson.databind.util.d.b(r14)
            if (r1 == 0) goto L_0x0128
            java.lang.Class r14 = r1.getClass()
            boolean r14 = r14.isArray()
            if (r14 == 0) goto L_0x0128
            java.lang.Object r1 = com.fasterxml.jackson.databind.util.b.a(r1)
            goto L_0x0128
        L_0x015f:
            com.fasterxml.jackson.databind.ser.std.t r4 = r4.S(r1, r12)
        L_0x0163:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.t.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    /* access modifiers changed from: protected */
    public void z(String str) {
        com.fasterxml.jackson.databind.util.f.Y(t.class, this, str);
    }

    protected t(t tVar, d dVar, com.fasterxml.jackson.databind.o oVar, com.fasterxml.jackson.databind.o oVar2, Set set, Set set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f5583w = set;
        this.C = set2;
        this.f5577e = tVar.f5577e;
        this.f5578f = tVar.f5578f;
        this.f5576d = tVar.f5576d;
        this.f5581i = tVar.f5581i;
        this.f5579g = oVar;
        this.f5580h = oVar2;
        this.f5582j = k.c();
        this.f5575c = dVar;
        this.X = tVar.X;
        this.O0 = tVar.O0;
        this.Y = tVar.Y;
        this.Z = tVar.Z;
        this.N0 = com.fasterxml.jackson.databind.util.i.a(set, set2);
    }

    protected t(t tVar, g gVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f5583w = tVar.f5583w;
        this.C = tVar.C;
        this.f5577e = tVar.f5577e;
        this.f5578f = tVar.f5578f;
        this.f5576d = tVar.f5576d;
        this.f5581i = gVar;
        this.f5579g = tVar.f5579g;
        this.f5580h = tVar.f5580h;
        this.f5582j = tVar.f5582j;
        this.f5575c = tVar.f5575c;
        this.X = tVar.X;
        this.O0 = tVar.O0;
        this.Y = obj;
        this.Z = z10;
        this.N0 = tVar.N0;
    }

    protected t(t tVar, Object obj, boolean z10) {
        super(Map.class, false);
        this.f5583w = tVar.f5583w;
        this.C = tVar.C;
        this.f5577e = tVar.f5577e;
        this.f5578f = tVar.f5578f;
        this.f5576d = tVar.f5576d;
        this.f5581i = tVar.f5581i;
        this.f5579g = tVar.f5579g;
        this.f5580h = tVar.f5580h;
        this.f5582j = k.c();
        this.f5575c = tVar.f5575c;
        this.X = obj;
        this.O0 = z10;
        this.Y = tVar.Y;
        this.Z = tVar.Z;
        this.N0 = tVar.N0;
    }
}
