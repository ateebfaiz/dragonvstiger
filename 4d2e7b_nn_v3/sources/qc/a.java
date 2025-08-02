package qc;

import hc.d;
import hc.e;
import hc.l;
import hc.m;
import hc.r;
import hc.s;
import hc.z0;

public class a extends l {

    /* renamed from: a  reason: collision with root package name */
    private m f1853a;

    /* renamed from: b  reason: collision with root package name */
    private d f1854b;

    public a(m mVar) {
        this.f1853a = mVar;
    }

    public static a i(Object obj) {
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
        eVar.a(this.f1853a);
        d dVar = this.f1854b;
        if (dVar != null) {
            eVar.a(dVar);
        }
        return new z0(eVar);
    }

    public m g() {
        return this.f1853a;
    }

    public d j() {
        return this.f1854b;
    }

    public a(m mVar, d dVar) {
        this.f1853a = mVar;
        this.f1854b = dVar;
    }

    private a(s sVar) {
        if (sVar.size() < 1 || sVar.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + sVar.size());
        }
        this.f1853a = m.t(sVar.q(0));
        if (sVar.size() == 2) {
            this.f1854b = sVar.q(1);
        } else {
            this.f1854b = null;
        }
    }
}
