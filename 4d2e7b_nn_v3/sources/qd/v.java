package qd;

import java.io.IOException;
import zd.d;

public final class v extends vc.a {

    /* renamed from: b  reason: collision with root package name */
    private final u f1956b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1957c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1958d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f1959e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f1960f;

    /* renamed from: g  reason: collision with root package name */
    private final a f1961g;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final u f1962a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f1963b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public byte[] f1964c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f1965d = null;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public byte[] f1966e = null;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public byte[] f1967f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public a f1968g = null;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public byte[] f1969h = null;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public u f1970i = null;

        public b(u uVar) {
            this.f1962a = uVar;
        }

        public v j() {
            return new v(this);
        }

        public b k(a aVar) {
            this.f1968g = aVar;
            return this;
        }

        public b l(int i10) {
            this.f1963b = i10;
            return this;
        }

        public b m(byte[] bArr) {
            this.f1966e = x.c(bArr);
            return this;
        }

        public b n(byte[] bArr) {
            this.f1967f = x.c(bArr);
            return this;
        }

        public b o(byte[] bArr) {
            this.f1965d = x.c(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f1964c = x.c(bArr);
            return this;
        }
    }

    public u a() {
        return this.f1956b;
    }

    public byte[] b() {
        int c10 = this.f1956b.c();
        byte[] bArr = new byte[(c10 + 4 + c10 + c10 + c10)];
        d.c(this.f1961g.b(), bArr, 0);
        x.e(bArr, this.f1957c, 4);
        int i10 = 4 + c10;
        x.e(bArr, this.f1958d, i10);
        int i11 = i10 + c10;
        x.e(bArr, this.f1959e, i11);
        x.e(bArr, this.f1960f, i11 + c10);
        try {
            return zd.a.i(bArr, x.o(this.f1961g));
        } catch (IOException e10) {
            throw new RuntimeException("error serializing bds state: " + e10.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private v(qd.v.b r8) {
        /*
            r7 = this;
            r0 = 1
            r7.<init>(r0)
            qd.u r2 = r8.f1962a
            r7.f1956b = r2
            if (r2 == 0) goto L_0x012d
            int r1 = r2.c()
            byte[] r3 = r8.f1969h
            if (r3 == 0) goto L_0x008e
            qd.u r0 = r8.f1970i
            if (r0 == 0) goto L_0x0086
            int r0 = r2.d()
            r2 = 0
            int r2 = zd.d.a(r3, r2)
            long r4 = (long) r2
            boolean r0 = qd.x.l(r0, r4)
            if (r0 == 0) goto L_0x007e
            r0 = 4
            byte[] r4 = qd.x.g(r3, r0, r1)
            r7.f1957c = r4
            int r0 = r0 + r1
            byte[] r4 = qd.x.g(r3, r0, r1)
            r7.f1958d = r4
            int r0 = r0 + r1
            byte[] r4 = qd.x.g(r3, r0, r1)
            r7.f1959e = r4
            int r0 = r0 + r1
            byte[] r4 = qd.x.g(r3, r0, r1)
            r7.f1960f = r4
            int r0 = r0 + r1
            int r1 = r3.length
            int r1 = r1 - r0
            byte[] r0 = qd.x.g(r3, r0, r1)
            java.lang.Object r0 = qd.x.f(r0)     // Catch:{ IOException -> 0x0058, ClassNotFoundException -> 0x0056 }
            qd.a r0 = (qd.a) r0     // Catch:{ IOException -> 0x0058, ClassNotFoundException -> 0x0056 }
            goto L_0x0062
        L_0x0056:
            r0 = move-exception
            goto L_0x005a
        L_0x0058:
            r0 = move-exception
            goto L_0x005e
        L_0x005a:
            r0.printStackTrace()
            goto L_0x0061
        L_0x005e:
            r0.printStackTrace()
        L_0x0061:
            r0 = 0
        L_0x0062:
            qd.u r8 = r8.f1970i
            r0.f(r8)
            r0.h()
            int r8 = r0.b()
            if (r8 != r2) goto L_0x0076
            r7.f1961g = r0
            goto L_0x012c
        L_0x0076:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "serialized BDS has wrong index"
            r8.<init>(r0)
            throw r8
        L_0x007e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "index out of bounds"
            r8.<init>(r0)
            throw r8
        L_0x0086:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "xmss == null"
            r8.<init>(r0)
            throw r8
        L_0x008e:
            byte[] r4 = r8.f1964c
            if (r4 == 0) goto L_0x00a2
            int r3 = r4.length
            if (r3 != r1) goto L_0x009a
            r7.f1957c = r4
            goto L_0x00a6
        L_0x009a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of secretKeySeed needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00a2:
            byte[] r3 = new byte[r1]
            r7.f1957c = r3
        L_0x00a6:
            byte[] r3 = r8.f1965d
            if (r3 == 0) goto L_0x00ba
            int r5 = r3.length
            if (r5 != r1) goto L_0x00b2
            r7.f1958d = r3
            goto L_0x00be
        L_0x00b2:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of secretKeyPRF needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00ba:
            byte[] r3 = new byte[r1]
            r7.f1958d = r3
        L_0x00be:
            byte[] r3 = r8.f1966e
            if (r3 == 0) goto L_0x00d2
            int r5 = r3.length
            if (r5 != r1) goto L_0x00ca
            r7.f1959e = r3
            goto L_0x00d6
        L_0x00ca:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of publicSeed needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00d2:
            byte[] r5 = new byte[r1]
            r7.f1959e = r5
        L_0x00d6:
            byte[] r5 = r8.f1967f
            if (r5 == 0) goto L_0x00ea
            int r6 = r5.length
            if (r6 != r1) goto L_0x00e2
            r7.f1960f = r5
            goto L_0x00ee
        L_0x00e2:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "size of root needs to be equal size of digest"
            r8.<init>(r0)
            throw r8
        L_0x00ea:
            byte[] r1 = new byte[r1]
            r7.f1960f = r1
        L_0x00ee:
            qd.a r1 = r8.f1968g
            if (r1 == 0) goto L_0x00f7
            r7.f1961g = r1
            goto L_0x012c
        L_0x00f7:
            int r1 = r8.f1963b
            int r5 = r2.d()
            int r0 = r0 << r5
            int r0 = r0 + -2
            if (r1 >= r0) goto L_0x0121
            if (r3 == 0) goto L_0x0121
            if (r4 == 0) goto L_0x0121
            qd.a r0 = new qd.a
            qd.i$b r1 = new qd.i$b
            r1.<init>()
            qd.n r1 = r1.l()
            r5 = r1
            qd.i r5 = (qd.i) r5
            int r6 = r8.f1963b
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            r7.f1961g = r0
            goto L_0x012c
        L_0x0121:
            qd.a r0 = new qd.a
            int r8 = r8.f1963b
            r0.<init>(r2, r8)
            r7.f1961g = r0
        L_0x012c:
            return
        L_0x012d:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "params == null"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.v.<init>(qd.v$b):void");
    }
}
