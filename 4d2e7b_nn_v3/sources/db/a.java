package db;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.swmansion.rnscreens.ScreenStack;
import kotlin.jvm.internal.m;

public abstract class a {
    public static final boolean a(View view) {
        m.f(view, "<this>");
        if (!(view instanceof ReactHorizontalScrollView) && !(view instanceof ReactScrollView)) {
            ViewParent parent = view.getParent();
            while ((parent instanceof ViewGroup) && !(parent instanceof ScreenStack)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof ReactHorizontalScrollView) {
                    return ((ReactHorizontalScrollView) parent).getRemoveClippedSubviews();
                }
                if (viewGroup instanceof ReactScrollView) {
                    return ((ReactScrollView) parent).getRemoveClippedSubviews();
                }
                parent = viewGroup.getParent();
            }
        }
        return false;
    }
}
