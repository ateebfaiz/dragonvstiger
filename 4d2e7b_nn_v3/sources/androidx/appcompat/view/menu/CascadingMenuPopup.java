package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends c implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int Z0 = R.layout.abc_cascading_menu_item_layout;
    private final MenuItemHoverListener C = new c();
    View N0;
    private int O0;
    private boolean P0;
    private boolean Q0;
    private int R0;
    private int S0;
    private boolean T0;
    private boolean U0;
    private MenuPresenter.Callback V0;
    ViewTreeObserver W0;
    private int X = 0;
    private PopupWindow.OnDismissListener X0;
    private int Y = 0;
    boolean Y0;
    private View Z;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14068b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14069c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14070d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14071e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14072f;

    /* renamed from: g  reason: collision with root package name */
    final Handler f14073g;

    /* renamed from: h  reason: collision with root package name */
    private final List f14074h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    final List f14075i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f14076j = new a();

    /* renamed from: w  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f14077w = new b();

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.f14075i.size() > 0 && !((d) CascadingMenuPopup.this.f14075i.get(0)).f14085a.isModal()) {
                View view = CascadingMenuPopup.this.N0;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (d dVar : CascadingMenuPopup.this.f14075i) {
                    dVar.f14085a.show();
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
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.W0;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.W0 = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.W0.removeGlobalOnLayoutListener(cascadingMenuPopup.f14076j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements MenuItemHoverListener {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f14081a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f14082b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MenuBuilder f14083c;

            a(d dVar, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.f14081a = dVar;
                this.f14082b = menuItem;
                this.f14083c = menuBuilder;
            }

            public void run() {
                d dVar = this.f14081a;
                if (dVar != null) {
                    CascadingMenuPopup.this.Y0 = true;
                    dVar.f14086b.close(false);
                    CascadingMenuPopup.this.Y0 = false;
                }
                if (this.f14082b.isEnabled() && this.f14082b.hasSubMenu()) {
                    this.f14083c.performItemAction(this.f14082b, 4);
                }
            }
        }

        c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.appcompat.view.menu.CascadingMenuPopup$d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onItemHoverEnter(androidx.appcompat.view.menu.MenuBuilder r6, android.view.MenuItem r7) {
            /*
                r5 = this;
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                android.os.Handler r0 = r0.f14073g
                r1 = 0
                r0.removeCallbacksAndMessages(r1)
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.f14075i
                int r0 = r0.size()
                r2 = 0
            L_0x0011:
                r3 = -1
                if (r2 >= r0) goto L_0x0026
                androidx.appcompat.view.menu.CascadingMenuPopup r4 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r4 = r4.f14075i
                java.lang.Object r4 = r4.get(r2)
                androidx.appcompat.view.menu.CascadingMenuPopup$d r4 = (androidx.appcompat.view.menu.CascadingMenuPopup.d) r4
                androidx.appcompat.view.menu.MenuBuilder r4 = r4.f14086b
                if (r6 != r4) goto L_0x0023
                goto L_0x0027
            L_0x0023:
                int r2 = r2 + 1
                goto L_0x0011
            L_0x0026:
                r2 = r3
            L_0x0027:
                if (r2 != r3) goto L_0x002a
                return
            L_0x002a:
                int r2 = r2 + 1
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.f14075i
                int r0 = r0.size()
                if (r2 >= r0) goto L_0x0041
                androidx.appcompat.view.menu.CascadingMenuPopup r0 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                java.util.List r0 = r0.f14075i
                java.lang.Object r0 = r0.get(r2)
                r1 = r0
                androidx.appcompat.view.menu.CascadingMenuPopup$d r1 = (androidx.appcompat.view.menu.CascadingMenuPopup.d) r1
            L_0x0041:
                androidx.appcompat.view.menu.CascadingMenuPopup$c$a r0 = new androidx.appcompat.view.menu.CascadingMenuPopup$c$a
                r0.<init>(r1, r7, r6)
                long r1 = android.os.SystemClock.uptimeMillis()
                r3 = 200(0xc8, double:9.9E-322)
                long r1 = r1 + r3
                androidx.appcompat.view.menu.CascadingMenuPopup r7 = androidx.appcompat.view.menu.CascadingMenuPopup.this
                android.os.Handler r7 = r7.f14073g
                r7.postAtTime(r0, r6, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.c.onItemHoverEnter(androidx.appcompat.view.menu.MenuBuilder, android.view.MenuItem):void");
        }

        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f14073g.removeCallbacksAndMessages(menuBuilder);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f14085a;

        /* renamed from: b  reason: collision with root package name */
        public final MenuBuilder f14086b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14087c;

        public d(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i10) {
            this.f14085a = menuPopupWindow;
            this.f14086b = menuBuilder;
            this.f14087c = i10;
        }

        public ListView a() {
            return this.f14085a.getListView();
        }
    }

    public CascadingMenuPopup(Context context, View view, int i10, int i11, boolean z10) {
        this.f14068b = context;
        this.Z = view;
        this.f14070d = i10;
        this.f14071e = i11;
        this.f14072f = z10;
        this.T0 = false;
        this.O0 = s();
        Resources resources = context.getResources();
        this.f14069c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f14073g = new Handler();
    }

    private MenuPopupWindow o() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f14068b, (AttributeSet) null, this.f14070d, this.f14071e);
        menuPopupWindow.setHoverListener(this.C);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.Z);
        menuPopupWindow.setDropDownGravity(this.Y);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int p(MenuBuilder menuBuilder) {
        int size = this.f14075i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (menuBuilder == ((d) this.f14075i.get(i10)).f14086b) {
                return i10;
            }
        }
        return -1;
    }

    private MenuItem q(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menuBuilder.getItem(i10);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View r(d dVar, MenuBuilder menuBuilder) {
        int i10;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem q10 = q(dVar.f14086b, menuBuilder);
        if (q10 == null) {
            return null;
        }
        ListView a10 = dVar.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i10 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            } else if (q10 == menuAdapter.getItem(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int s() {
        if (ViewCompat.getLayoutDirection(this.Z) == 1) {
            return 0;
        }
        return 1;
    }

    private int t(int i10) {
        List list = this.f14075i;
        ListView a10 = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.N0.getWindowVisibleDisplayFrame(rect);
        if (this.O0 == 1) {
            if (iArr[0] + a10.getWidth() + i10 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i10 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void u(MenuBuilder menuBuilder) {
        View view;
        d dVar;
        boolean z10;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f14068b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f14072f, Z0);
        if (!isShowing() && this.T0) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(c.m(menuBuilder));
        }
        int d10 = c.d(menuAdapter, (ViewGroup) null, this.f14068b, this.f14069c);
        MenuPopupWindow o10 = o();
        o10.setAdapter(menuAdapter);
        o10.setContentWidth(d10);
        o10.setDropDownGravity(this.Y);
        if (this.f14075i.size() > 0) {
            List list = this.f14075i;
            dVar = (d) list.get(list.size() - 1);
            view = r(dVar, menuBuilder);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            o10.setTouchModal(false);
            o10.setEnterTransition((Object) null);
            int t10 = t(d10);
            if (t10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.O0 = t10;
            if (Build.VERSION.SDK_INT >= 26) {
                o10.setAnchorView(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.Z.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.Y & 7) == 5) {
                    iArr[0] = iArr[0] + this.Z.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.Y & 5) != 5) {
                if (z10) {
                    d10 = view.getWidth();
                }
                i12 = i10 - d10;
                o10.setHorizontalOffset(i12);
                o10.setOverlapAnchor(true);
                o10.setVerticalOffset(i11);
            } else if (!z10) {
                d10 = view.getWidth();
                i12 = i10 - d10;
                o10.setHorizontalOffset(i12);
                o10.setOverlapAnchor(true);
                o10.setVerticalOffset(i11);
            }
            i12 = i10 + d10;
            o10.setHorizontalOffset(i12);
            o10.setOverlapAnchor(true);
            o10.setVerticalOffset(i11);
        } else {
            if (this.P0) {
                o10.setHorizontalOffset(this.R0);
            }
            if (this.Q0) {
                o10.setVerticalOffset(this.S0);
            }
            o10.setEpicenterBounds(c());
        }
        this.f14075i.add(new d(o10, menuBuilder, this.O0));
        o10.show();
        ListView listView = o10.getListView();
        listView.setOnKeyListener(this);
        if (dVar == null && this.U0 && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, (Object) null, false);
            o10.show();
        }
    }

    public void a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f14068b);
        if (isShowing()) {
            u(menuBuilder);
        } else {
            this.f14074h.add(menuBuilder);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }

    public void dismiss() {
        int size = this.f14075i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f14075i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f14085a.isShowing()) {
                    dVar.f14085a.dismiss();
                }
            }
        }
    }

    public void e(View view) {
        if (this.Z != view) {
            this.Z = view;
            this.Y = GravityCompat.getAbsoluteGravity(this.X, ViewCompat.getLayoutDirection(view));
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z10) {
        this.T0 = z10;
    }

    public ListView getListView() {
        if (this.f14075i.isEmpty()) {
            return null;
        }
        List list = this.f14075i;
        return ((d) list.get(list.size() - 1)).a();
    }

    public void h(int i10) {
        if (this.X != i10) {
            this.X = i10;
            this.Y = GravityCompat.getAbsoluteGravity(i10, ViewCompat.getLayoutDirection(this.Z));
        }
    }

    public void i(int i10) {
        this.P0 = true;
        this.R0 = i10;
    }

    public boolean isShowing() {
        if (this.f14075i.size() <= 0 || !((d) this.f14075i.get(0)).f14085a.isShowing()) {
            return false;
        }
        return true;
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.X0 = onDismissListener;
    }

    public void k(boolean z10) {
        this.U0 = z10;
    }

    public void l(int i10) {
        this.Q0 = true;
        this.S0 = i10;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        int p10 = p(menuBuilder);
        if (p10 >= 0) {
            int i10 = p10 + 1;
            if (i10 < this.f14075i.size()) {
                ((d) this.f14075i.get(i10)).f14086b.close(false);
            }
            d dVar = (d) this.f14075i.remove(p10);
            dVar.f14086b.removeMenuPresenter(this);
            if (this.Y0) {
                dVar.f14085a.setExitTransition((Object) null);
                dVar.f14085a.setAnimationStyle(0);
            }
            dVar.f14085a.dismiss();
            int size = this.f14075i.size();
            if (size > 0) {
                this.O0 = ((d) this.f14075i.get(size - 1)).f14087c;
            } else {
                this.O0 = s();
            }
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.V0;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.W0;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.W0.removeGlobalOnLayoutListener(this.f14076j);
                    }
                    this.W0 = null;
                }
                this.N0.removeOnAttachStateChangeListener(this.f14077w);
                this.X0.onDismiss();
            } else if (z10) {
                ((d) this.f14075i.get(0)).f14086b.close(false);
            }
        }
    }

    public void onDismiss() {
        d dVar;
        int size = this.f14075i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f14075i.get(i10);
            if (!dVar.f14085a.isShowing()) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            dVar.f14086b.close(false);
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
        for (d dVar : this.f14075i) {
            if (subMenuBuilder == dVar.f14086b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        a(subMenuBuilder);
        MenuPresenter.Callback callback = this.V0;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.V0 = callback;
    }

    public void show() {
        boolean z10;
        if (!isShowing()) {
            for (MenuBuilder u10 : this.f14074h) {
                u(u10);
            }
            this.f14074h.clear();
            View view = this.Z;
            this.N0 = view;
            if (view != null) {
                if (this.W0 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.W0 = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f14076j);
                }
                this.N0.addOnAttachStateChangeListener(this.f14077w);
            }
        }
    }

    public void updateMenuView(boolean z10) {
        for (d a10 : this.f14075i) {
            c.n(a10.a().getAdapter()).notifyDataSetChanged();
        }
    }
}
