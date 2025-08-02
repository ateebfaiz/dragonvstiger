package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.adjust.sdk.Constants;
import com.alibaba.fastjson.parser.JSONLexer;
import com.facebook.react.bridge.ReadableArray;
import g6.b;
import java.util.ArrayList;

public abstract class n {
    public static Typeface a(Typeface typeface, int i10, int i11, String str, AssetManager assetManager) {
        b.C0138b bVar = new b.C0138b(i10, i11);
        if (str != null) {
            return b.b().e(str, bVar, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return bVar.a(typeface);
    }

    public static int b(String str) {
        if (str == null) {
            return -1;
        }
        if ("italic".equals(str)) {
            return 2;
        }
        if (Constants.NORMAL.equals(str)) {
            return 0;
        }
        return -1;
    }

    public static String c(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            String string = readableArray.getString(i10);
            if (string != null) {
                char c10 = 65535;
                switch (string.hashCode()) {
                    case -1983120972:
                        if (string.equals("stylistic-thirteen")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1933522176:
                        if (string.equals("stylistic-fifteen")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1534462052:
                        if (string.equals("stylistic-eighteen")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -899039099:
                        if (string.equals("historical-ligatures")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -672279417:
                        if (string.equals("discretionary-ligatures")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case 249095901:
                        if (string.equals("no-contextual")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case 273808209:
                        if (string.equals("contextual")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case 289909490:
                        if (string.equals("no-common-ligatures")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case 296506098:
                        if (string.equals("stylistic-eight")) {
                            c10 = 12;
                            break;
                        }
                        break;
                    case 309330544:
                        if (string.equals("stylistic-seven")) {
                            c10 = 13;
                            break;
                        }
                        break;
                    case 310339585:
                        if (string.equals("stylistic-three")) {
                            c10 = 14;
                            break;
                        }
                        break;
                    case 604478526:
                        if (string.equals("stylistic-eleven")) {
                            c10 = 15;
                            break;
                        }
                        break;
                    case 915975441:
                        if (string.equals("no-historical-ligatures")) {
                            c10 = 16;
                            break;
                        }
                        break;
                    case 979426287:
                        if (string.equals("stylistic-five")) {
                            c10 = 17;
                            break;
                        }
                        break;
                    case 979432035:
                        if (string.equals("stylistic-four")) {
                            c10 = 18;
                            break;
                        }
                        break;
                    case 979664367:
                        if (string.equals("stylistic-nine")) {
                            c10 = 19;
                            break;
                        }
                        break;
                    case 1001434505:
                        if (string.equals("stylistic-one")) {
                            c10 = 20;
                            break;
                        }
                        break;
                    case 1001438213:
                        if (string.equals("stylistic-six")) {
                            c10 = 21;
                            break;
                        }
                        break;
                    case 1001439040:
                        if (string.equals("stylistic-ten")) {
                            c10 = 22;
                            break;
                        }
                        break;
                    case 1001439599:
                        if (string.equals("stylistic-two")) {
                            c10 = 23;
                            break;
                        }
                        break;
                    case 1030714463:
                        if (string.equals("stylistic-sixteen")) {
                            c10 = 24;
                            break;
                        }
                        break;
                    case 1044065430:
                        if (string.equals("stylistic-twelve")) {
                            c10 = 25;
                            break;
                        }
                        break;
                    case 1044067310:
                        if (string.equals("stylistic-twenty")) {
                            c10 = JSONLexer.EOI;
                            break;
                        }
                        break;
                    case 1082592379:
                        if (string.equals("no-discretionary-ligatures")) {
                            c10 = 27;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c10 = 28;
                            break;
                        }
                        break;
                    case 1223989350:
                        if (string.equals("common-ligatures")) {
                            c10 = 29;
                            break;
                        }
                        break;
                    case 1463562569:
                        if (string.equals("stylistic-nineteen")) {
                            c10 = 30;
                            break;
                        }
                        break;
                    case 1648446397:
                        if (string.equals("stylistic-fourteen")) {
                            c10 = 31;
                            break;
                        }
                        break;
                    case 2097122634:
                        if (string.equals("stylistic-seventeen")) {
                            c10 = ' ';
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        arrayList.add("'ss13'");
                        break;
                    case 1:
                        arrayList.add("'ss15'");
                        break;
                    case 2:
                        arrayList.add("'ss18'");
                        break;
                    case 3:
                        arrayList.add("'pnum'");
                        break;
                    case 4:
                        arrayList.add("'lnum'");
                        break;
                    case 5:
                        arrayList.add("'hlig'");
                        break;
                    case 6:
                        arrayList.add("'tnum'");
                        break;
                    case 7:
                        arrayList.add("'dlig'");
                        break;
                    case 8:
                        arrayList.add("'onum'");
                        break;
                    case 9:
                        arrayList.add("'calt' off");
                        break;
                    case 10:
                        arrayList.add("'calt'");
                        break;
                    case 11:
                        arrayList.add("'liga' off");
                        arrayList.add("'clig' off");
                        break;
                    case 12:
                        arrayList.add("'ss08'");
                        break;
                    case 13:
                        arrayList.add("'ss07'");
                        break;
                    case 14:
                        arrayList.add("'ss03'");
                        break;
                    case 15:
                        arrayList.add("'ss11'");
                        break;
                    case 16:
                        arrayList.add("'hlig' off");
                        break;
                    case 17:
                        arrayList.add("'ss05'");
                        break;
                    case 18:
                        arrayList.add("'ss04'");
                        break;
                    case 19:
                        arrayList.add("'ss09'");
                        break;
                    case 20:
                        arrayList.add("'ss01'");
                        break;
                    case 21:
                        arrayList.add("'ss06'");
                        break;
                    case 22:
                        arrayList.add("'ss10'");
                        break;
                    case 23:
                        arrayList.add("'ss02'");
                        break;
                    case 24:
                        arrayList.add("'ss16'");
                        break;
                    case 25:
                        arrayList.add("'ss12'");
                        break;
                    case 26:
                        arrayList.add("'ss20'");
                        break;
                    case 27:
                        arrayList.add("'dlig' off");
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                        arrayList.add("'smcp'");
                        break;
                    case 29:
                        arrayList.add("'liga'");
                        arrayList.add("'clig'");
                        break;
                    case 30:
                        arrayList.add("'ss19'");
                        break;
                    case 31:
                        arrayList.add("'ss14'");
                        break;
                    case ' ':
                        arrayList.add("'ss17'");
                        break;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int d(java.lang.String r2) {
        /*
            r0 = -1
            if (r2 == 0) goto L_0x00aa
            int r1 = r2.hashCode()
            switch(r1) {
                case -1039745817: goto L_0x0081;
                case 48625: goto L_0x0076;
                case 49586: goto L_0x006b;
                case 50547: goto L_0x0060;
                case 51508: goto L_0x0055;
                case 52469: goto L_0x004a;
                case 53430: goto L_0x003f;
                case 54391: goto L_0x0034;
                case 55352: goto L_0x0027;
                case 56313: goto L_0x001a;
                case 3029637: goto L_0x000d;
                default: goto L_0x000a;
            }
        L_0x000a:
            r2 = r0
            goto L_0x008b
        L_0x000d:
            java.lang.String r1 = "bold"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0016
            goto L_0x000a
        L_0x0016:
            r2 = 10
            goto L_0x008b
        L_0x001a:
            java.lang.String r1 = "900"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0023
            goto L_0x000a
        L_0x0023:
            r2 = 9
            goto L_0x008b
        L_0x0027:
            java.lang.String r1 = "800"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0030
            goto L_0x000a
        L_0x0030:
            r2 = 8
            goto L_0x008b
        L_0x0034:
            java.lang.String r1 = "700"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003d
            goto L_0x000a
        L_0x003d:
            r2 = 7
            goto L_0x008b
        L_0x003f:
            java.lang.String r1 = "600"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0048
            goto L_0x000a
        L_0x0048:
            r2 = 6
            goto L_0x008b
        L_0x004a:
            java.lang.String r1 = "500"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0053
            goto L_0x000a
        L_0x0053:
            r2 = 5
            goto L_0x008b
        L_0x0055:
            java.lang.String r1 = "400"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x005e
            goto L_0x000a
        L_0x005e:
            r2 = 4
            goto L_0x008b
        L_0x0060:
            java.lang.String r1 = "300"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0069
            goto L_0x000a
        L_0x0069:
            r2 = 3
            goto L_0x008b
        L_0x006b:
            java.lang.String r1 = "200"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0074
            goto L_0x000a
        L_0x0074:
            r2 = 2
            goto L_0x008b
        L_0x0076:
            java.lang.String r1 = "100"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x007f
            goto L_0x000a
        L_0x007f:
            r2 = 1
            goto L_0x008b
        L_0x0081:
            java.lang.String r1 = "normal"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x008a
            goto L_0x000a
        L_0x008a:
            r2 = 0
        L_0x008b:
            switch(r2) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a1;
                case 3: goto L_0x009e;
                case 4: goto L_0x00a7;
                case 5: goto L_0x009b;
                case 6: goto L_0x0098;
                case 7: goto L_0x0095;
                case 8: goto L_0x0092;
                case 9: goto L_0x008f;
                case 10: goto L_0x0095;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x00aa
        L_0x008f:
            r2 = 900(0x384, float:1.261E-42)
            return r2
        L_0x0092:
            r2 = 800(0x320, float:1.121E-42)
            return r2
        L_0x0095:
            r2 = 700(0x2bc, float:9.81E-43)
            return r2
        L_0x0098:
            r2 = 600(0x258, float:8.41E-43)
            return r2
        L_0x009b:
            r2 = 500(0x1f4, float:7.0E-43)
            return r2
        L_0x009e:
            r2 = 300(0x12c, float:4.2E-43)
            return r2
        L_0x00a1:
            r2 = 200(0xc8, float:2.8E-43)
            return r2
        L_0x00a4:
            r2 = 100
            return r2
        L_0x00a7:
            r2 = 400(0x190, float:5.6E-43)
            return r2
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.n.d(java.lang.String):int");
    }
}
