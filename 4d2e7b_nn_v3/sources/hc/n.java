package hc;

import ae.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import zd.a;
import zd.f;

public abstract class n extends r implements o {

    /* renamed from: a  reason: collision with root package name */
    byte[] f396a;

    public n(byte[] bArr) {
        if (bArr != null) {
            this.f396a = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public static n o(w wVar, boolean z10) {
        r p10 = wVar.p();
        if (z10 || (p10 instanceof n)) {
            return p(p10);
        }
        return b0.s(s.o(p10));
    }

    public static n p(Object obj) {
        if (obj == null || (obj instanceof n)) {
            return (n) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return p(r.k((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e10.getMessage());
            }
        } else {
            if (obj instanceof d) {
                r c10 = ((d) obj).c();
                if (c10 instanceof n) {
                    return (n) c10;
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public InputStream a() {
        return new ByteArrayInputStream(this.f396a);
    }

    public r d() {
        return c();
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof n)) {
            return false;
        }
        return a.a(this.f396a, ((n) rVar).f396a);
    }

    public int hashCode() {
        return a.m(q());
    }

    /* access modifiers changed from: package-private */
    public r m() {
        return new v0(this.f396a);
    }

    /* access modifiers changed from: package-private */
    public r n() {
        return new v0(this.f396a);
    }

    public byte[] q() {
        return this.f396a;
    }

    public String toString() {
        return "#" + f.b(d.b(this.f396a));
    }
}
