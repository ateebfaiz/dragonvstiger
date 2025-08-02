package androidx.activity.contextaware;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.m;

public final class ContextAwareHelper {
    private volatile Context context;
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        m.f(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Context context2 = this.context;
        if (context2 != null) {
            onContextAvailableListener.onContextAvailable(context2);
        }
        this.listeners.add(onContextAvailableListener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(Context context2) {
        m.f(context2, "context");
        this.context = context2;
        for (OnContextAvailableListener onContextAvailable : this.listeners) {
            onContextAvailable.onContextAvailable(context2);
        }
    }

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        m.f(onContextAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(onContextAvailableListener);
    }
}
