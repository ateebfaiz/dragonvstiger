package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItem implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public ActionMenuItem(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.mContext = context;
        this.mId = i11;
        this.mGroup = i10;
        this.mOrdering = i13;
        this.mTitle = charSequence;
    }

    private void applyIconTint() {
        Drawable drawable = this.mIconDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasIconTint || this.mHasIconTintMode) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            this.mIconDrawable = wrap;
            Drawable mutate = wrap.mutate();
            this.mIconDrawable = mutate;
            if (this.mHasIconTint) {
                DrawableCompat.setTintList(mutate, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        return this.mIconDrawable;
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mOrdering;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence != null) {
            return charSequence;
        }
        return this.mTitle;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.mIntent;
        if (intent == null) {
            return false;
        }
        this.mContext.startActivity(intent);
        return true;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        if ((this.mFlags & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.mFlags & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.mFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        if ((this.mFlags & 8) == 0) {
            return true;
        }
        return false;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.mFlags = z10 | (this.mFlags & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        int i10;
        int i11 = this.mFlags & -3;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        this.mFlags = i10 | i11;
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        int i10;
        int i11 = this.mFlags & -17;
        if (z10) {
            i10 = 16;
        } else {
            i10 = 0;
        }
        this.mFlags = i10 | i11;
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z10) {
        int i10;
        int i11 = this.mFlags & -5;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        this.mFlags = i10 | i11;
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        applyIconTint();
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.mShortcutNumericChar = c10;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        return this;
    }

    public void setShowAsAction(int i10) {
    }

    @NonNull
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.mFlags & 8;
        if (z10) {
            i10 = 0;
        }
        this.mFlags = i11 | i10;
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c10);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.mShortcutNumericChar = c10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @NonNull
    public SupportMenuItem setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.mTitle = this.mContext.getResources().getString(i10);
        return this;
    }

    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    @NonNull
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setIcon(int i10) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, i10);
        applyIconTint();
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i10);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @NonNull
    public SupportMenuItem setActionView(int i10) {
        throw new UnsupportedOperationException();
    }
}
