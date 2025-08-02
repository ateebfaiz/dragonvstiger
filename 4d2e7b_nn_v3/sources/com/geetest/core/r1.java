package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class r1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f6152a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6153b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6154c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f6155d = 0;

    /* renamed from: e  reason: collision with root package name */
    public t f6156e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f6157f;

    public r1(x0 x0Var, boolean z10) {
        this.f6152a = x0Var;
        this.f6153b = z10;
    }

    public final t a() throws IOException {
        v a10 = this.f6152a.a();
        if (a10 == null) {
            if (!this.f6153b || this.f6155d == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f6155d);
        } else if (!(a10 instanceof t)) {
            throw new IOException("unknown object encountered: " + a10.getClass());
        } else if (this.f6155d == 0) {
            return (t) a10;
        } else {
            throw new IOException("only the last nested bitstring can have padding");
        }
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        if (this.f6157f == null) {
            if (!this.f6154c) {
                return -1;
            }
            t a10 = a();
            this.f6156e = a10;
            if (a10 == null) {
                return -1;
            }
            this.f6154c = false;
            this.f6157f = a10.a();
        }
        while (true) {
            int read = this.f6157f.read(bArr, i10 + i12, i11 - i12);
            if (read >= 0) {
                i12 += read;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                this.f6155d = this.f6156e.e();
                t a11 = a();
                this.f6156e = a11;
                if (a11 == null) {
                    this.f6157f = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f6157f = a11.a();
            }
        }
    }

    public int read() throws IOException {
        if (this.f6157f == null) {
            if (!this.f6154c) {
                return -1;
            }
            t a10 = a();
            this.f6156e = a10;
            if (a10 == null) {
                return -1;
            }
            this.f6154c = false;
            this.f6157f = a10.a();
        }
        while (true) {
            int read = this.f6157f.read();
            if (read >= 0) {
                return read;
            }
            this.f6155d = this.f6156e.e();
            t a11 = a();
            this.f6156e = a11;
            if (a11 == null) {
                this.f6157f = null;
                return -1;
            }
            this.f6157f = a11.a();
        }
    }
}
