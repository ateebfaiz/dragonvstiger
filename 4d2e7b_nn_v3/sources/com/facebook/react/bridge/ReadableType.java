package com.facebook.react.bridge;

import d6.a;
import kotlin.enums.EnumEntries;

@a
public enum ReadableType {
    Null,
    Boolean,
    Number,
    String,
    Map,
    Array;

    static {
        ReadableType[] $values;
        $ENTRIES = pb.a.a($values);
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }
}
