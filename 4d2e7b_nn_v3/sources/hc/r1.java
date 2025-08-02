package hc;

import java.io.IOException;
import java.util.Enumeration;

class r1 implements Enumeration {

    /* renamed from: a  reason: collision with root package name */
    private i f419a;

    /* renamed from: b  reason: collision with root package name */
    private Object f420b = a();

    public r1(byte[] bArr) {
        this.f419a = new i(bArr, true);
    }

    private Object a() {
        try {
            return this.f419a.w();
        } catch (IOException e10) {
            throw new q("malformed DER construction: " + e10, e10);
        }
    }

    public boolean hasMoreElements() {
        if (this.f420b != null) {
            return true;
        }
        return false;
    }

    public Object nextElement() {
        Object obj = this.f420b;
        this.f420b = a();
        return obj;
    }
}
