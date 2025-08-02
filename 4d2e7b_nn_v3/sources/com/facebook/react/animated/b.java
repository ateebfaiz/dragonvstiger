package com.facebook.react.animated;

import java.util.ArrayList;
import java.util.List;
import p5.a;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    List f2775a;

    /* renamed from: b  reason: collision with root package name */
    int f2776b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2777c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f2778d = -1;

    b() {
    }

    public final void b(b bVar) {
        if (this.f2775a == null) {
            this.f2775a = new ArrayList(1);
        }
        ((List) a.c(this.f2775a)).add(bVar);
        bVar.c(this);
    }

    public void c(b bVar) {
    }

    public void d(b bVar) {
    }

    public abstract String e();

    public String f() {
        String str;
        List list = this.f2775a;
        String str2 = "";
        if (list == null || list.size() <= 0) {
            str = str2;
        } else {
            str = str2;
            for (b bVar : this.f2775a) {
                str = str + " " + bVar.f2778d;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(e());
        if (str.length() > 0) {
            str2 = " children: " + str;
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public final void g(b bVar) {
        if (this.f2775a != null) {
            bVar.d(this);
            this.f2775a.remove(bVar);
        }
    }

    public void h() {
    }
}
