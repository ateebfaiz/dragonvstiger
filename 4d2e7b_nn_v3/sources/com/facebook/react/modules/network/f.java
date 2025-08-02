package com.facebook.react.modules.network;

abstract class f {
    public static String a(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        int length = str.length();
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= ' ' || charAt >= 127) {
                z10 = true;
            } else {
                sb2.append(charAt);
            }
        }
        if (z10) {
            return sb2.toString();
        }
        return str;
    }
}
