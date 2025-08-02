package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import wb.d;

public abstract class e extends AbstractList implements List, d {
    protected e() {
    }

    public abstract int a();

    public abstract Object c(int i10);

    public final /* bridge */ Object remove(int i10) {
        return c(i10);
    }

    public final /* bridge */ int size() {
        return a();
    }
}
