package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Unit;
import kotlin.collections.g0;
import kotlin.collections.h0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i10) {
        if (sparseLongArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i10) {
        if (sparseLongArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j10) {
        if (sparseLongArray.indexOfValue(j10) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        int size = sparseLongArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i10)), Long.valueOf(sparseLongArray.valueAt(i10)));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i10, long j10) {
        return sparseLongArray.get(i10, j10);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i10, Function0<Long> function0) {
        int indexOfKey = sparseLongArray.indexOfKey(i10);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return ((Number) function0.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final g0 keyIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i10), sparseLongArray2.valueAt(i10));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i10, long j10) {
        int indexOfKey = sparseLongArray.indexOfKey(i10);
        if (indexOfKey < 0 || j10 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i10, long j10) {
        sparseLongArray.put(i10, j10);
    }

    public static final h0 valueIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
