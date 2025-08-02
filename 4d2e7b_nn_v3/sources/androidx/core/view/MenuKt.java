package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.sequences.Sequence;

public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (m.b(menu.getItem(i10), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            function1.invoke(menu.getItem(i10));
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Integer.valueOf(i10), menu.getItem(i10));
        }
    }

    public static final MenuItem get(Menu menu, int i10) {
        return menu.getItem(i10);
    }

    public static final Sequence<MenuItem> getChildren(Menu menu) {
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i10) {
        Unit unit;
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.f12577a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
