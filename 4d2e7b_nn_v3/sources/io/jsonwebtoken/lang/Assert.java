package io.jsonwebtoken.lang;

import java.util.Collection;
import java.util.Map;

public final class Assert {
    private Assert() {
    }

    public static void doesNotContain(String str, String str2, String str3) {
        if (Strings.hasLength(str) && Strings.hasLength(str2) && str.indexOf(str2) != -1) {
            throw new IllegalArgumentException(str3);
        }
    }

    public static void hasLength(String str, String str2) {
        if (!Strings.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void hasText(String str, String str2) {
        if (!Strings.hasText(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void isAssignable(Class cls, Class cls2) {
        isAssignable(cls, cls2, "");
    }

    public static void isInstanceOf(Class cls, Object obj) {
        isInstanceOf(cls, obj, "");
    }

    public static void isNull(Object obj, String str) {
        if (obj != null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void noNullElements(Object[] objArr, String str) {
        if (objArr != null) {
            int i10 = 0;
            while (i10 < objArr.length) {
                if (objArr[i10] != null) {
                    i10++;
                } else {
                    throw new IllegalArgumentException(str);
                }
            }
        }
    }

    public static void notEmpty(Object[] objArr, String str) {
        if (Objects.isEmpty(objArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void state(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    public static void isAssignable(Class cls, Class cls2, String str) {
        notNull(cls, "Type to check against must not be null");
        if (cls2 == null || !cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(str + cls2 + " is not assignable to " + cls);
        }
    }

    public static void isInstanceOf(Class cls, Object obj, String str) {
        notNull(cls, "Type to check against must not be null");
        if (!cls.isInstance(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("Object of class [");
            sb2.append(obj != null ? obj.getClass().getName() : "null");
            sb2.append("] must be an instance of ");
            sb2.append(cls);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static void isNull(Object obj) {
        isNull(obj, "[Assertion failed] - the object argument must be null");
    }

    public static void isTrue(boolean z10) {
        isTrue(z10, "[Assertion failed] - this expression must be true");
    }

    public static void notNull(Object obj) {
        notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void state(boolean z10) {
        state(z10, "[Assertion failed] - this state invariant must be true");
    }

    public static void doesNotContain(String str, String str2) {
        doesNotContain(str, str2, "[Assertion failed] - this String argument must not contain the substring [" + str2 + "]");
    }

    public static void hasLength(String str) {
        hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String str) {
        hasText(str, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void notEmpty(Object[] objArr) {
        notEmpty(objArr, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] objArr) {
        noNullElements(objArr, "[Assertion failed] - this array must not contain any null elements");
    }

    public static void notEmpty(byte[] bArr, String str) {
        if (Objects.isEmpty(bArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection collection, String str) {
        if (Collections.isEmpty(collection)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map map, String str) {
        if (Collections.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }
}
