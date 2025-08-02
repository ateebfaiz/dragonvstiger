package com.onesignal;

import com.onesignal.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import na.a;

class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f10737a;

    public k1() {
        HashMap hashMap = new HashMap();
        this.f10737a = hashMap;
        hashMap.put(s.d.class.getName(), new s.d());
        hashMap.put(s.b.class.getName(), new s.b());
    }

    private s.c a() {
        return (s.c) this.f10737a.get(s.b.class.getName());
    }

    private s.c d() {
        return (s.c) this.f10737a.get(s.d.class.getName());
    }

    /* access modifiers changed from: package-private */
    public s.c b() {
        s.c a10 = a();
        for (a d10 : a10.j()) {
            if (d10.d().b()) {
                return a10;
            }
        }
        return d();
    }

    /* access modifiers changed from: package-private */
    public s.c c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).d().b()) {
                return a();
            }
        }
        return d();
    }
}
