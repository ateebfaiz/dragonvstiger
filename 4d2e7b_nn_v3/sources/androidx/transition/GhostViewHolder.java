package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f16629a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16630b = true;

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f16629a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        y.b(this.f16629a).a(this);
    }

    static GhostViewHolder b(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i10 = 0;
        while (i10 <= childCount) {
            int i11 = (i10 + childCount) / 2;
            d(((GhostViewPort) getChildAt(i11)).f16633c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i10 = i11 + 1;
            } else {
                childCount = i11 - 1;
            }
            arrayList2.clear();
        }
        return i10;
    }

    private static void d(View view, ArrayList arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() == view2.getZ()) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(y.a(viewGroup, i10));
                if (childAt == view) {
                    return false;
                }
                if (childAt == view2) {
                    break;
                }
            }
            return true;
        } else if (view.getZ() > view2.getZ()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean f(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i10 = 1; i10 < min; i10++) {
            View view = (View) arrayList.get(i10);
            View view2 = (View) arrayList2.get(i10);
            if (view != view2) {
                return e(view, view2);
            }
        }
        if (arrayList2.size() == min) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(GhostViewPort ghostViewPort) {
        ArrayList arrayList = new ArrayList();
        d(ghostViewPort.f16633c, arrayList);
        int c10 = c(arrayList);
        if (c10 < 0 || c10 >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, c10);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f16630b) {
            y.b(this.f16629a).b(this);
            y.b(this.f16629a).a(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewAdded(View view) {
        if (this.f16630b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f16629a.setTag(R.id.ghost_view_holder, (Object) null);
            y.b(this.f16629a).b(this);
            this.f16630b = false;
        }
    }
}
