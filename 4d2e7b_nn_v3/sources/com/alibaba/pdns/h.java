package com.alibaba.pdns;

import com.alibaba.pdns.model.f;
import com.alibaba.pdns.x.b;
import com.alibaba.pdns.x.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private b f17946a;

    class a implements Comparator<f> {
        a() {
        }

        public int compare(f fVar, f fVar2) {
            if (!(fVar == null || fVar2 == null)) {
                if (fVar.g() > fVar2.g()) {
                    return 1;
                }
                if (fVar.g() < fVar2.g()) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public h() {
        this.f17946a = null;
        this.f17946a = new c();
    }

    public void a(CopyOnWriteArrayList<f> copyOnWriteArrayList) {
        if (e.b(copyOnWriteArrayList)) {
            ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
            Collections.sort(arrayList, new a());
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                copyOnWriteArrayList.set(i10, arrayList.get(i10));
            }
        }
    }

    public CopyOnWriteArrayList<f> b(CopyOnWriteArrayList<f> copyOnWriteArrayList) {
        if (!e.b(copyOnWriteArrayList)) {
            return null;
        }
        return c(copyOnWriteArrayList);
    }

    public CopyOnWriteArrayList<f> c(CopyOnWriteArrayList<f> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 1) {
            a(copyOnWriteArrayList);
        }
        return copyOnWriteArrayList;
    }
}
