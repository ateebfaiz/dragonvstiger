package com.geetest.core;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class j3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f6041a = 0;

    public class a implements PrivilegedAction<String> {
        public Object run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            String str = (String) AccessController.doPrivileged(new a());
        } catch (Exception unused) {
            try {
                String.format("%n", new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return new String(cArr);
    }
}
