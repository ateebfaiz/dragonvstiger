package com.facebook.react.animated;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.q;
import java.util.List;

class EventAnimationDriver implements RCTModernEventEmitter {
    String mEventName;
    private List<String> mEventPath;
    b0 mValueNode;
    int mViewTag;

    public EventAnimationDriver(String str, int i10, List<String> list, b0 b0Var) {
        this.mEventName = str;
        this.mViewTag = i10;
        this.mEventPath = list;
        this.mValueNode = b0Var;
    }

    public void receiveEvent(int i10, String str, @Nullable WritableMap writableMap) {
        receiveEvent(-1, i10, str, writableMap);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    public void receiveEvent(int i10, int i11, String str, @Nullable WritableMap writableMap) {
        receiveEvent(i10, i11, str, false, 0, writableMap, 2);
    }

    public void receiveTouches(q qVar) {
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.facebook.react.bridge.WritableMap, code=com.facebook.react.bridge.ReadableMap, for r7v0, types: [com.facebook.react.bridge.WritableMap] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveEvent(int r2, int r3, java.lang.String r4, boolean r5, int r6, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableMap r7, int r8) {
        /*
            r1 = this;
            if (r7 == 0) goto L_0x00c5
            r2 = 0
            r3 = 0
            r4 = r2
        L_0x0005:
            java.util.List<java.lang.String> r5 = r1.mEventPath
            int r5 = r5.size()
            int r5 = r5 + -1
            if (r3 >= r5) goto L_0x009f
            java.lang.String r5 = "'"
            java.lang.String r6 = "Unexpected type "
            if (r7 == 0) goto L_0x0058
            java.util.List<java.lang.String> r4 = r1.mEventPath
            java.lang.Object r4 = r4.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.react.bridge.ReadableType r8 = r7.getType(r4)
            com.facebook.react.bridge.ReadableType r0 = com.facebook.react.bridge.ReadableType.Map
            if (r8 != r0) goto L_0x002b
            com.facebook.react.bridge.ReadableMap r4 = r7.getMap(r4)
            r5 = r2
            goto L_0x0035
        L_0x002b:
            com.facebook.react.bridge.ReadableType r0 = com.facebook.react.bridge.ReadableType.Array
            if (r8 != r0) goto L_0x0038
            com.facebook.react.bridge.ReadableArray r4 = r7.getArray(r4)
            r5 = r4
            r4 = r2
        L_0x0035:
            r7 = r4
            r4 = r5
            goto L_0x007c
        L_0x0038:
            com.facebook.react.bridge.UnexpectedNativeTypeException r2 = new com.facebook.react.bridge.UnexpectedNativeTypeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r8)
            java.lang.String r6 = " for key '"
            r3.append(r6)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0058:
            java.util.List<java.lang.String> r7 = r1.mEventPath
            java.lang.Object r7 = r7.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            int r7 = java.lang.Integer.parseInt(r7)
            com.facebook.react.bridge.ReadableType r8 = r4.getType(r7)
            com.facebook.react.bridge.ReadableType r0 = com.facebook.react.bridge.ReadableType.Map
            if (r8 != r0) goto L_0x0073
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r7)
            r7 = r4
            r4 = r2
            goto L_0x007c
        L_0x0073:
            com.facebook.react.bridge.ReadableType r0 = com.facebook.react.bridge.ReadableType.Array
            if (r8 != r0) goto L_0x007f
            com.facebook.react.bridge.ReadableArray r4 = r4.getArray(r7)
            r7 = r2
        L_0x007c:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x007f:
            com.facebook.react.bridge.UnexpectedNativeTypeException r2 = new com.facebook.react.bridge.UnexpectedNativeTypeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r8)
            java.lang.String r4 = " for index '"
            r3.append(r4)
            r3.append(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x009f:
            java.util.List<java.lang.String> r2 = r1.mEventPath
            int r3 = r2.size()
            int r3 = r3 + -1
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            if (r7 == 0) goto L_0x00b8
            com.facebook.react.animated.b0 r3 = r1.mValueNode
            double r4 = r7.getDouble(r2)
            r3.f2779e = r4
            goto L_0x00c4
        L_0x00b8:
            int r2 = java.lang.Integer.parseInt(r2)
            com.facebook.react.animated.b0 r3 = r1.mValueNode
            double r4 = r4.getDouble(r2)
            r3.f2779e = r4
        L_0x00c4:
            return
        L_0x00c5:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Native animated events must have event data."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.EventAnimationDriver.receiveEvent(int, int, java.lang.String, boolean, int, com.facebook.react.bridge.WritableMap, int):void");
    }
}
