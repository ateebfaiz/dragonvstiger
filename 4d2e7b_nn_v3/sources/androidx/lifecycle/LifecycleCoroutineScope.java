package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f1;

public abstract class LifecycleCoroutineScope implements b0 {
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final f1 launchWhenCreated(Function2<? super b0, ? super d, ? extends Object> function2) {
        m.f(function2, "block");
        return f.b(this, (CoroutineContext) null, (d0) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, function2, (d) null), 3, (Object) null);
    }

    public final f1 launchWhenResumed(Function2<? super b0, ? super d, ? extends Object> function2) {
        m.f(function2, "block");
        return f.b(this, (CoroutineContext) null, (d0) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, function2, (d) null), 3, (Object) null);
    }

    public final f1 launchWhenStarted(Function2<? super b0, ? super d, ? extends Object> function2) {
        m.f(function2, "block");
        return f.b(this, (CoroutineContext) null, (d0) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, function2, (d) null), 3, (Object) null);
    }
}
