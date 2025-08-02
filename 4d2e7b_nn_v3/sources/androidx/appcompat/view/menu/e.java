package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

class e extends MenuWrapperICS implements SubMenu {

    /* renamed from: a  reason: collision with root package name */
    private final SupportSubMenu f14118a;

    e(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.f14118a = supportSubMenu;
    }

    public void clearHeader() {
        this.f14118a.clearHeader();
    }

    public MenuItem getItem() {
        return getMenuItemWrapper(this.f14118a.getItem());
    }

    public SubMenu setHeaderIcon(int i10) {
        this.f14118a.setHeaderIcon(i10);
        return this;
    }

    public SubMenu setHeaderTitle(int i10) {
        this.f14118a.setHeaderTitle(i10);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f14118a.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i10) {
        this.f14118a.setIcon(i10);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f14118a.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f14118a.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f14118a.setIcon(drawable);
        return this;
    }
}
