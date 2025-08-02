package hc;

import java.io.IOException;
import java.io.OutputStream;

public class x0 extends p {
    public x0(OutputStream outputStream) {
        super(outputStream);
    }

    /* access modifiers changed from: package-private */
    public p a() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public p b() {
        return this;
    }

    public void j(d dVar) {
        if (dVar != null) {
            dVar.c().m().i(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
