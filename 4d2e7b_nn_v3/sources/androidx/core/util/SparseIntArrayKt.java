package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Unit;
import kotlin.collections.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i10) {
        if (sparseIntArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i10) {
        if (sparseIntArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i10) {
        if (sparseIntArray.indexOfValue(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        int size = sparseIntArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i10)), Integer.valueOf(sparseIntArray.valueAt(i10)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i10, int i11) {
        return sparseIntArray.get(i10, i11);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i10, Function0<Integer> function0) {
        int indexOfKey = sparseIntArray.indexOfKey(i10);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return ((Number) function0.invoke()).intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final g0 keyIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i10), sparseIntArray2.valueAt(i10));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i10, int i11) {
        int indexOfKey = sparseIntArray.indexOfKey(i10);
        if (indexOfKey < 0 || i11 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i10, int i11) {
        sparseIntArray.put(i10, i11);
    }

    public static final g0 valueIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
