package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.m;

@RequiresApi(34)
public final class Api34Impl {
    public static final Api34Impl INSTANCE = new Api34Impl();

    private Api34Impl() {
    }

    @DoNotInline
    public final BackEvent createOnBackEvent(float f10, float f11, float f12, int i10) {
        return new BackEvent(f10, f11, f12, i10);
    }

    @DoNotInline
    public final float progress(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    @DoNotInline
    public final int swipeEdge(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    @DoNotInline
    public final float touchX(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    @DoNotInline
    public final float touchY(BackEvent backEvent) {
        m.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
