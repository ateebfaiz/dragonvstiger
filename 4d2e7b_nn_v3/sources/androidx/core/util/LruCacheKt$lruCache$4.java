package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import vb.o;

public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ Function1<K, V> $create;
    final /* synthetic */ o $onEntryRemoved;
    final /* synthetic */ Function2<K, V, Integer> $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i10, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, o oVar) {
        super(i10);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = oVar;
    }

    /* access modifiers changed from: protected */
    public V create(K k10) {
        return this.$create.invoke(k10);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z10, K k10, V v10, V v11) {
        this.$onEntryRemoved.invoke(Boolean.valueOf(z10), k10, v10, v11);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k10, V v10) {
        return ((Number) this.$sizeOf.invoke(k10, v10)).intValue();
    }
}
