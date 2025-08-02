package androidx.activity;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.m;

@RequiresApi(26)
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final void setPipParamsSourceRectHint(Activity activity, Rect rect) {
        m.f(activity, "activity");
        m.f(rect, "hint");
        activity.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(rect).build());
    }
}
