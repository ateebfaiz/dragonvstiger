package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY = new Builder().build();
    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = Logger.tagWithPrefix("Data");
    Map<String, Object> mValues;

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        @NonNull
        public Data build() {
            Data data = new Data((Map<String, ?>) this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder put(@NonNull String str, @Nullable Object obj) {
            if (obj == null) {
                this.mValues.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.mValues.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.mValues.put(str, Data.convertPrimitiveBooleanArray((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.mValues.put(str, Data.convertPrimitiveByteArray((byte[]) obj));
                } else if (cls == int[].class) {
                    this.mValues.put(str, Data.convertPrimitiveIntArray((int[]) obj));
                } else if (cls == long[].class) {
                    this.mValues.put(str, Data.convertPrimitiveLongArray((long[]) obj));
                } else if (cls == float[].class) {
                    this.mValues.put(str, Data.convertPrimitiveFloatArray((float[]) obj));
                } else if (cls == double[].class) {
                    this.mValues.put(str, Data.convertPrimitiveDoubleArray((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Data data) {
            putAll(data.mValues);
            return this;
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z10) {
            this.mValues.put(str, Boolean.valueOf(z10));
            return this;
        }

        @NonNull
        public Builder putBooleanArray(@NonNull String str, @NonNull boolean[] zArr) {
            this.mValues.put(str, Data.convertPrimitiveBooleanArray(zArr));
            return this;
        }

        @NonNull
        public Builder putByte(@NonNull String str, byte b10) {
            this.mValues.put(str, Byte.valueOf(b10));
            return this;
        }

        @NonNull
        public Builder putByteArray(@NonNull String str, @NonNull byte[] bArr) {
            this.mValues.put(str, Data.convertPrimitiveByteArray(bArr));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d10) {
            this.mValues.put(str, Double.valueOf(d10));
            return this;
        }

        @NonNull
        public Builder putDoubleArray(@NonNull String str, @NonNull double[] dArr) {
            this.mValues.put(str, Data.convertPrimitiveDoubleArray(dArr));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f10) {
            this.mValues.put(str, Float.valueOf(f10));
            return this;
        }

        @NonNull
        public Builder putFloatArray(@NonNull String str, @NonNull float[] fArr) {
            this.mValues.put(str, Data.convertPrimitiveFloatArray(fArr));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i10) {
            this.mValues.put(str, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public Builder putIntArray(@NonNull String str, @NonNull int[] iArr) {
            this.mValues.put(str, Data.convertPrimitiveIntArray(iArr));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j10) {
            this.mValues.put(str, Long.valueOf(j10));
            return this;
        }

        @NonNull
        public Builder putLongArray(@NonNull String str, @NonNull long[] jArr) {
            this.mValues.put(str, Data.convertPrimitiveLongArray(jArr));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @Nullable String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        @NonNull
        public Builder putStringArray(@NonNull String str, @NonNull String[] strArr) {
            this.mValues.put(str, strArr);
            return this;
        }

        @NonNull
        public Builder putAll(@NonNull Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }
    }

    Data() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Boolean[] convertPrimitiveBooleanArray(@NonNull boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Byte[] convertPrimitiveByteArray(@NonNull byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Double[] convertPrimitiveDoubleArray(@NonNull double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Float[] convertPrimitiveFloatArray(@NonNull float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Integer[] convertPrimitiveIntArray(@NonNull int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Long[] convertPrimitiveLongArray(@NonNull long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean[] convertToPrimitiveArray(@NonNull Boolean[] boolArr) {
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[SYNTHETIC, Splitter:B:36:0x006d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0062=Splitter:B:31:0x0062, B:16:0x003b=Splitter:B:16:0x003b} */
    @androidx.room.TypeConverter
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data fromByteArray(@androidx.annotation.NonNull byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L_0x0082
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0046 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0046 }
            int r7 = r3.readInt()     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002d }
        L_0x001b:
            if (r7 <= 0) goto L_0x0031
            java.lang.String r4 = r3.readUTF()     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002d }
            java.lang.Object r5 = r3.readObject()     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002d }
            r1.put(r4, r5)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002d }
            int r7 = r7 + -1
            goto L_0x001b
        L_0x002b:
            r7 = move-exception
            goto L_0x006b
        L_0x002d:
            r7 = move-exception
            goto L_0x0051
        L_0x002f:
            r7 = move-exception
            goto L_0x0051
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x003b
        L_0x0035:
            r7 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r7)
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0065
        L_0x003f:
            r7 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r7)
            goto L_0x0065
        L_0x0046:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L_0x006b
        L_0x004a:
            r3 = move-exception
        L_0x004b:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L_0x0051
        L_0x004f:
            r3 = move-exception
            goto L_0x004b
        L_0x0051:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x002b }
            android.util.Log.e(r4, r0, r7)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0062
            r3.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x005c:
            r7 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r7)
        L_0x0062:
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x0065:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>((java.util.Map<java.lang.String, ?>) r1)
            return r7
        L_0x006b:
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0077
        L_0x0071:
            r1 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r1)
        L_0x0077:
            r2.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x0081
        L_0x007b:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x0081:
            throw r7
        L_0x0082:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[SYNTHETIC, Splitter:B:31:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f A[SYNTHETIC, Splitter:B:41:0x008f] */
    @androidx.room.TypeConverter
    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArrayInternal(@androidx.annotation.NonNull androidx.work.Data r5) {
        /*
            java.lang.String r0 = "Error in Data#toByteArray: "
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x006c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x006c }
            int r2 = r5.size()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeInt(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r5.mValues     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
        L_0x001e:
            boolean r2 = r5.hasNext()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            if (r2 == 0) goto L_0x0041
            java.lang.Object r2 = r5.next()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.Object r4 = r2.getKey()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeUTF(r4)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.writeObject(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            goto L_0x001e
        L_0x003b:
            r5 = move-exception
            r2 = r3
            goto L_0x008d
        L_0x003e:
            r5 = move-exception
            r2 = r3
            goto L_0x006d
        L_0x0041:
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x004b
        L_0x0045:
            r5 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r5)
        L_0x004b:
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0055
        L_0x004f:
            r5 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r5)
        L_0x0055:
            int r5 = r1.size()
            r0 = 10240(0x2800, float:1.4349E-41)
            if (r5 > r0) goto L_0x0062
            byte[] r5 = r1.toByteArray()
            return r5
        L_0x0062:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        L_0x006a:
            r5 = move-exception
            goto L_0x008d
        L_0x006c:
            r5 = move-exception
        L_0x006d:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x006a }
            android.util.Log.e(r3, r0, r5)     // Catch:{ all -> 0x006a }
            byte[] r5 = r1.toByteArray()     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r2 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r2)
        L_0x0082:
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x008c:
            return r5
        L_0x008d:
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0099
        L_0x0093:
            r2 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r2)
        L_0x0099:
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a3
        L_0x009d:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x00a3:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.toByteArrayInternal(androidx.work.Data):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.mValues.get(next);
            Object obj3 = data.mValues.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z10 = obj2.equals(obj3);
                continue;
            } else {
                z10 = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(@NonNull String str, boolean z10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return z10;
    }

    @Nullable
    public boolean[] getBooleanArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Boolean[]) {
            return convertToPrimitiveArray((Boolean[]) obj);
        }
        return null;
    }

    public byte getByte(@NonNull String str, byte b10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Byte) {
            return ((Byte) obj).byteValue();
        }
        return b10;
    }

    @Nullable
    public byte[] getByteArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Byte[]) {
            return convertToPrimitiveArray((Byte[]) obj);
        }
        return null;
    }

    public double getDouble(@NonNull String str, double d10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return d10;
    }

    @Nullable
    public double[] getDoubleArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Double[]) {
            return convertToPrimitiveArray((Double[]) obj);
        }
        return null;
    }

    public float getFloat(@NonNull String str, float f10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return f10;
    }

    @Nullable
    public float[] getFloatArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Float[]) {
            return convertToPrimitiveArray((Float[]) obj);
        }
        return null;
    }

    public int getInt(@NonNull String str, int i10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i10;
    }

    @Nullable
    public int[] getIntArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Integer[]) {
            return convertToPrimitiveArray((Integer[]) obj);
        }
        return null;
    }

    @NonNull
    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(@NonNull String str, long j10) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return j10;
    }

    @Nullable
    public long[] getLongArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Long[]) {
            return convertToPrimitiveArray((Long[]) obj);
        }
        return null;
    }

    @Nullable
    public String getString(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Nullable
    public String[] getStringArray(@NonNull String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public <T> boolean hasKeyWithValueOfType(@NonNull String str, @NonNull Class<T> cls) {
        Object obj = this.mValues.get(str);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int size() {
        return this.mValues.size();
    }

    @NonNull
    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String next : this.mValues.keySet()) {
                sb2.append(next);
                sb2.append(" : ");
                Object obj = this.mValues.get(next);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public Data(@NonNull Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Data(@NonNull Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static byte[] convertToPrimitiveArray(@NonNull Byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = bArr[i10].byteValue();
        }
        return bArr2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int[] convertToPrimitiveArray(@NonNull Integer[] numArr) {
        int[] iArr = new int[numArr.length];
        for (int i10 = 0; i10 < numArr.length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static long[] convertToPrimitiveArray(@NonNull Long[] lArr) {
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static float[] convertToPrimitiveArray(@NonNull Float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static double[] convertToPrimitiveArray(@NonNull Double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }
}
