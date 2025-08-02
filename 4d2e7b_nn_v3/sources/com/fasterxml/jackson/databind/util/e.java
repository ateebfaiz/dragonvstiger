package com.fasterxml.jackson.databind.util;

import java.io.InputStream;
import java.nio.ByteBuffer;

public class e extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    protected final ByteBuffer f5670a;

    public e(ByteBuffer byteBuffer) {
        this.f5670a = byteBuffer;
    }

    public int available() {
        return this.f5670a.remaining();
    }

    public int read() {
        if (this.f5670a.hasRemaining()) {
            return this.f5670a.get() & 255;
        }
        return -1;
    }

    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f5670a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i11, this.f5670a.remaining());
        this.f5670a.get(bArr, i10, min);
        return min;
    }
}
