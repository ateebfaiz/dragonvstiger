package yd;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f2212a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2213b;

    public b(byte[] bArr) {
        if (bArr.length == 4) {
            int d10 = f.d(bArr);
            this.f2213b = d10;
            if (j.c(d10)) {
                this.f2212a = j.a(this.f2213b);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String i(int i10) {
        String str;
        if (i10 == 0) {
            return "0";
        }
        if (((byte) (i10 & 1)) == 1) {
            str = "1";
        } else {
            str = "";
        }
        int i11 = i10 >>> 1;
        int i12 = 1;
        while (i11 != 0) {
            if (((byte) (i11 & 1)) == 1) {
                str = str + "+x^" + i12;
            }
            i11 >>>= 1;
            i12++;
        }
        return str;
    }

    public int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public String b(int i10) {
        String str = "";
        for (int i11 = 0; i11 < this.f2212a; i11++) {
            if ((((byte) i10) & 1) == 0) {
                str = "0" + str;
            } else {
                str = "1" + str;
            }
            i10 >>>= 1;
        }
        return str;
    }

    public int c(int i10, int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i11 < 0) {
            i10 = f(i10);
            i11 = -i11;
        }
        int i12 = 1;
        while (i11 != 0) {
            if ((i11 & 1) == 1) {
                i12 = h(i12, i10);
            }
            i10 = h(i10, i10);
            i11 >>>= 1;
        }
        return i12;
    }

    public int d() {
        return this.f2212a;
    }

    public byte[] e() {
        return f.c(this.f2213b);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.f2212a == bVar.f2212a && this.f2213b == bVar.f2213b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int f(int i10) {
        return c(i10, (1 << this.f2212a) - 2);
    }

    public boolean g(int i10) {
        int i11 = this.f2212a;
        if (i11 == 31) {
            if (i10 >= 0) {
                return true;
            }
            return false;
        } else if (i10 < 0 || i10 >= (1 << i11)) {
            return false;
        } else {
            return true;
        }
    }

    public int h(int i10, int i11) {
        return j.d(i10, i11, this.f2213b);
    }

    public int hashCode() {
        return this.f2213b;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f2212a + ") = GF(2)[X]/<" + i(this.f2213b) + "> ";
    }
}
