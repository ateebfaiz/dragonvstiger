package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static class a {
        @DoNotInline
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @DoNotInline
        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @DoNotInline
        static void c(ViewGroup viewGroup, boolean z10) {
            viewGroup.setTransitionGroup(z10);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        return a.a(viewGroup);
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        return a.b(viewGroup);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i10) {
        viewGroup.setLayoutMode(i10);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z10) {
        viewGroup.setMotionEventSplittingEnabled(z10);
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z10) {
        a.c(viewGroup, z10);
    }
}
