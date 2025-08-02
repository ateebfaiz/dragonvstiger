package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenuItem;

public final class MenuItemCompat {
    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    class a implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnActionExpandListener f15158a;

        a(OnActionExpandListener onActionExpandListener) {
            this.f15158a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f15158a.onMenuItemActionCollapse(menuItem);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f15158a.onMenuItemActionExpand(menuItem);
        }
    }

    static class b {
        @DoNotInline
        static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @DoNotInline
        static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @DoNotInline
        static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @DoNotInline
        static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @DoNotInline
        static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @DoNotInline
        static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @DoNotInline
        static MenuItem g(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        @DoNotInline
        static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        @DoNotInline
        static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        @DoNotInline
        static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        @DoNotInline
        static MenuItem k(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        @DoNotInline
        static MenuItem l(MenuItem menuItem, char c10, char c11, int i10, int i11) {
            return menuItem.setShortcut(c10, c11, i10, i11);
        }

        @DoNotInline
        static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Nullable
    public static ActionProvider getActionProvider(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence getContentDescription(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.b(menuItem);
        }
        return null;
    }

    @Nullable
    public static ColorStateList getIconTintList(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.c(menuItem);
        }
        return null;
    }

    @Nullable
    public static PorterDuff.Mode getIconTintMode(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.d(menuItem);
        }
        return null;
    }

    public static int getNumericModifiers(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.e(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence getTooltipText(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.f(menuItem);
        }
        return null;
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem setActionProvider(@NonNull MenuItem menuItem, @Nullable ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(@NonNull MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.g(menuItem, c10, i10);
        }
    }

    public static void setContentDescription(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.h(menuItem, charSequence);
        }
    }

    public static void setIconTintList(@NonNull MenuItem menuItem, @Nullable ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.i(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(@NonNull MenuItem menuItem, @Nullable PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.j(menuItem, mode);
        }
    }

    public static void setNumericShortcut(@NonNull MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.k(menuItem, c10, i10);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new a(onActionExpandListener));
    }

    public static void setShortcut(@NonNull MenuItem menuItem, char c10, char c11, int i10, int i11) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c10, c11, i10, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.l(menuItem, c10, c11, i10, i11);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i10) {
        menuItem.setShowAsAction(i10);
    }

    public static void setTooltipText(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.m(menuItem, charSequence);
        }
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i10) {
        return menuItem.setActionView(i10);
    }
}
