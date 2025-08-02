package com.bugsnag.android;

import c1.j;
import c1.l;
import c1.n;
import c1.p;
import c1.u;
import com.bugsnag.android.k2;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class r1 implements k2.a {
    public i1 C;
    private String N0;
    private String O0;
    private l P0;
    private k4 Q0;
    private h4 R0;
    private List X;
    private List Y;
    private List Z;

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f18953a;

    /* renamed from: b  reason: collision with root package name */
    private q3 f18954b;

    /* renamed from: c  reason: collision with root package name */
    private final s2 f18955c;

    /* renamed from: d  reason: collision with root package name */
    private final y2 f18956d;

    /* renamed from: e  reason: collision with root package name */
    private final c2 f18957e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f18958f;

    /* renamed from: g  reason: collision with root package name */
    private Collection f18959g;

    /* renamed from: h  reason: collision with root package name */
    private final g3 f18960h;

    /* renamed from: i  reason: collision with root package name */
    public l3 f18961i;

    /* renamed from: j  reason: collision with root package name */
    private String f18962j;

    /* renamed from: w  reason: collision with root package name */
    public m f18963w;

    public r1(Throwable th, j jVar, q3 q3Var, y2 y2Var) {
        this(th, jVar, q3Var, y2Var, (c2) null, 16, (DefaultConstructorMarker) null);
    }

    public final void A(Collection collection) {
        Iterable iterable = collection;
        this.f18960h.h(r.A0(iterable));
        this.f18956d.m(r.A0(iterable));
    }

    public final void B(h4 h4Var) {
        this.R0 = h4Var;
    }

    public void C(String str, String str2, String str3) {
        this.Q0 = new k4(str, str2, str3);
    }

    public final void D(k4 k4Var) {
        this.Q0 = k4Var;
    }

    public final u E(int i10) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10 && (!this.X.isEmpty())) {
            i11 += p.f17266a.g((Breadcrumb) this.X.remove(0)).length;
            i12++;
        }
        if (i12 == 1) {
            this.X.add(new Breadcrumb("Removed to reduce payload size", this.f18955c));
        } else {
            List list = this.X;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Removed, along with ");
            sb2.append(i12 - 1);
            sb2.append(" older breadcrumbs, to reduce payload size");
            list.add(new Breadcrumb(sb2.toString(), this.f18955c));
        }
        return new u(i12, i11);
    }

    public final u F(int i10) {
        u o10 = this.f18956d.o(i10);
        int d10 = o10.d();
        int c10 = o10.c();
        for (Breadcrumb breadcrumb : this.X) {
            u a10 = breadcrumb.impl.a(i10);
            d10 += a10.d();
            c10 += a10.c();
        }
        return new u(d10, c10);
    }

    /* access modifiers changed from: protected */
    public final void G(Severity severity) {
        this.f18954b = new q3(this.f18954b.e(), severity, this.f18954b.f(), this.f18954b.g(), this.f18954b.c(), this.f18954b.b());
    }

    public final void H(q3 q3Var) {
        this.f18954b = q3Var;
    }

    public void a(String str, String str2) {
        this.f18957e.a(str, str2);
    }

    public void b(String str, String str2, Object obj) {
        this.f18956d.a(str, str2, obj);
    }

    public void c(String str, Map map) {
        this.f18956d.b(str, map);
    }

    public void d() {
        this.f18957e.c();
    }

    public final String e() {
        return this.f18962j;
    }

    public final m f() {
        m mVar = this.f18963w;
        if (mVar != null) {
            return mVar;
        }
        m.u("app");
        return null;
    }

    public final List g() {
        return this.X;
    }

    public final i1 h() {
        i1 i1Var = this.C;
        if (i1Var != null) {
            return i1Var;
        }
        m.u("device");
        return null;
    }

    public final Set i() {
        ArrayList arrayList = new ArrayList();
        for (k1 e10 : this.Y) {
            ErrorType e11 = e10.e();
            if (e11 != null) {
                arrayList.add(e11);
            }
        }
        Set A0 = r.A0(arrayList);
        Iterable<k1> iterable = this.Y;
        ArrayList<List> arrayList2 = new ArrayList<>(r.v(iterable, 10));
        for (k1 d10 : iterable) {
            arrayList2.add(d10.d());
        }
        ArrayList arrayList3 = new ArrayList();
        for (List<s3> it : arrayList2) {
            ArrayList arrayList4 = new ArrayList();
            for (s3 h10 : it) {
                ErrorType h11 = h10.h();
                if (h11 != null) {
                    arrayList4.add(h11);
                }
            }
            r.z(arrayList3, arrayList4);
        }
        return r0.j(A0, arrayList3);
    }

    public final List j() {
        return this.Y;
    }

    public final l k() {
        return this.P0;
    }

    public final boolean l() {
        return this.f18954b.f18950g;
    }

    public final Severity m() {
        return this.f18954b.d();
    }

    public final String n() {
        return this.f18954b.e();
    }

    public final List o() {
        return this.Z;
    }

    public final boolean p() {
        return this.f18954b.f();
    }

    /* access modifiers changed from: protected */
    public final boolean q(o1 o1Var) {
        String str;
        List h10 = o1Var.h();
        if (!h10.isEmpty()) {
            str = ((k1) h10.get(0)).b();
        } else {
            str = null;
        }
        return m.b("ANR", str);
    }

    public final void r() {
        if (i().size() == 1) {
            ArrayList<s3> arrayList = new ArrayList<>();
            for (k1 d10 : this.Y) {
                r.z(arrayList, d10.d());
            }
            for (s3 i10 : arrayList) {
                i10.i((ErrorType) null);
            }
        }
    }

    public final void s(String str) {
        this.f18962j = str;
    }

    public final void t(m mVar) {
        this.f18963w = mVar;
    }

    public void toStream(k2 k2Var) {
        k2 k2Var2 = new k2(k2Var, this.f18960h);
        k2Var2.j();
        k2Var2.v("context").K(this.O0);
        k2Var2.v("metaData").P(this.f18956d);
        k2Var2.v("severity").P(m());
        k2Var2.v("severityReason").P(this.f18954b);
        k2Var2.v("unhandled").L(this.f18954b.f());
        k2Var2.v("exceptions");
        k2Var2.h();
        for (k1 P : this.Y) {
            k2Var2.P(P);
        }
        k2Var2.m();
        k2Var2.v("projectPackages");
        k2Var2.h();
        for (String K : this.f18959g) {
            k2Var2.K(K);
        }
        k2Var2.m();
        k2Var2.v("user").P(this.Q0);
        k2Var2.v("app").P(f());
        k2Var2.v("device").P(h());
        k2Var2.v("breadcrumbs").P(this.X);
        k2Var2.v("groupingHash").K(this.N0);
        Map d10 = this.P0.d();
        if (!d10.isEmpty()) {
            k2Var2.v("usage");
            k2Var2.j();
            for (Map.Entry entry : d10.entrySet()) {
                k2Var2.v((String) entry.getKey()).P(entry.getValue());
            }
            k2Var2.n();
        }
        k2Var2.v("threads");
        k2Var2.h();
        for (a4 P2 : this.Z) {
            k2Var2.P(P2);
        }
        k2Var2.m();
        k2Var2.v("featureFlags").P(this.f18957e);
        h4 h4Var = this.R0;
        if (h4Var != null) {
            k2Var2.v("correlation").P(h4Var);
        }
        l3 l3Var = this.f18961i;
        if (l3Var != null) {
            l3 b10 = l3.b(l3Var);
            k2Var2.v("session").j();
            k2Var2.v("id").K(b10.e());
            k2Var2.v("startedAt").P(b10.g());
            k2Var2.v(DbParams.TABLE_EVENTS).j();
            k2Var2.v("handled").H((long) b10.d());
            k2Var2.v("unhandled").H((long) b10.h());
            k2Var2.n();
            k2Var2.n();
        }
        k2Var2.n();
    }

    public final void u(List list) {
        this.X = list;
    }

    public final void v(String str) {
        this.O0 = str;
    }

    public final void w(i1 i1Var) {
        this.C = i1Var;
    }

    public final void x(String str) {
        this.N0 = str;
    }

    public final void y(l lVar) {
        this.P0 = lVar;
    }

    public final void z(Collection collection) {
        this.f18959g = collection;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r1(Throwable th, j jVar, q3 q3Var, y2 y2Var, c2 c2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : th, jVar, q3Var, (i10 & 8) != 0 ? new y2((Map) null, 1, (DefaultConstructorMarker) null) : y2Var, (i10 & 16) != 0 ? new c2() : c2Var);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r1(java.lang.Throwable r21, c1.j r22, com.bugsnag.android.q3 r23, com.bugsnag.android.y2 r24, com.bugsnag.android.c2 r25) {
        /*
            r20 = this;
            r8 = r21
            java.lang.String r1 = r22.a()
            com.bugsnag.android.s2 r2 = r22.r()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r0 = r22.j()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r4 = kotlin.collections.r.A0(r0)
            if (r8 != 0) goto L_0x0022
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0020:
            r5 = r0
            goto L_0x002f
        L_0x0022:
            java.util.Collection r0 = r22.A()
            com.bugsnag.android.s2 r5 = r22.r()
            java.util.List r0 = com.bugsnag.android.k1.a(r8, r0, r5)
            goto L_0x0020
        L_0x002f:
            com.bugsnag.android.y2 r6 = r24.e()
            com.bugsnag.android.c2 r7 = r25.d()
            java.util.Collection r9 = r22.A()
            com.bugsnag.android.f4 r0 = new com.bugsnag.android.f4
            boolean r10 = r23.f()
            r11 = r22
            r0.<init>(r8, r10, r11)
            java.util.List r12 = r0.c()
            com.bugsnag.android.k4 r19 = new com.bugsnag.android.k4
            r17 = 7
            r18 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r13 = r19
            r13.<init>(r14, r15, r16, r17, r18)
            java.util.Collection r0 = r22.B()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r13 = kotlin.collections.r.A0(r0)
            r0 = r20
            r8 = r21
            r10 = r23
            r11 = r12
            r12 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r1.<init>(java.lang.Throwable, c1.j, com.bugsnag.android.q3, com.bugsnag.android.y2, com.bugsnag.android.c2):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ r1(java.lang.String r18, com.bugsnag.android.s2 r19, java.util.List r20, java.util.Set r21, java.util.List r22, com.bugsnag.android.y2 r23, com.bugsnag.android.c2 r24, java.lang.Throwable r25, java.util.Collection r26, com.bugsnag.android.q3 r27, java.util.List r28, com.bugsnag.android.k4 r29, java.util.Set r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000d
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5 = r1
            goto L_0x000f
        L_0x000d:
            r5 = r20
        L_0x000f:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0019
            java.util.Set r1 = kotlin.collections.r0.d()
            r6 = r1
            goto L_0x001b
        L_0x0019:
            r6 = r21
        L_0x001b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0026
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7 = r1
            goto L_0x0028
        L_0x0026:
            r7 = r22
        L_0x0028:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0035
            com.bugsnag.android.y2 r1 = new com.bugsnag.android.y2
            r3 = 1
            r1.<init>(r2, r3, r2)
            r8 = r1
            goto L_0x0037
        L_0x0035:
            r8 = r23
        L_0x0037:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0042
            com.bugsnag.android.c2 r1 = new com.bugsnag.android.c2
            r1.<init>()
            r9 = r1
            goto L_0x0044
        L_0x0042:
            r9 = r24
        L_0x0044:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004a
            r10 = r2
            goto L_0x004c
        L_0x004a:
            r10 = r25
        L_0x004c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0058
            java.util.Set r1 = kotlin.collections.r0.d()
            java.util.Collection r1 = (java.util.Collection) r1
            r11 = r1
            goto L_0x005a
        L_0x0058:
            r11 = r26
        L_0x005a:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0066
            java.lang.String r1 = "handledException"
            com.bugsnag.android.q3 r1 = com.bugsnag.android.q3.h(r1)
            r12 = r1
            goto L_0x0068
        L_0x0066:
            r12 = r27
        L_0x0068:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0073
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r13 = r1
            goto L_0x0075
        L_0x0073:
            r13 = r28
        L_0x0075:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0092
            com.bugsnag.android.k4 r1 = new com.bugsnag.android.k4
            r3 = 7
            r4 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = r1
            r21 = r14
            r22 = r15
            r23 = r16
            r24 = r3
            r25 = r4
            r20.<init>(r21, r22, r23, r24, r25)
            r14 = r1
            goto L_0x0094
        L_0x0092:
            r14 = r29
        L_0x0094:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x009a
            r15 = r2
            goto L_0x009c
        L_0x009a:
            r15 = r30
        L_0x009c:
            r2 = r17
            r3 = r18
            r4 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.r1.<init>(java.lang.String, com.bugsnag.android.s2, java.util.List, java.util.Set, java.util.List, com.bugsnag.android.y2, com.bugsnag.android.c2, java.lang.Throwable, java.util.Collection, com.bugsnag.android.q3, java.util.List, com.bugsnag.android.k4, java.util.Set, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public r1(String str, s2 s2Var, List list, Set set, List list2, y2 y2Var, c2 c2Var, Throwable th, Collection collection, q3 q3Var, List list3, k4 k4Var, Set set2) {
        g3 g3Var = new g3();
        g3Var.h(r.A0(g3Var.c()));
        this.f18960h = g3Var;
        this.P0 = new n();
        this.f18955c = s2Var;
        this.f18962j = str;
        this.X = list;
        this.f18958f = set;
        this.Y = list2;
        this.f18956d = y2Var;
        this.f18957e = c2Var;
        this.f18953a = th;
        this.f18959g = collection;
        this.f18954b = q3Var;
        this.Z = list3;
        this.Q0 = k4Var;
        if (set2 != null) {
            A(set2);
        }
    }
}
