package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.c> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k10) {
        if (contains(k10)) {
            return this.mHashMap.get(k10).f14402d;
        }
        return null;
    }

    public boolean contains(K k10) {
        return this.mHashMap.containsKey(k10);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public SafeIterableMap.c get(K k10) {
        return this.mHashMap.get(k10);
    }

    public V putIfAbsent(@NonNull K k10, @NonNull V v10) {
        SafeIterableMap.c cVar = get(k10);
        if (cVar != null) {
            return cVar.f14400b;
        }
        this.mHashMap.put(k10, put(k10, v10));
        return null;
    }

    public V remove(@NonNull K k10) {
        V remove = super.remove(k10);
        this.mHashMap.remove(k10);
        return remove;
    }
}
