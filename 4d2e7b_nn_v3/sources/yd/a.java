package yd;

import java.lang.reflect.Array;

public class a extends g {

    /* renamed from: c  reason: collision with root package name */
    private int[][] f2210c;

    /* renamed from: d  reason: collision with root package name */
    private int f2211d;

    public a(byte[] bArr) {
        if (bArr.length >= 9) {
            this.f2221a = f.e(bArr, 0);
            int e10 = f.e(bArr, 4);
            this.f2222b = e10;
            int i10 = this.f2221a;
            int i11 = ((e10 + 7) >>> 3) * i10;
            if (i10 > 0) {
                int i12 = 8;
                if (i11 == bArr.length - 8) {
                    int i13 = (e10 + 31) >>> 5;
                    this.f2211d = i13;
                    int[] iArr = new int[2];
                    iArr[1] = i13;
                    iArr[0] = i10;
                    this.f2210c = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                    int i14 = this.f2222b;
                    int i15 = i14 >> 5;
                    int i16 = i14 & 31;
                    for (int i17 = 0; i17 < this.f2221a; i17++) {
                        int i18 = 0;
                        while (i18 < i15) {
                            this.f2210c[i17][i18] = f.e(bArr, i12);
                            i18++;
                            i12 += 4;
                        }
                        int i19 = 0;
                        while (i19 < i16) {
                            int[] iArr2 = this.f2210c[i17];
                            iArr2[i15] = ((bArr[i12] & 255) << i19) ^ iArr2[i15];
                            i19 += 8;
                            i12++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public byte[] c() {
        int i10 = this.f2221a;
        int i11 = 8;
        byte[] bArr = new byte[((((this.f2222b + 7) >>> 3) * i10) + 8)];
        f.a(i10, bArr, 0);
        f.a(this.f2222b, bArr, 4);
        int i12 = this.f2222b;
        int i13 = i12 >>> 5;
        int i14 = i12 & 31;
        for (int i15 = 0; i15 < this.f2221a; i15++) {
            int i16 = 0;
            while (i16 < i13) {
                f.a(this.f2210c[i15][i16], bArr, i11);
                i16++;
                i11 += 4;
            }
            int i17 = 0;
            while (i17 < i14) {
                bArr[i11] = (byte) ((this.f2210c[i15][i13] >>> i17) & 255);
                i17 += 8;
                i11++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f2221a != aVar.f2221a || this.f2222b != aVar.f2222b || this.f2211d != aVar.f2211d) {
            return false;
        }
        for (int i10 = 0; i10 < this.f2221a; i10++) {
            if (!d.b(this.f2210c[i10], aVar.f2210c[i10])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = (((this.f2221a * 31) + this.f2222b) * 31) + this.f2211d;
        for (int i11 = 0; i11 < this.f2221a; i11++) {
            i10 = (i10 * 31) + this.f2210c[i11].hashCode();
        }
        return i10;
    }

    public String toString() {
        int i10;
        int i11 = this.f2222b & 31;
        if (i11 == 0) {
            i10 = this.f2211d;
        } else {
            i10 = this.f2211d - 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < this.f2221a; i12++) {
            stringBuffer.append(i12 + ": ");
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = this.f2210c[i12][i13];
                for (int i15 = 0; i15 < 32; i15++) {
                    if (((i14 >>> i15) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i16 = this.f2210c[i12][this.f2211d - 1];
            for (int i17 = 0; i17 < i11; i17++) {
                if (((i16 >>> i17) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public a(int i10, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length == ((i10 + 31) >> 5)) {
            this.f2222b = i10;
            this.f2221a = iArr.length;
            this.f2211d = iArr2.length;
            int i11 = i10 & 31;
            int i12 = i11 == 0 ? -1 : (1 << i11) - 1;
            for (int i13 = 0; i13 < this.f2221a; i13++) {
                int[] iArr3 = iArr[i13];
                int i14 = this.f2211d - 1;
                iArr3[i14] = iArr3[i14] & i12;
            }
            this.f2210c = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public a(a aVar) {
        this.f2222b = aVar.a();
        this.f2221a = aVar.b();
        this.f2211d = aVar.f2211d;
        this.f2210c = new int[aVar.f2210c.length][];
        int i10 = 0;
        while (true) {
            int[][] iArr = this.f2210c;
            if (i10 < iArr.length) {
                iArr[i10] = d.a(aVar.f2210c[i10]);
                i10++;
            } else {
                return;
            }
        }
    }
}
