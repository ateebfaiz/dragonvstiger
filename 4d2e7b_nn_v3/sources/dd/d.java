package dd;

import java.math.BigInteger;
import java.util.Random;
import jd.m;

public abstract class d implements b {

    public static class b extends d {

        /* renamed from: g  reason: collision with root package name */
        BigInteger f150g;

        /* renamed from: h  reason: collision with root package name */
        BigInteger f151h;

        /* renamed from: i  reason: collision with root package name */
        BigInteger f152i;

        b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f150g = bigInteger;
            this.f151h = bigInteger2;
            this.f152i = bigInteger3;
        }

        static BigInteger s(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return b.f122b.shiftLeft(bitLength).subtract(bigInteger);
        }

        private d t(d dVar) {
            if (dVar.n().equals(this)) {
                return dVar;
            }
            return null;
        }

        private BigInteger[] u(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = b.f122b;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = b.f123c;
            BigInteger bigInteger8 = bigInteger6;
            for (int i10 = bitLength - 1; i10 >= lowestSetBit + 1; i10--) {
                bigInteger4 = z(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i10)) {
                    bigInteger8 = z(bigInteger4, bigInteger2);
                    bigInteger6 = z(bigInteger6, bigInteger5);
                    bigInteger7 = A(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = A(bigInteger5.multiply(bigInteger5).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    BigInteger A = A(bigInteger6.multiply(bigInteger7).subtract(bigInteger4));
                    BigInteger A2 = A(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger7 = A(bigInteger7.multiply(bigInteger7).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger5 = A2;
                    bigInteger6 = A;
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger z10 = z(bigInteger4, bigInteger8);
            BigInteger z11 = z(z10, bigInteger2);
            BigInteger A3 = A(bigInteger6.multiply(bigInteger7).subtract(z10));
            BigInteger A4 = A(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(z10)));
            BigInteger z12 = z(z10, z11);
            for (int i11 = 1; i11 <= lowestSetBit; i11++) {
                A3 = z(A3, A4);
                A4 = A(A4.multiply(A4).subtract(z12.shiftLeft(1)));
                z12 = z(z12, z12);
            }
            return new BigInteger[]{A3, A4};
        }

        /* access modifiers changed from: protected */
        public BigInteger A(BigInteger bigInteger) {
            boolean z10;
            if (this.f151h == null) {
                return bigInteger.mod(this.f150g);
            }
            if (bigInteger.signum() < 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f150g.bitLength();
            boolean equals = this.f151h.equals(b.f122b);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f151h);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.f150g) >= 0) {
                bigInteger = bigInteger.subtract(this.f150g);
            }
            if (!z10 || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return this.f150g.subtract(bigInteger);
        }

        /* access modifiers changed from: protected */
        public BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            if (subtract.signum() < 0) {
                return subtract.add(this.f150g);
            }
            return subtract;
        }

        public d a(d dVar) {
            return new b(this.f150g, this.f151h, v(this.f152i, dVar.r()));
        }

        public d b() {
            BigInteger add = this.f152i.add(b.f122b);
            if (add.compareTo(this.f150g) == 0) {
                add = b.f121a;
            }
            return new b(this.f150g, this.f151h, add);
        }

        public d d(d dVar) {
            return new b(this.f150g, this.f151h, z(this.f152i, y(dVar.r())));
        }

        public int e() {
            return this.f150g.bitLength();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f150g.equals(bVar.f150g) || !this.f152i.equals(bVar.f152i)) {
                return false;
            }
            return true;
        }

        public d f() {
            return new b(this.f150g, this.f151h, y(this.f152i));
        }

        public int hashCode() {
            return this.f150g.hashCode() ^ this.f152i.hashCode();
        }

        public d i(d dVar) {
            return new b(this.f150g, this.f151h, z(this.f152i, dVar.r()));
        }

        public d j(d dVar, d dVar2, d dVar3) {
            BigInteger bigInteger = this.f152i;
            BigInteger r10 = dVar.r();
            BigInteger r11 = dVar2.r();
            BigInteger r12 = dVar3.r();
            return new b(this.f150g, this.f151h, A(bigInteger.multiply(r10).subtract(r11.multiply(r12))));
        }

        public d k(d dVar, d dVar2, d dVar3) {
            BigInteger bigInteger = this.f152i;
            BigInteger r10 = dVar.r();
            BigInteger r11 = dVar2.r();
            BigInteger r12 = dVar3.r();
            return new b(this.f150g, this.f151h, A(bigInteger.multiply(r10).add(r11.multiply(r12))));
        }

        public d l() {
            if (this.f152i.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f150g;
            return new b(bigInteger, this.f151h, bigInteger.subtract(this.f152i));
        }

        public d m() {
            if (h() || g()) {
                return this;
            }
            if (!this.f150g.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.f150g.testBit(1)) {
                BigInteger add = this.f150g.shiftRight(2).add(b.f122b);
                BigInteger bigInteger = this.f150g;
                return t(new b(bigInteger, this.f151h, this.f152i.modPow(add, bigInteger)));
            } else if (this.f150g.testBit(2)) {
                BigInteger modPow = this.f152i.modPow(this.f150g.shiftRight(3), this.f150g);
                BigInteger z10 = z(modPow, this.f152i);
                if (z(z10, modPow).equals(b.f122b)) {
                    return t(new b(this.f150g, this.f151h, z10));
                }
                return t(new b(this.f150g, this.f151h, z(z10, b.f123c.modPow(this.f150g.shiftRight(2), this.f150g))));
            } else {
                BigInteger shiftRight = this.f150g.shiftRight(1);
                BigInteger modPow2 = this.f152i.modPow(shiftRight, this.f150g);
                BigInteger bigInteger2 = b.f122b;
                if (!modPow2.equals(bigInteger2)) {
                    return null;
                }
                BigInteger bigInteger3 = this.f152i;
                BigInteger w10 = w(w(bigInteger3));
                BigInteger add2 = shiftRight.add(bigInteger2);
                BigInteger subtract = this.f150g.subtract(bigInteger2);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger4 = new BigInteger(this.f150g.bitLength(), random);
                    if (bigInteger4.compareTo(this.f150g) < 0 && A(bigInteger4.multiply(bigInteger4).subtract(w10)).modPow(shiftRight, this.f150g).equals(subtract)) {
                        BigInteger[] u10 = u(bigInteger4, bigInteger3, add2);
                        BigInteger bigInteger5 = u10[0];
                        BigInteger bigInteger6 = u10[1];
                        if (z(bigInteger6, bigInteger6).equals(w10)) {
                            return new b(this.f150g, this.f151h, x(bigInteger6));
                        }
                        if (!bigInteger5.equals(b.f122b) && !bigInteger5.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        public d n() {
            BigInteger bigInteger = this.f150g;
            BigInteger bigInteger2 = this.f151h;
            BigInteger bigInteger3 = this.f152i;
            return new b(bigInteger, bigInteger2, z(bigInteger3, bigInteger3));
        }

        public d o(d dVar, d dVar2) {
            BigInteger bigInteger = this.f152i;
            BigInteger r10 = dVar.r();
            BigInteger r11 = dVar2.r();
            return new b(this.f150g, this.f151h, A(bigInteger.multiply(bigInteger).add(r10.multiply(r11))));
        }

        public d p(d dVar) {
            return new b(this.f150g, this.f151h, B(this.f152i, dVar.r()));
        }

        public BigInteger r() {
            return this.f152i;
        }

        /* access modifiers changed from: protected */
        public BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            if (add.compareTo(this.f150g) >= 0) {
                return add.subtract(this.f150g);
            }
            return add;
        }

        /* access modifiers changed from: protected */
        public BigInteger w(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            if (shiftLeft.compareTo(this.f150g) >= 0) {
                return shiftLeft.subtract(this.f150g);
            }
            return shiftLeft;
        }

        /* access modifiers changed from: protected */
        public BigInteger x(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f150g.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* access modifiers changed from: protected */
        public BigInteger y(BigInteger bigInteger) {
            int e10 = e();
            int i10 = (e10 + 31) >> 5;
            int[] n10 = m.n(e10, this.f150g);
            int[] n11 = m.n(e10, bigInteger);
            int[] i11 = m.i(i10);
            jd.b.d(n10, n11, i11);
            return m.O(i10, i11);
        }

        /* access modifiers changed from: protected */
        public BigInteger z(BigInteger bigInteger, BigInteger bigInteger2) {
            return A(bigInteger.multiply(bigInteger2));
        }
    }

    public abstract d a(d dVar);

    public abstract d b();

    public int c() {
        return r().bitLength();
    }

    public abstract d d(d dVar);

    public abstract int e();

    public abstract d f();

    public boolean g() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (r().signum() == 0) {
            return true;
        }
        return false;
    }

    public abstract d i(d dVar);

    public d j(d dVar, d dVar2, d dVar3) {
        return i(dVar).p(dVar2.i(dVar3));
    }

    public d k(d dVar, d dVar2, d dVar3) {
        return i(dVar).a(dVar2.i(dVar3));
    }

    public abstract d l();

    public abstract d m();

    public abstract d n();

    public d o(d dVar, d dVar2) {
        return n().a(dVar.i(dVar2));
    }

    public abstract d p(d dVar);

    public boolean q() {
        return r().testBit(0);
    }

    public abstract BigInteger r();

    public String toString() {
        return r().toString(16);
    }

    public static class a extends d {

        /* renamed from: g  reason: collision with root package name */
        private int f146g;

        /* renamed from: h  reason: collision with root package name */
        private int f147h;

        /* renamed from: i  reason: collision with root package name */
        private int[] f148i;

        /* renamed from: j  reason: collision with root package name */
        private h f149j;

        public a(int i10, int i11, int i12, int i13, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i12 == 0 && i13 == 0) {
                this.f146g = 2;
                this.f148i = new int[]{i11};
            } else if (i12 >= i13) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i12 > 0) {
                this.f146g = 3;
                this.f148i = new int[]{i11, i12, i13};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.f147h = i10;
            this.f149j = new h(bigInteger);
        }

        public static void s(d dVar, d dVar2) {
            if (!(dVar instanceof a) || !(dVar2 instanceof a)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            a aVar = (a) dVar;
            a aVar2 = (a) dVar2;
            if (aVar.f146g != aVar2.f146g) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (aVar.f147h != aVar2.f147h || !zd.a.c(aVar.f148i, aVar2.f148i)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        public d a(d dVar) {
            h hVar = (h) this.f149j.clone();
            hVar.f(((a) dVar).f149j, 0);
            return new a(this.f147h, this.f148i, hVar);
        }

        public d b() {
            return new a(this.f147h, this.f148i, this.f149j.d());
        }

        public int c() {
            return this.f149j.j();
        }

        public d d(d dVar) {
            return i(dVar.f());
        }

        public int e() {
            return this.f147h;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f147h != aVar.f147h || this.f146g != aVar.f146g || !zd.a.c(this.f148i, aVar.f148i) || !this.f149j.equals(aVar.f149j)) {
                return false;
            }
            return true;
        }

        public d f() {
            int i10 = this.f147h;
            int[] iArr = this.f148i;
            return new a(i10, iArr, this.f149j.t(i10, iArr));
        }

        public boolean g() {
            return this.f149j.r();
        }

        public boolean h() {
            return this.f149j.s();
        }

        public int hashCode() {
            return (this.f149j.hashCode() ^ this.f147h) ^ zd.a.o(this.f148i);
        }

        public d i(d dVar) {
            int i10 = this.f147h;
            int[] iArr = this.f148i;
            return new a(i10, iArr, this.f149j.u(((a) dVar).f149j, i10, iArr));
        }

        public d j(d dVar, d dVar2, d dVar3) {
            return k(dVar, dVar2, dVar3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: dd.h} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public dd.d k(dd.d r5, dd.d r6, dd.d r7) {
            /*
                r4 = this;
                dd.h r0 = r4.f149j
                dd.d$a r5 = (dd.d.a) r5
                dd.h r5 = r5.f149j
                dd.d$a r6 = (dd.d.a) r6
                dd.h r6 = r6.f149j
                dd.d$a r7 = (dd.d.a) r7
                dd.h r7 = r7.f149j
                int r1 = r4.f147h
                int[] r2 = r4.f148i
                dd.h r1 = r0.x(r5, r1, r2)
                int r2 = r4.f147h
                int[] r3 = r4.f148i
                dd.h r6 = r6.x(r7, r2, r3)
                if (r1 == r0) goto L_0x0022
                if (r1 != r5) goto L_0x0029
            L_0x0022:
                java.lang.Object r5 = r1.clone()
                r1 = r5
                dd.h r1 = (dd.h) r1
            L_0x0029:
                r5 = 0
                r1.f(r6, r5)
                int r5 = r4.f147h
                int[] r6 = r4.f148i
                r1.z(r5, r6)
                dd.d$a r5 = new dd.d$a
                int r6 = r4.f147h
                int[] r7 = r4.f148i
                r5.<init>(r6, r7, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: dd.d.a.k(dd.d, dd.d, dd.d):dd.d");
        }

        public d l() {
            return this;
        }

        public d m() {
            if (this.f149j.s() || this.f149j.r()) {
                return this;
            }
            return t(this.f147h - 1);
        }

        public d n() {
            int i10 = this.f147h;
            int[] iArr = this.f148i;
            return new a(i10, iArr, this.f149j.v(i10, iArr));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: dd.h} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public dd.d o(dd.d r5, dd.d r6) {
            /*
                r4 = this;
                dd.h r0 = r4.f149j
                dd.d$a r5 = (dd.d.a) r5
                dd.h r5 = r5.f149j
                dd.d$a r6 = (dd.d.a) r6
                dd.h r6 = r6.f149j
                int r1 = r4.f147h
                int[] r2 = r4.f148i
                dd.h r1 = r0.J(r1, r2)
                int r2 = r4.f147h
                int[] r3 = r4.f148i
                dd.h r5 = r5.x(r6, r2, r3)
                if (r1 != r0) goto L_0x0023
                java.lang.Object r6 = r1.clone()
                r1 = r6
                dd.h r1 = (dd.h) r1
            L_0x0023:
                r6 = 0
                r1.f(r5, r6)
                int r5 = r4.f147h
                int[] r6 = r4.f148i
                r1.z(r5, r6)
                dd.d$a r5 = new dd.d$a
                int r6 = r4.f147h
                int[] r0 = r4.f148i
                r5.<init>(r6, r0, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: dd.d.a.o(dd.d, dd.d):dd.d");
        }

        public d p(d dVar) {
            return a(dVar);
        }

        public boolean q() {
            return this.f149j.M();
        }

        public BigInteger r() {
            return this.f149j.N();
        }

        public d t(int i10) {
            if (i10 < 1) {
                return this;
            }
            int i11 = this.f147h;
            int[] iArr = this.f148i;
            return new a(i11, iArr, this.f149j.w(i10, i11, iArr));
        }

        private a(int i10, int[] iArr, h hVar) {
            this.f147h = i10;
            this.f146g = iArr.length == 1 ? 2 : 3;
            this.f148i = iArr;
            this.f149j = hVar;
        }
    }
}
