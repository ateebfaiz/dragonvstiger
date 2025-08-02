package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.m;

public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        m.f(generatedAdapterArr, "generatedAdapters");
        this.generatedAdapters = generatedAdapterArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(lifecycleOwner, "source");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter callMethods : this.generatedAdapters) {
            callMethods.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter callMethods2 : this.generatedAdapters) {
            callMethods2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
