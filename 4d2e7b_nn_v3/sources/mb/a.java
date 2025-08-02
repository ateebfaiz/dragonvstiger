package mb;

import java.util.Map;
import kotlin.collections.g;
import kotlin.jvm.internal.m;

public abstract class a extends g {
    public final boolean c(Map.Entry entry) {
        m.f(entry, "element");
        return d(entry);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return c((Map.Entry) obj);
    }

    public abstract boolean d(Map.Entry entry);

    public /* bridge */ boolean e(Map.Entry entry) {
        return super.remove(entry);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return e((Map.Entry) obj);
    }
}
