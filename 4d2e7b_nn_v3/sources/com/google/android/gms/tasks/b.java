package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

final class b implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f7828a;

    b(Collection collection) {
        this.f7828a = collection;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) {
        ArrayList arrayList = new ArrayList();
        for (Task result : this.f7828a) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
