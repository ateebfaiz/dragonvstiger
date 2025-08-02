package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.f1;

public final /* synthetic */ class g implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f15890a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f1 f15891b;

    public /* synthetic */ g(LifecycleController lifecycleController, f1 f1Var) {
        this.f15890a = lifecycleController;
        this.f15891b = f1Var;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.f15890a, this.f15891b, lifecycleOwner, event);
    }
}
