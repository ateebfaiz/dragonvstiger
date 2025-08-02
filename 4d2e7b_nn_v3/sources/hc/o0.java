package hc;

import java.io.IOException;

public class o0 implements d, p1 {

    /* renamed from: a  reason: collision with root package name */
    private v f403a;

    public o0(v vVar) {
        this.f403a = vVar;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q("unable to get DER object", e10);
        } catch (IllegalArgumentException e11) {
            throw new q("unable to get DER object", e11);
        }
    }

    public r d() {
        try {
            return new n0(this.f403a.d());
        } catch (IllegalArgumentException e10) {
            throw new g(e10.getMessage(), e10);
        }
    }
}
