package com.geetest.captcha;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

public final class i {
    public static void a(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("gt_fp", 0).edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || "$unknown".equals(str)) {
            return true;
        }
        return false;
    }

    public static byte[] a(String str, String str2) throws Exception {
        String str3 = new String(a());
        Object bytes = str.getBytes("utf-8");
        Object bytes2 = str2.getBytes("utf-8");
        Object bytes3 = str3.getBytes("utf-8");
        Class cls = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{bytes3});
        Class cls2 = String.class;
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bytes2, "AES"});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{"AES/CBC/PKCS5Padding"});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{1, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bytes});
    }

    public static String a(Context context, String str) {
        String str2;
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bytes);
            byte[] digest = instance.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < digest.length; i10++) {
                char[] cArr = m.f5842a;
                sb2.append(cArr[(digest[i10] >> 4) & 15]);
                sb2.append(cArr[digest[i10] & 15]);
            }
            str2 = sb2.toString();
        } catch (Exception unused) {
            str2 = null;
        }
        if (b(str2)) {
            return null;
        }
        a(context, "gt_fp", str2);
        return str2;
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        Object bytes = str.getBytes("utf-8");
        Object a10 = a();
        Class cls = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{a10});
        Class cls2 = String.class;
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bytes, "AES"});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{"AES/CBC/PKCS5Padding"});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{2, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bArr});
    }

    public static byte[] a() {
        char[] charArray = new String(Base64.decode("MzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzA=", 0)).toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int digit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i10] = (byte) digit;
        }
        return bArr;
    }

    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }
}
