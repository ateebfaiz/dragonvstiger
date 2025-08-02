package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.e;
import kotlinx.coroutines.l0;

public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), function2, dVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), function2, dVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), function2, dVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return e.c(l0.c().G(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, function2, (d) null), dVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, function2, dVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, function2, dVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, Function2<? super b0, ? super d, ? extends Object> function2, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, function2, dVar);
    }
}
