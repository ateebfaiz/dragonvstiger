package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class c1 extends g {

    /* renamed from: a  reason: collision with root package name */
    private final Function1 f850a;

    public c1(Function1 function1) {
        this.f850a = function1;
    }

    public void h(Throwable th) {
        this.f850a.invoke(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        h((Throwable) obj);
        return Unit.f12577a;
    }

    public String toString() {
        return "InvokeOnCancel[" + f0.a(this.f850a) + '@' + f0.b(this) + ']';
    }
}
