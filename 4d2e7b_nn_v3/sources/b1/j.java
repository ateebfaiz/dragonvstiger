package b1;

import a1.n;
import a1.p;
import a1.v;
import java.io.UnsupportedEncodingException;

public abstract class j extends n {
    private static final String Q0 = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    private final Object N0 = new Object();
    private p.b O0;
    private final String P0;

    public j(int i10, String str, String str2, p.b bVar, p.a aVar) {
        super(i10, str, aVar);
        this.O0 = bVar;
        this.P0 = str2;
    }

    /* access modifiers changed from: protected */
    public void e(Object obj) {
        p.b bVar;
        synchronized (this.N0) {
            bVar = this.O0;
        }
        if (bVar != null) {
            bVar.a(obj);
        }
    }

    public byte[] h() {
        try {
            String str = this.P0;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            v.f("Unsupported Encoding while trying to get the bytes of %s using %s", this.P0, "utf-8");
            return null;
        }
    }

    public String i() {
        return Q0;
    }

    public byte[] n() {
        return h();
    }
}
