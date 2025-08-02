package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFg1xSDK extends FilterInputStream {
    private AFf1cSDK AFInAppEventParameterName;
    private byte[] AFInAppEventType;
    private final int AFKeystoreWrapper;
    private int AFLogger;
    private int[] afDebugLog;
    private int afErrorLog = Integer.MAX_VALUE;
    private int afInfoLog;
    private int afRDLog;
    private byte[] valueOf;
    private byte[] values;

    public AFg1xSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i10, boolean z10, int i11) throws IOException {
        super(inputStream);
        int min = Math.min(Math.max(i10, 3), 16);
        this.AFKeystoreWrapper = min;
        this.valueOf = new byte[8];
        byte[] bArr2 = new byte[8];
        this.AFInAppEventType = bArr2;
        this.values = new byte[8];
        this.afDebugLog = new int[2];
        this.afInfoLog = 8;
        this.afRDLog = 8;
        this.AFLogger = i11;
        if (i11 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.AFInAppEventParameterName = new AFf1cSDK(iArr, min, true, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFKeystoreWrapper() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.afErrorLog
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afErrorLog = r0
        L_0x000f:
            int r0 = r7.afInfoLog
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.valueOf
            int r2 = r7.afErrorLog
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.valueOf
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.values()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afErrorLog = r0
            r7.afInfoLog = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.valueOf
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.afRDLog = r1
            goto L_0x0059
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0059:
            int r0 = r7.afRDLog
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1xSDK.AFKeystoreWrapper():int");
    }

    private void values() {
        if (this.AFLogger == 2) {
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.values, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i10 = ((bArr2[0] << 24) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i11 = (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i12 = this.AFKeystoreWrapper;
        AFf1cSDK aFf1cSDK = this.AFInAppEventParameterName;
        AFf1dSDK.AFInAppEventParameterName(i10, i11, false, i12, aFf1cSDK.values, aFf1cSDK.AFInAppEventParameterName, this.afDebugLog);
        int[] iArr = this.afDebugLog;
        int i13 = iArr[0];
        int i14 = iArr[1];
        byte[] bArr3 = this.valueOf;
        bArr3[0] = (byte) (i13 >> 24);
        bArr3[1] = (byte) (i13 >> 16);
        bArr3[2] = (byte) (i13 >> 8);
        bArr3[3] = (byte) i13;
        bArr3[4] = (byte) (i14 >> 24);
        bArr3[5] = (byte) (i14 >> 16);
        bArr3[6] = (byte) (i14 >> 8);
        bArr3[7] = (byte) i14;
        if (this.AFLogger == 2) {
            for (int i15 = 0; i15 < 8; i15++) {
                byte[] bArr4 = this.valueOf;
                bArr4[i15] = (byte) (bArr4[i15] ^ this.AFInAppEventType[i15]);
            }
            byte[] bArr5 = this.values;
            System.arraycopy(bArr5, 0, this.AFInAppEventType, 0, bArr5.length);
        }
    }

    public final int available() throws IOException {
        AFKeystoreWrapper();
        return this.afRDLog - this.afInfoLog;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFKeystoreWrapper();
        int i10 = this.afInfoLog;
        if (i10 >= this.afRDLog) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.afInfoLog = i10 + 1;
        return bArr[i10] & 255;
    }

    public final long skip(long j10) throws IOException {
        long j11 = 0;
        while (j11 < j10 && read() != -1) {
            j11++;
        }
        return j11;
    }

    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = i10 + i11;
        int i13 = i10;
        while (i13 < i12) {
            AFKeystoreWrapper();
            int i14 = this.afInfoLog;
            if (i14 < this.afRDLog) {
                byte[] bArr2 = this.valueOf;
                this.afInfoLog = i14 + 1;
                bArr[i13] = bArr2[i14];
                i13++;
            } else if (i13 == i10) {
                return -1;
            } else {
                return i11 - (i12 - i13);
            }
        }
        return i11;
    }
}
