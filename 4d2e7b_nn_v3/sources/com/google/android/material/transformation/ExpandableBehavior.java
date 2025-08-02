package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    /* access modifiers changed from: private */
    public int currentState = 0;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8750a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f8751b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ExpandableWidget f8752c;

        a(View view, int i10, ExpandableWidget expandableWidget) {
            this.f8750a = view;
            this.f8751b = i10;
            this.f8752c = expandableWidget;
        }

        public boolean onPreDraw() {
            this.f8750a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.currentState == this.f8751b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                ExpandableWidget expandableWidget = this.f8752c;
                expandableBehavior.onExpandedStateChange((View) expandableWidget, this.f8750a, expandableWidget.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    private boolean didStateChange(boolean z10) {
        if (z10) {
            int i10 = this.currentState;
            if (i10 == 0 || i10 == 2) {
                return true;
            }
            return false;
        } else if (this.currentState == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View view, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof ExpandableBehavior) {
                return (ExpandableBehavior) cls.cast(behavior);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = dependencies.get(i10);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i10;
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        if (expandableWidget.isExpanded()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        this.currentState = i10;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    /* access modifiers changed from: protected */
    public abstract boolean onExpandedStateChange(View view, View view2, boolean z10, boolean z11);

    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i10) {
        ExpandableWidget findExpandableWidget;
        int i11;
        if (ViewCompat.isLaidOut(view) || (findExpandableWidget = findExpandableWidget(coordinatorLayout, view)) == null || !didStateChange(findExpandableWidget.isExpanded())) {
            return false;
        }
        if (findExpandableWidget.isExpanded()) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        this.currentState = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, findExpandableWidget));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
