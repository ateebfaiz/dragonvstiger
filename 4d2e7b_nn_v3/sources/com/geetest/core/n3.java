package com.geetest.core;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;

public class n3 {

    /* renamed from: a  reason: collision with root package name */
    public static final short[] f6111a = new short[128];

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f6112b;

    static {
        byte[] bArr = new byte[112];
        f6112b = bArr;
        byte[] bArr2 = new byte[128];
        a(bArr2, 0, 15, (byte) 1);
        a(bArr2, 16, 31, (byte) 2);
        a(bArr2, 32, 63, (byte) 3);
        a(bArr2, 64, 65, (byte) 0);
        a(bArr2, 66, 95, (byte) 4);
        a(bArr2, 96, 96, (byte) 5);
        a(bArr2, 97, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (byte) 6);
        a(bArr2, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, (byte) 7);
        a(bArr2, 110, 111, (byte) 6);
        a(bArr2, 112, 112, (byte) 8);
        a(bArr2, 113, 115, (byte) 9);
        a(bArr2, 116, 116, (byte) 10);
        a(bArr2, 117, 127, (byte) 0);
        a(bArr, 0, 111, (byte) -2);
        a(bArr, 8, 11, (byte) -1);
        a(bArr, 24, 27, (byte) 0);
        a(bArr, 40, 43, (byte) 16);
        a(bArr, 58, 59, (byte) 0);
        a(bArr, 72, 73, (byte) 0);
        a(bArr, 89, 91, (byte) 16);
        a(bArr, LocationRequestCompat.QUALITY_LOW_POWER, LocationRequestCompat.QUALITY_LOW_POWER, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
        for (int i10 = 0; i10 < 128; i10++) {
            byte b10 = bArr2[i10];
            f6111a[i10] = (short) (bArr4[b10] | ((bArr3[b10] & i10) << 8));
        }
    }

    public static void a(byte[] bArr, int i10, int i11, byte b10) {
        while (i10 <= i11) {
            bArr[i10] = b10;
            i10++;
        }
    }
}
