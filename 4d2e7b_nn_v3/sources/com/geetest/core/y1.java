package com.geetest.core;

import java.io.IOException;

public class y1 extends b0 {
    public y1(byte[] bArr) {
        super(bArr);
    }

    public int a(boolean z10) {
        return n0.a(z10, j().length);
    }

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }

    public final byte[] j() {
        byte[] bArr = this.f5933a;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!a(10) || !a(11)) {
            byte[] bArr2 = this.f5933a;
            byte[] bArr3 = new byte[(bArr2.length + 4)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            int i10 = j3.f6041a;
            byte[] bArr4 = new byte[5];
            for (int i11 = 0; i11 != 5; i11++) {
                bArr4[i11] = (byte) "0000Z".charAt(i11);
            }
            System.arraycopy(bArr4, 0, bArr3, this.f5933a.length - 1, 5);
            return bArr3;
        } else if (!a(12) || !a(13)) {
            byte[] bArr5 = this.f5933a;
            byte[] bArr6 = new byte[(bArr5.length + 2)];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length - 1);
            int i12 = j3.f6041a;
            byte[] bArr7 = new byte[3];
            for (int i13 = 0; i13 != 3; i13++) {
                bArr7[i13] = (byte) "00Z".charAt(i13);
            }
            System.arraycopy(bArr7, 0, bArr6, this.f5933a.length - 1, 3);
            return bArr6;
        } else {
            int i14 = 0;
            while (true) {
                byte[] bArr8 = this.f5933a;
                if (i14 == bArr8.length) {
                    return bArr8;
                }
                if (bArr8[i14] == 46 && i14 == 14) {
                    int length = bArr8.length - 2;
                    while (length > 0 && this.f5933a[length] == 48) {
                        length--;
                    }
                    byte[] bArr9 = this.f5933a;
                    if (bArr9[length] == 46) {
                        byte[] bArr10 = new byte[(length + 1)];
                        System.arraycopy(bArr9, 0, bArr10, 0, length);
                        bArr10[length] = 90;
                        return bArr10;
                    }
                    byte[] bArr11 = new byte[(length + 2)];
                    int i15 = length + 1;
                    System.arraycopy(bArr9, 0, bArr11, 0, i15);
                    bArr11[i15] = 90;
                    return bArr11;
                }
                i14++;
            }
        }
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 24, j());
    }
}
