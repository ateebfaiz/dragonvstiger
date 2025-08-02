package com.alibaba.pdns.x.d;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class a extends com.alibaba.pdns.x.a {

    /* renamed from: com.alibaba.pdns.x.d.a$a  reason: collision with other inner class name */
    public static class C0236a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f18293a = "bytes from ";

        private static boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.indexOf(f18293a) <= 0) {
                return false;
            }
            return true;
        }

        public static float b(String str) throws Exception {
            Runtime runtime = Runtime.getRuntime();
            String trim = str.trim();
            long currentTimeMillis = System.currentTimeMillis();
            Process exec = runtime.exec(trim);
            exec.waitFor();
            long currentTimeMillis2 = System.currentTimeMillis();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            bufferedReader.close();
            if (a(sb2.toString().toLowerCase().trim())) {
                return (float) ((int) (currentTimeMillis2 - currentTimeMillis));
            }
            return -1.0f;
        }
    }

    public float a(String str, int i10) {
        try {
            return C0236a.b("ping -c1 -s1 -w1 " + str);
        } catch (Error | Exception e10) {
            if (!com.alibaba.pdns.u.a.f18279a) {
                return -1.0f;
            }
            e10.printStackTrace();
            return -1.0f;
        }
    }
}
