package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

public abstract class b {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f5665a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5666b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f5667c;

        a(Class cls, int i10, Object obj) {
            this.f5665a = cls;
            this.f5666b = i10;
            this.f5667c = obj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!f.D(obj, this.f5665a) || Array.getLength(obj) != this.f5666b) {
                return false;
            }
            for (int i10 = 0; i10 < this.f5666b; i10++) {
                Object obj2 = Array.get(this.f5667c, i10);
                Object obj3 = Array.get(obj, i10);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Object a(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }
}
