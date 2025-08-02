package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class c implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Rect f14105a;

    c() {
    }

    protected static int d(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i10) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i11 = 0;
        int i12 = 0;
        View view = null;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = listAdapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i13, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i10) {
                return i10;
            }
            if (measuredWidth > i11) {
                i11 = measuredWidth;
            }
        }
        return i11;
    }

    protected static boolean m(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menuBuilder.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static MenuAdapter n(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    public abstract void a(MenuBuilder menuBuilder);

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    public Rect c() {
        return this.f14105a;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void e(View view);

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void f(Rect rect) {
        this.f14105a = rect;
    }

    public abstract void g(boolean z10);

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public abstract void h(int i10);

    public abstract void i(int i10);

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public abstract void j(PopupWindow.OnDismissListener onDismissListener);

    public abstract void k(boolean z10);

    public abstract void l(int i10);

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        int i11;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        MenuBuilder menuBuilder = n(listAdapter).mAdapterMenu;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i10);
        if (b()) {
            i11 = 0;
        } else {
            i11 = 4;
        }
        menuBuilder.performItemAction(menuItem, this, i11);
    }
}
