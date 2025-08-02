package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.mParentMenu = menuBuilder;
        this.mItem = menuItemImpl;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.collapseItemActionView(menuItemImpl);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (super.dispatchMenuItemSelected(menuBuilder, menuItem) || this.mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int i10;
        MenuItemImpl menuItemImpl = this.mItem;
        if (menuItemImpl != null) {
            i10 = menuItemImpl.getItemId();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + i10;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.mParentMenu.setCallback(callback);
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.mParentMenu.setGroupDividerEnabled(z10);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z10) {
        this.mParentMenu.setQwertyMode(z10);
    }

    public void setShortcutsVisible(boolean z10) {
        this.mParentMenu.setShortcutsVisible(z10);
    }

    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.setHeaderIconInt(i10);
    }

    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.setHeaderTitleInt(i10);
    }

    public SubMenu setIcon(int i10) {
        this.mItem.setIcon(i10);
        return this;
    }
}
