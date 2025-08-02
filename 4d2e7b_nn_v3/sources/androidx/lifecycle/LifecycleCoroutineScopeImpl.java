package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.l0;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle2, CoroutineContext coroutineContext2) {
        m.f(lifecycle2, "lifecycle");
        m.f(coroutineContext2, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = coroutineContext2;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            k1.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleOwner, "source");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            k1.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        f1 unused = f.b(this, l0.c().G(), (d0) null, new LifecycleCoroutineScopeImpl$register$1(this, (d) null), 2, (Object) null);
    }
}
