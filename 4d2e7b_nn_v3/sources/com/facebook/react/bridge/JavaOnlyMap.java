package com.facebook.react.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaOnlyMap implements ReadableMap, WritableMap {
    /* access modifiers changed from: private */
    public final Map mBackingMap;

    /* renamed from: com.facebook.react.bridge.JavaOnlyMap$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JavaOnlyMap.AnonymousClass2.<clinit>():void");
        }
    }

    private JavaOnlyMap(Object... objArr) {
        if (objArr.length % 2 == 0) {
            this.mBackingMap = new HashMap();
            for (int i10 = 0; i10 < objArr.length; i10 += 2) {
                Double d10 = objArr[i10 + 1];
                if (d10 instanceof Number) {
                    d10 = Double.valueOf(d10.doubleValue());
                }
                this.mBackingMap.put(objArr[i10], d10);
            }
            return;
        }
        throw new IllegalArgumentException("You must provide the same number of keys and values");
    }

    public static JavaOnlyMap deepClone(ReadableMap readableMap) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    javaOnlyMap.putNull(nextKey);
                    break;
                case 2:
                    javaOnlyMap.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    javaOnlyMap.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    javaOnlyMap.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    javaOnlyMap.putMap(nextKey, deepClone(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    javaOnlyMap.putArray(nextKey, JavaOnlyArray.deepClone(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return javaOnlyMap;
    }

    public static JavaOnlyMap from(Map<String, Object> map) {
        return new JavaOnlyMap(map);
    }

    public static JavaOnlyMap of(Object... objArr) {
        return new JavaOnlyMap(objArr);
    }

    public WritableMap copy() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.merge(this);
        return javaOnlyMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Map map = this.mBackingMap;
        Map map2 = ((JavaOnlyMap) obj).mBackingMap;
        if (map == null ? map2 == null : map.equals(map2)) {
            return true;
        }
        return false;
    }

    public ReadableArray getArray(@NonNull String str) {
        return (ReadableArray) this.mBackingMap.get(str);
    }

    public boolean getBoolean(@NonNull String str) {
        return ((Boolean) this.mBackingMap.get(str)).booleanValue();
    }

    public double getDouble(@NonNull String str) {
        return ((Number) this.mBackingMap.get(str)).doubleValue();
    }

    @NonNull
    public Dynamic getDynamic(@NonNull String str) {
        return DynamicFromMap.create(this, str);
    }

    @NonNull
    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        return this.mBackingMap.entrySet().iterator();
    }

    public int getInt(@NonNull String str) {
        return ((Number) this.mBackingMap.get(str)).intValue();
    }

    public long getLong(@NonNull String str) {
        return ((Number) Preconditions.checkNotNull(this.mBackingMap.get(str))).longValue();
    }

    public ReadableMap getMap(@NonNull String str) {
        return (ReadableMap) this.mBackingMap.get(str);
    }

    public String getString(@NonNull String str) {
        return (String) this.mBackingMap.get(str);
    }

    @NonNull
    public ReadableType getType(@NonNull String str) {
        Object obj = this.mBackingMap.get(str);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        throw new IllegalArgumentException("Invalid value " + obj.toString() + " for key " + str + "contained in JavaOnlyMap");
    }

    public boolean hasKey(@NonNull String str) {
        return this.mBackingMap.containsKey(str);
    }

    public int hashCode() {
        Map map = this.mBackingMap;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public boolean isNull(@NonNull String str) {
        if (this.mBackingMap.get(str) == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator() {
            Iterator<Map.Entry<String, Object>> mIterator;

            {
                this.mIterator = JavaOnlyMap.this.mBackingMap.entrySet().iterator();
            }

            public boolean hasNextKey() {
                return this.mIterator.hasNext();
            }

            public String nextKey() {
                return (String) this.mIterator.next().getKey();
            }
        };
    }

    public void merge(@NonNull ReadableMap readableMap) {
        this.mBackingMap.putAll(((JavaOnlyMap) readableMap).mBackingMap);
    }

    public void putArray(@NonNull String str, @Nullable ReadableArray readableArray) {
        this.mBackingMap.put(str, readableArray);
    }

    public void putBoolean(@NonNull String str, boolean z10) {
        this.mBackingMap.put(str, Boolean.valueOf(z10));
    }

    public void putDouble(@NonNull String str, double d10) {
        this.mBackingMap.put(str, Double.valueOf(d10));
    }

    public void putInt(@NonNull String str, int i10) {
        this.mBackingMap.put(str, new Double((double) i10));
    }

    public void putLong(@NonNull String str, long j10) {
        this.mBackingMap.put(str, Long.valueOf(j10));
    }

    public void putMap(@NonNull String str, @Nullable ReadableMap readableMap) {
        this.mBackingMap.put(str, readableMap);
    }

    public void putNull(@NonNull String str) {
        this.mBackingMap.put(str, (Object) null);
    }

    public void putString(@NonNull String str, @Nullable String str2) {
        this.mBackingMap.put(str, str2);
    }

    @NonNull
    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this.mBackingMap);
    }

    public String toString() {
        return this.mBackingMap.toString();
    }

    public JavaOnlyMap() {
        this.mBackingMap = new HashMap();
    }
}
