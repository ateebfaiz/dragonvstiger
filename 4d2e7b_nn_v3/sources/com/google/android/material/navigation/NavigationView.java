package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_Design_NavigationView;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    @Px
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    /* access modifiers changed from: private */
    public final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;
    @Nullable
    private Path shapeClipPath;
    /* access modifiers changed from: private */
    public final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    class a implements MenuBuilder.Callback {
        a() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
            if (onNavigationItemSelectedListener == null || !onNavigationItemSelectedListener.onNavigationItemSelected(menuItem)) {
                return false;
            }
            return true;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.tmpLocation);
            boolean z14 = true;
            if (NavigationView.this.tmpLocation[1] == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            NavigationView.this.presenter.setBehindStatusBar(z10);
            NavigationView navigationView2 = NavigationView.this;
            if (!z10 || !navigationView2.isTopInsetScrimEnabled()) {
                z11 = false;
            } else {
                z11 = true;
            }
            navigationView2.setDrawTopInsetForeground(z11);
            Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
            if (activity != null) {
                if (activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                NavigationView navigationView3 = NavigationView.this;
                if (!z12 || !z13 || !navigationView3.isBottomInsetScrimEnabled()) {
                    z14 = false;
                }
                navigationView3.setDrawBottomInsetForeground(z14);
            }
        }
    }

    public NavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    @NonNull
    private Drawable createDefaultItemBackground(@NonNull TintTypedArray tintTypedArray) {
        return createDefaultItemDrawable(tintTypedArray, MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
    }

    @NonNull
    private Drawable createDefaultItemDrawable(@NonNull TintTypedArray tintTypedArray, @Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(colorStateList);
        return new InsetDrawable(materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull TintTypedArray tintTypedArray) {
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
            return true;
        }
        return false;
    }

    private void maybeUpdateCornerSizeForDrawerLayout(@Px int i10, @Px int i11) {
        if (!(getParent() instanceof DrawerLayout) || this.drawerLayoutCornerSize <= 0 || !(getBackground() instanceof MaterialShapeDrawable)) {
            this.shapeClipPath = null;
            this.shapeClipBounds.setEmpty();
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        if (GravityCompat.getAbsoluteGravity(this.layoutGravity, ViewCompat.getLayoutDirection(this)) == 3) {
            builder.setTopRightCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomRightCornerSize((float) this.drawerLayoutCornerSize);
        } else {
            builder.setTopLeftCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomLeftCornerSize((float) this.drawerLayoutCornerSize);
        }
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        if (this.shapeClipPath == null) {
            this.shapeClipPath = new Path();
        }
        this.shapeClipPath.reset();
        this.shapeClipBounds.set(0.0f, 0.0f, (float) i10, (float) i11);
        ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
        invalidate();
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View view) {
        this.presenter.addHeaderView(view);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        if (this.shapeClipPath == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.shapeClipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i10) {
        return this.presenter.getHeaderView(i10);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public View inflateHeaderView(@LayoutRes int i10) {
        return this.presenter.inflateHeaderView(i10);
    }

    public void inflateMenu(int i10) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i10, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        maybeUpdateCornerSizeForDrawerLayout(i10, i11);
    }

    public void removeHeaderView(@NonNull View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.bottomInsetScrimEnabled = z10;
    }

    public void setCheckedItem(@IdRes int i10) {
        MenuItem findItem = this.menu.findItem(i10);
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i10) {
        this.presenter.setDividerInsetEnd(i10);
    }

    public void setDividerInsetStart(@Px int i10) {
        this.presenter.setDividerInsetStart(i10);
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        MaterialShapeUtils.setElevation(this, f10);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i10) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setItemHorizontalPadding(@Dimension int i10) {
        this.presenter.setItemHorizontalPadding(i10);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i10) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(@Dimension int i10) {
        this.presenter.setItemIconPadding(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(@Dimension int i10) {
        this.presenter.setItemIconSize(i10);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.presenter.setItemMaxLines(i10);
    }

    public void setItemTextAppearance(@StyleRes int i10) {
        this.presenter.setItemTextAppearance(i10);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i10) {
        this.presenter.setItemVerticalPadding(i10);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i10) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i10);
        }
    }

    public void setSubheaderInsetEnd(@Px int i10) {
        this.presenter.setSubheaderInsetStart(i10);
    }

    public void setSubheaderInsetStart(@Px int i10) {
        this.presenter.setSubheaderInsetStart(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.topInsetScrimEnabled = z10;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        public Bundle menuState;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            com.google.android.material.internal.NavigationMenuPresenter r10 = new com.google.android.material.internal.NavigationMenuPresenter
            r10.<init>()
            r0.presenter = r10
            r1 = 2
            int[] r1 = new int[r1]
            r0.tmpLocation = r1
            r11 = 1
            r0.topInsetScrimEnabled = r11
            r0.bottomInsetScrimEnabled = r11
            r12 = 0
            r0.layoutGravity = r12
            r0.drawerLayoutCornerSize = r12
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.shapeClipBounds = r1
            android.content.Context r13 = r16.getContext()
            com.google.android.material.internal.NavigationMenu r14 = new com.google.android.material.internal.NavigationMenu
            r14.<init>(r13)
            r0.menu = r14
            int[] r3 = com.google.android.material.R.styleable.NavigationView
            int[] r6 = new int[r12]
            r1 = r13
            r2 = r18
            r4 = r19
            r5 = r9
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0058
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
            androidx.core.view.ViewCompat.setBackground(r0, r2)
        L_0x0058:
            int r2 = com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize
            int r2 = r1.getDimensionPixelSize(r2, r12)
            r0.drawerLayoutCornerSize = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_android_layout_gravity
            int r2 = r1.getInt(r2, r12)
            r0.layoutGravity = r2
            android.graphics.drawable.Drawable r2 = r16.getBackground()
            if (r2 == 0) goto L_0x0076
            android.graphics.drawable.Drawable r2 = r16.getBackground()
            boolean r2 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x009e
        L_0x0076:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r13, (android.util.AttributeSet) r7, (int) r8, (int) r9)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            android.graphics.drawable.Drawable r3 = r16.getBackground()
            com.google.android.material.shape.MaterialShapeDrawable r4 = new com.google.android.material.shape.MaterialShapeDrawable
            r4.<init>((com.google.android.material.shape.ShapeAppearanceModel) r2)
            boolean r2 = r3 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x0098
            android.graphics.drawable.ColorDrawable r3 = (android.graphics.drawable.ColorDrawable) r3
            int r2 = r3.getColor()
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r4.setFillColor(r2)
        L_0x0098:
            r4.initializeElevationOverlay(r13)
            androidx.core.view.ViewCompat.setBackground(r0, r4)
        L_0x009e:
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x00b0
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            int r2 = r1.getDimensionPixelSize(r2, r12)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x00b0:
            int r2 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r2 = r1.getBoolean(r2, r12)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r2 = r1.getDimensionPixelSize(r2, r12)
            r0.maxWidth = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            boolean r2 = r1.hasValue(r2)
            r3 = 0
            if (r2 == 0) goto L_0x00d1
            int r2 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            goto L_0x00d2
        L_0x00d1:
            r2 = r3
        L_0x00d2:
            int r4 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            boolean r4 = r1.hasValue(r4)
            if (r4 == 0) goto L_0x00e1
            int r4 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            int r4 = r1.getResourceId(r4, r12)
            goto L_0x00e2
        L_0x00e1:
            r4 = r12
        L_0x00e2:
            r5 = 16842808(0x1010038, float:2.3693715E-38)
            if (r4 != 0) goto L_0x00ed
            if (r2 != 0) goto L_0x00ed
            android.content.res.ColorStateList r2 = r0.createDefaultColorStateList(r5)
        L_0x00ed:
            int r6 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x00fc
            int r5 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            goto L_0x0100
        L_0x00fc:
            android.content.res.ColorStateList r5 = r0.createDefaultColorStateList(r5)
        L_0x0100:
            int r6 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x010f
            int r6 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            int r6 = r1.getResourceId(r6, r12)
            goto L_0x0110
        L_0x010f:
            r6 = r12
        L_0x0110:
            int r7 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r7 = r1.hasValue(r7)
            if (r7 == 0) goto L_0x0121
            int r7 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            int r7 = r1.getDimensionPixelSize(r7, r12)
            r0.setItemIconSize(r7)
        L_0x0121:
            int r7 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r7 = r1.hasValue(r7)
            if (r7 == 0) goto L_0x0130
            int r7 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            android.content.res.ColorStateList r7 = r1.getColorStateList(r7)
            goto L_0x0131
        L_0x0130:
            r7 = r3
        L_0x0131:
            if (r6 != 0) goto L_0x013c
            if (r7 != 0) goto L_0x013c
            r7 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r7 = r0.createDefaultColorStateList(r7)
        L_0x013c:
            int r8 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r8 = r1.getDrawable(r8)
            if (r8 != 0) goto L_0x0166
            boolean r9 = r0.hasShapeAppearance(r1)
            if (r9 == 0) goto L_0x0166
            android.graphics.drawable.Drawable r8 = r0.createDefaultItemBackground(r1)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemRippleColor
            android.content.res.ColorStateList r9 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r9)
            if (r9 == 0) goto L_0x0166
            android.graphics.drawable.Drawable r15 = r0.createDefaultItemDrawable(r1, r3)
            android.graphics.drawable.RippleDrawable r11 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r9 = com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(r9)
            r11.<init>(r9, r3, r15)
            r10.setItemForeground(r11)
        L_0x0166:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0177
            int r3 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setItemHorizontalPadding(r3)
        L_0x0177:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0188
            int r3 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setItemVerticalPadding(r3)
        L_0x0188:
            int r3 = com.google.android.material.R.styleable.NavigationView_dividerInsetStart
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setDividerInsetStart(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_dividerInsetEnd
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setDividerInsetEnd(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_subheaderInsetStart
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setSubheaderInsetStart(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setSubheaderInsetEnd(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled
            boolean r9 = r0.topInsetScrimEnabled
            boolean r3 = r1.getBoolean(r3, r9)
            r0.setTopInsetScrimEnabled(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled
            boolean r9 = r0.bottomInsetScrimEnabled
            boolean r3 = r1.getBoolean(r3, r9)
            r0.setBottomInsetScrimEnabled(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            r11 = 1
            int r9 = r1.getInt(r9, r11)
            r0.setItemMaxLines(r9)
            com.google.android.material.navigation.NavigationView$a r9 = new com.google.android.material.navigation.NavigationView$a
            r9.<init>()
            r14.setCallback(r9)
            r10.setId(r11)
            r10.initForMenu(r13, r14)
            if (r4 == 0) goto L_0x01e5
            r10.setSubheaderTextAppearance(r4)
        L_0x01e5:
            r10.setSubheaderColor(r2)
            r10.setItemIconTintList(r5)
            int r2 = r16.getOverScrollMode()
            r10.setOverScrollMode(r2)
            if (r6 == 0) goto L_0x01f7
            r10.setItemTextAppearance(r6)
        L_0x01f7:
            r10.setItemTextColor(r7)
            r10.setItemBackground(r8)
            r10.setItemIconPadding(r3)
            r14.addMenuPresenter(r10)
            androidx.appcompat.view.menu.MenuView r2 = r10.getMenuView(r0)
            android.view.View r2 = (android.view.View) r2
            r0.addView(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x021d
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            int r2 = r1.getResourceId(r2, r12)
            r0.inflateMenu(r2)
        L_0x021d:
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x022e
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            int r2 = r1.getResourceId(r2, r12)
            r0.inflateHeaderView(r2)
        L_0x022e:
            r1.recycle()
            r16.setupInsetScrimsListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
