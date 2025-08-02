package kotlin.collections;

import java.util.Iterator;
import wb.a;

public abstract class q implements Iterator, a {
    public abstract char a();

    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
