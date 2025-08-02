package com.hcaptcha.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.alibaba.pdns.j;
import com.fasterxml.jackson.databind.s;
import dalvik.system.DexFile;
import io.jsonwebtoken.JwtParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

final class d implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static String f9515b = "[]";

    /* renamed from: c  reason: collision with root package name */
    private static String f9516c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f9517a;

    public d(Context context) {
        if (context != null) {
            this.f9517a = context;
            return;
        }
        throw new NullPointerException("context is marked non-null but is null");
    }

    public List a(String str, String str2) {
        ArrayList arrayList = new ArrayList(512);
        MessageDigest instance = MessageDigest.getInstance(j.f17955b);
        MessageDigest instance2 = MessageDigest.getInstance(j.f17955b);
        MessageDigest instance3 = MessageDigest.getInstance(j.f17955b);
        DexFile dexFile = new DexFile(str2);
        try {
            Enumeration<String> entries = dexFile.entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (!nextElement.startsWith("com.google.android.")) {
                    if (!nextElement.startsWith("android.")) {
                        if (nextElement.startsWith(str)) {
                            instance2.update(nextElement.getBytes("UTF-8"));
                        } else {
                            instance3.update(nextElement.getBytes("UTF-8"));
                        }
                    }
                }
                instance.update(nextElement.getBytes("UTF-8"));
            }
            dexFile.close();
            arrayList.add("sys_".concat(String.format("%032x", new Object[]{new BigInteger(1, instance.digest())})));
            arrayList.add("deps_".concat(String.format("%032x", new Object[]{new BigInteger(1, instance3.digest())})));
            arrayList.add("app_".concat(String.format("%032x", new Object[]{new BigInteger(1, instance2.digest())})));
            arrayList.add("aver_" + Build.VERSION.RELEASE);
            arrayList.add("sdk_" + "4.1.2_47".replace(JwtParser.SEPARATOR_CHAR, '_'));
            return arrayList;
        } catch (Throwable th) {
            dexFile.close();
            throw th;
        }
    }

    public Context b() {
        return this.f9517a;
    }

    public Map c() {
        BufferedReader bufferedReader;
        int i10;
        HashMap hashMap = new HashMap();
        Process process = null;
        try {
            process = new ProcessBuilder(new String[]{"/system/bin/getprop"}).start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    process.destroy();
                    return hashMap;
                } else if (readLine.endsWith("]")) {
                    if (sb2.length() == 0) {
                        i10 = 0;
                    } else {
                        i10 = sb2.length() - 1;
                    }
                    sb2.replace(0, i10, readLine);
                    String[] split = sb2.toString().split("]: \\[");
                    String substring = split[0].substring(1);
                    if (substring.startsWith("ro")) {
                        String str = split[1];
                        hashMap.put(substring, str.substring(0, str.length() - 2));
                    }
                } else {
                    sb2.append(readLine);
                }
            }
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
        throw th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        Context b10 = b();
        Context b11 = ((d) obj).b();
        if (b10 != null ? b10.equals(b11) : b11 == null) {
            return true;
        }
        return false;
    }

    @JavascriptInterface
    public String getDebugInfo() {
        String str = f9515b;
        if (str != null) {
            return str;
        }
        synchronized (this) {
            String str2 = f9515b;
            if (str2 != null) {
                return str2;
            }
            try {
                String j10 = new s().j(a(this.f9517a.getPackageName(), this.f9517a.getPackageCodePath()));
                f9515b = j10;
                return j10;
            } catch (IOException | NoSuchAlgorithmException unused) {
                Log.d("JSDI", "Cannot build debugInfo");
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        }
    }

    @JavascriptInterface
    public String getSysDebug() {
        String str = f9516c;
        if (str != null) {
            return str;
        }
        synchronized (this) {
            String str2 = f9516c;
            if (str2 != null) {
                return str2;
            }
            try {
                String j10 = new s().j(c());
                f9516c = j10;
                return j10;
            } catch (IOException unused) {
                Log.d("JSDI", "Cannot build sysDebug");
                return "{}";
            }
        }
    }

    public int hashCode() {
        int i10;
        Context b10 = b();
        if (b10 == null) {
            i10 = 43;
        } else {
            i10 = b10.hashCode();
        }
        return i10 + 59;
    }

    public String toString() {
        return "HCaptchaDebugInfo(context=" + b() + ")";
    }
}
