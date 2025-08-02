package hc;

import java.io.ByteArrayOutputStream;

public abstract class l implements d {
    public abstract r c();

    public byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new p(byteArrayOutputStream).j(this);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return c().equals(((d) obj).c());
    }

    public byte[] f(String str) {
        if (str.equals("DER")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new x0(byteArrayOutputStream).j(this);
            return byteArrayOutputStream.toByteArray();
        } else if (!str.equals("DL")) {
            return e();
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            new k1(byteArrayOutputStream2).j(this);
            return byteArrayOutputStream2.toByteArray();
        }
    }

    public int hashCode() {
        return c().hashCode();
    }
}
