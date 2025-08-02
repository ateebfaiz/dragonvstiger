package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFg1ySDK extends FilterInputStream {
    private final int AFInAppEventParameterName;
    private short AFInAppEventType;
    private long[] AFKeystoreWrapper;
    private int AFLogger = Integer.MAX_VALUE;
    private int afErrorLog;
    private int afRDLog;
    private byte[] valueOf;
    private long[] values;

    public AFg1ySDK(InputStream inputStream, int i10, int i11, short s10, int i12, int i13) throws IOException {
        super(inputStream);
        int min = Math.min(Math.max(s10, 4), 8);
        this.AFInAppEventParameterName = min;
        this.valueOf = new byte[min];
        this.values = new long[4];
        this.AFKeystoreWrapper = new long[4];
        this.afRDLog = min;
        this.afErrorLog = min;
        this.values = AFg1wSDK.values(i10 ^ i13, min ^ i13);
        this.AFKeystoreWrapper = AFg1wSDK.values(i11 ^ i13, i12 ^ i13);
    }

    private void AFInAppEventType() {
        long[] jArr = this.values;
        long[] jArr2 = this.AFKeystoreWrapper;
        short s10 = this.AFInAppEventType;
        long j10 = jArr2[(s10 + 2) % 4];
        int i10 = (s10 + 3) % 4;
        jArr2[i10] = ((jArr[i10] * 2147483085) + j10) / 2147483647L;
        jArr[i10] = ((jArr[s10 % 4] * 2147483085) + j10) % 2147483647L;
        for (int i11 = 0; i11 < this.AFInAppEventParameterName; i11++) {
            byte[] bArr = this.valueOf;
            bArr[i11] = (byte) ((int) (((long) bArr[i11]) ^ ((this.values[this.AFInAppEventType] >> (i11 << 3)) & 255)));
        }
        this.AFInAppEventType = (short) ((this.AFInAppEventType + 1) % 4);
    }

    private int values() throws IOException {
        int read;
        int i10;
        if (this.AFLogger == Integer.MAX_VALUE) {
            this.AFLogger = this.in.read();
        }
        if (this.afRDLog == this.AFInAppEventParameterName) {
            byte[] bArr = this.valueOf;
            int i11 = this.AFLogger;
            bArr[0] = (byte) i11;
            if (i11 >= 0) {
                int i12 = 1;
                do {
                    read = this.in.read(this.valueOf, i12, this.AFInAppEventParameterName - i12);
                    if (read <= 0 || (i12 = i12 + read) >= this.AFInAppEventParameterName) {
                    }
                    read = this.in.read(this.valueOf, i12, this.AFInAppEventParameterName - i12);
                    break;
                } while ((i12 = i12 + read) >= this.AFInAppEventParameterName);
                if (i12 >= this.AFInAppEventParameterName) {
                    AFInAppEventType();
                    int read2 = this.in.read();
                    this.AFLogger = read2;
                    this.afRDLog = 0;
                    if (read2 < 0) {
                        int i13 = this.AFInAppEventParameterName;
                        i10 = i13 - (this.valueOf[i13 - 1] & 255);
                    } else {
                        i10 = this.AFInAppEventParameterName;
                    }
                    this.afErrorLog = i10;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.afErrorLog;
    }

    public final int available() throws IOException {
        values();
        return this.afErrorLog - this.afRDLog;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        values();
        int i10 = this.afRDLog;
        if (i10 >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.afRDLog = i10 + 1;
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
            values();
            int i14 = this.afRDLog;
            if (i14 < this.afErrorLog) {
                byte[] bArr2 = this.valueOf;
                this.afRDLog = i14 + 1;
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
