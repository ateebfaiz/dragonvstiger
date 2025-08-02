package hc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import zd.a;

public class g1 extends r {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f373b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f374a;

    public g1(byte[] bArr) {
        this.f374a = a.e(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean g(r rVar) {
        if (!(rVar instanceof g1)) {
            return false;
        }
        return a.a(this.f374a, ((g1) rVar).f374a);
    }

    public int hashCode() {
        return a.m(this.f374a);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        pVar.g(28, o());
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return v1.a(this.f374a.length) + 1 + this.f374a.length;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    public byte[] o() {
        return a.e(this.f374a);
    }

    public String p() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new p(byteArrayOutputStream).j(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i10 = 0; i10 != byteArray.length; i10++) {
                char[] cArr = f373b;
                stringBuffer.append(cArr[(byteArray[i10] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i10] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new q("internal error encoding BitString");
        }
    }

    public String toString() {
        return p();
    }
}
