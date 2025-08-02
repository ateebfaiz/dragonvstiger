package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends a implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr3[i14] = getMenuItemWrapper(menuItemArr2[i14]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int i10) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i10));
    }

    public MenuItem getItem(int i10) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i10));
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i10, keyEvent);
    }

    public boolean performIdentifierAction(int i10, int i11) {
        return this.mWrappedObject.performIdentifierAction(i10, i11);
    }

    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return this.mWrappedObject.performShortcut(i10, keyEvent, i11);
    }

    public void removeGroup(int i10) {
        internalRemoveGroup(i10);
        this.mWrappedObject.removeGroup(i10);
    }

    public void removeItem(int i10) {
        internalRemoveItem(i10);
        this.mWrappedObject.removeItem(i10);
    }

    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        this.mWrappedObject.setGroupCheckable(i10, z10, z11);
    }

    public void setGroupEnabled(int i10, boolean z10) {
        this.mWrappedObject.setGroupEnabled(i10, z10);
    }

    public void setGroupVisible(int i10, boolean z10) {
        this.mWrappedObject.setGroupVisible(i10, z10);
    }

    public void setQwertyMode(boolean z10) {
        this.mWrappedObject.setQwertyMode(z10);
    }

    public int size() {
        return this.mWrappedObject.size();
    }

    public MenuItem add(int i10) {
        return getMenuItemWrapper(this.mWrappedObject.add(i10));
    }

    public SubMenu addSubMenu(int i10) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i10));
    }

    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i10, i11, i12, charSequence));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i10, i11, i12, charSequence));
    }

    public MenuItem add(int i10, int i11, int i12, int i13) {
        return getMenuItemWrapper(this.mWrappedObject.add(i10, i11, i12, i13));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i10, i11, i12, i13));
    }
}
