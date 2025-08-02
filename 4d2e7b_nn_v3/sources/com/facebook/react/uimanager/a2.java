package com.facebook.react.uimanager;

import java.util.Comparator;

public class a2 {

    /* renamed from: c  reason: collision with root package name */
    public static Comparator f3547c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f3548a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3549b;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(a2 a2Var, a2 a2Var2) {
            return a2Var.f3549b - a2Var2.f3549b;
        }
    }

    public a2(int i10, int i11) {
        this.f3548a = i10;
        this.f3549b = i11;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        a2 a2Var = (a2) obj;
        if (this.f3549b == a2Var.f3549b && this.f3548a == a2Var.f3548a) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[" + this.f3548a + ", " + this.f3549b + "]";
    }
}
