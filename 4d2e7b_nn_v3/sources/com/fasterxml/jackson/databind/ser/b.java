package com.fasterxml.jackson.databind.ser;

import c.d;
import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.n;
import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.q;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.n;
import com.fasterxml.jackson.databind.q;
import com.fasterxml.jackson.databind.ser.std.a0;
import com.fasterxml.jackson.databind.ser.std.c0;
import com.fasterxml.jackson.databind.ser.std.d0;
import com.fasterxml.jackson.databind.ser.std.e;
import com.fasterxml.jackson.databind.ser.std.h;
import com.fasterxml.jackson.databind.ser.std.i0;
import com.fasterxml.jackson.databind.ser.std.j0;
import com.fasterxml.jackson.databind.ser.std.k;
import com.fasterxml.jackson.databind.ser.std.k0;
import com.fasterxml.jackson.databind.ser.std.l0;
import com.fasterxml.jackson.databind.ser.std.n0;
import com.fasterxml.jackson.databind.ser.std.r;
import com.fasterxml.jackson.databind.ser.std.s;
import com.fasterxml.jackson.databind.ser.std.t;
import com.fasterxml.jackson.databind.ser.std.v;
import com.fasterxml.jackson.databind.ser.std.w;
import com.fasterxml.jackson.databind.ser.std.x;
import com.fasterxml.jackson.databind.type.j;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.util.p;
import com.fasterxml.jackson.databind.z;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import k8.e;
import l8.o;
import q8.g;
import t8.m;

