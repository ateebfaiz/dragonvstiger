package androidx.activity.contextaware;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ CancellableContinuation<R> $co;
    final /* synthetic */ Function1<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(CancellableContinuation<R> cancellableContinuation, Function1<Context, R> function1) {
        this.$co = cancellableContinuation;
        this.$onContextAvailable = function1;
    }

    public void onContextAvailable(Context context) {
        Object obj;
        m.f(context, "context");
        CancellableContinuation<R> cancellableContinuation = this.$co;
        Function1<Context, R> function1 = this.$onContextAvailable;
        try {
            o.a aVar = o.f12592b;
            obj = o.b(function1.invoke(context));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        cancellableContinuation.d(obj);
    }
}
