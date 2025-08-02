package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {

    static class a {
        @DoNotInline
        static void a(Menu menu, boolean z10) {
            menu.setGroupDividerEnabled(z10);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu menu, boolean z10) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z10);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z10);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i10) {
        menuItem.setShowAsAction(i10);
    }
}
