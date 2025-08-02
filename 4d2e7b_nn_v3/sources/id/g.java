package id;

import java.math.BigInteger;

class g implements a {

    /* renamed from: a  reason: collision with root package name */
    protected final BigInteger f469a;

    g(BigInteger bigInteger) {
        this.f469a = bigInteger;
    }

    public int b() {
        return 1;
    }

    public BigInteger c() {
        return this.f469a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f469a.equals(((g) obj).f469a);
    }

    public int hashCode() {
        return this.f469a.hashCode();
    }
}
