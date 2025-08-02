package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import wb.e;

public abstract class f extends AbstractMap implements Map, e {
    protected f() {
    }

    public abstract Set a();

    public /* bridge */ Set c() {
        return super.keySet();
    }

    public /* bridge */ int d() {
        return super.size();
    }

    public /* bridge */ Collection e() {
        return super.values();
    }

    public final /* bridge */ Set entrySet() {
        return a();
    }

    public final /* bridge */ Set keySet() {
        return c();
    }

    public final /* bridge */ int size() {
        return d();
    }

    public final /* bridge */ Collection values() {
        return e();
    }
}
