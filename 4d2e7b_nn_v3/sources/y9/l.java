package y9;

import aa.g;
import java.math.BigInteger;
import java.util.Objects;

public final class l extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f13425a;

    public l(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f13425a = bool;
    }

    private static boolean n(l lVar) {
        Object obj = lVar.f13425a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f13425a == null) {
            if (lVar.f13425a == null) {
                return true;
            }
            return false;
        } else if (!n(this) || !n(lVar)) {
            Object obj2 = this.f13425a;
            if (!(obj2 instanceof Number) || !(lVar.f13425a instanceof Number)) {
                return obj2.equals(lVar.f13425a);
            }
            double doubleValue = k().doubleValue();
            double doubleValue2 = lVar.k().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (k().longValue() == lVar.k().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f13425a == null) {
            return 31;
        }
        if (n(this)) {
            doubleToLongBits = k().longValue();
        } else {
            Object obj = this.f13425a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(k().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        if (m()) {
            return ((Boolean) this.f13425a).booleanValue();
        }
        return Boolean.parseBoolean(l());
    }

    public Number k() {
        Object obj = this.f13425a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String l() {
        Object obj = this.f13425a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (o()) {
            return k().toString();
        }
        if (m()) {
            return ((Boolean) this.f13425a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f13425a.getClass());
    }

    public boolean m() {
        return this.f13425a instanceof Boolean;
    }

    public boolean o() {
        return this.f13425a instanceof Number;
    }

    public boolean p() {
        return this.f13425a instanceof String;
    }

    public l(Number number) {
        Objects.requireNonNull(number);
        this.f13425a = number;
    }

    public l(String str) {
        Objects.requireNonNull(str);
        this.f13425a = str;
    }
}
