package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.m;

public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements LifecycleEventObserver {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ SavedStateRegistry $registry;

    LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.$lifecycle = lifecycle;
        this.$registry = savedStateRegistry;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleOwner, "source");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            this.$lifecycle.removeObserver(this);
            this.$registry.runOnNextRecreation(LegacySavedStateHandleController.OnRecreation.class);
        }
    }
}
