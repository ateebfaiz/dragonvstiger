package com.botion.captcha;

import androidx.core.view.InputDeviceCompat;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f18531a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            char[] cArr = f18531a;
            sb2.append(cArr[(bArr[i10] >> 4) & 15]);
            sb2.append(cArr[bArr[i10] & 15]);
        }
        return sb2.toString();
    }

    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int digit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i10] = (byte) digit;
        }
        return bArr;
    }
}
