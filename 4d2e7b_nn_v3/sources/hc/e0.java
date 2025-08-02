package hc;

import java.io.IOException;

public class e0 implements t {

    /* renamed from: a  reason: collision with root package name */
    private v f366a;

    e0(v vVar) {
        this.f366a = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }

    public r d() {
        return new d0(this.f366a.d());
    }
}
