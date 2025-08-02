package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class v extends b0 {

    /* renamed from: h  reason: collision with root package name */
    private final p f2874h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f2875i;

    public v(ReadableMap readableMap, p pVar) {
        this.f2874h = pVar;
        ReadableArray array = readableMap.getArray("input");
        this.f2875i = new int[array.size()];
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2875i;
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
        sb2.append("SubtractionAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("]: input nodes: ");
        int[] iArr = this.f2875i;
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
            int[] iArr = this.f2875i;
            if (i10 < iArr.length) {
                b k10 = this.f2874h.k(iArr[i10]);
                if (k10 != null && (k10 instanceof b0)) {
                    double l10 = ((b0) k10).l();
                    if (i10 == 0) {
                        this.f2779e = l10;
                    } else {
                        this.f2779e -= l10;
                    }
                    i10++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.subtract node");
    }
}
