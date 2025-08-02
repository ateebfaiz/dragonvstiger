package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

class b implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* renamed from: a  reason: collision with root package name */
    private MenuBuilder f14101a;

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f14102b;

    /* renamed from: c  reason: collision with root package name */
    ListMenuPresenter f14103c;

    /* renamed from: d  reason: collision with root package name */
    private MenuPresenter.Callback f14104d;

    public b(MenuBuilder menuBuilder) {
        this.f14101a = menuBuilder;
    }

    public void a() {
        AlertDialog alertDialog = this.f14102b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f14101a;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
        this.f14103c = listMenuPresenter;
        listMenuPresenter.setCallback(this);
        this.f14101a.addMenuPresenter(this.f14103c);
        builder.setAdapter(this.f14103c.getAdapter(), this);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(this);
        AlertDialog create = builder.create();
        this.f14102b = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f14102b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f14102b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f14101a.performItemAction((MenuItemImpl) this.f14103c.getAdapter().getItem(i10), 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        if (z10 || menuBuilder == this.f14101a) {
            a();
        }
        MenuPresenter.Callback callback = this.f14104d;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z10);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f14103c.onCloseMenu(this.f14101a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f14102b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f14102b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f14101a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f14101a.performShortcut(i10, keyEvent, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f14104d;
        if (callback != null) {
            return callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }
}
