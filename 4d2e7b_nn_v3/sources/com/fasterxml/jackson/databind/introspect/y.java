package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class y {

    /* renamed from: c  reason: collision with root package name */
    static final Class[] f5436c = new Class[0];

    /* renamed from: a  reason: collision with root package name */
    final String f5437a;

    /* renamed from: b  reason: collision with root package name */
    final Class[] f5438b;

    public y(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public int a() {
        return this.f5438b.length;
    }

    public String b() {
        return this.f5437a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != y.class) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.f5437a.equals(yVar.f5437a)) {
            return false;
        }
        Class[] clsArr = yVar.f5438b;
        int length = this.f5438b.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (clsArr[i10] != this.f5438b[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f5437a.hashCode() + this.f5438b.length;
    }

    public String toString() {
        return this.f5437a + "(" + this.f5438b.length + "-args)";
    }

    public y(Constructor constructor) {
        this("", constructor.getParameterTypes());
    }

    public y(String str, Class[] clsArr) {
        this.f5437a = str;
        this.f5438b = clsArr == null ? f5436c : clsArr;
    }
}
