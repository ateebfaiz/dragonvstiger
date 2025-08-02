package hc;

import java.io.IOException;

public class g0 implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    private v f372a;

    g0(v vVar) {
        this.f372a = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q(e10.getMessage(), e10);
        }
    }

    public r d() {
        return new f0(this.f372a.d());
    }
}
