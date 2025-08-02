package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    class a implements MenuBuilder.Callback {
        a() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.mMenuItemClickListener;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        public void onDismiss() {
            PopupMenu popupMenu = PopupMenu.this;
            OnDismissListener onDismissListener = popupMenu.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(popupMenu);
            }
        }
    }

    class c extends ForwardingListener {
        c(View view) {
            super(view);
        }

        public ShowableListMenu getPopup() {
            return PopupMenu.this.mPopup.getPopup();
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new c(this.mAnchor);
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.mMenu;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ListView getMenuListView() {
        if (!this.mPopup.isShowing()) {
            return null;
        }
        return this.mPopup.getListView();
    }

    public void inflate(@MenuRes int i10) {
        getMenuInflater().inflate(i10, this.mMenu);
    }

    public void setForceShowIcon(boolean z10) {
        this.mPopup.setForceShowIcon(z10);
    }

    public void setGravity(int i10) {
        this.mPopup.setGravity(i10);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i10) {
        this(context, view, i10, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i10, @AttrRes int i11, @StyleRes int i12) {
        this.mContext = context;
        this.mAnchor = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.mMenu = menuBuilder;
        menuBuilder.setCallback(new a());
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i11, i12);
        this.mPopup = menuPopupHelper;
        menuPopupHelper.setGravity(i10);
        menuPopupHelper.setOnDismissListener(new b());
    }
}
