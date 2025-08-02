package sd;

import hc.n;
import hc.v0;
import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import kd.e;
import zd.d;

public class a implements Key, PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private final md.a f2062a;

    public a(nc.a aVar) {
        this.f2062a = new md.a(a(n.p(aVar.j()).q()));
    }

    private static short[] a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 != length; i10++) {
            sArr[i10] = d.g(bArr, i10 * 2);
        }
        return sArr;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return zd.a.d(this.f2062a.a(), ((a) obj).f2062a.a());
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public byte[] getEncoded() {
        try {
            qc.a aVar = new qc.a(e.f581v);
            short[] a10 = this.f2062a.a();
            byte[] bArr = new byte[(a10.length * 2)];
            for (int i10 = 0; i10 != a10.length; i10++) {
                d.k(a10[i10], bArr, i10 * 2);
            }
            return new nc.a(aVar, new v0(bArr)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return zd.a.r(this.f2062a.a());
    }
}
