package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    @Nullable
    private ColorStateList backgroundTint;
    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new d();
    /* access modifiers changed from: private */
    public boolean draggable = true;
    float elevation = -1.0f;
    private int expandHalfwayActionId = -1;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = 0.5f;
    boolean hideable;
    private boolean ignoreEvents;
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    /* access modifiers changed from: private */
    public int insetBottom;
    /* access modifiers changed from: private */
    public int insetTop;
    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState = 4;
    /* access modifiers changed from: private */
    public boolean marginLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginRightSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginTopSystemWindowInsets;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private float maximumVelocity;
    private boolean nestedScrolled;
    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    /* access modifiers changed from: private */
    public boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    private final BottomSheetBehavior<V>.f stateSettlingTracker = new f(this, (a) null);
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    @Nullable
    private VelocityTracker velocityTracker;
    @Nullable
    ViewDragHelper viewDragHelper;
    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        /* access modifiers changed from: package-private */
        public void onLayout(@NonNull View view) {
        }

        public abstract void onSlide(@NonNull View view, float f10);

        public abstract void onStateChanged(@NonNull View view, int i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z10 = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z10;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f7955a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7956b;

        a(View view, int i10) {
            this.f7955a = view;
            this.f7956b = i10;
        }

        public void run() {
            BottomSheetBehavior.this.startSettling(this.f7955a, this.f7956b, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
            }
        }
    }

    class c implements ViewUtils.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f7959a;

        c(boolean z10) {
            this.f7959a = z10;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            boolean z10;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            int unused = BottomSheetBehavior.this.insetTop = insets.top;
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                int unused2 = BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
            }
            if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                if (isLayoutRtl) {
                    i14 = relativePadding.end;
                } else {
                    i14 = relativePadding.start;
                }
                paddingLeft = i14 + insets.left;
            }
            if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                if (isLayoutRtl) {
                    i13 = relativePadding.start;
                } else {
                    i13 = relativePadding.end;
                }
                paddingRight = i13 + insets.right;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z11 = true;
            if (!BottomSheetBehavior.this.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == (i12 = insets.left)) {
                z10 = false;
            } else {
                marginLayoutParams.leftMargin = i12;
                z10 = true;
            }
            if (BottomSheetBehavior.this.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != (i11 = insets.right)) {
                marginLayoutParams.rightMargin = i11;
                z10 = true;
            }
            if (!BottomSheetBehavior.this.marginTopSystemWindowInsets || marginLayoutParams.topMargin == (i10 = insets.top)) {
                z11 = z10;
            } else {
                marginLayoutParams.topMargin = i10;
            }
            if (z11) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f7959a) {
                int unused3 = BottomSheetBehavior.this.gestureInsetBottom = insets2.bottom;
            }
            if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || this.f7959a) {
                BottomSheetBehavior.this.updatePeekHeight(false);
            }
            return windowInsetsCompat;
        }
    }

    class d extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private long f7961a;

        d() {
        }

        private boolean a(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            int i12;
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                i12 = bottomSheetBehavior.parentHeight;
            } else {
                i12 = bottomSheetBehavior.collapsedOffset;
            }
            return MathUtils.clamp(i10, expandedOffset, i12);
        }

        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.dispatchOnSlide(i11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
            if (r9 > r7.f7962b.halfExpandedOffset) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.f7962b.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.f7962b.halfExpandedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
            if (r7.f7962b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00eb, code lost:
            if (java.lang.Math.abs(r9 - r7.f7962b.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.f7962b.collapsedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
            if (r7.f7962b.shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0121, code lost:
            if (r7.f7962b.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
            if (r10.shouldExpandOnUpwardDrag(r0, (((float) r9) * 100.0f) / ((float) r10.parentHeight)) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 6
                r3 = 3
                r4 = 4
                if (r1 >= 0) goto L_0x003f
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0013
            L_0x0010:
                r2 = r3
                goto L_0x0124
            L_0x0013:
                int r9 = r8.getTop()
                long r0 = java.lang.System.currentTimeMillis()
                long r5 = r7.f7961a
                long r0 = r0 - r5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.shouldSkipHalfExpandedStateWhenDragging()
                if (r10 == 0) goto L_0x0037
                float r9 = (float) r9
                r10 = 1120403456(0x42c80000, float:100.0)
                float r9 = r9 * r10
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r2 = r10.parentHeight
                float r2 = (float) r2
                float r9 = r9 / r2
                boolean r9 = r10.shouldExpandOnUpwardDrag(r0, r9)
                if (r9 == 0) goto L_0x00a7
                goto L_0x0010
            L_0x0037:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                if (r9 <= r10) goto L_0x0010
                goto L_0x0124
            L_0x003f:
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r1.hideable
                if (r5 == 0) goto L_0x008e
                boolean r1 = r1.shouldHide(r8, r10)
                if (r1 == 0) goto L_0x008e
                float r9 = java.lang.Math.abs(r9)
                float r0 = java.lang.Math.abs(r10)
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x005d
                r9 = 1140457472(0x43fa0000, float:500.0)
                int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r9 > 0) goto L_0x0063
            L_0x005d:
                boolean r9 = r7.a(r8)
                if (r9 == 0) goto L_0x0066
            L_0x0063:
                r2 = 5
                goto L_0x0124
            L_0x0066:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x006f
                goto L_0x0010
            L_0x006f:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.getExpandedOffset()
                int r9 = r9 - r10
                int r9 = java.lang.Math.abs(r9)
                int r10 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.halfExpandedOffset
                int r10 = r10 - r0
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0124
                goto L_0x0010
            L_0x008e:
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x00cc
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x009f
                goto L_0x00cc
            L_0x009f:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x00aa
            L_0x00a7:
                r2 = r4
                goto L_0x0124
            L_0x00aa:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00a7
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x0124
                goto L_0x00a7
            L_0x00cc:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.fitToContents
                if (r10 == 0) goto L_0x00ef
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.fitToContentsOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00a7
                goto L_0x0010
            L_0x00ef:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r10.halfExpandedOffset
                if (r9 >= r0) goto L_0x010a
                int r10 = r10.collapsedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0101
                goto L_0x0010
            L_0x0101:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x0124
                goto L_0x00a7
            L_0x010a:
                int r10 = r9 - r0
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00a7
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x0124
                goto L_0x00a7
            L_0x0124:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r9.shouldSkipSmoothAnimation()
                r9.startSettling(r8, r2, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(View view, int i10) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.state;
            if (i11 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.activePointerId == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f7961a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    class e implements AccessibilityViewCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7963a;

        e(int i10) {
            this.f7963a = i10;
        }

        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.setState(this.f7963a);
            return true;
        }
    }

    public BottomSheetBehavior() {
    }

    private int addAccessibilityActionForState(V v10, @StringRes int i10, int i11) {
        return ViewCompat.addAccessibilityAction(v10, v10.getResources().getString(i10), createAccessibilityViewCommandForState(i11));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i10;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i10 = this.gestureInsetBottom) <= 0) {
            return this.peekHeight + this.insetBottom;
        }
        return Math.max(this.peekHeight, i10 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int i10) {
        return new e(i10);
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context context) {
        if (this.shapeAppearanceModelDefault != null) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new b());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    private int getTopOffsetForState(int i10) {
        if (i10 == 3) {
            return getExpandedOffset();
        }
        if (i10 == 4) {
            return this.collapsedOffset;
        }
        if (i10 == 5) {
            return this.parentHeight;
        }
        if (i10 == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isLayouting(V v10) {
        ViewParent parent = v10.getParent();
        if (parent == null || !parent.isLayoutRequested() || !ViewCompat.isAttachedToWindow(v10)) {
            return false;
        }
        return true;
    }

    private void replaceAccessibilityActionForState(V v10, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i10) {
        ViewCompat.replaceAccessibilityAction(v10, accessibilityActionCompat, (CharSequence) null, createAccessibilityViewCommandForState(i10));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i10 = this.saveFlags;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void runAfterLayout(V v10, Runnable runnable) {
        if (isLayouting(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(@NonNull View view) {
        boolean z10;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z10) {
            ViewUtils.doOnApplyWindowInsets(view, new c(z10));
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper == null || (!this.draggable && this.state != 1)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void startSettling(View view, int i10, boolean z10) {
        int topOffsetForState = getTopOffsetForState(i10);
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null || (!z10 ? !viewDragHelper2.smoothSlideViewTo(view, view.getLeft(), topOffsetForState) : !viewDragHelper2.settleCapturedViewAt(view.getLeft(), topOffsetForState))) {
            setStateInternal(i10);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i10);
        this.stateSettlingTracker.c(i10);
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(view, 524288);
            ViewCompat.removeAccessibilityAction(view, 262144);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            int i10 = this.expandHalfwayActionId;
            if (i10 != -1) {
                ViewCompat.removeAccessibilityAction(view, i10);
            }
            int i11 = 6;
            if (!this.fitToContents && this.state != 6) {
                this.expandHalfwayActionId = addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6);
            }
            if (this.hideable && this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            int i12 = this.state;
            if (i12 == 3) {
                if (this.fitToContents) {
                    i11 = 4;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i11);
            } else if (i12 == 4) {
                if (this.fitToContents) {
                    i11 = 3;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i11);
            } else if (i12 == 6) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    private void updateDrawableForTargetState(int i10) {
        boolean z10;
        ValueAnimator valueAnimator;
        float f10;
        if (i10 != 2) {
            if (i10 == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.isShapeExpanded != z10) {
                this.isShapeExpanded = z10;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    if (z10) {
                        f10 = 0.0f;
                    } else {
                        f10 = 1.0f;
                    }
                    this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f10, f10});
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private void updateImportantForAccessibility(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z10) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    V childAt = coordinatorLayout.getChildAt(i10);
                    if (childAt != this.viewRef.get()) {
                        if (z10) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                ViewCompat.setImportantForAccessibility(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z10) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z10) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z10) {
                    setState(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i10) {
        float f10;
        float f11;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i11 = this.collapsedOffset;
            if (i10 > i11 || i11 == getExpandedOffset()) {
                int i12 = this.collapsedOffset;
                f10 = (float) (i12 - i10);
                f11 = (float) (this.parentHeight - i12);
            } else {
                int i13 = this.collapsedOffset;
                f10 = (float) (i13 - i10);
                f11 = (float) (i13 - getExpandedOffset());
            }
            float f12 = f10 / f11;
            for (int i14 = 0; i14 < this.callbacks.size(); i14++) {
                this.callbacks.get(i14).onSlide(view, f12);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i10));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public int getExpandedOffset() {
        int i10;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i11 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i10 = 0;
        } else {
            i10 = this.insetTop;
        }
        return Math.max(i11, i10);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2;
        boolean z10;
        View view;
        if (!v10.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x10, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            if (this.activePointerId != -1 || coordinatorLayout.isPointInChildBounds(v10, x10, this.initialY)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.ignoreEvents = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper2 = this.viewDragHelper) != null && viewDragHelper2.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        boolean z10;
        float f10;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v10);
            this.viewRef = new WeakReference<>(v10);
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                ViewCompat.setBackground(v10, materialShapeDrawable2);
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                float f11 = this.elevation;
                if (f11 == -1.0f) {
                    f11 = ViewCompat.getElevation(v10);
                }
                materialShapeDrawable3.setElevation(f11);
                if (this.state == 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.isShapeExpanded = z10;
                MaterialShapeDrawable materialShapeDrawable4 = this.materialShapeDrawable;
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                materialShapeDrawable4.setInterpolation(f10);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v10, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v10) == 0) {
                ViewCompat.setImportantForAccessibility(v10, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v10.getTop();
        coordinatorLayout.onLayoutChild(v10, i10);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.childHeight = height;
        int i11 = this.parentHeight;
        int i12 = i11 - height;
        int i13 = this.insetTop;
        if (i12 < i13) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i11;
            } else {
                this.childHeight = i11 - i13;
            }
        }
        this.fitToContentsOffset = Math.max(0, i11 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i14 = this.state;
        if (i14 == 3) {
            ViewCompat.offsetTopAndBottom(v10, getExpandedOffset());
        } else if (i14 == 6) {
            ViewCompat.offsetTopAndBottom(v10, this.halfExpandedOffset);
        } else if (this.hideable && i14 == 5) {
            ViewCompat.offsetTopAndBottom(v10, this.parentHeight);
        } else if (i14 == 4) {
            ViewCompat.offsetTopAndBottom(v10, this.collapsedOffset);
        } else if (i14 == 1 || i14 == 2) {
            ViewCompat.offsetTopAndBottom(v10, top - v10.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v10));
        for (int i15 = 0; i15 < this.callbacks.size(); i15++) {
            this.callbacks.get(i15).onLayout(v10);
        }
        return true;
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(getChildMeasureSpec(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        if (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11)) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        View view2;
        if (i12 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (!isNestedScrollingCheckEnabled() || view == view2) {
                int top = v10.getTop();
                int i13 = top - i11;
                if (i11 > 0) {
                    if (i13 < getExpandedOffset()) {
                        int expandedOffset2 = top - getExpandedOffset();
                        iArr[1] = expandedOffset2;
                        ViewCompat.offsetTopAndBottom(v10, -expandedOffset2);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i11;
                        ViewCompat.offsetTopAndBottom(v10, -i11);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                    int i14 = this.collapsedOffset;
                    if (i13 > i14 && !this.hideable) {
                        int i15 = top - i14;
                        iArr[1] = i15;
                        ViewCompat.offsetTopAndBottom(v10, -i15);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i11;
                        ViewCompat.offsetTopAndBottom(v10, -i11);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v10.getTop());
                this.lastNestedScrollDy = i11;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i10 = savedState.state;
        if (i10 == 1 || i10 == 2) {
            this.state = 4;
            this.lastStableState = 4;
            return;
        }
        this.state = i10;
        this.lastStableState = i10;
    }

    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i10 & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4.getTop() <= r2.halfExpandedOffset) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.setStateInternal(r0)
            return
        L_0x000f:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L_0x0024
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x0023
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L_0x0039
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x002f
            goto L_0x00aa
        L_0x002f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto L_0x00aa
            goto L_0x00a9
        L_0x0039:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L_0x0049
            float r3 = r2.getYVelocity()
            boolean r3 = r2.shouldHide(r4, r3)
            if (r3 == 0) goto L_0x0049
            r0 = 5
            goto L_0x00aa
        L_0x0049:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L_0x008e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L_0x0068
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L_0x0092
            goto L_0x00aa
        L_0x0068:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L_0x007e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L_0x0077
            goto L_0x00aa
        L_0x0077:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto L_0x00a9
            goto L_0x0092
        L_0x007e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
            goto L_0x00a9
        L_0x008e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x0094
        L_0x0092:
            r0 = r6
            goto L_0x00aa
        L_0x0094:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
        L_0x00a9:
            r0 = r5
        L_0x00aa:
            r3 = 0
            r2.startSettling(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.getTouchSlop())) {
            this.viewDragHelper.captureChildView(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    public void setExpandedOffset(int i10) {
        if (i10 >= 0) {
            this.expandedOffset = i10;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z10) {
        int i10;
        if (this.fitToContents != z10) {
            this.fitToContents = z10;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            if (!this.fitToContents || this.state != 6) {
                i10 = this.state;
            } else {
                i10 = 3;
            }
            setStateInternal(i10);
            updateAccessibilityActions();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z10) {
        this.gestureInsetBottomIgnored = z10;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f10;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideable(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean z10) {
        this.hideable = z10;
    }

    public void setMaxHeight(@Px int i10) {
        this.maxHeight = i10;
    }

    public void setMaxWidth(@Px int i10) {
        this.maxWidth = i10;
    }

    public void setPeekHeight(int i10) {
        setPeekHeight(i10, false);
    }

    public void setSaveFlags(int i10) {
        this.saveFlags = i10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.skipCollapsed = z10;
    }

    public void setState(int i10) {
        String str;
        int i11;
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            if (i10 == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            sb2.append(str);
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        } else if (this.hideable || i10 != 5) {
            if (i10 != 6 || !this.fitToContents || getTopOffsetForState(i10) > this.fitToContentsOffset) {
                i11 = i10;
            } else {
                i11 = 3;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                setStateInternal(i10);
                return;
            }
            View view = (View) this.viewRef.get();
            runAfterLayout(view, new a(view, i11));
        } else {
            Log.w(TAG, "Cannot set state: " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i10) {
        View view;
        if (this.state != i10) {
            this.state = i10;
            if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
                this.lastStableState = i10;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i10 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i10 == 6 || i10 == 5 || i10 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i10);
                for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
                    this.callbacks.get(i11).onStateChanged(view, i10);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z10) {
        this.updateImportantForAccessibilityOnSiblings = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long j10, @FloatRange(from = 0.0d, to = 100.0d) float f10) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(@NonNull View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f10 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    private class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f7965a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f7966b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f7967c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                boolean unused = f.this.f7966b = false;
                ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
                if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                    f fVar = f.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.state == 2) {
                        bottomSheetBehavior.setStateInternal(fVar.f7965a);
                        return;
                    }
                    return;
                }
                f fVar2 = f.this;
                fVar2.c(fVar2.f7965a);
            }
        }

        private f() {
            this.f7967c = new a();
        }

        /* access modifiers changed from: package-private */
        public void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.f7965a = i10;
                if (!this.f7966b) {
                    ViewCompat.postOnAnimation((View) BottomSheetBehavior.this.viewRef.get(), this.f7967c);
                    this.f7966b = true;
                }
            }
        }

        /* synthetic */ f(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public final void setPeekHeight(int i10, boolean z10) {
        if (i10 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            } else {
                return;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i10) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i10);
        } else {
            return;
        }
        updatePeekHeight(z10);
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(i10);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
