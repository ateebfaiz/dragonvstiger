package com.alibaba.pdns.jni;

public final class a {
    static {
        try {
            System.loadLibrary("alipdns");
        } catch (Throwable th) {
            if (com.alibaba.pdns.u.a.f18279a) {
                th.printStackTrace();
            }
        }
    }

    public static int a() {
        try {
            return Jni.getNetworkStack();
        } catch (Throwable th) {
            if (!com.alibaba.pdns.u.a.f18279a) {
                return 0;
            }
            th.printStackTrace();
            return 0;
        }
    }
}
