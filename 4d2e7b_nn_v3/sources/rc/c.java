package rc;

import dd.a;
import hc.e;
import hc.l;
import hc.m;
import hc.m0;
import hc.r;
import hc.z0;

public class c extends l implements j {

    /* renamed from: a  reason: collision with root package name */
    private dd.c f2006a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f2007b;

    /* renamed from: c  reason: collision with root package name */
    private m f2008c = null;

    public c(dd.c cVar, byte[] bArr) {
        this.f2006a = cVar;
        this.f2007b = bArr;
        g();
    }

    private void g() {
        if (a.c(this.f2006a)) {
            this.f2008c = j.f2047v;
        } else if (a.a(this.f2006a)) {
            this.f2008c = j.f2050x;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public r c() {
        e eVar = new e();
        if (this.f2008c.equals(j.f2047v)) {
            eVar.a(new g(this.f2006a.k()).c());
            eVar.a(new g(this.f2006a.l()).c());
        } else if (this.f2008c.equals(j.f2050x)) {
            eVar.a(new g(this.f2006a.k()).c());
            eVar.a(new g(this.f2006a.l()).c());
        }
        if (this.f2007b != null) {
            eVar.a(new m0(this.f2007b));
        }
        return new z0(eVar);
    }
}
