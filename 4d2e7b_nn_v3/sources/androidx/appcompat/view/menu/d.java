package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class d extends c implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    private static final int T0 = R.layout.abc_popup_menu_item_layout;
    private PopupWindow.OnDismissListener C;
    ViewTreeObserver N0;
    private boolean O0;
    private boolean P0;
    private int Q0;
    private int R0 = 0;
    private boolean S0;
    private View X;
    View Y;
    private MenuPresenter.Callback Z;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14106b;

    /* renamed from: c  reason: collision with root package name */
    private final MenuBuilder f14107c;

    /* renamed from: d  reason: collision with root package name */
    private final MenuAdapter f14108d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14109e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14110f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14111g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14112h;

    /* renamed from: i  reason: collision with root package name */
    final MenuPopupWindow f14113i;

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f14114j = new a();

    /* renamed from: w  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f14115w = new b();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (d.this.isShowing() && !d.this.f14113i.isModal()) {
                View view = d.this.Y;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                } else {
                    d.this.f14113i.show();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.N0;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.N0 = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.N0.removeGlobalOnLayoutListener(dVar.f14114j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public d(Context context, MenuBuilder menuBuilder, View view, int i10, int i11, boolean z10) {
        this.f14106b = context;
        this.f14107c = menuBuilder;
        this.f14109e = z10;
        this.f14108d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z10, T0);
        this.f14111g = i10;
        this.f14112h = i11;
        Resources resources = context.getResources();
        this.f14110f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.X = view;
        this.f14113i = new MenuPopupWindow(context, (AttributeSet) null, i10, i11);
        menuBuilder.addMenuPresenter(this, context);
    }

    private boolean o() {
        View view;
        boolean z10;
        if (isShowing()) {
            return true;
        }
        if (this.O0 || (view = this.X) == null) {
            return false;
        }
        this.Y = view;
        this.f14113i.setOnDismissListener(this);
        this.f14113i.setOnItemClickListener(this);
        this.f14113i.setModal(true);
        View view2 = this.Y;
        if (this.N0 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.N0 = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f14114j);
        }
        view2.addOnAttachStateChangeListener(this.f14115w);
        this.f14113i.setAnchorView(view2);
        this.f14113i.setDropDownGravity(this.R0);
        if (!this.P0) {
            this.Q0 = c.d(this.f14108d, (ViewGroup) null, this.f14106b, this.f14110f);
            this.P0 = true;
        }
        this.f14113i.setContentWidth(this.Q0);
        this.f14113i.setInputMethodMode(2);
        this.f14113i.setEpicenterBounds(c());
        this.f14113i.show();
        ListView listView = this.f14113i.getListView();
        listView.setOnKeyListener(this);
        if (this.S0 && this.f14107c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f14106b).inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f14107c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f14113i.setAdapter(this.f14108d);
        this.f14113i.show();
        return true;
    }

    public void a(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f14113i.dismiss();
        }
    }

    public void e(View view) {
        this.X = view;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z10) {
        this.f14108d.setForceShowIcon(z10);
    }

    public ListView getListView() {
        return this.f14113i.getListView();
    }

    public void h(int i10) {
        this.R0 = i10;
    }

    public void i(int i10) {
        this.f14113i.setHorizontalOffset(i10);
    }

    public boolean isShowing() {
        if (this.O0 || !this.f14113i.isShowing()) {
            return false;
        }
        return true;
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.C = onDismissListener;
    }

    public void k(boolean z10) {
        this.S0 = z10;
    }

    public void l(int i10) {
        this.f14113i.setVerticalOffset(i10);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        if (menuBuilder == this.f14107c) {
            dismiss();
            MenuPresenter.Callback callback = this.Z;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z10);
            }
        }
    }

    public void onDismiss() {
        this.O0 = true;
        this.f14107c.close();
        ViewTreeObserver viewTreeObserver = this.N0;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.N0 = this.Y.getViewTreeObserver();
            }
            this.N0.removeGlobalOnLayoutListener(this.f14114j);
            this.N0 = null;
        }
        this.Y.removeOnAttachStateChangeListener(this.f14115w);
        PopupWindow.OnDismissListener onDismissListener = this.C;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f14106b, subMenuBuilder, this.Y, this.f14109e, this.f14111g, this.f14112h);
            menuPopupHelper.setPresenterCallback(this.Z);
            menuPopupHelper.setForceShowIcon(c.m(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.C);
            this.C = null;
            this.f14107c.close(false);
            int horizontalOffset = this.f14113i.getHorizontalOffset();
            int verticalOffset = this.f14113i.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.R0, ViewCompat.getLayoutDirection(this.X)) & 7) == 5) {
                horizontalOffset += this.X.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.Z;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.Z = callback;
    }

    public void show() {
        if (!o()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z10) {
        this.P0 = false;
        MenuAdapter menuAdapter = this.f14108d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
