package com.alibaba.pdns.w;

import android.text.TextUtils;
import com.alibaba.pdns.model.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class b implements a {

    class a implements Comparator<c> {
        a() {
        }

        public int compare(c cVar, c cVar2) {
            if (!(cVar == null || cVar2 == null)) {
                float f10 = cVar.f18020j;
                float f11 = cVar2.f18020j;
                if (f10 > f11) {
                    return 1;
                }
                if (f10 < f11) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public void a(com.alibaba.pdns.model.a aVar) {
        if (aVar.f17988n.size() > 1) {
            b(aVar.f17988n);
        }
    }

    public void b(CopyOnWriteArrayList<c> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
            Collections.sort(arrayList, new a());
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                copyOnWriteArrayList.set(i10, arrayList.get(i10));
            }
        }
    }

    public String[] a(CopyOnWriteArrayList<c> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (int i10 = 0; i10 < copyOnWriteArrayList.size(); i10++) {
            if (copyOnWriteArrayList.get(i10) != null) {
                String str = copyOnWriteArrayList.get(i10).f18015e;
                if (!TextUtils.isEmpty(str)) {
                    copyOnWriteArrayList2.add(str);
                }
            }
        }
        return (String[]) copyOnWriteArrayList2.toArray(new String[0]);
    }
}
