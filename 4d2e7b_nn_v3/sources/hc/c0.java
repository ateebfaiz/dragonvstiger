package hc;

import be.a;
import java.io.IOException;
import java.io.InputStream;

public class c0 implements o {

    /* renamed from: a  reason: collision with root package name */
    private v f362a;

    c0(v vVar) {
        this.f362a = vVar;
    }

    public InputStream a() {
        return new j0(this.f362a);
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    public r d() {
        return new b0(a.b(a()));
    }
}
