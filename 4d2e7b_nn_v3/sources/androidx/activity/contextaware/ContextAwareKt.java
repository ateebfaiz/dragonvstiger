package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<Context, R> function1, d dVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.b(dVar), 1);
        cancellableContinuationImpl.E();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(cancellableContinuationImpl, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        cancellableContinuationImpl.j(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object A = cancellableContinuationImpl.A();
        if (A == b.c()) {
            e.c(dVar);
        }
        return A;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, Function1<Context, R> function1, d dVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return function1.invoke(peekAvailableContext);
        }
        k.c(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.b(dVar), 1);
        cancellableContinuationImpl.E();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(cancellableContinuationImpl, function1);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        cancellableContinuationImpl.j(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Unit unit = Unit.f12577a;
        Object A = cancellableContinuationImpl.A();
        if (A == b.c()) {
            e.c(dVar);
        }
        k.c(1);
        return A;
    }
}
