package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import wb.a;

public final class ViewGroupKt$iterator$1 implements Iterator<View>, a {
    final /* synthetic */ ViewGroup $this_iterator;
    private int index;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.$this_iterator = viewGroup;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.getChildCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        ViewGroup viewGroup = this.$this_iterator;
        int i10 = this.index - 1;
        this.index = i10;
        viewGroup.removeViewAt(i10);
    }

    public View next() {
        ViewGroup viewGroup = this.$this_iterator;
        int i10 = this.index;
        this.index = i10 + 1;
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
