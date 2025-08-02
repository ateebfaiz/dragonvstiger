package com.geetest.core;

public class m3 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6076a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6077b = new byte[128];

    public m3() {
        a();
    }

    public void a() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f6077b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.f6076a;
            if (i10 < bArr2.length) {
                this.f6077b[bArr2[i10]] = (byte) i10;
                i10++;
            } else {
                byte[] bArr3 = this.f6077b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }
}
