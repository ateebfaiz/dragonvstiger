package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class ActivityResultLauncherKt {
    public static final void launch(ActivityResultLauncher<Void> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        m.f(activityResultLauncher, "<this>");
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launchUnit(ActivityResultLauncher<Unit> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        m.f(activityResultLauncher, "<this>");
        activityResultLauncher.launch(Unit.f12577a, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }
}
