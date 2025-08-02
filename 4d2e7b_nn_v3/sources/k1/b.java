package k1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import h1.a;

public class b implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("activity", activity.getComponentName().getClassName());
        a.i(activity.getApplicationContext(), PointerIconCompat.TYPE_COPY, bundle2);
    }

    public void onActivityDestroyed(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        a.i(activity.getApplicationContext(), PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, bundle);
    }

    public void onActivityPaused(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        a.i(activity.getApplicationContext(), PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, bundle);
    }

    public void onActivityResumed(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        a.i(activity.getApplicationContext(), PointerIconCompat.TYPE_ALL_SCROLL, bundle);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        bundle.putBoolean("state", true);
        a.i(activity.getApplicationContext(), 1008, bundle);
    }

    public void onActivityStopped(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        bundle.putBoolean("state", false);
        a.i(activity.getApplicationContext(), 1008, bundle);
    }
}
