package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class s1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f6174a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6175b = true;

    /* renamed from: c  reason: collision with root package name */
    public InputStream f6176c;

    public s1(x0 x0Var) {
        this.f6174a = x0Var;
    }

    public final m0 a() throws IOException {
        v a10 = this.f6174a.a();
        if (a10 == null) {
            return null;
        }
        if (a10 instanceof m0) {
            return (m0) a10;
        }
        throw new IOException("unknown object encountered: " + a10.getClass());
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        m0 a10;
        int i12 = 0;
        if (this.f6176c == null) {
            if (!this.f6175b || (a10 = a()) == null) {
                return -1;
            }
            this.f6175b = false;
            this.f6176c = a10.c();
        }
        while (true) {
            int read = this.f6176c.read(bArr, i10 + i12, i11 - i12);
            if (read >= 0) {
                i12 += read;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                m0 a11 = a();
                if (a11 == null) {
                    this.f6176c = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f6176c = a11.c();
            }
        }
    }

    public int read() throws IOException {
        m0 a10;
        if (this.f6176c == null) {
            if (!this.f6175b || (a10 = a()) == null) {
                return -1;
            }
            this.f6175b = false;
            this.f6176c = a10.c();
        }
        while (true) {
            int read = this.f6176c.read();
            if (read >= 0) {
                return read;
            }
            m0 a11 = a();
            if (a11 == null) {
                this.f6176c = null;
                return -1;
            }
            this.f6176c = a11.c();
        }
    }
}
