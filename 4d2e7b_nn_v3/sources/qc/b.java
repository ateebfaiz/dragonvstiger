package qc;

import hc.d;
import hc.e;
import hc.i;
import hc.l;
import hc.m0;
import hc.r;
import hc.s;
import hc.z0;
import java.util.Enumeration;

public class b extends l {

    /* renamed from: a  reason: collision with root package name */
    private a f1855a;

    /* renamed from: b  reason: collision with root package name */
    private m0 f1856b;

    public b(a aVar, d dVar) {
        this.f1856b = new m0(dVar);
        this.f1855a = aVar;
    }

    public static b i(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(this.f1855a);
        eVar.a(this.f1856b);
        return new z0(eVar);
    }

    public a g() {
        return this.f1855a;
    }

    public m0 j() {
        return this.f1856b;
    }

    public r k() {
        return new i(this.f1856b.r()).w();
    }

    public b(a aVar, byte[] bArr) {
        this.f1856b = new m0(bArr);
        this.f1855a = aVar;
    }

    public b(s sVar) {
        if (sVar.size() == 2) {
            Enumeration r10 = sVar.r();
            this.f1855a = a.i(r10.nextElement());
            this.f1856b = m0.u(r10.nextElement());
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + sVar.size());
    }
}
