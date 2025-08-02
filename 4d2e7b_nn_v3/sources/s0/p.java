package s0;

import java.util.Arrays;
import java.util.List;
import z0.a;

abstract class p implements o {

    /* renamed from: a  reason: collision with root package name */
    final List f23753a;

    p(List list) {
        this.f23753a = list;
    }

    public List b() {
        return this.f23753a;
    }

    public boolean c() {
        if (this.f23753a.isEmpty()) {
            return true;
        }
        if (this.f23753a.size() != 1 || !((a) this.f23753a.get(0)).i()) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f23753a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f23753a.toArray()));
        }
        return sb2.toString();
    }
}
