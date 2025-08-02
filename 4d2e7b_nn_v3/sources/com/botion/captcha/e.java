package com.botion.captcha;

import android.util.Base64;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

final class e {
    static byte[] a(byte[] bArr, String str) throws Exception {
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

    static byte[] a() {
        return k.a(new String(Base64.decode("MzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzA=", 0)));
    }

    static String a(String str) {
        return new String(Base64.decode(str, 0));
    }
}
