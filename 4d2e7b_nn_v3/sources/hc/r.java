package hc;

import java.io.IOException;

public abstract class r extends l {
    r() {
    }

    public static r k(byte[] bArr) {
        i iVar = new i(bArr);
        try {
            r w10 = iVar.w();
            if (iVar.available() == 0) {
                return w10;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public r c() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d) || !g(((d) obj).c())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean g(r rVar);

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract void i(p pVar);

    /* access modifiers changed from: package-private */
    public abstract int j();

    /* access modifiers changed from: package-private */
    public abstract boolean l();

    /* access modifiers changed from: package-private */
    public r m() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public r n() {
        return this;
    }
}
