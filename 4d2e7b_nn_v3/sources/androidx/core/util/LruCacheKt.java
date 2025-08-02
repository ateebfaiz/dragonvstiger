package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import vb.o;

public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i10, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, o oVar) {
        return new LruCacheKt$lruCache$4(i10, function2, function1, oVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i10, Function2 function2, Function1 function1, o oVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function2 = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            function1 = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            oVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        return new LruCacheKt$lruCache$4(i10, function2, function1, oVar);
    }
}
