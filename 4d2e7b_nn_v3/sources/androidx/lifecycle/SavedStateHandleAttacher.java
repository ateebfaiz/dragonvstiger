package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.m;

public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        m.f(savedStateHandlesProvider, "provider");
        this.provider = savedStateHandlesProvider;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleOwner, "source");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.provider.performRestore();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
