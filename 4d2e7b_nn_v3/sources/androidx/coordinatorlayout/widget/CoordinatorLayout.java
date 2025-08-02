package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.alibaba.pdns.f;
import io.jsonwebtoken.JwtParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = {Context.class, AttributeSet.class};
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = new d();
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal<>();
    private static final Pools.Pool<Rect> sRectPool = new Pools.SynchronizedPool(12);
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private c mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mBehaviorTag;
        }

        public static void setTag(@NonNull View view, @Nullable Object obj) {
            ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            if (getScrimOpacity(coordinatorLayout, v10) > 0.0f) {
                return true;
            }
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Rect rect, boolean z10) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
            if (i12 == 0) {
                onNestedPreScroll(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
            if (i11 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
            if (i11 == 0) {
                return onStartNestedScroll(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10) {
            if (i10 == 0) {
                onStopNestedScroll(coordinatorLayout, v10, view);
            }
        }

        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
        }
    }

    private class b implements ViewGroup.OnHierarchyChangeListener {
        b() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static class d implements Comparator {
        d() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float z10 = ViewCompat.getZ(view);
            float z11 = ViewCompat.getZ(view2);
            if (z10 > z11) {
                return -1;
            }
            if (z10 < z11) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            WIDGET_PACKAGE_NAME = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$d
            r0.<init>()
            TOP_SORTED_CHILDREN_COMPARATOR = r0
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            java.lang.Class<android.util.AttributeSet> r1 = android.util.AttributeSet.class
            r2 = 1
            r0[r2] = r1
            CONSTRUCTOR_PARAMS = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            sConstructors = r0
            androidx.core.util.Pools$SynchronizedPool r0 = new androidx.core.util.Pools$SynchronizedPool
            r1 = 12
            r0.<init>(r1)
            sRectPool = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect acquire = sRectPool.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private void cancelInterceptBehaviors() {
        int childCount = getChildCount();
        MotionEvent motionEvent = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (behavior != null) {
                if (motionEvent == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                behavior.onInterceptTouchEvent(this, childAt, motionEvent);
            }
        }
        if (motionEvent != null) {
            motionEvent.recycle();
        }
    }

    private static int clamp(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - layoutParams.bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        Behavior behavior;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (ViewCompat.getFitsSystemWindows(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) != null) {
                windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(int i10, Rect rect, Rect rect2, LayoutParams layoutParams, int i11, int i12) {
        int i13;
        int i14;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i10);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i10);
        int i15 = absoluteGravity & 7;
        int i16 = absoluteGravity & 112;
        int i17 = absoluteGravity2 & 7;
        int i18 = absoluteGravity2 & 112;
        if (i17 == 1) {
            i13 = rect.left + (rect.width() / 2);
        } else if (i17 != 5) {
            i13 = rect.left;
        } else {
            i13 = rect.right;
        }
        if (i18 == 16) {
            i14 = rect.top + (rect.height() / 2);
        } else if (i18 != 80) {
            i14 = rect.top;
        } else {
            i14 = rect.bottom;
        }
        if (i15 == 1) {
            i13 -= i11 / 2;
        } else if (i15 != 5) {
            i13 -= i11;
        }
        if (i16 == 16) {
            i14 -= i12 / 2;
        } else if (i16 != 80) {
            i14 -= i12;
        }
        rect2.set(i13, i14, i11 + i13, i12 + i14);
    }

    private int getKeyline(int i10) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        } else if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        } else {
            Log.e(TAG, "Keyline index " + i10 + " out of range for " + this);
            return 0;
        }
    }

    private void getTopSortedChildren(List<View> list) {
        int i10;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            if (isChildrenDrawingOrderEnabled) {
                i10 = getChildDrawingOrder(childCount, i11);
            } else {
                i10 = i11;
            }
            list.add(getChildAt(i10));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    private void layoutChild(View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i10);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i10) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i10, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i10, int i11) {
        int i12;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i11);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int keyline = getKeyline(i10) - measuredWidth;
        if (i13 == 1) {
            keyline += measuredWidth / 2;
        } else if (i13 == 5) {
            keyline += measuredWidth;
        }
        if (i14 == 16) {
            i12 = measuredHeight / 2;
        } else if (i14 != 80) {
            i12 = 0;
        } else {
            i12 = measuredHeight;
        }
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i12, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private MotionEvent obtainCancelEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        return obtain;
    }

    private void offsetChildByInset(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                acquireTempRect.set(acquireTempRect2);
            } else if (!acquireTempRect2.contains(acquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i10);
            boolean z12 = true;
            if ((absoluteGravity & 48) != 48 || (i15 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.mInsetOffsetY) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                setInsetOffsetY(view, i16 - i15);
                z10 = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY) < (i14 = rect.bottom)) {
                setInsetOffsetY(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                setInsetOffsetY(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i12 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                setInsetOffsetX(view, i13 - i12);
                z11 = true;
            }
            if ((absoluteGravity & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX) >= (i11 = rect.right)) {
                z12 = z11;
            } else {
                setInsetOffsetX(view, width - i11);
            }
            if (!z12) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(f.G)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = WIDGET_PACKAGE_NAME;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + JwtParser.SEPARATOR_CHAR + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = sConstructors;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    private boolean performEvent(Behavior behavior, View view, MotionEvent motionEvent, int i10) {
        if (i10 == 0) {
            return behavior.onInterceptTouchEvent(this, view, motionEvent);
        }
        if (i10 == 1) {
            return behavior.onTouchEvent(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r6 = performEvent(r10, r8, r14, r15);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performIntercept(android.view.MotionEvent r14, int r15) {
        /*
            r13 = this;
            int r0 = r14.getActionMasked()
            java.util.List<android.view.View> r1 = r13.mTempList1
            r13.getTopSortedChildren(r1)
            int r2 = r1.size()
            r3 = 0
            r4 = 0
            r5 = r3
            r6 = r5
            r7 = r6
        L_0x0012:
            if (r5 >= r2) goto L_0x0082
            java.lang.Object r8 = r1.get(r5)
            android.view.View r8 = (android.view.View) r8
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r9
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r10 = r9.getBehavior()
            if (r6 != 0) goto L_0x0028
            if (r7 == 0) goto L_0x0036
        L_0x0028:
            if (r0 == 0) goto L_0x0036
            if (r10 == 0) goto L_0x007f
            if (r4 != 0) goto L_0x0032
            android.view.MotionEvent r4 = r13.obtainCancelEvent(r14)
        L_0x0032:
            r13.performEvent(r10, r8, r4, r15)
            goto L_0x007f
        L_0x0036:
            r11 = 1
            if (r7 != 0) goto L_0x006b
            if (r6 != 0) goto L_0x006b
            if (r10 == 0) goto L_0x006b
            boolean r6 = r13.performEvent(r10, r8, r14, r15)
            if (r6 == 0) goto L_0x006b
            r13.mBehaviorTouchView = r8
            r7 = 3
            if (r0 == r7) goto L_0x006b
            if (r0 == r11) goto L_0x006b
            r7 = r3
        L_0x004b:
            if (r7 >= r5) goto L_0x006b
            java.lang.Object r10 = r1.get(r7)
            android.view.View r10 = (android.view.View) r10
            android.view.ViewGroup$LayoutParams r12 = r10.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r12 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r12
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r12 = r12.getBehavior()
            if (r12 == 0) goto L_0x0068
            if (r4 != 0) goto L_0x0065
            android.view.MotionEvent r4 = r13.obtainCancelEvent(r14)
        L_0x0065:
            r13.performEvent(r12, r10, r4, r15)
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x004b
        L_0x006b:
            boolean r7 = r9.didBlockInteraction()
            boolean r8 = r9.isBlockingInteractionBelow(r13, r8)
            if (r8 == 0) goto L_0x0079
            if (r7 != 0) goto L_0x0079
            r7 = r11
            goto L_0x007a
        L_0x0079:
            r7 = r3
        L_0x007a:
            if (r8 == 0) goto L_0x007f
            if (r7 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            int r5 = r5 + 1
            goto L_0x0012
        L_0x0082:
            r1.clear()
            if (r4 == 0) goto L_0x008a
            r4.recycle()
        L_0x008a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.performIntercept(android.view.MotionEvent, int):boolean");
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    private void resetTouchBehaviors() {
        View view = this.mBehaviorTouchView;
        if (view != null) {
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.onTouchEvent(this, this.mBehaviorTouchView, obtain);
                obtain.recycle();
            }
            this.mBehaviorTouchView = null;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ((LayoutParams) getChildAt(i10).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    private static int resolveGravity(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= GravityCompat.START;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    private static int resolveKeylineGravity(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    private void setInsetOffsetX(View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i11 = layoutParams.mInsetOffsetX;
        if (i11 != i10) {
            ViewCompat.offsetLeftAndRight(view, i10 - i11);
            layoutParams.mInsetOffsetX = i10;
        }
    }

    private void setInsetOffsetY(View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i11 = layoutParams.mInsetOffsetY;
        if (i11 != i10) {
            ViewCompat.offsetTopAndBottom(view, i10 - i11);
            layoutParams.mInsetOffsetY = i10;
        }
    }

    private void setupForInsets() {
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new a();
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener) null);
    }

    /* access modifiers changed from: package-private */
    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new c();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        ArrayList<View> incomingEdgesInternal = this.mChildDag.getIncomingEdgesInternal(view);
        if (incomingEdgesInternal != null && !incomingEdgesInternal.isEmpty()) {
            for (int i10 = 0; i10 < incomingEdgesInternal.size(); i10++) {
                View view2 = incomingEdgesInternal.get(i10);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        if (view.getParent() != this) {
            z10 = true;
        } else {
            z10 = false;
        }
        getChildRect(view, z10, acquireTempRect);
        Rect acquireTempRect2 = acquireTempRect();
        if (view2.getParent() != this) {
            z11 = true;
        } else {
            z11 = false;
        }
        getChildRect(view2, z11, acquireTempRect2);
        try {
            if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left && acquireTempRect.bottom >= acquireTempRect2.top) {
                z12 = true;
            }
            return z12;
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.mBehavior;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || !drawable.isStateful()) {
            z10 = false;
        } else {
            z10 = drawable.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i10))) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10 == this.mNeedsPreDrawListener) {
            return;
        }
        if (z10) {
            addPreDrawListener();
        } else {
            removePreDrawListener();
        }
    }

    /* access modifiers changed from: package-private */
    public void getChildRect(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        List<View> outgoingEdges = this.mChildDag.getOutgoingEdges(view);
        if (outgoingEdges == null) {
            return Collections.emptyList();
        }
        return outgoingEdges;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        List<View> incomingEdges = this.mChildDag.getIncomingEdges(view);
        if (incomingEdges == null) {
            return Collections.emptyList();
        }
        return incomingEdges;
    }

    /* access modifiers changed from: package-private */
    public void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void getDesiredAnchoredChildRect(View view, int i10, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(i10, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: package-private */
    public void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    /* access modifiers changed from: package-private */
    public LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                layoutParams.setBehavior(behavior);
                layoutParams.mBehaviorResolved = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.setBehavior((Behavior) defaultBehavior.value().getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
                    } catch (Exception e10) {
                        Log.e(TAG, "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
        }
        return layoutParams;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(@NonNull View view, int i10, int i11) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i10, i11);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetChildToAnchor(View view, int i10) {
        Behavior behavior;
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            boolean z10 = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(i10, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z10 = true;
            }
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
            int i11 = acquireTempRect3.left - acquireTempRect2.left;
            int i12 = acquireTempRect3.top - acquireTempRect2.top;
            if (i11 != 0) {
                ViewCompat.offsetLeftAndRight(view2, i11);
            }
            if (i12 != 0) {
                ViewCompat.offsetTopAndBottom(view2, i12);
            }
            if (z10 && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onDependentViewChanged(this, view2, layoutParams.mAnchorView);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new c();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    /* access modifiers changed from: package-private */
    public final void onChildViewsChanged(int i10) {
        boolean z10;
        int i11 = i10;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.mDependencySortedChildren.get(i12);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i11 != 0 || view.getVisibility() != 8) {
                for (int i13 = 0; i13 < i12; i13++) {
                    if (layoutParams.mAnchorDirectChild == this.mDependencySortedChildren.get(i13)) {
                        offsetChildToAnchor(view, layoutDirection);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (layoutParams.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    int i14 = absoluteGravity & 112;
                    if (i14 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i14 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i15 = absoluteGravity & 7;
                    if (i15 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i15 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, layoutDirection);
                }
                if (i11 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i16 = i12 + 1; i16 < size; i16++) {
                    View view2 = this.mDependencySortedChildren.get(i16);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (i11 != 0 || !layoutParams2.getChangedAfterNestedScroll()) {
                            if (i11 != 2) {
                                z10 = behavior.onDependentViewChanged(this, view2, view);
                            } else {
                                behavior.onDependentViewRemoved(this, view2, view);
                                z10 = true;
                            }
                            if (i11 == 1) {
                                layoutParams2.setChangedAfterNestedScroll(z10);
                            }
                        } else {
                            layoutParams2.resetChangedAfterNestedScroll();
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                i10 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i10);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors();
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            this.mBehaviorTouchView = null;
            resetTouchBehaviors();
        }
        return performIntercept;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Behavior behavior;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.mDependencySortedChildren.get(i14);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i10) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.checkAnchorChanged()) {
            View view2 = layoutParams.mAnchorView;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i10);
                return;
            }
            int i11 = layoutParams.keyline;
            if (i11 >= 0) {
                layoutChildWithKeyline(view, i11, i10);
            } else {
                layoutChild(view, i10);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.prepareChildren()
            r30.ensurePreDrawListener()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.ViewCompat.getLayoutDirection(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = r2
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r3 = r7.mLastInsets
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.ViewCompat.getFitsSystemWindows(r30)
            if (r3 == 0) goto L_0x004b
            r19 = r2
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.mDependencySortedChildren
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x0171
            java.util.List<android.view.View> r0 = r7.mDependencySortedChildren
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0169
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            int r0 = r1.keyline
            if (r0 < 0) goto L_0x00bc
            if (r13 == 0) goto L_0x00bc
            int r0 = r7.getKeyline(r0)
            int r11 = r1.gravity
            int r11 = resolveKeylineGravity(r11)
            int r11 = androidx.core.view.GravityCompat.getAbsoluteGravity(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r11 = r0
            r21 = r2
            goto L_0x00c1
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00ba
            if (r12 == 0) goto L_0x00ba
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00c1
        L_0x00ba:
            r11 = 0
            goto L_0x00bf
        L_0x00bc:
            r22 = r2
            goto L_0x00ba
        L_0x00bf:
            r21 = r11
        L_0x00c1:
            if (r19 == 0) goto L_0x00f3
            boolean r0 = androidx.core.view.ViewCompat.getFitsSystemWindows(r20)
            if (r0 != 0) goto L_0x00f3
            androidx.core.view.WindowInsetsCompat r0 = r7.mLastInsets
            int r0 = r0.getSystemWindowInsetLeft()
            androidx.core.view.WindowInsetsCompat r2 = r7.mLastInsets
            int r2 = r2.getSystemWindowInsetRight()
            int r0 = r0 + r2
            androidx.core.view.WindowInsetsCompat r2 = r7.mLastInsets
            int r2 = r2.getSystemWindowInsetTop()
            androidx.core.view.WindowInsetsCompat r11 = r7.mLastInsets
            int r11 = r11.getSystemWindowInsetBottom()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f7
        L_0x00f3:
            r11 = r31
            r23 = r32
        L_0x00f7:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.getBehavior()
            if (r0 == 0) goto L_0x011f
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0139
            goto L_0x012c
        L_0x011f:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012c:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.onMeasureChild(r1, r2, r3, r4, r5)
        L_0x0139:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0169:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x0171:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z11 |= behavior.onNestedFling(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (z11) {
            onChildViewsChanged(1);
        }
        return z11;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                    z10 |= behavior.onNestedPreFling(this, childAt, view, f10, f11);
                }
            }
        }
        return z10;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
            if (!(id2 == -1 || behavior == null || (parcelable2 = sparseArray.get(id2)) == null)) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (!(id2 == -1 || behavior == null || (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id2, onSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.mBehaviorTouchView;
        boolean z11 = false;
        if (view != null) {
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
            z10 = behavior != null ? behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent) : false;
        } else {
            z10 = performIntercept(motionEvent, 1);
            if (actionMasked != 0 && z10) {
                z11 = true;
            }
        }
        if (this.mBehaviorTouchView == null || actionMasked == 3) {
            z10 |= super.onTouchEvent(motionEvent);
        } else if (z11) {
            MotionEvent obtainCancelEvent = obtainCancelEvent(motionEvent);
            super.onTouchEvent(obtainCancelEvent);
            obtainCancelEvent.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mBehaviorTouchView = null;
            resetTouchBehaviors();
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
    }

    /* access modifiers changed from: package-private */
    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.mDisallowInterceptReset) {
            if (this.mBehaviorTouchView == null) {
                cancelInterceptBehaviors();
            }
            resetTouchBehaviors();
            this.mDisallowInterceptReset = true;
        }
    }

    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i10);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z10) {
            this.mStatusBarBackground.setVisible(z10, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        boolean z10;
        if (ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z11 = false;
        if (windowInsetsCompat == null || windowInsetsCompat.getSystemWindowInsetTop() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.mDrawStatusBarBackground = z10;
        if (!z10 && getBackground() == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground) {
            return true;
        }
        return false;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                int i16 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i12) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i10, i11, iArr2, i12);
                    if (i10 > 0) {
                        min = Math.max(i13, this.mBehaviorConsumed[0]);
                    } else {
                        min = Math.min(i13, this.mBehaviorConsumed[0]);
                    }
                    i13 = min;
                    if (i11 > 0) {
                        min2 = Math.max(i14, this.mBehaviorConsumed[1]);
                    } else {
                        min2 = Math.min(i14, this.mBehaviorConsumed[1]);
                    }
                    i14 = min2;
                    z10 = true;
                }
            }
        }
        iArr[0] = i13;
        iArr[1] = i14;
        if (z10) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        Behavior behavior;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i10, i11);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i11) && (behavior = layoutParams.getBehavior()) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i10, i11);
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        int i12 = i11;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i10, i11);
                    z10 |= onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i12, onStartNestedScroll);
                } else {
                    layoutParams.setNestedScrollAccepted(i12, false);
                }
            }
        }
        return z10;
    }

    public void onStopNestedScroll(View view, int i10) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i10)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i10);
                }
                layoutParams.resetNestedScroll(i10);
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArray;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        if (i10 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i10, 0);
        }
        if (i10 == 0) {
            ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.CoordinatorLayout, attributeSet, typedArray, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.CoordinatorLayout, attributeSet, typedArray, i10, 0);
        }
        int resourceId = typedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i11 = 0; i11 < length; i11++) {
                int[] iArr = this.mKeylines;
                iArr[i11] = (int) (((float) iArr[i11]) * f10);
            }
        }
        this.mStatusBarBackground = typedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new b());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        Behavior behavior;
        int min;
        boolean z10;
        int min2;
        int childCount = getChildCount();
        boolean z11 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i14) && (behavior = layoutParams.getBehavior()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    if (i12 > 0) {
                        min = Math.max(i15, this.mBehaviorConsumed[0]);
                    } else {
                        min = Math.min(i15, this.mBehaviorConsumed[0]);
                    }
                    i15 = min;
                    if (i13 > 0) {
                        z10 = true;
                        min2 = Math.max(i16, this.mBehaviorConsumed[1]);
                    } else {
                        z10 = true;
                        min2 = Math.min(i16, this.mBehaviorConsumed[1]);
                    }
                    i16 = min2;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + i15;
        iArr[1] = iArr[1] + i16;
        if (z11) {
            onChildViewsChanged(1);
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray<Parcelable> behaviorStates;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                this.behaviorStates.append(iArr[i10], readParcelableArray[i10]);
            }
        }

        public void writeToParcel(Parcel parcel, int i10) {
            int i11;
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i11 = sparseArray.size();
            } else {
                i11 = 0;
            }
            parcel.writeInt(i11);
            int[] iArr = new int[i11];
            Parcelable[] parcelableArr = new Parcelable[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = this.behaviorStates.keyAt(i12);
                parcelableArr[i12] = this.behaviorStates.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int anchorGravity = 0;
        public int dodgeInsetEdges = 0;
        public int gravity = 0;
        public int insetEdge = 0;
        public int keyline = -1;
        View mAnchorDirectChild;
        int mAnchorId = -1;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved = false;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect = new Rect();

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.mAnchorId);
            this.mAnchorView = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.mAnchorDirectChild = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
            }
        }

        private boolean shouldDodge(View view, int i10) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i10);
            if (absoluteGravity == 0 || (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i10) & absoluteGravity) != absoluteGravity) {
                return false;
            }
            return true;
        }

        private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view2 = this.mAnchorView;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.mAnchorDirectChild = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean checkAnchorChanged() {
            if (this.mAnchorView != null || this.mAnchorId == -1) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            if (view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((behavior = this.mBehavior) != null && behavior.layoutDependsOn(coordinatorLayout, view, view2))) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        /* access modifiers changed from: package-private */
        public View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
                resolveAnchorView(view, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        /* access modifiers changed from: package-private */
        public boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        /* access modifiers changed from: package-private */
        public Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        /* access modifiers changed from: package-private */
        public void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        /* access modifiers changed from: package-private */
        public boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10;
            boolean z11 = this.mDidBlockInteraction;
            if (z11) {
                return true;
            }
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                z10 = behavior.blocksInteractionBelow(coordinatorLayout, view);
            } else {
                z10 = false;
            }
            boolean z12 = z10 | z11;
            this.mDidBlockInteraction = z12;
            return z12;
        }

        /* access modifiers changed from: package-private */
        public boolean isNestedScrollAccepted(int i10) {
            if (i10 == 0) {
                return this.mDidAcceptNestedScrollTouch;
            }
            if (i10 != 1) {
                return false;
            }
            return this.mDidAcceptNestedScrollNonTouch;
        }

        /* access modifiers changed from: package-private */
        public void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        /* access modifiers changed from: package-private */
        public void resetNestedScroll(int i10) {
            setNestedScrollAccepted(i10, false);
        }

        /* access modifiers changed from: package-private */
        public void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        public void setAnchorId(@IdRes int i10) {
            invalidateAnchor();
            this.mAnchorId = i10;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setChangedAfterNestedScroll(boolean z10) {
            this.mDidChangeAfterNestedScroll = z10;
        }

        /* access modifiers changed from: package-private */
        public void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void setNestedScrollAccepted(int i10, boolean z10) {
            if (i10 == 0) {
                this.mDidAcceptNestedScrollTouch = z10;
            } else if (i10 == 1) {
                this.mDidAcceptNestedScrollNonTouch = z10;
            }
        }

        LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
