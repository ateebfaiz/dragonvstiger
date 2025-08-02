package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private c mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    }

    static class b {
        @DoNotInline
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, R.attr.popupMenuStyle, 0);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.appcompat.view.menu.MenuPresenter, androidx.appcompat.view.menu.c] */
    /* JADX WARNING: type inference failed for: r8v1, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: type inference failed for: r2v2, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.c createPopup() {
        /*
            r15 = this;
            android.content.Context r0 = r15.mContext
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            androidx.appcompat.view.menu.MenuPopupHelper.b.a(r0, r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r15.mContext
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R.dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x003d
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r3 = r15.mContext
            android.view.View r4 = r15.mAnchorView
            int r5 = r15.mPopupStyleAttr
            int r6 = r15.mPopupStyleRes
            boolean r7 = r15.mOverflowOnly
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x004f
        L_0x003d:
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r9 = r15.mContext
            androidx.appcompat.view.menu.MenuBuilder r10 = r15.mMenu
            android.view.View r11 = r15.mAnchorView
            int r12 = r15.mPopupStyleAttr
            int r13 = r15.mPopupStyleRes
            boolean r14 = r15.mOverflowOnly
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
        L_0x004f:
            androidx.appcompat.view.menu.MenuBuilder r1 = r15.mMenu
            r0.a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r15.mInternalOnDismissListener
            r0.j(r1)
            android.view.View r1 = r15.mAnchorView
            r0.e(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r15.mPresenterCallback
            r0.setCallback(r1)
            boolean r1 = r15.mForceShowIcon
            r0.g(r1)
            int r1 = r15.mDropDownGravity
            r0.h(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.createPopup():androidx.appcompat.view.menu.c");
    }

    private void showPopup(int i10, int i11, boolean z10, boolean z11) {
        c popup = getPopup();
        popup.k(z11);
        if (z10) {
            if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i10 -= this.mAnchorView.getWidth();
            }
            popup.i(i10);
            popup.l(i11);
            int i12 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.f(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public c getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        c cVar = this.mPopup;
        if (cVar == null || !cVar.isShowing()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@NonNull View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z10) {
        this.mForceShowIcon = z10;
        c cVar = this.mPopup;
        if (cVar != null) {
            cVar.g(z10);
        }
    }

    public void setGravity(int i10) {
        this.mDropDownGravity = i10;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        c cVar = this.mPopup;
        if (cVar != null) {
            cVar.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z10, @AttrRes int i10) {
        this(context, menuBuilder, view, z10, i10, 0);
    }

    public void show(int i10, int i11) {
        if (!tryShow(i10, i11)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z10, @AttrRes int i10, @StyleRes int i11) {
        this.mDropDownGravity = GravityCompat.START;
        this.mInternalOnDismissListener = new a();
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z10;
        this.mPopupStyleAttr = i10;
        this.mPopupStyleRes = i11;
    }

    public boolean tryShow(int i10, int i11) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i10, i11, true, true);
        return true;
    }
}
