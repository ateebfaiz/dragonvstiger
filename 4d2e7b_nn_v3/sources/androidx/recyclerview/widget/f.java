package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class f implements ItemTouchUIUtil {

    /* renamed from: a  reason: collision with root package name */
    static final ItemTouchUIUtil f16366a = new f();

    f() {
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f10) {
                    f10 = elevation;
                }
            }
        }
        return f10;
    }

    public void clearView(View view) {
        Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            ViewCompat.setElevation(view, ((Float) tag).floatValue());
        }
        view.setTag(R.id.item_touch_helper_previous_elevation, (Object) null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (z10 && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            ViewCompat.setElevation(view, a(recyclerView, view) + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    public void onSelected(View view) {
    }
}
