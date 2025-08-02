package yd;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private int[] f2223a;

    public h(byte[] bArr) {
        if (bArr.length > 4) {
            int e10 = f.e(bArr, 0);
            int a10 = e.a(e10 - 1);
            if (bArr.length == (e10 * a10) + 4) {
                this.f2223a = new int[e10];
                for (int i10 = 0; i10 < e10; i10++) {
                    this.f2223a[i10] = f.f(bArr, (i10 * a10) + 4, a10);
                }
                if (!b(this.f2223a)) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    private boolean b(int[] iArr) {
        boolean[] zArr = new boolean[r0];
        for (int i10 : iArr) {
            if (i10 < 0 || i10 >= r0 || zArr[i10]) {
                return false;
            }
            zArr[i10] = true;
        }
        return true;
    }

    public byte[] a() {
        int length = this.f2223a.length;
        int a10 = e.a(length - 1);
        byte[] bArr = new byte[((length * a10) + 4)];
        f.a(length, bArr, 0);
        for (int i10 = 0; i10 < length; i10++) {
            f.b(this.f2223a[i10], bArr, (i10 * a10) + 4, a10);
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return d.b(this.f2223a, ((h) obj).f2223a);
    }

    public int hashCode() {
        return this.f2223a.hashCode();
    }

    public String toString() {
        String str = "[" + this.f2223a[0];
        for (int i10 = 1; i10 < this.f2223a.length; i10++) {
            str = str + ", " + this.f2223a[i10];
        }
        return str + "]";
    }
}
