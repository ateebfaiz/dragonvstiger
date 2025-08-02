package hc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class y extends a {
    public y(int i10, e eVar) {
        super(true, i10, p(eVar));
    }

    private static byte[] p(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 != eVar.c()) {
            try {
                byteArrayOutputStream.write(((l) eVar.b(i10)).f("BER"));
                i10++;
            } catch (IOException e10) {
                throw new q("malformed object: " + e10, e10);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        int i10;
        if (this.f344a) {
            i10 = 96;
        } else {
            i10 = 64;
        }
        pVar.k(i10, this.f345b);
        pVar.c(128);
        pVar.d(this.f346c);
        pVar.c(0);
        pVar.c(0);
    }
}
