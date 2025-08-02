package com.appsflyer.internal;

public final class AFf1aSDK {
    public static int AFInAppEventType;
    public static int AFKeystoreWrapper;
    public static final Object values = new Object();

    public static char[] values(long j10, char[] cArr, int i10) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i11 = 0;
        int i12 = 4;
        for (int i13 = 0; i13 < cArr.length; i13++) {
            if ((((j10 >>> i13) & 1) != ((long) i10) || i11 >= 4) && i12 < length) {
                cArr2[i12] = cArr[i13];
                i12++;
            } else {
                cArr2[i11] = cArr[i13];
                i11++;
            }
        }
        return cArr2;
    }
}
