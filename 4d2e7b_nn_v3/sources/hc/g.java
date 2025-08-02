package hc;

import java.io.IOException;

public class g extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private Throwable f371a;

    g(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.f371a;
    }

    g(String str, Throwable th) {
        super(str);
        this.f371a = th;
    }
}
