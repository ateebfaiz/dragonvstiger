package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    c adapter;
    private MenuPresenter.Callback callback;
    @Px
    int dividerInsetEnd;
    @Px
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;

    /* renamed from: id  reason: collision with root package name */
    private int f8318id;
    boolean isBehindStatusBar = true;
    Drawable itemBackground;
    RippleDrawable itemForeground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    /* access modifiers changed from: private */
    public int itemMaxLines;
    @Px
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener = new a();
    private int overScrollMode = -1;
    int paddingSeparator;
    private int paddingTopDefault;
    @Nullable
    ColorStateList subheaderColor;
    @Px
    int subheaderInsetEnd;
    @Px
    int subheaderInsetStart;
    int subheaderTextAppearance = 0;
    int textAppearance = 0;
    ColorStateList textColor;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            boolean z10 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                z10 = false;
            } else {
                NavigationMenuPresenter.this.adapter.j(itemData);
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z10) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    private static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f8320a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private MenuItemImpl f8321b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8322c;

        c() {
            h();
        }

        private void a(int i10, int i11) {
            while (i10 < i11) {
                ((g) this.f8320a.get(i10)).f8327b = true;
                i10++;
            }
        }

        private void h() {
            if (!this.f8322c) {
                boolean z10 = true;
                this.f8322c = true;
                this.f8320a.clear();
                this.f8320a.add(new d());
                int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
                int i10 = -1;
                int i11 = 0;
                boolean z11 = false;
                int i12 = 0;
                while (i11 < size) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i11);
                    if (menuItemImpl.isChecked()) {
                        j(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.setExclusiveCheckable(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i11 != 0) {
                                this.f8320a.add(new f(NavigationMenuPresenter.this.paddingSeparator, 0));
                            }
                            this.f8320a.add(new g(menuItemImpl));
                            int size2 = this.f8320a.size();
                            int size3 = subMenu.size();
                            int i13 = 0;
                            boolean z12 = false;
                            while (i13 < size3) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i13);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z12 && menuItemImpl2.getIcon() != null) {
                                        z12 = z10;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.setExclusiveCheckable(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        j(menuItemImpl);
                                    }
                                    this.f8320a.add(new g(menuItemImpl2));
                                }
                                i13++;
                                z10 = true;
                            }
                            if (z12) {
                                a(size2, this.f8320a.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i10) {
                            i12 = this.f8320a.size();
                            if (menuItemImpl.getIcon() != null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (i11 != 0) {
                                i12++;
                                ArrayList arrayList = this.f8320a;
                                int i14 = NavigationMenuPresenter.this.paddingSeparator;
                                arrayList.add(new f(i14, i14));
                            }
                        } else if (!z11 && menuItemImpl.getIcon() != null) {
                            a(i12, this.f8320a.size());
                            z11 = true;
                        }
                        g gVar = new g(menuItemImpl);
                        gVar.f8327b = z11;
                        this.f8320a.add(gVar);
                        i10 = groupId;
                    }
                    i11++;
                    z10 = true;
                }
                this.f8322c = false;
            }
        }

        public Bundle b() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f8321b;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f8320a.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = (e) this.f8320a.get(i10);
                if (eVar instanceof g) {
                    MenuItemImpl a10 = ((g) eVar).a();
                    if (a10 != null) {
                        view = a10.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a10.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public MenuItemImpl c() {
            return this.f8321b;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            int i10;
            if (NavigationMenuPresenter.this.headerLayout.getChildCount() == 0) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            for (int i11 = 0; i11 < NavigationMenuPresenter.this.adapter.getItemCount(); i11++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i11) == 0) {
                    i10++;
                }
            }
            return i10;
        }

        /* renamed from: e */
        public void onBindViewHolder(l lVar, int i10) {
            Drawable drawable;
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
                int i11 = NavigationMenuPresenter.this.textAppearance;
                if (i11 != 0) {
                    navigationMenuItemView.setTextAppearance(i11);
                }
                ColorStateList colorStateList = NavigationMenuPresenter.this.textColor;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable2 = NavigationMenuPresenter.this.itemBackground;
                if (drawable2 != null) {
                    drawable = drawable2.getConstantState().newDrawable();
                } else {
                    drawable = null;
                }
                ViewCompat.setBackground(navigationMenuItemView, drawable);
                RippleDrawable rippleDrawable = NavigationMenuPresenter.this.itemForeground;
                if (rippleDrawable != null) {
                    navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
                }
                g gVar = (g) this.f8320a.get(i10);
                navigationMenuItemView.setNeedsEmptyIcon(gVar.f8327b);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                int i12 = navigationMenuPresenter.itemHorizontalPadding;
                int i13 = navigationMenuPresenter.itemVerticalPadding;
                navigationMenuItemView.setPadding(i12, i13, i12, i13);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                if (navigationMenuPresenter2.hasCustomItemIconSize) {
                    navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
                }
                navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
                navigationMenuItemView.initialize(gVar.a(), 0);
            } else if (itemViewType == 1) {
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.f8320a.get(i10)).a().getTitle());
                int i14 = NavigationMenuPresenter.this.subheaderTextAppearance;
                if (i14 != 0) {
                    TextViewCompat.setTextAppearance(textView, i14);
                }
                textView.setPadding(NavigationMenuPresenter.this.subheaderInsetStart, textView.getPaddingTop(), NavigationMenuPresenter.this.subheaderInsetEnd, textView.getPaddingBottom());
                ColorStateList colorStateList2 = NavigationMenuPresenter.this.subheaderColor;
                if (colorStateList2 != null) {
                    textView.setTextColor(colorStateList2);
                }
            } else if (itemViewType == 2) {
                f fVar = (f) this.f8320a.get(i10);
                lVar.itemView.setPadding(NavigationMenuPresenter.this.dividerInsetStart, fVar.b(), NavigationMenuPresenter.this.dividerInsetEnd, fVar.a());
            }
        }

        /* renamed from: f */
        public l onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new i(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            } else if (i10 == 1) {
                return new k(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            } else {
                if (i10 == 2) {
                    return new j(NavigationMenuPresenter.this.layoutInflater, viewGroup);
                }
                if (i10 != 3) {
                    return null;
                }
                return new b(NavigationMenuPresenter.this.headerLayout);
            }
        }

        /* renamed from: g */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).recycle();
            }
        }

        public int getItemCount() {
            return this.f8320a.size();
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public int getItemViewType(int i10) {
            e eVar = (e) this.f8320a.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (!(eVar instanceof g)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((g) eVar).a().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        public void i(Bundle bundle) {
            MenuItemImpl a10;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a11;
            int i10 = bundle.getInt("android:menu:checked", 0);
            if (i10 != 0) {
                this.f8322c = true;
                int size = this.f8320a.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = (e) this.f8320a.get(i11);
                    if ((eVar instanceof g) && (a11 = ((g) eVar).a()) != null && a11.getItemId() == i10) {
                        j(a11);
                        break;
                    }
                    i11++;
                }
                this.f8322c = false;
                h();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f8320a.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = (e) this.f8320a.get(i12);
                    if (!(!(eVar2 instanceof g) || (a10 = ((g) eVar2).a()) == null || (actionView = a10.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a10.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void j(MenuItemImpl menuItemImpl) {
            if (this.f8321b != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.f8321b;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.f8321b = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void k(boolean z10) {
            this.f8322c = z10;
        }

        public void l() {
            h();
            notifyDataSetChanged();
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    private static class f implements e {

        /* renamed from: a  reason: collision with root package name */
        private final int f8324a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8325b;

        public f(int i10, int i11) {
            this.f8324a = i10;
            this.f8325b = i11;
        }

        public int a() {
            return this.f8325b;
        }

        public int b() {
            return this.f8324a;
        }
    }

    private static class g implements e {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItemImpl f8326a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8327b;

        g(MenuItemImpl menuItemImpl) {
            this.f8326a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f8326a;
        }
    }

    private class h extends RecyclerViewAccessibilityDelegate {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(NavigationMenuPresenter.this.adapter.d(), 0, false));
        }
    }

    private static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void updateTopPadding() {
        int i10;
        if (this.headerLayout.getChildCount() != 0 || !this.isBehindStatusBar) {
            i10 = 0;
        } else {
            i10 = this.paddingTopDefault;
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != systemWindowInsetTop) {
            this.paddingTopDefault = systemWindowInsetTop;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.adapter.c();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i10) {
        return this.headerLayout.getChildAt(i10);
    }

    public int getId() {
        return this.f8318id;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.menuView));
            if (this.adapter == null) {
                this.adapter = new c();
            }
            int i10 = this.overScrollMode;
            if (i10 != -1) {
                this.menuView.setOverScrollMode(i10);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(@LayoutRes int i10) {
        View inflate = this.layoutInflater.inflate(i10, this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        MenuPresenter.Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onCloseMenu(menuBuilder, z10);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.i(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray sparseArray = new SparseArray();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.adapter;
        if (cVar != null) {
            bundle.putBundle(STATE_ADAPTER, cVar.b());
        }
        if (this.headerLayout != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z10) {
        if (this.isBehindStatusBar != z10) {
            this.isBehindStatusBar = z10;
            updateTopPadding();
        }
    }

    public void setCallback(MenuPresenter.Callback callback2) {
        this.callback = callback2;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.adapter.j(menuItemImpl);
    }

    public void setDividerInsetEnd(@Px int i10) {
        this.dividerInsetEnd = i10;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int i10) {
        this.dividerInsetStart = i10;
        updateMenuView(false);
    }

    public void setId(int i10) {
        this.f8318id = i10;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public void setItemForeground(@Nullable RippleDrawable rippleDrawable) {
        this.itemForeground = rippleDrawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i10) {
        this.itemHorizontalPadding = i10;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i10) {
        this.itemIconPadding = i10;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i10) {
        if (this.itemIconSize != i10) {
            this.itemIconSize = i10;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i10) {
        this.itemMaxLines = i10;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i10) {
        this.textAppearance = i10;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int i10) {
        this.itemVerticalPadding = i10;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i10) {
        this.overScrollMode = i10;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    public void setSubheaderColor(@Nullable ColorStateList colorStateList) {
        this.subheaderColor = colorStateList;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int i10) {
        this.subheaderInsetEnd = i10;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int i10) {
        this.subheaderInsetStart = i10;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int i10) {
        this.subheaderTextAppearance = i10;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z10) {
        c cVar = this.adapter;
        if (cVar != null) {
            cVar.k(z10);
        }
    }

    public void updateMenuView(boolean z10) {
        c cVar = this.adapter;
        if (cVar != null) {
            cVar.l();
        }
    }
}
