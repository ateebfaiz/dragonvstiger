package kotlinx.coroutines;

import kotlin.Unit;

public final class n extends h1 implements m {

    /* renamed from: e  reason: collision with root package name */
    public final o f1106e;

    public n(o oVar) {
        this.f1106e = oVar;
    }

    public boolean b(Throwable th) {
        return t().Q(th);
    }

    public f1 getParent() {
        return t();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.f12577a;
    }

    public void s(Throwable th) {
        this.f1106e.p(t());
    }
}
