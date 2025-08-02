package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class i extends b0 {

    /* renamed from: h  reason: collision with root package name */
    private final p f2806h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f2807i;

    public i(ReadableMap readableMap, p pVar) {
        this.f2806h = pVar;
        ReadableArray array = readableMap.getArray("input");
        this.f2807i = new int[array.size()];
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2807i;
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
        sb2.append("DivisionAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("]: input nodes: ");
        int[] iArr = this.f2807i;
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
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2807i;
            if (i10 < iArr.length) {
                b k10 = this.f2806h.k(iArr[i10]);
                if (k10 == null || !(k10 instanceof b0)) {
                } else {
                    double l10 = ((b0) k10).l();
                    if (i10 == 0) {
                        this.f2779e = l10;
                    } else if (l10 != 0.0d) {
                        this.f2779e /= l10;
                    } else {
                        throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node with Animated ID " + this.f2778d);
                    }
                    i10++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node with Animated ID " + this.f2778d);
    }
}
