package io.jsonwebtoken.lang;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class Objects {
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";
    private static final String ARRAY_END = "}";
    private static final String ARRAY_START = "{";
    private static final String EMPTY_ARRAY = "{}";
    private static final String EMPTY_STRING = "";
    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;
    private static final String NULL_STRING = "null";

    private Objects() {
    }

    public static <A, O extends A> A[] addObjectToArray(A[] aArr, O o10) {
        Class cls;
        int i10;
        if (aArr != null) {
            cls = aArr.getClass().getComponentType();
        } else if (o10 != null) {
            cls = o10.getClass();
        } else {
            cls = Object.class;
        }
        if (aArr != null) {
            i10 = aArr.length + 1;
        } else {
            i10 = 1;
        }
        Object[] objArr = (Object[]) Array.newInstance(cls, i10);
        if (aArr != null) {
            System.arraycopy(aArr, 0, objArr, 0, aArr.length);
        }
        objArr[objArr.length - 1] = o10;
        return objArr;
    }

    public static <E extends Enum<?>> E caseInsensitiveValueOf(E[] eArr, String str) {
        for (E e10 : eArr) {
            if (e10.toString().equalsIgnoreCase(str)) {
                return e10;
            }
        }
        throw new IllegalArgumentException(String.format("constant [%s] does not exist in enum type %s", new Object[]{str, eArr.getClass().getComponentType().getName()}));
    }

    public static boolean containsConstant(Enum<?>[] enumArr, String str) {
        return containsConstant(enumArr, str, false);
    }

    public static boolean containsElement(Object[] objArr, Object obj) {
        if (objArr == null) {
            return false;
        }
        for (Object nullSafeEquals : objArr) {
            if (nullSafeEquals(nullSafeEquals, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String getDisplayString(Object obj) {
        if (obj == null) {
            return "";
        }
        return nullSafeToString(obj);
    }

    public static String getIdentityHexString(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static int hashCode(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.getClass().getName() + "@" + getIdentityHexString(obj);
    }

    public static boolean isArray(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return false;
        }
        return true;
    }

    public static boolean isCheckedException(Throwable th) {
        if ((th instanceof RuntimeException) || (th instanceof Error)) {
            return false;
        }
        return true;
    }

    public static boolean isCompatibleWithThrowsClause(Throwable th, Class[] clsArr) {
        if (!isCheckedException(th)) {
            return true;
        }
        if (clsArr != null) {
            for (Class isAssignableFrom : clsArr) {
                if (isAssignableFrom.isAssignableFrom(th.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static String nullSafeClassName(Object obj) {
        if (obj != null) {
            return obj.getClass().getName();
        }
        return NULL_STRING;
    }

    public static void nullSafeClose(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    public static boolean nullSafeEquals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (!(obj == null || obj2 == null)) {
            if (obj.equals(obj2)) {
                return true;
            }
            if (obj.getClass().isArray() && obj2.getClass().isArray()) {
                if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                    return Arrays.equals((Object[]) obj, (Object[]) obj2);
                }
                if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                    return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
                }
                if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                    return Arrays.equals((byte[]) obj, (byte[]) obj2);
                }
                if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                    return Arrays.equals((char[]) obj, (char[]) obj2);
                }
                if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                    return Arrays.equals((double[]) obj, (double[]) obj2);
                }
                if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                    return Arrays.equals((float[]) obj, (float[]) obj2);
                }
                if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                    return Arrays.equals((int[]) obj, (int[]) obj2);
                }
                if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                    return Arrays.equals((long[]) obj, (long[]) obj2);
                }
                if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                    return Arrays.equals((short[]) obj, (short[]) obj2);
                }
            }
        }
        return false;
    }

    public static int nullSafeHashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return nullSafeHashCode((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return nullSafeHashCode((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return nullSafeHashCode((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return nullSafeHashCode((char[]) obj);
            }
            if (obj instanceof double[]) {
                return nullSafeHashCode((double[]) obj);
            }
            if (obj instanceof float[]) {
                return nullSafeHashCode((float[]) obj);
            }
            if (obj instanceof int[]) {
                return nullSafeHashCode((int[]) obj);
            }
            if (obj instanceof long[]) {
                return nullSafeHashCode((long[]) obj);
            }
            if (obj instanceof short[]) {
                return nullSafeHashCode((short[]) obj);
            }
        }
        return obj.hashCode();
    }

    public static String nullSafeToString(Object obj) {
        if (obj == null) {
            return NULL_STRING;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Object[]) {
            return nullSafeToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return nullSafeToString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return nullSafeToString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return nullSafeToString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return nullSafeToString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return nullSafeToString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return nullSafeToString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return nullSafeToString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return nullSafeToString((short[]) obj);
        }
        String obj2 = obj.toString();
        return obj2 != null ? obj2 : "";
    }

    public static Object[] toObjectArray(Object obj) {
        if (obj instanceof Object[]) {
            return (Object[]) obj;
        }
        if (obj == null) {
            return new Object[0];
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (length == 0) {
                return new Object[0];
            }
            Object[] objArr = (Object[]) Array.newInstance(Array.get(obj, 0).getClass(), length);
            for (int i10 = 0; i10 < length; i10++) {
                objArr[i10] = Array.get(obj, i10);
            }
            return objArr;
        }
        throw new IllegalArgumentException("Source is not an array: " + obj);
    }

    public static boolean containsConstant(Enum<?>[] enumArr, String str, boolean z10) {
        for (Enum<?> enumR : enumArr) {
            String str2 = enumR.toString();
            if (z10) {
                if (str2.equals(str)) {
                    return true;
                }
            } else if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static int hashCode(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static int hashCode(double d10) {
        return hashCode(Double.doubleToLongBits(d10));
    }

    public static int hashCode(float f10) {
        return Float.floatToIntBits(f10);
    }

    public static int nullSafeHashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int i10 = 7;
        for (Object nullSafeHashCode : objArr) {
            i10 = (i10 * MULTIPLIER) + nullSafeHashCode(nullSafeHashCode);
        }
        return i10;
    }

    public static int nullSafeHashCode(boolean[] zArr) {
        if (zArr == null) {
            return 0;
        }
        int i10 = 7;
        for (boolean hashCode : zArr) {
            i10 = (i10 * MULTIPLIER) + hashCode(hashCode);
        }
        return i10;
    }

    public static String nullSafeToString(Object[] objArr) {
        if (objArr == null) {
            return NULL_STRING;
        }
        int length = objArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(String.valueOf(objArr[i10]));
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static int nullSafeHashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int i10 = 7;
        for (byte b10 : bArr) {
            i10 = (i10 * MULTIPLIER) + b10;
        }
        return i10;
    }

    public static int nullSafeHashCode(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int i10 = 7;
        for (char c10 : cArr) {
            i10 = (i10 * MULTIPLIER) + c10;
        }
        return i10;
    }

    public static int nullSafeHashCode(double[] dArr) {
        if (dArr == null) {
            return 0;
        }
        int i10 = 7;
        for (double hashCode : dArr) {
            i10 = (i10 * MULTIPLIER) + hashCode(hashCode);
        }
        return i10;
    }

    public static int nullSafeHashCode(float[] fArr) {
        if (fArr == null) {
            return 0;
        }
        int i10 = 7;
        for (float hashCode : fArr) {
            i10 = (i10 * MULTIPLIER) + hashCode(hashCode);
        }
        return i10;
    }

    public static int nullSafeHashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i10 = 7;
        for (int i11 : iArr) {
            i10 = (i10 * MULTIPLIER) + i11;
        }
        return i10;
    }

    public static String nullSafeToString(boolean[] zArr) {
        if (zArr == null) {
            return NULL_STRING;
        }
        int length = zArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(zArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static int nullSafeHashCode(long[] jArr) {
        if (jArr == null) {
            return 0;
        }
        int i10 = 7;
        for (long hashCode : jArr) {
            i10 = (i10 * MULTIPLIER) + hashCode(hashCode);
        }
        return i10;
    }

    public static int nullSafeHashCode(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int i10 = 7;
        for (short s10 : sArr) {
            i10 = (i10 * MULTIPLIER) + s10;
        }
        return i10;
    }

    public static String nullSafeToString(byte[] bArr) {
        if (bArr == null) {
            return NULL_STRING;
        }
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(bArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(char[] cArr) {
        if (cArr == null) {
            return NULL_STRING;
        }
        int length = cArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append("'");
            sb2.append(cArr[i10]);
            sb2.append("'");
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(double[] dArr) {
        if (dArr == null) {
            return NULL_STRING;
        }
        int length = dArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(dArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(float[] fArr) {
        if (fArr == null) {
            return NULL_STRING;
        }
        int length = fArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(fArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(int[] iArr) {
        if (iArr == null) {
            return NULL_STRING;
        }
        int length = iArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(iArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(long[] jArr) {
        if (jArr == null) {
            return NULL_STRING;
        }
        int length = jArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(jArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }

    public static String nullSafeToString(short[] sArr) {
        if (sArr == null) {
            return NULL_STRING;
        }
        int length = sArr.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                sb2.append(ARRAY_START);
            } else {
                sb2.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb2.append(sArr[i10]);
        }
        sb2.append(ARRAY_END);
        return sb2.toString();
    }
}
