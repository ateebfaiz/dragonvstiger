package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Unit;
import kotlin.collections.g0;
import kotlin.collections.p;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i10) {
        if (sparseBooleanArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i10) {
        if (sparseBooleanArray.indexOfKey(i10) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (sparseBooleanArray.indexOfValue(z10) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i10)), Boolean.valueOf(sparseBooleanArray.valueAt(i10)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        return sparseBooleanArray.get(i10, z10);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i10, Function0<Boolean> function0) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (indexOfKey >= 0) {
            return sparseBooleanArray.valueAt(indexOfKey);
        }
        return ((Boolean) function0.invoke()).booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final g0 keyIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i10), sparseBooleanArray2.valueAt(i10));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (indexOfKey < 0 || z10 != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i10);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        sparseBooleanArray.put(i10, z10);
    }

    public static final p valueIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
