package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.a1;
import com.facebook.react.uimanager.b2;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.k0;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.p0;
import com.facebook.react.uimanager.q0;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.x;
import com.facebook.react.uimanager.x0;
import com.facebook.react.uimanager.z0;
import g7.b;
import g7.c;
import g7.d;

public class ReactViewGroup extends ViewGroup implements d, k0, q0, c, x0, p0 {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    @Nullable
    private View[] mAllChildren;
    private int mAllChildrenCount;
    private float mBackfaceOpacity;
    private String mBackfaceVisibility;
    @Nullable
    private k7.a mCSSBackgroundDrawable;
    @Nullable
    private a mChildrenLayoutChangeListener;
    @Nullable
    private Rect mClippingRect;
    @Nullable
    private b2 mDrawingOrderHelper;
    @Nullable
    private Rect mHitSlopRect;
    private boolean mNeedsOffscreenAlphaCompositing;
    @Nullable
    private b mOnInterceptTouchEventListener;
    @Nullable
    private String mOverflow;
    private final Rect mOverflowInset = new Rect();
    @Nullable
    private Path mPath;
    private h0 mPointerEvents;
    private boolean mRemoveClippedSubviews;

    private static final class a implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final ReactViewGroup f4359a;

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (this.f4359a.getRemoveClippedSubviews()) {
                this.f4359a.o(view);
            }
        }

        private a(ReactViewGroup reactViewGroup) {
            this.f4359a = reactViewGroup;
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        k();
    }

    private void d(View view, int i10) {
        View[] viewArr = (View[]) p5.a.c(this.mAllChildren);
        int i11 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i10 == i11) {
            if (length == i11) {
                View[] viewArr2 = new View[(length + 12)];
                this.mAllChildren = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.mAllChildren;
            }
            int i12 = this.mAllChildrenCount;
            this.mAllChildrenCount = i12 + 1;
            viewArr[i12] = view;
        } else if (i10 < i11) {
            if (length == i11) {
                View[] viewArr3 = new View[(length + 12)];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i10);
                System.arraycopy(viewArr, i10, this.mAllChildren, i10 + 1, i11 - i10);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i10, viewArr, i10 + 1, i11 - i10);
            }
            viewArr[i10] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i10 + " count=" + i11);
        }
    }

    private boolean e() {
        if (getId() != -1 && i7.a.a(getId()) == 2) {
            return true;
        }
        return false;
    }

    private void f(Canvas canvas) {
        boolean z10;
        float f10;
        float f11;
        float f12;
        float f13;
        Canvas canvas2 = canvas;
        String str = this.mOverflow;
        if (str != null) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1217487446:
                    if (str.equals("hidden")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (str.equals("scroll")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 466743410:
                    if (str.equals("visible")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                    float width = (float) getWidth();
                    float height = (float) getHeight();
                    k7.a aVar = this.mCSSBackgroundDrawable;
                    float f14 = 0.0f;
                    if (aVar != null) {
                        RectF j10 = aVar.j();
                        float f15 = j10.top;
                        if (f15 > 0.0f || j10.left > 0.0f || j10.bottom > 0.0f || j10.right > 0.0f) {
                            f11 = j10.left + 0.0f;
                            f12 = f15 + 0.0f;
                            width -= j10.right;
                            height -= j10.bottom;
                        } else {
                            f12 = 0.0f;
                            f11 = 0.0f;
                        }
                        m7.c i10 = this.mCSSBackgroundDrawable.i();
                        if (i10.e()) {
                            if (this.mPath == null) {
                                this.mPath = new Path();
                            }
                            this.mPath.rewind();
                            f13 = f12;
                            this.mPath.addRoundRect(new RectF(f11, f12, width, height), new float[]{Math.max(i10.c() - j10.left, 0.0f), Math.max(i10.c() - j10.top, 0.0f), Math.max(i10.d() - j10.right, 0.0f), Math.max(i10.d() - j10.top, 0.0f), Math.max(i10.b() - j10.right, 0.0f), Math.max(i10.b() - j10.bottom, 0.0f), Math.max(i10.a() - j10.left, 0.0f), Math.max(i10.a() - j10.bottom, 0.0f)}, Path.Direction.CW);
                            canvas2.clipPath(this.mPath);
                            f14 = f11;
                            z10 = true;
                            width = width;
                            height = height;
                        } else {
                            float f16 = width;
                            float f17 = height;
                            f13 = f12;
                            f14 = f11;
                            z10 = false;
                        }
                        f10 = f13;
                    } else {
                        f10 = 0.0f;
                        z10 = false;
                    }
                    if (!z10) {
                        canvas2.clipRect(new RectF(f14, f10, width, height));
                        return;
                    }
                    return;
                case 2:
                    Path path = this.mPath;
                    if (path != null) {
                        path.rewind();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void g(View view) {
        UiThreadUtil.assertOnUiThread();
        if (!e()) {
            getDrawingOrderHelper().b(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().d());
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    private b2 getDrawingOrderHelper() {
        if (this.mDrawingOrderHelper == null) {
            this.mDrawingOrderHelper = new b2(this);
        }
        return this.mDrawingOrderHelper;
    }

    private void h(View view) {
        UiThreadUtil.assertOnUiThread();
        if (e()) {
            setChildrenDrawingOrderEnabled(false);
        } else if (indexOfChild(view) != -1) {
            getDrawingOrderHelper().c(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().d());
        }
    }

    private void i(int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            if (i10 < getChildCount()) {
                h(getChildAt(i10));
            }
            i10++;
        }
    }

    private int j(View view) {
        int i10 = this.mAllChildrenCount;
        View[] viewArr = (View[]) p5.a.c(this.mAllChildren);
        for (int i11 = 0; i11 < i10; i11++) {
            if (viewArr[i11] == view) {
                return i11;
            }
        }
        return -1;
    }

    private void k() {
        setClipChildren(false);
        this.mRemoveClippedSubviews = false;
        this.mAllChildren = null;
        this.mAllChildrenCount = 0;
        this.mClippingRect = null;
        this.mHitSlopRect = null;
        this.mOverflow = null;
        this.mPointerEvents = h0.AUTO;
        this.mChildrenLayoutChangeListener = null;
        this.mCSSBackgroundDrawable = null;
        this.mOnInterceptTouchEventListener = null;
        this.mNeedsOffscreenAlphaCompositing = false;
        this.mDrawingOrderHelper = null;
        this.mPath = null;
        this.mBackfaceOpacity = 1.0f;
        this.mBackfaceVisibility = "visible";
    }

    private void l(int i10) {
        View[] viewArr = (View[]) p5.a.c(this.mAllChildren);
        int i11 = this.mAllChildrenCount;
        if (i10 == i11 - 1) {
            int i12 = i11 - 1;
            this.mAllChildrenCount = i12;
            viewArr[i12] = null;
        } else if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i10 + 1, viewArr, i10, (i11 - i10) - 1);
            int i13 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i13;
            viewArr[i13] = null;
        }
    }

    private void m(Rect rect) {
        p5.a.c(this.mAllChildren);
        int i10 = 0;
        for (int i11 = 0; i11 < this.mAllChildrenCount; i11++) {
            n(rect, i11, i10);
            if (this.mAllChildren[i11].getParent() == null) {
                i10++;
            }
        }
    }

    private void n(Rect rect, int i10, int i11) {
        boolean z10;
        UiThreadUtil.assertOnUiThread();
        View view = ((View[]) p5.a.c(this.mAllChildren))[i10];
        Rect rect2 = sHelperRect;
        rect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean intersects = rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
        Animation animation = view.getAnimation();
        if (animation == null || animation.hasEnded()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!intersects && view.getParent() != null && !z10) {
            removeViewsInLayout(i10 - i11, 1);
        } else if (intersects && view.getParent() == null) {
            addViewInLayout(view, i10 - i11, sDefaultLayoutParam, true);
            invalidate();
        } else if (!intersects) {
            return;
        }
        if (view instanceof k0) {
            k0 k0Var = (k0) view;
            if (k0Var.getRemoveClippedSubviews()) {
                k0Var.updateClippingRect();
            }
        }
    }

    /* access modifiers changed from: private */
    public void o(View view) {
        boolean z10;
        if (this.mRemoveClippedSubviews && getParent() != null) {
            p5.a.c(this.mClippingRect);
            p5.a.c(this.mAllChildren);
            Rect rect = sHelperRect;
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            boolean intersects = this.mClippingRect.intersects(rect.left, rect.top, rect.right, rect.bottom);
            if (view.getParent() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (intersects != z10) {
                int i10 = 0;
                for (int i11 = 0; i11 < this.mAllChildrenCount; i11++) {
                    View view2 = this.mAllChildren[i11];
                    if (view2 == view) {
                        n(this.mClippingRect, i11, i10);
                        return;
                    }
                    if (view2.getParent() == null) {
                        i10++;
                    }
                }
            }
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        g(view);
        super.addView(view, i10, layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        g(view);
        return super.addViewInLayout(view, i10, layoutParams, z10);
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i10) {
        addViewWithSubviewClippingEnabled(view, i10, sDefaultLayoutParam);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            f(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException | StackOverflowError e10) {
            z0 a10 = a1.a(this);
            if (a10 != null) {
                a10.handleException(e10);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new s("StackOverflowException", this, e10));
            } else {
                throw e10;
            }
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!h0.c(this.mPointerEvents)) {
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e10) {
            z2.a.k("ReactNative", "NullPointerException when executing dispatchProvideStructure", e10);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z10) {
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (view.getElevation() > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            a.a(canvas, true);
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        if (z10) {
            a.a(canvas, false);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    public int getBackgroundColor() {
        if (getBackground() == null) {
            return 0;
        }
        c.d.a(getBackground());
        throw null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public View getChildAtWithSubviewClippingEnabled(int i10) {
        if (i10 < 0 || i10 >= this.mAllChildrenCount) {
            return null;
        }
        return ((View[]) p5.a.c(this.mAllChildren))[i10];
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        UiThreadUtil.assertOnUiThread();
        if (!e()) {
            return getDrawingOrderHelper().a(i10, i11);
        }
        return i11;
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    @Nullable
    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    /* access modifiers changed from: package-private */
    public k7.a getOrCreateReactViewBackground() {
        if (this.mCSSBackgroundDrawable == null) {
            this.mCSSBackgroundDrawable = new k7.a(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable((Drawable) null);
            if (background == null) {
                updateBackgroundDrawable(this.mCSSBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mCSSBackgroundDrawable, background}));
            }
            if (!o6.a.d()) {
                this.mCSSBackgroundDrawable.y(com.facebook.react.modules.i18nmanager.a.f().i(getContext()) ? 1 : 0);
            }
        }
        return this.mCSSBackgroundDrawable;
    }

    @Nullable
    public String getOverflow() {
        return this.mOverflow;
    }

    public Rect getOverflowInset() {
        return this.mOverflowInset;
    }

    public h0 getPointerEvents() {
        return this.mPointerEvents;
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public int getZIndexMappedChildIndex(int i10) {
        UiThreadUtil.assertOnUiThread();
        if (e() || !getDrawingOrderHelper().d()) {
            return i10;
        }
        return getDrawingOrderHelper().a(getChildCount(), i10);
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar = this.mOnInterceptTouchEventListener;
        if ((bVar == null || !bVar.a(this, motionEvent)) && h0.c(this.mPointerEvents)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        a0.a(i10, i11);
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!h0.b(this.mPointerEvents)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void recycleView() {
        k();
        this.mOverflowInset.setEmpty();
        sHelperRect.setEmpty();
        removeAllViews();
        updateBackgroundDrawable((Drawable) null);
        resetPointerEvents();
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsWithSubviewClippingEnabled() {
        p5.a.a(this.mRemoveClippedSubviews);
        p5.a.c(this.mAllChildren);
        for (int i10 = 0; i10 < this.mAllChildrenCount; i10++) {
            this.mAllChildren[i10].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    public void removeView(View view) {
        h(view);
        super.removeView(view);
    }

    public void removeViewAt(int i10) {
        h(getChildAt(i10));
        super.removeViewAt(i10);
    }

    public void removeViewInLayout(View view) {
        h(view);
        super.removeViewInLayout(view);
    }

    /* access modifiers changed from: package-private */
    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        p5.a.a(this.mRemoveClippedSubviews);
        p5.a.c(this.mClippingRect);
        p5.a.c(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int j10 = j(view);
        if (this.mAllChildren[j10].getParent() != null) {
            int i10 = 0;
            for (int i11 = 0; i11 < j10; i11++) {
                if (this.mAllChildren[i11].getParent() == null) {
                    i10++;
                }
            }
            removeViewsInLayout(j10 - i10, 1);
        }
        l(j10);
    }

    public void removeViews(int i10, int i11) {
        i(i10, i11);
        super.removeViews(i10, i11);
    }

    public void removeViewsInLayout(int i10, int i11) {
        i(i10, i11);
        super.removeViewsInLayout(i10, i11);
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    /* access modifiers changed from: package-private */
    public void resetPointerEvents() {
        this.mPointerEvents = h0.AUTO;
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals("visible")) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX < -90.0f || rotationX >= 90.0f || rotationY < -90.0f || rotationY >= 90.0f) {
            setAlpha(0.0f);
        } else {
            setAlpha(this.mBackfaceOpacity);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setBackgroundColor(int i10) {
        if (i10 != 0 || this.mCSSBackgroundDrawable != null) {
            getOrCreateReactViewBackground().x(i10);
        }
    }

    public void setBorderColor(int i10, float f10, float f11) {
        getOrCreateReactViewBackground().s(i10, f10, f11);
    }

    public void setBorderRadius(float f10) {
        getOrCreateReactViewBackground().z(f10);
    }

    public void setBorderStyle(@Nullable String str) {
        getOrCreateReactViewBackground().v(str);
    }

    public void setBorderWidth(int i10, float f10) {
        getOrCreateReactViewBackground().w(i10, f10);
    }

    public void setHitSlopRect(@Nullable Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z10) {
        this.mNeedsOffscreenAlphaCompositing = z10;
    }

    public void setOnInterceptTouchEventListener(b bVar) {
        this.mOnInterceptTouchEventListener = bVar;
    }

    public void setOpacityIfPossible(float f10) {
        this.mBackfaceOpacity = f10;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public void setOverflowInset(int i10, int i11, int i12, int i13) {
        this.mOverflowInset.set(i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(h0 h0Var) {
        this.mPointerEvents = h0Var;
    }

    public void setRemoveClippedSubviews(boolean z10) {
        if (z10 != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z10;
            if (z10) {
                Rect rect = new Rect();
                this.mClippingRect = rect;
                l0.a(this, rect);
                int childCount = getChildCount();
                this.mAllChildrenCount = childCount;
                this.mAllChildren = new View[Math.max(12, childCount)];
                this.mChildrenLayoutChangeListener = new a();
                for (int i10 = 0; i10 < this.mAllChildrenCount; i10++) {
                    View childAt = getChildAt(i10);
                    this.mAllChildren[i10] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            p5.a.c(this.mClippingRect);
            p5.a.c(this.mAllChildren);
            p5.a.c(this.mChildrenLayoutChangeListener);
            for (int i11 = 0; i11 < this.mAllChildrenCount; i11++) {
                this.mAllChildren[i11].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            m(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public void setTranslucentBackgroundDrawable(@Nullable Drawable drawable) {
        updateBackgroundDrawable((Drawable) null);
        if (this.mCSSBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mCSSBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackground(drawable);
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            p5.a.c(this.mClippingRect);
            p5.a.c(this.mAllChildren);
            l0.a(this, this.mClippingRect);
            m(this.mClippingRect);
        }
    }

    public void updateDrawingOrder() {
        if (!e()) {
            getDrawingOrderHelper().e();
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().d());
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        p5.a.a(this.mRemoveClippedSubviews);
        p5.a.c(this.mClippingRect);
        p5.a.c(this.mAllChildren);
        d(view, i10);
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (this.mAllChildren[i12].getParent() == null) {
                i11++;
            }
        }
        n(this.mClippingRect, i10, i11);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    public void setBorderRadius(float f10, int i10) {
        getOrCreateReactViewBackground().A(f10, i10);
    }

    public void setBorderRadius(m7.a aVar, @Nullable x xVar) {
        getOrCreateReactViewBackground().u(aVar, xVar);
    }
}
