package hc;

import java.io.IOException;

public class c1 implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    private v f363a;

    c1(v vVar) {
        this.f363a = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q(e10.getMessage(), e10);
        }
    }

    public r d() {
        return new b1(this.f363a.d(), false);
    }
}
