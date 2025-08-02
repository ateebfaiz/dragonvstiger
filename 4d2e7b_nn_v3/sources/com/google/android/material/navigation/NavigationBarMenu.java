package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i10) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i10;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public MenuItem addInternal(int i10, int i11, int i12, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i10, i11, i12, charSequence);
            if (addInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.maxItemCount + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @NonNull
    public SubMenu addSubMenu(int i10, int i11, int i12, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
