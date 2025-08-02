package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import wb.b;

public abstract class g extends AbstractSet implements Set, b {
    protected g() {
    }

    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
