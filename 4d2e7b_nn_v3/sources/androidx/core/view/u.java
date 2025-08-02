package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class u implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f15274a;

    public /* synthetic */ u(DragStartHelper dragStartHelper) {
        this.f15274a = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f15274a.onTouch(view, motionEvent);
    }
}
