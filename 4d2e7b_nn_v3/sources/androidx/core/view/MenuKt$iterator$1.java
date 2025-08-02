package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Unit;
import wb.a;

public final class MenuKt$iterator$1 implements Iterator<MenuItem>, a {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.size()) {
            return true;
        }
        return false;
    }

    public void remove() {
        Unit unit;
        Menu menu = this.$this_iterator;
        int i10 = this.index - 1;
        this.index = i10;
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

    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i10 = this.index;
        this.index = i10 + 1;
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
