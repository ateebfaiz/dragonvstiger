package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class Preconditions {
    public static void checkArgument(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static void checkState(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
