package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFg1zSDK extends FilterInputStream {
    private static final short AFInAppEventParameterName = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));
    private byte[] AFInAppEventType = new byte[8];
    private byte[] AFKeystoreWrapper = new byte[8];
    private int AFLogger = Integer.MAX_VALUE;
    private int AFVersionDeclaration;
    private int afDebugLog;
    private int afErrorLog = 8;
    private int afErrorLogForExcManagerOnly;
    private int afInfoLog;
    private int afRDLog;
    private int afWarnLog;
    private int valueOf = 8;
    private byte[] values = new byte[8];

    public AFg1zSDK(InputStream inputStream, int[] iArr, int i10, byte[] bArr, int i11, int i12) throws IOException {
        super(inputStream);
        this.afRDLog = Math.min(Math.max(i11, 5), 16);
        this.afDebugLog = i12;
        if (i12 == 3) {
            System.arraycopy(bArr, 0, this.AFKeystoreWrapper, 0, 8);
        }
        long j10 = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i10 == 0) {
            this.afInfoLog = (int) j10;
            long j11 = j10 >> 3;
            short s10 = AFInAppEventParameterName;
            this.AFVersionDeclaration = (int) ((((long) s10) * j11) >> 32);
            this.afWarnLog = (int) (j10 >> 32);
            this.afErrorLogForExcManagerOnly = (int) (j11 + ((long) s10));
            return;
        }
        int i13 = (int) j10;
        this.afInfoLog = i13;
        this.AFVersionDeclaration = i13 * i10;
        this.afWarnLog = i13 ^ i10;
        this.afErrorLogForExcManagerOnly = (int) (j10 >> 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFInAppEventType() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.AFLogger
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFLogger = r0
        L_0x000f:
            int r0 = r7.valueOf
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.values
            int r2 = r7.AFLogger
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.values
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.valueOf()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFLogger = r0
            r7.valueOf = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.values
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.afErrorLog = r1
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
            int r0 = r7.afErrorLog
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1zSDK.AFInAppEventType():int");
    }

    private void valueOf() {
        if (this.afDebugLog == 3) {
            byte[] bArr = this.values;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.values;
        int i10 = ((bArr2[0] << 24) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i11 = (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i12 = 0;
        while (true) {
            int i13 = this.afRDLog;
            if (i12 >= i13) {
                break;
            }
            short s10 = AFInAppEventParameterName;
            i11 -= ((((i13 - i12) * s10) + i10) ^ ((i10 << 4) + this.afWarnLog)) ^ ((i10 >>> 5) + this.afErrorLogForExcManagerOnly);
            i10 -= (((i11 << 4) + this.afInfoLog) ^ ((s10 * (i13 - i12)) + i11)) ^ ((i11 >>> 5) + this.AFVersionDeclaration);
            i12++;
        }
        byte[] bArr3 = this.values;
        bArr3[0] = (byte) (i10 >> 24);
        bArr3[1] = (byte) (i10 >> 16);
        bArr3[2] = (byte) (i10 >> 8);
        bArr3[3] = (byte) i10;
        bArr3[4] = (byte) (i11 >> 24);
        bArr3[5] = (byte) (i11 >> 16);
        bArr3[6] = (byte) (i11 >> 8);
        bArr3[7] = (byte) i11;
        if (this.afDebugLog == 3) {
            for (int i14 = 0; i14 < 8; i14++) {
                byte[] bArr4 = this.values;
                bArr4[i14] = (byte) (bArr4[i14] ^ this.AFKeystoreWrapper[i14]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.AFKeystoreWrapper, 0, bArr5.length);
        }
    }

    public final int available() throws IOException {
        AFInAppEventType();
        return this.afErrorLog - this.valueOf;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFInAppEventType();
        int i10 = this.valueOf;
        if (i10 >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.values;
        this.valueOf = i10 + 1;
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
            AFInAppEventType();
            int i14 = this.valueOf;
            if (i14 < this.afErrorLog) {
                byte[] bArr2 = this.values;
                this.valueOf = i14 + 1;
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
