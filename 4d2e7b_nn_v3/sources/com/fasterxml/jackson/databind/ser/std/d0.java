package com.fasterxml.jackson.databind.ser.std;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public abstract class d0 {

    public static class a extends g0 {
    }

    public static class b extends g0 {
    }

    public static class c extends g0 {
    }

    public static Collection a() {
        HashMap hashMap = new HashMap();
        Class<URL> cls = URL.class;
        hashMap.put(cls, new l0(cls));
        Class<URI> cls2 = URI.class;
        hashMap.put(cls2, new l0(cls2));
        Class<Currency> cls3 = Currency.class;
        hashMap.put(cls3, new l0(cls3));
        hashMap.put(UUID.class, new o0());
        Class<Pattern> cls4 = Pattern.class;
        hashMap.put(cls4, new l0(cls4));
        Class<Locale> cls5 = Locale.class;
        hashMap.put(cls5, new l0(cls5));
        hashMap.put(AtomicBoolean.class, a.class);
        hashMap.put(AtomicInteger.class, b.class);
        hashMap.put(AtomicLong.class, c.class);
        hashMap.put(File.class, o.class);
        hashMap.put(Class.class, i.class);
        u uVar = u.f5585c;
        hashMap.put(Void.class, uVar);
        hashMap.put(Void.TYPE, uVar);
        return hashMap.entrySet();
    }
}
