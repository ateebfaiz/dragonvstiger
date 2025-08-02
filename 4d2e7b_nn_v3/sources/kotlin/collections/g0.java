package kotlin.collections;

import java.util.Iterator;
import wb.a;

public abstract class g0 implements Iterator, a {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
