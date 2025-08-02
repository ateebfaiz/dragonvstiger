package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

public abstract class e implements c2 {

    /* renamed from: a  reason: collision with root package name */
    protected final f f3579a;

    public e(f fVar) {
        this.f3579a = fVar;
    }

    public void a(View view, String str, ReadableArray readableArray) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.view.View r7, java.lang.String r8, java.lang.Object r9) {
        /*
            r6 = this;
            r8.hashCode()
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r2 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            r4 = -1
            int r5 = r8.hashCode()
            switch(r5) {
                case -1721943862: goto L_0x01a2;
                case -1721943861: goto L_0x0197;
                case -1589741021: goto L_0x018c;
                case -1267206133: goto L_0x0181;
                case -1228066334: goto L_0x0176;
                case -908189618: goto L_0x016b;
                case -908189617: goto L_0x0160;
                case -877170387: goto L_0x0155;
                case -781597262: goto L_0x0147;
                case -731417480: goto L_0x0139;
                case -101663499: goto L_0x012b;
                case -101359900: goto L_0x011d;
                case -80891667: goto L_0x010f;
                case -40300674: goto L_0x0101;
                case -4379043: goto L_0x00f3;
                case 3506294: goto L_0x00e5;
                case 36255470: goto L_0x00d7;
                case 333432965: goto L_0x00c9;
                case 581268560: goto L_0x00bb;
                case 588239831: goto L_0x00ad;
                case 746986311: goto L_0x009f;
                case 1052666732: goto L_0x0091;
                case 1146842694: goto L_0x0083;
                case 1153872867: goto L_0x0075;
                case 1287124693: goto L_0x0067;
                case 1349188574: goto L_0x0059;
                case 1505602511: goto L_0x004b;
                case 1761903244: goto L_0x003d;
                case 1865277756: goto L_0x002f;
                case 1993034687: goto L_0x0021;
                case 2045685618: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x01ac
        L_0x0013:
            java.lang.String r5 = "nativeID"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x001d
            goto L_0x01ac
        L_0x001d:
            r4 = 30
            goto L_0x01ac
        L_0x0021:
            java.lang.String r5 = "accessibilityCollectionItem"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x002b
            goto L_0x01ac
        L_0x002b:
            r4 = 29
            goto L_0x01ac
        L_0x002f:
            java.lang.String r5 = "accessibilityLabelledBy"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0039
            goto L_0x01ac
        L_0x0039:
            r4 = 28
            goto L_0x01ac
        L_0x003d:
            java.lang.String r5 = "accessibilityCollection"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0047
            goto L_0x01ac
        L_0x0047:
            r4 = 27
            goto L_0x01ac
        L_0x004b:
            java.lang.String r5 = "accessibilityActions"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0055
            goto L_0x01ac
        L_0x0055:
            r4 = 26
            goto L_0x01ac
        L_0x0059:
            java.lang.String r5 = "borderRadius"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0063
            goto L_0x01ac
        L_0x0063:
            r4 = 25
            goto L_0x01ac
        L_0x0067:
            java.lang.String r5 = "backgroundColor"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0071
            goto L_0x01ac
        L_0x0071:
            r4 = 24
            goto L_0x01ac
        L_0x0075:
            java.lang.String r5 = "accessibilityState"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x007f
            goto L_0x01ac
        L_0x007f:
            r4 = 23
            goto L_0x01ac
        L_0x0083:
            java.lang.String r5 = "accessibilityLabel"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x008d
            goto L_0x01ac
        L_0x008d:
            r4 = 22
            goto L_0x01ac
        L_0x0091:
            java.lang.String r5 = "transform"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x009b
            goto L_0x01ac
        L_0x009b:
            r4 = 21
            goto L_0x01ac
        L_0x009f:
            java.lang.String r5 = "importantForAccessibility"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00a9
            goto L_0x01ac
        L_0x00a9:
            r4 = 20
            goto L_0x01ac
        L_0x00ad:
            java.lang.String r5 = "borderBottomRightRadius"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00b7
            goto L_0x01ac
        L_0x00b7:
            r4 = 19
            goto L_0x01ac
        L_0x00bb:
            java.lang.String r5 = "borderBottomLeftRadius"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00c5
            goto L_0x01ac
        L_0x00c5:
            r4 = 18
            goto L_0x01ac
        L_0x00c9:
            java.lang.String r5 = "borderTopRightRadius"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00d3
            goto L_0x01ac
        L_0x00d3:
            r4 = 17
            goto L_0x01ac
        L_0x00d7:
            java.lang.String r5 = "accessibilityLiveRegion"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00e1
            goto L_0x01ac
        L_0x00e1:
            r4 = 16
            goto L_0x01ac
        L_0x00e5:
            java.lang.String r5 = "role"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00ef
            goto L_0x01ac
        L_0x00ef:
            r4 = 15
            goto L_0x01ac
        L_0x00f3:
            java.lang.String r5 = "elevation"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x00fd
            goto L_0x01ac
        L_0x00fd:
            r4 = 14
            goto L_0x01ac
        L_0x0101:
            java.lang.String r5 = "rotation"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x010b
            goto L_0x01ac
        L_0x010b:
            r4 = 13
            goto L_0x01ac
        L_0x010f:
            java.lang.String r5 = "renderToHardwareTextureAndroid"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0119
            goto L_0x01ac
        L_0x0119:
            r4 = 12
            goto L_0x01ac
        L_0x011d:
            java.lang.String r5 = "accessibilityRole"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0127
            goto L_0x01ac
        L_0x0127:
            r4 = 11
            goto L_0x01ac
        L_0x012b:
            java.lang.String r5 = "accessibilityHint"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0135
            goto L_0x01ac
        L_0x0135:
            r4 = 10
            goto L_0x01ac
        L_0x0139:
            java.lang.String r5 = "zIndex"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0143
            goto L_0x01ac
        L_0x0143:
            r4 = 9
            goto L_0x01ac
        L_0x0147:
            java.lang.String r5 = "transformOrigin"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0151
            goto L_0x01ac
        L_0x0151:
            r4 = 8
            goto L_0x01ac
        L_0x0155:
            java.lang.String r5 = "testID"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x015e
            goto L_0x01ac
        L_0x015e:
            r4 = 7
            goto L_0x01ac
        L_0x0160:
            java.lang.String r5 = "scaleY"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0169
            goto L_0x01ac
        L_0x0169:
            r4 = 6
            goto L_0x01ac
        L_0x016b:
            java.lang.String r5 = "scaleX"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0174
            goto L_0x01ac
        L_0x0174:
            r4 = 5
            goto L_0x01ac
        L_0x0176:
            java.lang.String r5 = "borderTopLeftRadius"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x017f
            goto L_0x01ac
        L_0x017f:
            r4 = 4
            goto L_0x01ac
        L_0x0181:
            java.lang.String r5 = "opacity"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x018a
            goto L_0x01ac
        L_0x018a:
            r4 = 3
            goto L_0x01ac
        L_0x018c:
            java.lang.String r5 = "shadowColor"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0195
            goto L_0x01ac
        L_0x0195:
            r4 = 2
            goto L_0x01ac
        L_0x0197:
            java.lang.String r5 = "translateY"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x01a0
            goto L_0x01ac
        L_0x01a0:
            r4 = 1
            goto L_0x01ac
        L_0x01a2:
            java.lang.String r5 = "translateX"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            r4 = r1
        L_0x01ac:
            switch(r4) {
                case 0: goto L_0x0331;
                case 1: goto L_0x0322;
                case 2: goto L_0x030d;
                case 3: goto L_0x02fe;
                case 4: goto L_0x02ef;
                case 5: goto L_0x02e0;
                case 6: goto L_0x02d1;
                case 7: goto L_0x02c8;
                case 8: goto L_0x02bf;
                case 9: goto L_0x02af;
                case 10: goto L_0x02a6;
                case 11: goto L_0x029d;
                case 12: goto L_0x028d;
                case 13: goto L_0x027d;
                case 14: goto L_0x026d;
                case 15: goto L_0x0264;
                case 16: goto L_0x025b;
                case 17: goto L_0x024b;
                case 18: goto L_0x023b;
                case 19: goto L_0x022b;
                case 20: goto L_0x0222;
                case 21: goto L_0x0219;
                case 22: goto L_0x0210;
                case 23: goto L_0x0207;
                case 24: goto L_0x01f1;
                case 25: goto L_0x01e1;
                case 26: goto L_0x01d8;
                case 27: goto L_0x01cf;
                case 28: goto L_0x01c3;
                case 29: goto L_0x01ba;
                case 30: goto L_0x01b1;
                default: goto L_0x01af;
            }
        L_0x01af:
            goto L_0x033f
        L_0x01b1:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setNativeId(r7, r9)
            goto L_0x033f
        L_0x01ba:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setAccessibilityCollectionItem(r7, r9)
            goto L_0x033f
        L_0x01c3:
            com.facebook.react.bridge.DynamicFromObject r8 = new com.facebook.react.bridge.DynamicFromObject
            r8.<init>(r9)
            com.facebook.react.uimanager.f r9 = r6.f3579a
            r9.setAccessibilityLabelledBy(r7, r8)
            goto L_0x033f
        L_0x01cf:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setAccessibilityCollection(r7, r9)
            goto L_0x033f
        L_0x01d8:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setAccessibilityActions(r7, r9)
            goto L_0x033f
        L_0x01e1:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x01e6
            goto L_0x01ec
        L_0x01e6:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x01ec:
            r8.setBorderRadius(r7, r3)
            goto L_0x033f
        L_0x01f1:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x01f6
            goto L_0x0202
        L_0x01f6:
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            int r1 = r9.intValue()
        L_0x0202:
            r8.setBackgroundColor(r7, r1)
            goto L_0x033f
        L_0x0207:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setViewState(r7, r9)
            goto L_0x033f
        L_0x0210:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setAccessibilityLabel(r7, r9)
            goto L_0x033f
        L_0x0219:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setTransform(r7, r9)
            goto L_0x033f
        L_0x0222:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setImportantForAccessibility(r7, r9)
            goto L_0x033f
        L_0x022b:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0230
            goto L_0x0236
        L_0x0230:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0236:
            r8.setBorderBottomRightRadius(r7, r3)
            goto L_0x033f
        L_0x023b:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0240
            goto L_0x0246
        L_0x0240:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0246:
            r8.setBorderBottomLeftRadius(r7, r3)
            goto L_0x033f
        L_0x024b:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0250
            goto L_0x0256
        L_0x0250:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0256:
            r8.setBorderTopRightRadius(r7, r3)
            goto L_0x033f
        L_0x025b:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setAccessibilityLiveRegion(r7, r9)
            goto L_0x033f
        L_0x0264:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setRole(r7, r9)
            goto L_0x033f
        L_0x026d:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0272
            goto L_0x0278
        L_0x0272:
            java.lang.Double r9 = (java.lang.Double) r9
            float r2 = r9.floatValue()
        L_0x0278:
            r8.setElevation(r7, r2)
            goto L_0x033f
        L_0x027d:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0282
            goto L_0x0288
        L_0x0282:
            java.lang.Double r9 = (java.lang.Double) r9
            float r2 = r9.floatValue()
        L_0x0288:
            r8.setRotation(r7, r2)
            goto L_0x033f
        L_0x028d:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0292
            goto L_0x0298
        L_0x0292:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x0298:
            r8.setRenderToHardwareTexture(r7, r1)
            goto L_0x033f
        L_0x029d:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setAccessibilityRole(r7, r9)
            goto L_0x033f
        L_0x02a6:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setAccessibilityHint(r7, r9)
            goto L_0x033f
        L_0x02af:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x02b4
            goto L_0x02ba
        L_0x02b4:
            java.lang.Double r9 = (java.lang.Double) r9
            float r2 = r9.floatValue()
        L_0x02ba:
            r8.setZIndex(r7, r2)
            goto L_0x033f
        L_0x02bf:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setTransformOrigin(r7, r9)
            goto L_0x033f
        L_0x02c8:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            java.lang.String r9 = (java.lang.String) r9
            r8.setTestId(r7, r9)
            goto L_0x033f
        L_0x02d1:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x02d6
            goto L_0x02dc
        L_0x02d6:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02dc:
            r8.setScaleY(r7, r0)
            goto L_0x033f
        L_0x02e0:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x02e5
            goto L_0x02eb
        L_0x02e5:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02eb:
            r8.setScaleX(r7, r0)
            goto L_0x033f
        L_0x02ef:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x02f4
            goto L_0x02fa
        L_0x02f4:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x02fa:
            r8.setBorderTopLeftRadius(r7, r3)
            goto L_0x033f
        L_0x02fe:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0303
            goto L_0x0309
        L_0x0303:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0309:
            r8.setOpacity(r7, r0)
            goto L_0x033f
        L_0x030d:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0312
            goto L_0x031e
        L_0x0312:
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            int r1 = r9.intValue()
        L_0x031e:
            r8.setShadowColor(r7, r1)
            goto L_0x033f
        L_0x0322:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0327
            goto L_0x032d
        L_0x0327:
            java.lang.Double r9 = (java.lang.Double) r9
            float r2 = r9.floatValue()
        L_0x032d:
            r8.setTranslateY(r7, r2)
            goto L_0x033f
        L_0x0331:
            com.facebook.react.uimanager.f r8 = r6.f3579a
            if (r9 != 0) goto L_0x0336
            goto L_0x033c
        L_0x0336:
            java.lang.Double r9 = (java.lang.Double) r9
            float r2 = r9.floatValue()
        L_0x033c:
            r8.setTranslateX(r7, r2)
        L_0x033f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.e.b(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
