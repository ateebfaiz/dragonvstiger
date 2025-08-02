package com.alibaba.pdns;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17954a = "SHA-256";

    /* renamed from: b  reason: collision with root package name */
    public static final String f17955b = "MD5";

    /* renamed from: c  reason: collision with root package name */
    public static final String f17956c = "SHA-1";

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        if (r3.equals("") != false) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3) {
        /*
            byte[] r2 = r2.getBytes()
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x000e
            boolean r1 = r3.equals(r0)     // Catch:{ Error | Exception | NoSuchAlgorithmException -> 0x0020 }
            if (r1 == 0) goto L_0x0010
        L_0x000e:
            java.lang.String r3 = "SHA-256"
        L_0x0010:
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Error | Exception | NoSuchAlgorithmException -> 0x0020 }
            r3.update(r2)     // Catch:{ Error | Exception | NoSuchAlgorithmException -> 0x0020 }
            byte[] r2 = r3.digest()     // Catch:{ Error | Exception | NoSuchAlgorithmException -> 0x0020 }
            java.lang.String r2 = a(r2)     // Catch:{ Error | Exception | NoSuchAlgorithmException -> 0x0020 }
            return r2
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.j.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }
}
