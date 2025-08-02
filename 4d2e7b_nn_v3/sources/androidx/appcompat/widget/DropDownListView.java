package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    f mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding = 0;
    private int mSelectionLeftPadding = 0;
    private int mSelectionRightPadding = 0;
    private int mSelectionTopPadding = 0;
    private d mSelector;
    private final Rect mSelectorRect = new Rect();

    static class a {
        @DoNotInline
        static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private static Method f14245a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f14246b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f14247c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f14248d = true;

        static {
            Class<AdapterView> cls = AdapterView.class;
            Class<AbsListView> cls2 = AbsListView.class;
            try {
                Class cls3 = Integer.TYPE;
                Class cls4 = Float.TYPE;
                Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
                f14245a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
                f14246b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
                f14247c = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        static boolean a() {
            return f14248d;
        }

        static void b(DropDownListView dropDownListView, int i10, View view) {
            try {
                f14245a.invoke(dropDownListView, new Object[]{Integer.valueOf(i10), view, Boolean.FALSE, -1, -1});
                f14246b.invoke(dropDownListView, new Object[]{Integer.valueOf(i10)});
                f14247c.invoke(dropDownListView, new Object[]{Integer.valueOf(i10)});
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    static class c {
        @DoNotInline
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        @DoNotInline
        static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    private static class d extends DrawableWrapperCompat {

        /* renamed from: a  reason: collision with root package name */
        private boolean f14249a = true;

        d(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z10) {
            this.f14249a = z10;
        }

        public void draw(Canvas canvas) {
            if (this.f14249a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f10, float f11) {
            if (this.f14249a) {
                super.setHotspot(f10, f11);
            }
        }

        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f14249a) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f14249a) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f14249a) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private static final Field f14250a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            f14250a = field;
        }

        static boolean a(AbsListView absListView) {
            Field field = f14250a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z10) {
            Field field = f14250a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z10));
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.drawableStateChanged();
        }
    }

    DropDownListView(Context context, boolean z10) {
        super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = z10;
        setCacheColorHint(0);
    }

    private void a() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.mClickAnimation = null;
        }
    }

    private void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.mSelectorRect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    private void d(int i10, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        boolean i11 = i();
        if (view.isEnabled() != i11) {
            j(!i11);
            if (i10 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void e(int i10, View view) {
        boolean z10;
        Drawable selector = getSelector();
        boolean z11 = true;
        if (selector == null || i10 == -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            selector.setVisible(false, false);
        }
        d(i10, view);
        if (z10) {
            Rect rect = this.mSelectorRect;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z11 = false;
            }
            selector.setVisible(z11, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    private void f(int i10, View view, float f10, float f11) {
        e(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            DrawableCompat.setHotspot(selector, f10, f11);
        }
    }

    private void g(View view, int i10, float f10, float f11) {
        View childAt;
        this.mDrawsInPressedState = true;
        a.a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.mMotionPosition;
        if (!(i11 == -1 || (childAt = getChildAt(i11 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i10;
        a.a(view, f10 - ((float) view.getLeft()), f11 - ((float) view.getTop()));
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        f(i10, view, f10, f11);
        h(false);
        refreshDrawableState();
    }

    private void h(boolean z10) {
        d dVar = this.mSelector;
        if (dVar != null) {
            dVar.a(z10);
        }
    }

    private boolean i() {
        if (BuildCompat.isAtLeastT()) {
            return c.a(this);
        }
        return e.a(this);
    }

    private void j(boolean z10) {
        if (BuildCompat.isAtLeastT()) {
            c.b(this, z10);
        } else {
            e.b(this, z10);
        }
    }

    private boolean k() {
        return this.mDrawsInPressedState;
    }

    private void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) {
            super.drawableStateChanged();
            h(true);
            l();
        }
    }

    public boolean hasFocus() {
        if (this.mHijackFocus || super.hasFocus()) {
            return true;
        }
        return false;
    }

    public boolean hasWindowFocus() {
        if (this.mHijackFocus || super.hasWindowFocus()) {
            return true;
        }
        return false;
    }

    public boolean isFocused() {
        if (this.mHijackFocus || super.isFocused()) {
            return true;
        }
        return false;
    }

    public boolean isInTouchMode() {
        if ((!this.mHijackFocus || !this.mListSelectionHidden) && !super.isInTouchMode()) {
            return false;
        }
        return true;
    }

    public int lookForSelectablePosition(int i10, boolean z10) {
        int i11;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z10) {
                    i11 = Math.max(0, i10);
                    while (i11 < count && !adapter.isEnabled(i11)) {
                        i11++;
                    }
                } else {
                    int min = Math.min(i10, count - 1);
                    while (i11 >= 0 && !adapter.isEnabled(i11)) {
                        min = i11 - 1;
                    }
                }
                if (i11 < 0 || i11 >= count) {
                    return -1;
                }
                return i11;
            } else if (i10 < 0 || i10 >= count) {
                return -1;
            } else {
                return i10;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i16 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        View view = null;
        while (i17 < count) {
            int itemViewType = adapter.getItemViewType(i17);
            if (itemViewType != i18) {
                view = null;
                i18 = itemViewType;
            }
            view = adapter.getView(i17, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i20 = layoutParams.height;
            if (i20 > 0) {
                i15 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
            } else {
                i15 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, i15);
            view.forceLayout();
            if (i17 > 0) {
                i16 += dividerHeight;
            }
            i16 += view.getMeasuredHeight();
            if (i16 < i13) {
                if (i14 >= 0 && i17 >= i14) {
                    i19 = i16;
                }
                i17++;
            } else if (i14 < 0 || i17 <= i14 || i19 <= 0 || i16 == i13) {
                return i13;
            } else {
                return i19;
            }
        }
        return i16;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r3 = r1
            r9 = r2
            goto L_0x0046
        L_0x0011:
            r9 = r2
            r3 = r9
            goto L_0x0046
        L_0x0014:
            r3 = r1
            goto L_0x0017
        L_0x0016:
            r3 = r2
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = r1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.g(r3, r5, r4, r9)
            if (r0 != r1) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.mScrollHelper = r9
        L_0x005a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            r9.setEnabled(r1)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.mScrollHelper
            if (r8 == 0) goto L_0x006c
            r8.setEnabled(r2)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            f fVar = new f();
            this.mResolveHoverRunnable = fVar;
            fVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !b.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, pointToPosition, childAt);
                    }
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.mResolveHoverRunnable;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z10) {
        this.mListSelectionHidden = z10;
    }

    public void setSelector(Drawable drawable) {
        d dVar;
        if (drawable != null) {
            dVar = new d(drawable);
        } else {
            dVar = null;
        }
        this.mSelector = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
