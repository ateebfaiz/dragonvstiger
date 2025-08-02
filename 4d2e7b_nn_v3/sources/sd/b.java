package sd;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import kd.e;
import zd.a;

public class b implements Key, PublicKey {

    /* renamed from: a  reason: collision with root package name */
    private final md.b f2063a;

    public b(qc.b bVar) {
        this.f2063a = new md.b(bVar.j().q());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return a.a(this.f2063a.a(), ((b) obj).f2063a.a());
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public byte[] getEncoded() {
        try {
            return new qc.b(new qc.a(e.f581v), this.f2063a.a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return a.m(this.f2063a.a());
    }
}
