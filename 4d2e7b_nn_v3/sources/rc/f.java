package rc;

import dd.c;
import hc.l;
import hc.n;
import hc.r;
import hc.v0;
import zd.a;

public class f extends l {

    /* renamed from: a  reason: collision with root package name */
    private final n f2017a;

    /* renamed from: b  reason: collision with root package name */
    private c f2018b;

    /* renamed from: c  reason: collision with root package name */
    private dd.f f2019c;

    public f(c cVar, byte[] bArr) {
        this.f2018b = cVar;
        this.f2017a = new v0(a.e(bArr));
    }

    public r c() {
        return this.f2017a;
    }

    public synchronized dd.f g() {
        try {
            if (this.f2019c == null) {
                this.f2019c = this.f2018b.g(this.f2017a.q()).s();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2019c;
    }
}
