package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = 0.0f;
    private final ViewDragHelper.Callback dragCallback = new a();
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i10);
    }

    class a extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private int f7926a;

        /* renamed from: b  reason: collision with root package name */
        private int f7927b = -1;

        a() {
        }

        private boolean a(View view, float f10) {
            boolean z10;
            int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
            if (i10 != 0) {
                if (ViewCompat.getLayoutDirection(view) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = SwipeDismissBehavior.this.swipeDirection;
                if (i11 == 2) {
                    return true;
                }
                if (i11 == 0) {
                    if (z10) {
                        if (f10 >= 0.0f) {
                            return false;
                        }
                    } else if (i10 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i11 != 1) {
                    return false;
                } else {
                    if (z10) {
                        if (i10 <= 0) {
                            return false;
                        }
                    } else if (f10 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (Math.abs(view.getLeft() - this.f7926a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                    return true;
                }
                return false;
            }
        }

        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            boolean z10;
            int i12;
            int i13;
            int width;
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i14 = SwipeDismissBehavior.this.swipeDirection;
            if (i14 != 0) {
                if (i14 != 1) {
                    i12 = this.f7926a - view.getWidth();
                    i13 = view.getWidth() + this.f7926a;
                } else if (z10) {
                    i12 = this.f7926a;
                    width = view.getWidth();
                } else {
                    i12 = this.f7926a - view.getWidth();
                    i13 = this.f7926a;
                }
                return SwipeDismissBehavior.clamp(i12, i10, i13);
            } else if (z10) {
                i12 = this.f7926a - view.getWidth();
                i13 = this.f7926a;
                return SwipeDismissBehavior.clamp(i12, i10, i13);
            } else {
                i12 = this.f7926a;
                width = view.getWidth();
            }
            i13 = width + i12;
            return SwipeDismissBehavior.clamp(i12, i10, i13);
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public void onViewCaptured(View view, int i10) {
            this.f7927b = i10;
            this.f7926a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i10) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i10);
            }
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            float width = ((float) this.f7926a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = ((float) this.f7926a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f10 = (float) i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f10), 1.0f));
            }
        }

        public void onViewReleased(View view, float f10, float f11) {
            boolean z10;
            int i10;
            OnDismissListener onDismissListener;
            this.f7927b = -1;
            int width = view.getWidth();
            if (a(view, f10)) {
                int left = view.getLeft();
                int i11 = this.f7926a;
                if (left < i11) {
                    i10 = i11 - width;
                } else {
                    i10 = i11 + width;
                }
                z10 = true;
            } else {
                i10 = this.f7926a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(i10, view.getTop())) {
                ViewCompat.postOnAnimation(view, new c(view, z10));
            } else if (z10 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        public boolean tryCaptureView(View view, int i10) {
            int i11 = this.f7927b;
            if ((i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    }

    class b implements AccessibilityViewCommand {
        b() {
        }

        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            int i10;
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return false;
            }
            if (ViewCompat.getLayoutDirection(view) == 1) {
                z10 = true;
            }
            int i11 = SwipeDismissBehavior.this.swipeDirection;
            if ((i11 != 0 || !z10) && (i11 != 1 || z10)) {
                i10 = view.getWidth();
            } else {
                i10 = -view.getWidth();
            }
            ViewCompat.offsetLeftAndRight(view, i10);
            view.setAlpha(0.0f);
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(view);
            }
            return true;
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f7930a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7931b;

        c(View view, boolean z10) {
            this.f7930a = view;
            this.f7931b = z10;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f7930a, this);
            } else if (this.f7931b && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.f7930a);
            }
        }
    }

    static float clamp(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelper2;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                viewDragHelper2 = ViewDragHelper.create(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = viewDragHelper2;
        }
    }

    static float fraction(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    private void updateAccessibilityActions(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (canSwipeDismissView(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, (CharSequence) null, new b());
        }
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            return viewDragHelper2.getViewDragState();
        }
        return 0;
    }

    @VisibleForTesting
    @Nullable
    public OnDismissListener getListener() {
        return this.listener;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        boolean z10 = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.isPointInChildBounds(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z10) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v10, i10);
        if (ViewCompat.getImportantForAccessibility(v10) == 0) {
            ViewCompat.setImportantForAccessibility(v10, 1);
            updateAccessibilityActions(v10);
        }
        return onLayoutChild;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.processTouchEvent(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f10) {
        this.dragDismissThreshold = clamp(0.0f, f10, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f10) {
        this.alphaEndSwipeDistance = clamp(0.0f, f10, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f10) {
        this.sensitivity = f10;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f10) {
        this.alphaStartSwipeDistance = clamp(0.0f, f10, 1.0f);
    }

    public void setSwipeDirection(int i10) {
        this.swipeDirection = i10;
    }

    static int clamp(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }
}
