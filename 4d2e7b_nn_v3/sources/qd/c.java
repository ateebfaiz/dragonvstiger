package qd;

import java.io.Serializable;

class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private r f1869a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1870b;

    /* renamed from: c  reason: collision with root package name */
    private int f1871c;

    /* renamed from: d  reason: collision with root package name */
    private int f1872d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1873e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1874f = false;

    c(int i10) {
        this.f1870b = i10;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        if (!this.f1873e || this.f1874f) {
            return Integer.MAX_VALUE;
        }
        return this.f1871c;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1872d;
    }

    public r c() {
        return this.f1869a.clone();
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        this.f1869a = null;
        this.f1871c = this.f1870b;
        this.f1872d = i10;
        this.f1873e = true;
        this.f1874f = false;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f1874f;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f1873e;
    }

    /* access modifiers changed from: package-private */
    public void h(r rVar) {
        this.f1869a = rVar;
        int b10 = rVar.b();
        this.f1871c = b10;
        if (b10 == this.f1870b) {
            this.f1874f = true;
        }
    }

    /* JADX WARNING: type inference failed for: r7v17, types: [qd.n] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(java.util.Stack r5, qd.j r6, byte[] r7, byte[] r8, qd.i r9) {
        /*
            r4 = this;
            if (r9 == 0) goto L_0x021e
            boolean r0 = r4.f1874f
            if (r0 != 0) goto L_0x0216
            boolean r0 = r4.f1873e
            if (r0 == 0) goto L_0x0216
            qd.i$b r0 = new qd.i$b
            r0.<init>()
            int r1 = r9.b()
            qd.n$a r0 = r0.g(r1)
            qd.i$b r0 = (qd.i.b) r0
            long r1 = r9.c()
            qd.n$a r0 = r0.h(r1)
            qd.i$b r0 = (qd.i.b) r0
            int r1 = r4.f1872d
            qd.i$b r0 = r0.p(r1)
            int r1 = r9.e()
            qd.i$b r0 = r0.n(r1)
            int r1 = r9.f()
            qd.i$b r0 = r0.o(r1)
            int r9 = r9.a()
            qd.n$a r9 = r0.f(r9)
            qd.i$b r9 = (qd.i.b) r9
            qd.n r9 = r9.l()
            qd.i r9 = (qd.i) r9
            qd.h$b r0 = new qd.h$b
            r0.<init>()
            int r1 = r9.b()
            qd.n$a r0 = r0.g(r1)
            qd.h$b r0 = (qd.h.b) r0
            long r1 = r9.c()
            qd.n$a r0 = r0.h(r1)
            qd.h$b r0 = (qd.h.b) r0
            int r1 = r4.f1872d
            qd.h$b r0 = r0.n(r1)
            qd.n r0 = r0.l()
            qd.h r0 = (qd.h) r0
            qd.f$b r1 = new qd.f$b
            r1.<init>()
            int r2 = r9.b()
            qd.n$a r1 = r1.g(r2)
            qd.f$b r1 = (qd.f.b) r1
            long r2 = r9.c()
            qd.n$a r1 = r1.h(r2)
            qd.f$b r1 = (qd.f.b) r1
            int r2 = r4.f1872d
            qd.f$b r1 = r1.n(r2)
            qd.n r1 = r1.k()
            qd.f r1 = (qd.f) r1
            byte[] r8 = r6.g(r8, r9)
            r6.h(r8, r7)
            qd.m r7 = r6.e(r9)
            qd.r r7 = qd.s.a(r6, r7, r0)
        L_0x00a2:
            boolean r8 = r5.isEmpty()
            r9 = 1
            if (r8 != 0) goto L_0x0159
            java.lang.Object r8 = r5.peek()
            qd.r r8 = (qd.r) r8
            int r8 = r8.b()
            int r0 = r7.b()
            if (r8 != r0) goto L_0x0159
            java.lang.Object r8 = r5.peek()
            qd.r r8 = (qd.r) r8
            int r8 = r8.b()
            int r0 = r4.f1870b
            if (r8 == r0) goto L_0x0159
            qd.f$b r8 = new qd.f$b
            r8.<init>()
            int r0 = r1.b()
            qd.n$a r8 = r8.g(r0)
            qd.f$b r8 = (qd.f.b) r8
            long r2 = r1.c()
            qd.n$a r8 = r8.h(r2)
            qd.f$b r8 = (qd.f.b) r8
            int r0 = r1.e()
            qd.f$b r8 = r8.m(r0)
            int r0 = r1.f()
            int r0 = r0 - r9
            int r0 = r0 / 2
            qd.f$b r8 = r8.n(r0)
            int r0 = r1.a()
            qd.n$a r8 = r8.f(r0)
            qd.f$b r8 = (qd.f.b) r8
            qd.n r8 = r8.k()
            qd.f r8 = (qd.f) r8
            java.lang.Object r0 = r5.pop()
            qd.r r0 = (qd.r) r0
            qd.r r7 = qd.s.b(r6, r0, r7, r8)
            qd.r r0 = new qd.r
            int r1 = r7.b()
            int r1 = r1 + r9
            byte[] r7 = r7.c()
            r0.<init>(r1, r7)
            qd.f$b r7 = new qd.f$b
            r7.<init>()
            int r1 = r8.b()
            qd.n$a r7 = r7.g(r1)
            qd.f$b r7 = (qd.f.b) r7
            long r1 = r8.c()
            qd.n$a r7 = r7.h(r1)
            qd.f$b r7 = (qd.f.b) r7
            int r1 = r8.e()
            int r1 = r1 + r9
            qd.f$b r7 = r7.m(r1)
            int r9 = r8.f()
            qd.f$b r7 = r7.n(r9)
            int r8 = r8.a()
            qd.n$a r7 = r7.f(r8)
            qd.f$b r7 = (qd.f.b) r7
            qd.n r7 = r7.k()
            r1 = r7
            qd.f r1 = (qd.f) r1
            r7 = r0
            goto L_0x00a2
        L_0x0159:
            qd.r r8 = r4.f1869a
            if (r8 != 0) goto L_0x0161
            r4.f1869a = r7
            goto L_0x01fd
        L_0x0161:
            int r8 = r8.b()
            int r0 = r7.b()
            if (r8 != r0) goto L_0x01fa
            qd.f$b r5 = new qd.f$b
            r5.<init>()
            int r8 = r1.b()
            qd.n$a r5 = r5.g(r8)
            qd.f$b r5 = (qd.f.b) r5
            long r2 = r1.c()
            qd.n$a r5 = r5.h(r2)
            qd.f$b r5 = (qd.f.b) r5
            int r8 = r1.e()
            qd.f$b r5 = r5.m(r8)
            int r8 = r1.f()
            int r8 = r8 - r9
            int r8 = r8 / 2
            qd.f$b r5 = r5.n(r8)
            int r8 = r1.a()
            qd.n$a r5 = r5.f(r8)
            qd.f$b r5 = (qd.f.b) r5
            qd.n r5 = r5.k()
            qd.f r5 = (qd.f) r5
            qd.r r8 = r4.f1869a
            qd.r r6 = qd.s.b(r6, r8, r7, r5)
            qd.r r7 = new qd.r
            qd.r r8 = r4.f1869a
            int r8 = r8.b()
            int r8 = r8 + r9
            byte[] r6 = r6.c()
            r7.<init>(r8, r6)
            r4.f1869a = r7
            qd.f$b r6 = new qd.f$b
            r6.<init>()
            int r8 = r5.b()
            qd.n$a r6 = r6.g(r8)
            qd.f$b r6 = (qd.f.b) r6
            long r0 = r5.c()
            qd.n$a r6 = r6.h(r0)
            qd.f$b r6 = (qd.f.b) r6
            int r8 = r5.e()
            int r8 = r8 + r9
            qd.f$b r6 = r6.m(r8)
            int r8 = r5.f()
            qd.f$b r6 = r6.n(r8)
            int r5 = r5.a()
            qd.n$a r5 = r6.f(r5)
            qd.f$b r5 = (qd.f.b) r5
            qd.n r5 = r5.k()
            qd.f r5 = (qd.f) r5
            goto L_0x01fd
        L_0x01fa:
            r5.push(r7)
        L_0x01fd:
            qd.r r5 = r4.f1869a
            int r5 = r5.b()
            int r6 = r4.f1870b
            if (r5 != r6) goto L_0x020a
            r4.f1874f = r9
            goto L_0x0215
        L_0x020a:
            int r5 = r7.b()
            r4.f1871c = r5
            int r5 = r4.f1872d
            int r5 = r5 + r9
            r4.f1872d = r5
        L_0x0215:
            return
        L_0x0216:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "finished or not initialized"
            r5.<init>(r6)
            throw r5
        L_0x021e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "otsHashAddress == null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.c.i(java.util.Stack, qd.j, byte[], byte[], qd.i):void");
    }
}
