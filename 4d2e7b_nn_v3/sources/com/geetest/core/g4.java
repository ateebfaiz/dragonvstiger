package com.geetest.core;

import java.util.Arrays;

public class g4 extends h4 {

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f5984d;

    public g4(byte[] bArr) {
        super(m4.BYTE_STRING);
        if (bArr == null) {
            this.f5984d = null;
        } else {
            this.f5984d = bArr;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g4)) {
            return false;
        }
        g4 g4Var = (g4) obj;
        if (!super.equals(obj) || !Arrays.equals(this.f5984d, g4Var.f5984d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.f5984d);
    }
}
