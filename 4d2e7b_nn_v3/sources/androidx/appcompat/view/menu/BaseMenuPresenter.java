package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter implements MenuPresenter {
    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context context, int i10, int i11) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i10;
        this.mItemLayoutRes = i11;
    }

    /* access modifiers changed from: protected */
    public void addItemView(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i10);
    }

    public abstract void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean filterLeftoverView(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        if (view instanceof MenuView.ItemView) {
            itemView = (MenuView.ItemView) view;
        } else {
            itemView = createItemView(viewGroup);
        }
        bindItemView(menuItemImpl, itemView);
        return (View) itemView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            MenuView menuView = (MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView = menuView;
            menuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r1.mCallback
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.mMenu
        L_0x0009:
            boolean r2 = r0.onOpenSubMenu(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.BaseMenuPresenter.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public boolean shouldIncludeItem(int i10, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void updateMenuView(boolean z10) {
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.mMenu;
            int i10 = 0;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
                int size = visibleItems.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    MenuItemImpl menuItemImpl2 = visibleItems.get(i12);
                    if (shouldIncludeItem(i11, menuItemImpl2)) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof MenuView.ItemView) {
                            menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View itemView = getItemView(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i11);
                        }
                        i11++;
                    }
                }
                i10 = i11;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i10)) {
                    i10++;
                }
            }
        }
    }
}
