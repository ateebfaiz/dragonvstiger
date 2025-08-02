package r0;

import androidx.core.util.Pair;

public class i {

    /* renamed from: a  reason: collision with root package name */
    Object f23631a;

    /* renamed from: b  reason: collision with root package name */
    Object f23632b;

    private static boolean a(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public void b(Object obj, Object obj2) {
        this.f23631a = obj;
        this.f23632b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!a(pair.first, this.f23631a) || !a(pair.second, this.f23632b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Object obj = this.f23631a;
        int i11 = 0;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        Object obj2 = this.f23632b;
        if (obj2 != null) {
            i11 = obj2.hashCode();
        }
        return i10 ^ i11;
    }

    public String toString() {
        return "Pair{" + this.f23631a + " " + this.f23632b + "}";
    }
}
