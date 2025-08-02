package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.f1;

@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, f1 f1Var) {
        m.f(lifecycle2, "lifecycle");
        m.f(state, "minState");
        m.f(dispatchQueue2, "dispatchQueue");
        m.f(f1Var, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        g gVar = new g(this, f1Var);
        this.observer = gVar;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            f1.a.a(f1Var, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(gVar);
    }

    private final void handleDestroy(f1 f1Var) {
        f1.a.a(f1Var, (CancellationException) null, 1, (Object) null);
        finish();
    }

    /* access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, f1 f1Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleController, "this$0");
        m.f(f1Var, "$parentJob");
        m.f(lifecycleOwner, "source");
        m.f(event, "<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            f1.a.a(f1Var, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
