package com.alibaba.pdns.x;

import com.alibaba.pdns.x.d.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class c implements b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18288b = "c";

    /* renamed from: c  reason: collision with root package name */
    public static final float f18289c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public static final int f18290d = 9999;

    /* renamed from: e  reason: collision with root package name */
    public static final int f18291e = 10000000;

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f18292a;

    public c() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f18292a = copyOnWriteArrayList;
        copyOnWriteArrayList.add(new b());
    }

    public float a(String str, int i10) {
        Iterator<a> it = this.f18292a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                float a10 = next.a(str, i10);
                if (a10 > -1.0f) {
                    return a10;
                }
            }
        }
        return -1.0f;
    }

    public float b(String str, int i10) {
        Iterator<a> it = this.f18292a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                float a10 = next.a(str, i10);
                if (a10 > -1.0f) {
                    return a10;
                }
            }
        }
        return -1.0f;
    }
}
