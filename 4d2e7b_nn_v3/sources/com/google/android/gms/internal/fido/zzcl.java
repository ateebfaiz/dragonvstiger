package com.google.android.gms.internal.fido;

public final class zzcl {
    public static byte[] zza(byte[]... bArr) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= r3) {
                break;
            }
            i11 += bArr[i10].length;
            i10++;
        }
        byte[] bArr2 = new byte[i11];
        int i12 = 0;
        for (byte[] bArr3 : bArr) {
            int length = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i12, length);
            i12 += length;
        }
        return bArr2;
    }
}
