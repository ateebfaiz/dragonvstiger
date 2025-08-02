package kotlin.collections;

import java.util.Iterator;
import wb.a;

public abstract class h0 implements Iterator, a {
    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
