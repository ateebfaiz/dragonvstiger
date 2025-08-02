package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class e1 extends l1 {

    /* renamed from: e  reason: collision with root package name */
    private final Function1 f963e;

    public e1(Function1 function1) {
        this.f963e = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.f12577a;
    }

    public void s(Throwable th) {
        this.f963e.invoke(th);
    }
}
