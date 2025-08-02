package hc;

import java.io.IOException;

public class z implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f444a;

    /* renamed from: b  reason: collision with root package name */
    private final v f445b;

    z(int i10, v vVar) {
        this.f444a = i10;
        this.f445b = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q(e10.getMessage(), e10);
        }
    }

    public r d() {
        return new y(this.f444a, this.f445b.d());
    }
}
