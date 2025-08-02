package hc;

import java.io.IOException;
import java.io.InputStream;

public class w0 implements o {

    /* renamed from: a  reason: collision with root package name */
    private o1 f441a;

    w0(o1 o1Var) {
        this.f441a = o1Var;
    }

    public InputStream a() {
        return this.f441a;
    }

    public r c() {
        try {
            return d();
        } catch (IOException e10) {
            throw new q("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    public r d() {
        return new v0(this.f441a.h());
    }
}
