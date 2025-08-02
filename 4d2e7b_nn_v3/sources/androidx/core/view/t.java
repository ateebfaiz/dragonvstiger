package androidx.core.view;

import android.view.View;

public final /* synthetic */ class t implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f15273a;

    public /* synthetic */ t(DragStartHelper dragStartHelper) {
        this.f15273a = dragStartHelper;
    }

    public final boolean onLongClick(View view) {
        return this.f15273a.onLongClick(view);
    }
}
