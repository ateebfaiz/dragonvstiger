package hc;

import java.io.IOException;

public class a1 implements t {

    /* renamed from: a  reason: collision with root package name */
    private v f349a;

    a1(v vVar) {
        this.f349a = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }

    public r d() {
        return new z0(this.f349a.d());
    }
}
