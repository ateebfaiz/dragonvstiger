package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final f mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final j mResizePopupRunnable;
    private final h mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final i mTouchInterceptor;

    class a extends ForwardingListener {
        a(View view) {
            super(view);
        }

        /* renamed from: a */
        public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            View anchorView = ListPopupWindow.this.getAnchorView();
            if (anchorView != null && anchorView.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            DropDownListView dropDownListView;
            if (i10 != -1 && (dropDownListView = ListPopupWindow.this.mDropDownList) != null) {
                dropDownListView.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class d {
        @DoNotInline
        static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    static class e {
        @DoNotInline
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @DoNotInline
        static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class g extends DataSetObserver {
        g() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class h implements AbsListView.OnScrollListener {
        h() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private class i implements View.OnTouchListener {
        i() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.mPopup) != null && popupWindow.isShowing() && x10 >= 0 && x10 < ListPopupWindow.this.mPopup.getWidth() && y10 >= 0 && y10 < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
                return false;
            }
        }
    }

    private class j implements Runnable {
        j() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.mDropDownList;
            if (dropDownListView != null && ViewCompat.isAttachedToWindow(dropDownListView) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) {
                int childCount = ListPopupWindow.this.mDropDownList.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                    listPopupWindow.mPopup.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r12 = this;
            androidx.appcompat.widget.DropDownListView r0 = r12.mDropDownList
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00be
            android.content.Context r0 = r12.mContext
            androidx.appcompat.widget.ListPopupWindow$b r5 = new androidx.appcompat.widget.ListPopupWindow$b
            r5.<init>()
            r12.mShowDropDownRunnable = r5
            boolean r5 = r12.mModal
            r5 = r5 ^ r3
            androidx.appcompat.widget.DropDownListView r5 = r12.createDropDownListView(r0, r5)
            r12.mDropDownList = r5
            android.graphics.drawable.Drawable r6 = r12.mDropDownListHighlight
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            android.widget.ListAdapter r6 = r12.mAdapter
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            android.widget.AdapterView$OnItemClickListener r6 = r12.mItemClickListener
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            r5.setFocusable(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            androidx.appcompat.widget.ListPopupWindow$c r6 = new androidx.appcompat.widget.ListPopupWindow$c
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            androidx.appcompat.widget.ListPopupWindow$h r6 = r12.mScrollListener
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.mItemSelectedListener
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.DropDownListView r6 = r12.mDropDownList
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.DropDownListView r5 = r12.mDropDownList
            android.view.View r6 = r12.mPromptView
            if (r6 == 0) goto L_0x00b7
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.mPromptPosition
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.mPromptPosition
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.mDropDownWidth
            if (r0 < 0) goto L_0x009b
            r5 = r1
            goto L_0x009d
        L_0x009b:
            r0 = r4
            r5 = r0
        L_0x009d:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b8
        L_0x00b7:
            r0 = r4
        L_0x00b8:
            android.widget.PopupWindow r6 = r12.mPopup
            r6.setContentView(r5)
            goto L_0x00dc
        L_0x00be:
            android.widget.PopupWindow r0 = r12.mPopup
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.mPromptView
            if (r0 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dc
        L_0x00db:
            r0 = r4
        L_0x00dc:
            android.widget.PopupWindow r5 = r12.mPopup
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f8
            android.graphics.Rect r6 = r12.mTempRect
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.mTempRect
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.mDropDownVerticalOffsetSet
            if (r7 != 0) goto L_0x00fe
            int r6 = -r6
            r12.mDropDownVerticalOffset = r6
            goto L_0x00fe
        L_0x00f8:
            android.graphics.Rect r5 = r12.mTempRect
            r5.setEmpty()
            r5 = r4
        L_0x00fe:
            android.widget.PopupWindow r6 = r12.mPopup
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r3 = r4
        L_0x0109:
            android.view.View r4 = r12.getAnchorView()
            int r6 = r12.mDropDownVerticalOffset
            int r3 = r12.getMaxAvailableHeight(r4, r6, r3)
            boolean r4 = r12.mDropDownAlwaysVisible
            if (r4 != 0) goto L_0x017b
            int r4 = r12.mDropDownHeight
            if (r4 != r2) goto L_0x011c
            goto L_0x017b
        L_0x011c:
            int r4 = r12.mDropDownWidth
            r6 = -2
            if (r4 == r6) goto L_0x0144
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012b
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
        L_0x0129:
            r7 = r1
            goto L_0x015d
        L_0x012b:
            android.content.Context r2 = r12.mContext
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.mTempRect
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0129
        L_0x0144:
            android.content.Context r2 = r12.mContext
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.mTempRect
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0129
        L_0x015d:
            androidx.appcompat.widget.DropDownListView r6 = r12.mDropDownList
            int r10 = r3 - r0
            r11 = -1
            r8 = 0
            r9 = -1
            int r1 = r6.measureHeightOfChildrenCompat(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0179
            androidx.appcompat.widget.DropDownListView r2 = r12.mDropDownList
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r3 = r12.mDropDownList
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0179:
            int r1 = r1 + r0
            return r1
        L_0x017b:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.buildDropDown():int");
    }

    private int getMaxAvailableHeight(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return d.a(this.mPopup, view, i10, z10);
        }
        Method method = sGetMaxAvailableHeightMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.mPopup, new Object[]{view, Integer.valueOf(i10), Boolean.valueOf(z10)})).intValue();
            } catch (Exception unused) {
                Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.mPopup.getMaxAvailableHeight(view, i10);
    }

    private static boolean isConfirmKey(int i10) {
        return i10 == 66 || i10 == 23;
    }

    private void removePromptView() {
        View view = this.mPromptView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetClipToWindowEnabledMethod;
            if (method != null) {
                try {
                    method.invoke(this.mPopup, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                    Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            e.b(this.mPopup, z10);
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new a(view);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DropDownListView createDropDownListView(Context context, boolean z10) {
        return new DropDownListView(context, z10);
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView((View) null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) {
            return new Rect(this.mEpicenterBounds);
        }
        return null;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Nullable
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int i10, @NonNull KeyEvent keyEvent) {
        int i11;
        int i12;
        if (isShowing() && i10 != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i10))) {
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            boolean z10 = !this.mPopup.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i11 = 0;
                } else {
                    i11 = this.mDropDownList.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i12 = listAdapter.getCount() - 1;
                } else {
                    i12 = this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            } else {
                i11 = Integer.MAX_VALUE;
                i12 = Integer.MIN_VALUE;
            }
            if ((!z10 || i10 != 19 || selectedItemPosition > i11) && (z10 || i10 != 20 || selectedItemPosition < i12)) {
                this.mDropDownList.setListSelectionHidden(false);
                if (this.mDropDownList.onKeyDown(i10, keyEvent)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    if (i10 == 19 || i10 == 20 || i10 == 23 || i10 == 66) {
                        return true;
                    }
                } else if (!z10 || i10 != 20) {
                    if (!z10 && i10 == 19 && selectedItemPosition == i11) {
                        return true;
                    }
                    return false;
                } else if (selectedItemPosition == i12) {
                    return true;
                }
            } else {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i10, @NonNull KeyEvent keyEvent) {
        if (i10 != 4 || !isShowing()) {
            return false;
        }
        View view = this.mDropDownAnchorView;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        } else if (keyEvent.getAction() != 1) {
            return false;
        } else {
            KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.handleUpEvent(keyEvent);
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            dismiss();
            return true;
        }
    }

    public boolean onKeyUp(int i10, @NonNull KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.mDropDownList.onKeyUp(i10, keyEvent);
        if (onKeyUp && isConfirmKey(i10)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i10) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener == null) {
            return true;
        }
        DropDownListView dropDownListView = this.mDropDownList;
        int i11 = i10;
        this.mItemClickListener.onItemClick(dropDownListView, dropDownListView.getChildAt(i10 - dropDownListView.getFirstVisiblePosition()), i11, dropDownListView.getAdapter().getItemId(i10));
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new g();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(@StyleRes int i10) {
        this.mPopup.setAnimationStyle(i10);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i10) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            this.mDropDownWidth = rect.left + rect.right + i10;
            return;
        }
        setWidth(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z10) {
        this.mDropDownAlwaysVisible = z10;
    }

    public void setDropDownGravity(int i10) {
        this.mDropDownGravity = i10;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.mEpicenterBounds = rect2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z10) {
        this.mForceIgnoreOutsideTouch = z10;
    }

    public void setHeight(int i10) {
        if (i10 >= 0 || -2 == i10 || -1 == i10) {
            this.mDropDownHeight = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int i10) {
        this.mDropDownHorizontalOffset = i10;
    }

    public void setInputMethodMode(int i10) {
        this.mPopup.setInputMethodMode(i10);
    }

    /* access modifiers changed from: package-private */
    public void setListItemExpandMax(int i10) {
        this.mListItemExpandMaximum = i10;
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z10) {
        this.mModal = z10;
        this.mPopup.setFocusable(z10);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z10) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z10;
    }

    public void setPromptPosition(int i10) {
        this.mPromptPosition = i10;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i10) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i10);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i10, true);
            }
        }
    }

    public void setSoftInputMode(int i10) {
        this.mPopup.setSoftInputMode(i10);
    }

    public void setVerticalOffset(int i10) {
        this.mDropDownVerticalOffset = i10;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i10) {
        this.mDropDownWidth = i10;
    }

    public void setWindowLayoutType(int i10) {
        this.mDropDownWindowLayoutType = i10;
    }

    public void show() {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean z11 = true;
        if (!this.mPopup.isShowing()) {
            int i14 = this.mDropDownWidth;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = getAnchorView().getWidth();
            }
            int i15 = this.mDropDownHeight;
            if (i15 == -1) {
                buildDropDown = -1;
            } else if (i15 != -2) {
                buildDropDown = i15;
            }
            this.mPopup.setWidth(i14);
            this.mPopup.setHeight(buildDropDown);
            setPopupClipToScreenEnabled(true);
            PopupWindow popupWindow = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z10 = false;
            } else {
                z10 = true;
            }
            popupWindow.setOutsideTouchable(z10);
            this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = sSetEpicenterBoundsMethod;
                if (method != null) {
                    try {
                        method.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});
                    } catch (Exception e10) {
                        Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e10);
                    }
                }
            } else {
                e.a(this.mPopup, this.mEpicenterBounds);
            }
            PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post(this.mHideSelector);
            }
        } else if (ViewCompat.isAttachedToWindow(getAnchorView())) {
            int i16 = this.mDropDownWidth;
            if (i16 == -1) {
                i16 = -1;
            } else if (i16 == -2) {
                i16 = getAnchorView().getWidth();
            }
            int i17 = this.mDropDownHeight;
            if (i17 == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow2 = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow2.setWidth(i13);
                    this.mPopup.setHeight(0);
                } else {
                    PopupWindow popupWindow3 = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i12 = -1;
                    } else {
                        i12 = 0;
                    }
                    popupWindow3.setWidth(i12);
                    this.mPopup.setHeight(-1);
                }
            } else if (i17 != -2) {
                buildDropDown = i17;
            }
            PopupWindow popupWindow4 = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z11 = false;
            }
            popupWindow4.setOutsideTouchable(z11);
            PopupWindow popupWindow5 = this.mPopup;
            View anchorView = getAnchorView();
            int i18 = this.mDropDownHorizontalOffset;
            int i19 = this.mDropDownVerticalOffset;
            if (i16 < 0) {
                i10 = -1;
            } else {
                i10 = i16;
            }
            if (buildDropDown < 0) {
                i11 = -1;
            } else {
                i11 = buildDropDown;
            }
            popupWindow5.update(anchorView, i18, i19, i10, i11);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new j();
        this.mTouchInterceptor = new i();
        this.mScrollListener = new h();
        this.mHideSelector = new f();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i10, i11);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i10, i11);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
