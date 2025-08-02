package com.facebook.react.bridge;

import kotlin.enums.EnumEntries;
import pb.a;

public enum MemoryPressure {
    UI_HIDDEN,
    MODERATE,
    CRITICAL;

    static {
        MemoryPressure[] $values;
        $ENTRIES = a.a($values);
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }
}
