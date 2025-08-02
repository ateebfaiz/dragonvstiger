package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.a;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public final class p implements a {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap f5397a;

    public p() {
    }

    public static p e(p pVar, p pVar2) {
        HashMap hashMap;
        HashMap hashMap2;
        if (pVar == null || (hashMap = pVar.f5397a) == null || hashMap.isEmpty()) {
            return pVar2;
        }
        if (pVar2 == null || (hashMap2 = pVar2.f5397a) == null || hashMap2.isEmpty()) {
            return pVar;
        }
        HashMap hashMap3 = new HashMap();
        for (Annotation annotation : pVar2.f5397a.values()) {
            hashMap3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : pVar.f5397a.values()) {
            hashMap3.put(annotation2.annotationType(), annotation2);
        }
        return new p(hashMap3);
    }

    public static p f(Class cls, Annotation annotation) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(cls, annotation);
        return new p(hashMap);
    }

    public boolean a(Class cls) {
        HashMap hashMap = this.f5397a;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(cls);
    }

    public boolean b(Class[] clsArr) {
        if (this.f5397a != null) {
            for (Class containsKey : clsArr) {
                if (this.f5397a.containsKey(containsKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean c(Annotation annotation) {
        if (this.f5397a == null) {
            this.f5397a = new HashMap();
        }
        Annotation annotation2 = (Annotation) this.f5397a.put(annotation.annotationType(), annotation);
        if (annotation2 == null || !annotation2.equals(annotation)) {
            return true;
        }
        return false;
    }

    public boolean d(Annotation annotation) {
        return c(annotation);
    }

    public Annotation get(Class cls) {
        HashMap hashMap = this.f5397a;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    public int size() {
        HashMap hashMap = this.f5397a;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public String toString() {
        HashMap hashMap = this.f5397a;
        if (hashMap == null) {
            return "[null]";
        }
        return hashMap.toString();
    }

    p(HashMap hashMap) {
        this.f5397a = hashMap;
    }
}
