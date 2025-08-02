package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import wb.b;

public abstract class d extends AbstractCollection implements Collection, b {
    protected d() {
    }

    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
