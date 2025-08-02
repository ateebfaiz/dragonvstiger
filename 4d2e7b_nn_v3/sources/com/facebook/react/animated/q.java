package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

class q extends b {

    /* renamed from: e  reason: collision with root package name */
    private final p f2846e;

    /* renamed from: f  reason: collision with root package name */
    private final JavaOnlyMap f2847f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2848a;

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
                f2848a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2848a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2848a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2848a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2848a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2848a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.q.a.<clinit>():void");
        }
    }

    q(ReadableMap readableMap, p pVar) {
        this.f2847f = JavaOnlyMap.deepClone(readableMap);
        this.f2846e = pVar;
    }

    private JavaOnlyArray j(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            switch (a.f2848a[readableArray.getType(i10).ordinal()]) {
                case 1:
                    javaOnlyArray.pushNull();
                    break;
                case 2:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i10));
                    break;
                case 3:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i10));
                    break;
                case 4:
                    javaOnlyArray.pushString(readableArray.getString(i10));
                    break;
                case 5:
                    ReadableMap map = readableArray.getMap(i10);
                    if (!map.hasKey("nodeTag") || map.getType("nodeTag") != ReadableType.Number) {
                        javaOnlyArray.pushMap(k(readableArray.getMap(i10)));
                        break;
                    } else {
                        b k10 = this.f2846e.k(map.getInt("nodeTag"));
                        if (k10 != null) {
                            if (!(k10 instanceof b0)) {
                                if (!(k10 instanceof f)) {
                                    break;
                                } else {
                                    javaOnlyArray.pushInt(((f) k10).i());
                                    break;
                                }
                            } else {
                                b0 b0Var = (b0) k10;
                                Object k11 = b0Var.k();
                                if (!(k11 instanceof Integer)) {
                                    if (!(k11 instanceof String)) {
                                        javaOnlyArray.pushDouble(b0Var.l());
                                        break;
                                    } else {
                                        javaOnlyArray.pushString((String) k11);
                                        break;
                                    }
                                } else {
                                    javaOnlyArray.pushInt(((Integer) k11).intValue());
                                    break;
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                    }
                case 6:
                    javaOnlyArray.pushArray(j(readableArray.getArray(i10)));
                    break;
            }
        }
        return javaOnlyArray;
    }

    private JavaOnlyMap k(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (a.f2848a[readableMap.getType(nextKey).ordinal()]) {
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
                    ReadableMap map = readableMap.getMap(nextKey);
                    if (map == null || !map.hasKey("nodeTag") || map.getType("nodeTag") != ReadableType.Number) {
                        javaOnlyMap.putMap(nextKey, k(map));
                        break;
                    } else {
                        b k10 = this.f2846e.k(map.getInt("nodeTag"));
                        if (k10 != null) {
                            if (!(k10 instanceof b0)) {
                                if (!(k10 instanceof f)) {
                                    break;
                                } else {
                                    javaOnlyMap.putInt(nextKey, ((f) k10).i());
                                    break;
                                }
                            } else {
                                b0 b0Var = (b0) k10;
                                Object k11 = b0Var.k();
                                if (!(k11 instanceof Integer)) {
                                    if (!(k11 instanceof String)) {
                                        javaOnlyMap.putDouble(nextKey, b0Var.l());
                                        break;
                                    } else {
                                        javaOnlyMap.putString(nextKey, (String) k11);
                                        break;
                                    }
                                } else {
                                    javaOnlyMap.putInt(nextKey, ((Integer) k11).intValue());
                                    break;
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                    }
                case 6:
                    javaOnlyMap.putArray(nextKey, j(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return javaOnlyMap;
    }

    public String e() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ObjectAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("]: mConfig: ");
        JavaOnlyMap javaOnlyMap = this.f2847f;
        if (javaOnlyMap != null) {
            str = javaOnlyMap.toString();
        } else {
            str = "null";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void i(String str, JavaOnlyMap javaOnlyMap) {
        ReadableType type = this.f2847f.getType("value");
        if (type == ReadableType.Map) {
            javaOnlyMap.putMap(str, k(this.f2847f.getMap("value")));
        } else if (type == ReadableType.Array) {
            javaOnlyMap.putArray(str, j(this.f2847f.getArray("value")));
        } else {
            throw new IllegalArgumentException("Invalid value type for ObjectAnimatedNode");
        }
    }
}
