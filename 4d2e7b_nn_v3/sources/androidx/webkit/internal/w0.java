package androidx.webkit.internal;

import java.net.URLConnection;

abstract class w0 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        if (guessContentTypeFromName != null) {
            return guessContentTypeFromName;
        }
        return b(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b0, code lost:
        if (r5.equals("js") == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r5) {
        /*
            r0 = 1
            r1 = 46
            int r2 = r5.lastIndexOf(r1)
            r3 = -1
            r4 = 0
            if (r2 != r3) goto L_0x000c
            return r4
        L_0x000c:
            int r2 = r2 + r0
            java.lang.String r5 = r5.substring(r2)
            java.lang.String r5 = r5.toLowerCase()
            r5.hashCode()
            int r2 = r5.hashCode()
            switch(r2) {
                case 3315: goto L_0x02b4;
                case 3401: goto L_0x02aa;
                case 97669: goto L_0x029e;
                case 98819: goto L_0x0292;
                case 102340: goto L_0x0286;
                case 103649: goto L_0x027a;
                case 104085: goto L_0x026e;
                case 105441: goto L_0x0262;
                case 106458: goto L_0x0255;
                case 106479: goto L_0x0247;
                case 108089: goto L_0x0239;
                case 108150: goto L_0x022b;
                case 108272: goto L_0x021d;
                case 108273: goto L_0x020f;
                case 108324: goto L_0x0201;
                case 109961: goto L_0x01f3;
                case 109967: goto L_0x01e5;
                case 109973: goto L_0x01d7;
                case 109982: goto L_0x01c9;
                case 110834: goto L_0x01bb;
                case 111030: goto L_0x01ad;
                case 111145: goto L_0x019f;
                case 114276: goto L_0x0191;
                case 114791: goto L_0x0183;
                case 114833: goto L_0x0175;
                case 117484: goto L_0x0167;
                case 118660: goto L_0x0159;
                case 118807: goto L_0x014b;
                case 120609: goto L_0x013d;
                case 3000872: goto L_0x012f;
                case 3145576: goto L_0x0121;
                case 3213227: goto L_0x0113;
                case 3259225: goto L_0x0105;
                case 3268712: goto L_0x00f7;
                case 3271912: goto L_0x00e9;
                case 3358085: goto L_0x00db;
                case 3418175: goto L_0x00cd;
                case 3529614: goto L_0x00bf;
                case 3542678: goto L_0x00b1;
                case 3559925: goto L_0x00a3;
                case 3642020: goto L_0x0096;
                case 3645337: goto L_0x0089;
                case 3645340: goto L_0x007c;
                case 3655064: goto L_0x006f;
                case 3678569: goto L_0x0062;
                case 96488848: goto L_0x0055;
                case 103877016: goto L_0x0049;
                case 106703064: goto L_0x003c;
                case 109418142: goto L_0x002f;
                case 114035747: goto L_0x0022;
                default: goto L_0x001f;
            }
        L_0x001f:
            r0 = r3
            goto L_0x02bf
        L_0x0022:
            java.lang.String r0 = "xhtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x002b
            goto L_0x001f
        L_0x002b:
            r0 = 49
            goto L_0x02bf
        L_0x002f:
            java.lang.String r0 = "shtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0038
            goto L_0x001f
        L_0x0038:
            r0 = 48
            goto L_0x02bf
        L_0x003c:
            java.lang.String r0 = "pjpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0045
            goto L_0x001f
        L_0x0045:
            r0 = 47
            goto L_0x02bf
        L_0x0049:
            java.lang.String r0 = "mhtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0052
            goto L_0x001f
        L_0x0052:
            r0 = r1
            goto L_0x02bf
        L_0x0055:
            java.lang.String r0 = "ehtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x005e
            goto L_0x001f
        L_0x005e:
            r0 = 45
            goto L_0x02bf
        L_0x0062:
            java.lang.String r0 = "xhtm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x006b
            goto L_0x001f
        L_0x006b:
            r0 = 44
            goto L_0x02bf
        L_0x006f:
            java.lang.String r0 = "woff"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0078
            goto L_0x001f
        L_0x0078:
            r0 = 43
            goto L_0x02bf
        L_0x007c:
            java.lang.String r0 = "webp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0085
            goto L_0x001f
        L_0x0085:
            r0 = 42
            goto L_0x02bf
        L_0x0089:
            java.lang.String r0 = "webm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0092
            goto L_0x001f
        L_0x0092:
            r0 = 41
            goto L_0x02bf
        L_0x0096:
            java.lang.String r0 = "wasm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x009f
            goto L_0x001f
        L_0x009f:
            r0 = 40
            goto L_0x02bf
        L_0x00a3:
            java.lang.String r0 = "tiff"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00ad
            goto L_0x001f
        L_0x00ad:
            r0 = 39
            goto L_0x02bf
        L_0x00b1:
            java.lang.String r0 = "svgz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00bb
            goto L_0x001f
        L_0x00bb:
            r0 = 38
            goto L_0x02bf
        L_0x00bf:
            java.lang.String r0 = "shtm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00c9
            goto L_0x001f
        L_0x00c9:
            r0 = 37
            goto L_0x02bf
        L_0x00cd:
            java.lang.String r0 = "opus"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00d7
            goto L_0x001f
        L_0x00d7:
            r0 = 36
            goto L_0x02bf
        L_0x00db:
            java.lang.String r0 = "mpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00e5
            goto L_0x001f
        L_0x00e5:
            r0 = 35
            goto L_0x02bf
        L_0x00e9:
            java.lang.String r0 = "json"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00f3
            goto L_0x001f
        L_0x00f3:
            r0 = 34
            goto L_0x02bf
        L_0x00f7:
            java.lang.String r0 = "jpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0101
            goto L_0x001f
        L_0x0101:
            r0 = 33
            goto L_0x02bf
        L_0x0105:
            java.lang.String r0 = "jfif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x010f
            goto L_0x001f
        L_0x010f:
            r0 = 32
            goto L_0x02bf
        L_0x0113:
            java.lang.String r0 = "html"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x011d
            goto L_0x001f
        L_0x011d:
            r0 = 31
            goto L_0x02bf
        L_0x0121:
            java.lang.String r0 = "flac"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x012b
            goto L_0x001f
        L_0x012b:
            r0 = 30
            goto L_0x02bf
        L_0x012f:
            java.lang.String r0 = "apng"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0139
            goto L_0x001f
        L_0x0139:
            r0 = 29
            goto L_0x02bf
        L_0x013d:
            java.lang.String r0 = "zip"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0147
            goto L_0x001f
        L_0x0147:
            r0 = 28
            goto L_0x02bf
        L_0x014b:
            java.lang.String r0 = "xml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0155
            goto L_0x001f
        L_0x0155:
            r0 = 27
            goto L_0x02bf
        L_0x0159:
            java.lang.String r0 = "xht"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0163
            goto L_0x001f
        L_0x0163:
            r0 = 26
            goto L_0x02bf
        L_0x0167:
            java.lang.String r0 = "wav"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0171
            goto L_0x001f
        L_0x0171:
            r0 = 25
            goto L_0x02bf
        L_0x0175:
            java.lang.String r0 = "tif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x017f
            goto L_0x001f
        L_0x017f:
            r0 = 24
            goto L_0x02bf
        L_0x0183:
            java.lang.String r0 = "tgz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x018d
            goto L_0x001f
        L_0x018d:
            r0 = 23
            goto L_0x02bf
        L_0x0191:
            java.lang.String r0 = "svg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x019b
            goto L_0x001f
        L_0x019b:
            r0 = 22
            goto L_0x02bf
        L_0x019f:
            java.lang.String r0 = "png"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01a9
            goto L_0x001f
        L_0x01a9:
            r0 = 21
            goto L_0x02bf
        L_0x01ad:
            java.lang.String r0 = "pjp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01b7
            goto L_0x001f
        L_0x01b7:
            r0 = 20
            goto L_0x02bf
        L_0x01bb:
            java.lang.String r0 = "pdf"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01c5
            goto L_0x001f
        L_0x01c5:
            r0 = 19
            goto L_0x02bf
        L_0x01c9:
            java.lang.String r0 = "ogv"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01d3
            goto L_0x001f
        L_0x01d3:
            r0 = 18
            goto L_0x02bf
        L_0x01d7:
            java.lang.String r0 = "ogm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01e1
            goto L_0x001f
        L_0x01e1:
            r0 = 17
            goto L_0x02bf
        L_0x01e5:
            java.lang.String r0 = "ogg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01ef
            goto L_0x001f
        L_0x01ef:
            r0 = 16
            goto L_0x02bf
        L_0x01f3:
            java.lang.String r0 = "oga"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01fd
            goto L_0x001f
        L_0x01fd:
            r0 = 15
            goto L_0x02bf
        L_0x0201:
            java.lang.String r0 = "mpg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x020b
            goto L_0x001f
        L_0x020b:
            r0 = 14
            goto L_0x02bf
        L_0x020f:
            java.lang.String r0 = "mp4"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0219
            goto L_0x001f
        L_0x0219:
            r0 = 13
            goto L_0x02bf
        L_0x021d:
            java.lang.String r0 = "mp3"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0227
            goto L_0x001f
        L_0x0227:
            r0 = 12
            goto L_0x02bf
        L_0x022b:
            java.lang.String r0 = "mjs"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0235
            goto L_0x001f
        L_0x0235:
            r0 = 11
            goto L_0x02bf
        L_0x0239:
            java.lang.String r0 = "mht"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0243
            goto L_0x001f
        L_0x0243:
            r0 = 10
            goto L_0x02bf
        L_0x0247:
            java.lang.String r0 = "m4v"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0251
            goto L_0x001f
        L_0x0251:
            r0 = 9
            goto L_0x02bf
        L_0x0255:
            java.lang.String r0 = "m4a"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x025f
            goto L_0x001f
        L_0x025f:
            r0 = 8
            goto L_0x02bf
        L_0x0262:
            java.lang.String r0 = "jpg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x026c
            goto L_0x001f
        L_0x026c:
            r0 = 7
            goto L_0x02bf
        L_0x026e:
            java.lang.String r0 = "ico"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0278
            goto L_0x001f
        L_0x0278:
            r0 = 6
            goto L_0x02bf
        L_0x027a:
            java.lang.String r0 = "htm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0284
            goto L_0x001f
        L_0x0284:
            r0 = 5
            goto L_0x02bf
        L_0x0286:
            java.lang.String r0 = "gif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0290
            goto L_0x001f
        L_0x0290:
            r0 = 4
            goto L_0x02bf
        L_0x0292:
            java.lang.String r0 = "css"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x029c
            goto L_0x001f
        L_0x029c:
            r0 = 3
            goto L_0x02bf
        L_0x029e:
            java.lang.String r0 = "bmp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02a8
            goto L_0x001f
        L_0x02a8:
            r0 = 2
            goto L_0x02bf
        L_0x02aa:
            java.lang.String r1 = "js"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x02bf
            goto L_0x001f
        L_0x02b4:
            java.lang.String r0 = "gz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02be
            goto L_0x001f
        L_0x02be:
            r0 = 0
        L_0x02bf:
            switch(r0) {
                case 0: goto L_0x031a;
                case 1: goto L_0x0317;
                case 2: goto L_0x0314;
                case 3: goto L_0x0311;
                case 4: goto L_0x030e;
                case 5: goto L_0x030b;
                case 6: goto L_0x0308;
                case 7: goto L_0x0305;
                case 8: goto L_0x0302;
                case 9: goto L_0x02ff;
                case 10: goto L_0x02fc;
                case 11: goto L_0x0317;
                case 12: goto L_0x02f9;
                case 13: goto L_0x02ff;
                case 14: goto L_0x02f6;
                case 15: goto L_0x02f3;
                case 16: goto L_0x02f3;
                case 17: goto L_0x02f0;
                case 18: goto L_0x02f0;
                case 19: goto L_0x02ed;
                case 20: goto L_0x0305;
                case 21: goto L_0x02ea;
                case 22: goto L_0x02e7;
                case 23: goto L_0x031a;
                case 24: goto L_0x02e4;
                case 25: goto L_0x02e1;
                case 26: goto L_0x02de;
                case 27: goto L_0x02db;
                case 28: goto L_0x02d8;
                case 29: goto L_0x02d5;
                case 30: goto L_0x02d2;
                case 31: goto L_0x030b;
                case 32: goto L_0x0305;
                case 33: goto L_0x0305;
                case 34: goto L_0x02cf;
                case 35: goto L_0x02f6;
                case 36: goto L_0x02f3;
                case 37: goto L_0x030b;
                case 38: goto L_0x02e7;
                case 39: goto L_0x02e4;
                case 40: goto L_0x02cc;
                case 41: goto L_0x02c9;
                case 42: goto L_0x02c6;
                case 43: goto L_0x02c3;
                case 44: goto L_0x02de;
                case 45: goto L_0x030b;
                case 46: goto L_0x02fc;
                case 47: goto L_0x0305;
                case 48: goto L_0x030b;
                case 49: goto L_0x02de;
                default: goto L_0x02c2;
            }
        L_0x02c2:
            return r4
        L_0x02c3:
            java.lang.String r5 = "application/font-woff"
            return r5
        L_0x02c6:
            java.lang.String r5 = "image/webp"
            return r5
        L_0x02c9:
            java.lang.String r5 = "video/webm"
            return r5
        L_0x02cc:
            java.lang.String r5 = "application/wasm"
            return r5
        L_0x02cf:
            java.lang.String r5 = "application/json"
            return r5
        L_0x02d2:
            java.lang.String r5 = "audio/flac"
            return r5
        L_0x02d5:
            java.lang.String r5 = "image/apng"
            return r5
        L_0x02d8:
            java.lang.String r5 = "application/zip"
            return r5
        L_0x02db:
            java.lang.String r5 = "text/xml"
            return r5
        L_0x02de:
            java.lang.String r5 = "application/xhtml+xml"
            return r5
        L_0x02e1:
            java.lang.String r5 = "audio/wav"
            return r5
        L_0x02e4:
            java.lang.String r5 = "image/tiff"
            return r5
        L_0x02e7:
            java.lang.String r5 = "image/svg+xml"
            return r5
        L_0x02ea:
            java.lang.String r5 = "image/png"
            return r5
        L_0x02ed:
            java.lang.String r5 = "application/pdf"
            return r5
        L_0x02f0:
            java.lang.String r5 = "video/ogg"
            return r5
        L_0x02f3:
            java.lang.String r5 = "audio/ogg"
            return r5
        L_0x02f6:
            java.lang.String r5 = "video/mpeg"
            return r5
        L_0x02f9:
            java.lang.String r5 = "audio/mpeg"
            return r5
        L_0x02fc:
            java.lang.String r5 = "multipart/related"
            return r5
        L_0x02ff:
            java.lang.String r5 = "video/mp4"
            return r5
        L_0x0302:
            java.lang.String r5 = "audio/x-m4a"
            return r5
        L_0x0305:
            java.lang.String r5 = "image/jpeg"
            return r5
        L_0x0308:
            java.lang.String r5 = "image/x-icon"
            return r5
        L_0x030b:
            java.lang.String r5 = "text/html"
            return r5
        L_0x030e:
            java.lang.String r5 = "image/gif"
            return r5
        L_0x0311:
            java.lang.String r5 = "text/css"
            return r5
        L_0x0314:
            java.lang.String r5 = "image/bmp"
            return r5
        L_0x0317:
            java.lang.String r5 = "text/javascript"
            return r5
        L_0x031a:
            java.lang.String r5 = "application/gzip"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.webkit.internal.w0.b(java.lang.String):java.lang.String");
    }
}
