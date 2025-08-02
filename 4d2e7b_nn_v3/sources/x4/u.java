package x4;

import c3.a;
import y2.m;

public class u implements x {

    /* renamed from: a  reason: collision with root package name */
    private final x f24813a;

    /* renamed from: b  reason: collision with root package name */
    private final z f24814b;

    public u(x xVar, z zVar) {
        this.f24813a = xVar;
        this.f24814b = zVar;
    }

    public int a(m mVar) {
        return this.f24813a.a(mVar);
    }

    public a b(Object obj, a aVar) {
        this.f24814b.c(obj);
        return this.f24813a.b(obj, aVar);
    }

    public void c(Object obj) {
        this.f24813a.c(obj);
    }

    public boolean f(m mVar) {
        return this.f24813a.f(mVar);
    }

    public a get(Object obj) {
        a aVar = this.f24813a.get(obj);
        if (aVar == null) {
            this.f24814b.b(obj);
        } else {
            this.f24814b.a(obj);
        }
        return aVar;
    }
}
