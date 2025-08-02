package p7;

import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.e;

public class p extends e {
    public p(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.view.View r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            r0 = 1
            r1 = 0
            r2 = -1
            int r3 = r6.hashCode()
            switch(r3) {
                case -2143114526: goto L_0x0078;
                case -1609594047: goto L_0x006d;
                case -775297261: goto L_0x0062;
                case 722830999: goto L_0x0057;
                case 737768677: goto L_0x004c;
                case 741115130: goto L_0x0041;
                case 1387411372: goto L_0x0036;
                case 1686617758: goto L_0x002b;
                case 1825644485: goto L_0x001d;
                case 1984457027: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0082
        L_0x000f:
            java.lang.String r3 = "foreground"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0019
            goto L_0x0082
        L_0x0019:
            r2 = 9
            goto L_0x0082
        L_0x001d:
            java.lang.String r3 = "borderless"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0027
            goto L_0x0082
        L_0x0027:
            r2 = 8
            goto L_0x0082
        L_0x002b:
            java.lang.String r3 = "exclusive"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0034
            goto L_0x0082
        L_0x0034:
            r2 = 7
            goto L_0x0082
        L_0x0036:
            java.lang.String r3 = "touchSoundDisabled"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x003f
            goto L_0x0082
        L_0x003f:
            r2 = 6
            goto L_0x0082
        L_0x0041:
            java.lang.String r3 = "borderWidth"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x004a
            goto L_0x0082
        L_0x004a:
            r2 = 5
            goto L_0x0082
        L_0x004c:
            java.lang.String r3 = "borderStyle"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0055
            goto L_0x0082
        L_0x0055:
            r2 = 4
            goto L_0x0082
        L_0x0057:
            java.lang.String r3 = "borderColor"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0060
            goto L_0x0082
        L_0x0060:
            r2 = 3
            goto L_0x0082
        L_0x0062:
            java.lang.String r3 = "rippleColor"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            r2 = 2
            goto L_0x0082
        L_0x006d:
            java.lang.String r3 = "enabled"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            r2 = r0
            goto L_0x0082
        L_0x0078:
            java.lang.String r3 = "rippleRadius"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r2 = r1
        L_0x0082:
            switch(r2) {
                case 0: goto L_0x0136;
                case 1: goto L_0x0123;
                case 2: goto L_0x0111;
                case 3: goto L_0x00ff;
                case 4: goto L_0x00ee;
                case 5: goto L_0x00da;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00b2;
                case 8: goto L_0x009e;
                case 9: goto L_0x008a;
                default: goto L_0x0085;
            }
        L_0x0085:
            super.b(r5, r6, r7)
            goto L_0x0148
        L_0x008a:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x0093
            goto L_0x0099
        L_0x0093:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0099:
            r6.setForeground(r5, r1)
            goto L_0x0148
        L_0x009e:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x00a7
            goto L_0x00ad
        L_0x00a7:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00ad:
            r6.setBorderless(r5, r1)
            goto L_0x0148
        L_0x00b2:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r0 = r7.booleanValue()
        L_0x00c1:
            r6.setExclusive(r5, r0)
            goto L_0x0148
        L_0x00c6:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00d5:
            r6.setTouchSoundDisabled(r5, r1)
            goto L_0x0148
        L_0x00da:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x00e4
            r7 = 0
            goto L_0x00ea
        L_0x00e4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r7 = r7.floatValue()
        L_0x00ea:
            r6.setBorderWidth(r5, r7)
            goto L_0x0148
        L_0x00ee:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x00f9
            java.lang.String r7 = "solid"
            goto L_0x00fb
        L_0x00f9:
            java.lang.String r7 = (java.lang.String) r7
        L_0x00fb:
            r6.setBorderStyle(r5, r7)
            goto L_0x0148
        L_0x00ff:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBorderColor(r5, r7)
            goto L_0x0148
        L_0x0111:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setRippleColor(r5, r7)
            goto L_0x0148
        L_0x0123:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x012c
            goto L_0x0132
        L_0x012c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r0 = r7.booleanValue()
        L_0x0132:
            r6.setEnabled(r5, r0)
            goto L_0x0148
        L_0x0136:
            com.facebook.react.uimanager.f r6 = r4.f3579a
            com.facebook.react.uimanager.BaseViewManager r6 = (com.facebook.react.uimanager.BaseViewManager) r6
            p7.q r6 = (p7.q) r6
            if (r7 != 0) goto L_0x013f
            goto L_0x0145
        L_0x013f:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x0145:
            r6.setRippleRadius(r5, r1)
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.p.b(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
