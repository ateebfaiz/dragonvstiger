package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {

    /* renamed from: id  reason: collision with root package name */
    private int f8364id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended = false;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f8365a;

        /* renamed from: b  reason: collision with root package name */
        ParcelableSparseArray f8366b;

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
            parcel.writeInt(this.f8365a);
            parcel.writeParcelable(this.f8366b, 0);
        }

        SavedState(Parcel parcel) {
            this.f8365a = parcel.readInt();
            this.f8366b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public boolean collapseItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f8364id;
    }

    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup viewGroup) {
        return this.menuView;
    }

    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    public void onCloseMenu(@Nullable MenuBuilder menuBuilder, boolean z10) {
    }

    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.f8365a);
            this.menuView.restoreBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.f8366b));
        }
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f8365a = this.menuView.getSelectedItemId();
        savedState.f8366b = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    public boolean onSubMenuSelected(@Nullable SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(@Nullable MenuPresenter.Callback callback) {
    }

    public void setId(int i10) {
        this.f8364id = i10;
    }

    public void setMenuView(@NonNull NavigationBarMenuView navigationBarMenuView) {
        this.menuView = navigationBarMenuView;
    }

    public void setUpdateSuspended(boolean z10) {
        this.updateSuspended = z10;
    }

    public void updateMenuView(boolean z10) {
        if (!this.updateSuspended) {
            if (z10) {
                this.menuView.buildMenuView();
            } else {
                this.menuView.updateMenuView();
            }
        }
    }
}
