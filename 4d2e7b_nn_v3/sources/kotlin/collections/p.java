package kotlin.collections;

import java.util.Iterator;
import wb.a;

public abstract class p implements Iterator, a {
    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
