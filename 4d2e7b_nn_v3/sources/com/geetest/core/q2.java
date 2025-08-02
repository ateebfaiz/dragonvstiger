package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class q2 implements t {

    /* renamed from: a  reason: collision with root package name */
    public final a3 f6145a;

    /* renamed from: b  reason: collision with root package name */
    public int f6146b = 0;

    public q2(a3 a3Var) {
        this.f6145a = a3Var;
    }

    public InputStream a() throws IOException {
        a3 a3Var = this.f6145a;
        int i10 = a3Var.f5903e;
        if (i10 >= 1) {
            int read = a3Var.read();
            this.f6146b = read;
            if (read > 0) {
                if (i10 < 2) {
                    throw new IllegalStateException("zero length data with non-zero pad bits");
                } else if (read > 7) {
                    throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
                }
            }
            return this.f6145a;
        }
        throw new IllegalStateException("content octets cannot be empty");
    }

    public p0 b() throws IOException {
        return s.a(this.f6145a.a());
    }

    public p0 d() {
        try {
            return s.a(this.f6145a.a());
        } catch (IOException e10) {
            throw new o0("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    public int e() {
        return this.f6146b;
    }
}
