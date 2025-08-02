package hc;

import ae.d;

public class k0 extends a {
    k0(boolean z10, int i10, byte[] bArr) {
        super(z10, i10, bArr);
    }

    /* access modifiers changed from: package-private */
    public void i(p pVar) {
        int i10;
        if (this.f344a) {
            i10 = 96;
        } else {
            i10 = 64;
        }
        pVar.f(i10, this.f345b, this.f346c);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (l()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(o()));
        stringBuffer.append("]");
        if (this.f346c != null) {
            stringBuffer.append(" #");
            stringBuffer.append(d.d(this.f346c));
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
