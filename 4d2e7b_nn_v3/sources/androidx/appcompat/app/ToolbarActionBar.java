package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
    final DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    final AppCompatDelegateImpl.g mMenuCallback;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator = new a();
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    boolean mToolbarMenuPrepared;
    final Window.Callback mWindowCallback;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    }

    class b implements Toolbar.OnMenuItemClickListener {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements MenuPresenter.Callback {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13963a;

        c() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            if (!this.f13963a) {
                this.f13963a = true;
                ToolbarActionBar.this.mDecorToolbar.dismissPopupMenus();
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
                this.f13963a = false;
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.mWindowCallback.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            return true;
        }
    }

    private final class d implements MenuBuilder.Callback {
        d() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.mDecorToolbar.isOverflowMenuShowing()) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, menuBuilder);
            }
        }
    }

    private class e implements AppCompatDelegateImpl.g {
        e() {
        }

        public boolean a(int i10) {
            if (i10 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.mToolbarMenuPrepared) {
                return false;
            }
            toolbarActionBar.mDecorToolbar.setMenuPrepared();
            ToolbarActionBar.this.mToolbarMenuPrepared = true;
            return false;
        }

        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(ToolbarActionBar.this.mDecorToolbar.getContext());
            }
            return null;
        }
    }

    ToolbarActionBar(@NonNull Toolbar toolbar, @Nullable CharSequence charSequence, @NonNull Window.Callback callback) {
        b bVar = new b();
        this.mMenuClicker = bVar;
        Preconditions.checkNotNull(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.mDecorToolbar = toolbarWidgetWrapper;
        this.mWindowCallback = (Window.Callback) Preconditions.checkNotNull(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.mMenuCallback = new e();
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mDecorToolbar.setMenuCallbacks(new c(), new d());
            this.mMenuCallbackSet = true;
        }
        return this.mDecorToolbar.getMenu();
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if (!this.mDecorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean z10) {
        if (z10 != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z10;
            int size = this.mMenuVisibilityListeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mMenuVisibilityListeners.get(i10).onMenuVisibilityChanged(z10);
            }
        }
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return true;
    }

    public boolean isShowing() {
        if (this.mDecorToolbar.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    public boolean onKeyShortcut(int i10, KeyEvent keyEvent) {
        int i11;
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        menu.setQwertyMode(z10);
        return menu.performShortcut(i10, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populateOptionsMenu() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.getMenu()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.MenuBuilder
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r0
            androidx.appcompat.view.menu.MenuBuilder r1 = (androidx.appcompat.view.menu.MenuBuilder) r1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            if (r1 == 0) goto L_0x0013
            r1.stopDispatchingItemsChanged()
        L_0x0013:
            r0.clear()     // Catch:{ all -> 0x0028 }
            android.view.Window$Callback r3 = r5.mWindowCallback     // Catch:{ all -> 0x0028 }
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            android.view.Window$Callback r3 = r5.mWindowCallback     // Catch:{ all -> 0x0028 }
            boolean r2 = r3.onPreparePanel(r4, r2, r0)     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x002d
            goto L_0x002a
        L_0x0028:
            r0 = move-exception
            goto L_0x0033
        L_0x002a:
            r0.clear()     // Catch:{ all -> 0x0028 }
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.startDispatchingItemsChanged()
        L_0x0032:
            return
        L_0x0033:
            if (r1 == 0) goto L_0x0038
            r1.startDispatchingItemsChanged()
        L_0x0038:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ToolbarActionBar.populateOptionsMenu():void");
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.mDecorToolbar.setBackgroundDrawable(drawable);
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z10) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i10) {
        setDisplayOptions(i10, -1);
    }

    public void setDisplayShowCustomEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 16;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z10) {
        setDisplayOptions(z10 ? 1 : 0, 1);
    }

    public void setElevation(float f10) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), f10);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z10) {
    }

    public void setIcon(int i10) {
        this.mDecorToolbar.setIcon(i10);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new v(onNavigationListener));
    }

    public void setLogo(int i10) {
        this.mDecorToolbar.setLogo(i10);
    }

    public void setNavigationMode(int i10) {
        if (i10 != 2) {
            this.mDecorToolbar.setNavigationMode(i10);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int i10) {
        if (this.mDecorToolbar.getNavigationMode() == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(i10);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean z10) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    public void addTab(ActionBar.Tab tab, boolean z10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDisplayOptions(int i10, int i11) {
        this.mDecorToolbar.setDisplayOptions((i10 & i11) | ((~i11) & this.mDecorToolbar.getDisplayOptions()));
    }

    public void setHomeActionContentDescription(int i10) {
        this.mDecorToolbar.setNavigationContentDescription(i10);
    }

    public void setHomeAsUpIndicator(int i10) {
        this.mDecorToolbar.setNavigationIcon(i10);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setSubtitle(int i10) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        decorToolbar.setSubtitle(i10 != 0 ? decorToolbar.getContext().getText(i10) : null);
    }

    public void setTitle(int i10) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        decorToolbar.setTitle(i10 != 0 ? decorToolbar.getContext().getText(i10) : null);
    }

    public void addTab(ActionBar.Tab tab, int i10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i10, boolean z10) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(int i10) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(i10, this.mDecorToolbar.getViewGroup(), false));
    }
}
