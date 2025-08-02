package com.alibaba.pdns;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17963a = 8;

    /* renamed from: b  reason: collision with root package name */
    private static final int f17964b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static final int f17965c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f17966d = 4;

    public static String a(String str) {
        String str2;
        String str3;
        String str4 = str;
        int indexOf = str4.indexOf(f.G);
        int indexOf2 = str4.indexOf(":");
        int indexOf3 = str4.indexOf("::");
        String replace = str4.replace(f.G, "&").replace(":", "&");
        if (indexOf == -1 || indexOf2 != -1) {
            str2 = "";
        } else {
            String[] split = replace.split("&");
            str2 = "";
            for (int i10 = 0; i10 < 6; i10++) {
                if (i10 == 5) {
                    str3 = str2 + "ff9b";
                } else {
                    str3 = str2 + "0000";
                }
                str2 = str3;
            }
            int i11 = 0;
            for (int i12 = 4; i11 < i12; i12 = 4) {
                split[i11] = Integer.toHexString(Integer.parseInt(split[i11]));
                for (int i13 = 0; i13 < 2 - split[i11].length(); i13++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + split[i11];
                i11++;
            }
        }
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf3 != -1)) {
            String[] split2 = replace.split("&");
            for (int i14 = 0; i14 < 6; i14++) {
                for (int i15 = 0; i15 < 4 - split2[i14].length(); i15++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + split2[i14];
            }
            for (int i16 = 0; i16 < 4; i16++) {
                split2[i16] = Integer.toHexString(Integer.parseInt(split2[i16]));
                for (int i17 = 0; i17 < 2 - split2[i16].length(); i17++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + split2[i16];
            }
        }
        if (!(indexOf3 == -1 || indexOf == -1)) {
            String[] split3 = replace.split("&");
            String[] strArr = new String[10];
            if ("".equals(split3[0])) {
                int i18 = 0;
                for (int i19 = 0; i19 < 10 - (split3.length - 2); i19++) {
                    strArr[i19] = "0000";
                    i18++;
                }
                for (int i20 = 2; i20 < split3.length; i20++) {
                    strArr[i18] = split3[i20];
                    i18++;
                }
            } else {
                int i21 = 0;
                for (int i22 = 0; i22 < split3.length; i22++) {
                    if ("".equals(split3[i22])) {
                        for (int i23 = 0; i23 < 11 - split3.length; i23++) {
                            strArr[i21] = "0000";
                            i21++;
                        }
                    } else {
                        strArr[i21] = split3[i22];
                        i21++;
                    }
                }
            }
            int i24 = 0;
            for (int i25 = 0; i25 < 6; i25++) {
                for (int i26 = 0; i26 < 4 - strArr[i25].length(); i26++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + strArr[i25];
                i24++;
            }
            int i27 = 0;
            for (int i28 = 4; i27 < i28; i28 = 4) {
                strArr[i24] = Integer.toHexString(Integer.parseInt(strArr[i24]));
                for (int i29 = 0; i29 < 2 - strArr[i24].length(); i29++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + strArr[i24];
                i24++;
                i27++;
            }
        }
        if (indexOf3 == -1 && indexOf == -1 && indexOf2 != -1) {
            String[] split4 = replace.split("&");
            for (int i30 = 0; i30 < 8; i30++) {
                for (int i31 = 0; i31 < 4 - split4[i30].length(); i31++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + split4[i30];
            }
        }
        if (indexOf3 != -1 && indexOf == -1) {
            String[] split5 = replace.split("&");
            String[] strArr2 = new String[8];
            if ("".equals(split5[0])) {
                int i32 = 0;
                for (int i33 = 0; i33 < 8 - (split5.length - 2); i33++) {
                    strArr2[i33] = "0000";
                    i32++;
                }
                for (int i34 = 2; i34 < split5.length; i34 += 2) {
                    strArr2[i32] = split5[i34];
                    i32++;
                }
            } else {
                int i35 = 0;
                for (int i36 = 0; i36 < split5.length; i36++) {
                    if ("".equals(split5[i36])) {
                        for (int i37 = 0; i37 < 9 - split5.length; i37++) {
                            strArr2[i35] = "0000";
                            i35++;
                        }
                    } else {
                        strArr2[i35] = split5[i36];
                        i35++;
                    }
                }
            }
            for (int i38 = 0; i38 < 8; i38++) {
                for (int i39 = 0; i39 < 4 - strArr2[i38].length(); i39++) {
                    str2 = str2 + "0";
                }
                str2 = str2 + strArr2[i38];
            }
        }
        return str2;
    }

    public static String b(String str) {
        String str2 = "";
        String trim = str.substring(0, 24).replace("0000", str2).trim();
        if (!str2.equals(trim) && !"FFFF".equals(trim)) {
            String str3 = str2;
            while (!str2.equals(str)) {
                String substring = str.substring(0, 4);
                str = str.substring(4);
                if (str2.equals(str3)) {
                    str3 = substring;
                } else {
                    str3 = str3 + ":" + substring;
                }
            }
            str2 = str3.replaceFirst("(^|:)(0+(:|$)){2,8}", "64:");
        }
        return "[" + str2.replace("64:ff9b", "64:ff9b:") + "]";
    }

    public static byte[] c(String str) {
        String[] split = b(a(str)).split(":");
        String[] strArr = new String[16];
        byte[] bArr = new byte[16];
        int i10 = 0;
        for (int i11 = 0; i11 < split.length; i11++) {
            strArr[i10] = split[i11].substring(0, 2);
            strArr[i10 + 1] = split[i11].substring(2, 4);
            i10 += 2;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            bArr[i12] = (byte) Integer.parseInt(strArr[i12], 16);
        }
        return bArr;
    }
}
