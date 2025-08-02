package com.geetest.core;

import java.io.IOException;

public class u extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u f6184a = new u((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public static final u f6185b = new u((byte) -1);

    /* renamed from: c  reason: collision with root package name */
    public final byte f6186c;

    public u(byte b10) {
        this.f6186c = b10;
    }

    public int a(boolean z10) {
        return n0.a(z10, 1);
    }

    public boolean g() {
        return false;
    }

    public p0 h() {
        if (j()) {
            return f6185b;
        }
        return f6184a;
    }

    public int hashCode() {
        return j() ? 1 : 0;
    }

    public boolean j() {
        if (this.f6186c != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (j()) {
            return "TRUE";
        }
        return "FALSE";
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        byte b10 = this.f6186c;
        n0Var.b(z10, 1);
        n0Var.c(1);
        n0Var.f6110a.write(b10);
    }

    public boolean a(p0 p0Var) {
        if ((p0Var instanceof u) && j() == ((u) p0Var).j()) {
            return true;
        }
        return false;
    }

    public static u a(byte[] bArr) {
        if (bArr.length == 1) {
            byte b10 = bArr[0];
            if (b10 == -1) {
                return f6185b;
            }
            if (b10 != 0) {
                return new u(b10);
            }
            return f6184a;
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }
}
