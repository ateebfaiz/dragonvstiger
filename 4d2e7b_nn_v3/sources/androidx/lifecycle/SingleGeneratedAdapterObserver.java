package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.m;

public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter2) {
        m.f(generatedAdapter2, "generatedAdapter");
        this.generatedAdapter = generatedAdapter2;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleOwner, "source");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        this.generatedAdapter.callMethods(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.generatedAdapter.callMethods(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}
