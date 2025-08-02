package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.annotation.u;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.v;
import com.fasterxml.jackson.databind.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import l8.l;

public class f0 extends s implements Comparable {
    private static final b.a X = b.a.c("");
    protected transient b.a C;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f5322b;

    /* renamed from: c  reason: collision with root package name */
    protected final l f5323c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f5324d;

    /* renamed from: e  reason: collision with root package name */
    protected final w f5325e;

    /* renamed from: f  reason: collision with root package name */
    protected final w f5326f;

    /* renamed from: g  reason: collision with root package name */
    protected f f5327g;

    /* renamed from: h  reason: collision with root package name */
    protected f f5328h;

    /* renamed from: i  reason: collision with root package name */
    protected f f5329i;

    /* renamed from: j  reason: collision with root package name */
    protected f f5330j;

    /* renamed from: w  reason: collision with root package name */
    protected transient v f5331w;

    class a implements g {
        a() {
        }

        /* renamed from: b */
        public Class[] a(i iVar) {
            return f0.this.f5324d.W(iVar);
        }
    }

    class b implements g {
        b() {
        }

        /* renamed from: b */
        public b.a a(i iVar) {
            return f0.this.f5324d.I(iVar);
        }
    }

    class c implements g {
        c() {
        }

        /* renamed from: b */
        public Boolean a(i iVar) {
            return f0.this.f5324d.j0(iVar);
        }
    }

    class d implements g {
        d() {
        }

        /* renamed from: b */
        public u.a a(i iVar) {
            return f0.this.f5324d.y(iVar);
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.fasterxml.jackson.annotation.u$a[] r0 = com.fasterxml.jackson.annotation.u.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5336a = r0
                com.fasterxml.jackson.annotation.u$a r1 = com.fasterxml.jackson.annotation.u.a.READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5336a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.u$a r1 = com.fasterxml.jackson.annotation.u.a.READ_WRITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.u$a r1 = com.fasterxml.jackson.annotation.u.a.WRITE_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5336a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.u$a r1 = com.fasterxml.jackson.annotation.u.a.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.f0.e.<clinit>():void");
        }
    }

    protected static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5337a;

        /* renamed from: b  reason: collision with root package name */
        public final f f5338b;

        /* renamed from: c  reason: collision with root package name */
        public final w f5339c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5340d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5341e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f5342f;

        public f(Object obj, f fVar, w wVar, boolean z10, boolean z11, boolean z12) {
            w wVar2;
            this.f5337a = obj;
            this.f5338b = fVar;
            if (wVar == null || wVar.h()) {
                wVar2 = null;
            } else {
                wVar2 = wVar;
            }
            this.f5339c = wVar2;
            if (z10) {
                if (wVar2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                } else if (!wVar.e()) {
                    z10 = false;
                }
            }
            this.f5340d = z10;
            this.f5341e = z11;
            this.f5342f = z12;
        }

        /* access modifiers changed from: protected */
        public f a(f fVar) {
            f fVar2 = this.f5338b;
            if (fVar2 == null) {
                return c(fVar);
            }
            return c(fVar2.a(fVar));
        }

        public f b() {
            f fVar = this.f5338b;
            if (fVar == null) {
                return this;
            }
            f b10 = fVar.b();
            if (this.f5339c != null) {
                if (b10.f5339c == null) {
                    return c((f) null);
                }
                return c(b10);
            } else if (b10.f5339c != null) {
                return b10;
            } else {
                boolean z10 = this.f5341e;
                if (z10 == b10.f5341e) {
                    return c(b10);
                }
                if (z10) {
                    return c((f) null);
                }
                return b10;
            }
        }

        public f c(f fVar) {
            if (fVar == this.f5338b) {
                return this;
            }
            return new f(this.f5337a, fVar, this.f5339c, this.f5340d, this.f5341e, this.f5342f);
        }

        public f d(Object obj) {
            if (obj == this.f5337a) {
                return this;
            }
            return new f(obj, this.f5338b, this.f5339c, this.f5340d, this.f5341e, this.f5342f);
        }

        public f e() {
            f e10;
            if (this.f5342f) {
                f fVar = this.f5338b;
                if (fVar == null) {
                    return null;
                }
                return fVar.e();
            }
            f fVar2 = this.f5338b;
            if (fVar2 == null || (e10 = fVar2.e()) == this.f5338b) {
                return this;
            }
            return c(e10);
        }

