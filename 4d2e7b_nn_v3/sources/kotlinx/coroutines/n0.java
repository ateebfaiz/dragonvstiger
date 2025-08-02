package kotlinx.coroutines;

import kotlin.Unit;

final class n0 extends g {

    /* renamed from: a  reason: collision with root package name */
    private final m0 f1107a;

    public n0(m0 m0Var) {
        this.f1107a = m0Var;
    }

    public void h(Throwable th) {
        this.f1107a.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        h((Throwable) obj);
        return Unit.f12577a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f1107a + ']';
    }
}
