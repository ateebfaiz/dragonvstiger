package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.h0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j10) {
        if (longSparseArray.indexOfKey(j10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j10) {
        if (longSparseArray.indexOfKey(j10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t10) {
        if (longSparseArray.indexOfValue(t10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i10)), longSparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j10, T t10) {
        T t11 = longSparseArray.get(j10);
        if (t11 == null) {
            return t10;
        }
        return t11;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j10, Function0<? extends T> function0) {
        T t10 = longSparseArray.get(j10);
        if (t10 == null) {
            return function0.invoke();
        }
        return t10;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> h0 keyIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            longSparseArray.put(longSparseArray2.keyAt(i10), longSparseArray2.valueAt(i10));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j10, T t10) {
        int indexOfKey = longSparseArray.indexOfKey(j10);
        if (indexOfKey < 0 || !m.b(t10, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j10, T t10) {
        longSparseArray.put(j10, t10);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