        public f f() {
            if (this.f5338b == null) {
                return this;
            }
            return new f(this.f5337a, (f) null, this.f5339c, this.f5340d, this.f5341e, this.f5342f);
        }

        public f g() {
            f fVar;
            f fVar2 = this.f5338b;
            if (fVar2 == null) {
                fVar = null;
            } else {
                fVar = fVar2.g();
            }
            if (this.f5341e) {
                return c(fVar);
            }
            return fVar;
        }

        public String toString() {
            String format = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", new Object[]{this.f5337a.toString(), Boolean.valueOf(this.f5341e), Boolean.valueOf(this.f5342f), Boolean.valueOf(this.f5340d)});
            if (this.f5338b == null) {
                return format;
            }
            return format + ", " + this.f5338b.toString();
        }
    }

    private interface g {
        Object a(i iVar);
    }

    public f0(l lVar, com.fasterxml.jackson.databind.b bVar, boolean z10, w wVar) {
        this(lVar, bVar, z10, wVar, wVar);
    }

    private p C(int i10, f... fVarArr) {
        p z10 = z(fVarArr[i10]);
        do {
            i10++;
            if (i10 >= fVarArr.length) {
                return z10;
            }
        } while (fVarArr[i10] == null);
        return p.e(z10, C(i10, fVarArr));
    }

    private f E(f fVar) {
        if (fVar == null) {
            return fVar;
        }
        return fVar.e();
    }

    private f F(f fVar) {
        if (fVar == null) {
            return fVar;
        }
        return fVar.g();
    }

    private f J(f fVar) {
        if (fVar == null) {
            return fVar;
        }
        return fVar.b();
    }

    private static f a0(f fVar, f fVar2) {
        if (fVar == null) {
            return fVar2;
        }
        if (fVar2 == null) {
            return fVar;
        }
        return fVar.a(fVar2);
    }

    private boolean s(f fVar) {
        while (fVar != null) {
            if (fVar.f5339c != null && fVar.f5340d) {
                return true;
            }
            fVar = fVar.f5338b;
        }
        return false;
    }

    private boolean t(f fVar) {
        while (fVar != null) {
            w wVar = fVar.f5339c;
            if (wVar != null && wVar.e()) {
                return true;
            }
            fVar = fVar.f5338b;
        }
        return false;
    }

    private boolean u(f fVar) {
        while (fVar != null) {
            if (fVar.f5342f) {
                return true;
            }
            fVar = fVar.f5338b;
        }
        return false;
    }

    private boolean v(f fVar) {
        while (fVar != null) {
            if (fVar.f5341e) {
                return true;
            }
            fVar = fVar.f5338b;
        }
        return false;
    }

    private f w(f fVar, p pVar) {
        i iVar = (i) ((i) fVar.f5337a).o(pVar);
        f fVar2 = fVar.f5338b;
        if (fVar2 != null) {
            fVar = fVar.c(w(fVar2, pVar));
        }
        return fVar.d(iVar);
    }

    private void x(Collection collection, Map map, f fVar) {
        for (f fVar2 = fVar; fVar2 != null; fVar2 = fVar2.f5338b) {
            w wVar = fVar2.f5339c;
            if (fVar2.f5340d && wVar != null) {
                f0 f0Var = (f0) map.get(wVar);
                if (f0Var == null) {
                    f0Var = new f0(this.f5323c, this.f5324d, this.f5322b, this.f5326f, wVar);
                    map.put(wVar, f0Var);
                }
                if (fVar == this.f5327g) {
                    f0Var.f5327g = fVar2.c(f0Var.f5327g);
                } else if (fVar == this.f5329i) {
                    f0Var.f5329i = fVar2.c(f0Var.f5329i);
                } else if (fVar == this.f5330j) {
                    f0Var.f5330j = fVar2.c(f0Var.f5330j);
                } else if (fVar == this.f5328h) {
                    f0Var.f5328h = fVar2.c(f0Var.f5328h);
                } else {
                    throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                }
            } else if (fVar2.f5341e) {
                throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name " + com.fasterxml.jackson.databind.util.f.O(this.f5325e) + "): found multiple explicit names: " + collection + ", but also implicit accessor: " + fVar2);
            }
        }
    }

    private Set y(f fVar, Set set) {
        while (fVar != null) {
            if (fVar.f5340d && fVar.f5339c != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(fVar.f5339c);
            }
            fVar = fVar.f5338b;
        }
        return set;
    }

    private p z(f fVar) {
        p j10 = ((i) fVar.f5337a).j();
        f fVar2 = fVar.f5338b;
        if (fVar2 != null) {
            return p.e(j10, z(fVar2));
        }
        return j10;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.v A(com.fasterxml.jackson.databind.v r7, com.fasterxml.jackson.databind.introspect.i r8) {
        /*
            r6 = this;
            com.fasterxml.jackson.databind.introspect.i r0 = r6.e()
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0072
            com.fasterxml.jackson.databind.b r3 = r6.f5324d
            r4 = 0
            if (r3 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0024
            java.lang.Boolean r3 = r3.q(r8)
            if (r3 == 0) goto L_0x0024
            boolean r1 = r3.booleanValue()
            if (r1 == 0) goto L_0x0023
            com.fasterxml.jackson.databind.v$a r1 = com.fasterxml.jackson.databind.v.a.b(r0)
            com.fasterxml.jackson.databind.v r7 = r7.e(r1)
        L_0x0023:
            r1 = r4
        L_0x0024:
            com.fasterxml.jackson.databind.b r3 = r6.f5324d
            com.fasterxml.jackson.annotation.z$a r3 = r3.R(r8)
            if (r3 == 0) goto L_0x0035
            com.fasterxml.jackson.annotation.h0 r2 = r3.f()
            com.fasterxml.jackson.annotation.h0 r3 = r3.e()
            goto L_0x0036
        L_0x0035:
            r3 = r2
        L_0x0036:
            if (r1 != 0) goto L_0x003c
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x0073
        L_0x003c:
            java.lang.Class r8 = r6.D(r8)
            l8.l r5 = r6.f5323c
            l8.g r8 = r5.k(r8)
            com.fasterxml.jackson.annotation.z$a r5 = r8.h()
            if (r5 == 0) goto L_0x0058
            if (r2 != 0) goto L_0x0052
            com.fasterxml.jackson.annotation.h0 r2 = r5.f()
        L_0x0052:
            if (r3 != 0) goto L_0x0058
            com.fasterxml.jackson.annotation.h0 r3 = r5.e()
        L_0x0058:
            if (r1 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0073
            java.lang.Boolean r8 = r8.g()
            if (r8 == 0) goto L_0x0073
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0070
            com.fasterxml.jackson.databind.v$a r8 = com.fasterxml.jackson.databind.v.a.c(r0)
            com.fasterxml.jackson.databind.v r7 = r7.e(r8)
        L_0x0070:
            r1 = r4
            goto L_0x0073
        L_0x0072:
            r3 = r2
        L_0x0073:
            if (r1 != 0) goto L_0x0079
            if (r2 == 0) goto L_0x0079
            if (r3 != 0) goto L_0x00a5
        L_0x0079:
            l8.l r8 = r6.f5323c
            com.fasterxml.jackson.annotation.z$a r8 = r8.t()
            if (r2 != 0) goto L_0x0085
            com.fasterxml.jackson.annotation.h0 r2 = r8.f()
        L_0x0085:
            if (r3 != 0) goto L_0x008b
            com.fasterxml.jackson.annotation.h0 r3 = r8.e()
        L_0x008b:
            if (r1 == 0) goto L_0x00a5
            l8.l r8 = r6.f5323c
            java.lang.Boolean r8 = r8.o()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00a5
            if (r0 == 0) goto L_0x00a5
            com.fasterxml.jackson.databind.v$a r8 = com.fasterxml.jackson.databind.v.a.a(r0)
            com.fasterxml.jackson.databind.v r7 = r7.e(r8)
        L_0x00a5:
            if (r2 != 0) goto L_0x00a9
            if (r3 == 0) goto L_0x00ad
        L_0x00a9:
            com.fasterxml.jackson.databind.v r7 = r7.f(r2, r3)
        L_0x00ad:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.f0.A(com.fasterxml.jackson.databind.v, com.fasterxml.jackson.databind.introspect.i):com.fasterxml.jackson.databind.v");
    }

    /* access modifiers changed from: protected */
    public int B(j jVar) {
        String c10 = jVar.c();
        if (c10.startsWith("get") && c10.length() > 3) {
            return 1;
        }
        if (!c10.startsWith("is") || c10.length() <= 2) {
            return 3;
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public Class D(i iVar) {
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            if (jVar.w() > 0) {
                return jVar.s(0).s();
            }
        }
        return iVar.e().s();
    }

    /* access modifiers changed from: protected */
    public j G(j jVar, j jVar2) {
        Class k10 = jVar.k();
        Class k11 = jVar2.k();
        if (k10 != k11) {
            if (k10.isAssignableFrom(k11)) {
                return jVar2;
            }
            if (k11.isAssignableFrom(k10)) {
                return jVar;
            }
        }
        int I = I(jVar2);
        int I2 = I(jVar);
        if (I == I2) {
            com.fasterxml.jackson.databind.b bVar = this.f5324d;
            if (bVar == null) {
                return null;
            }
            return bVar.m0(this.f5323c, jVar, jVar2);
        } else if (I < I2) {
            return jVar2;
        } else {
            return jVar;
        }
    }

    /* access modifiers changed from: protected */
    public j H(f fVar, f fVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar.f5337a);
        arrayList.add(fVar2.f5337a);
        for (f fVar3 = fVar2.f5338b; fVar3 != null; fVar3 = fVar3.f5338b) {
            j G = G((j) fVar.f5337a, (j) fVar3.f5337a);
            if (G != fVar.f5337a) {
                Object obj = fVar3.f5337a;
                if (G == obj) {
                    arrayList.clear();
                    fVar = fVar3;
                } else {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.f5330j = fVar.f();
            return (j) fVar.f5337a;
        }
        throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s", new Object[]{l(), (String) arrayList.stream().map(new e0()).collect(Collectors.joining(" vs "))}));
    }

    /* access modifiers changed from: protected */
    public int I(j jVar) {
        String c10 = jVar.c();
        if (!c10.startsWith("set") || c10.length() <= 3) {
            return 2;
        }
        return 1;
    }

    public void K(f0 f0Var) {
        this.f5327g = a0(this.f5327g, f0Var.f5327g);
        this.f5328h = a0(this.f5328h, f0Var.f5328h);
        this.f5329i = a0(this.f5329i, f0Var.f5329i);
        this.f5330j = a0(this.f5330j, f0Var.f5330j);
    }

    public void L(m mVar, w wVar, boolean z10, boolean z11, boolean z12) {
        this.f5328h = new f(mVar, this.f5328h, wVar, z10, z11, z12);
    }

    public void M(g gVar, w wVar, boolean z10, boolean z11, boolean z12) {
        this.f5327g = new f(gVar, this.f5327g, wVar, z10, z11, z12);
    }

    public void N(j jVar, w wVar, boolean z10, boolean z11, boolean z12) {
        this.f5329i = new f(jVar, this.f5329i, wVar, z10, z11, z12);
    }

    public void O(j jVar, w wVar, boolean z10, boolean z11, boolean z12) {
        this.f5330j = new f(jVar, this.f5330j, wVar, z10, z11, z12);
    }

    public boolean P() {
        if (u(this.f5327g) || u(this.f5329i) || u(this.f5330j) || u(this.f5328h)) {
            return true;
        }
        return false;
    }

    public boolean Q() {
        if (v(this.f5327g) || v(this.f5329i) || v(this.f5330j) || v(this.f5328h)) {
            return true;
        }
        return false;
    }

    /* renamed from: R */
    public int compareTo(f0 f0Var) {
        if (this.f5328h != null) {
            if (f0Var.f5328h == null) {
                return -1;
            }
        } else if (f0Var.f5328h != null) {
            return 1;
        }
        return l().compareTo(f0Var.l());
    }

    public Collection S(Collection collection) {
        HashMap hashMap = new HashMap();
        x(collection, hashMap, this.f5327g);
        x(collection, hashMap, this.f5329i);
        x(collection, hashMap, this.f5330j);
        x(collection, hashMap, this.f5328h);
        return hashMap.values();
    }

    public u.a T() {
        return (u.a) W(new d(), u.a.AUTO);
    }

    public Set U() {
        Set y10 = y(this.f5328h, y(this.f5330j, y(this.f5329i, y(this.f5327g, (Set) null))));
        if (y10 == null) {
            return Collections.emptySet();
        }
        return y10;
    }

    /* access modifiers changed from: protected */
    public Object V(g gVar) {
        f fVar;
        f fVar2;
        Object obj = null;
        if (this.f5324d == null) {
            return null;
        }
        if (this.f5322b) {
            f fVar3 = this.f5329i;
            if (fVar3 != null) {
                obj = gVar.a((i) fVar3.f5337a);
            }
        } else {
            f fVar4 = this.f5328h;
            if (fVar4 != null) {
                obj = gVar.a((i) fVar4.f5337a);
            }
            if (obj == null && (fVar2 = this.f5330j) != null) {
                obj = gVar.a((i) fVar2.f5337a);
            }
        }
        if (obj != null || (fVar = this.f5327g) == null) {
            return obj;
        }
        return gVar.a((i) fVar.f5337a);
    }

    /* access modifiers changed from: protected */
    public Object W(g gVar, Object obj) {
        Object a10;
        Object a11;
        Object a12;
        Object a13;
        Object a14;
        Object a15;
        Object a16;
        Object a17;
        if (this.f5324d == null) {
            return null;
        }
        if (this.f5322b) {
            f fVar = this.f5329i;
            if (fVar != null && (a17 = gVar.a((i) fVar.f5337a)) != null && a17 != obj) {
                return a17;
            }
            f fVar2 = this.f5327g;
            if (fVar2 != null && (a16 = gVar.a((i) fVar2.f5337a)) != null && a16 != obj) {
                return a16;
            }
            f fVar3 = this.f5328h;
            if (fVar3 != null && (a15 = gVar.a((i) fVar3.f5337a)) != null && a15 != obj) {
                return a15;
            }
            f fVar4 = this.f5330j;
            if (fVar4 == null || (a14 = gVar.a((i) fVar4.f5337a)) == null || a14 == obj) {
                return null;
            }
            return a14;
        }
        f fVar5 = this.f5328h;
        if (fVar5 != null && (a13 = gVar.a((i) fVar5.f5337a)) != null && a13 != obj) {
            return a13;
        }
        f fVar6 = this.f5330j;
        if (fVar6 != null && (a12 = gVar.a((i) fVar6.f5337a)) != null && a12 != obj) {
            return a12;
        }
        f fVar7 = this.f5327g;
        if (fVar7 != null && (a11 = gVar.a((i) fVar7.f5337a)) != null && a11 != obj) {
            return a11;
        }
        f fVar8 = this.f5329i;
        if (fVar8 == null || (a10 = gVar.a((i) fVar8.f5337a)) == null || a10 == obj) {
            return null;
        }
        return a10;
    }

    public String X() {
        return this.f5326f.c();
    }

    /* access modifiers changed from: protected */
    public i Y() {
        if (this.f5322b) {
            f fVar = this.f5329i;
            if (fVar != null) {
                return (i) fVar.f5337a;
            }
            f fVar2 = this.f5327g;
            if (fVar2 != null) {
                return (i) fVar2.f5337a;
            }
            return null;
        }
        f fVar3 = this.f5328h;
        if (fVar3 != null) {
            return (i) fVar3.f5337a;
        }
        f fVar4 = this.f5330j;
        if (fVar4 != null) {
            return (i) fVar4.f5337a;
        }
        f fVar5 = this.f5327g;
        if (fVar5 != null) {
            return (i) fVar5.f5337a;
        }
        f fVar6 = this.f5329i;
        if (fVar6 != null) {
            return (i) fVar6.f5337a;
        }
        return null;
    }

    public j Z() {
        if (this.f5322b) {
            b i10 = i();
            if (i10 == null && (i10 = g()) == null) {
                return o.J();
            }
            return i10.e();
        }
        b f10 = f();
        if (f10 == null) {
            j o10 = o();
            if (o10 != null) {
                return o10.s(0);
            }
            f10 = g();
        }
        if (f10 == null && (f10 = i()) == null) {
            return o.J();
        }
        return f10.e();
    }

    public boolean a() {
        if (this.f5328h == null && this.f5330j == null && this.f5327g == null) {
            return false;
        }
        return true;
    }

    public p.b b() {
        p.b bVar;
        i e10 = e();
        com.fasterxml.jackson.databind.b bVar2 = this.f5324d;
        if (bVar2 == null) {
            bVar = null;
        } else {
            bVar = bVar2.E(e10);
        }
        if (bVar == null) {
            return p.b.c();
        }
        return bVar;
    }

    public void b0(boolean z10) {
        if (z10) {
            f fVar = this.f5329i;
            if (fVar != null) {
                this.f5329i = w(this.f5329i, C(0, fVar, this.f5327g, this.f5328h, this.f5330j));
                return;
            }
            f fVar2 = this.f5327g;
            if (fVar2 != null) {
                this.f5327g = w(this.f5327g, C(0, fVar2, this.f5328h, this.f5330j));
                return;
            }
            return;
        }
        f fVar3 = this.f5328h;
        if (fVar3 != null) {
            this.f5328h = w(this.f5328h, C(0, fVar3, this.f5330j, this.f5327g, this.f5329i));
            return;
        }
        f fVar4 = this.f5330j;
        if (fVar4 != null) {
            this.f5330j = w(this.f5330j, C(0, fVar4, this.f5327g, this.f5329i));
            return;
        }
        f fVar5 = this.f5327g;
        if (fVar5 != null) {
            this.f5327g = w(this.f5327g, C(0, fVar5, this.f5329i));
        }
    }

    public b.a c() {
        b.a aVar;
        b.a aVar2 = this.C;
        if (aVar2 == null) {
            b.a aVar3 = (b.a) V(new b());
            if (aVar3 == null) {
                aVar = X;
            } else {
                aVar = aVar3;
            }
            this.C = aVar;
            return aVar3;
        } else if (aVar2 == X) {
            return null;
        } else {
            return aVar2;
        }
    }

    public void c0() {
        this.f5327g = E(this.f5327g);
        this.f5329i = E(this.f5329i);
        this.f5330j = E(this.f5330j);
        this.f5328h = E(this.f5328h);
    }

    public Class[] d() {
        return (Class[]) V(new a());
    }

    public u.a d0(boolean z10, c0 c0Var) {
        u.a T = T();
        if (T == null) {
            T = u.a.AUTO;
        }
        int i10 = e.f5336a[T.ordinal()];
        if (i10 == 1) {
            if (c0Var != null) {
                c0Var.j(l());
                for (w c10 : U()) {
                    c0Var.j(c10.c());
                }
            }
            this.f5330j = null;
            this.f5328h = null;
            if (!this.f5322b) {
                this.f5327g = null;
            }
        } else if (i10 != 2) {
            if (i10 != 3) {
                this.f5329i = F(this.f5329i);
                this.f5328h = F(this.f5328h);
                if (!z10 || this.f5329i == null) {
                    this.f5327g = F(this.f5327g);
                    this.f5330j = F(this.f5330j);
                }
            } else {
                this.f5329i = null;
                if (this.f5322b) {
                    this.f5327g = null;
                }
            }
        }
        return T;
    }

    public void e0() {
        this.f5327g = J(this.f5327g);
        this.f5329i = J(this.f5329i);
        this.f5330j = J(this.f5330j);
        this.f5328h = J(this.f5328h);
    }

    public m f() {
        f fVar = this.f5328h;
        if (fVar == null) {
            return null;
        }
        while (!(((m) fVar.f5337a).q() instanceof e)) {
            fVar = fVar.f5338b;
            if (fVar == null) {
                return (m) this.f5328h.f5337a;
            }
        }
        return (m) fVar.f5337a;
    }

    public f0 f0(w wVar) {
        return new f0(this, wVar);
    }

    public g g() {
        f fVar = this.f5327g;
        if (fVar == null) {
            return null;
        }
        g gVar = (g) fVar.f5337a;
        f fVar2 = fVar.f5338b;
        while (fVar2 != null) {
            g gVar2 = (g) fVar2.f5337a;
            Class k10 = gVar.k();
            Class k11 = gVar2.k();
            if (k10 != k11) {
                if (k10.isAssignableFrom(k11)) {
                    gVar = gVar2;
                } else if (k11.isAssignableFrom(k10)) {
                }
                fVar2 = fVar2.f5338b;
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + l() + "\": " + gVar.l() + " vs " + gVar2.l());
        }
        return gVar;
    }

    public w h() {
        return this.f5325e;
    }

    public j i() {
        f fVar = this.f5329i;
        if (fVar == null) {
            return null;
        }
        f fVar2 = fVar.f5338b;
        if (fVar2 == null) {
            return (j) fVar.f5337a;
        }
        while (fVar2 != null) {
            Class k10 = ((j) fVar.f5337a).k();
            Class k11 = ((j) fVar2.f5337a).k();
            if (k10 != k11) {
                if (!k10.isAssignableFrom(k11)) {
                    if (k11.isAssignableFrom(k10)) {
                        continue;
                        fVar2 = fVar2.f5338b;
                    }
                }
                fVar = fVar2;
                fVar2 = fVar2.f5338b;
            }
            int B = B((j) fVar2.f5337a);
            int B2 = B((j) fVar.f5337a);
            if (B != B2) {
                if (B >= B2) {
                    fVar2 = fVar2.f5338b;
                }
                fVar = fVar2;
                fVar2 = fVar2.f5338b;
            } else {
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + l() + "\": " + ((j) fVar.f5337a).l() + " vs " + ((j) fVar2.f5337a).l());
            }
        }
        this.f5329i = fVar.f();
        return (j) fVar.f5337a;
    }

    public v j() {
        if (this.f5331w == null) {
            i Y = Y();
            if (Y == null) {
                this.f5331w = v.f5722j;
            } else {
                Boolean g02 = this.f5324d.g0(Y);
                String B = this.f5324d.B(Y);
                Integer G = this.f5324d.G(Y);
                String A = this.f5324d.A(Y);
                if (g02 == null && G == null && A == null) {
                    v vVar = v.f5722j;
                    if (B != null) {
                        vVar = vVar.d(B);
                    }
                    this.f5331w = vVar;
                } else {
                    this.f5331w = v.a(g02, B, G, A);
                }
                if (!this.f5322b) {
                    this.f5331w = A(this.f5331w, Y);
                }
            }
        }
        return this.f5331w;
    }

    public String l() {
        w wVar = this.f5325e;
        if (wVar == null) {
            return null;
        }
        return wVar.c();
    }

    public i m() {
        if (this.f5322b) {
            return e();
        }
        i k10 = k();
        if (k10 == null) {
            return e();
        }
        return k10;
    }

    public Class n() {
        return Z().s();
    }

    public j o() {
        f fVar = this.f5330j;
        if (fVar == null) {
            return null;
        }
        f fVar2 = fVar.f5338b;
        if (fVar2 == null) {
            return (j) fVar.f5337a;
        }
        while (fVar2 != null) {
            j G = G((j) fVar.f5337a, (j) fVar2.f5337a);
            if (G != fVar.f5337a) {
                if (G != fVar2.f5337a) {
                    return H(fVar, fVar2);
                }
                fVar = fVar2;
            }
            fVar2 = fVar2.f5338b;
        }
        this.f5330j = fVar.f();
        return (j) fVar.f5337a;
    }

    public w p() {
        com.fasterxml.jackson.databind.b bVar;
        i m10 = m();
        if (m10 == null || (bVar = this.f5324d) == null) {
            return null;
        }
        return bVar.X(m10);
    }

    public boolean q() {
        if (t(this.f5327g) || t(this.f5329i) || t(this.f5330j) || s(this.f5328h)) {
            return true;
        }
        return false;
    }

    public boolean r() {
        Boolean bool = (Boolean) V(new c());
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[Property '" + this.f5325e + "'; ctors: " + this.f5328h + ", field(s): " + this.f5327g + ", getter(s): " + this.f5329i + ", setter(s): " + this.f5330j + "]";
    }

    protected f0(l lVar, com.fasterxml.jackson.databind.b bVar, boolean z10, w wVar, w wVar2) {
        this.f5323c = lVar;
        this.f5324d = bVar;
        this.f5326f = wVar;
        this.f5325e = wVar2;
        this.f5322b = z10;
    }

    protected f0(f0 f0Var, w wVar) {
        this.f5323c = f0Var.f5323c;
        this.f5324d = f0Var.f5324d;
        this.f5326f = f0Var.f5326f;
        this.f5325e = wVar;
        this.f5327g = f0Var.f5327g;
        this.f5328h = f0Var.f5328h;
        this.f5329i = f0Var.f5329i;
        this.f5330j = f0Var.f5330j;
        this.f5322b = f0Var.f5322b;
    }
}
