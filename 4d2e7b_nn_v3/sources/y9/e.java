package y9;

import aa.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private d f13402a = d.f2281g;

    /* renamed from: b  reason: collision with root package name */
    private n f13403b = n.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private c f13404c = b.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map f13405d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List f13406e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List f13407f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f13408g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f13409h = d.f13371z;

    /* renamed from: i  reason: collision with root package name */
    private int f13410i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f13411j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13412k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13413l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13414m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13415n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13416o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13417p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13418q = true;

    /* renamed from: r  reason: collision with root package name */
    private q f13419r = d.B;

    /* renamed from: s  reason: collision with root package name */
    private q f13420s = d.C;

    /* renamed from: t  reason: collision with root package name */
    private final LinkedList f13421t = new LinkedList();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, int r6, int r7, java.util.List r8) {
        /*
            r4 = this;
            boolean r0 = ea.d.f12060a
            r1 = 0
            if (r5 == 0) goto L_0x0026
            java.lang.String r2 = r5.trim()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0026
            ba.d$b r6 = ba.d.b.f2521b
            y9.s r6 = r6.b(r5)
            if (r0 == 0) goto L_0x0024
            ba.d$b r7 = ea.d.f12062c
            y9.s r1 = r7.b(r5)
            ba.d$b r7 = ea.d.f12061b
            y9.s r5 = r7.b(r5)
            goto L_0x0045
        L_0x0024:
            r5 = r1
            goto L_0x0045
        L_0x0026:
            r5 = 2
            if (r6 == r5) goto L_0x0050
            if (r7 == r5) goto L_0x0050
            ba.d$b r5 = ba.d.b.f2521b
            y9.s r5 = r5.a(r6, r7)
            if (r0 == 0) goto L_0x0043
            ba.d$b r1 = ea.d.f12062c
            y9.s r1 = r1.a(r6, r7)
            ba.d$b r2 = ea.d.f12061b
            y9.s r6 = r2.a(r6, r7)
            r3 = r6
            r6 = r5
            r5 = r3
            goto L_0x0045
        L_0x0043:
            r6 = r5
            goto L_0x0024
        L_0x0045:
            r8.add(r6)
            if (r0 == 0) goto L_0x0050
            r8.add(r1)
            r8.add(r5)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y9.e.a(java.lang.String, int, int, java.util.List):void");
    }

    public d b() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.f13406e.size() + this.f13407f.size() + 3);
        arrayList2.addAll(this.f13406e);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.f13407f);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        a(this.f13409h, this.f13410i, this.f13411j, arrayList2);
        d dVar = this.f13402a;
        c cVar = this.f13404c;
        HashMap hashMap = r5;
        HashMap hashMap2 = new HashMap(this.f13405d);
        boolean z10 = this.f13408g;
        boolean z11 = this.f13412k;
        boolean z12 = this.f13416o;
        boolean z13 = this.f13414m;
        boolean z14 = this.f13415n;
        boolean z15 = this.f13417p;
        boolean z16 = this.f13413l;
        boolean z17 = this.f13418q;
        n nVar = this.f13403b;
        String str = this.f13409h;
        int i10 = this.f13410i;
        int i11 = this.f13411j;
        ArrayList arrayList4 = r1;
        d dVar2 = dVar;
        ArrayList arrayList5 = new ArrayList(this.f13406e);
        ArrayList arrayList6 = r1;
        ArrayList arrayList7 = new ArrayList(this.f13407f);
        q qVar = this.f13419r;
        q qVar2 = this.f13420s;
        ArrayList arrayList8 = r1;
        ArrayList arrayList9 = new ArrayList(this.f13421t);
        return new d(dVar2, cVar, hashMap, z10, z11, z12, z13, z14, z15, z16, z17, nVar, str, i10, i11, arrayList4, arrayList6, arrayList, qVar, qVar2, arrayList8);
    }

    public e c() {
        this.f13414m = false;
        return this;
    }

    public e d() {
        this.f13408g = true;
        return this;
    }

    public e e(q qVar) {
        Objects.requireNonNull(qVar);
        this.f13419r = qVar;
        return this;
    }
}
