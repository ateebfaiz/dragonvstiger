package hc;

import java.math.BigInteger;
import zd.a;
import zd.e;

public class j extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f384a;

    public j(long j10) {
        this.f384a = BigInteger.valueOf(j10).toByteArray();
    }

    public static j o(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (j) r.k((byte[]) obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    static boolean q(byte[] bArr) {
        if (bArr.length > 1) {
            byte b10 = bArr[0];
            if (b10 == 0 && (bArr[1] & 128) == 0) {
                return true;
            }
            if (b10 != -1 || (bArr[1] & 128) == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof j)) {
            return false;
        }
        return a.a(this.f384a, ((j) rVar).f384a);
    }

    public int hashCode() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f384a;
            if (i10 == bArr.length) {
                return i11;
            }
            i11 ^= (bArr[i10] & 255) << (i10 % 4);
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(2, this.f384a);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f384a.length) + 1 + this.f384a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public BigInteger p() {
        return new BigInteger(this.f384a);
    }

    public String toString() {
        return p().toString();
    }

    public j(BigInteger bigInteger) {
        this.f384a = bigInteger.toByteArray();
    }

    j(byte[] bArr, boolean z10) {
        if (e.c("org.spongycastle.asn1.allow_unsafe_integer") || !q(bArr)) {
            this.f384a = z10 ? a.e(bArr) : bArr;
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }
}
