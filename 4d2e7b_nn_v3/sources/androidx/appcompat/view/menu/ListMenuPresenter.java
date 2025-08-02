package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    a mAdapter;
    private MenuPresenter.Callback mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f14088a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.mMenu.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.mMenu.getNonActionItems();
                int size = nonActionItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (nonActionItems.get(i10) == expandedItem) {
                        this.f14088a = i10;
                        return;
                    }
                }
            }
            this.f14088a = -1;
        }

        /* renamed from: b */
        public MenuItemImpl getItem(int i10) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.mMenu.getNonActionItems();
            int i11 = i10 + ListMenuPresenter.this.mItemIndexOffset;
            int i12 = this.f14088a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return nonActionItems.get(i11);
        }

        public int getCount() {
            int size = ListMenuPresenter.this.mMenu.getNonActionItems().size() - ListMenuPresenter.this.mItemIndexOffset;
            if (this.f14088a < 0) {
                return size;
            }
            return size - 1;
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.mInflater.inflate(listMenuPresenter.mItemLayoutRes, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i10), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i10) {
        this(i10, 0);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new a();
        }
        return this.mAdapter;
    }

    public int getId() {
        return this.mId;
    }

    /* access modifiers changed from: package-private */
    public int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (ExpandedMenuView) this.mInflater.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.mAdapter == null) {
                this.mAdapter = new a();
            }
            this.mMenuView.setAdapter(this.mAdapter);
            this.mMenuView.setOnItemClickListener(this);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.mThemeRes != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.mThemeRes);
            this.mContext = contextThemeWrapper;
            this.mInflater = LayoutInflater.from(contextThemeWrapper);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(context);
            }
        }
        this.mMenu = menuBuilder;
        a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z10);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.mMenu.performItemAction(this.mAdapter.getItem(i10), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.mMenuView == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new b(subMenuBuilder).b((IBinder) null);
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.mMenuView.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setItemIndexOffset(int i10) {
        this.mItemIndexOffset = i10;
        if (this.mMenuView != null) {
            updateMenuView(false);
        }
    }

    public void updateMenuView(boolean z10) {
        a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i10, int i11) {
        this.mItemLayoutRes = i10;
        this.mThemeRes = i11;
    }
}
