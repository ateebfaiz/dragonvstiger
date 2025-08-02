package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    private long getBytesToRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == 0) {
            return -1;
        }
        if (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) {
            return j10;
        }
        return (long) i10;
    }

    private void updateAvailableBytesAfterRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 != Integer.MIN_VALUE && j10 != -1) {
            this.availableBytes = (int) (((long) i10) - j10);
        }
    }

    public int available() throws IOException {
        int i10 = this.availableBytes;
        if (i10 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i10, super.available());
    }

    public synchronized void mark(int i10) {
        super.mark(i10);
        this.availableBytes = i10;
    }

    public int read() throws IOException {
        if (getBytesToRead(1) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    public long skip(long j10) throws IOException {
        long bytesToRead = getBytesToRead(j10);
        if (bytesToRead == -1) {
            return 0;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    public int read(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int bytesToRead = (int) getBytesToRead((long) i11);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, bytesToRead);
        updateAvailableBytesAfterRead((long) read);
        return read;
    }
}
