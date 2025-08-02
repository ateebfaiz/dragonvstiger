package s0;

import java.util.List;
import o0.a;
import o0.j;
import o0.k;

public class e implements o {

    /* renamed from: a  reason: collision with root package name */
    private final List f23729a;

    public e(List list) {
        this.f23729a = list;
    }

    public a a() {
        if (((z0.a) this.f23729a.get(0)).i()) {
            return new k(this.f23729a);
        }
        return new j(this.f23729a);
    }

    public List b() {
        return this.f23729a;
    }

    public boolean c() {
        if (this.f23729a.size() != 1 || !((z0.a) this.f23729a.get(0)).i()) {
            return false;
        }
        return true;
    }
}
