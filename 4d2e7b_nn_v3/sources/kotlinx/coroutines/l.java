package kotlinx.coroutines;

import kotlin.Unit;

public final class l extends h1 {

    /* renamed from: e  reason: collision with root package name */
    public final CancellableContinuationImpl f1093e;

    public l(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f1093e = cancellableContinuationImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.f12577a;
    }

    public void s(Throwable th) {
        CancellableContinuationImpl cancellableContinuationImpl = this.f1093e;
        cancellableContinuationImpl.M(cancellableContinuationImpl.y(t()));
    }
}
