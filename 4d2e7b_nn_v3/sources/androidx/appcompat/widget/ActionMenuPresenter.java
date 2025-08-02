package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private boolean C;
    a N0;
    c O0;
    private b P0;
    final e Q0 = new e();
    int R0;
    private int X;
    private final SparseBooleanArray Y = new SparseBooleanArray();
    d Z;

    /* renamed from: a  reason: collision with root package name */
    OverflowMenuButton f14125a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f14126b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14127c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14128d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14129e;

    /* renamed from: f  reason: collision with root package name */
    private int f14130f;

    /* renamed from: g  reason: collision with root package name */
    private int f14131g;

    /* renamed from: h  reason: collision with root package name */
    private int f14132h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14133i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14134j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14135w;

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        class a extends ForwardingListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ActionMenuPresenter f14137a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f14137a = actionMenuPresenter;
            }

            public ShowableListMenu getPopup() {
                d dVar = ActionMenuPresenter.this.Z;
                if (dVar == null) {
                    return null;
                }
                return dVar.getPopup();
            }

            public boolean onForwardingStarted() {
                ActionMenuPresenter.this.u();
                return true;
            }

            public boolean onForwardingStopped() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.O0 != null) {
                    return false;
                }
                actionMenuPresenter.k();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.u();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f14139a;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f14139a);
        }

        SavedState(Parcel parcel) {
            this.f14139a = parcel.readInt();
        }
    }

    private class a extends MenuPopupHelper {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.f14125a;
                setAnchorView(view2 == null ? (View) ActionMenuPresenter.this.mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.Q0);
        }

        /* access modifiers changed from: protected */
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.N0 = null;
            actionMenuPresenter.R0 = 0;
            super.onDismiss();
        }
    }

    private class b extends ActionMenuItemView.PopupCallback {
        b() {
        }

        public ShowableListMenu getPopup() {
            a aVar = ActionMenuPresenter.this.N0;
            if (aVar != null) {
                return aVar.getPopup();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private d f14142a;

        public c(d dVar) {
            this.f14142a = dVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.f14142a.tryShow())) {
                ActionMenuPresenter.this.Z = this.f14142a;
            }
            ActionMenuPresenter.this.O0 = null;
        }
    }

    private class d extends MenuPopupHelper {
        public d(Context context, MenuBuilder menuBuilder, View view, boolean z10) {
            super(context, menuBuilder, view, z10, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.Q0);
        }

        /* access modifiers changed from: protected */
        public void onDismiss() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            ActionMenuPresenter.this.Z = null;
            super.onDismiss();
        }
    }

    private class e implements MenuPresenter.Callback {
        e() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z10);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.mMenu) {
                return false;
            }
            ActionMenuPresenter.this.R0 = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    private View i(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.P0 == null) {
            this.P0 = new b();
        }
        actionMenuItemView.setPopupCallback(this.P0);
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f14125a) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i10);
    }

    public boolean flagActionItems() {
        int i10;
        ArrayList<MenuItemImpl> arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        View view = null;
        boolean z13 = false;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i14 = actionMenuPresenter.f14132h;
        int i15 = actionMenuPresenter.f14131g;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
        boolean z14 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < i10; i18++) {
            MenuItemImpl menuItemImpl = arrayList.get(i18);
            if (menuItemImpl.requiresActionButton()) {
                i16++;
            } else if (menuItemImpl.requestsActionButton()) {
                i17++;
            } else {
                z14 = true;
            }
            if (actionMenuPresenter.C && menuItemImpl.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (actionMenuPresenter.f14128d && (z14 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.Y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f14134j) {
            int i20 = actionMenuPresenter.X;
            i11 = i15 / i20;
            i12 = i20 + ((i15 % i20) / i11);
        } else {
            i12 = 0;
            i11 = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i10) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i21);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.f14134j) {
                    i11 -= ActionMenuView.measureChildForCells(itemView, i12, i11, makeMeasureSpec, z13 ? 1 : 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                z10 = z13;
                i13 = i10;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z15 = sparseBooleanArray.get(groupId2);
                if ((i19 > 0 || z15) && i15 > 0 && (!actionMenuPresenter.f14134j || i11 > 0)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z16 = z11;
                i13 = i10;
                if (z11) {
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.f14134j) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i12, i11, makeMeasureSpec, 0);
                        i11 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z16 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z17 = z16;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f14134j ? i15 + i22 <= 0 : i15 < 0) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    z11 = z17 & z12;
                }
                if (z11 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z15) {
                    sparseBooleanArray.put(groupId2, false);
                    int i23 = 0;
                    while (i23 < i21) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i23);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i19++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                        i23++;
                    }
                }
                if (z11) {
                    i19--;
                }
                menuItemImpl2.setIsActionButton(z11);
                z10 = false;
            } else {
                z10 = z13;
                i13 = i10;
                menuItemImpl2.setIsActionButton(z10);
            }
            i21++;
            z13 = z10;
            i10 = i13;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i10;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        actionView.setVisibility(i10);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public boolean h() {
        return k() | l();
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.f14129e) {
            this.f14128d = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.f14135w) {
            this.f14130f = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.f14133i) {
            this.f14132h = actionBarPolicy.getMaxActionButtons();
        }
        int i10 = this.f14130f;
        if (this.f14128d) {
            if (this.f14125a == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.f14125a = overflowMenuButton;
                if (this.f14127c) {
                    overflowMenuButton.setImageDrawable(this.f14126b);
                    this.f14126b = null;
                    this.f14127c = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f14125a.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f14125a.getMeasuredWidth();
        } else {
            this.f14125a = null;
        }
        this.f14131g = i10;
        this.X = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public Drawable j() {
        OverflowMenuButton overflowMenuButton = this.f14125a;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f14127c) {
            return this.f14126b;
        }
        return null;
    }

    public boolean k() {
        MenuView menuView;
        c cVar = this.O0;
        if (cVar == null || (menuView = this.mMenuView) == null) {
            d dVar = this.Z;
            if (dVar == null) {
                return false;
            }
            dVar.dismiss();
            return true;
        }
        ((View) menuView).removeCallbacks(cVar);
        this.O0 = null;
        return true;
    }

    public boolean l() {
        a aVar = this.N0;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public boolean m() {
        if (this.O0 != null || n()) {
            return true;
        }
        return false;
    }

    public boolean n() {
        d dVar = this.Z;
        if (dVar == null || !dVar.isShowing()) {
            return false;
        }
        return true;
    }

    public boolean o() {
        return this.f14128d;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        h();
        super.onCloseMenu(menuBuilder, z10);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f14139a) > 0 && (findItem = this.mMenu.findItem(i10)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f14139a = this.R0;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z10 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View i10 = i(subMenuBuilder2.getItem());
        if (i10 == null) {
            return false;
        }
        this.R0 = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i11++;
        }
        a aVar = new a(this.mContext, subMenuBuilder, i10);
        this.N0 = aVar;
        aVar.setForceShowIcon(z10);
        this.N0.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z10) {
        if (z10) {
            super.onSubMenuSelected((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public void p(Configuration configuration) {
        if (!this.f14133i) {
            this.f14132h = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void q(boolean z10) {
        this.C = z10;
    }

    public void r(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void s(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f14125a;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.f14127c = true;
        this.f14126b = drawable;
    }

    public boolean shouldIncludeItem(int i10, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public void t(boolean z10) {
        this.f14128d = z10;
        this.f14129e = true;
    }

    public boolean u() {
        MenuBuilder menuBuilder;
        if (!this.f14128d || n() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.O0 != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        c cVar = new c(new d(this.mContext, this.mMenu, this.f14125a, true));
        this.O0 = cVar;
        ((View) this.mMenuView).post(cVar);
        return true;
    }

    public void updateMenuView(boolean z10) {
        ArrayList<MenuItemImpl> arrayList;
        MenuView menuView;
        super.updateMenuView(z10);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        boolean z11 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                ActionProvider supportActionProvider = actionItems.get(i10).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.getNonActionItems();
        } else {
            arrayList = null;
        }
        if (this.f14128d && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z11 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f14125a == null) {
                this.f14125a = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.f14125a.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f14125a);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f14125a, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f14125a;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (menuView = this.mMenuView)) {
                ((ViewGroup) menuView).removeView(this.f14125a);
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f14128d);
    }
}
