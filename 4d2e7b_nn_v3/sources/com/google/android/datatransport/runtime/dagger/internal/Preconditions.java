package com.google.android.datatransport.runtime.dagger.internal;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void checkBuilderRequirement(T t10, Class<T> cls) {
        if (t10 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T checkNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNull(T t10, String str, Object obj) {
        String str2;
        if (t10 != null) {
            return t10;
        }
        if (!str.contains("%s")) {
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        } else if (str.indexOf("%s") == str.lastIndexOf("%s")) {
            if (obj instanceof Class) {
                str2 = ((Class) obj).getCanonicalName();
            } else {
                str2 = String.valueOf(obj);
            }
            throw new NullPointerException(str.replace("%s", str2));
        } else {
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
    }
}
