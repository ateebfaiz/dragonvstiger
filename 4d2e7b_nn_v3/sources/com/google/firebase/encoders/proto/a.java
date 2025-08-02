package com.google.firebase.encoders.proto;

import java.io.OutputStream;

final class a extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f9093a = 0;

    a() {
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f9093a;
    }

    public void write(int i10) {
        this.f9093a++;
    }

    public void write(byte[] bArr) {
        this.f9093a += (long) bArr.length;
    }

    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f9093a += (long) i11;
    }
}
