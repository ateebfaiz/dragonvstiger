package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    /* access modifiers changed from: package-private */
    public float getFloatValue(Object obj, String str, int i10) {
        if (!this.map.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap hashMap = this.map.get(obj);
        if (!hashMap.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = (float[]) hashMap.get(str);
        if (fArr.length > i10) {
            return fArr[i10];
        }
        return Float.NaN;
    }

    /* access modifiers changed from: package-private */
    public void setFloatValue(Object obj, String str, int i10, float f10) {
        if (!this.map.containsKey(obj)) {
            HashMap hashMap = new HashMap();
            float[] fArr = new float[(i10 + 1)];
            fArr[i10] = f10;
            hashMap.put(str, fArr);
            this.map.put(obj, hashMap);
            return;
        }
        HashMap hashMap2 = this.map.get(obj);
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[(i10 + 1)];
            fArr2[i10] = f10;
            hashMap2.put(str, fArr2);
            this.map.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = (float[]) hashMap2.get(str);
        if (fArr3.length <= i10) {
            fArr3 = Arrays.copyOf(fArr3, i10 + 1);
        }
        fArr3[i10] = f10;
        hashMap2.put(str, fArr3);
    }
}
