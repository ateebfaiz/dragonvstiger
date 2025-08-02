package com.facebook.react.views.image;

import android.graphics.Bitmap;
import c3.a;
import java.util.LinkedList;
import java.util.List;
import k5.d;
import r2.f;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final List f4021a;

    private e(List list) {
        this.f4021a = new LinkedList(list);
    }

    public static d c(List list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        if (size != 1) {
            return new e(list);
        }
        return (d) list.get(0);
    }

    public a a(Bitmap bitmap, w4.d dVar) {
        Bitmap bitmap2;
        a aVar = null;
        try {
            a aVar2 = null;
            for (d dVar2 : this.f4021a) {
                if (aVar2 != null) {
                    bitmap2 = (Bitmap) aVar2.p();
                } else {
                    bitmap2 = bitmap;
                }
                aVar = dVar2.a(bitmap2, dVar);
                a.m(aVar2);
                aVar2 = aVar.b();
            }
            a b10 = aVar.b();
            a.m(aVar);
            return b10;
        } catch (Throwable th) {
            a.m((a) null);
            throw th;
        }
    }

    public r2.d b() {
        LinkedList linkedList = new LinkedList();
        for (d b10 : this.f4021a) {
            linkedList.push(b10.b());
        }
        return new f(linkedList);
    }

    public String getName() {
        StringBuilder sb2 = new StringBuilder();
        for (d dVar : this.f4021a) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(dVar.getName());
        }
        sb2.insert(0, "MultiPostProcessor (");
        sb2.append(")");
        return sb2.toString();
    }
}
