package kd;

import hc.e;
import hc.e1;
import hc.j;
import hc.n;
import hc.r;
import hc.s;
import hc.v0;
import hc.w;
import hc.z0;
import java.math.BigInteger;
import zd.a;

public class l extends hc.l {

    /* renamed from: a  reason: collision with root package name */
    private final int f615a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f616b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f617c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f618d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f619e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f620f;

    public l(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f615a = i10;
        this.f616b = a.e(bArr);
        this.f617c = a.e(bArr2);
        this.f618d = a.e(bArr3);
        this.f619e = a.e(bArr4);
        this.f620f = a.e(bArr5);
    }

    public static l j(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j(0));
        e eVar2 = new e();
        eVar2.a(new j((long) this.f615a));
        eVar2.a(new v0(this.f616b));
        eVar2.a(new v0(this.f617c));
        eVar2.a(new v0(this.f618d));
        eVar2.a(new v0(this.f619e));
        eVar.a(new z0(eVar2));
        eVar.a(new e1(true, 0, new v0(this.f620f)));
        return new z0(eVar);
    }

    public byte[] g() {
        return a.e(this.f620f);
    }

    public int i() {
        return this.f615a;
    }

    public byte[] k() {
        return a.e(this.f618d);
    }

    public byte[] l() {
        return a.e(this.f619e);
    }

    public byte[] m() {
        return a.e(this.f617c);
    }

    public byte[] n() {
        return a.e(this.f616b);
    }

    private l(s sVar) {
        if (!j.o(sVar.q(0)).p().equals(BigInteger.valueOf(0))) {
            throw new IllegalArgumentException("unknown version of sequence");
        } else if (sVar.size() == 2 || sVar.size() == 3) {
            s o10 = s.o(sVar.q(1));
            this.f615a = j.o(o10.q(0)).p().intValue();
            this.f616b = a.e(n.p(o10.q(1)).q());
            this.f617c = a.e(n.p(o10.q(2)).q());
            this.f618d = a.e(n.p(o10.q(3)).q());
            this.f619e = a.e(n.p(o10.q(4)).q());
            if (sVar.size() == 3) {
                this.f620f = a.e(n.o(w.o(sVar.q(2)), true).q());
            } else {
                this.f620f = null;
            }
        } else {
            throw new IllegalArgumentException("key sequence wrong size");
        }
    }
}
