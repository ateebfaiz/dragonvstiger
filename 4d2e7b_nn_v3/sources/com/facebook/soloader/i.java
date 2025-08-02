package com.facebook.soloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f4813a;

    /* renamed from: b  reason: collision with root package name */
    private final ZipEntry f4814b;

    /* renamed from: c  reason: collision with root package name */
    private final ZipFile f4815c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4816d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4817e = true;

    /* renamed from: f  reason: collision with root package name */
    private long f4818f = 0;

    public i(ZipFile zipFile, ZipEntry zipEntry) {
        this.f4815c = zipFile;
        this.f4814b = zipEntry;
        this.f4816d = zipEntry.getSize();
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        this.f4813a = inputStream;
        if (inputStream == null) {
            throw new IOException(zipEntry.getName() + "'s InputStream is null");
        }
    }

    public g a(long j10) {
        InputStream inputStream = this.f4813a;
        if (inputStream != null) {
            long j11 = this.f4818f;
            if (j10 == j11) {
                return this;
            }
            long j12 = this.f4816d;
            if (j10 > j12) {
                j10 = j12;
            }
            if (j10 >= j11) {
                inputStream.skip(j10 - j11);
            } else {
                inputStream.close();
                InputStream inputStream2 = this.f4815c.getInputStream(this.f4814b);
                this.f4813a = inputStream2;
                if (inputStream2 != null) {
                    inputStream2.skip(j10);
                } else {
                    throw new IOException(this.f4814b.getName() + "'s InputStream is null");
                }
            }
            this.f4818f = j10;
            return this;
        }
        throw new IOException(this.f4814b.getName() + "'s InputStream is null");
    }

    public void close() {
        InputStream inputStream = this.f4813a;
        if (inputStream != null) {
            inputStream.close();
            this.f4817e = false;
        }
    }

    public boolean isOpen() {
        return this.f4817e;
    }

    public int o(ByteBuffer byteBuffer, long j10) {
        if (this.f4813a != null) {
            int remaining = byteBuffer.remaining();
            long j11 = this.f4816d - j10;
            if (j11 <= 0) {
                return -1;
            }
            int i10 = (int) j11;
            if (remaining > i10) {
                remaining = i10;
            }
            a(j10);
            if (byteBuffer.hasArray()) {
                this.f4813a.read(byteBuffer.array(), 0, remaining);
                byteBuffer.position(byteBuffer.position() + remaining);
            } else {
                byte[] bArr = new byte[remaining];
                this.f4813a.read(bArr, 0, remaining);
                byteBuffer.put(bArr, 0, remaining);
            }
            this.f4818f += (long) remaining;
            return remaining;
        }
        throw new IOException("InputStream is null");
    }

    public int read(ByteBuffer byteBuffer) {
        return o(byteBuffer, this.f4818f);
    }

    public int write(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }
}
