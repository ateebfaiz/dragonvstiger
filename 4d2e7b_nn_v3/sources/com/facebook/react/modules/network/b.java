package com.facebook.react.modules.network;

import java.io.FilterOutputStream;
import java.io.OutputStream;

abstract class b extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f3319a = 0;

    public b(OutputStream outputStream) {
        super(outputStream);
    }

    public long a() {
        return this.f3319a;
    }

    public void close() {
        this.out.close();
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
        this.f3319a += (long) i11;
    }

    public void write(int i10) {
        this.out.write(i10);
        this.f3319a++;
    }
}
