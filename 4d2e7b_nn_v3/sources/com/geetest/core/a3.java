package com.geetest.core;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class a3 extends e3 {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f5901c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public final int f5902d;

    /* renamed from: e  reason: collision with root package name */
    public int f5903e;

    public a3(InputStream inputStream, int i10, int i11) {
        super(inputStream, i11);
        if (i10 <= 0) {
            if (i10 >= 0) {
                a(true);
            } else {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
        }
        this.f5902d = i10;
        this.f5903e = i10;
    }

    public byte[] a() throws IOException {
        int i10 = this.f5903e;
        if (i10 == 0) {
            return f5901c;
        }
        int i11 = this.f5965b;
        if (i10 < i11) {
            byte[] bArr = new byte[i10];
            int a10 = i10 - o3.a(this.f5964a, bArr, 0, i10);
            this.f5903e = a10;
            if (a10 == 0) {
                a(true);
                return bArr;
            }
            throw new EOFException("DEF length " + this.f5902d + " object truncated by " + this.f5903e);
        }
        throw new IOException("corrupted stream - out of bounds length found: " + this.f5903e + " >= " + i11);
    }

    public int read() throws IOException {
        if (this.f5903e == 0) {
            return -1;
        }
        int read = this.f5964a.read();
        if (read >= 0) {
            int i10 = this.f5903e - 1;
            this.f5903e = i10;
            if (i10 == 0) {
                a(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f5902d + " object truncated by " + this.f5903e);
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f5903e;
        if (i12 == 0) {
            return -1;
        }
        int read = this.f5964a.read(bArr, i10, Math.min(i11, i12));
        if (read >= 0) {
            int i13 = this.f5903e - read;
            this.f5903e = i13;
            if (i13 == 0) {
                a(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f5902d + " object truncated by " + this.f5903e);
    }
}
