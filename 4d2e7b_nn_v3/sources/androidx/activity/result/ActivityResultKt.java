package androidx.activity.result;

import android.content.Intent;
import kotlin.jvm.internal.m;

public final class ActivityResultKt {
    public static final int component1(ActivityResult activityResult) {
        m.f(activityResult, "<this>");
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        m.f(activityResult, "<this>");
        return activityResult.getData();
    }
}
