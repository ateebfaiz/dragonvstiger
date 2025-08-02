package i0;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f22038a;

    public /* synthetic */ a(SavedStateRegistry savedStateRegistry) {
        this.f22038a = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.performAttach$lambda$4(this.f22038a, lifecycleOwner, event);
    }
}
