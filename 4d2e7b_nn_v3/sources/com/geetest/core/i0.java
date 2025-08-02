package com.geetest.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class i0 implements v {
    public byte[] a(String str) throws IOException {
        n0 n0Var;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        p0 d10 = d();
        d10.getClass();
        if (str.equals("DER")) {
            n0Var = new f2(byteArrayOutputStream);
        } else if (str.equals("DL")) {
            n0Var = new t2(byteArrayOutputStream);
        } else {
            n0Var = new n0(byteArrayOutputStream);
        }
        n0Var.a(d10, true);
        return byteArrayOutputStream.toByteArray();
    }

    public abstract p0 d();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return d().b(((v) obj).d());
    }

    public byte[] f() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((p0) this).a(new n0(byteArrayOutputStream), true);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return d().hashCode();
    }
}
