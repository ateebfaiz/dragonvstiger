package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class a extends b0 {

    /* renamed from: h  reason: collision with root package name */
    private final p f2773h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f2774i;

    public a(ReadableMap readableMap, p pVar) {
        this.f2773h = pVar;
        ReadableArray array = readableMap.getArray("input");
        this.f2774i = new int[array.size()];
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2774i;
            if (i10 < iArr.length) {
                iArr[i10] = array.getInt(i10);
                i10++;
            } else {
                return;
            }
        }
    }

    public String e() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdditionAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("]: input nodes: ");
        int[] iArr = this.f2774i;
        if (iArr != null) {
            str = iArr.toString();
        } else {
            str = "null";
        }
        sb2.append(str);
        sb2.append(" - super: ");
        sb2.append(super.e());
        return sb2.toString();
    }

    public void h() {
        this.f2779e = 0.0d;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2774i;
            if (i10 < iArr.length) {
                b k10 = this.f2773h.k(iArr[i10]);
                if (k10 != null && (k10 instanceof b0)) {
                    this.f2779e += ((b0) k10).l();
                    i10++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.Add node");
    }
}
