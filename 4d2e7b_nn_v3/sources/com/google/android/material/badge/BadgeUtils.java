package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

@ExperimentalBadgeUtils
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Toolbar f7919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f7921c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FrameLayout f7922d;

        a(Toolbar toolbar, int i10, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.f7919a = toolbar;
            this.f7920b = i10;
            this.f7921c = badgeDrawable;
            this.f7922d = frameLayout;
        }

        public void run() {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(this.f7919a, this.f7920b);
            if (actionMenuItemView != null) {
                BadgeUtils.setToolbarOffset(this.f7921c, this.f7919a.getResources());
                BadgeUtils.attachBadgeDrawable(this.f7921c, (View) actionMenuItemView, this.f7922d);
                BadgeUtils.attachBadgeContentDescription(this.f7921c, actionMenuItemView);
            }
        }
    }

    class b extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f7923a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(View.AccessibilityDelegate accessibilityDelegate, BadgeDrawable badgeDrawable) {
            super(accessibilityDelegate);
            this.f7923a = badgeDrawable;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.f7923a.getContentDescription());
        }
    }

    class c extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f7924a;

        c(BadgeDrawable badgeDrawable) {
            this.f7924a = badgeDrawable;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.f7924a.getContentDescription());
        }
    }

    class d extends AccessibilityDelegateCompat {
        d(View.AccessibilityDelegate accessibilityDelegate) {
            super(accessibilityDelegate);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription((CharSequence) null);
        }
    }

    private BadgeUtils() {
    }

    /* access modifiers changed from: private */
    public static void attachBadgeContentDescription(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, new c(badgeDrawable));
        } else {
            ViewCompat.setAccessibilityDelegate(view, new b(view.getAccessibilityDelegate(), badgeDrawable));
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        int i10 = 0;
        while (i10 < parcelableSparseArray.size()) {
            int keyAt = parcelableSparseArray.keyAt(i10);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i10);
            if (state != null) {
                sparseArray.put(keyAt, BadgeDrawable.createFromSavedState(context, state));
                i10++;
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        int i10 = 0;
        while (i10 < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i10);
            BadgeDrawable valueAt = sparseArray.valueAt(i10);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.getSavedState());
                i10++;
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    private static void detachBadgeContentDescription(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, (AccessibilityDelegateCompat) null);
        } else {
            ViewCompat.setAccessibilityDelegate(view, new d(view.getAccessibilityDelegate()));
        }
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable != null) {
            if (USE_COMPAT_PARENT || badgeDrawable.getCustomBadgeParent() != null) {
                badgeDrawable.getCustomBadgeParent().setForeground((Drawable) null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    @VisibleForTesting
    static void removeToolbarOffset(BadgeDrawable badgeDrawable) {
        badgeDrawable.setAdditionalHorizontalOffset(0);
        badgeDrawable.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    @VisibleForTesting
    static void setToolbarOffset(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.setAdditionalHorizontalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.setAdditionalVerticalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@NonNull Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else if (!USE_COMPAT_PARENT) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i10) {
        if (badgeDrawable != null) {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i10);
            if (actionMenuItemView != null) {
                removeToolbarOffset(badgeDrawable);
                detachBadgeDrawable(badgeDrawable, actionMenuItemView);
                detachBadgeContentDescription(actionMenuItemView);
                return;
            }
            Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + i10);
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i10) {
        attachBadgeDrawable(badgeDrawable, toolbar, i10, (FrameLayout) null);
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i10, @Nullable FrameLayout frameLayout) {
        toolbar.post(new a(toolbar, i10, badgeDrawable, frameLayout));
    }
}
