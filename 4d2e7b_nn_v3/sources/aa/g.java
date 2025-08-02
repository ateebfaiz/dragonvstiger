package aa;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f2296a;

    public g(String str) {
        this.f2296a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f2296a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f2296a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f2296a;
        String str2 = ((g) obj).f2296a;
        if (str == str2 || str.equals(str2)) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat(this.f2296a);
    }

    public int hashCode() {
        return this.f2296a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return (int) java.lang.Long.parseLong(r2.f2296a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return new java.math.BigDecimal(r2.f2296a).intValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f2296a     // Catch:{ NumberFormatException -> 0x0007 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.String r0 = r2.f2296a     // Catch:{ NumberFormatException -> 0x000f }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000f }
            int r0 = (int) r0
            return r0
        L_0x000f:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.String r1 = r2.f2296a
            r0.<init>(r1)
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.g.intValue():int");
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f2296a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f2296a).longValue();
        }
    }

    public String toString() {
        return this.f2296a;
    }
}
