package cd;

import dd.f;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public abstract class c implements AlgorithmParameterSpec {

    /* renamed from: a  reason: collision with root package name */
    private dd.c f116a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f117b;

    /* renamed from: c  reason: collision with root package name */
    private f f118c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f119d;

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f120e;

    public c(dd.c cVar, f fVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f116a = cVar;
        this.f118c = fVar.s();
        this.f119d = bigInteger;
        this.f120e = bigInteger2;
        this.f117b = bArr;
    }

    public dd.c a() {
        return this.f116a;
    }

    public f b() {
        return this.f118c;
    }

    public BigInteger c() {
        return this.f119d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!a().i(cVar.a()) || !b().d(cVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return a().hashCode() ^ b().hashCode();
    }
}