public abstract class b extends q implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    protected static final HashMap f5483b;

    /* renamed from: c  reason: collision with root package name */
    protected static final HashMap f5484c;

    /* renamed from: a  reason: collision with root package name */
    protected final o f5485a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5486a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5487b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            /*
                com.fasterxml.jackson.annotation.p$a[] r0 = com.fasterxml.jackson.annotation.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5487b = r0
                r1 = 1
                com.fasterxml.jackson.annotation.p$a r2 = com.fasterxml.jackson.annotation.p.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5487b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.p$a r3 = com.fasterxml.jackson.annotation.p.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5487b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.p$a r4 = com.fasterxml.jackson.annotation.p.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f5487b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.p$a r4 = com.fasterxml.jackson.annotation.p.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f5487b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.p$a r4 = com.fasterxml.jackson.annotation.p.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f5487b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.p$a r4 = com.fasterxml.jackson.annotation.p.a.USE_DEFAULTS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.fasterxml.jackson.annotation.i$c[] r3 = com.fasterxml.jackson.annotation.i.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5486a = r3
                com.fasterxml.jackson.annotation.i$c r4 = com.fasterxml.jackson.annotation.i.c.STRING     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f5486a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.fasterxml.jackson.annotation.i$c r3 = com.fasterxml.jackson.annotation.i.c.OBJECT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f5486a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.fasterxml.jackson.annotation.i$c r1 = com.fasterxml.jackson.annotation.i.c.ARRAY     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.b.a.<clinit>():void");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(String.class.getName(), new i0());
        l0 l0Var = l0.f5560c;
        hashMap2.put(StringBuffer.class.getName(), l0Var);
        hashMap2.put(StringBuilder.class.getName(), l0Var);
        hashMap2.put(Character.class.getName(), l0Var);
        hashMap2.put(Character.TYPE.getName(), l0Var);
        w.a(hashMap2);
        hashMap2.put(Boolean.TYPE.getName(), new e(true));
        hashMap2.put(Boolean.class.getName(), new e(false));
        Class<BigInteger> cls = BigInteger.class;
        hashMap2.put(cls.getName(), new v(cls));
        Class<BigDecimal> cls2 = BigDecimal.class;
        hashMap2.put(cls2.getName(), new v(cls2));
        hashMap2.put(Calendar.class.getName(), h.f5553f);
        hashMap2.put(Date.class.getName(), k.f5556f);
        for (Map.Entry entry : d0.a()) {
            Object value = entry.getValue();
            if (value instanceof com.fasterxml.jackson.databind.o) {
                hashMap2.put(((Class) entry.getKey()).getName(), (com.fasterxml.jackson.databind.o) value);
            } else {
                hashMap.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        hashMap.put(p.class.getName(), n0.class);
        f5483b = hashMap2;
        f5484c = hashMap;
    }

    protected b(o oVar) {
        this.f5485a = oVar == null ? new o() : oVar;
    }

    public com.fasterxml.jackson.databind.o A(b0 b0Var, j jVar, c cVar, boolean z10) {
        com.fasterxml.jackson.databind.j l10 = jVar.l();
        g gVar = (g) l10.v();
        z N = b0Var.f();
        if (gVar == null) {
            gVar = c(N, l10);
        }
        g gVar2 = gVar;
        com.fasterxml.jackson.databind.o oVar = (com.fasterxml.jackson.databind.o) l10.w();
        Iterator it = v().iterator();
        if (it.hasNext()) {
            d.a(it.next());
            throw null;
        } else if (jVar.L(AtomicReference.class)) {
            return j(b0Var, jVar, cVar, z10, gVar2, oVar);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o B(z zVar, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10) {
        com.fasterxml.jackson.databind.j J;
        com.fasterxml.jackson.databind.j J2;
        Class s10 = jVar.s();
        Class<Iterator> cls = Iterator.class;
        if (cls.isAssignableFrom(s10)) {
            com.fasterxml.jackson.databind.j[] G = zVar.B().G(jVar, cls);
            if (G == null || G.length != 1) {
                J2 = com.fasterxml.jackson.databind.type.o.J();
            } else {
                J2 = G[0];
            }
            return s(zVar, jVar, cVar, z10, J2);
        }
        Class<Iterable> cls2 = Iterable.class;
        if (cls2.isAssignableFrom(s10)) {
            com.fasterxml.jackson.databind.j[] G2 = zVar.B().G(jVar, cls2);
            if (G2 == null || G2.length != 1) {
                J = com.fasterxml.jackson.databind.type.o.J();
            } else {
                J = G2[0];
            }
            return q(zVar, jVar, cVar, z10, J);
        } else if (CharSequence.class.isAssignableFrom(s10)) {
            return l0.f5560c;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o C(b0 b0Var, com.fasterxml.jackson.databind.j jVar, c cVar) {
        if (n.class.isAssignableFrom(jVar.s())) {
            return a0.f5520c;
        }
        i e10 = cVar.e();
        if (e10 == null) {
            return null;
        }
        if (b0Var.s()) {
            f.g(e10.m(), b0Var.a0(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        com.fasterxml.jackson.databind.j e11 = e10.e();
        com.fasterxml.jackson.databind.o F = F(b0Var, e10);
        if (F == null) {
            F = (com.fasterxml.jackson.databind.o) e11.w();
        }
        g gVar = (g) e11.v();
        if (gVar == null) {
            gVar = c(b0Var.f(), e11);
        }
        return new s(e10, gVar, F);
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o D(com.fasterxml.jackson.databind.j jVar, z zVar, c cVar, boolean z10) {
        Class cls;
        String name = jVar.s().getName();
        com.fasterxml.jackson.databind.o oVar = (com.fasterxml.jackson.databind.o) f5483b.get(name);
        if (oVar != null || (cls = (Class) f5484c.get(name)) == null) {
            return oVar;
        }
        return (com.fasterxml.jackson.databind.o) f.k(cls, false);
    }

    /* access modifiers changed from: protected */
    public final com.fasterxml.jackson.databind.o E(b0 b0Var, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10) {
        if (jVar.E()) {
            return n(b0Var.f(), jVar, cVar);
        }
        Class s10 = jVar.s();
        com.fasterxml.jackson.databind.o z11 = z(b0Var, jVar, cVar, z10);
        if (z11 != null) {
            return z11;
        }
        if (Calendar.class.isAssignableFrom(s10)) {
            return h.f5553f;
        }
        if (Date.class.isAssignableFrom(s10)) {
            return k.f5556f;
        }
        Class<Map.Entry> cls = Map.Entry.class;
        if (cls.isAssignableFrom(s10)) {
            com.fasterxml.jackson.databind.j j10 = jVar.j(cls);
            return t(b0Var, jVar, cVar, z10, j10.i(0), j10.i(1));
        } else if (ByteBuffer.class.isAssignableFrom(s10)) {
            return new com.fasterxml.jackson.databind.ser.std.g();
        } else {
            if (InetAddress.class.isAssignableFrom(s10)) {
                return new com.fasterxml.jackson.databind.ser.std.p();
            }
            if (InetSocketAddress.class.isAssignableFrom(s10)) {
                return new com.fasterxml.jackson.databind.ser.std.q();
            }
            if (TimeZone.class.isAssignableFrom(s10)) {
                return new j0();
            }
            if (Charset.class.isAssignableFrom(s10)) {
                return l0.f5560c;
            }
            if (Number.class.isAssignableFrom(s10)) {
                int i10 = a.f5486a[cVar.c((i.d) null).i().ordinal()];
                if (i10 == 1) {
                    return l0.f5560c;
                }
                if (i10 == 2 || i10 == 3) {
                    return null;
                }
                return v.f5586d;
            } else if (ClassLoader.class.isAssignableFrom(s10)) {
                return new k0(jVar);
            } else {
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o F(b0 b0Var, com.fasterxml.jackson.databind.introspect.b bVar) {
        Object Q = b0Var.L().Q(bVar);
        if (Q == null) {
            return null;
        }
        return x(b0Var, bVar, b0Var.i0(bVar, Q));
    }

    /* access modifiers changed from: protected */
    public boolean G(Class cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    /* access modifiers changed from: protected */
    public boolean H(z zVar, c cVar, g gVar) {
        if (gVar != null) {
            return false;
        }
        e.b P = zVar.h().P(cVar.k());
        if (P == null || P == e.b.DEFAULT_TYPING) {
            return zVar.F(q.USE_STATIC_TYPING);
        }
        if (P == e.b.STATIC) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r6, com.fasterxml.jackson.databind.j r7, com.fasterxml.jackson.databind.o r8) {
        /*
            r5 = this;
            com.fasterxml.jackson.databind.z r0 = r6.f()
            com.fasterxml.jackson.databind.c r1 = r0.a0(r7)
            l8.o r2 = r5.f5485a
            boolean r2 = r2.a()
            r3 = 0
            if (r2 == 0) goto L_0x002a
            l8.o r2 = r5.f5485a
            java.lang.Iterable r2 = r2.c()
            java.util.Iterator r2 = r2.iterator()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            java.lang.Object r6 = r2.next()
            c.d.a(r6)
            throw r3
        L_0x002a:
            com.fasterxml.jackson.databind.introspect.c r2 = r1.k()
            com.fasterxml.jackson.databind.o r2 = r5.h(r6, r2)
            if (r2 != 0) goto L_0x0077
            if (r8 != 0) goto L_0x0078
            java.lang.Class r2 = r7.s()
            r4 = 0
            com.fasterxml.jackson.databind.o r2 = com.fasterxml.jackson.databind.ser.std.f0.b(r0, r2, r4)
            if (r2 != 0) goto L_0x0077
            com.fasterxml.jackson.databind.introspect.i r2 = r1.d()
            if (r2 != 0) goto L_0x004b
            com.fasterxml.jackson.databind.introspect.i r2 = r1.e()
        L_0x004b:
            if (r2 == 0) goto L_0x006e
            com.fasterxml.jackson.databind.j r7 = r2.e()
            com.fasterxml.jackson.databind.o r6 = r5.a(r6, r7, r8)
            boolean r7 = r0.b()
            if (r7 == 0) goto L_0x0068
            java.lang.reflect.Member r7 = r2.m()
            com.fasterxml.jackson.databind.q r8 = com.fasterxml.jackson.databind.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r8 = r0.F(r8)
            com.fasterxml.jackson.databind.util.f.g(r7, r8)
        L_0x0068:
            com.fasterxml.jackson.databind.ser.std.s r8 = new com.fasterxml.jackson.databind.ser.std.s
            r8.<init>(r2, r3, r6)
            goto L_0x0078
        L_0x006e:
            java.lang.Class r6 = r7.s()
            com.fasterxml.jackson.databind.o r8 = com.fasterxml.jackson.databind.ser.std.f0.a(r0, r6)
            goto L_0x0078
        L_0x0077:
            r8 = r2
        L_0x0078:
            l8.o r6 = r5.f5485a
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0099
            l8.o r6 = r5.f5485a
            java.lang.Iterable r6 = r6.d()
            java.util.Iterator r6 = r6.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x0091
            goto L_0x0099
        L_0x0091:
            java.lang.Object r6 = r6.next()
            c.d.a(r6)
            throw r3
        L_0x0099:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.b.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.j, com.fasterxml.jackson.databind.o):com.fasterxml.jackson.databind.o");
    }

    public g c(z zVar, com.fasterxml.jackson.databind.j jVar) {
        Collection collection;
        com.fasterxml.jackson.databind.introspect.c k10 = zVar.D(jVar.s()).k();
        q8.f U = zVar.h().U(zVar, k10, jVar);
        if (U == null) {
            U = zVar.u(jVar);
            collection = null;
        } else {
            collection = zVar.T().a(zVar, k10);
        }
        if (U == null) {
            return null;
        }
        return U.d(zVar, jVar, collection);
    }

    /* access modifiers changed from: protected */
    public t d(b0 b0Var, c cVar, t tVar) {
        p.a aVar;
        com.fasterxml.jackson.databind.j J = tVar.J();
        p.b f10 = f(b0Var, cVar, J, Map.class);
        if (f10 == null) {
            aVar = p.a.USE_DEFAULTS;
        } else {
            aVar = f10.f();
        }
        Object obj = null;
        boolean z10 = true;
        if (aVar != p.a.USE_DEFAULTS && aVar != p.a.ALWAYS) {
            int i10 = a.f5487b[aVar.ordinal()];
            if (i10 == 1) {
                obj = com.fasterxml.jackson.databind.util.d.b(J);
                if (obj != null && obj.getClass().isArray()) {
                    obj = com.fasterxml.jackson.databind.util.b.a(obj);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj = t.Q0;
                } else if (i10 == 4 && (obj = b0Var.Y((com.fasterxml.jackson.databind.introspect.s) null, f10.e())) != null) {
                    z10 = b0Var.Z(obj);
                }
            } else if (J.d()) {
                obj = t.Q0;
            }
            return tVar.S(obj, z10);
        } else if (!b0Var.b0(com.fasterxml.jackson.databind.a0.WRITE_NULL_MAP_VALUES)) {
            return tVar.S((Object) null, true);
        } else {
            return tVar;
        }
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o e(b0 b0Var, com.fasterxml.jackson.databind.introspect.b bVar) {
        Object f10 = b0Var.L().f(bVar);
        if (f10 != null) {
            return b0Var.i0(bVar, f10);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public p.b f(b0 b0Var, c cVar, com.fasterxml.jackson.databind.j jVar, Class cls) {
        z N = b0Var.f();
        p.b s10 = N.s(cls, cVar.g(N.P()));
        p.b s11 = N.s(jVar.s(), (p.b) null);
        if (s11 == null) {
            return s10;
        }
        int i10 = a.f5487b[s11.i().ordinal()];
        if (i10 == 4) {
            return s10.l(s11.e());
        }
        if (i10 != 6) {
            return s10.m(s11.i());
        }
        return s10;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o h(b0 b0Var, com.fasterxml.jackson.databind.introspect.b bVar) {
        Object p10 = b0Var.L().p(bVar);
        if (p10 != null) {
            return b0Var.i0(bVar, p10);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o i(b0 b0Var, com.fasterxml.jackson.databind.type.a aVar, c cVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar) {
        com.fasterxml.jackson.databind.o oVar2;
        b0Var.f();
        Iterator it = v().iterator();
        if (!it.hasNext()) {
            Class<String[]> s10 = aVar.s();
            if (oVar != null && !f.J(oVar)) {
                oVar2 = null;
            } else if (String[].class == s10) {
                oVar2 = m.f13113g;
            } else {
                oVar2 = c0.a(s10);
            }
            if (oVar2 == null) {
                oVar2 = new x(aVar.l(), z10, gVar, oVar);
            }
            if (this.f5485a.b()) {
                Iterator it2 = this.f5485a.d().iterator();
                if (it2.hasNext()) {
                    d.a(it2.next());
                    throw null;
                }
            }
            return oVar2;
        }
        d.a(it.next());
        throw null;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o j(b0 b0Var, j jVar, c cVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar) {
        p.a aVar;
        boolean z11;
        com.fasterxml.jackson.databind.j t10 = jVar.b();
        p.b f10 = f(b0Var, cVar, t10, AtomicReference.class);
        if (f10 == null) {
            aVar = p.a.USE_DEFAULTS;
        } else {
            aVar = f10.f();
        }
        Object obj = null;
        if (aVar == p.a.USE_DEFAULTS || aVar == p.a.ALWAYS) {
            z11 = false;
        } else {
            int i10 = a.f5487b[aVar.ordinal()];
            z11 = true;
            if (i10 == 1) {
                obj = com.fasterxml.jackson.databind.util.d.b(t10);
                if (obj != null && obj.getClass().isArray()) {
                    obj = com.fasterxml.jackson.databind.util.b.a(obj);
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    obj = t.Q0;
                } else if (i10 == 4 && (obj = b0Var.Y((com.fasterxml.jackson.databind.introspect.s) null, f10.e())) != null) {
                    z11 = b0Var.Z(obj);
                }
            } else if (t10.d()) {
                obj = t.Q0;
            }
        }
        return new com.fasterxml.jackson.databind.ser.std.c(jVar, z10, gVar, oVar).D(obj, z11);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o k(b0 b0Var, com.fasterxml.jackson.databind.type.e eVar, c cVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar) {
        b0Var.f();
        Iterator it = v().iterator();
        if (!it.hasNext()) {
            com.fasterxml.jackson.databind.o C = C(b0Var, eVar, cVar);
            if (C == null) {
                if (cVar.c((i.d) null).i() == i.c.OBJECT) {
                    return null;
                }
                Class s10 = eVar.s();
                if (EnumSet.class.isAssignableFrom(s10)) {
                    com.fasterxml.jackson.databind.j l10 = eVar.l();
                    if (!l10.D()) {
                        l10 = null;
                    }
                    C = o(l10);
                } else {
                    Class<String> s11 = eVar.l().s();
                    Class<String> cls = String.class;
                    if (G(s10)) {
                        if (s11 != cls) {
                            C = p(eVar.l(), z10, gVar, oVar);
                        } else if (f.J(oVar)) {
                            C = t8.f.f13073d;
                        }
                    } else if (s11 == cls && f.J(oVar)) {
                        C = t8.n.f13115d;
                    }
                    if (C == null) {
                        C = l(eVar.l(), z10, gVar, oVar);
                    }
                }
            }
            if (this.f5485a.b()) {
                Iterator it2 = this.f5485a.d().iterator();
                if (it2.hasNext()) {
                    d.a(it2.next());
                    throw null;
                }
            }
            return C;
        }
        d.a(it.next());
        throw null;
    }

    public h l(com.fasterxml.jackson.databind.j jVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar) {
        return new com.fasterxml.jackson.databind.ser.std.j(jVar, z10, gVar, oVar);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o m(b0 b0Var, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10) {
        z N = b0Var.f();
        if (!z10 && jVar.O() && (!jVar.C() || !jVar.l().H())) {
            z10 = true;
        }
        g c10 = c(N, jVar.l());
        if (c10 != null) {
            z10 = false;
        }
        boolean z11 = z10;
        com.fasterxml.jackson.databind.o e10 = e(b0Var, cVar.k());
        if (jVar.I()) {
            com.fasterxml.jackson.databind.type.g gVar = (com.fasterxml.jackson.databind.type.g) jVar;
            com.fasterxml.jackson.databind.o h10 = h(b0Var, cVar.k());
            if (gVar instanceof com.fasterxml.jackson.databind.type.h) {
                return u(b0Var, (com.fasterxml.jackson.databind.type.h) gVar, cVar, z11, h10, c10, e10);
            }
            Iterator it = v().iterator();
            if (!it.hasNext()) {
                com.fasterxml.jackson.databind.o C = C(b0Var, jVar, cVar);
                if (C != null && this.f5485a.b()) {
                    Iterator it2 = this.f5485a.d().iterator();
                    if (it2.hasNext()) {
                        d.a(it2.next());
                        throw null;
                    }
                }
                return C;
            }
            d.a(it.next());
            throw null;
        } else if (jVar.B()) {
            com.fasterxml.jackson.databind.type.d dVar = (com.fasterxml.jackson.databind.type.d) jVar;
            if (dVar instanceof com.fasterxml.jackson.databind.type.e) {
                return k(b0Var, (com.fasterxml.jackson.databind.type.e) dVar, cVar, z11, c10, e10);
            }
            Iterator it3 = v().iterator();
            if (!it3.hasNext()) {
                com.fasterxml.jackson.databind.o C2 = C(b0Var, jVar, cVar);
                if (C2 != null && this.f5485a.b()) {
                    Iterator it4 = this.f5485a.d().iterator();
                    if (it4.hasNext()) {
                        d.a(it4.next());
                        throw null;
                    }
                }
                return C2;
            }
            d.a(it3.next());
            throw null;
        } else if (!jVar.A()) {
            return null;
        } else {
            return i(b0Var, (com.fasterxml.jackson.databind.type.a) jVar, cVar, z11, c10, e10);
        }
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o n(z zVar, com.fasterxml.jackson.databind.j jVar, c cVar) {
        i.d c10 = cVar.c((i.d) null);
        if (c10.i() == i.c.OBJECT) {
            ((com.fasterxml.jackson.databind.introspect.q) cVar).t("declaringClass");
            return null;
        }
        com.fasterxml.jackson.databind.ser.std.m z10 = com.fasterxml.jackson.databind.ser.std.m.z(jVar.s(), zVar, cVar, c10);
        if (this.f5485a.b()) {
            Iterator it = this.f5485a.d().iterator();
            if (it.hasNext()) {
                d.a(it.next());
                throw null;
            }
        }
        return z10;
    }

    public com.fasterxml.jackson.databind.o o(com.fasterxml.jackson.databind.j jVar) {
        return new com.fasterxml.jackson.databind.ser.std.n(jVar);
    }

    public h p(com.fasterxml.jackson.databind.j jVar, boolean z10, g gVar, com.fasterxml.jackson.databind.o oVar) {
        return new t8.e(jVar, z10, gVar, oVar);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o q(z zVar, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10, com.fasterxml.jackson.databind.j jVar2) {
        return new r(jVar2, z10, c(zVar, jVar2));
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o s(z zVar, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10, com.fasterxml.jackson.databind.j jVar2) {
        return new t8.g(jVar2, z10, c(zVar, jVar2));
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o t(b0 b0Var, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10, com.fasterxml.jackson.databind.j jVar2, com.fasterxml.jackson.databind.j jVar3) {
        p.a aVar;
        b0 b0Var2 = b0Var;
        c cVar2 = cVar;
        Class<Map.Entry> cls = Map.Entry.class;
        Object obj = null;
        if (i.d.p(cVar2.c((i.d) null), b0Var.P(cls)).i() == i.c.OBJECT) {
            return null;
        }
        com.fasterxml.jackson.databind.j jVar4 = jVar3;
        t8.h hVar = new t8.h(jVar3, jVar2, jVar4, z10, c(b0Var.f(), jVar4), (com.fasterxml.jackson.databind.d) null);
        com.fasterxml.jackson.databind.j B = hVar.B();
        p.b f10 = f(b0Var, cVar2, B, cls);
        if (f10 == null) {
            aVar = p.a.USE_DEFAULTS;
        } else {
            aVar = f10.f();
        }
        if (aVar == p.a.USE_DEFAULTS || aVar == p.a.ALWAYS) {
            return hVar;
        }
        int i10 = a.f5487b[aVar.ordinal()];
        boolean z11 = true;
        if (i10 == 1) {
            obj = com.fasterxml.jackson.databind.util.d.b(B);
            if (obj != null && obj.getClass().isArray()) {
                obj = com.fasterxml.jackson.databind.util.b.a(obj);
            }
        } else if (i10 != 2) {
            if (i10 == 3) {
                obj = t.Q0;
            } else if (i10 == 4 && (obj = b0Var.Y((com.fasterxml.jackson.databind.introspect.s) null, f10.e())) != null) {
                z11 = b0Var.Z(obj);
            }
        } else if (B.d()) {
            obj = t.Q0;
        }
        return hVar.G(obj, z11);
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o u(b0 b0Var, com.fasterxml.jackson.databind.type.h hVar, c cVar, boolean z10, com.fasterxml.jackson.databind.o oVar, g gVar, com.fasterxml.jackson.databind.o oVar2) {
        Set set;
        Set set2;
        c cVar2 = cVar;
        if (cVar2.c((i.d) null).i() == i.c.OBJECT) {
            return null;
        }
        z N = b0Var.f();
        Iterator it = v().iterator();
        if (!it.hasNext()) {
            com.fasterxml.jackson.databind.o C = C(b0Var, hVar, cVar);
            if (C == null) {
                Object y10 = y(N, cVar2);
                Class<Map> cls = Map.class;
                n.a O = N.O(cls, cVar.k());
                if (O == null) {
                    set = null;
                } else {
                    set = O.h();
                }
                q.a Q = N.Q(cls, cVar.k());
                if (Q == null) {
                    set2 = null;
                } else {
                    set2 = Q.e();
                }
                b0 b0Var2 = b0Var;
                C = d(b0Var, cVar2, t.I(set, set2, hVar, z10, gVar, oVar, oVar2, y10));
            }
            if (this.f5485a.b()) {
                Iterator it2 = this.f5485a.d().iterator();
                if (it2.hasNext()) {
                    d.a(it2.next());
                    throw null;
                }
            }
            return C;
        }
        d.a(it.next());
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract Iterable v();

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.util.g w(b0 b0Var, com.fasterxml.jackson.databind.introspect.b bVar) {
        Object M = b0Var.L().M(bVar);
        if (M == null) {
            return null;
        }
        b0Var.e(bVar, M);
        return null;
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o x(b0 b0Var, com.fasterxml.jackson.databind.introspect.b bVar, com.fasterxml.jackson.databind.o oVar) {
        w(b0Var, bVar);
        return oVar;
    }

    /* access modifiers changed from: protected */
    public Object y(z zVar, c cVar) {
        return zVar.h().k(cVar.k());
    }

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o z(b0 b0Var, com.fasterxml.jackson.databind.j jVar, c cVar, boolean z10) {
        return o8.e.f12879e.b(b0Var.f(), jVar, cVar);
    }
}
