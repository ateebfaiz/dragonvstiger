package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<b> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f10);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f16490a;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f16490a ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f16490a = parcel.readInt() != 0;
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(View view) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelSlide(View view, float f10) {
        }
    }

    class a extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f16491a = new Rect();

        a() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f16491a;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            a(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i10);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!b(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f16493a;

        b(View view) {
            this.f16493a = view;
        }

        public void run() {
            if (this.f16493a.getParent() == SlidingPaneLayout.this) {
                this.f16493a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.invalidateChildRegion(this.f16493a);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class c extends ViewDragHelper.Callback {
        c() {
        }

        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i10, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i10, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public void onEdgeDragStarted(int i10, int i11) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i11);
        }

        public void onViewCaptured(View view, int i10) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int i10) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset == 0.0f) {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            SlidingPaneLayout.this.onPanelDragged(i10);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f10, float f11) {
            int i10;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f10 < 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                i10 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                i10 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                if (i11 > 0 || (i11 == 0 && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    i10 += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i10, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i10) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean closePane(View view, int i10) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i10)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f10, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f10 > 0.0f && i10 != 0) {
            int i11 = (((int) (((float) ((-16777216 & i10) >>> 24)) * f10)) << 24) | (i10 & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.mPostedRunnables.add(bVar);
            ViewCompat.postOnAnimation(this, bVar);
        }
    }

    private boolean openPane(View view, int i10) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i10)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parallaxOtherViews(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.isLayoutRtlSupport()
            android.view.View r1 = r9.mSlideableView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.dimWhenOffset
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = r3
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0057
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.mSlideableView
            if (r4 != r5) goto L_0x002c
            goto L_0x0054
        L_0x002c:
            float r5 = r9.mParallaxOffset
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.mParallaxBy
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.mParallaxOffset = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0042
            int r5 = -r5
        L_0x0042:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0054
            float r5 = r9.mParallaxOffset
            if (r0 == 0) goto L_0x004d
            float r5 = r5 - r6
            goto L_0x004f
        L_0x004d:
            float r5 = r6 - r5
        L_0x004f:
            int r6 = r9.mCoveredFadeColor
            r9.dimChildView(r4, r5, r6)
        L_0x0054:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.parallaxOtherViews(float):void");
    }

    private static boolean viewIsOpaque(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        int i14;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i11 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i12 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i10, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z10) {
            if (isLayoutRtlSupport()) {
                i13 = i10;
            } else {
                i13 = -i10;
            }
            if (view.canScrollHorizontally(i13)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void computeScroll() {
        if (!this.mDragHelper.continueSettling(true)) {
            return;
        }
        if (!this.mCanSlide) {
            this.mDragHelper.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i10;
        int i11;
        super.draw(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i11 = view.getRight();
                i10 = intrinsicWidth + i11;
            } else {
                int left = view.getLeft();
                int i12 = left - intrinsicWidth;
                i10 = left;
                i11 = i12;
            }
            drawable.setBounds(i11, top, i10, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    /* access modifiers changed from: package-private */
    public void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
    }

    /* access modifiers changed from: package-private */
    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRtlSupport() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        if (!this.mCanSlide || this.mSlideOffset == 1.0f) {
            return true;
        }
        return false;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mPostedRunnables.get(i10).run();
        }
        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                this.mInitialMotionX = x10;
                this.mInitialMotionY = y10;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x10, (int) y10) && isDimmed(this.mSlideableView)) {
                    z10 = true;
                    if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent) && !z10) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                float abs = Math.abs(x11 - this.mInitialMotionX);
                float abs2 = Math.abs(y11 - this.mInitialMotionY);
                if (abs > ((float) this.mDragHelper.getTouchSlop()) && abs2 > abs) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z10 = false;
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) ? true : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z11;
        float f10;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i21 = i12 - i10;
        if (isLayoutRtlSupport) {
            i14 = getPaddingRight();
        } else {
            i14 = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i15 = getPaddingLeft();
        } else {
            i15 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            if (!this.mCanSlide || !this.mPreservedOpenState) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            this.mSlideOffset = f10;
        }
        int i22 = i14;
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i24 = i21 - i15;
                    int min = (Math.min(i14, i24 - this.mOverhangSize) - i22) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.mSlideRange = min;
                    if (isLayoutRtlSupport) {
                        i20 = layoutParams.rightMargin;
                    } else {
                        i20 = layoutParams.leftMargin;
                    }
                    if (i22 + i20 + min + (measuredWidth / 2) > i24) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    layoutParams.dimWhenOffset = z11;
                    int i25 = (int) (((float) min) * this.mSlideOffset);
                    i22 += i20 + i25;
                    this.mSlideOffset = ((float) i25) / ((float) min);
                    i16 = 0;
                } else if (!this.mCanSlide || (i19 = this.mParallaxBy) == 0) {
                    i22 = i14;
                    i16 = 0;
                } else {
                    i16 = (int) ((1.0f - this.mSlideOffset) * ((float) i19));
                    i22 = i14;
                }
                if (isLayoutRtlSupport) {
                    i17 = (i21 - i22) + i16;
                    i18 = i17 - measuredWidth;
                } else {
                    i18 = i22 - i16;
                    i17 = i18 + measuredWidth;
                }
                childAt.layout(i18, paddingTop, i17, childAt.getMeasuredHeight() + paddingTop);
                i14 += childAt.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i26 = 0; i26 < childCount; i26++) {
                    dimChildView(getChildAt(i26), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z11;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                size2 = 300;
                mode2 = Integer.MIN_VALUE;
            }
        }
        boolean z12 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i13 = 0;
            } else {
                i13 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            i12 = i13;
        } else {
            i12 = (size2 - getPaddingTop()) - getPaddingBottom();
            i13 = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int i22 = 0;
        boolean z13 = false;
        int i23 = paddingLeft;
        float f10 = 0.0f;
        while (true) {
            i14 = 8;
            if (i22 >= childCount) {
                break;
            }
            View childAt = getChildAt(i22);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z12;
            } else {
                float f11 = layoutParams.weight;
                if (f11 > 0.0f) {
                    f10 += f11;
                    if (layoutParams.width == 0) {
                    }
                }
                int i24 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i25 = layoutParams.width;
                if (i25 == -2) {
                    i20 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i24, Integer.MIN_VALUE);
                } else if (i25 == -1) {
                    i20 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i24, 1073741824);
                } else {
                    i20 = View.MeasureSpec.makeMeasureSpec(i25, 1073741824);
                }
                int i26 = layoutParams.height;
                if (i26 == -2) {
                    i21 = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
                } else if (i26 == -1) {
                    i21 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    i21 = View.MeasureSpec.makeMeasureSpec(i26, 1073741824);
                }
                childAt.measure(i20, i21);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i13) {
                    i13 = Math.min(measuredHeight, i12);
                }
                i23 -= measuredWidth;
                if (i23 < 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                layoutParams.slideable = z11;
                z13 |= z11;
                if (z11) {
                    this.mSlideableView = childAt;
                }
            }
            i22++;
            z12 = false;
        }
        if (z13 || f10 > 0.0f) {
            int i27 = paddingLeft - this.mOverhangSize;
            int i28 = 0;
            while (i28 < childCount) {
                View childAt2 = getChildAt(i28);
                if (childAt2.getVisibility() != i14) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i14) {
                        if (layoutParams2.width != 0 || layoutParams2.weight <= 0.0f) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (z10) {
                            i16 = 0;
                        } else {
                            i16 = childAt2.getMeasuredWidth();
                        }
                        if (!z13 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (layoutParams2.width == 0) {
                                    int i29 = layoutParams2.height;
                                    if (i29 == -2) {
                                        i17 = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
                                    } else if (i29 == -1) {
                                        i17 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                                    } else {
                                        i17 = View.MeasureSpec.makeMeasureSpec(i29, 1073741824);
                                    }
                                } else {
                                    i17 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z13) {
                                    int i30 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i15 = i27;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i30, 1073741824);
                                    if (i16 != i30) {
                                        childAt2.measure(makeMeasureSpec, i17);
                                    }
                                    i28++;
                                    i27 = i15;
                                    i14 = 8;
                                } else {
                                    i15 = i27;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i16 + ((int) ((layoutParams2.weight * ((float) Math.max(0, i23))) / f10)), 1073741824), i17);
                                    i28++;
                                    i27 = i15;
                                    i14 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i16 > i27 || layoutParams2.weight > 0.0f)) {
                            if (z10) {
                                int i31 = layoutParams2.height;
                                if (i31 == -2) {
                                    i19 = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
                                    i18 = 1073741824;
                                } else if (i31 == -1) {
                                    i18 = 1073741824;
                                    i19 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                                } else {
                                    i18 = 1073741824;
                                    i19 = View.MeasureSpec.makeMeasureSpec(i31, 1073741824);
                                }
                            } else {
                                i18 = 1073741824;
                                i19 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i27, i18), i19);
                        }
                    }
                }
                i15 = i27;
                i28++;
                i27 = i15;
                i14 = 8;
            }
        }
        setMeasuredDimension(size, i13 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z13;
        if (this.mDragHelper.getViewDragState() != 0 && !z13) {
            this.mDragHelper.abort();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPanelDragged(int i10) {
        int i11;
        int i12;
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i10 = (getWidth() - i10) - width;
        }
        if (isLayoutRtlSupport) {
            i11 = getPaddingRight();
        } else {
            i11 = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i12 = layoutParams.rightMargin;
        } else {
            i12 = layoutParams.leftMargin;
        }
        float f10 = ((float) (i10 - (i11 + i12))) / ((float) this.mSlideRange);
        this.mSlideOffset = f10;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(f10);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f16490a) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.f16490a;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
            z10 = isOpen();
        } else {
            z10 = this.mPreservedOpenState;
        }
        savedState.f16490a = z10;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.mInitialMotionX = x10;
            this.mInitialMotionY = y10;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float f10 = x11 - this.mInitialMotionX;
            float f11 = y11 - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f10 * f10) + (f11 * f11) < ((float) (touchSlop * touchSlop)) && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x11, (int) y11)) {
                closePane(this.mSlideableView, 0);
            }
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        boolean z10;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            if (view == this.mSlideableView) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mPreservedOpenState = z10;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i10) {
        this.mCoveredFadeColor = i10;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i10) {
        this.mParallaxBy = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i10) {
        setShadowDrawable(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setSliderFadeColor(@ColorInt int i10) {
        this.mSliderFadeColor = i10;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    /* access modifiers changed from: package-private */
    public boolean smoothSlideTo(float f10, int i10) {
        int i11;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            i11 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f10 * ((float) this.mSlideRange))) + ((float) this.mSlideableView.getWidth())));
        } else {
            i11 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f10 * ((float) this.mSlideRange)));
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, i11, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void updateObscuredViewsVisibility(View view) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View childAt;
        boolean z10;
        int i16;
        int i17;
        int i18;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            i10 = getWidth() - getPaddingRight();
        } else {
            i10 = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i11 = getPaddingLeft();
        } else {
            i11 = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i15 = 0;
            i14 = 0;
            i13 = 0;
            i12 = 0;
        } else {
            i15 = view.getLeft();
            i14 = view.getRight();
            i13 = view.getTop();
            i12 = view.getBottom();
        }
        int childCount = getChildCount();
        int i19 = 0;
        while (true) {
            if (i19 < childCount && (childAt = getChildAt(i19)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z10 = isLayoutRtlSupport;
                } else {
                    if (isLayoutRtlSupport) {
                        i16 = i11;
                    } else {
                        i16 = i10;
                    }
                    int max = Math.max(i16, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z10 = isLayoutRtlSupport;
                    if (isLayoutRtlSupport) {
                        i17 = i10;
                    } else {
                        i17 = i11;
                    }
                    int min = Math.min(i17, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max < i15 || max2 < i13 || min > i14 || min2 > i12) {
                        i18 = 0;
                    } else {
                        i18 = 4;
                    }
                    childAt.setVisibility(i18);
                }
                i19++;
                view2 = view;
                isLayoutRtlSupport = z10;
            } else {
                return;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f10) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new a());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new c());
        this.mDragHelper = create;
        create.setMinVelocity(f10 * 400.0f);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }
}
