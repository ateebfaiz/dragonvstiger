package nc;

import hc.d;
import hc.e;
import hc.e1;
import hc.j;
import hc.l;
import hc.n;
import hc.r;
import hc.s;
import hc.u;
import hc.v0;
import hc.w;
import hc.z0;
import java.util.Enumeration;

public class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private n f1332a;

    /* renamed from: b  reason: collision with root package name */
    private qc.a f1333b;

    /* renamed from: c  reason: collision with root package name */
    private u f1334c;

    public a(qc.a aVar, d dVar) {
        this(aVar, dVar, (u) null);
    }

    public static a g(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(s.o(obj));
        }
        return null;
    }

    public r c() {
        e eVar = new e();
        eVar.a(new j(0));
        eVar.a(this.f1333b);
        eVar.a(this.f1332a);
        if (this.f1334c != null) {
            eVar.a(new e1(false, 0, this.f1334c));
        }
        return new z0(eVar);
    }

    public qc.a i() {
        return this.f1333b;
    }

    public d j() {
        return r.k(this.f1332a.q());
    }

    public a(qc.a aVar, d dVar, u uVar) {
        this.f1332a = new v0(dVar.c().f("DER"));
        this.f1333b = aVar;
        this.f1334c = uVar;
    }

    public a(s sVar) {
        Enumeration r10 = sVar.r();
        if (((j) r10.nextElement()).p().intValue() == 0) {
            this.f1333b = qc.a.i(r10.nextElement());
            this.f1332a = n.p(r10.nextElement());
            if (r10.hasMoreElements()) {
                this.f1334c = u.p((w) r10.nextElement(), false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }
}
