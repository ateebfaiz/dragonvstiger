package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.m;

public class EmptyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.f(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        m.f(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        m.f(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        m.f(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.f(activity, "activity");
        m.f(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        m.f(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        m.f(activity, "activity");
    }
}
