package td;

import hc.t0;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import kd.e;
import kd.f;

public class a implements PrivateKey {

    /* renamed from: a  reason: collision with root package name */
    private short[][] f2148a;

    /* renamed from: b  reason: collision with root package name */
    private short[] f2149b;

    /* renamed from: c  reason: collision with root package name */
    private short[][] f2150c;

    /* renamed from: d  reason: collision with root package name */
    private short[] f2151d;

    /* renamed from: e  reason: collision with root package name */
    private nd.a[] f2152e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f2153f;

    public a(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, nd.a[] aVarArr) {
        this.f2148a = sArr;
        this.f2149b = sArr2;
        this.f2150c = sArr3;
        this.f2151d = sArr4;
        this.f2153f = iArr;
        this.f2152e = aVarArr;
    }

    public short[] a() {
        return this.f2149b;
    }

    public short[] b() {
        return this.f2151d;
    }

    public short[][] c() {
        return this.f2148a;
    }

    public short[][] d() {
        return this.f2150c;
    }

    public nd.a[] e() {
        return this.f2152e;
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!od.a.j(this.f2148a, aVar.c()) || !od.a.j(this.f2150c, aVar.d()) || !od.a.i(this.f2149b, aVar.a()) || !od.a.i(this.f2151d, aVar.b()) || !Arrays.equals(this.f2153f, aVar.f())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f2152e.length != aVar.e().length) {
            return false;
        }
        for (int length = this.f2152e.length - 1; length >= 0; length--) {
            z10 &= this.f2152e[length].equals(aVar.e()[length]);
        }
        return z10;
    }

    public int[] f() {
        return this.f2153f;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public byte[] getEncoded() {
        try {
            return new nc.a(new qc.a(e.f560a, t0.f424a), new f(this.f2148a, this.f2149b, this.f2150c, this.f2151d, this.f2153f, this.f2152e)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        int length = (((((((((this.f2152e.length * 37) + zd.a.s(this.f2148a)) * 37) + zd.a.r(this.f2149b)) * 37) + zd.a.s(this.f2150c)) * 37) + zd.a.r(this.f2151d)) * 37) + zd.a.o(this.f2153f);
        for (int length2 = this.f2152e.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.f2152e[length2].hashCode();
        }
        return length;
    }

    public a(xd.a aVar) {
        this(aVar.c(), aVar.a(), aVar.d(), aVar.b(), aVar.f(), aVar.e());
    }
}
