package com.geetest.core;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class c3 extends e3 {

    /* renamed from: c  reason: collision with root package name */
    public int f5943c;

    /* renamed from: d  reason: collision with root package name */
    public int f5944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5945e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5946f = true;

    public c3(InputStream inputStream, int i10) throws IOException {
        super(inputStream, i10);
        this.f5943c = inputStream.read();
        int read = inputStream.read();
        this.f5944d = read;
        if (read >= 0) {
            a();
            return;
        }
        throw new EOFException();
    }

    public final boolean a() {
        if (!this.f5945e && this.f5946f && this.f5943c == 0 && this.f5944d == 0) {
            this.f5945e = true;
            a(true);
        }
        return this.f5945e;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f5946f || i11 < 3) {
            return super.read(bArr, i10, i11);
        }
        if (this.f5945e) {
            return -1;
        }
        int read = this.f5964a.read(bArr, i10 + 2, i11 - 2);
        if (read >= 0) {
            bArr[i10] = (byte) this.f5943c;
            bArr[i10 + 1] = (byte) this.f5944d;
            this.f5943c = this.f5964a.read();
            int read2 = this.f5964a.read();
            this.f5944d = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    public int read() throws IOException {
        if (a()) {
            return -1;
        }
        int read = this.f5964a.read();
        if (read >= 0) {
            int i10 = this.f5943c;
            this.f5943c = this.f5944d;
            this.f5944d = read;
            return i10;
        }
        throw new EOFException();
    }
}
