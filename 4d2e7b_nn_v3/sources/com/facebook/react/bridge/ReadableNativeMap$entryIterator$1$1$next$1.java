package com.facebook.react.bridge;

import java.util.Map;
import kotlin.jvm.internal.m;
import wb.a;

public final class ReadableNativeMap$entryIterator$1$1$next$1 implements Map.Entry<String, Object>, a {
    final /* synthetic */ int $index;
    final /* synthetic */ String[] $iteratorKeys;
    final /* synthetic */ Object[] $iteratorValues;

    ReadableNativeMap$entryIterator$1$1$next$1(String[] strArr, int i10, Object[] objArr) {
        this.$iteratorKeys = strArr;
        this.$index = i10;
        this.$iteratorValues = objArr;
    }

    public Object getValue() {
        return this.$iteratorValues[this.$index];
    }

    public Object setValue(Object obj) {
        m.f(obj, "newValue");
        throw new UnsupportedOperationException("Can't set a value while iterating over a ReadableNativeMap");
    }

    public String getKey() {
        return this.$iteratorKeys[this.$index];
    }
}
