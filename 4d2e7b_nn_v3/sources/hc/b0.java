package hc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class b0 extends n {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public n[] f353b;

    class a implements Enumeration {

        /* renamed from: a  reason: collision with root package name */
        int f354a = 0;

        a() {
        }

        public boolean hasMoreElements() {
            if (this.f354a < b0.this.f353b.length) {
                return true;
            }
            return false;
        }

        public Object nextElement() {
            n[] r10 = b0.this.f353b;
            int i10 = this.f354a;
            this.f354a = i10 + 1;
            return r10[i10];
        }
    }

    public b0(byte[] bArr) {
        super(bArr);
    }

    static b0 s(s sVar) {
        n[] nVarArr = new n[sVar.size()];
        Enumeration r10 = sVar.r();
        int i10 = 0;
        while (r10.hasMoreElements()) {
            nVarArr[i10] = (n) r10.nextElement();
            i10++;
        }
        return new b0(nVarArr);
    }

    private Vector t() {
        int i10;
        Vector vector = new Vector();
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f396a;
            if (i11 >= bArr.length) {
                return vector;
            }
            int i12 = i11 + 1000;
            if (i12 > bArr.length) {
                i10 = bArr.length;
            } else {
                i10 = i12;
            }
            int i13 = i10 - i11;
            byte[] bArr2 = new byte[i13];
            System.arraycopy(bArr, i11, bArr2, 0, i13);
            vector.addElement(new v0(bArr2));
            i11 = i12;
        }
    }

    private static byte[] v(n[] nVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 != nVarArr.length) {
            try {
                byteArrayOutputStream.write(nVarArr[i10].q());
                i10++;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(nVarArr[i10].getClass().getName() + " found in input should only contain DEROctetString");
            } catch (IOException e10) {
                throw new IllegalArgumentException("exception converting octets " + e10.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void i(p pVar) {
        pVar.c(36);
        pVar.c(128);
        Enumeration u10 = u();
        while (u10.hasMoreElements()) {
            pVar.j((d) u10.nextElement());
        }
        pVar.c(0);
        pVar.c(0);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        Enumeration u10 = u();
        int i10 = 0;
        while (u10.hasMoreElements()) {
            i10 += ((d) u10.nextElement()).c().j();
        }
        return i10 + 4;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    public byte[] q() {
        return this.f396a;
    }

    public Enumeration u() {
        if (this.f353b == null) {
            return t().elements();
        }
        return new a();
    }

    public b0(n[] nVarArr) {
        super(v(nVarArr));
        this.f353b = nVarArr;
    }
}
