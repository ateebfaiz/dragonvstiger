package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.q;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import l8.l;

public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    protected final l f5420a;

    /* renamed from: b  reason: collision with root package name */
    protected final c f5421b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5422c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f5423d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f5424e;

    /* renamed from: f  reason: collision with root package name */
    protected final String f5425f;

    public interface a {
    }

    public static class b extends a.C0071a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected final String f5426a;

        /* renamed from: b  reason: collision with root package name */
        protected final String f5427b;

        /* renamed from: c  reason: collision with root package name */
        protected final String f5428c;

        /* renamed from: d  reason: collision with root package name */
        protected final String f5429d;

        public b() {
            this("set", "with", "get", "is", (a) null);
        }

        public a a(l lVar, c cVar) {
            return new w(lVar, cVar, this.f5426a, this.f5428c, this.f5429d, (a) null);
        }

        public a b(l lVar, c cVar) {
            return new c(lVar, cVar);
        }

        protected b(String str, String str2, String str3, String str4, a aVar) {
            this.f5426a = str;
            this.f5427b = str2;
            this.f5428c = str3;
            this.f5429d = str4;
        }
    }

    public static class c extends w {

        /* renamed from: g  reason: collision with root package name */
        protected final Set f5430g = new HashSet();

        public c(l lVar, c cVar) {
            super(lVar, cVar, (String) null, "get", "is", (a) null);
            for (String add : p8.a.a(cVar.d())) {
                this.f5430g.add(add);
            }
        }

        public String c(j jVar, String str) {
            if (this.f5430g.contains(str)) {
                return str;
            }
            return w.super.c(jVar, str);
        }
    }

    protected w(l lVar, c cVar, String str, String str2, String str3, a aVar) {
        this.f5420a = lVar;
        this.f5421b = cVar;
        this.f5422c = lVar.F(q.USE_STD_BEAN_NAMING);
        this.f5425f = str;
        this.f5423d = str2;
        this.f5424e = str3;
    }

    public String a(j jVar, String str) {
        if (this.f5424e == null) {
            return null;
        }
        Class<Boolean> d10 = jVar.d();
        if ((d10 != Boolean.class && d10 != Boolean.TYPE) || !str.startsWith(this.f5424e)) {
            return null;
        }
        if (this.f5422c) {
            return h(str, 2);
        }
        return g(str, 2);
    }

    public String b(j jVar, String str) {
        String str2 = this.f5425f;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if (this.f5422c) {
            return h(str, this.f5425f.length());
        }
        return g(str, this.f5425f.length());
    }

    public String c(j jVar, String str) {
        String str2 = this.f5423d;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (e(jVar)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && f(jVar)) {
            return null;
        }
        if (this.f5422c) {
            return h(str, this.f5423d.length());
        }
        return g(str, this.f5423d.length());
    }

    public String d(g gVar, String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public boolean e(j jVar) {
        Class d10 = jVar.d();
        if (!d10.isArray()) {
            return false;
        }
        String name = d10.getComponentType().getName();
        if (!name.contains(".cglib")) {
            return false;
        }
        if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean f(j jVar) {
        return jVar.d().getName().startsWith("groovy.lang");
    }

    /* access modifiers changed from: protected */
    public String g(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        while (true) {
            i10++;
            if (i10 >= length) {
                break;
            }
            char charAt2 = str.charAt(i10);
            char lowerCase2 = Character.toLowerCase(charAt2);
            if (charAt2 == lowerCase2) {
                sb2.append(str, i10, length);
                break;
            }
            sb2.append(lowerCase2);
        }
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public String h(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        int i11 = i10 + 1;
        if (i11 < length && Character.isUpperCase(str.charAt(i11))) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        sb2.append(str, i11, length);
        return sb2.toString();
    }
}
