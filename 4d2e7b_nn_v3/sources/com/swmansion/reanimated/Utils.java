package com.swmansion.reanimated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static boolean isChromeDebugger;

    public static Runnable combineRunnables(final Runnable... runnableArr) {
        return new Runnable() {
            public void run() {
                for (Runnable run : runnableArr) {
                    run.run();
                }
            }
        };
    }

    public static float convertToFloat(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).floatValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).floatValue();
        }
        return 0.0f;
    }

    public static int[] processIntArray(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = readableArray.getInt(i10);
        }
        return iArr;
    }

    public static Map<String, Integer> processMapping(ReadableMap readableMap) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, Integer.valueOf(readableMap.getInt(nextKey)));
        }
        return hashMap;
    }

    public static String simplifyStringNumbersList(String str) {
        return str.replace(",", "").replace("[", "").replace("]", "");
    }
}
