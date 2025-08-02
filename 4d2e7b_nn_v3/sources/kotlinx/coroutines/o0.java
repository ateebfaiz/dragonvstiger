package kotlinx.coroutines;

import kotlin.Unit;

public final class o0 extends l1 {

    /* renamed from: e  reason: collision with root package name */
    private final m0 f1108e;

    public o0(m0 m0Var) {
        this.f1108e = m0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.f12577a;
    }

    public void s(Throwable th) {
        this.f1108e.dispose();
    }
}
