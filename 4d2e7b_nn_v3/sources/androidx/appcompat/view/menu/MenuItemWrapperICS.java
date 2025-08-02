package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS extends a implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* renamed from: a  reason: collision with root package name */
        final android.view.CollapsibleActionView f14091a;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f14091a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f14091a;
        }

        public void onActionViewCollapsed() {
            this.f14091a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f14091a.onActionViewExpanded();
        }
    }

    private class a extends ActionProvider {

        /* renamed from: a  reason: collision with root package name */
        final android.view.ActionProvider f14092a;

        a(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f14092a = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f14092a.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f14092a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f14092a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f14092a.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: c  reason: collision with root package name */
        private ActionProvider.VisibilityListener f14094c;

        b(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean isVisible() {
            return this.f14092a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            ActionProvider.VisibilityListener visibilityListener = this.f14094c;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z10);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f14092a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f14092a.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.f14092a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            b bVar;
            this.f14094c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f14092a;
            if (visibilityListener != null) {
                bVar = this;
            } else {
                bVar = null;
            }
            actionProvider.setVisibilityListener(bVar);
        }
    }

    private class c implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f14096a;

        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f14096a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f14096a.onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f14096a.onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f14098a;

        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f14098a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f14098a.onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.mWrappedObject = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.mWrappedObject.getSupportActionProvider();
        if (supportActionProvider instanceof a) {
            return ((a) supportActionProvider).f14092a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).a();
        }
        return actionView;
    }

    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    public SubMenu getSubMenu() {
        return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        b bVar = new b(this.mContext, actionProvider);
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (actionProvider == null) {
            bVar = null;
        }
        supportMenuItem.setSupportActionProvider(bVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mWrappedObject.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.mWrappedObject.setAlphabeticShortcut(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.mWrappedObject.setCheckable(z10);
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        this.mWrappedObject.setChecked(z10);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mWrappedObject.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        this.mWrappedObject.setEnabled(z10);
        return this;
    }

    public void setExclusiveCheckable(boolean z10) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, new Object[]{Boolean.valueOf(z10)});
        } catch (Exception e10) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e10);
        }
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mWrappedObject.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mWrappedObject.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mWrappedObject.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mWrappedObject.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.mWrappedObject.setNumericShortcut(c10);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        c cVar;
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (onActionExpandListener != null) {
            cVar = new c(onActionExpandListener);
        } else {
            cVar = null;
        }
        supportMenuItem.setOnActionExpandListener(cVar);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        d dVar;
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        if (onMenuItemClickListener != null) {
            dVar = new d(onMenuItemClickListener);
        } else {
            dVar = null;
        }
        supportMenuItem.setOnMenuItemClickListener(dVar);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.mWrappedObject.setShortcut(c10, c11);
        return this;
    }

    public void setShowAsAction(int i10) {
        this.mWrappedObject.setShowAsAction(i10);
    }

    public MenuItem setShowAsActionFlags(int i10) {
        this.mWrappedObject.setShowAsActionFlags(i10);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mWrappedObject.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mWrappedObject.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        return this.mWrappedObject.setVisible(z10);
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.mWrappedObject.setAlphabeticShortcut(c10, i10);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.mWrappedObject.setIcon(i10);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        this.mWrappedObject.setNumericShortcut(c10, i10);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.mWrappedObject.setShortcut(c10, c11, i10, i11);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.mWrappedObject.setTitle(i10);
        return this;
    }

    public MenuItem setActionView(int i10) {
        this.mWrappedObject.setActionView(i10);
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.mWrappedObject.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
