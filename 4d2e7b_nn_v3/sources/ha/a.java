package ha;

import java.io.Serializable;
import java.math.BigInteger;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final String f12311a;

    public a(String str) {
        if (str != null) {
            this.f12311a = str;
            return;
        }
        throw new IllegalArgumentException("The Base64 value must not be null");
    }

    public byte[] a() {
        return b.c(this.f12311a);
    }

    public BigInteger b() {
        return new BigInteger(1, a());
    }

    public String c() {
        return new String(a(), f.f12313a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a) || !toString().equals(obj.toString())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f12311a.hashCode();
    }

    public String toString() {
        return this.f12311a;
    }
}
