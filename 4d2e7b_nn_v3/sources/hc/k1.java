package hc;

import java.io.IOException;
import java.io.OutputStream;

public class k1 extends p {
    public k1(OutputStream outputStream) {
        super(outputStream);
    }

    public void j(d dVar) {
        if (dVar != null) {
            dVar.c().n().i(this);
            return;
        }
        throw new IOException("null object detected");
    }
}
