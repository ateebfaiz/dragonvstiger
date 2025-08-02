package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    @Nullable
    b mCollections;

    class a extends b {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            ArrayMap.this.clear();
        }

        /* access modifiers changed from: protected */
        public Object b(int i10, int i11) {
            return ArrayMap.this.mArray[(i10 << 1) + i11];
        }

        /* access modifiers changed from: protected */
        public Map c() {
            return ArrayMap.this;
        }

        /* access modifiers changed from: protected */
        public int d() {
            return ArrayMap.this.mSize;
        }

        /* access modifiers changed from: protected */
        public int e(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        /* access modifiers changed from: protected */
        public int f(Object obj) {
            return ArrayMap.this.indexOfValue(obj);
        }

        /* access modifiers changed from: protected */
        public void g(Object obj, Object obj2) {
            ArrayMap.this.put(obj, obj2);
        }

        /* access modifiers changed from: protected */
        public void h(int i10) {
            ArrayMap.this.removeAt(i10);
        }

        /* access modifiers changed from: protected */
        public Object i(int i10, Object obj) {
            return ArrayMap.this.setValueAt(i10, obj);
        }
    }

    public ArrayMap() {
    }

    private b getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new a();
        }
        return this.mCollections;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return b.j(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().l();
    }

    public Set<K> keySet() {
        return getCollection().m();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return b.o(this, collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return b.p(this, collection);
    }

    public Collection<V> values() {
        return getCollection().n();
    }

    public ArrayMap(int i10) {
        super(i10);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
