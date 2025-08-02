package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;

public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i10) {
        if (sparseArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i10) {
        if (sparseArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t10) {
        if (sparseArray.indexOfValue(t10) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i10, T t10) {
        T t11 = sparseArray.get(i10);
        if (t11 == null) {
            return t10;
        }
        return t11;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i10, Function0<? extends T> function0) {
        T t10 = sparseArray.get(i10);
        if (t10 == null) {
            return function0.invoke();
        }
        return t10;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> g0 keyIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$keyIterator$1(sparseArray);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(sparseArray2.keyAt(i10), sparseArray2.valueAt(i10));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i10, T t10) {
        int indexOfKey = sparseArray.indexOfKey(i10);
        if (indexOfKey < 0 || !m.b(t10, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i10, T t10) {
        sparseArray.put(i10, t10);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
