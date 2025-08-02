package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.f1;

final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, Unit> {
    private final CompletableFuture<T> future;

    /* access modifiers changed from: protected */
    public void J0(Throwable th, boolean z10) {
        boolean unused = this.future.completeExceptionally(th);
    }

    /* access modifiers changed from: protected */
    public void K0(Object obj) {
        boolean unused = this.future.complete(obj);
    }

    public void M0(Object obj, Throwable th) {
        f1.a.a(this, (CancellationException) null, 1, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        M0(obj, (Throwable) obj2);
        return Unit.f12577a;
    }
}
