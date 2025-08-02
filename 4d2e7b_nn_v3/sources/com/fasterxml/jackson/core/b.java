package com.fasterxml.jackson.core;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5070a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f5071b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f5072c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f5073d;

    static {
        a aVar = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f5070a = aVar;
        f5071b = new a(aVar, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f5072c = new a(aVar, "PEM", true, '=', 64);
        StringBuilder sb2 = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb2.setCharAt(sb2.indexOf("+"), '-');
        sb2.setCharAt(sb2.indexOf(DomExceptionUtils.SEPARATOR), '_');
        f5073d = new a("MODIFIED-FOR-URL", sb2.toString(), false, 0, Integer.MAX_VALUE);
    }

    public static a a() {
        return f5071b;
    }

    public static a b(String str) {
        String str2;
        a aVar = f5070a;
        if (aVar.f5061d.equals(str)) {
            return aVar;
        }
        a aVar2 = f5071b;
        if (aVar2.f5061d.equals(str)) {
            return aVar2;
        }
        a aVar3 = f5072c;
        if (aVar3.f5061d.equals(str)) {
            return aVar3;
        }
        a aVar4 = f5073d;
        if (aVar4.f5061d.equals(str)) {
            return aVar4;
        }
        if (str == null) {
            str2 = "<null>";
        } else {
            str2 = "'" + str + "'";
        }
        throw new IllegalArgumentException("No Base64Variant with name " + str2);
    }
}
