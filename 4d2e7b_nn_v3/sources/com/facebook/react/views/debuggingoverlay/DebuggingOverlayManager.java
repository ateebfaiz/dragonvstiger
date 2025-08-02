package com.facebook.react.views.debuggingoverlay;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.e1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "DebuggingOverlay")
public final class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "DebuggingOverlay";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public DebuggingOverlay createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new DebuggingOverlay(e1Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0184 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.debuggingoverlay.DebuggingOverlay r21, java.lang.String r22, com.facebook.react.bridge.ReadableArray r23) {
        /*
            r20 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            java.lang.String r3 = "view"
            kotlin.jvm.internal.m.f(r1, r3)
            java.lang.String r3 = "commandId"
            kotlin.jvm.internal.m.f(r0, r3)
            int r3 = r22.hashCode()
            r4 = -1942063165(0xffffffff8c3e77c3, float:-1.4673107E-31)
            java.lang.String r5 = "DebuggingOverlay"
            if (r3 == r4) goto L_0x018c
            r4 = 1326903961(0x4f16f299, float:2.53248128E9)
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            java.lang.String r8 = "y"
            java.lang.String r9 = "x"
            r11 = 0
            if (r3 == r4) goto L_0x00c0
            r4 = 1385348555(0x5292bdcb, float:3.15124711E11)
            if (r3 == r4) goto L_0x0031
        L_0x002e:
            r3 = r5
            goto L_0x0195
        L_0x0031:
            java.lang.String r3 = "highlightElements"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x003a
            goto L_0x002e
        L_0x003a:
            if (r2 != 0) goto L_0x003d
            return
        L_0x003d:
            com.facebook.react.bridge.ReadableArray r2 = r2.getArray(r11)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r2.size()
            r12 = r11
            r0 = 1
        L_0x004c:
            if (r12 >= r4) goto L_0x00b7
            com.facebook.react.bridge.ReadableMap r13 = r2.getMap(r12)
            double r14 = r13.getDouble(r9)     // Catch:{ Exception -> 0x0090 }
            float r14 = (float) r14     // Catch:{ Exception -> 0x0090 }
            double r10 = r13.getDouble(r8)     // Catch:{ Exception -> 0x0090 }
            float r10 = (float) r10
            r11 = r8
            r16 = r9
            double r8 = (double) r14
            double r17 = r13.getDouble(r7)     // Catch:{ Exception -> 0x008c }
            double r8 = r8 + r17
            float r8 = (float) r8
            r22 = r2
            double r1 = (double) r10
            double r17 = r13.getDouble(r6)     // Catch:{ Exception -> 0x008a }
            double r1 = r1 + r17
            float r1 = (float) r1     // Catch:{ Exception -> 0x008a }
            android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ Exception -> 0x008a }
            float r9 = com.facebook.react.uimanager.g0.d(r14)     // Catch:{ Exception -> 0x008a }
            float r10 = com.facebook.react.uimanager.g0.d(r10)     // Catch:{ Exception -> 0x008a }
            float r8 = com.facebook.react.uimanager.g0.d(r8)     // Catch:{ Exception -> 0x008a }
            float r1 = com.facebook.react.uimanager.g0.d(r1)     // Catch:{ Exception -> 0x008a }
            r2.<init>(r9, r10, r8, r1)     // Catch:{ Exception -> 0x008a }
            r3.add(r2)     // Catch:{ Exception -> 0x008a }
            goto L_0x00ab
        L_0x008a:
            r0 = move-exception
            goto L_0x0096
        L_0x008c:
            r0 = move-exception
            r22 = r2
            goto L_0x0096
        L_0x0090:
            r0 = move-exception
            r22 = r2
            r11 = r8
            r16 = r9
        L_0x0096:
            boolean r1 = r0 instanceof com.facebook.react.bridge.NoSuchKeyException
            if (r1 == 0) goto L_0x009c
            r1 = 1
            goto L_0x009e
        L_0x009c:
            boolean r1 = r0 instanceof com.facebook.react.bridge.UnexpectedNativeTypeException
        L_0x009e:
            if (r1 == 0) goto L_0x00b6
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r1 = "Unexpected payload for highlighting elements: every element should have x, y, width, height fields"
            r0.<init>((java.lang.String) r1)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r5, r0)
            r0 = 0
        L_0x00ab:
            int r12 = r12 + 1
            r1 = r21
            r2 = r22
            r8 = r11
            r9 = r16
            r11 = 0
            goto L_0x004c
        L_0x00b6:
            throw r0
        L_0x00b7:
            if (r0 == 0) goto L_0x01a3
            r1 = r21
            r1.setHighlightedElementsRectangles(r3)
            goto L_0x01a3
        L_0x00c0:
            r11 = r8
            r16 = r9
            java.lang.String r3 = "highlightTraceUpdates"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x002e
            if (r2 != 0) goto L_0x00ce
            return
        L_0x00ce:
            r3 = 0
            com.facebook.react.bridge.ReadableArray r2 = r2.getArray(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r8 = r2.size()
            r9 = r3
            r0 = 1
        L_0x00de:
            if (r9 >= r8) goto L_0x0185
            com.facebook.react.bridge.ReadableMap r10 = r2.getMap(r9)
            java.lang.String r12 = "rectangle"
            com.facebook.react.bridge.ReadableMap r12 = r10.getMap(r12)
            if (r12 != 0) goto L_0x00f9
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r2 = "Unexpected payload for highlighting trace updates: rectangle field is null"
            r0.<init>((java.lang.String) r2)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r5, r0)
            r11 = r3
            goto L_0x0186
        L_0x00f9:
            java.lang.String r13 = "id"
            int r13 = r10.getInt(r13)
            java.lang.String r14 = "color"
            int r10 = r10.getInt(r14)
            r22 = r4
            r14 = r16
            double r3 = r12.getDouble(r14)     // Catch:{ Exception -> 0x015c }
            float r3 = (float) r3
            r16 = r14
            double r14 = r12.getDouble(r11)     // Catch:{ Exception -> 0x0157 }
            float r14 = (float) r14
            r15 = r5
            double r4 = (double) r3
            double r17 = r12.getDouble(r7)     // Catch:{ Exception -> 0x0150 }
            double r4 = r4 + r17
            float r4 = (float) r4
            r5 = r7
            r17 = r8
            double r7 = (double) r14
            double r18 = r12.getDouble(r6)     // Catch:{ Exception -> 0x014c }
            double r7 = r7 + r18
            float r7 = (float) r7     // Catch:{ Exception -> 0x014c }
            android.graphics.RectF r8 = new android.graphics.RectF     // Catch:{ Exception -> 0x014c }
            float r3 = com.facebook.react.uimanager.g0.d(r3)     // Catch:{ Exception -> 0x014c }
            float r12 = com.facebook.react.uimanager.g0.d(r14)     // Catch:{ Exception -> 0x014c }
            float r4 = com.facebook.react.uimanager.g0.d(r4)     // Catch:{ Exception -> 0x014c }
            float r7 = com.facebook.react.uimanager.g0.d(r7)     // Catch:{ Exception -> 0x014c }
            r8.<init>(r3, r12, r4, r7)     // Catch:{ Exception -> 0x014c }
            r7.b r3 = new r7.b     // Catch:{ Exception -> 0x014c }
            r3.<init>(r13, r8, r10)     // Catch:{ Exception -> 0x014c }
            r4 = r22
            r4.add(r3)     // Catch:{ Exception -> 0x014a }
            r3 = r15
            goto L_0x017b
        L_0x014a:
            r0 = move-exception
            goto L_0x0165
        L_0x014c:
            r0 = move-exception
            r4 = r22
            goto L_0x0165
        L_0x0150:
            r0 = move-exception
            r4 = r22
        L_0x0153:
            r5 = r7
            r17 = r8
            goto L_0x0165
        L_0x0157:
            r0 = move-exception
            r4 = r22
            r15 = r5
            goto L_0x0153
        L_0x015c:
            r0 = move-exception
            r4 = r22
            r15 = r5
            r5 = r7
            r17 = r8
            r16 = r14
        L_0x0165:
            boolean r3 = r0 instanceof com.facebook.react.bridge.NoSuchKeyException
            if (r3 == 0) goto L_0x016b
            r3 = 1
            goto L_0x016d
        L_0x016b:
            boolean r3 = r0 instanceof com.facebook.react.bridge.UnexpectedNativeTypeException
        L_0x016d:
            if (r3 == 0) goto L_0x0184
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r3 = "Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"
            r0.<init>((java.lang.String) r3)
            r3 = r15
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r3, r0)
            r0 = 0
        L_0x017b:
            int r9 = r9 + 1
            r7 = r5
            r8 = r17
            r5 = r3
            r3 = 0
            goto L_0x00de
        L_0x0184:
            throw r0
        L_0x0185:
            r11 = r0
        L_0x0186:
            if (r11 == 0) goto L_0x01a3
            r1.setTraceUpdates(r4)
            goto L_0x01a3
        L_0x018c:
            r3 = r5
            java.lang.String r2 = "clearElementsHighlights"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01a0
        L_0x0195:
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r1 = "Received unexpected command in DebuggingOverlayManager"
            r0.<init>((java.lang.String) r1)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r3, r0)
            goto L_0x01a3
        L_0x01a0:
            r21.b()
        L_0x01a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager.receiveCommand(com.facebook.react.views.debuggingoverlay.DebuggingOverlay, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
